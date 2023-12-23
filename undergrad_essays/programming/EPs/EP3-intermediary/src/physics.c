#include <stdio.h>
#include <math.h>
#include "utils.h"
#include "physics.h"

float velocidade_esc(float xA, float yA,
                     float mA,
                     float x, float y) {
  /**
   * Calcula a velocidade de escape de um objeto em relação a outro objeto massivo.
   *
   * @param xA Coordenada x da posição do objeto massivo.
   * @param yA Coordenada y da posição do objeto massivo.
   * @param mA Massa do objeto massivo.
   * @param x Coordenada x da posição do objeto cuja velocidade de escape está sendo calculada.
   * @param y Coordenada y da posição do objeto cuja velocidade de escape está sendo calculada.
   *
   * @return A velocidade de escape calculada.
   */

    return sqrt(2*G*mA/distancia(xA,yA,x,y));
}

void aceleracao_gravitacional(
  float xA, float yA, float mA,
  float x,  float y,
  float *ax, float *ay
) {
  /**
   * Calcula a aceleração gravitacional exercida por um objeto massivo em um objeto de menor massa.
   * Os componentes da aceleração nas direções x e y são armazenados nos ponteiros ax e ay.
   *
   * @param xA Coordenada x da posição do objeto massivo.
   * @param yA Coordenada y da posição do objeto massivo.
   * @param mA Massa do objeto massivo.
   * @param x Coordenada x da posição do objeto de menor massa.
   * @param y Coordenada y da posição do objeto de menor massa.
   * @param ax Ponteiro para a variável que armazenará a componente x da aceleração gravitacional.
   * @param ay Ponteiro para a variável que armazenará a componente y da aceleração gravitacional.
   */

    float dist_AP;
    dist_AP=distancia(xA,yA,x,y);
    
    float acel_total;
    acel_total=G*mA/(dist_AP*dist_AP);
    
    float cos_alpha, sin_alpha;
    
    cos_alpha=(xA-x)/dist_AP;
    sin_alpha=(yA-y)/dist_AP;

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
    /**
     * Calcula a aceleração resultante exercida por dois objetos massivos em um objeto de menor massa.
     * Os componentes da aceleração nas direções x e y são armazenados nos ponteiros ax e ay.
     *
     * @param xA Coordenada x da posição do primeiro objeto massivo.
     * @param yA Coordenada y da posição do primeiro objeto massivo.
     * @param mA Massa do primeiro objeto massivo.
     * @param xB Coordenada x da posição do segundo objeto massivo.
     * @param yB Coordenada y da posição do segundo objeto massivo.
     * @param mB Massa do segundo objeto massivo.
     * @param x Coordenada x da posição do objeto de menor massa.
     * @param y Coordenada y da posição do objeto de menor massa.
     * @param ax Ponteiro para a variável que armazenará a componente x da aceleração resultante.
     * @param ay Ponteiro para a variável que armazenará a componente y da aceleração resultante.
     */

    float ax_A,ay_A,ax_B, ay_B;

    aceleracao_gravitacional(xA,yA,mA,x,y,&ax_A, &ay_A);
    aceleracao_gravitacional(xB,yB,mB,x,y,&ax_B, &ay_B);
    
    *ax=ax_A+ax_B;
    *ay=ay_A+ay_B;
}

void ponto_lagrangeano(
    float xA, float yA, float mA,
    float xB, float yB, float mB,
    float *x,  float *y
  ) {
    float lambda, dist_AB;
    dist_AB=distancia(xA,yA,xB, yB);

    /*
      Desenvolvimento tanto para mA!=mB ou mA=mB: 
        (mA-mB)*lambda^2-2*mA*D*lambda+A*D^2 = 0
        lambda = sqrt(mA)*D/sqrt(mA)+sqrt(mB)
    */
    float ratio = sqrt(mA)/(sqrt(mA)+sqrt(mB));
    lambda=ratio*dist_AB;

    *x=xA+lambda*(xB-xA)/dist_AB;
    *y=yA+lambda*(yB-yA)/dist_AB;
}

void atualizar_estados(
  float dt, 
  float* x, float* y,
  float* vx, float* vy, 
  float vx_1,  float vy_1,
  float ax_1,  float ay_1
)
{
  *x=(*x)+vx_1*dt;
  *y=(*y)+vy_1*dt;
  *vx=(*vx)+ax_1*dt;
  *vy=(*vy)+ay_1*dt;
}

void atualizar_variaveis(
    float dt, float *hora_viagem, float *distancia_percorrida,
    float *x, float *y, float *vx, float *vy, float *ax, float *ay,
    float *x_1, float *y_1, float *vx_1, float *vy_1
) {
    // Atualiza valores
    float dist_AB = distancia(*x, *y, *x_1, *y_1);
    *distancia_percorrida=*distancia_percorrida+dist_AB;
    
    *hora_viagem = *hora_viagem+dt;
    *vx_1 = *vx;
    *vy_1 = *vy;
    
    aceleracao_resultante(
        X_T, Y_T, MTERRA, X_L, Y_L, MLUA, 
        *x, *y, ax, ay
    );
    
    atualizar_estados(
        dt, 
        x, y, vx, vy, 
        *vx_1, *vy_1, *ax, *ay 
    );
}