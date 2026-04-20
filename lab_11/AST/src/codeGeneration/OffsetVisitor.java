package codeGeneration;

import ast.definition.FuncDef;
import ast.definition.VarDef;
import ast.statement.Statement;
import ast.type.FuncType;
import ast.type.RecordField;
import ast.type.RecordType;
import visitor.AbstractVisitor;

import java.util.List;

public class OffsetVisitor extends AbstractVisitor<Void, Boolean> {

    private int bytesGlobalSum = 0;
    private int bytesLocalSum = 0;

    @Override
    public Void visit(FuncDef fd, Boolean param) {
        // Reiniciar el acumulador de variables locales para cada función
        bytesLocalSum = 0;

        // Primero visitar el tipo de la función, que incluye:
        // - tipo de retorno
        // - parámetros formales
        fd.getType().accept(this, null);

        // Después recorrer el cuerpo como contexto local
        for (Statement stmt : fd.getBody())
            stmt.accept(this, true);

        return null;
    }

    @Override
    public Void visit(VarDef vd, Boolean isLocal) {
        // Primero visitar su tipo por si contiene records anidados
        vd.getType().accept(this, null);

        if (isLocal == null || !isLocal) {
            // Variable global
            if (vd.getScope() == 0) {
                vd.setOffset(bytesGlobalSum);
                bytesGlobalSum += vd.getType().numberOfBytes();
            }
        }
        else {
            // Variable local
            bytesLocalSum += vd.getType().numberOfBytes();
            vd.setOffset(-bytesLocalSum);
        }

        return null;
    }

    @Override
    public Void visit(FuncType ft, Boolean param) {
        // Visitar el tipo de retorno por si fuera complejo
        ft.getReturnType().accept(this, null);

        // Los parámetros van con offsets positivos respecto a BP y se calculan de derecha a izquierda.
        int paramOffset = 4;
        List<VarDef> params = ft.getParams();

        for (int i = params.size() - 1; i >= 0; i--) {
            VarDef vd = params.get(i);

            // Visitar el tipo por si el parámetro contiene records anidados
            vd.getType().accept(this, null);

            vd.setOffset(paramOffset);
            paramOffset += vd.getType().numberOfBytes();
        }

        return null;
    }

    @Override
    public Void visit(RecordType rt, Boolean param) {
        int bytesSum = 0;
        for(RecordField rf : rt.getFields()) {
            rf.setOffset(bytesSum);
            bytesSum += rf.getTargetType().numberOfBytes();

            // Para soportar records anidados dentro de campos
            rf.getTargetType().accept(this, null);
        }
        return null;
    }

}
