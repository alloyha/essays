package ep3.pkg7206666;

import ep3.pkg7206666.BancoDeDados.GUI;
import java.awt.Color;

public class pkg7206666 {
    
    /* public static void main(String[] args):
	- proposito: Cria um objeto do tipo GUI, que é a interface gráfica
        do programa, e nesta são realizadas todas as interações com o usuário;
        - parametros de entrada: array de String 'args' que não será usado 
        neste exercício-programa
	- parametros de saida: nao possui
    */
    public static void main(String[] args) {
        GUI gui = new GUI("EP3 - Bruno Henrique Lobo Netto Peixoto/7206666", Color.white);
	gui.setVisible(true);
    }
}
