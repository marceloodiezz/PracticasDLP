package codeGeneration;

public class ExecuteCGVisitor extends AbstractCGVisitor<Void, Void> {

    public ExecuteCGVisitor(CodeGenerator cg) {
        super.setCodeGenerator(cg);
    }

}
