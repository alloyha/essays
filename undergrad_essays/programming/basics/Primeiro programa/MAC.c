#include <stdio.h>
int main(){
    int posit, negat, x;
    printf("Digite uma sequencia de numeros inteiros, negativos e/ou positivos.");
    printf("Digite o primeiro numero: ");
    scanf("%d", &x);
    posit=0 ;
    negat=0 ;
    while (x!=0){
        if (x>0){
            posit = posit + x;
            printf("A soma dos numeros positivos e %d e dos negativos, %d\n.", posit, negat);
            printf("Digite o proximo numero: ");
            scanf("%d", &x);
        }
        else {
            negat = negat + x;
            printf("A soma dos numeros positivos e %d e dos negativos, %d\n.", posit, negat);
            printf("Digite o proximo número: ");
            scanf("%d", &x);
            }
        scanf("%d", &x);
        }
    printf("A soma dos números positivos é %d e a soma dos negativos é %d\n.", posit, negat);
    return 0;
}
