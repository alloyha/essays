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
#include "physics.h"
#include "utils.h"

/* ----------------------- *
 * MAIN                    *
 * ----------------------- */
int main() {

  FILE  *entrada ;
  char  nome_arquivo[FILENAME_MAXTAM] ;
  char  codigo ;

  float x0, y0, vx0, vy0; 
  float x, y, vx, vy, ax, ay;
  float xA, yA, mA;
  float xB, yB, mB;
  
  float hora_max, dt, hora_viagem, distancia_percorrida;
  
  int iT, jT, iL, jL,iN, jN;
  
  bool imprime_mapa=false;
  bool fim_loop=false;
  bool fim_duracao=false, aterrisou_terra=false, aterrisou_lua=false;

  printf("\nArquivo de entrada :  ") ;
  scanf("%s", nome_arquivo) ;
  printf("\n") ;

  entrada = fopen(nome_arquivo, "r") ;
  if(entrada==NULL) {
    printf("Arquivo %s nao existe ou ocorreu erro na abertura.\n\n",
	    nome_arquivo) ;
    return 0 ;
  }
  
  // Limpa o \n...
  scanf("%c", &codigo) ;

  // Laco principal
  while(!feof(entrada)) {

    fscanf(entrada, "%c", &codigo) ;

    switch (codigo) {
    
    case 'a':
        // Posição do corpo celeste
        fscanf(entrada,"%f %f", &xA, &yA);

        // Massa do Corpo celeste
        fscanf(entrada,"%f", &mA);

        // Posição nave
        fscanf(entrada,"%f %f", &x, &y);

        printf("Opcao [%c]:\n", codigo);
        
        // Aceleração gravitacional da nave em relação ao corpo celeste*/
        aceleracao_gravitacional(xA,yA,mA,x,y,&ax,&ay);

        mostre_aceleracao(xA, yA, mA, x, y, ax, ay);
        espere_enter();

      break ;

    // Exibe acelerações
    case 'A':
        // Posição 1
        fscanf(entrada,"%f %f", &xA, &yA); 
        
        // Massa 1
        fscanf(entrada,"%f", &mA);

        // Posição 2
        fscanf(entrada,"%f %f", &xB, &yB); 
        
        // Massa 2
        fscanf(entrada,"%f", &mB);

        // Posição nave
        fscanf(entrada,"%f %f", &x, &y);

        printf("Opcao [%c]:\n",codigo);
        
        mostre_aceleracao_resultante(
          xA, yA, mA, 
          xB, yB, mB, 
          x, y, ax, ay
        );

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

        mostre_velocidade_de_escape(
          xA, yA, mA, 
          x, y
        );
        
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
        
        mostre_lagrangiano(
          xA, yA, mA, 
          xB, yB, mB, 
          x, y
        );
        
        espere_enter();

      break ;

    // Exibe mapa e dados
    case 's':

        fscanf(entrada,"%f %f", &x, &y);
        fscanf(entrada,"%f %f", &vx, &vy);
        fscanf(entrada,"%f", &hora_max);
        fscanf(entrada,"%f", &dt);
         
        quadrante(X_T,Y_T,&iT,&jT);
        quadrante(X_L,Y_L,&iL,&jL);
        aceleracao_resultante(
          X_T, Y_T, MTERRA,
          X_L, Y_L, MLUA,
          x, y, &ax, &ay);
        
        // quadrante (0,0) para a nave só para imprimir o mapa
        iN=jN=0, x0=x, y0=y, distancia_percorrida=0, hora_viagem=0;
        imprime_mapa=mostre_mapa(
          iT, jT, iL, jL,
          x, y, &iN, &jN
        );
        mostre_dados_viagem(
          hora_viagem, distancia_percorrida,
          x, y, vx, vy, ax, ay
        );

        espere_enter();
        
        // Toda vez que 'mapa' for diferente de 0: 
        // o mapa é impresso e a variavel 'mapa' volta a zero
        imprime_mapa=false;

        // Enquanto variavel 'fim_loop' for 0, o laço ocorre 
        while(!fim_loop){
            // Atualiza valores
            distancia_percorrida=distancia_percorrida+distancia(x,y,x0,y0);
            x0=x, y0=y;
            
            // Pode alterar 'mapa' para 1 (imprime mapa) ou permanecer em 0
            imprime_mapa=mostre_mapa(
              iT, jT, iL, jL, 
              x, y, &iN, &jN
            );
            
            if(imprime_mapa){
                imprime_mapa=false;
                mostre_dados_viagem(
                  hora_viagem, distancia_percorrida,
                  x, y, vx, vy, ax, ay
                );
                espere_enter();
            }
            
            // Velocidades vx0 e vy0 imediatamente dt tempo antes do instante atual
            hora_viagem=hora_viagem+dt;
            vx0=vx, vy0=vy;

            aceleracao_resultante(
              X_T, Y_T, MTERRA, X_L, Y_L, MLUA, 
              x, y, &ax, &ay
            );
            
            atualizar_estados(
              &x, &y, &vx, &vy, vx0, vy0, ax, ay, dt 
            );
            
            if(hora_viagem >= hora_max) fim_loop=true;
            else if(distancia(x,y,X_T,Y_T)<RTERRA) fim_loop=true;
            else if(distancia(x,y,X_L,Y_L)<RLUA) fim_loop=true;
        
            printf("Hora de viagem: %.2f\n", hora_viagem);
        }
        
        fim_duracao = hora_viagem >= hora_max;
        aterrisou_terra = distancia(x,y,X_T,Y_T)<RTERRA;
        aterrisou_lua = distancia(x,y,X_L,Y_L)<RLUA;
        fim_loop = fim_duracao | aterrisou_terra | aterrisou_lua;
        
        if(fim_duracao) {
            printf("Apos %.2f horas de voo, a nave ainda esta em orbita!\n", hora_viagem);
        } else if(aterrisou_terra) {
            printf("A nave colide com a Terra em %.2f horas de voo!\n", hora_viagem);
        } else if(aterrisou_lua) {
            printf("A nave colide com a Lua em %.2f horas de voo!\n", hora_viagem);
        }
        
        espere_enter();
        
        printf("\n");
        printf("Fim de Processamento!\n");

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

