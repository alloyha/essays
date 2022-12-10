#include <stdio.h>
int main(){
    int no_dias, qtd1, qtd2, maior, dia;
    no_dias=0;
    printf("Digite a quantidade de discos de cada dia do mes: ");
    scanf("%d", &qtd1);
    qtd1=maior;
    while (no_dias<=30){
        scanf("%d", &qtd2);
        if (qtd2>qtd1) dia=no_dias, maior=qtd2;
        no_dias=no_dias+1;
        qtd1=qtd2;
    }
    printf("O dia %d de marco vendeu %d discos, a maior venda do mes", dia, maior);
    return 0;
}
