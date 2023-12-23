#ifndef DISPLAY_H  // Include guard: checks if DISPLAY_H is not defined
#define DISPLAY_H

#include <stdio.h>
#include <stdbool.h>
#include "constants.h"

void imprimir_cerca();

void imprimir_quadro(
  int i, int j, 
  int novo_i, int novo_j,
  int iT, int jT, 
  int iL, int jL
);

bool mostre_mapa(
  int iT, int jT, 
  int iL, int jL,
  float x, float y, 
  int *iN, int *jN
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
  float xB, float yB, float mB
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

void mostre_viagem(
    int iT, int jT, int iL, int jL, int *iN, int *jN, 
    float x, float y, float vx, float vy, float ax, float ay,
    float hora_viagem, float distancia_percorrida
);

void opcao_aceleracao(FILE *entrada);

void opcao_aceleracao_resultante(FILE *entrada);

void opcao_lagrangiano(FILE *entrada);

void opcao_velocidade_de_escape(FILE *entrada);

void opcao_viagem(FILE *entrada);

#endif  // DISPLAY_H