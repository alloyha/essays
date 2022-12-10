#include <stdio.h>
int main(){
    int a, b, resto;
    printf("Digite dois numeros inteiros: ");
    scanf("%d %d", &a, &b);
    printf("MDC(%d, %d)= ", a, b);
    while(a!=0){
       while (a%b!=0){
          resto=a%b;
          b=resto;
          a=b;
          }
       printf("%d\n", b);
       printf("Digite dois numeros inteiros: ");
       scanf("%d %d", &a, &b);
       printf("MDC(%d, %d)= ", a, b);
    }
    return 0;
}
