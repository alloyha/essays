#include <stdio.h>
int main(){
    int result, num;
    result=1;

    printf("Digite um No inteiro maior que zero: ");
    scanf("%d", &num);

    while (num>0){
        result=result*num;
        num=num-1;
    }
    printf("Fatorial do No requisitado e' %d", result);
    return 0;
}
