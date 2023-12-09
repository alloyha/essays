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
  float* x, float* y,
  float* vx, float* vy, 
  float vx0,  float vy0,
  float ax,  float ay,
  float dt 
);

#endif  // PHYSICS_H