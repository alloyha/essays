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

void apagar_bloco(int n_linhas, int n_colunas) {
  /**
   * @brief Clears a block of characters on the terminal screen.
   *
   * This function moves the cursor to the beginning of the next line and then clears a 
   * rectangular block
   * of characters specified by the number of lines (n_linhas) and columns (n_colunas).
   * After clearing the block, it moves the cursor back to the original position.
   *
   * @param n_linhas The number of lines in the block to be cleared.
   * @param n_colunas The number of columns in the block to be cleared.
   */

    for(int i=0; i<n_linhas; ++i) {
        // Move cursor para começo desta linha
        printf("\r");

        // Sobe o cursor uma linha
        printf("\033[1A");

        // Imprime n_colunas espaços
        for (int j = 0; j < n_colunas; ++j) {
            printf(" ");
        }
    }

    // Apaga n_colunas caracteres da primeira linha
    for (int j = 0; j < n_colunas; ++j) {
        printf("\b");
    }
}

void apagar_linhas(int n_linhas){
  apagar_bloco(n_linhas, MAXCOL+2);
}

void apagar_espere_enter(){
  apagar_linhas(5);
}

void apagar_mapa(){
  apagar_linhas(MAXLINHA);
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
  *i= (int) (y + 13.5*LARGURA)/LARGURA;
  *j= (int) (x + 5.5*LARGURA)/LARGURA;
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

