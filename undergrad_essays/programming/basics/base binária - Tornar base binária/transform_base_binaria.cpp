#include <stdio.h>
int main(){
    int num, pot, base, x;
    printf("Entre com um numero em base decimal (0 para parar): ");
    scanf("%d", &num);
    printf("%d em base binaria corresponde a ", num);
    while(num!=0){
       base=0;
       while (num!=0){
          for(pot=1, x=0; pot<=num; pot=pot*2) x++;
          num=num-pot/2;
          pot=1;
          while(x>1){
             pot=pot*10;
             x--;           
          }
          base=base+pot;
       }
       printf("%d\n\n", base);
       printf("Entre com um numero em base decimal (0 para parar): ");
       scanf("%d", &num);
       printf("%d em base binaria corresponde a ", num);
    }
    return 0;    
}
