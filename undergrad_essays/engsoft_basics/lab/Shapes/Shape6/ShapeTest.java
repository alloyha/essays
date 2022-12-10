/**
 * ShapeTest versao 6 - PMR2300
 * Departamento de Engenharia Mecatronica e de Sistemas Mecanicos
 * Escola Politecnica, Universidade de Sao Paulo
 * Autor: Fabio Gagliardi Cozman
 *
 * Exercicio sobre excecoes, com criacao de uma classe
 * de excecao.
 * Teste para uso de classe abstrata com Shape.
 */

import shapes.*;

public class ShapeTest {
    public static void main(String args[]) {
        try {
            Shape s = createShape(args);
            System.out.println(s.getName() + ", area = " + s.area());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Insira numero correto de parametros!");
        } catch (NumberFormatException e) {
            System.out.println("Use formato correto para parametros!");
        } catch (UndefinedShapeException e) {
            System.out.println("Use um shape valido!");
        } finally {
            System.out.println("TCHAU! \n");
        }
    }

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
              throw new UndefinedShapeException();
    }
}
 