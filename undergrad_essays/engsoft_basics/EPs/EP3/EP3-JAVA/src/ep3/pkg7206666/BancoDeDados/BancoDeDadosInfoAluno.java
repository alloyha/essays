package ep3.pkg7206666.BancoDeDados;

import java.io.*;
import java.util.*;

public class BancoDeDadosInfoAluno {
    
    // Banco de Dados de alunos
    private TreeMap <Integer , InfoAluno> tMap;
    
    // Variável que detecta se houve rearranjo do array de alunos
    private boolean rearranjo;
    
    // Arranjo de alunos para possibilitar que 
    // se percorra o Banco de Dados
    private String[] Alunos;
    
// Construtores e metodos
    
/* public BancoDeDadosInfoAluno():
	- proposito: Cria uma árvore e aloca espaço; 
                     Atribue valor true para rearranjo (houve rearranjo);
                     Cria um Array com tamanho igual ao número de alunos na árvore e aloca espaço;
	- parametros de entrada: nao possui
	- parametros de saida: nao possui
*/
public BancoDeDadosInfoAluno(){
    tMap = new TreeMap();
    rearranjo = true;
    Alunos = new String[tMap.size()];
}

/* public void ResetaBancoDeDados():
	- proposito: Resetar o banco de Dados
	- parametros de entrada: nao possui
	- parametros de saida: nao possui
*/
public void ResetaBancoDeDados(){
    tMap.clear();
    rearranjo = true;
}

/*
public boolean InsereAluno():
	- proposito: Inserir aluno no Banco de Dados
	- parametros de entrada: Atributos do aluno
	- parametros de saida: nao possui
*/
public void InsereAluno(String Nome,
                        String Nomedomeio,
                        String Sobrenome,
                        String Nusp,
                        String Endereco,
                        String Complemento,
                        String Cep){
    
        InfoAluno NovoAluno = new InfoAluno(Nome,
                                    Nomedomeio,
                                    Sobrenome,
                                    Nusp,
                                    Endereco,
                                    Complemento,
                                    Cep);
        tMap.put(Integer.parseInt(NovoAluno.GetNUSP()), NovoAluno);
        rearranjo = true;
}

/*
public boolean RemoveAluno():
	- proposito: Deleta aluno do Banco de Dados
	- parametros de entrada: N USP do aluno
	- parametros de saida: true, caso tenha deletado o aluno e
	false caso este não exista no Bando de Dados
*/
public boolean RemoveAluno(String NUSP){
    Object prev;
    prev = tMap.remove(Integer.parseInt(NUSP));
    if(prev != null){
        rearranjo = true;
        return true;
    }
    else return false;
    
}

/*
public InfoAluno BuscaAluno():
	- proposito: Busca aluno no Banco de Dados por Busca Binaria
	- parametros de entrada: N USP do aluno
	- parametros de saida: O aluno buscado
*/
public InfoAluno BuscaAluno(String NUSP){
    InfoAluno AlunoBuscado;    
    AlunoBuscado = tMap.get(Integer.parseInt(NUSP));
    return AlunoBuscado;
}

/*
public int IndiceBusca():
	- proposito: Dar o índice do aluno buscado
	- parametros de entrada: N USP do aluno
	- parametros de saida: índice buscado
*/
public int IndiceBusca(int nusp){
    ArrayList lista = new ArrayList(tMap.keySet()); 
    return lista.indexOf(nusp);
}

/*
public boolean ImportaBancoDeDados():
	- proposito: Importa Banco de Dados de um arquivo externo
	- parametros de entrada: nao possui
	- parametros de saida: true, caso tenha importado o BD com  sucesso
	e false caso contrario
*/
public boolean ImportaBancoDeDados(String FileName){
	String linha;
        InfoAluno AlunoLinha;

	// Abertura do arquivo
	FileReader	fr;
	try{ fr = new FileReader(FileName); }
	catch(IOException exc){
		System.out.println("Nao e' possivel abrir o arquivo\n");
		return false;
	}

	// Leitura do arquivo
	BufferedReader	br = new BufferedReader(fr);
	try{
            while((linha = br.readLine()) != null){

                String[] SplitedLine = linha.split("//");

                // Linha do arquivo
                // PRIMEIRO NOME+SEGUNDO NOME+SOBRENOME+NUSP+ENDERECO+COMPLEMENTO+CEP
                
                AlunoLinha = new InfoAluno(SplitedLine[0],
                                           SplitedLine[1],
                                           SplitedLine[2],
                                           SplitedLine[3],
                                           SplitedLine[4],
                                           SplitedLine[5],
                                           SplitedLine[6]);
                tMap.put(Integer.parseInt(SplitedLine[3]), AlunoLinha);
            }
            rearranjo = true;
            fr.close();
            return true;
         }    
    
        catch(IOException exc){
            //Problema ao ler o arquivo!
            return false;
        }
}

/*
public boolean ExportaBancoDeDados():
	- proposito: Exporta Banco de Dados para um arquivo externo
	- parametros de entrada: nao possui
	- parametros de saida: true, caso tenha exportado o BD com  sucesso
	e false caso contrario
*/
public boolean ExportaBancoDeDados(String FileName){
        Iterator iterator = tMap.entrySet().iterator();
        InfoAluno AlunoLinha;
             
	// Abertura do arquivo
	FileWriter fw;
	try{
		fw = new FileWriter(FileName);
	}
	catch(IOException exc){
                 //Nao e' possivel abrir o arquivo
		return false;
	}

	// Escreve no arquivo
	try{
            while (iterator.hasNext()) {    
                Map.Entry entry = (Map.Entry) iterator.next();
                AlunoLinha = (InfoAluno) entry.getValue();
                fw.write(AlunoLinha.GetNome()+"//");
                fw.write(AlunoLinha.GetNMeio()+"//");
		fw.write(AlunoLinha.GetNSobrenome()+"//");
		fw.write(AlunoLinha.GetNUSP()+"//");
		fw.write(AlunoLinha.GetEndereco()+"//");
		fw.write(AlunoLinha.GetComplemento()+"//");
		fw.write(AlunoLinha.GetCEP()+"\r\n");  
            }    
            fw.close();
            return true;
	}
	catch(IOException exc){
		//Problema ao escrever no arquivo
		return false;
	}
}

/*
public int[] Percorrer():
	- proposito: possibilitar que usuário percorra o Banco de Dados atual
	- parametros de entrada: posicao atual do aluno mostrado e 
        tipo de botão pressionado (avanço ou recuo)
	- parametros de saida: um array de duas posições contendo 
        N USP e posição relativa no atual array
*/
public int[] Percorrer(int posicaoatual, int botao){
    int posicao = 0;
    
    if(rearranjo){
        Alunos = new String[tMap.size()];
        Iterator iterator = tMap.entrySet().iterator();
        for(int i = 0; iterator.hasNext(); i++){
            Map.Entry entry = (Map.Entry) iterator.next();
            Alunos[i] = (((InfoAluno)entry.getValue())).GetNUSP();
        }
        rearranjo = false;
    }
    else if(!rearranjo){
        posicao = posicaoatual + botao;
        if(posicao<0) posicao = tMap.size() - 1;
        else if(posicao>tMap.size()-1) posicao = 0;
    }
    
    int[] Dados = new int[2]; 
    Dados[0] = Integer.valueOf(Alunos[posicao]);
    Dados[1] = posicao;
    
    return Dados;
    }
    
}
