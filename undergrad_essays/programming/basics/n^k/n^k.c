#include <stdio.h>
int main(){
    int pot, num, k;
    pot=1;

    printf("Digite a base de sua potencia: ");
    scanf("%d", &num);
    printf("Digite um No positivo, que sera' o expoente: ");
    scanf("%d", &k);

    while (k>0){
        pot=pot*num;
        k=k-1;
    }
    printf("O resultado e' %d.", pot);

    return 0;
}
