package ast.type;

import ast.ASTNode;
import ast.Locatable;

import java.util.List;

public interface Type extends ASTNode {

    // Operaciones aritméticas binarias
    Type arithmetic(Type other, Locatable l);

    // Operaciones lógicas binarias
    Type logic(Type other, Locatable l);

    // Operaciones de comparación
    Type comparison(Type other, Locatable l);

    // Operaciones aritméticas unarias
    Type arithmetic(Locatable l);

    // Operaciones lógicas unarias
    Type logic(Locatable l);

    // Cast
    Type canBeCastTo(Type t, Locatable l);

    // Acceso a arrays
    Type squareBrackets(Type other, Locatable l);

    // Acceso a campos
    Type dot(String fieldName, Locatable l);

    // Invocación a funciones
    Type parenthesis(List<Type> types, Locatable l);

    // Comprobar que la expresión es lógica para condiciones (If-Else y While)
    void mustBeLogical(Locatable l);

    // Comprobar que un tipo puede promocionar a otro
    void mustPromotesTo(Type other, Locatable l);

    // Comprobar que el tipo es simple
    // NO USAR PARA CAST
    void mustBeBuiltIn(Locatable l);

}
