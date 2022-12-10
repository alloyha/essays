/**
 * ShapeTest versao 4 - PMR2300
 * Circle
 * Departamento de Engenharia Mecatronica e de Sistemas Mecanicos
 * Escola Politecnica, Universidade de Sao Paulo
 * Autor: Fabio Gagliardi Cozman
 */

package shapes;

public class Circle extends Shape {
        private double x, y;
        private double radius;
        
        // Default: inicia raio com 1.0.
        public Circle (String n) {
            super(n);
            radius = 1.0;
        }
        
        // Construtor com inicializacao completa.
        public Circle(String n, double centerX, 
        double centerY, double r) {
            super(n);
            x = centerX;
            y = centerY;
            radius = r;
        }

        // Accessors.
        public void setX(double centerX) { x = centerX; }
        public void setY(double centerY) { y = centerY; }
        public void setRadius(double r) { radius = r; }
        public double getX() { return(x); }
        public double getY() { return(y); }
        public double getRadius() { return(radius); }
        
        /**
         * Metodo que calcula area.
         */
        public double area() {
           return(Math.PI * radius * radius);
        }
}
