package ast.type;

import ast.Locatable;

import java.util.List;

public abstract class AbstractType implements Type {

    @Override
    public Type arithmetic(Type other, Locatable l) {
        if (other instanceof ErrorType)
            return other;
        return new ErrorType("No se puede realizar una operación aritmética entre '" + this + "' y '" + other + "'.", l);
    }

    @Override
    public Type logic(Type other, Locatable l) {
        if (other instanceof ErrorType)
            return other;
        return new ErrorType("No se puede realizar una operación lógica entre '" + this + "' y '" + other + "'.", l);
    }

    @Override
    public Type comparison(Type other, Locatable l) {
        if (other instanceof ErrorType)
            return other;
        return new ErrorType("No se puede realizar una comparación entre '" + this + "' y '" + other + "'.", l);
    }

    @Override
    public Type arithmetic(Locatable l) {
        return new ErrorType("No se puede aplicar un operador aritmético unario al tipo '" + this + "'.", l);
    }

    @Override
    public Type logic(Locatable l) {
        return new ErrorType("No se puede aplicar un operador lógico unario al tipo '" + this + "'.", l);
    }

    @Override
    public Type canBeCastTo(Type other, Locatable l) {
        if (other instanceof ErrorType)
            return other;
        return new ErrorType("No se puede convertir el tipo '" + this + "' al tipo '" + other + "'.", l);
    }

    @Override
    public Type squareBrackets(Type other, Locatable l) {
        if (other instanceof ErrorType)
            return other;
        return new ErrorType("No se puede indexar una expresión de tipo '" + this + "'.", l);
    }

    @Override
    public Type dot(String fieldName, Locatable l) {
        return new ErrorType("El tipo '" + this + "' no tiene un campo llamado '" + fieldName + "'.", l);
    }

    @Override
    public Type parenthesis(List<Type> types, Locatable l) {
        for (Type t : types)
            if (t instanceof ErrorType)
                return t;

        return new ErrorType("No se puede invocar una expresión de tipo '" + this + "' porque no es una función.", l);
    }



    @Override
    public void mustBeLogical(Locatable l) {
        new ErrorType("Se esperaba una expresión lógica, pero se encontró una expresión de tipo '" + this + "'.", l);
    }

    @Override
    public void mustPromotesTo(Type other, Locatable l) {
        if (other instanceof ErrorType)
            return;
        new ErrorType("No se puede convertir implícitamente el tipo '" + this + "' al tipo '" + other + "'.", l);
    }

    @Override
    public void mustBeBuiltIn(Locatable l) {
        new ErrorType("Se esperaba un tipo primitivo, pero se encontró el tipo '" + this + "'.", l);
    }

    @Override
    public int numberOfBytes() {
        // Lanzar RuntimeException ya que una VarDef no puede ser de tipo VoidType, FunctType o ErrorType
        throw new UnsupportedOperationException("Una definición de variable no puede ser de tipo '" + this + "'");
    }

}
