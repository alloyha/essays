#include <stdio.h>
int main(){
    int num, quad;
    printf("Digite uma sequencia de Nos terminada em 0: ");
    scanf("%d", &num);
    while (num!=0){
        quad=num*num;
        printf("%d ao quadrado e' %d\n", num, quad);
        scanf("%d", &num);
        quad=0;
    }
    return 0;
}
