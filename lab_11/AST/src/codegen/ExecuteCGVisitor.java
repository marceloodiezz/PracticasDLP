package codegen;

import ast.definition.*;
import ast.expression.*;
import ast.program.Program;
import ast.statement.*;
import ast.type.*;

import java.util.ArrayList;
import java.util.List;

public class ExecuteCGVisitor extends AbstractCGVisitor<Void, Void> {

    private final AddressCGVisitor addressCGVisitor;
    private final ValueCGVisitor valueCGVisitor;

    public ExecuteCGVisitor(CodeGenerator codeGenerator) {
        super(codeGenerator);

        this.addressCGVisitor = new AddressCGVisitor(codeGenerator);
        this.valueCGVisitor = new ValueCGVisitor(codeGenerator);
        this.addressCGVisitor.setValueCGVisitor(valueCGVisitor);
        this.valueCGVisitor.setAddressCGVisitor(addressCGVisitor);
    }

    /**
     * execute[[ Assignment: stmt -> expr1 expr2 ]]() =
     *     address[[expr1]]()
     *     value[[expr2]]()
     *     cg.convertTo(expr2.type, expr1.type)
     *     <store> expr1.type.suffix()
     */
    @Override
    public Void visit(Assignment a, Void param){
        getCodeGenerator().commentLine(a.getLine());
        getCodeGenerator().comment("Assignment");

        a.getLeft().accept(addressCGVisitor, null);
        a.getRight().accept(valueCGVisitor, null);
        getCodeGenerator().convertTo(a.getRight().getType(), a.getLeft().getType());
        getCodeGenerator().store(a.getLeft().getType());
        return null;
    }

    /**
     * execute[[ Input: stmt -> expr ]]() =
     *     <#line> expr.line
     *     <' * Read>
     *     address[[expr]]()
     *     <in> expr.type.suffix()
     *     <store> expr.type.suffix()
     */
    @Override
    public Void visit(Input i, Void param){
        getCodeGenerator().commentLine(i.getLine());
        getCodeGenerator().comment("Read");
        i.getTarget().accept(addressCGVisitor, null);
        getCodeGenerator().in(i.getTarget().getType());
        getCodeGenerator().store(i.getTarget().getType());
        return null;
    }

    /**
     * execute [[ Log: stmt -> expr ]]() =
     *     <#line> expr.line
     *     <' * Write>
     *     value[[expr]]()
     *     <out> expr.type.suffix()
     */
    @Override
    public Void visit(Log l, Void param){
        getCodeGenerator().commentLine(l.getExpr().getLine());
        getCodeGenerator().comment("Write");
        l.getExpr().accept(valueCGVisitor, null);
        getCodeGenerator().out(l.getExpr().getType());
        return null;
    }

    /**
     * execute[[ FuncDef: definition -> ID type stmt* ]]() =
     *     ID <:>
     *     <' * Parametros: >
     *     for (VarDef vd : type.getParams())
     *         execute[[vd]]()
     *     <' * Variables Locales: >
     *     for (Statement stmt : stmt*)
     *         if (stmt instanceof VarDef) {
     *             definitions*.add(stmt)
     *             execute[[stmt]]()
     *         }
     *     if (definitions*.isEmpty())
     *         definition.bytesLocalSum = 0;
     *     else {
     *         VarDef ultimaVarDef = definitions*.get(definitions.size() - 1)
     *         definition.bytesLocalSum = -1 * ultimaVarDef.offset
     *     }
     *     <enter> definition.bytesLocalSum
     *     for (Statement stmt : stmt*) {
     *         if (!(stmt instanceof VarDef))
     *             execute[[stmt]]()
     *     }
     *     <ret> 0, definition.bytesLocalSum, 0
     */
    @Override
    public Void visit(FuncDef f, Void param){
        getCodeGenerator().commentLine(f.getLine());
        getCodeGenerator().printFunction(f.getName());
        getCodeGenerator().comment("Parameters:");

        for (VarDef def: ((FuncType) f.getType()).getParams())
            def.accept(this, null);

        getCodeGenerator().comment("Local Variables:");
        List<VarDef> definitionList = new ArrayList<>();
        for (Statement st: f.getBody())
            if (st instanceof VarDef) {
                st.accept(this, null);
                definitionList.add((VarDef) st);
            }

        if (definitionList.isEmpty())
            f.setBytesLocalSum(0);
        else {
            VarDef ultimaDef = definitionList.getLast();
            f.setBytesLocalSum(-1 * ultimaDef.getOffset());
        }

        getCodeGenerator().enter(f.getBytesLocalSum());
        for (Statement st: f.getBody())
            if (!(st instanceof VarDef))
                st.accept(this, null);

        getCodeGenerator().ret(0, f.getBytesLocalSum(), 0);
        return null;
    }

    /**
     * execute [[ VarDef: definition -> ID type ]]() =
     *     <' *> type.toString() ID <(offset> definition.offset() <)>
     */
    @Override
    public Void visit(VarDef v, Void param){
        getCodeGenerator().comment(v.getType() + " " + v.getName() + " (offset " + v.getOffset() + ")");
        return null;
    }

    /**
     * execute[[ Program: program -> def* ]]() =
     *     for(Definition d : def*)
     *         if (d instanceof VarDef)
     *             execute[[d]]()
     *     cg.mainInvocation() // <call main> y <halt>
     *     for(Definition d : def*)
     *         if (d instanceof FuncDef)
     *             execute[[d]]()
     */
    @Override
    public Void visit(Program p, Void param){
        for (Definition def: p.getDefinitions())
            if (def instanceof VarDef)
                def.accept(this, null);

        getCodeGenerator().mainInvocation();

        for (Definition def: p.getDefinitions())
            if (def instanceof FuncDef)
                def.accept(this, null);

        return null;
    }
}
