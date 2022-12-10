/*	PMR2300 - Computacao para Mecatronica
 *	Aluno	: Bruno Henrique Lobo Netto Peixoto
 *	Nusp	: 7206666
 */

import java.util.*;

public class novo{

public static int BinSearch(Aluno[] alunos, int left, int right, String SearchName){
	int middle = (right+left)/2;

	if((alunos[middle].GetName()).compareTo(SearchName) < 0)	left = middle;
	else if((alunos[middle].GetName()).compareTo(SearchName) > 0)	right = middle;
	else return middle;

	if(left == right-1) {
		if((alunos[left].GetName()).equals(SearchName))	return left;
		else if((alunos[right].GetName()).equals(SearchName))	return right;
		else return -1;
	}
	return (BinSearch(alunos,left,right,SearchName));
}

public static void main(String[] args){
	Aluno[] alunos = new Aluno[6];
	String SearchName, DelName;
	int index;

	for(int i = 0; i<6; i++) alunos[i] = new Aluno();

	alunos[0].InsertName("Bruno Henrique Lobo");
	alunos[0].InsertNUSP("1234567");
	alunos[1].InsertName("Bruno Henrique Lobo Netto");
	alunos[1].InsertNUSP("1234568");
	alunos[2].InsertName("Flavio Jose Oliveira de Paula");
	alunos[2].InsertNUSP("1234569");
	alunos[3].InsertName("Amanda Vieira Fernandes");
	alunos[3].InsertNUSP("1234570");
	alunos[4].InsertName("Gustavo Vilela Momente");
	alunos[4].InsertNUSP("1234571");
	alunos[5].InsertName("Eduardo Moscatelli de Souza");
	alunos[5].InsertNUSP("1234572");

	for(int i = 0; i<6; i++){
		System.out.println(alunos[i].GetName()+" + "+alunos[i].GetNUSP());
	}
	System.out.println();

	List<Aluno> names = Arrays.asList(alunos);

	for(Aluno e : names){
			System.out.println(e.GetName());
	}

	Collections.sort(names.subList(0,4));

	alunos = (Aluno[]) names.toArray();
	for(int i = 0; i<6; i++){
			System.out.println(i+" - "+alunos[i].GetName()+" + "+alunos[i].GetNUSP());
	}

	SearchName = "Amanda Vieira Fernandes";
	index = BinSearch(alunos,0,alunos.length - 1,SearchName);
	if(index == -1)
		System.out.println("Pau! "+SearchName+" nao existe no Database!");
	else
		System.out.println("\n"+SearchName+" esta' no indice "+index);

	DelName = "Amanda Vieira Fernandes";
	index = BinSearch(alunos,0,alunos.length - 1,SearchName);
	if(index == -1)
		System.out.println("Pau! "+DelName+" nao existe no Database!");
	else{
		for(int i=index+1; i<6; i++){
			alunos[i-1].InsertName(alunos[i].GetName());
		}
	}

	for(Aluno e : names){
		System.out.println(e.GetName());
	}

	}
}