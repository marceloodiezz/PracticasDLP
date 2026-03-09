package ast.expression;

public class IntLiteral extends AbstractExpression {

    private final int value;

    public IntLiteral(int value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
