#include <stdio.h>
int main(){
    int num, teste, n;
    printf("Digite um numero inteiro positivo: ");
    scanf("%d", &num);
    n=1, teste=0;
    while (teste<num){
        teste=(n*n*n)-n;
        n=n+1;
    }
    if (teste==num) printf("O numero %d e' triangular.\n", num);
    else  printf("O numero %d nao e' triangular./n", num);
    return 0;
}
