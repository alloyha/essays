#include <stdio.h>
#include <math.h>
#include "simulation.h"


int main() {

  FILE  *entrada ;
  char  nome_arquivo[FILENAME_MAXTAM] ;
  
  printf("\nArquivo de entrada :  ") ;
  scanf("%s", nome_arquivo) ;
  printf("\n") ;

  entrada = fopen(nome_arquivo, "r") ;

  if(entrada==NULL) {
    printf("Arquivo %s nao existe ou ocorreu erro na abertura.\n\n",
	    nome_arquivo) ;
    return 1 ;
  }
  
  // Iniciar simulação de acordo com o arquivo de entrada
  iniciar_simulacao(entrada);

  fclose(entrada) ;

  return 0 ;
}

/*
int main() {
  int iT, jT, iL, jL, iN, jN;
  float x, y;

  quadrante(X_T, Y_T, &iT, &jT);
  quadrante(X_L, Y_L, &iL, &jL);

  mostre_mapa(iT, jT, iL, jL, x, y, &iN, &jN);
  espere_enter();
  apagar_espere_enter();
  apagar_mapa();
}
*/