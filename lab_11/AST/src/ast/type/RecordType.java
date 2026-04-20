package ast.type;

import ast.Locatable;
import visitor.Visitor;

import java.util.List;

public class RecordType extends AbstractType {

    private final List<RecordField> fields;

    public RecordType(List<RecordField> fields) {
        this.fields = fields;
    }

    public List<RecordField> getFields() {
        return this.fields;
    }

    @Override
    public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
        return v.visit(this, param);
    }

    @Override
    public Type dot(String fieldName, Locatable l) {
        for(RecordField f : fields)
            if(f.getName().equals(fieldName))
                return f.getTargetType();
        return new ErrorType("No se ha encontrado ningún campo '" + fieldName + "' en el Record.", l);
    }

    @Override
    public String toString() {
        return "RecordType";
    }

    @Override
    public int numberOfBytes() {
        int cont = 0;
        for(RecordField field : fields)
            cont += field.getTargetType().numberOfBytes();
        return cont;
    }

}
