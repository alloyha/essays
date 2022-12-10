/**
 * ShapeTest versao 6 - PMR2300
 * Shape
 * Departamento de Engenharia Mecatronica e de Sistemas Mecanicos
 * Escola Politecnica, Universidade de Sao Paulo
 * Autor: Fabio Gagliardi Cozman
 */

package shapes;

public class Shape {
        static private int total = 0; 
        
        String name;
        
        // Default.
        public Shape(String n) {
            name = n;
            total ++;
        }
        
        // Método area() simplesmente retorna zero.
        public double area() {
            return(0.0);
        }

        // Accessors.
        public void setName(String n) { name = n; }
        public String getName() { return(name); }
        public int getTotal() { return(total); }
        
        /**
         * Imprime uma mensagem sobre o Shape.
         */
        public void print() {
            System.out.println("Shape is called " + name);
        }
}
