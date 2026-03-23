package ast.expression;

public class UnaryNot extends AbstractExpression {

    private final Expression operand;

    public UnaryNot(Expression operand, int line, int column) {
        super(line, column);
        this.operand = operand;
    }

    public Expression getOperand() {
        return this.operand;
    }
}
