#include <stdio.h>
int main(){
    int n_alunos, nota1, nota2, maior, menor;
    printf("Digite o número de notas de entrada: ");
    scanf("%d", &n_alunos);
    printf("Digite as notas de entrada: ");
    scanf("%d", &nota1);
    maior=nota1, menor=nota1;
    while (n_alunos!=0){
        scanf("%d", &nota2);
        if (nota2>maior) maior=nota2;
        if (nota2<menor) menor=nota2;
        n_alunos=n_alunos-1;
    }
    printf("A maior nota e' %d e a menor, %d", maior, menor);
    return 0;
}
