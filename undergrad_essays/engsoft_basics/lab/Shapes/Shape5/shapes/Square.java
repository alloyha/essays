/**
 * ShapeTest versao 5 - PMR2300
 * Square
 * Departamento de Engenharia Mecatronica e de Sistemas Mecanicos
 * Escola Politecnica, Universidade de Sao Paulo
 * Autor: Fabio Gagliardi Cozman
 */

package shapes;

public class Square extends Shape implements Area {
        private double side;

        // Default: inicia lado com 1.0.
        public Square(String n) {
            super(n);
            side = 1.0;
        }
        
        // Construtor com inicialização.
        public Square(String n, double s) {
            super(n);
            side = s;
        }
        
        // Accessors.
        public void setSide(double s) { side = s; }
        public double getSide() { return(side); }

        /**
         * Calcula a area de um Square.
         */
        public double area() {
            return(side * side);
        }

        /**
         * Imprime uma mensagem sobre o Square.
         */
        public void print() {
            System.out.println("Square is called " + name +   
                               " with area " + area() );
        }
}
