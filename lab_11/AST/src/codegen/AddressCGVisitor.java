package codegen;

import ast.definition.*;
import ast.expression.*;
import ast.statement.*;
import ast.type.*;

public class AddressCGVisitor extends AbstractCGVisitor<Void, Void> {

    private ValueCGVisitor valueCGVisitor;

    public AddressCGVisitor(CodeGenerator codeGenerator) {
        super(codeGenerator);
    }

    public void setValueCGVisitor(ValueCGVisitor valueCGVisitor) {
        this.valueCGVisitor = valueCGVisitor;
    }

    /**
     * address[[ Variable: expr -> ID ]]() =
     *     // Variables Globales
     *     if (expr.def.scope == 0)
     *         <pusha> expr.def.offset
     *     // Variables Locales y Parámetros
     *     else {
     *         <pusha bp>
     *         <pushi> expr.def.offset
     *         <addi>
     *     }
     */
    @Override
    public Void visit(Variable v, Void param) {
        if (v.getDefinition().getScope() == 0)
            getCodeGenerator().pusha(((VarDef) v.getDefinition()).getOffset());
        else {
            getCodeGenerator().pushBP();
            getCodeGenerator().pushi(((VarDef) v.getDefinition()).getOffset());
            getCodeGenerator().add(IntType.getInstance());
        }
        return null;
    }

    /**
     * address[[ ArrayAccess: expr1 -> expr2 expr3 ]]() =
     *     address[[expr2]]()
     *     value[[expr3]]()
     *     cg.convertTo(expr3.type, IntType)
     *     <pushi> expr1.type.numberOfBytes()
     *     <muli>
     *     <addi>
     */
    @Override
    public Void visit(ArrayAccess a, Void param) {
        a.getLeft().accept(this, null);
        a.getRight().accept(valueCGVisitor, null);
        getCodeGenerator().convertTo(a.getRight().getType(), IntType.getInstance());
        getCodeGenerator().pushi(a.getType().numberOfBytes());
        getCodeGenerator().mul(IntType.getInstance());
        getCodeGenerator().add(IntType.getInstance());
        return null;
    }

    /**
     * address[[ FieldAccess: expr1 -> expr2 ID ]]()
     *     address[[expr2]]()
     *     <pushi> expr2.type.field(ID).offset
     *     <addi>
     */
    @Override
    public Void visit(FieldAccess f, Void param) {
        f.getExpr().accept(this, null);
        getCodeGenerator().pushi(((RecordType) f.getExpr().getType()).getField(f.getFieldName()).getOffset());
        getCodeGenerator().add(IntType.getInstance());
        return null;
    }
}
