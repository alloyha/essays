//import javax.swing.JFrame;
//import javax.swing.*;


import java.awt.event.*;
import java.awt.*;

/*
 * Created on 15/03/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author fktakase
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */



public class FrameGrafico extends Frame implements ActionListener{
	public static final int LARGURA=640;
	public static final int ALTURA=480;

	//caixa de dialogo para entrada de parametros da reta
	private Dialog caixaDeDialogoReta;
	private Button botaoOKDialogoReta;
	private Button botaoCancelaDialogoReta;
	private TextField parametroRetaA;
	private TextField parametroRetaB;

	//caixa de dialogo para entrada de parametros da parabola
	private Dialog caixaDeDialogoParabola;
	private Button botaoOKDialogoParabola;
	private Button botaoCancelaDialogoParabola;
	private TextField parametroParabolaA;
	private TextField parametroParabolaB;
	private TextField parametroParabolaC;


	private PainelDePlotagem pp;


	//construtor sem parametros da classe FrameGrafico
	public FrameGrafico(){
		//chama o construtor da classe pai, no caso, a classe JFrame
		super();
		//inicializa o frame
		init();
		//estabelece um nome padrao para a janela
		setTitle("Nome Padrao");
		//estabelece uma cor padrao para o fundo da janela
		this.setBackground(Color.blue);
	}

	//construtor "sobrecarregado" com parametros (titulo da janela e cor de fundo da janela)
	//da classe FrameGrafico
	public FrameGrafico(String tituloAplicacao, Color corAplicacao){
		//chama o construtor da classe pai, no caso a classe JFrame
		super();
		//inicializa a classe FrameGrafico
		init();
		//determina o titulo da janela (informado pelo usuario)
		setTitle(tituloAplicacao);
		//determina a cor de fundo da janela (informada pelo usuario)
		this.setBackground(corAplicacao);
	}

