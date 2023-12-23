#ifndef UTILS_H  // Include guard: checks if UTILS_H is not defined
#define UTILS_H

#include <stdio.h>
#include <stdbool.h>
#include "constants.h"

void espere_enter();

void apagar_bloco(int n_linhas, int n_colunas);

void apagar_linhas(int n_linhas);

void apagar_espere_enter();

void apagar_mapa();

void quadrante(float x, float y, int *i, int *j);

int sao_iguais(float x1, float x2);

float distancia(float x1, float y1, float x2, float y2);

#endif  // UTILS_H
