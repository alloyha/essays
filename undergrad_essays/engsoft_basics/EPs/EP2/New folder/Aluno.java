/*	PMR2300 - Computacao para Mecatronica
 *	Aluno	: Bruno Henrique Lobo Netto Peixoto
 *	Nusp	: 7206666
 */

public class Aluno implements Comparable<Aluno>{

private String nomedoaluno, nusp;

public void InsertName(String n){
		nomedoaluno = n;
}

public String GetName(){
	return(nomedoaluno);
}

public void InsertNUSP(String n){
	nusp=n;
}

public String GetNUSP(){
	return(nusp);
}

/*
 * Ao implementar a interface Comparable ser�
 * necess�rio sobrescrever o m�todo compareTo que retorna
 * um int. O m�todo compareTo faz toda a m�gica para que
 * o List de alunos (Database) possa ser ordenado pelo nome.
 */
@Override
public int compareTo(Aluno p) {
	return this.GetName().compareTo(p.GetName());
}

}