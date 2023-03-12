package Controller;

import Model.AbstractFuncion;
import Model.Defensiva;
import Model.LispException;
import View.UI;

public class Main {
    static UI ui = new UI();
    static Defensiva defensiva = new Defensiva();
    static Factory factory = new Factory();
    public static void main(String[] args) throws Exception {
        System.out.println("Interprete LISP");
        String f = "(+ 2 2)";
        AbstractFuncion funcion = execute(f);
        assert funcion != null;
        System.out.println(funcion.ejecutar(f));
    }
    public static AbstractFuncion execute(String line) throws Exception {
        // String line = ui.readCodigo();
        try {
           return factory.execute(line);

        }catch (LispException e){
            ui.print(e.getMessage());
        }
        return null;
    }
}