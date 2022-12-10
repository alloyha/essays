/**
 * ShapeTest versao 2 - PMR2300
 * Departamento de Engenharia Mecatronica e de Sistemas Mecanicos
 * Escola Politecnica, Universidade de Sao Paulo
 * Autor: Fabio Gagliardi Cozman
 * 
 * Segundo exercicio sobre criacao de arranjos de objetos;
 * para ser feito fora da aula.
 */

public class ShapeTest {
    public static void main(String args[]) {
        Circle c[] = new Circle[ args.length/3 ];
        
        for (int i=0; i<c.length; i++) {
            double x = Double.parseDouble(args[3*i]);
            double y = Double.parseDouble(args[3*i+1]);
            double r = Double.parseDouble(args[3*i+2]);
            c[i] = new Circle("Circle"+i, x, y, r);
        }
        
        for (int j=0; j<c.length; j++)
            System.out.println(c[j].name + "(" + c[j].x + 
                               ", " + c[j].y + ", " + c[j].radius + ")");
            
        System.out.println("Total = " + Circle.total);
        
        // Insira aqui codigo que determina quais circulos
        // tem interseção não nula.
        //
        //
    }
}

 