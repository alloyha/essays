/**
 * ShapeTest versao 1 - PMR2300
 * Departamento de Engenharia Mecatronica e de Sistemas Mecanicos
 * Escola Politecnica, Universidade de Sao Paulo
 * Autor: Fabio Gagliardi Cozman
 * 
 * Exemplo com uma classe de teste e uma classe Circle;
 * exercicio sobre criacao de arranjo contendo objetos.
 */

public class ShapeTest {
    public static void main(String args[]) {
        Circle c[] = new Circle[ args.length ];
        
        for (int i=0; i<c.length; i++) {
            double r = Double.parseDouble(args[i]);
            c[i] = new Circle("Circle"+i);
            c[i].radius = r;
        }
        
        for (int j=0; j<c.length; j++) {
            System.out.println(c[j].name + " with area = " + c[j].area());
            // Insira aqui código que imprime o perímetro do circulo.
            //
            //
        }
    }
}

 