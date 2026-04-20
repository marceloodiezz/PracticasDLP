package visitor;

import ast.definition.*;
import ast.expression.*;
import ast.program.Program;
import ast.statement.*;
import ast.type.*;

public abstract class AbstractVisitor<RT, PT> implements Visitor<RT, PT> {

    // ---------------------------------------------------
    // Definiciones

    @Override
    public RT visit(FuncDef funcDef, PT param) {
        funcDef.getType().accept(this, param);
        for(Statement stmt : funcDef.getBody())
            stmt.accept(this, param);
        return null;
    }

    @Override
    public RT visit(VarDef varDef, PT param) {
        varDef.getType().accept(this, param);
        return null;
    }

    // ---------------------------------------------------
    // Expresiones

    @Override
    public RT visit(ArithmeticOp arithmeticOp, PT param) {
        arithmeticOp.getLeft().accept(this, param);
        arithmeticOp.getRight().accept(this, param);
        return null;
    }

    @Override
    public RT visit(ArrayAccess arrayAccess, PT param) {
        arrayAccess.getLeft().accept(this, param);
        arrayAccess.getRight().accept(this, param);
        return null;
    }

    @Override
    public RT visit(Cast cast, PT param) {
        cast.getExpr().accept(this, param);
        cast.getTargetType().accept(this, param);
        return null;
    }

    @Override
    public RT visit(CharLiteral charLiteral, PT param) {
        return null;
    }

    @Override
    public RT visit(ComparisonOp comparisonOp, PT param) {
        comparisonOp.getLeft().accept(this, param);
        comparisonOp.getRight().accept(this, param);
        return null;
    }

    @Override
    public RT visit(FieldAccess fieldAccess, PT param) {
        fieldAccess.getExpr().accept(this, param);
        return null;
    }

    @Override
    public RT visit(IntLiteral intLiteral, PT param) {
        return null;
    }

    @Override
    public RT visit(LogicOp logicOp, PT param) {
        logicOp.getLeft().accept(this, param);
        logicOp.getRight().accept(this, param);
        return null;
    }

    @Override
    public RT visit(NumberLiteral numberLiteral, PT param) {
        return null;
    }

    @Override
    public RT visit(UnaryMinus unaryMinus, PT param) {
        unaryMinus.getOperand().accept(this, param);
        return null;
    }

    @Override
    public RT visit(UnaryNot unaryNot, PT param) {
        unaryNot.getOperand().accept(this, param);
        return null;
    }

    @Override
    public RT visit(Variable variable, PT param) {
        return null;
    }

    // ---------------------------------------------------
    // Programa

    @Override
    public RT visit(Program program, PT param) {
        for(Definition def : program.getDefinitions())
            def.accept(this, param);
        return null;
    }

    // ---------------------------------------------------
    // Sentencias

    @Override
    public RT visit(Assignment assignment, PT param) {
        assignment.getLeft().accept(this, param);
        assignment.getRight().accept(this, param);
        return null;
    }

    @Override
    public RT visit(FuncCall funcCall, PT param) {
        funcCall.getVariable().accept(this, param);
        for(Expression arg : funcCall.getArgs())
            arg.accept(this, param);
        return null;
    }

    @Override
    public RT visit(IfElse ifElse, PT param) {
        ifElse.getCondition().accept(this, param);
        for(Statement ifStmt : ifElse.getIf_body())
            ifStmt.accept(this, param);
        for(Statement elseStmt : ifElse.getElse_body())
            elseStmt.accept(this, param);
        return null;
    }

    @Override
    public RT visit(Input input, PT param) {
        input.getTarget().accept(this, param);
        return null;
    }

    @Override
    public RT visit(Log log, PT param) {
        log.getExpr().accept(this, param);
        return null;
    }

    @Override
    public RT visit(Return ret, PT param) {
        ret.getValue().accept(this, param);
        return null;
    }

    @Override
    public RT visit(While wh, PT param) {
        wh.getCondition().accept(this, param);
        for(Statement stmt : wh.getBody())
            stmt.accept(this, param);
        return null;
    }

    // ---------------------------------------------------
    // Tipos

    @Override
    public RT visit(ArrayType arrayType, PT param) {
        arrayType.getOf().accept(this, param);
        return null;
    }

    @Override
    public RT visit(CharType charType, PT param) {
        return null;
    }

    @Override
    public RT visit(ErrorType errorType, PT param) {
        errorType.getLocatable().accept(this, param);
        return null;
    }

    @Override
    public RT visit(FuncType funcType, PT param) {
        funcType.getReturnType().accept(this, param);
        for(VarDef varDef : funcType.getParams()) {
            varDef.accept(this, param);
            varDef.getType().accept(this, param);
        }
        return null;
    }

    @Override
    public RT visit(IntType intType, PT param) {
        return null;
    }

    @Override
    public RT visit(NumberType numberType, PT param) {
        return null;
    }

    @Override
    public RT visit(RecordField recordField, PT param) {
        recordField.getTargetType().accept(this, param);
        return null;
    }

    @Override
    public RT visit(RecordType recordType, PT param) {
        for(RecordField rf : recordType.getFields())
            rf.accept(this, param);
        return null;
    }

    @Override
    public RT visit(VoidType voidType, PT param) {
        return null;
    }

}
