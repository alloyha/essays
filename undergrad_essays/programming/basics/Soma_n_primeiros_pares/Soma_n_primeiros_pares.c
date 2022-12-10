#include <stdio.h>
int main(){
    int n, soma, x;
    soma=0, n=0;
    printf("Digite um numero inteiro: ");
    scanf("%d", &x);
    while(n!=x){
        if (x%2==0){
            soma=soma+x;
            n=n+1;
        }
    }
    printf("A soma dos %d primeiros inteiros pares e' %d", x, soma);
    return 0;
}
