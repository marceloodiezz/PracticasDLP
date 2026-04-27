package codegen;

import ast.definition.*;
import ast.expression.*;
import ast.program.Program;
import ast.statement.*;
import ast.type.*;
import visitor.Visitor;

public abstract class AbstractCGVisitor<RT, PT> implements Visitor<RT, PT> {

    private CodeGenerator codeGenerator;

    public AbstractCGVisitor(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

    public CodeGenerator getCodeGenerator() {
        return codeGenerator;
    }

    @Override
    public RT visit(FuncDef funcDef, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + funcDef);
    }

    @Override
    public RT visit(VarDef varDef, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + varDef);
    }

    @Override
    public RT visit(ArithmeticOp arithmeticOp, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + arithmeticOp);
    }

    @Override
    public RT visit(ArrayAccess arrayAccess, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + arrayAccess);
    }

    @Override
    public RT visit(Cast cast, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + cast);
    }

    @Override
    public RT visit(CharLiteral charLiteral, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + charLiteral);
    }

    @Override
    public RT visit(ComparisonOp comparisonOp, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + comparisonOp);
    }

    @Override
    public RT visit(FieldAccess fieldAccess, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + fieldAccess);
    }

    @Override
    public RT visit(IntLiteral intLiteral, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + intLiteral);
    }

    @Override
    public RT visit(LogicOp logicOp, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + logicOp);
    }

    @Override
    public RT visit(NumberLiteral numberLiteral, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + numberLiteral);
    }

    @Override
    public RT visit(UnaryMinus unaryMinus, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + unaryMinus);
    }

    @Override
    public RT visit(UnaryNot unaryNot, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + unaryNot);
    }

    @Override
    public RT visit(Variable variable, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + variable);
    }

    @Override
    public RT visit(Program program, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + program);
    }

    @Override
    public RT visit(Assignment assignment, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + assignment);
    }

    @Override
    public RT visit(FuncCall funcCall, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + funcCall);
    }

    @Override
    public RT visit(IfElse ifElse, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + ifElse);
    }

    @Override
    public RT visit(Input input, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + input);
    }

    @Override
    public RT visit(Log log, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + log);
    }

    @Override
    public RT visit(Return ret, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + ret);
    }

    @Override
    public RT visit(While wh, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + wh);
    }

    @Override
    public RT visit(ArrayType arrayType, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + arrayType);
    }

    @Override
    public RT visit(CharType charType, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + charType);
    }

    @Override
    public RT visit(ErrorType errorType, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + errorType);
    }

    @Override
    public RT visit(FuncType funcType, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + funcType);
    }

    @Override
    public RT visit(IntType intType, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + intType);
    }

    @Override
    public RT visit(NumberType numberType, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + numberType);
    }

    @Override
    public RT visit(RecordField recordField, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + recordField);
    }

    @Override
    public RT visit(RecordType recordType, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + recordType);
    }

    @Override
    public RT visit(VoidType voidType, PT param) {
        throw new IllegalStateException("Generación de código no implementada para el nodo: " + voidType);
    }
}
