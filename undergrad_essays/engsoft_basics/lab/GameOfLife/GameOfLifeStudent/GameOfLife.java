/**
 * GameOfLife - PMR2300
 * Departamento de Engenharia Mecatronica e de Sistemas Mecanicos
 * Escola Politecnica, Universidade de Sao Paulo
 * Autor: Fabio G. Cozman, Marcos R. P. Barretto
 */

import java.io.*;

public class GameOfLife {
    
    public static void main(String args[]) {
        int i, j;
        int numberOfCells = 10;
        boolean matrix[][];
        
        // Leia parametros da linha de comando.
        int numberIterations = 3;
        if (args.length > 0)
            numberIterations = Integer.parseInt(args[0]);
            
        // Anuncie programa.
        System.out.println("Game of Life");
        System.out.println("PMR2300");
        
        // Crie matriz inicial.
        matrix = inicia(numberOfCells);
        show(matrix);
        
        // Itere pelo algoritmo.
        System.out.println("Tecle ENTER para iniciar:");
        waitForEnter();
        for (i=0; i<numberIterations; i++) {
            // Faca a nova iteracao (aplique regras).
            matrix = iterate(matrix);
            show(matrix);
            System.out.println("Nova iteracao (tecle ENTER).");            
            // Espere usuario teclar Enter.
            waitForEnter();
        }
    }
    
    static boolean[][] inicia(int numberOfCells) {
        boolean matrix[][] = new boolean[numberOfCells][numberOfCells];
        matrix[3][3] = true;
        matrix[3][4] = true;
        matrix[3][5] = true;
        return(matrix);
    }
        
    static void show(boolean matrix[][]) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++)
                System.out.print(" "+matrix[i][j]+" ");
            System.out.println();
        }
        System.out.println();
    }    
    
    /*
     * Calcula a nova geracao em uma outra
     * matriz e copia a nova matriz para a matriz.
     */
    static boolean[][] iterate(boolean matrix[][]) {
        int i, j;
        boolean nextMatrix[][] =
            new boolean[matrix.length][matrix[0].length];
        // Aplica regras em todos os elementos.
        for (i=1; i<(matrix.length-1); i++) {
            for (j=1; j<(matrix.length-1); j++) {
                nextMatrix[i][j] = updateCell(matrix, i, j);
            }
        }
        return(nextMatrix);
    }
        
    /*
     * Usa as regras do Game of Life para determinar
     * se uma celula vai sobreviver ou nao.
     */
    static boolean updateCell(boolean matrix[][], int row, int col) {
         if (matrix[row][col] == true)
            return(false);
         else 
            return(true);
    }
    
    /*** IGNORE O SEGUINTE CODIGO: *****/
    static java.io.BufferedReader in = 
                new java.io.BufferedReader(
                    new java.io.InputStreamReader(System.in));
    static void waitForEnter() {
        System.out.println("Para prosseguir, digite [Enter].");
        try {
            in.readLine();           
        } catch (IOException e) { }
    }
    /***********************************/
}

