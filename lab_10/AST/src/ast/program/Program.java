package ast.program;

import ast.ASTNode;
import ast.definition.Definition;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Program implements ASTNode {

    private final List<Definition> definitions;

    public Program(List<Definition> definitions) {
        this.definitions = new ArrayList<>(definitions);
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    @Override
    public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
        return v.visit(this, param);
    }

}
