#ifndef SIMULATION_H  // Include guard: checks if SIMULATION_H is not defined
#define SIMULATION_H

#include "constants.h"
#include "display.h"
#include "utils.h"
#include "physics.h"

void iniciar_simulacao(FILE *entrada) {
    char  codigo ;

    // Limpa o \n...
    scanf("%c", &codigo) ;

    // Laco principal
    while(!feof(entrada)) {
        fscanf(entrada, "%c", &codigo) ;

        switch (codigo) {

        case 'a':
            opcao_aceleracao(&entrada);
            espere_enter();

            break ;

        // Exibe acelerações
        case 'A':
            opcao_aceleracao_resultante(&entrada);
            espere_enter();
            
            break ;

        // Exibe distâncias e velocidades
        case 'e':
            opcao_velocidade_de_escape(&entrada);
            espere_enter();

            break ;

        // Exibe pontos característicos
        case 'L':
            opcao_lagrangiano(&entrada);
            espere_enter();

            break ;

        // Exibe mapa e dados
        case 's':
            opcao_viagem(&entrada);
            
            printf("\n");
            printf("Fim de Processamento!\n");

            break ;

        default:
            /* se o caractere lido não for nenhum dos anteriores, *
            * nao faz nada ...                                   */
            break;
        }
    }
}

#endif  // SIMULATION_H