package semantic;

import ast.definition.*;
import ast.expression.Variable;
import ast.type.ErrorType;
import symboltable.SymbolTable;
import visitor.AbstractVisitor;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

    public SymbolTable st = new SymbolTable();

    // ---------------------------------------------------
    // Definiciones

    public Void visit(FuncDef funcDef, Void param) {
        if(!st.insert(funcDef)){
            new ErrorType("FunctionDefinition: La función '" + funcDef.getName() + "' ya ha sido declarada.", funcDef);
        }
        st.set();
        super.visit(funcDef, param);
        st.reset();
        return null;
    }

    public Void visit (VarDef varDef, Void param) {
        if (!st.insert(varDef)){
            new ErrorType("VariableDefinition: La variable '" + varDef.getName() + "' ya ha sido declarada.", varDef);
        }
        super.visit(varDef, param);
        return null;
    }

    // ---------------------------------------------------
    // Variable

    public Void visit(Variable var, Void param) {
        Definition def = st.find(var.getName());
        super.visit(var, param);
        if (def != null) {
            var.setDefinition(def);
        }
        else {
            ErrorType e = new ErrorType("Variable: La variable '" + var.getName() + "' no ha sido declarada.", var);
            var.setDefinition(new VarDef("", e, 0, 0));
        }
        return null;
    }

}
