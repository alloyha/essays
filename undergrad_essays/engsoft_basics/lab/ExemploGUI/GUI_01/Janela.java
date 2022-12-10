import java.awt.*;
import java.awt.event.*;


public class Janela extends Frame{
	public static final int LARGURA=640;
	public static final int ALTURA=480;

	//construtor sem parametros da classe Janela
	public Janela(){
		//chama o construtor da classe pai, no caso, a classe JFrame
		super();
		//inicializa o frame
		init();
		//estabelece um nome padrao para a janela
		setTitle("Janela Padrao");
		//estabelece uma cor padrao para o fundo da janela
		this.setBackground(Color.blue);
	}

	//construtor "sobrecarregado" com parametros (titulo da janela e cor de fundo da janela)
	//da classe Janela
	public Janela(String tituloAplicacao, Color corAplicacao){
		//chama o construtor da classe pai, no caso a classe JFrame
		super();
		//inicializa a classe Janela
		init();
		//determina o titulo da janela (informado pelo usuario)
		setTitle(tituloAplicacao);
		//determina a cor de fundo da janela (informada pelo usuario)
		this.setBackground(corAplicacao);
	}

	//Metodo que inicializa a Janela, posicionando os seus componentes
	private void init(){
		//determina o tamanho da janela
		setSize(LARGURA,ALTURA);

        /** Tratamento do evento de fechamento da janela*/
		addWindowListener(new WindowAdapter(){ public void windowClosing(
			              WindowEvent e){System.exit(0);}});
		/**/
	}

}
