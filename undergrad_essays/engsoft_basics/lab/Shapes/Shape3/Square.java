/**
 * ShapeTest versao 3 - PMR2300
 * Square
 * Departamento de Engenharia Mecatronica e de Sistemas Mecanicos
 * Escola Politecnica, Universidade de Sao Paulo
 * Autor: Fabio Gagliardi Cozman
 */

class Square extends Shape {
        double side;

        // Default: inicia lado com 1.0.
        Square(String n) {
            super(n);
            side = 1.0;
        }
        
        // Construtor com inicialização.
        Square(String n, double s) {
            super(n);
            side = s;
        }

        /**
         * Calcula a area de um Square.
         */
        double area() {
            return(side * side);
        }

        /**
         * Imprime uma mensagem sobre o Square.
         */
        void print() {
            System.out.println("Square is called " + name +   
                               " with area " + area() );
        }
}
