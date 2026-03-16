package errorhandler;

import ast.type.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    private static final ErrorHandler INSTANCE = new ErrorHandler();
    private List<ErrorType> errores = new ArrayList<>();

    private ErrorHandler() {}

    public static ErrorHandler getInstance() {
        return INSTANCE;
    }

    public boolean anyError() {
        return !(errores.isEmpty());
    }

    public void showErrors(PrintStream pS) {
        for(ErrorType e : errores)
            pS.println(e.toString());
    }

    public void addError(ErrorType e) {
        errores.add(e);
    }

}
