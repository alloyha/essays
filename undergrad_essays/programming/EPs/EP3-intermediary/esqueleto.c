/* esqueleto.c para o EP3 de MAC2166, ano 2010 */
/* Versão 1.0                                  */

#include <stdio.h>
#include <math.h>

/* Os comentarios e mensagens no comando printf *
 * estao sem acentuacao propositalmente         */


/* massa da terra */
#define MTERRA   5.97e+24

/* massa da lua */
#define MLUA     7.35e+22

/* constante gravitacional universal */
#define G        8.65e-13

/* raio da terra */
#define RTERRA   6378

/* raio da lua */
#define RLUA     1738

/* posicoes (fixas) da terra e lua no sistema cartesiano */
#define X_T          0
#define Y_T          0
#define X_L          D
#define Y_L          0

/* distancia da terra a lua */
#define D        384400


/* definicoes usadas para exibir */
#define MAXLINHA    25
#define MAXCOL      80
#define LARGURA     5414


/* Outras */
#define FILENAME_MAXTAM   128

#define EPS         0.00001




/* ----------------------- *
 * Prototipo das funcoes   *
 * ----------------------- */

void espere_enter( ) ;

int sao_iguais(float x1, float x2) ;

float distancia(float x1, float y1, float x2, float y2) ;

float velocidade_esc(float xA, float yA,
                     float mA,
                     float x, float y) ;

void aceleracao_gravitacional(float xA, float yA, float mA,
			      float x,  float y,
			      float *ax, float *ay) ;

void aceleracao_resultante(float xA, float yA, float mA,
		float xB, float yB, float mB,
		float x, float y, float *ax, float *ay) ;

void ponto_L1(float xA, float yA, float mA,
		  float xB, float yB, float mB,
		  float *x,  float *y) ;

void quadrante(float x, float y, int *i, int *j) ;

int mostre_mapa(int iT, int jT, int iL, int jL,
                float x, float y, int *iN, int *jN) ;

void mostre_dados(float hora,
		  float distancia_percorrida,
		  float x,  float y,
		  float vx, float vy,
		  float ax,   float ay ) ;

int sinal(float xA, float x);


/* ----------------------- *
 * MAIN                    *
 * ----------------------- */

int main() {

  FILE  *entrada ;
  char  nome_arquivo[FILENAME_MAXTAM] ;
  char  codigo ;

  /*

   Aqui: outras variaveis necessarias

  */


  printf("\nArquivo de entrada :  ") ;
  scanf("%s", nome_arquivo) ;
  printf("\n") ;

  entrada = fopen(nome_arquivo, "r") ;
  if(entrada==NULL) {
    printf("Arquivo %s nao existe ou ocorreu erro na abertura.\n\n",
	    nome_arquivo) ;
    return 0 ;
  }

  /* limpa o \n ... */
  scanf("%c", &codigo) ;



  /* laco principal */
  while(!feof(entrada)) {

    fscanf(entrada, "%c", &codigo) ;

    switch (codigo) {

    case 'a':

      /*
        Aqui: processar a opcao a
      */

      break ;


    case 'A':

      /*
        Aqui: processar a opcao A
      */

      break ;


    case 'L':

      /*
        Aqui: processar a opcao L
      */

      break ;


    case 'e':

      /*
        Aqui: processar a opcao e
      */

      break ;


    case 's':

      /*
        Aqui: processar a opcao s
      */

      break ;


    default:
      /* se o caractere lido não for nenhum dos anteriores, *
       * nao faz nada ...                                   */
      break;
    }

  }

  fclose(entrada) ;

  return 0 ;
}





/* ----------------------- *
 * Funções                 *
 * ----------------------- */


/* Le os caracteres teclados, ate um ENTER ser teclado */

void espere_enter()
{
  char ch;

  printf("\n");
  printf("Tecle <enter> para continuar.  ");
  scanf("%c", &ch);
  while (ch != '\n')
    {
      scanf("%c", &ch);
    }
  printf("\n");
}

/* Verifica se dois numeros reais x1 e x2 sao iguais */

