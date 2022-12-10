package ep3.pkg7206666.BancoDeDados;

class InfoAluno {

    
// Atributos de um aluno
private String
nome,
nomedomeio,
sobrenome,
nusp,
endereco,
complemento,
cep;

/* Construtores/metodos:  */

// Construtor de um aluno (Inserção completa de parâmetros)
protected InfoAluno(String Nome,
                    String Nomedomeio,
                    String Sobrenome,
                    String Nusp,
                    String Endereco,
                    String Complemento,
                    String Cep){
	nome = Nome;
	nomedomeio = Nomedomeio;
	sobrenome = Sobrenome;
	nusp = Nusp;
	endereco = Endereco;
	complemento = Complemento;
	cep = Cep;
}

// Construtor de um aluno (construtor nulo)
protected InfoAluno(){}

// Métodos para ter acesso à determinada atributo do aluno
protected String GetNome(){ return nome; }
protected String GetNMeio(){ return nomedomeio; }
protected String GetNSobrenome(){ return sobrenome; }
protected String GetNUSP(){ return nusp; }
protected String GetEndereco(){ return endereco; }
protected String GetComplemento(){ return complemento; }
protected String GetCEP(){ return cep; }
    
}
