package codeGeneration;

import ast.definition.FuncDef;
import ast.definition.VarDef;
import ast.expression.*;
import ast.program.Program;
import ast.statement.*;
import ast.type.*;
import visitor.Visitor;

public abstract class AbstractCGVisitor<RT, PT> implements Visitor<RT, PT> {

    private CodeGenerator codeGenerator;

    public CodeGenerator getCodeGenerator() {
        return codeGenerator;
    }

    public void setCodeGenerator(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

    @Override
    public RT visit(FuncDef funcDef, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + funcDef);
    }

    @Override
    public RT visit(VarDef varDef, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + varDef);
    }

    @Override
    public RT visit(ArithmeticOp arithmeticOp, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + arithmeticOp);
    }

    @Override
    public RT visit(ArrayAccess arrayAccess, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + arrayAccess);
    }

    @Override
    public RT visit(Cast cast, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + cast);
    }

    @Override
    public RT visit(CharLiteral charLiteral, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + charLiteral);
    }

    @Override
    public RT visit(ComparisonOp comparisonOp, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + comparisonOp);
    }

    @Override
    public RT visit(FieldAccess fieldAccess, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + fieldAccess);
    }

    @Override
    public RT visit(IntLiteral intLiteral, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + intLiteral);
    }

    @Override
    public RT visit(LogicOp logicOp, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + logicOp);
    }

    @Override
    public RT visit(NumberLiteral numberLiteral, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + numberLiteral);
    }

    @Override
    public RT visit(UnaryMinus unaryMinus, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + unaryMinus);
    }

    @Override
    public RT visit(UnaryNot unaryNot, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + unaryNot);
    }

    @Override
    public RT visit(Variable variable, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + variable);
    }

    @Override
    public RT visit(Program program, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + program);
    }

    @Override
    public RT visit(Assignment assignment, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + assignment);
    }

    @Override
    public RT visit(FuncCall funcCall, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + funcCall);
    }

    @Override
    public RT visit(IfElse ifElse, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + ifElse);
    }

    @Override
    public RT visit(Input input, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + input);
    }

    @Override
    public RT visit(Log log, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + log);
    }

    @Override
    public RT visit(Return ret, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + ret);
    }

    @Override
    public RT visit(While wh, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + wh);
    }

    @Override
    public RT visit(ArrayType arrayType, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + arrayType);
    }

    @Override
    public RT visit(CharType charType, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + charType);
    }

    @Override
    public RT visit(ErrorType errorType, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + errorType);
    }

    @Override
    public RT visit(FuncType funcType, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + funcType);
    }

    @Override
    public RT visit(IntType intType, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + intType);
    }

    @Override
    public RT visit(NumberType numberType, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + numberType);
    }

    @Override
    public RT visit(RecordField recordField, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + recordField);
    }

    @Override
    public RT visit(RecordType recordType, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + recordType);
    }

    @Override
    public RT visit(VoidType voidType, PT param) {
        throw new IllegalStateException("Code generation not implemented for node: " + voidType);
    }
}