int sao_iguais(float x1, float x2)
{

  return fabs(x1-x2) < EPS*fabs(x1) || fabs(x1-x2) < EPS*fabs(x2) ;

}


void quadrante(float x, float y, int *i, int *j) {

  /*
     Aqui: trocar as duas linhas de codigo
     abaixo pelo seu codigo para calculo do quadrante
  */
  *i = (y + 13.5*LARGURA)/LARGURA;
  *j = (x + 5.5*LARGURA)/LARGURA;
}


/* Recebe os indices (iT,jY), (iL,jL) e (*iN,*jN) dos    *
 * quadrantes no mapa da Terra, Lua e nave,              *
 * respectivamente.                                      *
 * Calcula os indices do quadrante correspondente ao     *
 * ponto (x,y). Se esses indices forem diferentes da     *
 * armazenada em (*iN,*jN), entao mostra o mapa com a    *
 * nave na nova posicao no mapa, imprime varios dados    *
 * relativos a nave e armazena em (*iN,*jN) os novos     *
 * indices calculados.                                   *
 * Retorna 1 caso o mapa tenha sido mostrado e 0 em caso *
 * contario.                                             */

int mostre_mapa(int iT, int jT, int iL, int jL,
                float x, float y, int *iN, int *jN)
{

  int i, j ;
  int novo_i, novo_j ;

  quadrante(x, y, &novo_i, &novo_j);

  if(novo_i != *iN || novo_j != *jN) {
    printf("+");
    for (j = 1; j <= MAXCOL; j++) printf("-");
    printf("+\n");

    for (i = 1; i <= MAXLINHA; i++)
      for (j = 0; j <= MAXCOL+1; j++)
	if ( (i == novo_i && j == novo_j) && ((i == iT && j == jT)
	     || (i == iL && j == jL)) ) printf("#");
	else if (i == iT && j == jT) printf("T");
	else if (i == iL && j == jL) printf("L");
	else if (j ==  0)              printf("|");
	else if (j == MAXCOL+1)        printf("|\n");
	else if (i == novo_i && j == novo_j) printf("A");
	else printf(" ");

    printf("+");
    for (j = 1; j <= MAXCOL; j++) printf("-");
    printf("+\n");

    *iN = novo_i;
    *jN = novo_j ;

    return 1;
  }

  return 0;
}

float distancia(float x1, float y1, float x2, float y2) {
    return sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
}

float velocidade_esc(float xA, float yA,
                     float mA,
                     float x, float y) {
    return sqrt(2*G*mA/distancia(xA,yA,x,y));
}

void aceleracao_gravitacional(float xA, float yA, float mA,
			      float x,  float y,
			      float *ax, float *ay) {
    *ax=G*mA/(x-xA)*(x-xA)*sinal(xA,x);
    *ay=G*mA/(y-yA)*(y-yA)*sinal(yA,y);
}

int sinal(float xA, float x){
    if(xA<x) return -1;
    return 1;
}

void aceleracao_resultante(float xA, float yA, float mA,
		float xB, float yB, float mB,
		float x, float y, float *ax, float *ay) {
	*ax=(G*mA/(xA-x)*(xA-x))*sinal(xA,x)+(G*mB/(xB-x)*(xB-x))*sinal(xB,x);
	*ay=(G*mA/(yA-y)*(yA-y))*sinal(yA,y)+(G*mB/(yB-y)*(yB-y))*sinal(yB,y);
}

void ponto_L1(float xA, float yA, float mA,
		  float xB, float yB, float mB,
		  float *x,  float *y) {
    float L;
    L=sqrt(mA)*distancia(xA,yA,xB, yB)/sqrt(mA)+sqrt(mB)
    /* (mA-mB)*L^2-2*mA*D*L+A*D*D=0  <==> L=sqrt(mA)*D/sqrt(mA)+sqrt(mB), tanto para mA!mB ou mA=mB */
    *x=xA+L*(xB-xA)/distancia(xA,yA,xB, yB);
    *y=yA+L*(yB-yA)/distancia(xA,yA,xB, yB);
}

void mostre_dados(float hora,
		  float distancia_percorrida,
		  float x,  float y,
		  float vx, float vy,
		  float ax,   float ay ) {

}
