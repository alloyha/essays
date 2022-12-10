import java.awt.*;
import java.awt.event.*;


public class Janela extends Frame implements ActionListener{
	public static final int LARGURA=640;
	public static final int ALTURA=480;

	private TextArea ta;


	//caixa de dialogo para entrada de parametros da reta
	private Dialog caixaDeDialogoReta;
	private Button botaoOKDialogoReta;
	private Button botaoCancelaDialogoReta;
	private TextField parametroRetaA;
	private TextField parametroRetaB;



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

		ta = new TextArea();
		this.add(ta,BorderLayout.CENTER);

		//cria painel onde serao posicionados os botoes
		Panel painelDeBotoes = new Panel();
		//determina a cor de fundo do painel de botoes
		painelDeBotoes.setBackground(Color.lightGray);
		//adiciona o painel de botoes na porcao SUL da janela
		this.add(painelDeBotoes,BorderLayout.SOUTH);

		//escolhe o leioute para o painel de botoes
		painelDeBotoes.setLayout( new FlowLayout());


		//cria botao
		Button botaoNovo = new Button("Novo Botao");
		//estabelece a cor de fundo do botao
		botaoNovo.setBackground(Color.lightGray);
		//adiciona o botao ao painel de botoes
		painelDeBotoes.add(botaoNovo);

		//cria botao
		Button botaoOutro = new Button("Outro Botao");
		//estabelece a cor de fundo do botao
		botaoOutro.setBackground(Color.red);
		//adiciona o botao ao painel de botoes
		painelDeBotoes.add(botaoOutro);

		//adiciona o listener para o botao - necessario para tratar evento de clique do mouse
		botaoNovo.addActionListener(this);
		botaoOutro.addActionListener(this);

        /** Tratamento do evento de fechamento da janela*/
		addWindowListener(new WindowAdapter(){ public void windowClosing(
			              WindowEvent e){System.exit(0);}});
		/**/
	}


	//tratamento dos eventos - botoes
	public void actionPerformed(ActionEvent e)
	{

		//eventos relacionados ao Novo Botao
		if(e.getActionCommand().equals("Novo Botao")){
			System.out.println("Novo Botao foi pressionado");
			ta.appendText("Novo Botao foi pressionado\n");
		//eventos relacionados ao Outro Botao
		} else if (e.getActionCommand().equals("Outro Botao")){
			System.out.println("Outro Botao foi pressionado");
			NovaReta();
		} else if (e.getSource().equals(botaoOKDialogoReta)) {
			ta.appendText("Reta: f(x) = "+ parametroRetaA.getText() + "*x + " + parametroRetaB.getText() + "\n");
			caixaDeDialogoReta.dispose();
			caixaDeDialogoReta = null;
		} else if (e.getSource().equals(botaoCancelaDialogoReta)) {
			caixaDeDialogoReta.dispose();
			caixaDeDialogoReta = null;
		} else {
			System.out.println("OHOH");
		}

	}


	public void NovaReta(){
		caixaDeDialogoReta = new Dialog(this);
		caixaDeDialogoReta.setSize(300,100);
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


}
