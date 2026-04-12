package semantic;

import ast.definition.FuncDef;
import ast.expression.*;
import ast.statement.*;
import ast.type.*;
import visitor.AbstractVisitor;

import java.util.*;

public class TypeCheckingVisitor extends AbstractVisitor<Void, Type> {

    // ---------------------------------------------------
    // Expresiones

    @Override
    public Void visit(IntLiteral i, Type param) {
        i.setType(IntType.getInstance());
        return null;
    }

    @Override
    public Void visit(CharLiteral c, Type param) {
        c.setType(CharType.getInstance());
        return null;
    }

    @Override
    public Void visit(NumberLiteral n, Type param) {
        n.setType(NumberType.getInstance());
        return null;
    }

    @Override
    public Void visit(Variable v, Type param) {
        v.setType(v.getDefinition().getType());
        return null;
    }

    @Override
    public Void visit (ArithmeticOp a, Type param) {
        super.visit(a, param);
        a.setType(a.getLeft().getType().arithmetic(a.getRight().getType(), a));
        return null;
    }

    @Override
    public Void visit(LogicOp l, Type param) {
        super.visit(l, param);
        l.setType(l.getLeft().getType().logic(l.getRight().getType(), l));
        return null;
    }

    @Override
    public Void visit(ComparisonOp c, Type param) {
        super.visit(c, param);
        c.setType(c.getLeft().getType().comparison(c.getRight().getType(), c));
        return null;
    }

    @Override
    public Void visit(UnaryMinus u, Type param) {
        super.visit(u, param);
        u.setType(u.getOperand().getType().arithmetic(u));
        return null;
    }

    @Override
    public Void visit(UnaryNot u, Type param) {
        super.visit(u, param);
        u.setType(u.getOperand().getType().logic(u));
        return null;
    }

    @Override
    public Void visit(Cast c, Type param) {
        super.visit(c, param);
        c.setType(c.getExpr().getType().canBeCastTo(c.getTargetType(), c));
        return null;
    }

    @Override
    public Void visit(ArrayAccess a, Type param) {
        super.visit(a, param);
        a.setType(a.getLeft().getType().squareBrackets(a.getRight().getType(), a));
        return null;
    }

    @Override
    public Void visit(FieldAccess f, Type param) {
        super.visit(f, param);
        f.setType(f.getExpr().getType().dot(f.getFieldName(), f));
        return null;
    }

    @Override
    public Void visit(FuncCall f, Type param) {
        super.visit(f, param);
        List<Type> argumentsTypes = new ArrayList<>();
        for(Expression expr : f.getArgs())
            argumentsTypes.add(expr.getType());
        f.setType(f.getVariable().getType().parenthesis(argumentsTypes, f));
        return null;
    }

    // ---------------------------------------------------
    // Sentencias

    @Override
    public Void visit(Return r, Type param) {
        super.visit(r, param);
        r.getValue().getType().mustPromotesTo(param, r);
        return null;
    }

    @Override
    public Void visit(Input i, Type param) {
        super.visit(i, param);
        i.getTarget().getType().mustBeBuiltIn(i);
        return null;
    }

    @Override
    public Void visit(Log l, Type param) {
        super.visit(l, param);
        l.getExpr().getType().mustBeBuiltIn(l);
        return null;
    }

    @Override
    public Void visit(Assignment a, Type param) {
        super.visit(a, param);
        a.getRight().getType().mustPromotesTo(a.getLeft().getType(), a);
        return null;
    }

    @Override
    public Void visit(While w, Type param) {
        super.visit(w, param);
        w.getCondition().getType().mustBeLogical(w);
        return null;
    }

    @Override
    public Void visit(IfElse i, Type param) {
        super.visit(i, param);
        i.getCondition().getType().mustBeLogical(i);
        return null;
    }

    // ---------------------------------------------------
    // Definiciones

    @Override
    public Void visit(FuncDef f, Type param) {
        f.getType().accept(this, param);

        FuncType funcType = (FuncType) f.getType();
        Type returnType = funcType.getReturnType();

        for (Statement stmt : f.getBody()) {
            stmt.accept(this, returnType);
        }
        return null;
    }

}
