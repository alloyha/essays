#include <stdio.h>
#include <stdbool.h>
#include "constants.h"
#include "physics.h"
#include "utils.h"

void espere_enter()
{
  /**
   * Lê os caracteres teclados até que a tecla ENTER seja pressionada.
   * Esta função aguarda a entrada do usuário antes de continuar a execução do programa.
   */

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

void quadrante(float x, float y, int *i, int *j) 
{
  /**
   * Calcula os índices do quadrante em um mapa com base nas coordenadas (x, y).
   *
   * @param x Coordenada x no plano.
   * @param y Coordenada y no plano.
   * @param i Ponteiro para a variável que armazenará a coordenada i do quadrante.
   * @param j Ponteiro para a variável que armazenará a coordenada j do quadrante.
   */
  *i= (y + 13.5*LARGURA)/LARGURA;
  *j= (x + 5.5*LARGURA)/LARGURA;
}

int sao_iguais(float x1, float x2)
{
  /* 
    Verifica se dois numeros reais x1 e x2 sao iguais 
  */
  return fabs(x1-x2) < EPS*fabs(x1) || fabs(x1-x2) < EPS*fabs(x2) ;
}


float distancia(float x1, float y1, float x2, float y2) {
  /**
   * Calcula a distância euclidiana entre dois pontos em um plano bidimensional.
   *
   * @param x1 A coordenada x do primeiro ponto.
   * @param y1 A coordenada y do primeiro ponto.
   * @param x2 A coordenada x do segundo ponto.
   * @param y2 A coordenada y do segundo ponto.
   *
   * @return A distância euclidiana entre os dois pontos.
   */

    float delta_x_2 = pow(x2 - x1, 2);
    float delta_y_2 = pow(y2 - y1, 2);

    return sqrt(delta_x_2+delta_y_2);
}

void imprimir_cerca(){
  /**
   * Imprime uma representação gráfica de uma cerca na tela.
   * A cerca é composta por caracteres '+' nos cantos e '-' no meio.
   * A largura da cerca é definida pela constante MAXCOL.
   */

  printf("+");
  for (int j = 1; j <= MAXCOL; j++) printf("-");
  printf("+\n");
}

void imprimir_quadro(
  int i, int j, int novo_i, int novo_j,
  int iT, int jT, int iL, int jL
){
    /**
     * Imprime um quadro com diferentes caracteres para representar elementos específicos
     * nas posições dadas pelas coordenadas (i, j), (novo_i, novo_j), (iT, jT) e (iL, jL).
     *
     * @param i A coordenada i atual.
     * @param j A coordenada j atual.
     * @param novo_i A coordenada i do elemento marcado como 'A'.
     * @param novo_j A coordenada j do elemento marcado como 'A'.
     * @param iT A coordenada i do elemento marcado como 'T'.
     * @param jT A coordenada j do elemento marcado como 'T'.
     * @param iL A coordenada i do elemento marcado como 'L'.
     * @param jL A coordenada j do elemento marcado como 'L'.
     */

    bool colisao = (i == iT && j == jT) || (i == iL && j == jL);
    bool estagnacao = (i == novo_i && j == novo_j);
  
    if ( estagnacao && colisao) printf("#");
    else if (i == iT && j == jT) printf("T");
    else if (i == iL && j == jL) printf("L");
    else if (j ==  0) printf("|");
    else if (j == MAXCOL+1) printf("|\n");
    else if (i == novo_i && j == novo_j) printf("A");
    else printf(" ");
}

bool mostre_mapa(int iT, int jT, int iL, int jL,
                float x, float y, int *iN, int *jN)
{
  /**
   * Recebe os índices (iT, jT), (iL, jL) e (*iN, *jN) dos quadrantes no 
   * mapa da Terra, Lua e nave, respectivamente.
   * Calcula os índices do quadrante correspondente ao ponto (x, y). 
   * Se esses índices forem diferentes dos armazenados em (*iN, *jN),
   * então mostra o mapa com a nave na nova posição no mapa, 
   * imprime vários dados relativos à nave e armazena em (*iN, *jN) 
   * os novos índices calculados.
   * Retorna 1 caso o mapa tenha sido mostrado e 0 em contrário.
   *
   * @param iT Coordenada i do quadrante da Terra.
   * @param jT Coordenada j do quadrante da Terra.
   * @param iL Coordenada i do quadrante da Lua.
   * @param jL Coordenada j do quadrante da Lua.
   * @param x Coordenada x da posição da nave.
   * @param y Coordenada y da posição da nave.
   * @param iN Ponteiro para a coordenada i do quadrante atual da nave.
   * @param jN Ponteiro para a coordenada j do quadrante atual da nave.
   *
   * @return Retorna 1 se o mapa foi mostrado devido à mudança de quadrante da nave, senão retorna 0.
   */

  int novo_i, novo_j ;

  // Obtem quadrante da nave
  quadrante(x, y, &novo_i, &novo_j);

  // Imprime se a nave mudou de quadrante
  bool imprime = (novo_i != *iN) || (novo_j != *jN);
  if(imprime) {
    imprimir_cerca();

    for (int i = 1; i <= MAXLINHA; i++)
      for (int j = 0; j <= MAXCOL+1; j++)
        imprimir_quadro(
          i, j, novo_i, novo_j,
          iT, jT, iL, jL
        );

    imprimir_cerca();

    *iN = novo_i;
    *jN = novo_j ;

    return true;
  } else {
    return false;
  }
}

void mostre_dados_viagem(
    float hora,
    float distancia_percorrida,
    float x,  float y,
    float vx, float vy,
    float ax,   float ay 
  ) {

    printf("Tempo de viagem      : %.2f\n",hora);
    printf("Distancia percorrida : %.2f\n",distancia_percorrida);
    printf("Posicao              : ( %.2f , %.2f )\n",x,y);
    printf("Velocidade           : (%.2f,%.2f)\n",vx,vy);
    printf("Aceleracao           : (%.2f,%.2f)\n",ax,ay);
    printf("Distancia da Terra   : %.2f\n", distancia(X_T,Y_T,x,y));
    printf("Distancia da Lua     : %.2f\n", distancia(X_L,Y_L,x,y));
}

void mostre_lagrangiano(
  float xA, float yA, float mA,
  float xB, float yB, float mB,
  float x, float y
) 
{
  printf(" Posicao do corpo 1 [Km, Km]        : ( %.2f , %.2f )\n", xA, yA);
  printf(" Massa do corpo 1   [Kg]            : %.2e\n", mA);
  printf(" Posicao do corpo 2 [Km, Km]        : ( %.2f , %.2f )\n", xB, yB);
  printf(" Massa do corpo 2   [Kg]            : %.2e\n", mB);
  ponto_lagrangeano(xA,yA,mA,xB,yB,mB,&x,&y);
  printf(" Ponto Lagrangeano  [Km]            : ( %.2f , %.2f )\n\n",x,y);
}

void mostre_velocidade_de_escape(
  float xA, float yA, float mA,
  float x, float y
) 
{
    printf(" Posicao do corpo [Km, Km]        : ( %.2f , %.2f )\n", xA, yA);
    printf(" Massa do corpo   [Kg]            : %.2e\n", mA);
    printf(" Posicao da nave  [Km, Km]        : ( %.2f , %.2f )\n",x,y);

    // Distancia entre corpo e nave
    float dist_A = distancia(xA,yA,x,y);
    float v_esc = velocidade_esc(xA,yA,mA,x,y);

    printf(" Distancia do corpo a nave [Km]   : %.2f\n", dist_A); 
    printf(" Velocidade de escape      [Km/h] : %.2f\n\n", v_esc); 
}

void mostre_aceleracao_resultante(
  float xA, float yA, float mA,
  float xB, float yB, float mB,
  float x, float y, float ax, float ay
)
{
    printf(" Posicao do corpo 1 [Km, Km]      : ( %.2f , %.2f )\n", xA, yA);
    printf(" Massa do corpo 1   [Kg]          : %.2e\n", mA);
    printf(" Posicao do corpo 2 [Km, Km]      : ( %.2f , %.2f )\n", xB, yB);
    printf(" Massa do corpo 2   [Kg]          : %.2e\n", mB);
    printf(" Posicao da nave    [Km, Km]      : ( %.2f , %.2f )\n\n", x, y);
    
    /*aceleração resultante em relação a 1*/
    aceleracao_gravitacional(xA,yA,mA,x,y,&ax,&ay);
    printf(" Aceleracao do corpo 1 [Km/h^2]   : ( %.2f , %.2f )\n", ax, ay);
    
    /*Aceleração gravit. em relação a 2*/
    aceleracao_gravitacional(xB,yB,mB,x,y,&ax,&ay); 
    printf(" Aceleracao do corpo 2 [Km/h^2]   : ( %.2f , %.2f )\n", ax, ay);
    
    /*Aceleração resultante da nave em relação a 1 e 2*/
    aceleracao_resultante(xA,yA,mA,xB,yB,mB,x,y,&ax,&ay); 
    printf(" Aceleracao gravitacional resultante: ( %.2f , %.2f )\n\n", ax, ay);
}

void mostre_aceleracao(
  float xA, float yA, float mA,
  float x, float y, float ax, float ay
)
{
  printf(" Posicao do corpo         [Km, Km]      : ( %.2f , %.2f )\n", xA, yA);
  printf(" Massa do corpo           [Kg]          : %.2e\n", mA);
  printf(" Posicao da nave          [Km, Km]      : ( %.2f , %.2f )\n",x,y);
  printf(" Aceleracao gravitacional [Km/h^2]      : ( %.2f , %.2f )\n\n",ax, ay);
}
