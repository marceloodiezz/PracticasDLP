package semantic;

import ast.expression.*;
import ast.statement.Assignment;
import ast.statement.FuncCall;
import ast.statement.Input;
import ast.type.ErrorType;
import visitor.AbstractVisitor;

public class LValueVisitor extends AbstractVisitor<Void, Void> {

    // ---------------------------------------------------
    // Expresiones

    @Override
    public Void visit(ArithmeticOp arithmeticOp, Void param) {
        super.visit(arithmeticOp, param);
        arithmeticOp.setLValue(false);
        return null;
    }

    @Override
    public Void visit(ArrayAccess arrayAccess, Void param) {
        super.visit(arrayAccess, param);
        arrayAccess.setLValue(true);
        return null;
    }

    @Override
    public Void visit(Cast cast, Void param) {
        super.visit(cast, param);
        cast.setLValue(false);
        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Void param) {
        super.visit(charLiteral, param);
        charLiteral.setLValue(false);
        return null;
    }

    @Override
    public Void visit(ComparisonOp comparisonOp, Void param) {
        super.visit(comparisonOp, param);
        comparisonOp.setLValue(false);
        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Void param) {
        super.visit(fieldAccess, param);
        fieldAccess.setLValue(true);
        return null;
    }

    @Override
    public Void visit(FuncCall funcCall, Void param) {
        super.visit(funcCall, param);
        funcCall.setLValue(false);
        return null;
    }

    @Override
    public Void visit(IntLiteral intLiteral, Void param) {
        super.visit(intLiteral, param);
        intLiteral.setLValue(false);
        return null;
    }

    @Override
    public Void visit(LogicOp logicOp, Void param) {
        super.visit(logicOp, param);
        logicOp.setLValue(false);
        return null;
    }

    @Override
    public Void visit(NumberLiteral numberLiteral, Void param) {
        super.visit(numberLiteral, param);
        numberLiteral.setLValue(false);
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        super.visit(unaryMinus, param);
        unaryMinus.setLValue(false);
        return null;
    }

    @Override
    public Void visit(UnaryNot unaryNot, Void param) {
        super.visit(unaryNot, param);
        unaryNot.setLValue(false);
        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        super.visit(variable, param);
        variable.setLValue(true);
        return null;
    }

    // ---------------------------------------------------
    // Sentencias

    @Override
    public Void visit(Assignment assignment, Void param) {
        super.visit(assignment, param);
        if(!assignment.getLeft().getLValue())
            new ErrorType("Assignment: El lado izquierdo debe ser direccionable (lValue)" , assignment.getLeft());
        return null;
    }

    @Override
    public Void visit(Input input, Void param) {
        super.visit(input, param);
        if(!input.getTarget().getLValue())
            new ErrorType("Input: La expresión debe ser direccionable (lValue)", input.getTarget());
        return null;
    }

}
