package main.program;

import main.definition.Definition;

import java.util.ArrayList;
import java.util.List;

public class Program {

    private final List<Definition> definitions;

    public Program(List<Definition> definitions) {
        this.definitions = new ArrayList<>(definitions);
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }
}
