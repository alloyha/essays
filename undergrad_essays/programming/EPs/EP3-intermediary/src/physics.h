#ifndef PHYSICS_H  // Include guard: checks if PHYSICS_H is not defined
#define PHYSICS_H

#include <stdio.h>
#include <math.h>

float velocidade_esc(
  float xA, float yA, float mA, float x, float y
);

void aceleracao_gravitacional(
  float xA, float yA, float mA,float x,  float y,float *ax, float *ay
);

void aceleracao_resultante(
    float xA, float yA, float mA,
		float xB, float yB, float mB,
		float x, float y, float *ax, float *ay
);

void ponto_lagrangeano(
    float xA, float yA, float mA,
    float xB, float yB, float mB,
    float *x,  float *y
);

void atualizar_estados(
  float dt,
  float* x, float* y, float* vx, float* vy, 
  float vx0,  float vy0, float ax,  float ay 
);

void atualizar_variaveis(
    float dt, float *hora_viagem, float *distancia_percorrida,
    float *x, float *y, float *vx, float *vy, float *ax, float *ay,
    float *x_1, float *y_1, float *vx_1, float *vy_1
);

#endif  // PHYSICS_H