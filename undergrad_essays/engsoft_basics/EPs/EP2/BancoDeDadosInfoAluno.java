/*	PMR2300 - Computacao para Mecatronica
 *	Aluno	: Bruno Henrique Lobo Netto Peixoto
 *	Nusp	: 7206666
 */

import java.io.*;
import java.text.DecimalFormat;

public class BancoDeDadosInfoAluno extends Resources{

// NMax e' uma constante
// ou seja voce pode declarar
// o tamanho de vetor que quiser
private final int NMax = 100;

// vetor do tipo InfoAluno
private InfoAluno[] BancoDeDados;

// Numero de alunos ja inseridos
int NumeroDeAlunos;

/*
public BancoDeDadosInfoAluno():
	- proposito: atribui o valor inicial nulo para o numero de alunos
	- parametros de entrada: nao possui
	- parametros de saida: nao possui
*/
public BancoDeDadosInfoAluno(){
	BancoDeDados = new InfoAluno[NMax];
	NumeroDeAlunos=0;
}

/*
public boolean InsereAluno():
	- proposito: Inserir aluno no Banco de Dados
	- parametros de entrada: Dados do aluno (Nome, NUSP, Notas)
	- parametros de saida: true, caso tenha inserido o aluno e
	false caso contrario
*/
public boolean InsereAluno(String inpnomedoaluno, String inpnusp, double inpP1,
double inpP2, double inpEP1, double inpEP2, double inpEP3, double inpEP4){

	if(NumeroDeAlunos < NMax){

		BancoDeDados[NumeroDeAlunos] = new InfoAluno();
		BancoDeDados[NumeroDeAlunos].InsertName(inpnomedoaluno);
		BancoDeDados[NumeroDeAlunos].InsertNUSP(inpnusp);
		BancoDeDados[NumeroDeAlunos].InsertP1(inpP1);
		BancoDeDados[NumeroDeAlunos].InsertP2(inpP2);
		BancoDeDados[NumeroDeAlunos].InsertEP1(inpEP1);
		BancoDeDados[NumeroDeAlunos].InsertEP2(inpEP2);
		BancoDeDados[NumeroDeAlunos].InsertEP3(inpEP3);
		BancoDeDados[NumeroDeAlunos].InsertEP4(inpEP4);
		NumeroDeAlunos++;

		BancoDeDados = alphabetic(BancoDeDados, NumeroDeAlunos);
		return true;
	}

	else{
		System.out.println("Nao e' possivel inserir mais alunos!\n");
		return false;
	}
}

/*
public boolean DeletaAluno():
	- proposito: Deleta aluno do Banco de Dados
	- parametros de entrada: Nome do Aluno
	- parametros de saida: true, caso tenha deletado o aluno e
	false caso este não exista no Bando de Dados
*/
public boolean DeletaAluno(String DelName){
	int index;

	index = BinSearch(BancoDeDados, 0, NumeroDeAlunos - 1,DelName);

	if(index == -1) return false;
	else{
		for(int i = index+1; i<NumeroDeAlunos; i++){
			BancoDeDados[i-1].InsertName(BancoDeDados[i].GetName());
			BancoDeDados[i-1].InsertNUSP(BancoDeDados[i].GetNUSP());
			BancoDeDados[i-1].InsertP1(BancoDeDados[i].GetP1());
			BancoDeDados[i-1].InsertP2(BancoDeDados[i].GetP2());
			BancoDeDados[i-1].InsertEP1(BancoDeDados[i].GetEP1());
			BancoDeDados[i-1].InsertEP2(BancoDeDados[i].GetEP2());
			BancoDeDados[i-1].InsertEP3(BancoDeDados[i].GetEP3());
			BancoDeDados[i-1].InsertEP4(BancoDeDados[i].GetEP4());
		}
		NumeroDeAlunos--;
		return true;
	}
}

/*
public void SearchAluno():
	- proposito: Busca aluno no Banco de Dados por Busca Binaria
	- parametros de entrada: Nome do Aluno
	- parametros de saida: nao possui
*/
public void SearchAluno(String SearchName){
	int index;

	index = BinSearch(BancoDeDados,0,NumeroDeAlunos-1,SearchName);

	if(index == -1)	System.out.println("Nao existe o aluno \""+SearchName+"\" neste Banco de Dados!\n");
	else PrintAluno(index);
}

/*
public boolean FileImport():
	- proposito: Importa Banco de Dados de um arquivo externo
	- parametros de entrada: nao possui
	- parametros de saida: true, caso tenha importado o BD com  sucesso
	e false caso contrario
*/
public boolean FileImport(String FileName){
	String linha;
	String nome;

	// Abertura do arquivo
	FileReader	fr;
	try{
		fr = new FileReader(FileName);
	}
	catch(IOException exc){
		System.out.println("Nao e' possivel abrir o arquivo\n");
		return false;
	}

	// Leitura do arquivo
	BufferedReader	br = new BufferedReader(fr);
	try{
		while((linha = br.readLine()) != null){

			if(NumeroDeAlunos >= NMax){
				System.out.println("O Banco de Dados atingiu seu limite de armazenamento!\n");
				return false;
			}

			else{

				String[] SplitedLine = linha.split(" ");
				nome = SplitedLine[0];

				// Linha do arquivo
				// NOME DO ALUNO NUSP P1 P2 EP1 EP2 EP3 EP4
				for(int i = 1; i < (SplitedLine.length - 7); i++){
					SplitedLine[i] = (" ").concat(SplitedLine[i]);
					nome = nome.concat(SplitedLine[i]);
				}
				BancoDeDados[NumeroDeAlunos] = new InfoAluno();
				BancoDeDados[NumeroDeAlunos].InsertName(nome);
				BancoDeDados[NumeroDeAlunos].InsertNUSP(SplitedLine[SplitedLine.length - 7]);
				BancoDeDados[NumeroDeAlunos].InsertP1(Double.parseDouble(SplitedLine[SplitedLine.length - 6]));
				BancoDeDados[NumeroDeAlunos].InsertP2(Double.parseDouble(SplitedLine[SplitedLine.length - 5]));
				BancoDeDados[NumeroDeAlunos].InsertEP1(Double.parseDouble(SplitedLine[SplitedLine.length - 4]));
				BancoDeDados[NumeroDeAlunos].InsertEP2(Double.parseDouble(SplitedLine[SplitedLine.length - 3]));
				BancoDeDados[NumeroDeAlunos].InsertEP3(Double.parseDouble(SplitedLine[SplitedLine.length - 2]));
				BancoDeDados[NumeroDeAlunos].InsertEP4(Double.parseDouble(SplitedLine[SplitedLine.length - 1]));
				NumeroDeAlunos++;
			}
		}

		BancoDeDados = alphabetic(BancoDeDados, NumeroDeAlunos);
		fr.close();
		return true;
	}
	catch(IOException exc){
		System.out.println("Problema ao ler o arquivo!\n");
		return false;
	}

}

/*
public boolean FileExport():
	- proposito: Exporta Banco de Dados para um arquivo externo
	- parametros de entrada: nao possui
	- parametros de saida: true, caso tenha exportado o BD com  sucesso
	e false caso contrario
*/
public boolean FileExport(String FileName){

	// Abertura do arquivo
	FileWriter	fw;
	try{
		fw = new FileWriter(FileName);
	}
	catch(IOException exc){
		System.out.println("Nao e' possivel abrir o arquivo\n");
		return false;
	}

	// Escreve no arquivo
	try{
		for(int i = 0; i<NumeroDeAlunos; i++){
			fw.write(BancoDeDados[i].GetName()+" ");
			fw.write(BancoDeDados[i].GetNUSP()+" ");
			fw.write(BancoDeDados[i].GetP1()+" ");
			fw.write(BancoDeDados[i].GetP2()+" ");
			fw.write(BancoDeDados[i].GetEP1()+" ");
			fw.write(BancoDeDados[i].GetEP2()+" ");
			fw.write(BancoDeDados[i].GetEP3()+" ");
			fw.write(BancoDeDados[i].GetEP4()+"\r\n");
		}
		fw.close();
		return true;
	}
	catch(IOException exc){
		System.out.println("Problema ao escrever no arquivo!\n");
		return false;
	}

}

/*
public double[] ClassMean():
	- proposito: Realiza a media das notas P1, P2, EP1, EP2,
	EP3, EP4, T, L MF
	- parametros de entrada: nao possui
	- parametros de saida: um vetor double[] contendo, em sequencia, as
	medias das notas P1, P2, EP1, EP2, EP3, EP4, T, L MF
*/
public double[] ClassMean(){
	double[] sum = new double[9];

	for(int i = 0; i < NumeroDeAlunos; i++){
		sum[0]+=BancoDeDados[i].GetP1();
		sum[1]+=BancoDeDados[i].GetP2();
		sum[2]+=BancoDeDados[i].GetEP1();
		sum[3]+=BancoDeDados[i].GetEP2();
		sum[4]+=BancoDeDados[i].GetEP3();
		sum[5]+=BancoDeDados[i].GetEP4();
		sum[6]+=BancoDeDados[i].GetPMean();
		sum[7]+=BancoDeDados[i].GetEPMean();
		sum[8]+=BancoDeDados[i].GetFinalMean();
	}

	for(int i = 0; i<9; i++) sum[i]/=NumeroDeAlunos;
	return sum;
}

/*
public double[] ClassStdDev():
	- proposito: Realiza os desvios-padrao das notas P1, P2, EP1, EP2,
	EP3, EP4, T, L MF
	- parametros de entrada: media das notas P1, P2, EP1, EP2, EP3,
	EP4, T, L MF
	- parametros de saida: um vetor double[] contendo, em sequencia, os
	desvios-padrao das notas P1, P2, EP1, EP2, EP3, EP4, T, L MF
*/
public double[] ClassStdDev(double[] meanc){
	double[] sum = new double[9];

	for(int i = 0; i < NumeroDeAlunos; i++){
		sum[0]+=Math.pow(BancoDeDados[i].GetP1()-meanc[0],2);
		sum[1]+=Math.pow(BancoDeDados[i].GetP2()-meanc[1],2);
		sum[2]+=Math.pow(BancoDeDados[i].GetEP1()-meanc[2],2);
		sum[3]+=Math.pow(BancoDeDados[i].GetEP2()-meanc[3],2);
		sum[4]+=Math.pow(BancoDeDados[i].GetEP3()-meanc[4],2);
		sum[5]+=Math.pow(BancoDeDados[i].GetEP4()-meanc[5],2);
		sum[6]+=Math.pow(BancoDeDados[i].GetPMean()-meanc[6],2);
		sum[7]+=Math.pow(BancoDeDados[i].GetEPMean()-meanc[7],2);
		sum[8]+=Math.pow(BancoDeDados[i].GetFinalMean()-meanc[8],2);
	}

	for(int i = 0; i<9; i++) sum[i] = Math.sqrt(sum[i]/NumeroDeAlunos);

	return sum;
}

/*
public void PrintAluno():
	- proposito: Imprime um aluno do indice
	- parametros de entrada: media das notas P1, P2, EP1, EP2, EP3,
	EP4, T, L MF
	- parametros de saida: um vetor double[] contendo, em sequencia, os
	desvios-padrao das notas P1, P2, EP1, EP2, EP3, EP4, T, L MF
*/
public void PrintAluno(int index){
	// Metodo que aproxima com 2 casas
	DecimalFormat aproximador = new DecimalFormat("0.00");

	System.out.println("Nome : "+BancoDeDados[index].GetName());
	System.out.println("NUSP : "+BancoDeDados[index].GetNUSP());
	System.out.println("Provas :  <P1> "+aproximador.format(BancoDeDados[index].GetP1())+
										  ";  <P2> "+aproximador.format(BancoDeDados[index].GetP2()));
	System.out.println("   EPs : <EP1> "+aproximador.format(BancoDeDados[index].GetEP1())+
							  "; <EP2> "+aproximador.format(BancoDeDados[index].GetEP2())+
							  "; <EP3> "+aproximador.format(BancoDeDados[index].GetEP3())+
							  "; <EP4> "+aproximador.format(BancoDeDados[index].GetEP4()));
	System.out.println("Medias :   <L> "+aproximador.format(BancoDeDados[index].GetEPMean())+
							  ";   <P> "+aproximador.format(BancoDeDados[index].GetPMean())+
					 		  ";  <MF> "+aproximador.format(BancoDeDados[index].GetFinalMean())+"\n");
}

}



