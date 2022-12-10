#include <stdio.h>
int main(){
    int n, j, m;
    printf("Numero de congruentes modulo que quer (0 para parar): ");
    scanf("%d", &n);
    while(n!=0){
       printf("Numero inicial: ");
       scanf("%d", &j);
       printf("Divisor: ");
       scanf("%d", &m);
       printf("%d ./' %d=", j, m);
       while(n>1){
          printf(" %d ./' %d=", j+m, m);
          j=j+m;
          n--;
       }
       printf(" %d\n\n", j%m);
       printf("Numero de congruentes modulo que quer (0 para parar): ");
       scanf("%d", &n);           
    }
}
