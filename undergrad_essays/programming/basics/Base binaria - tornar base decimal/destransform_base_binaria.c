#include <stdio.h>
int main(){
   int base, pot, num;
   printf("Entre com uma base binaria (0 para sair): ");
   scanf("%d", &base);
   printf("%d em base binaria corresponde a ", base);
   while(base!=0){
      num=0;
      for(pot=1; base!=0; pot=pot*2){
         num=(base%10)*pot+num;
         base=base/10;
      }
      printf("%d em base decimal.\n\n", num);
      printf("Entre com uma base binaria (0 para sair): ");
      scanf("%d", &base);
      printf("%d em base binaria corresponde a ", base);            
   }
}
