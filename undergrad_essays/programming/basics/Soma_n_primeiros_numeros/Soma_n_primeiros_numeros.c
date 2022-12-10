#include <stdio.h>
int main(){
    int n, result, num;
    result=0;
    printf("Digite um numero inteiro positivo: ");
    scanf("%d", &n);
    num=n;
    while (n!=0){
        result=result+n;
        n=n-1;
    }
    printf("A soma dos %d primeiros Nos maiores que 0 e' %d\n\n", num, result);
    return 0;
}
