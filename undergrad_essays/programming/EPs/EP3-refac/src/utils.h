#ifndef UTILS_H  // Include guard: checks if UTILS_H is not defined
#define UTILS_H

#include <stdio.h>
#include <stdbool.h>
#include "constants.h"

void espere_enter();

void quadrante(float x, float y, int *i, int *j);

int sao_iguais(float x1, float x2);

float distancia(float x1, float y1, float x2, float y2);

void imprimir_cerca();

void imprimir_quadro(
  int i, int j, int novo_i, int novo_j,
  int iT, int jT, int iL, int jL
);

int mostre_mapa(
  int iT, int jT, int iL, int jL,
  float x, float y, int *iN, int *jN
);

void mostre_dados_viagem(
    float hora,
    float distancia_percorrida,
    float x,  float y,
    float vx, float vy,
    float ax,   float ay 
);

void mostre_lagrangiano(
  float xA, float yA, float mA,
  float xB, float yB, float mB,
  float x, float y
);

void mostre_velocidade_de_escape(
  float xA, float yA, float mA,
  float x, float y
);

void mostre_aceleracao_resultante(
  float xA, float yA, float mA,
  float xB, float yB, float mB,
  float x, float y, float ax, float ay
);

void mostre_aceleracao(
  float xA, float yA, float mA,
  float x, float y, float ax, float ay
);

#endif  // UTILS_H
