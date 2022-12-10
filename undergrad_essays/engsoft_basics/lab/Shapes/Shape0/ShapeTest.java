/**
 * ShapeTest versao 0 - PMR2300
 * Departamento de Engenharia Mecatronica e de Sistemas Mecanicos
 * Escola Politecnica, Universidade de Sao Paulo
 * Autor: Fabio Gagliardi Cozman
 *
 * Exemplo basico com uma classe de teste e uma classe Circle.
 */

public class ShapeTest {
         public static void main(String args[]) {
            double x = Double.parseDouble(args[1]);
            double y = Double.parseDouble(args[2]);
            double r = Double.parseDouble(args[3]);
            Circle c = new Circle(args[0], x, y, r);
            System.out.print("Area of circle " + 
                c.name + " = " + c.area());
        }
}
