/**
 * ShapeTest versao 3 - PMR2300
 * Circle
 * Departamento de Engenharia Mecatronica e de Sistemas Mecanicos
 * Escola Politecnica, Universidade de Sao Paulo
 * Autor: Fabio Gagliardi Cozman
 */

class Circle extends Shape {
        double x, y;
        double radius;
        
        // Default: inicia raio com 1.0.
        Circle (String n) {
            super(n);
            radius = 1.0;
        }
        
        // Construtor com inicializacao completa.
        Circle(String n, double centerX, 
        double centerY, double r) {
            super(n);
            x = centerX;
            y = centerY;
            radius = r;
        }

        /**
         * Metodo que calcula area.
         */
        double area() {
           return(Math.PI * radius * radius);
        }
}
