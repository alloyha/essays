/**
 * ShapeTest versao 3 - PMR2300
 * Shape
 * Departamento de Engenharia Mecatronica e de Sistemas Mecanicos
 * Escola Politecnica, Universidade de Sao Paulo
 * Autor: Fabio Gagliardi Cozman
 */

class Shape {
        static int total = 0; 
        
        String name;
        
        // Default.
        Shape(String n) {
            name = n;
            total ++;
        }
        
        // Método area() simplesmente retorna zero.
        double area() {
            return(0.0);
        }
        
        /**
         * Imprime uma mensagem sobre o Shape.
         */
        void print() {
            System.out.println("Shape is called " + name);
        }
}
