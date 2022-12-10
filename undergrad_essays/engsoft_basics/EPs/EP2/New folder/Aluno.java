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
 * Ao implementar a interface Comparable será
 * necessário sobrescrever o método compareTo que retorna
 * um int. O método compareTo faz toda a mágica para que
 * o List de alunos (Database) possa ser ordenado pelo nome.
 */
@Override
public int compareTo(Aluno p) {
	return this.GetName().compareTo(p.GetName());
}

}