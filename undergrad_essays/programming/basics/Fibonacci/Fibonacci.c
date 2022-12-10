#include <stdio.h>
int main(){
    int n, termo, antip, penult;
    printf("Digite qual termo quer da sequencia de Fibonacci (0 para sair): ");
    scanf("%d", &n);
    antip=1, penult=1;
    printf("O %do termo da sequencia de Fibonacci e' ", n);
    while(n!=0){
       while(n>=3){
          termo=penult+antip;
          penult=termo;
          antip=penult;
          n--;                 
       }
       printf("%d\n\n", penult);
       printf("Digite qual termo quer da sequencia de Fibonacci (0 para sair): ");
       scanf("%d", &n);
       antip=1, penult=1;
       printf("O %d o termo da sequencia de Fibonacci e' ", n);                
    }
}
