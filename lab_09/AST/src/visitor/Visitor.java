package visitor;

import ast.definition.*;
import ast.expression.*;
import ast.program.Program;
import ast.statement.*;
import ast.type.*;

public interface Visitor<PT, RT> {

    // Definiciones
    RT visit(FuncDef funcDef, PT param);
    RT visit(VarDef varDef, PT param);

    // Expresiones
    RT visit(ArithmeticOp arithmeticOp, PT param);
    RT visit(ArrayAccess arrayAccess, PT param);
    RT visit(Cast cast, PT param);
    RT visit(CharLiteral charLiteral, PT param);
    RT visit(ComparisonOp comparisonOp, PT param);
    RT visit(FieldAccess fieldAccess, PT param);
    RT visit(IntLiteral intLiteral, PT param);
    RT visit(LogicOp logicOp, PT param);
    RT visit(NumberLiteral numberLiteral, PT param);
    RT visit(UnaryMinus unaryMinus, PT param);
    RT visit(UnaryNot unaryNot, PT param);
    RT visit(Variable variable, PT param);

    // Programa
    RT visit(Program program, PT param);

    // Sentencias
    RT visit(Assignment assignment, PT param);
    RT visit(FuncCall funcCall, PT param);
    RT visit(IfElse ifElse, PT param);
    RT visit(Input input, PT param);
    RT visit(Log log, PT param);
    RT visit(Return ret, PT param);
    RT visit(While wh, PT param);

    // Tipos
    RT visit(ArrayType arrayType, PT param);
    RT visit(CharType charType, PT param);
    RT visit(ErrorType errorType, PT param);
    RT visit(FuncType funcType, PT param);
    RT visit(IntType intType, PT param);
    RT visit(NumberType numberType, PT param);
    RT visit(RecordField recordField, PT param);
    RT visit(RecordType recordType, PT param);
    RT visit(VoidType voidType, PT param);

}
