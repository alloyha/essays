/*	PMR2300 - Computacao para Mecatronica
 *	Aluno	: Bruno Henrique Lobo Netto Peixoto
 *	Nusp	: 7206666
 */

import java.io.*;
import java.util.*;

public class Resources{

/*
public InfoAluno[] alphabetic():
	- proposito: Ordena o array Data[] alfabeticamente
	pelo nome de cada aluno
	- parametros de entrada: Array de InfoAluno[] Data a ser ordenado
	e posicao do ultimo elemento de Data[]
	- parametros de saida: Data[] ordenado alfabeticamente
*/
public InfoAluno[] alphabetic(InfoAluno[] Data, int k){
	List<InfoAluno> DataList = Arrays.asList(Data);
	Collections.sort(DataList.subList(0,k));
	Data = (InfoAluno[]) DataList.toArray();

	return Data;
}

/*
public int BinSearch():
	- proposito: Busca um aluno pelo nome SearchName por Busca Binária
	- parametros de entrada: Array de InfoAluno[] Data no qual deseja-se
	buscar o aluno, as posicoes a direita e a esquerda do método de busca
	e o nome a ser buscado
	- parametros de saida: o indice do aluno com nome SearchName, ou -1 caso

*/
public int BinSearch(InfoAluno[] Data, int left, int right, String SearchName){

	int middle = (right+left)/2;

	if((Data[middle].GetName()).compareTo(SearchName) < 0)	left = middle;
	else if((Data[middle].GetName()).compareTo(SearchName) > 0)	right = middle;
	else return middle;

	if(left == right-1) {
		if((Data[left].GetName()).equals(SearchName))	return left;
		else if((Data[right].GetName()).equals(SearchName))	return right;
		else return -1;
	}
	return (BinSearch(Data,left,right,SearchName));

}
}