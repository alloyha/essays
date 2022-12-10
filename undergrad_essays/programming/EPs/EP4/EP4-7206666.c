/**********************************************************************/
/**                                                                  **/
/**   Bruno Henrique Lôbo Netto Peixoto          Número USP 7206666  **/
/**   Exercício-Programa 4 - EP4                                     **/
/**   Professor: Nina S. T. Hirata                                   **/
/**   Turma: 8                                                       **/
/**                                                                  **/
/**********************************************************************/

#include <stdio.h>
#include <string.h>
#define K 3
#define DOISKUM 7 /* 2^k - 1 */
#define NMAX 61
int read(int V[K][NMAX], int x);
int Vizinho( int Q[K], int d, int P[K]);
int W( int P[K], int Q[K], char S[K][NMAX], int r, int q, int g );
int main(){
    int r, q, g, k,i, j, l, print, len[K], Q[K], P[K],PPLUSWAY[DOISKUM], p[NMAX][NMAX][NMAX], max=0, x;
    char S[K][NMAX], lol;
    printf("Digite os respectivos parametros r, q e g: ");
    scanf("%d %d %d", &r, &q, &g);
    printf("\nDigite o numero de sequencias a serem alinhadas (3 para este EP): ");
    scanf("%d", &k);
    scanf("%c",&lol);
    for(i=0;i<K;i++){
        printf("\nDigite uma sequencia a ser alinhada: ");
        gets(S[i]);
        len[i] = strlen(S[i]); }                                                 /* Devido ao fato de que o parametro k é uma mera */
    printf("\nDeseja imprimir a matriz-potuacaoo(1 para SIM/ 0 para NAO): ");    /* formalidade, já que, neste EP, k=3, ele será   */
    scanf("%d", &print);                                                         /* utilizado  como coordenada variavel a seguir   */
    p[0][0][0]=0;
    for(i=0;i<=len[0];i++){
        for(j=0;j<=len[1];j++){
            for(k=0;k<=len[2];k++){
                Q[0]=i; Q[1]=j; Q[2]=k;
                for(l=1;l<=DOISKUM;l++){ if(Vizinho(Q,l,P)) PPLUSWAY[l-1]=p[P[0]][P[1]][P[2]]+W(P,Q,S,r,q,g); }
                max=PPLUSWAY[0];
                for(l=0;l<DOISKUM;l++){ if(PPLUSWAY[l]>max) max=PPLUSWAY[l]; }
                p[i][j][k]=max;
            }
        }
    }
    for(i=0;i<=len[0];i++){
        for(j=0;j<=len[1];j++){
            for(k=0;k<=len[2];k++) printf("%5d ", p[i][j][k]);
            printf("\n");
        }
        printf("\n\n");
    }
    printf("Maxima Pontuacao de alinhamento: %d\n",p[len[0]][len[1]][len[2]]);


    return 0;
    }

/*int Vizinho( int Q[K], int d, int P[K]){
    int X[K], i;
    for(i=4;i>=1;i/=2){ X[i/2]=d/i; d=d%i; }
    for(i=0;i<K;i++){ if(Q[i]>=X[i]){ P[i]=Q[i]-X[i]; if(i==2)return 1;}}
    return 0;
}*/
int Vizinho( int Q[K], int d, int P[K]){
    int X[K], i;
    for(i=4;i>=1;i/=2){/*transformacao do d em cordenadas*/
        X[i/2]=d/i;
        d=d%i; }

    for(i=0;i<K;i++){
        P[i]=Q[i]-X[i];}
    if(P[0]>=0 && P[1]>=0 && P[2]>=0) return 1;
    else return 0;
}


int W( int P[K], int Q[K], char S[K][NMAX], int r, int q, int g ){
    int i, j, score=0, way[K];
    char X[K];
    for(i=0; i<K; i++) way[i]=Q[i]-P[i];
    for(i=0; i<K; i++){
        X[i]=S[i][P[i]];
        if(!way[i]) X[i]='-'; }
    for(i=0;i<K-1;i++){
        for(j=i+1;j<K;j++){
            if(X[i]==X[j] && X[i]!='-') score+=r; /*Iguais entre si e diferentes de '-'*/
            else if(X[i]==X[j]=='-') score=score; /*Iguais a '-'*/
            else if(X[i]!=X[j] && X[i]!='-' && X[j]!='-') score+=q; /*Diferentes entre si e de '-'*/
            else if (X[i]!=X[j]) score+=g; /* Como já foi "diferentes entre si e de '-'", se alguma dupla */
        }                                  /* chegar aqui, será diferente entre si por ter '-'.           */
    }
    return score;
}