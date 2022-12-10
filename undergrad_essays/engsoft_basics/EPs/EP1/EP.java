/*	PMR2300 - Computacao para Mecatronica
 *	Aluno	: Bruno Henrique Lobo Netto Peixoto
 *	Nusp	: 7206666
 */


import java.io.*;
import java.text.DecimalFormat;

public class EP{

/******************************* Funcoes ********************************/

// Efetua leitura das notas de cada aluno
public static double leitura() throws IOException{

	// Metodo de leitura via teclado
	InputStreamReader conversor = new InputStreamReader(System.in);
	BufferedReader 	  teclado 	= new BufferedReader(conversor);

	// Variaveis locais de leitura e retorno
    String value;
    double nota;

	// Leitura das notas
	System.out.print("    Digite a nota do aluno: ");
	value = teclado.readLine();
	nota = Integer.parseInt(value);

	return nota;
}

// Efetua a media da classe
public static double mean(double[] notas, int n) throws IOException{
	double cont=0;

	for(int i=0;i<n; i++)
		cont+=(notas[i]);

	return (cont/n);
}

// Efetua desvio-padrao das notas da sala
public static double stddev(double[] notas, double meanc, int n) throws IOException{
	double cont=0;

	for(int i=0;i<n; i++)
		cont+= Math.pow((notas[i] - meanc),2);

	return (Math.sqrt(cont/n));
}

// Efetua moda das notas da classe
public static int[] mode(double[] notas, int n) throws IOException{
	int[] f = new int[n];
	int[] indice = new int[n+2];
	int x, k = 1, flag;

	for(int i=0; i<n; i++)
		for(int j=0; j<n; j++)
			if(notas[i] == notas[j]) f[i]++;

	x = f[0];
	indice[2] = 0;
	for(int i=1; i<n ; i++){
		if(f[i] > x){
			x = f[i];
			indice[2] = i;
			k=1;
		}
		else{
			if(f[i] == x){
				flag=0;
				for(int j=2;j<k+2;j++)
					if(notas[i] == notas[indice[j]]) flag++;
				if(flag==0){
					indice[2+k] = i;
					k++;
				}
			}
		}
	}
	indice[0] = k;
	indice[1] = x;
	return indice;

}

// Encontra maior valor dentre as notas
public static double max(double[] notas, int n){
	double max;
	max = notas[0];
	for(int i=1; i<n; i++)
		if(notas[i] > max)	max = notas[i];

	return max;

}

// Encontra menor valor dentre as notas
public static double min(double[] notas, int n){
	double min;
	min = notas[0];
	for(int i=1; i<n; i++)
		if(notas[i] < min)	min = notas[i];

	return min;

}

/************************************************************************/

/******************************** Main **********************************/

public static void main(String[] args) throws IOException{

	// Array de alunos
	String[] 	aluno = new String[100];

	// Array de N USP
	String[] 	nusp  = new String[100];

	// Array contendo notas dos alunos
	double[]	notas = new double[100];

	// Media, Desvio-padrao, maior e menor nota, e a moda
	double mean, stddev, max, min;
	int[] mode;

	// Numero de alunos
	int n = 0;

	// Nome do arquivo e String de leitura do arquivo
	String arquivo, linha;

	// Metodo que aproxima com 2 casas
	DecimalFormat aproximador = new DecimalFormat("0.00");

	// Metodo q ira fazer a leitura via teclado
	InputStreamReader conversor = new InputStreamReader(System.in);
	BufferedReader 	  teclado 	= new BufferedReader(conversor);

	// Solicitação do nome do arquivo que contem os dados de leitura
	System.out.print("Insira o nome do arquivo de leitura: ");
	arquivo = teclado.readLine();
	System.out.println();

	// Abertura do arquivo
	FileReader	fr;
		try{
		fr = new FileReader(arquivo);
	}
	catch(IOException exc){
		System.out.println("Nao e' possivel abrir o arquivo");
		return;
	}

	// Leitura do arquivo
	BufferedReader	br = new BufferedReader(fr);
	try{
		for(int i=0;(linha = br.readLine()) != null;i++){
			aluno[i] = linha.substring(0, linha.length() - 8);
			nusp[i] = linha.substring(linha.length() - 7,linha.length());
		}
	}
	catch(IOException exc){
		System.out.println("Problema ao ler o arquivo!");
	}
	fr.close();

	// Insercao das notas
	for(int i=0;i<aluno.length && aluno[i] != null;i++){
		System.out.println("Nome: "+aluno[i]+"\t"+"N USP: "+nusp[i]);
		notas[i] = leitura();
		System.out.println();
		n++;
	}

	// Coleta dos dados estatisticos
	mean = mean(notas,n);
	stddev = stddev(notas,mean,n);
	max = max(notas,n);
	min = min(notas,n);
	mode = mode(notas,n);

	// Impressao dos dados estatisticos
	System.out.println("Media da classe:"+"\t"+aproximador.format(mean));
	System.out.println("Desvio-Padrao  :"+"\t"+aproximador.format(stddev));
	System.out.println("Maior nota     :"+"\t"+aproximador.format(max));
	System.out.println("Menor nota     :"+"\t"+aproximador.format(min));
	System.out.print("Moda           :"+"\t");
	if(mode[1]==1) System.out.println("Nao ha moda");
	else{
		for(int i=2; i<2+mode[0]; i++)
			System.out.println(notas[mode[i]]+" ");
	}
	System.out.println();

	// Criação do arquivo a ser escrito
	FileWriter	fw;
	try{
		fw = new FileWriter("dados.txt");
	}
	catch(IOException exc){
		System.out.println("Nao e' possivel abrir o arquivo");
		return;
	}

	// Escreve no arquivo
		try{
			for(int i=0; i<n;i++){
				fw.write(aluno[i]+" "+nusp[i]+" "+notas[i]+"\r\n");
			}
			fw.write("\r\n");
			fw.write("Media da classe:"+"\t"+aproximador.format(mean)+"\r\n");
			fw.write("Desvio-Padrao  :"+"\t"+aproximador.format(stddev)+"\r\n");
			fw.write("Maior nota     :"+"\t"+aproximador.format(max)+"\r\n");
			fw.write("Menor nota     :"+"\t"+aproximador.format(min)+"\r\n");
			fw.write("Moda           :"+"\t");
				if(mode[1]==1) fw.write("Nao ha moda");
				else{
					for(int i=2; i<2+mode[0]; i++)
						fw.write(notas[mode[i]]+" ");
	}
		}
		catch(IOException exc){
		System.out.println("Problema ao escrever no arquivo!");
		}
		fw.close();

}
/************************************************************************/
}
