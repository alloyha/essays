#include <stdio.h>
int main(){
   int num, soma, divs;
   printf("Digite um numero inteiro positivo: ");
   scanf("%d", &num);
   while (num!=0){
      soma=0;
      for(divs=1; divs<num; divs++){
         if(num%divs==0) soma=soma+divs;            
      }
      if(soma==num) printf("O numero %d e' perfeito\n\n", num);
      else printf("O numero %d nao e' perfeito\n\n", num);
      printf("Digite outro numero inteiro positivo: ");
      scanf("%d", &num);
   } 
   return 0;
}
