package main.type;

import java.util.List;

public class RecordType {

    private final List<RecordField> fields;

    public RecordType(List<RecordField> fields) {
        this.fields = fields;
    }

    public List<RecordField> getFields() {
        return this.fields;
    }

}
