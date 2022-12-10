/*	PMR2300 - Computacao para Mecatronica
 *	Aluno	: Bruno Henrique Lobo Netto Peixoto
 *	Nusp	: 7206666
 */

import java.util.*;

public class teste{

public static void main(String[] args){
	Aluno[] alunos = new Aluno[6];

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

//	List<Aluno> names = Arrays.asList(alunos);
	/*Strings = ordena(Strings);*/
//	Collections.sort(names);
	/*for(String e : names){
		System.out.println(e);
	}*/
//	alunos = (Aluno[]) names.toArray();
//	for(int i = 0; i<6; i++){
//			System.out.println(alunos[i].GetName()+" + "+alunos[i].GetNUSP());
//	}

	}
}