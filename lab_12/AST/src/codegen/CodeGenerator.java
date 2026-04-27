package codegen;

import ast.type.CharType;
import ast.type.IntType;
import ast.type.NumberType;
import ast.type.Type;

import java.io.IOException;
import java.io.PrintWriter;

public class CodeGenerator {

    private PrintWriter out;

    public CodeGenerator(String outputFilename, String sourceFilename) {
        try {
            this.out = new PrintWriter(outputFilename);
        }
        catch (IOException e) {
            System.err.println("Error abriendo el archivo: " + outputFilename + ".");
            System.exit(-1);
        }
        this.source(sourceFilename);
    }

    public void pushb(char charConstant){
        out.println("\tpushb\t" + (int) charConstant);

        out.flush();
    }

    public void pushi(int intConstant){
        out.println("\tpushi\t" + intConstant);

        out.flush();
    }

    public void pushf(double realConstant){
        out.println("\tpushf\t" + realConstant);

        out.flush();
    }

    public void pusha(int intConstant) {
        out.println("\tpusha\t" + intConstant);

        out.flush();
    }

    public void pushBP() {
        out.println("\tpush\tbp");

        out.flush();
    }

    public void load(Type type) {
        out.println("\tload" + type.suffix());

        out.flush();
    }
    public void store(Type type) {
        out.println("\tstore" + type.suffix());

        out.flush();
    }

    public void pop(Type type) {
        out.println("\tpop\t" + type.suffix());

        out.flush();
    }

    public void dup(Type type) {
        out.println("\tdup\t" + type.suffix());

        out.flush();
    }

    public void arithmetic(String operator, Type type) {
        switch (operator) {
            case "+": add(type); break;
            case "*": mul(type); break;
            case "-": sub(type); break;
            case "/": div(type); break;
            case "%": mod(type); break;
        }

        out.flush();
    }

    public void add(Type type) {
        out.println("\tadd" + type.suffix());

        out.flush();
    }

    public void mul(Type type) {
        out.println("\tmul" + type.suffix());

        out.flush();
    }

    public void sub(Type type) {
        out.println("\tsub" + type.suffix());

        out.flush();
    }

    public void div(Type type) {
        out.println("\tdiv" + type.suffix());

        out.flush();
    }

    public void mod(Type type) {
        out.println("\tmod" + type.suffix());

        out.flush();
    }

    public void comparison(String operator, Type type) {
        switch (operator) {
            case ">": gt(type); break;
            case "<": lt(type); break;
            case ">=": ge(type); break;
            case "<=": le(type); break;
            case "==": eq(type); break;
            case "!=": ne(type); break;
        }

        out.flush();
    }

    public Type comparisonType(Type left, Type right) {
        if (left.equals(NumberType.getInstance()) || right.equals(NumberType.getInstance()))
            return NumberType.getInstance();
        return IntType.getInstance();
    }

    public void gt(Type type) {
        out.println("\tgt" + type.suffix());

        out.flush();
    }

    public void lt(Type type) {
        out.println("\tlt" + type.suffix());

        out.flush();
    }

    public void ge(Type type) {
        out.println("\tge" + type.suffix());

        out.flush();
    }

    public void le(Type type) {
        out.println("\tle" + type.suffix());

        out.flush();
    }

    public void eq(Type type) {
        out.println("\teq" + type.suffix());

        out.flush();
    }

    public void ne(Type type) {
        out.println("\tne" + type.suffix());

        out.flush();
    }

    public void logic(String operator, Type type) {
        switch (operator) {
            case "&&": and(); break;
            case "||": or(); break;
        }

        out.flush();
    }

    public void and(){
        out.println("\tand");

        out.flush();
    }

    public void or(){
        out.println("\tor");

        out.flush();
    }

    public void not(){
        out.println("\tnot");

        out.flush();
    }

    public void out(Type type) {
        out.println("\tout" + type.suffix());
        out.flush();
    }

    public void in(Type type) {
        out.println("\tin" + type.suffix());

        out.flush();
    }

    public void convertTo(Type from, Type to) {
        // From y To son el mismo tipo
        if (from.equals(to))
            return;

        // Llega un entero y
        if (from.equals(IntType.getInstance())) {
            // se quiere convertir a char (conversion directa)
            if (to.equals(CharType.getInstance()))
                out.println("\ti2b");

            // se quiere convertir a number (conversion directa)
            else if (to.equals(NumberType.getInstance()))
                out.println("\ti2f");
        }

        // Llega un caracter y
        else if ( from.equals(CharType.getInstance())) {
            // se quiere convertir a entero (conversion directa)
            if (to.equals(IntType.getInstance()))
                out.println("\tb2i");

            // se quiere convertir a number (conversion indirecta: Char -> Int; Int -> Number)
            else if (to.equals(NumberType.getInstance())) {
                out.println("\tb2i");
                out.println("\ti2f");
            }
        }

        // Llega un number y
        else if (from.equals(NumberType.getInstance())){
            // se quiere convertir a entero (conversion directa)
            if (to.equals(IntType.getInstance()))
                out.println("\tf2i");

            // se quiere convertir a char (conversion indirecta: Number -> Int; Int -> Char)
            else if (to.equals(CharType.getInstance())) {
                out.println("\tf2i");
                out.println("\ti2b");
            }
        }

        out.flush();
    }

    public void call(String name) {
        out.println("\tcall\t" + name);

        out.flush();
    }

    public void ret(int returnBytes, int bytesLocalSum, int paramBytes) {
        out.println("\tret\t" + returnBytes + ", " + bytesLocalSum + ", " + paramBytes);

        out.flush();
    }

    public void halt() {
        out.println("halt");

        out.flush();
    }

    public void commentLine(int line) {
        out.println("\n#line\t" + line);

        out.flush();
    }

    public void printFunction(String name) {
        out.println("\n" + name + ":");

        out.flush();
    }

    public void comment(String name) {
        out.println("\t' * " + name);

        out.flush();
    }

    public void enter(int bytesLocalSum) {
        out.println("\tenter\t" + bytesLocalSum);

        out.flush();
    }

    public void source(String source) {
        out.println("\n#source\t" + "\"" + source + "\"\n");

        out.flush();
    }

    public void mainInvocation() {
        out.println("\n' Invocation to the main function");
        out.println("\tcall\tmain");
        out.println("\thalt");

        out.flush();
    }


}
