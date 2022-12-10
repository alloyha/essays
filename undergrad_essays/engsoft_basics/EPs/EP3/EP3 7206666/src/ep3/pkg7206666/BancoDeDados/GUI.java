package ep3.pkg7206666.BancoDeDados;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends Frame implements ActionListener{
    
    // Dimensoes do Frame de Trabalho
    public static final int LARGURA=1000;
    public static final int ALTURA=300;
    
    // Componentes do Frame
    
    // Campo selecionável para selecionar se quer 
    // mesclar o atual Banco de Dados à outro a ser
    // carregado ou não
    private Checkbox ArqEscolha;
    
    // Caixa de diálogo de remoção e busca de alunos
    private Dialog CaixaDeDialogoRmveBsc;
    
    // Botões da caixa de Diálogo OK e Cancelar
    private Button 
            BotaoOKDialogoBusca,
            BotaoOKDialogoRemocao,
            BotaoCancelDialogo;
    
    // Campo de Texto para inserção do N USP do Aluno a ser deletado
    private TextField
            CaixaTextoDialogo;
    
    // Campos de Texto para inserção de dados do aluno
    private TextField
            CaixaInsereNome,
            CaixaInsereNomeDoMeio,
            CaixaInsereSobrenome,
            CaixaInsereNUSP,
            CaixaInsereEndereco,
            CaixaInsereComplemento,
            CaixaInsereCEP;
    
    // Botões para efetuar alguma operação com/no Banco de Dados
    private Button 
            BotaoIniciar,
            BotaoCarregar,
            BotaoInserir,
            BotaoRemover,
            BotaoBuscar,
            BotaoAvancar,
            BotaoVoltar,
            BotaoSalvar;
    
    // Área de Texto para emissão de mensagens do Sistema (não editável)
    private TextArea MsgDoSistema;
    
    // Banco de Dados de Alunos
    private BancoDeDadosInfoAluno Database;
    
    // Array com duas posições para inidicar o N USP e índice do aluno
    // mostrado atualmente no TextArea
    private int[] Dados = new int[2];
    
    // Botão para indicar se o Banco de Dados foi inicializado pela primeira vez
    private boolean Iniciar;
    
    // CONSTRUTORES E MÉTODOS
    
    /* public GUI():
	- proposito: Cria um Frame com Título e cor pré-determinados
	- parametros de entrada: nao possui
	- parametros de saida: nao possui
    */ 
    public GUI(){
        super();
        init();
        setTitle("EP3 - Computação para Engenharia Mecatrônica");
        this.setBackground(Color.blue);
        Database = new BancoDeDadosInfoAluno();
        Iniciar = false;
    }
    
    /* public GUI():
	- proposito: Cria um Frame com Título e cor à escolha
	- parametros de entrada: Título e Cor do Frame
	- parametros de saida: nao possui
    */
    public GUI(String tituloAplicacao, Color corAplicacao){
        super();
        init();
        setTitle(tituloAplicacao);
        this.setBackground(corAplicacao);
        Database = new BancoDeDadosInfoAluno();
        Iniciar = false;
    }
    
    /* private void init():
	- proposito: Posiciona componentes do Frame (por meio de GridBagConstraints) e
        atribue as devidas propriedades (cor, tamanho, etc) quando possível;
	- parametros de entrada: não possui
	- parametros de saida: nao possui
    */
    private void init(){
        setSize(LARGURA,ALTURA);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        Panel PainelEsquerdo = new Panel();
        PainelEsquerdo.setBackground(Color.lightGray);
        PainelEsquerdo.setLayout(new GridBagLayout());

        BotaoIniciar = new Button("Iniciar");
        BotaoIniciar.setBackground(Color.lightGray);
        BotaoIniciar.addActionListener(this);
        c.gridx = 0;
        c.gridy = 0;
        PainelEsquerdo.add(BotaoIniciar,c);

        BotaoCarregar = new Button("Carregar");
        BotaoCarregar.setBackground(Color.lightGray);
        BotaoCarregar.addActionListener(this);
        c.gridx = 0;
        c.gridy = 1;
        PainelEsquerdo.add(BotaoCarregar,c);
        
        ArqEscolha = new Checkbox("Mesclar");
        c.gridx = 0;
        c.gridy = 2;
        PainelEsquerdo.add(ArqEscolha,c);

        BotaoSalvar = new Button("Salvar");
        BotaoSalvar.setBackground(Color.lightGray);
        BotaoSalvar.addActionListener(this);
        c.gridx = 0;
        c.gridy = 3;
        PainelEsquerdo.add(BotaoSalvar,c);

        BotaoRemover = new Button("Remover");
        BotaoRemover.setBackground(Color.lightGray);
        BotaoRemover.addActionListener(this);
        c.gridx = 0;
        c.gridy = 4;
        PainelEsquerdo.add(BotaoRemover,c);

        BotaoBuscar = new Button("Buscar");
        BotaoBuscar.setBackground(Color.lightGray);
        BotaoBuscar.addActionListener(this);
        c.gridx = 0;
        c.gridy = 5;
        PainelEsquerdo.add(BotaoBuscar,c);
        
        this.add(PainelEsquerdo,BorderLayout.WEST);

        Panel PainelCentro = new Panel();
        PainelCentro.setBackground(Color.lightGray);
        PainelCentro.setLayout(new GridBagLayout());

        CaixaInsereNome = new TextField(40);
        CaixaInsereNomeDoMeio = new TextField();
        CaixaInsereSobrenome = new TextField();
        CaixaInsereNUSP = new TextField();
        CaixaInsereEndereco = new TextField();
        CaixaInsereComplemento = new TextField();
        CaixaInsereCEP = new TextField();

        CaixaInsereNome.addActionListener(this);
        CaixaInsereNomeDoMeio.addActionListener(this);
        CaixaInsereSobrenome.addActionListener(this);
        CaixaInsereNUSP.addActionListener(this);
        CaixaInsereEndereco.addActionListener(this);
        CaixaInsereComplemento.addActionListener(this);
        CaixaInsereCEP.addActionListener(this);

        CaixaInsereNome.setBackground(Color.white);
        c.gridx = 0;
        c.gridy = 0;
        PainelCentro.add((new Label ("Primeiro Nome: ")),c);
        c.gridx = 1;
        c.gridy = 0;
        PainelCentro.add(CaixaInsereNome,c);

        CaixaInsereNomeDoMeio.setBackground(Color.white);
        c.gridx = 0;
        c.gridy = 1;
        PainelCentro.add((new Label ("Segundo Nome: ")),c);
        c.gridx = 1;
        c.gridy = 1;
        PainelCentro.add(CaixaInsereNomeDoMeio,c);

        CaixaInsereSobrenome.setBackground(Color.white);
        c.gridx = 0;
        c.gridy = 2;
        PainelCentro.add((new Label ("Sobrenome: ")),c);
        c.gridx = 1;
        c.gridy = 2;
        PainelCentro.add(CaixaInsereSobrenome,c);

        CaixaInsereNUSP.setBackground(Color.white);
        c.gridx = 0;
        c.gridy = 3;
        PainelCentro.add((new Label ("Número USP: ")),c);
        c.gridx = 1;
        c.gridy = 3;
        PainelCentro.add(CaixaInsereNUSP,c);

        CaixaInsereEndereco.setBackground(Color.white);
        c.gridx = 0;
        c.gridy = 4;
        PainelCentro.add((new Label ("Endereço: ")),c);
        c.gridx = 1;
        c.gridy = 4;
        PainelCentro.add(CaixaInsereEndereco,c);

        CaixaInsereComplemento.setBackground(Color.white);
        c.gridx = 0;
        c.gridy = 5;
        PainelCentro.add((new Label ("Complemento: ")),c);
        c.gridx = 1;
        c.gridy = 5;
        PainelCentro.add(CaixaInsereComplemento,c);

        CaixaInsereCEP.setBackground(Color.white);
        c.gridx = 0;
        c.gridy = 6;
        PainelCentro.add((new Label ("CEP: ")),c);
        c.gridx = 1;
        c.gridy = 6;
        PainelCentro.add(CaixaInsereCEP,c);

        BotaoInserir = new Button("Inserir");
        BotaoInserir.setBackground(Color.lightGray);
        BotaoInserir.addActionListener(this);
        c.gridx = 2;
        c.gridy = 7;
        c.gridwidth = 1;
        PainelCentro.add(BotaoInserir,c);

        this.add(PainelCentro,BorderLayout.CENTER);

        Panel PainelDireito = new Panel();
        PainelDireito.setBackground(Color.lightGray);
        PainelDireito.setLayout(new GridBagLayout());

        MsgDoSistema = new TextArea();
        MsgDoSistema.setEditable(false);
        MsgDoSistema.setBackground(Color.white);
        c.gridx = 0;
        c.gridy = 0;
        PainelDireito.add((new Label ("Mensagem do Sistema")),c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 6;
        PainelDireito.add(MsgDoSistema,c);

        BotaoVoltar = new Button("Voltar");
        BotaoVoltar.setBackground(Color.lightGray);
        BotaoVoltar.addActionListener(this);
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        PainelDireito.add(BotaoVoltar,c);

        BotaoAvancar = new Button("Avançar");
        BotaoAvancar.setBackground(Color.lightGray);
        BotaoAvancar.addActionListener(this);
        c.gridx = 4;
        c.gridy = 4;
        c.gridwidth = 1;
        PainelDireito.add(BotaoAvancar,c);

        this.add(PainelDireito,BorderLayout.EAST);

        //trata o evento de fechamento da janela
        addWindowListener(
            new WindowAdapter(){
            @Override
                public void windowClosing(WindowEvent e){
                    System.exit(0);}});
    }

   /* public void actionPerformed():
	- proposito: Tratar evento ocorrido no Frame, de acordo com o componente à 
        que ele está associado (botão "Buscar" abre caixa de diálogo respectivo,
        botão "Carregar" abre janela para acessar o arquivo a ser carregado, etc);
	- parametros de entrada: evento que ocorreu na janela (clicar em um botão, 
        digitar em um campo de texto, etc)
	- parametros de saida: nao possui
    */
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(BotaoIniciar)){
            Database.ResetaBancoDeDados();
            MsgDoSistema.setText("Banco de Dados Inicializado com Sucesso");
            Iniciar = true;
        }
        
        else if(e.getSource().equals(BotaoCarregar)){
            if(Iniciar){
                String FileName;
                boolean ans;
            
                if(!(ArqEscolha.getState())) Database = new BancoDeDadosInfoAluno();
            
                FileName = CarregaArq( this, "Abrir Arquivo", ".\\", "*.txt");
                ans = Database.ImportaBancoDeDados(FileName);
                        
                if(ans) MsgDoSistema.setText("Importação realizada com Sucesso");
                else MsgDoSistema.setText("Erro ao tentar carregar o Banco De Dados");}
            else MsgDoSistema.setText("É necessário iniciar um Banco de Dados");
            
        }
        
        else if(e.getSource().equals(BotaoSalvar)){
            
            if(Iniciar){
                String FileName;
                boolean ans;

                FileName = SalvaArq( this, "Salvar Arquivo", ".\\", "*.txt");

                ans = Database.ExportaBancoDeDados(FileName);

                if(ans) MsgDoSistema.setText("Exportação realizada com Sucesso");
                else MsgDoSistema.setText("Erro ao tentar salvar o Banco De Dados");}
            
            else MsgDoSistema.setText("É necessário iniciar um Banco de Dados");
        }
        
        else if(e.getSource().equals(BotaoRemover)){
            if(Iniciar) CaixaDialogo(false);
            else MsgDoSistema.setText("É necessário iniciar um Banco de Dados");
            
        }
        
        else if(e.getSource().equals(BotaoBuscar)){
            if(Iniciar) CaixaDialogo(true);
            else MsgDoSistema.setText("É necessário iniciar um Banco de Dados");
        }
        
        else if(e.getSource().equals(BotaoInserir)){
            if(Iniciar){
                try{
                    Database.InsereAluno(CaixaInsereNome.getText(),
                                        CaixaInsereNomeDoMeio.getText(),
                                        CaixaInsereSobrenome.getText(),
                                        CaixaInsereNUSP.getText(),
                                        CaixaInsereEndereco.getText(),
                                        CaixaInsereComplemento.getText(),
                                        CaixaInsereCEP.getText());
                    MsgDoSistema.setText("Inserção realizada com Sucesso");

                    CaixaInsereNome.setText(null);
                    CaixaInsereNomeDoMeio.setText(null);
                    CaixaInsereSobrenome.setText(null);
                    CaixaInsereNUSP.setText(null);
                    CaixaInsereEndereco.setText(null);
                    CaixaInsereComplemento.setText(null);
                    CaixaInsereCEP.setText(null);
                }
                catch(NumberFormatException exc){
                    MsgDoSistema.setText("Campos de inserção vazios ou "
                                        +"campo \"Número USP\" não-número");
                }
            }
            else MsgDoSistema.setText("É necessário iniciar um Banco de Dados");
        }
        
        else if(e.getSource().equals(BotaoVoltar)){
            if(Iniciar){
                try{
                    InfoAluno AlunoAtual;
                    Dados = Database.Percorrer(Dados[1],-1);
                    MsgDoSistema.setText("Deu certo");
                    AlunoAtual = Database.BuscaAluno(Integer.toString(Dados[0]));

                    MsgDoSistema.setText("Primeiro Nome: "+AlunoAtual.GetNome()+"\n"+
                                         "Segundo Nome: "+AlunoAtual.GetNMeio()+"\n"+
                                         "Sobrenome: "+AlunoAtual.GetNSobrenome()+"\n"+
                                         "Numero USP: "+AlunoAtual.GetNUSP()+"\n"+
                                         "Endereço: "+AlunoAtual.GetEndereco()+"\n"+
                                         "Complemento: "+AlunoAtual.GetComplemento()+"\n"+
                                         "CEP: "+AlunoAtual.GetCEP());}
                    catch(ArrayIndexOutOfBoundsException exc){
                    MsgDoSistema.setText("Insira/carregue alunos no Banco de Dados");
                }
            }
            else{MsgDoSistema.setText("É necessário iniciar um Banco de Dados");}
            
        }
        
        else if(e.getSource().equals(BotaoAvancar)){
            if(Iniciar){
                try{
                    InfoAluno AlunoAtual;
                    Dados = Database.Percorrer(Dados[1],1);
                    AlunoAtual = Database.BuscaAluno(Integer.toString(Dados[0]));

                    MsgDoSistema.setText("Primeiro Nome: "+AlunoAtual.GetNome()+"\n"+
                                        "Segundo Nome: "+AlunoAtual.GetNMeio()+"\n"+
                                        "Sobrenome: "+AlunoAtual.GetNSobrenome()+"\n"+
                                        "Numero USP: "+AlunoAtual.GetNUSP()+"\n"+
                                        "Endereço: "+AlunoAtual.GetEndereco()+"\n"+
                                        "Complemento: "+AlunoAtual.GetComplemento()+"\n"+
                                        "CEP: "+AlunoAtual.GetCEP());}
                catch(ArrayIndexOutOfBoundsException exc){
                    MsgDoSistema.setText("Insira/carregue alunos no Banco de Dados");
                }
            }
            else MsgDoSistema.setText("É necessário iniciar um Banco de Dados");
        }
        
        else if(e.getSource().equals(BotaoOKDialogoRemocao)){
           try{
                boolean ans;            
                ans = Database.RemoveAluno(CaixaTextoDialogo.getText());
                if(ans) MsgDoSistema.setText("Deleção realizada com Sucesso");
                else MsgDoSistema.setText("O Aluno solicitado não existe no Banco de Dados");
                CaixaDeDialogoRmveBsc.dispose();
                CaixaDeDialogoRmveBsc = null;
            }
            catch(NumberFormatException exc){
                MsgDoSistema.setText("Insira um número USP a ser deletado");
            }
        }
        
        else if(e.getSource().equals(BotaoOKDialogoBusca)){
            try{
              InfoAluno AlunoBuscado = new InfoAluno();
                AlunoBuscado = Database.BuscaAluno(CaixaTextoDialogo.getText());
                if(AlunoBuscado != null){
                    Dados[1] = Database.IndiceBusca(Integer.valueOf(AlunoBuscado.GetNUSP()));
                    MsgDoSistema.setText("Primeiro Nome: "+AlunoBuscado.GetNome()+"\n"+
                                         "Segundo Nome: "+AlunoBuscado.GetNMeio()+"\n"+
                                         "Sobrenome: "+AlunoBuscado.GetNSobrenome()+"\n"+
                                         "Numero USP: "+AlunoBuscado.GetNUSP()+"\n"+
                                         "Endereço: "+AlunoBuscado.GetEndereco()+"\n"+
                                         "Complemento: "+AlunoBuscado.GetComplemento()+"\n"+
                                         "CEP: "+AlunoBuscado.GetCEP());
                }
                else{MsgDoSistema.setText("O Aluno solicitado não existe no Banco de Dados");}
                CaixaDeDialogoRmveBsc.dispose();
                CaixaDeDialogoRmveBsc = null;
            }
            catch(NumberFormatException exc){
                MsgDoSistema.setText("Insira um número USP a ser buscado");
            }
        }
        
        else if(e.getSource().equals(BotaoCancelDialogo)){
            CaixaDeDialogoRmveBsc.dispose();
            CaixaDeDialogoRmveBsc = null;
        }
    }
    
    /* public void CaixaDialogo():
	- proposito: gerar caixa de diálogo para busca ou deleção de alunos;
        - parametros de entrada: variável booleana identificando se a caixa de
        diálogo é de Busca ou Remoção
	- parametros de saida: nao possui
    */
    public void CaixaDialogo(boolean x){
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        
        CaixaDeDialogoRmveBsc = new Dialog(this);
        if(x) CaixaDeDialogoRmveBsc.setTitle("Busca");
        else CaixaDeDialogoRmveBsc.setTitle("Remoção");
        CaixaDeDialogoRmveBsc.setSize(300,120);
        CaixaDeDialogoRmveBsc.setLayout(new BorderLayout());
        
        Panel PainelBotoes = new Panel();
        PainelBotoes.setLayout(new GridBagLayout());
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        
        if(x){
            BotaoOKDialogoBusca = new Button("OK");
            BotaoOKDialogoBusca.addActionListener(this);
            PainelBotoes.add(BotaoOKDialogoBusca,c);
        }else{
            BotaoOKDialogoRemocao = new Button("OK");
            BotaoOKDialogoRemocao.addActionListener(this);
            PainelBotoes.add(BotaoOKDialogoRemocao,c);}
        
        BotaoCancelDialogo = new Button("Cancelar");
        BotaoCancelDialogo.addActionListener(this);
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 1;
        PainelBotoes.add(BotaoCancelDialogo,c);
               
        Panel PainelTexto = new Panel();
        CaixaTextoDialogo = new TextField(8);

        c.gridx = 0;
        c.gridy = 0;
        PainelTexto.add((new Label ("Número USP:  ")),c);
        c.gridx = 1;
        c.gridy = 0;
        PainelTexto.add(CaixaTextoDialogo,c);     
        
        CaixaDeDialogoRmveBsc.add(PainelTexto,BorderLayout.NORTH);
        CaixaDeDialogoRmveBsc.add(PainelBotoes,BorderLayout.CENTER);
        
        CaixaDeDialogoRmveBsc.setVisible(true);
        CaixaDeDialogoRmveBsc.addWindowListener(new WindowAdapter(){
            @Override
        public void windowClosing(WindowEvent e){
        CaixaDeDialogoRmveBsc.dispose();
        CaixaDeDialogoRmveBsc = null;}});      
    }
    
    /* public String CarregaArq():
	- proposito: gerar caixa de diálogo para carregar um banco de dados externo;
        - parametros de entrada: Frame em que será aberto, título do Diálogo, diretório
        de carregamento e tipo de arquivo importado;
	- parametros de saida: diretório do arquivo
    */
    public String CarregaArq(Frame f, String title, String defDir, String fileType){
        FileDialog fd = new FileDialog(f, title, FileDialog.LOAD);
        fd.setFile(fileType);
        fd.setDirectory(defDir);
        fd.setLocation(50, 50);
        fd.show();
        return fd.getDirectory() + 
               fd.getFile();
    }
    
    /* public String CarregaArq():
	- proposito: gerar caixa de diálogo para salvar um banco de dados externo;
            - parametros de entrada: Frame em que será aberto, título do Diálogo, diretório
            de carregamento e tipo de arquivo a ser salvo;
	- parametros de saida: diretório do arquivo
    */
    protected String SalvaArq(Frame f, String title, String defDir, String fileType) {
        FileDialog fd = new FileDialog(f, title,  FileDialog.SAVE);
        fd.setFile(fileType);
        fd.setDirectory(defDir);
        fd.setLocation(50, 50);
        fd.setVisible(true);
        return fd.getDirectory() + 
               fd.getFile();
    }  
}

