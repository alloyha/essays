#include <stdio.h>
int main(){
    int maior, cat1, cat2, temp;
    printf("Digite as medidas dos lados do triangulo (0 para parar): ");
    scanf("%d", &maior);
    while (maior!=0){
        scanf("%d", &cat1);
        if(cat1>maior){
            temp=maior;
            maior=cat1;
            cat1=temp;
        }
        scanf("%d", &cat2);
        if (cat2>maior){
            temp=maior;
            maior=cat2;
            cat2=temp;
        }
        if(maior*maior==cat1*cat1+cat2*cat2) printf("Os tres Nos formam um triangulo retangulo pois %d = %d + %d\n\n", maior*maior, cat1*cat1, cat2*cat2);
        else printf("Os tres Nos nao formam um triangulo retangulo pois %d != %d + %d\n\n", maior*maior, cat1*cat1, cat2*cat2);
        printf("Digite outros tres lados de um triangulo (0 para parar): ");
        scanf("%d", &maior);
    }
}
