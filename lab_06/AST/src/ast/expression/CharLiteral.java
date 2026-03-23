package ast.expression;

public class CharLiteral extends AbstractExpression {

    private final char value;

    public CharLiteral(char value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public char getValue() {
        return this.value;
    }

}
