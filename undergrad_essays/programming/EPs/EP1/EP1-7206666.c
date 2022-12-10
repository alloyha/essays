/**********************************************************************/
/**                                                                  **/
/**   Bruno Henrique Lôbo Netto Peixoto          Número USP 7206666  **/
/**   Exercício-Programa 1 - EP1                                     **/
/**   Professor: Nina S. T. Hirata                                   **/
/**   Turma: 8                                                       **/
/**                                                                  **/
/**********************************************************************/
#include <stdio.h>
int main(){
    int num, x1, x2, x3, x4, x5, x6, x7, x8, x9, soma1, soma2, soma3, soma4, soma5, soma6, soma7, soma8;
    x1=x2=x3=x4=x5=x6=x7=x8=x9=0;

    printf("Digite um No positivo com 9 digitos (0 para parar): ");
    scanf("%d", &num);
    while (num!=0){
        while (num>=100000000){
            num=num-100000000;
            x1=x1+1;
        }
        while (num>=10000000){
            num=num-10000000;
            x2=x2+1;
        }
        while (num>=1000000){
            num=num-1000000;
            x3=x3+1;
        }
        while (num>=100000){
            num=num-100000;
            x4=x4+1;
        }
        while (num>=10000){
            num=num-10000;
            x5=x5+1;
        }
        while (num>=1000){
            num=num-1000;
            x6=x6+1;
        }
        while (num>=100){
            num=num-100;
            x7=x7+1;
        }
        while (num>=10){
            num=num-10;
            x8=x8+1;
        }
        while (num>=1){
            num=num-1;
            x9=x9+1;
        }
        soma1=x1+x2+x3;
        soma2=x4+x5+x6;
        soma3=x7+x8+x9;
        soma4=x1+x4+x7;
        soma5=x2+x5+x8;
        soma6=x3+x6+x9;
        soma7=x1+x5+x9;
        soma8=x3+x5+x7;
        if (soma1==soma2 && soma2==soma3 && soma3==soma4 && soma4==soma5 && soma5==soma6 && soma6==soma7 && soma7==soma8){
            if (soma7==soma8){
                printf("%d  %d  %d - %2d\n%d  %d  %d - %2d\n%d  %d  %d - %2d\n-- -- --  \n%2d %2d %2d \nSoma diagonal principal: %d\nSoma diagonal secundaria: %d\n\n", x1, x2, x3, soma1, x4, x5, x6, soma2, x7, x8, x9, soma3, soma4, soma5, soma6, soma7, soma8);
                printf("O quadrado e' magico :-).\n\n");
            }
        }
        else {
            printf("%d  %d  %d -  %d\n%d  %d  %d -  %d\n%d  %d  %d -  %d\n-- -- --  \n%d  %d  %d \nSoma diagonal principal: %d\nSoma diagonal secundaria: %d\n\n", x1, x2, x3, soma1, x4, x5, x6, soma2, x7, x8, x9, soma3, soma4, soma5, soma6, soma7, soma8);
            printf("O quadrado nao e' magico :-(.\n\n");
        }
        printf("Digite outro numero com 9 digitos (0 para parar): ");
        scanf("%d", &num);
        x1=0, x2=0, x3=0, x4=0, x5=0, x6=0, x7=0, x8=0, x9=0;
    }
    return 0;
}
