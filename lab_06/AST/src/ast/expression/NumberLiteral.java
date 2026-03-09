package ast.expression;

public class NumberLiteral extends AbstractExpression {

    private final double value;

    public NumberLiteral(double value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
