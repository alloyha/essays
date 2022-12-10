/*	PMR2300 - Computacao para Mecatronica
 *	Aluno	: Bruno Henrique Lobo Netto Peixoto
 *	Nusp	: 7206666
 */

import java.io.*;
import java.text.DecimalFormat;

public class EP2{

public static void main(String[] args) throws IOException{

	// Strings de entrada
	String
	FileName, 	// Nome do arquivo de leitura/escrita
	SearchName, // Nome do aluno buscado
	DelName;	// Nome do aluno a ser deletado

	// Opcao do menu
	int option = 1;

	// Resposta dos metodos da classe BancoDeDadosInfoAluno
	Boolean
	InsAnswer, // InsereAluno
	DelAnswer, // DeletaAluno
	ImpAnswer, // FileImport
	ExpAnswer; // FileExport

	// Banco de Dados
	BancoDeDadosInfoAluno Database = new BancoDeDadosInfoAluno();

	// Atributos do aluno a ser inserido
	String inpnomedoaluno, inpnusp;
	double
	inpP1, 	// Nota da prova 1
	inpP2, 	// Nota da prova 2
	inpEP1,	// Nota do EP1
	inpEP2,	// Nota do EP2
	inpEP3,	// Nota da EP3
	inpEP4,	// Nota da EP4
	ínpT, 	// Media de provas
	inpL, 	// Media dos EPs
	inpMF; 	// Media Final

	// Media e Desvio-padrao da classe
	double[] meanc = new double[9];
	double[] stddev = new double[9];

	// Metodo q ira fazer a leitura via teclado
	InputStreamReader conversor = new InputStreamReader(System.in);
	BufferedReader 	  teclado 	= new BufferedReader(conversor);

	// Metodo que aproxima com 2 casas
	DecimalFormat aproximador = new DecimalFormat("0.00");

	// Cabecalho do Exercicio-programa
	System.out.println("+---------------------------------------------------------------+");
	System.out.println("|            PMR2300 - Computacao para Mecatronica              |");
	System.out.println("|                       Banco de Dados                          |");
	System.out.println("+---------------------------------------------------------------+\n");

	// Menu Principal
	while(option!=6){

		// Menu
		System.out.println("+----------------------- Opcoes --------------------------------+");
		System.out.println("|                                                               |");
		System.out.println("| 0 - Inserir aluno manualmente                                 |");
		System.out.println("| 1 - Remover aluno                                             |");
		System.out.println("| 2 - Buscar aluno                                              |");
		System.out.println("| 3 - Leitura da base de dados de um arquivo externo            |");
		System.out.println("| 4 - Escrita da base de dados em um arquivo externo            |");
		System.out.println("| 5 - Impressao do relatorio na tela                            |");
		System.out.println("| 6 - Finalizar execucao                                        |");
		System.out.println("|                                                               |");
		System.out.println("+---------------------------------------------------------------+");
		System.out.print("Insira a opcao desejada: ");
		try{
			option = Integer.parseInt(teclado.readLine());
		}
		catch(IOException e){
			System.out.println("Insira uma opcao valida!\n");
		}

		System.out.println();

		// Opcoes do Menu
		switch(option){

			case 0 :
			// Insercao de aluno

				// Dados do aluno a ser inserido
				System.out.println("Insira os dados do aluno a ser inserido.\n");
				System.out.print("\tNome : ");
				inpnomedoaluno = teclado.readLine();
				System.out.print("\tN USP : ");
				inpnusp = teclado.readLine();
				System.out.print("\tP1 : ");
				inpP1 = Double.parseDouble(teclado.readLine());
				System.out.print("\tP2 : ");
				inpP2 = Double.parseDouble(teclado.readLine());
				System.out.print("\tEP1 : ");
				inpEP1 = Double.parseDouble(teclado.readLine());
				System.out.print("\tEP2 : ");
				inpEP2 = Double.parseDouble(teclado.readLine());
				System.out.print("\tEP3 : ");
				inpEP3 = Double.parseDouble(teclado.readLine());
				System.out.print("\tEP4 : ");
				inpEP4 = Double.parseDouble(teclado.readLine());
				System.out.println();

				// Insercao do aluno no Banco de Dados
				// 		Caso tenha sucedido tudo bem, InsAnswer==true
				// 		Caso não, entra em algum dos IOException da Class InsereAluno()
				// 		e InsAnswer==false
				InsAnswer = Database.InsereAluno(inpnomedoaluno,inpnusp,inpP1,
				inpP2,inpEP1,inpEP2,inpEP3,inpEP4);

				if(InsAnswer) System.out.println("Insercao realizada com sucesso!\n");

			break;

			case 1 :
			// Delecao de alunos

			//Solicita o nome do aluno a ser deletado
			System.out.print("Insira o nome do aluno a ser deletado: ");
			DelName = teclado.readLine();
			System.out.println();

			// Delecao do aluno do Banco de Dados
			// 		Caso tenha sucedido tudo bem, DelAnswer==true e o aluno e'
			// deletado do banco de dados
			// 		Caso não, DelAnswer==false e não existe tal aluno no banco
			// de dados
			DelAnswer = Database.DeletaAluno(DelName);

			if(DelAnswer) System.out.println("Delecao realizada com sucesso!\n");
			else System.out.println(DelName+" nao foi encontrado no Banco de Dados");

			break;

			case 2 :
			// Busca de alunos

			// Solicitacao do nome do arquivo que contem os dados de leitura
			System.out.print("Insira o nome do aluno buscado: ");
			SearchName = teclado.readLine();
			System.out.println();

			// Busca Aluno no Banco de Dados
			Database.SearchAluno(SearchName);

			break;

			case 3 :
			// Leitura da base de dados de um arquivo externo

			// Solicitacao do nome do arquivo que contem os dados de leitura
			System.out.print("Insira o nome do arquivo de leitura: ");
			FileName = teclado.readLine();
			System.out.println();

			// Importacao do Banco de Dados de um arquivo externo
			// 		Caso tenha sucedido tudo bem, ImpAnswer==true e o banco de
			// dados foi importado com sucesso
			// 		Caso não, ImpAnswer==false e ocorreu algum erro na importacao,
			// seja na abertura do arquivo ou que o banco de dados atingiu seu
			// limite máximo de alunos
			ImpAnswer = Database.FileImport(FileName);

			if(ImpAnswer) System.out.println("Importacao realizada com sucesso!\n");

			break;

			case 4 :
			// Escrita da base de dados em um arquivo externo

			// Solicitacao do nome do arquivo a ser escrito
			System.out.print("Insira o nome do arquivo de escrita: ");
			FileName = teclado.readLine();
			System.out.println();

			// Importacao do Banco de Dados de um arquivo externo
			// 		Caso tenha sucedido tudo bem, ExpAnswer==true e o banco de
			// dados foi exportado com sucesso
			// 		Caso não, ImpAnswer==false e ocorreu algum erro na exportacao,
			// capturada pelo try catch do método FileExport()
			ExpAnswer = Database.FileExport(FileName);

			if(ExpAnswer) System.out.println("Exportacao realizada com sucesso!\n");

			break;

			case 5 :
			// Impressao do banco de Dados e relatório na tela

			// Impressao do Banco de Dados
			System.out.println("+--------------------- Banco de dados --------------------------+\n");

			for(int i = 0; i<Database.NumeroDeAlunos;i++)
				Database.PrintAluno(i);

			System.out.print("+---------------------------------------------------------------+\n");

			meanc = Database.ClassMean();
			stddev = Database.ClassStdDev(meanc);

			// Impressao do Relatorio de Notas
			System.out.print("+--------------------- Relatorio Final -------------------------+");

			System.out.println("\nProvas:");
			System.out.println("        Medias : <P1> "+aproximador.format(meanc[0])+
											  "; <P2> "+aproximador.format(meanc[1]));
			System.out.println(" Desvio-Padrao : <P1> "+aproximador.format(stddev[0])+
											  "; <P2> "+aproximador.format(stddev[1])+"\n");

			System.out.println("Exercicios");
			System.out.println("        Medias : <EP1> "+aproximador.format(meanc[2])+
											  "; <EP2> "+aproximador.format(meanc[3])+
											  "; <EP3> "+aproximador.format(meanc[4])+
											  "; <EP4> "+aproximador.format(meanc[5]));
			System.out.println(" Desvio-Padrao : <EP1> "+aproximador.format(stddev[2])+
											  "; <EP2> "+aproximador.format(stddev[3])+
											  "; <EP3> "+aproximador.format(stddev[4])+
											  "; <EP4> "+aproximador.format(stddev[5])+"\n");

			System.out.println("Notas Finais");
			System.out.println("        Medias : <T> "+aproximador.format(meanc[6])+
											  "; <L> "+aproximador.format(meanc[7])+
											  "; <MF> "+aproximador.format(meanc[8]));
			System.out.println(" Desvio-Padrao : <T> "+aproximador.format(stddev[6])+
											  "; <L> "+aproximador.format(stddev[7])+
											  "; <MF> "+aproximador.format(stddev[8])+"\n");

			System.out.print("+---------------------------------------------------------------+\n");

			break;

			// Finalizar execucao do programa
			case 6 :
			System.out.println("+----------------------- Fim de execucao -----------------------+\n");
			break;

			default:
			System.out.println("Insira uma opcao valida!\n");
			break;
		}

	}

}
}