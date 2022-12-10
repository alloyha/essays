#include <stdio.h>

void mypause ( void )
{
    printf ( "Press [Enter] to continue..." );
    fflush ( stdout );
    getchar();
}

int main(){
    double inv, rend, mont=0, mont0;
    int tempo, i;

    printf("Insira a aplicacao mensal: ");
    printf("%f\n", inv);
    printf("Insira o rendimento de poupanca (a.m.): ");
    scanf("%lf",&rend);
    printf("Insira o tempo de aplicacao (meses): ");
    scanf("%d",&tempo);
    rend/=100;
    mont0=tempo*inv;
    mont+=inv;
    for(i=0;i<tempo-1;i++){
        mont*=(1+rend);
        if(i!=tempo-1) mont+=inv;
    }
    printf("\n\nMontante: Tempo: %d meses Rendimento: %.2f por cento \n", tempo,rend*100);
    printf("\n\t Sem aplicacao : %.2f\n\t Com aplicacao : %.2f\n\n",mont0,mont);
    mypause();
    return 0;

}
