/**********************************************************************/
/**                                                                  **/
/**   Bruno Henrique Lobo Netto Peixoto          Número USP 7206666  **/
/**   Exercício-Programa 3 - EP3                                     **/
/**   Professor: Nina S. T. Hirata                                   **/
/**   Turma: 8                                                       **/
/**                                                                  **/
/**********************************************************************/

#include <stdio.h>
#include <math.h>

// Massa da Terra
#define MTERRA   5.97e+24

// Massa da Lua
#define MLUA     7.35e+22

// Constante gravitacional universal
#define G        8.65e-13

// Raio da Terra
#define RTERRA   6378

// Raio da Lua
#define RLUA     1738

// Posicoes (fixas) da terra e lua no sistema cartesiano
#define X_T          0
#define Y_T          0
#define X_L          D
#define Y_L          0

// Distancia da terra a lua
#define D        384400


// Definicoes usadas para exibir
#define MAXLINHA    25
#define MAXCOL      80
#define LARGURA     5414

// Outras
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

/* ----------------------- *
 * MAIN                    *
 * ----------------------- */

int main() {

  FILE  *entrada ;
  char  nome_arquivo[FILENAME_MAXTAM] ;
  char  codigo ;

  float x0, y0, vx0, vy0, x, y, vx, vy, ax, ay;
  float xA, yA, mA, xB, yB, mB; 
  float hora_max, dt, hora_viagem, distancia_percorrida;
  int iT, jT, iL, jL,iN, jN, mapa, flag=0;

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
       /*Posição do corpo celeste*/
        fscanf(entrada,"%f %f", &xA, &yA);

        /*Massa do Corpo celeste*/
        fscanf(entrada,"%f", &mA);

        /*Posição nave*/    
        fscanf(entrada,"%f %f", &x, &y);

        /*Aceleração gravitacional da nave em relação ao corpo celeste*/
        aceleracao_gravitacional(xA,yA,mA,x,y,&ax,&ay);

        printf("Opcao [%c]:\n", codigo);
        printf(" Posicao do corpo         : ( %.2f , %.2f )\n", xA, yA);
        printf(" Massa do corpo           : %.2e\n", mA);
        printf(" Posicao da nave          : ( %.2f , %.2f )\n",x,y);
        printf(" Aceleracao gravitacional : ( %.2f , %.2f )\n\n",ax, ay);
        espere_enter();

      break ;

    // Exibe acelerações
    case 'A':
        /*Posição 1*/
        fscanf(entrada,"%f %f", &xA, &yA); 
        
        /*Massa 1*/
        fscanf(entrada,"%f", &mA);

        /*Posição 2*/
        fscanf(entrada,"%f %f", &xB, &yB); 
        
        /*Massa 2*/
        fscanf(entrada,"%f", &mB);

        /*Posição nave*/
        fscanf(entrada,"%f %f", &x, &y);

        printf("Opcao [%c]:\n",codigo);
        printf(" Posicao do corpo 1 : ( %.2f , %.2f )\n", xA, yA);
        printf(" Massa do corpo 1   : %.2e\n", mA);
        printf(" Posicao do corpo 2 : ( %.2f , %.2f )\n", xB, yB);
        printf(" Massa do corpo 2   : %.2e\n", mB);
        printf(" Posicao da nave    : ( %.2f , %.2f )\n\n",x,y);
        
        /*aceleração resultante em relação a 1*/
        aceleracao_gravitacional(xA,yA,mA,x,y,&ax,&ay);
        printf(" Aceleracao gravitacional (corpo 1) : ( %.2f , %.2f )\n",ax, ay);
        
        /*Aceleração gravit. em relação a 2*/
        aceleracao_gravitacional(xB,yB,mB,x,y,&ax,&ay); 
        printf(" Aceleracao gravitacional (corpo 2) : ( %.2f , %.2f )\n",ax, ay);
        
        /*Aceleração resultante da nave em relação a 1 e 2*/
        aceleracao_resultante(xA,yA,mA,xB,yB,mB,x,y,&ax,&ay); 
        printf(" Aceleracao gravitacional resultante: ( %.2f , %.2f )\n\n",ax, ay);
        
        espere_enter();
      break ;

    // Exibe distâncias e velocidades
    case 'e':
        // Posição do corpo celeste
        fscanf(entrada,"%f %f", &xA, &yA); 
        
        // Massa do Corpo celeste
        fscanf(entrada,"%f", &mA);

        // Posição nave
        fscanf(entrada,"%f %f", &x, &y);
        
        printf("Opcao [%c]:\n", codigo);
        printf(" Posicao do corpo          : ( %.2f , %.2f )\n", xA, yA);
        printf(" Massa do corpo            : %.2e\n", mA);
        printf(" Posicao da nave           : ( %.2f , %.2f )\n",x,y);

        // Distancia entre corpo e nave
        printf(" Distancia do corpo a nave : %.2f\n", distancia(xA,yA,x,y)); 
        printf(" Velocidade de escape      : %.2f\n\n", velocidade_esc(xA,yA,mA,x,y)); /*Velocidade de escape*/
        
        espere_enter();

      break ;

    // Exibe pontos característicos
    case 'L':
        // Posição 1
        fscanf(entrada,"%f %f", &xA, &yA); 
        
        // Massa 1
        fscanf(entrada,"%f", &mA);

        // Posição 2
        fscanf(entrada,"%f %f", &xB, &yB); 
        
        // Massa 2
        fscanf(entrada,"%f", &mB); 
        printf("Opcao [%c]:\n",codigo);
        printf(" Posicao do corpo 1 : ( %.2f , %.2f )\n", xA, yA);
        printf(" Massa do corpo 1   : %.2e\n", mA);
        printf(" Posicao do corpo 2 : ( %.2f , %.2f )\n", xB, yB);
        printf(" Massa do corpo 2   : %.2e\n", mB);
        ponto_L1(xA,yA,mA,xB,yB,mB,&x,&y);
        printf(" Ponto Lagrangeano  : ( %.2f , %.2f )\n\n",x,y);
        
        espere_enter();

      break ;

    // Exibe mapa e dados
    case 's':

      fscanf(entrada,"%f %f", &x,&y);
      fscanf(entrada,"%f %f", &vx,&vy);
      fscanf(entrada,"%f", &hora_max);
      fscanf(entrada,"%f", &dt);
      quadrante(X_T,Y_T,&iT,&jT);
      quadrante(X_L,Y_L,&iL,&jL);
      aceleracao_resultante(X_T,Y_T,MTERRA,X_L,Y_L,MLUA,x,y,&ax,&ay);
      
      //quadrantes(0,0) para a nave só para imprimir o mapa
      iN=jN=0, x0=x, y0=y, distancia_percorrida=0, hora_viagem=0;
      mapa=mostre_mapa(iT,jT,iL,jL,x,y,&iN,&jN);
      
      mostre_dados(hora_viagem,distancia_percorrida,x,y,vx,vy,ax,ay);
      espere_enter();
      
      // Toda vez que 'mapa' for diferente de 0: 
      // o mapa é impresso e a variavel 'mapa' volta a zero
      mapa=0;

      // Enquanto variavel 'flag' for 0, o laço ocorre 
      while(!(flag)){
         distancia_percorrida=distancia_percorrida+distancia(x,y,x0,y0);
         x0=x, y0=y;
         
         // Pode alterar 'mapa' para 1 (imprime mapa) ou permanecer em 0
         mapa=mostre_mapa(iT,jT,iL,jL,x,y,&iN,&jN);
         
         if(mapa){
            mapa=0;
            mostre_dados(hora_viagem,distancia_percorrida,x,y,vx,vy,ax,ay);
            espere_enter();
         }
         
         
         // Velocidades vx0 e vy0 imediatamente dt tempo antes do instante atual
         hora_viagem=hora_viagem+dt;
         vx0=vx, vy0=vy;
         aceleracao_resultante(X_T,Y_T,MTERRA,X_L,Y_L,MLUA,x,y,&ax,&ay);
         vx=vx+ax*dt;
         vy=vy+ay*dt;
         x=x+vx0*dt;
         y=y+vy0*dt;

         if(sao_iguais(hora_viagem,hora_max)) flag++;
         else if(distancia(x,y,X_T,Y_T)<RTERRA)flag++;
         else if(distancia(x,y,X_L,Y_L)<RLUA) flag++;
      }

      flag=0;
      
      if(sao_iguais(hora_viagem,hora_max)) {
        printf("Apos %.2f horas de voo, a nave ainda esta em orbita!\n", hora_viagem);
      } else if(distancia(x,y,X_T,Y_T)<RTERRA) {
        printf("A nave colide com a Terra em %.2f horas de voo!\n",hora_viagem);
      } else if(distancia(x,y,X_L,Y_L)<RLUA) {
        printf("A nave colide com a Lua em %.2f horas de voo!\n",hora_viagem);
      }
      
      espere_enter();
      
      printf("\n");
      printf("Fim de Processamento!");

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

void quadrante(float x, float y, int *i, int *j) 
{
  *i= (y + 13.5*LARGURA)/LARGURA;
  *j= (x + 5.5*LARGURA)/LARGURA;
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
    return sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
}

float velocidade_esc(float xA, float yA,
                     float mA,
                     float x, float y) {
    return sqrt(2*G*mA/distancia(xA,yA,x,y));
}

void aceleracao_gravitacional(float xA, float yA, float mA,
			      float x,  float y,
			      float *ax, float *ay) {
    float acel_total;
    acel_total=G*mA/(distancia(xA,yA,x,y)*distancia(xA,yA,x,y));
    
    float cos_alpha, sin_alpha;
    
    cos_alpha=(xA-x)/distancia(xA,yA,x,y);
    sin_alpha=(yA-y)/distancia(xA,yA,x,y);

    // ax=acel_total*cos(alfa)
    *ax=acel_total*cos_alpha;

    // ay=acel_total*sin(alfa)
    *ay=acel_total*sin_alpha;
}

void aceleracao_resultante(
    float xA, float yA, float mA,
		float xB, float yB, float mB,
		float x, float y, float *ax, float *ay
  ) {
    float ax_A,ay_A,ax_B, ay_B;

    aceleracao_gravitacional(xA,yA,mA,x,y,&ax_A, &ay_A);
    aceleracao_gravitacional(xB,yB,mB,x,y,&ax_B, &ay_B);
    
    *ax=ax_A+ax_B;
    *ay=ay_A+ay_B;
}

void ponto_L1(
    float xA, float yA, float mA,
    float xB, float yB, float mB,
    float *x,  float *y
  ) {
    float L;
    
    /* 
      (mA-mB)*L^2-2*mA*D*L+A*D*D=0  <==> L=sqrt(mA)*D/sqrt(mA)+sqrt(mB), 
      tanto para mA!=mB ou mA=mB 
    */
    L=(sqrt(mA)/sqrt(mA)+sqrt(mB))*distancia(xA,yA,xB, yB);
    
    *x=xA+L*(xB-xA)/distancia(xA,yA,xB, yB);
    *y=yA+L*(yB-yA)/distancia(xA,yA,xB, yB);
}

void mostre_dados(
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