	//Metodo que inicializa o FrameGrafico, posicionando os seus componentes
	private void init(){
		//determina o tamanho da janela
		setSize(LARGURA,ALTURA);

		//cria painel onde serao posicionados os botoes
		Panel painelDeBotoes = new Panel();
		//determina a cor de fundo do painel de botoes
		painelDeBotoes.setBackground(Color.lightGray);
		//escolhe o leioute para o painel de botoes
		painelDeBotoes.setLayout( new FlowLayout());

		//cria o botao para retas
		Button botaoReta = new Button("Nova Reta");
		//determina a cor de fundo do botao de retas
		botaoReta.setBackground(Color.lightGray);
		//adiciona o listener para o botao - necessario para tratar evento de clique do mouse
		botaoReta.addActionListener(this);
		//adiciona o botao de retas no painel de botoes
		painelDeBotoes.add(botaoReta);

		//cria botao para parabolas
		Button botaoParabola = new Button("Nova Parabola");
		//estabelece a cor de fundo do botao
		botaoParabola.setBackground(Color.lightGray);
		//adiciona o listener para o botao - necessario para tratar evento de clique do mouse
		botaoParabola.addActionListener(this);
		//adiciona o botao de parabolas ao painel de botoes
		painelDeBotoes.add(botaoParabola);

		//adiciona o painel de botoes na porcao SUL do frame grafico
		this.add(painelDeBotoes,BorderLayout.SOUTH);

		//cria uma instancia do painel de plotagem
		pp = new PainelDePlotagem();
		//adiciona o painel de plotagem no centro do frame grafico
		this.add(pp,BorderLayout.CENTER);

	    //trata o evento de fechamento da janela
		addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){System.exit(0);}});
	}

	//tratamento dos eventos - botoes
	public void actionPerformed(ActionEvent e)
	{
		//Container contentPane = getContentPane();

		//eventos relacionados a Reta
		if(e.getActionCommand().equals("Nova Reta")){
			NovaReta();
		} else if (e.getSource().equals(botaoOKDialogoReta)) {
			pp.adicionaFuncao(new Reta(Integer.parseInt(parametroRetaA.getText()),Integer.parseInt(parametroRetaB.getText())),Color.BLUE );
			caixaDeDialogoReta.dispose();
			caixaDeDialogoReta = null;
		} else if (e.getSource().equals(botaoCancelaDialogoReta)) {
			caixaDeDialogoReta.dispose();
			caixaDeDialogoReta = null;

		//eventos relacionados a Parabola
		} else if (e.getActionCommand().equals("Nova Parabola")){
			NovaParabola();
		} else if (e.getSource().equals(botaoOKDialogoParabola)) {
			pp.adicionaFuncao(new Parabola(Integer.parseInt(parametroParabolaA.getText()),Integer.parseInt(parametroParabolaB.getText()),Integer.parseInt(parametroParabolaC.getText())),Color.BLUE );
			caixaDeDialogoParabola.dispose();
			caixaDeDialogoParabola = null;
		} else if (e.getSource().equals(botaoCancelaDialogoParabola)) {
			caixaDeDialogoParabola.dispose();
			caixaDeDialogoParabola = null;
		} else {
			System.out.println("OHOH");
		}

	}
	public void NovaReta(){
		caixaDeDialogoReta = new Dialog(this);
		caixaDeDialogoReta.setSize(200,100);
		caixaDeDialogoReta.setTitle("Parametros da Linha");
		caixaDeDialogoReta.setLayout(new BorderLayout());

	    Panel painelDeBotaoReta = new Panel();
	    botaoOKDialogoReta = new Button("OK");
	    botaoOKDialogoReta.addActionListener(this);
	    painelDeBotaoReta.add(botaoOKDialogoReta);

	    botaoCancelaDialogoReta = new Button("Cancela");
	    botaoCancelaDialogoReta.addActionListener(this);
	    painelDeBotaoReta.add(botaoCancelaDialogoReta);
	    caixaDeDialogoReta.add(painelDeBotaoReta,BorderLayout.SOUTH);

	    parametroRetaA = new TextField(1);
	    parametroRetaB = new TextField(1);

	    Panel painelParametrosReta = new Panel();
	    painelParametrosReta.setLayout(new FlowLayout());
	    painelParametrosReta.add(new Label("f(x)= "));
	    painelParametrosReta.add(parametroRetaA);
	    painelParametrosReta.add(new Label("*x + "));
	    painelParametrosReta.add(parametroRetaB);
	    caixaDeDialogoReta.add(painelParametrosReta,BorderLayout.CENTER);

	    caixaDeDialogoReta.setVisible(true);
	}

	public void NovaParabola(){
		caixaDeDialogoParabola = new Dialog(this);
		caixaDeDialogoParabola.setSize(200,100);
		caixaDeDialogoParabola.setTitle("Parametros da Parabola");
		caixaDeDialogoParabola.setLayout(new BorderLayout());

	    Panel painelDeBotaoParabola = new Panel();
	    botaoOKDialogoParabola = new Button("OK");
	    botaoOKDialogoParabola.addActionListener(this);
	    painelDeBotaoParabola.add(botaoOKDialogoParabola);

	    botaoCancelaDialogoParabola = new Button("Cancela");
	    botaoCancelaDialogoParabola.addActionListener(this);
	    painelDeBotaoParabola.add(botaoCancelaDialogoParabola);
	    caixaDeDialogoParabola.add(painelDeBotaoParabola,BorderLayout.SOUTH);

	    parametroParabolaA = new TextField(1);
	    parametroParabolaB = new TextField(1);
	    parametroParabolaC = new TextField(1);

	    Panel painelParametrosParabola = new Panel();
	    painelParametrosParabola.setLayout(new FlowLayout());
	    painelParametrosParabola.add(new Label("f(x)= "));
	    painelParametrosParabola.add(parametroParabolaA);
	    painelParametrosParabola.add(new Label("*x^2 + "));
	    painelParametrosParabola.add(parametroParabolaB);
	    painelParametrosParabola.add(new Label("*x + "));
	    painelParametrosParabola.add(parametroParabolaC);
	    caixaDeDialogoParabola.add(painelParametrosParabola,BorderLayout.CENTER);

	    caixaDeDialogoParabola.setVisible(true);
	}

}
