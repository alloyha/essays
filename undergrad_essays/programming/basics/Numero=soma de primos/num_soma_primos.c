#include <stdio.h>
int primo(int a);
int main(){
    int num, a, b, m=0;
    printf("Digite um numero inteiro maior que zero (0 para parar): ");
    scanf("%d", &num);
    while(num!=0){
        for(a=0,b=num;a<=b;a++,b--){
            if (primo(a)==1 && primo(b)==1){
                printf("%d=%d+%d\n", num, a, b);
                m++;
            }
        }
        printf("%d", m);
        if(m=0) printf("Nao ha' Nos primos cuja soma seja %d\n", num);
        printf("\n");
        m=0;
        printf("Digite um numero inteiro maior que zero (0 para parar): ");
        scanf("%d", &num);
    }
    return 0;
}
int primo(int a){
    int i, alert=0;
    for(i=1; i<=a; i++){
        if(a%i==0) alert++;
    }
    if(alert==2) return 1;
    else return 0;
}
