#include <stdio.h>
int main(){
   int m, i, k;
   printf("Digite um numero inteiro acima de 0: ");
   scanf("%d", &m);
   printf("\n");
   while (m!=0){
      for (i=1;i<=m;i++){
         printf("%d*%d*%d = %d = %d", i, i, i, i*i*i, i*i-i+1);
         for(k=1;k<i;k++){
            printf(" + %d", i*i-i+1+2*k);
         }
         printf("\n");
      }
      printf("\n");
      printf("Digite outro numero maior que 0 (0 para parar): ");
      scanf("%d", &m);
   }
}
