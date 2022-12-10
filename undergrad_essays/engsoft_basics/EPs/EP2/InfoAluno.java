/*	PMR2300 - Computacao para Mecatronica
 *	Aluno	: Bruno Henrique Lobo Netto Peixoto
 *	Nusp	: 7206666
 */

public class InfoAluno implements Comparable<InfoAluno>{

// Variaveis da classe

private String nomedoaluno, nusp;
private double
P1, 	// Nota da prova 1
P2, 	// Nota da prova 2
EP1, 	// Nota do EP1
EP2, 	// Nota do EP2
EP3, 	// Nota da EP3
EP4, 	// Nota da EP4
T, 		// Media de provas
L, 		// Media dos EPs
MF; 	// Media Final

// Construtores: Construtor Inicial Nulo
/*
public InfoAluno():
	- proposito: atribui o valor inicial nulo aos atributos da classe
	- parametros de entrada: nao possui
	- parametros de saida: nao possui
*/
public InfoAluno(){
	nomedoaluno = null;
	nusp = null;
	P1=0;
	P2=0;
	EP1=0;
	EP2=0;
	EP3=0;
	EP4=0;
	T=0;
	L=0;
	MF=0;
}

// Metodos de insercao
/*
public void InsertX():
	- proposito: Insere o valor x ao respectivo atributo X do objeto
	- parametros de entrada: x, sendo String ou double, dependendo do
	respectivo atributo X do objeto
	- parametros de saida: nao possui
*/
public void InsertName(String n){ nomedoaluno=n;}
public void InsertNUSP(String nu){ nusp=nu;}
public void InsertP1(double p1){ P1=p1; }
public void InsertP2(double p2){ P2 = p2; }
public void InsertEP1(double ep1){ EP1 = ep1; }
public void InsertEP2(double ep2){ EP2 = ep2; }
public void InsertEP3(double ep3){ EP3 = ep3; }
public void InsertEP4(double ep4){ EP4 = ep4; }

// Metodos de coleta de dados
/*
public TIPO GetX():
	- proposito: pega o valor do atributo X do objeto
	- parametros de entrada: nao possui
	- parametros de saida: Respectivo atributo X do objeto
*/
public String GetName(){ return(nomedoaluno); }
public String GetNUSP(){ return(nusp); }
public double GetP1(){ return(P1); }
public double GetP2(){ return(P2); }
public double GetEP1(){ return(EP1); }
public double GetEP2(){ return(EP2); }
public double GetEP3(){ return(EP3); }
public double GetEP4(){ return(EP4); }
public double GetPMean(){
	T = (P1+2*P2)/3;
	return(T);
}
public double GetEPMean(){
	L = (EP1+EP2+EP3+EP4)/4;
	return(L);
}
public double GetFinalMean(){
	MF = (5*T+L)/6;
	return(MF);
}

/*
 * Ao implementar a interface Comparable será
 * necessário sobrescrever o método compareTo que retorna
 * um int. O método compareTo possibilita que
 * o List de alunos (Database) possa ser ordenado pelo nome.
 */
/*@Override*/
public int compareTo(InfoAluno p) {
	return this.GetName().compareTo(p.GetName());
}

}