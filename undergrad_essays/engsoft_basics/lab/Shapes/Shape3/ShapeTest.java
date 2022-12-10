/**
 * ShapeTest versao 3 - PMR2300
 * Departamento de Engenharia Mecatronica e de Sistemas Mecanicos
 * Escola Politecnica, Universidade de Sao Paulo
 * Autor: Fabio Gagliardi Cozman
 *
 * Exemplo com hierarquia de classes, com exercicio de
 * criacao de subclasses.
 */

public class ShapeTest {
    public static void main(String args[]) {
        Shape s = createShape(args);
        System.out.println(s.name + ", area = " + s.area());
    }

    // Cria um Shape. Insira código para classe Triangle
    // e para classe Rectangle (sub-classe de Square).
    static Shape createShape(String args[]) {
        if (args[0].equals("square")) {
            double s = Double.parseDouble(args[2]);
            return(new Square(args[1], s));
        } else if (args[0].equals("circle")) {
            double x = Double.parseDouble(args[2]);
            double y = Double.parseDouble(args[3]);
            double r = Double.parseDouble(args[4]);
            return(new Circle(args[1], x, y, r));
        } else 
              return(null);
    }
}
 