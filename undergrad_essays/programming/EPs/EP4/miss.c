#include <stdio.h>
#define K 3
int main(){
    int X[K],d, i,quit;
    for(quit=1;quit<8;quit++){
    d=quit;
    for(i=4;i>=1;i/=2){
            X[i/2]=d/i;
            d=d%i;}
    printf("d:%d (%d,%d,%d)\n",quit,X[0],X[1],X[2]);}

    return 0;
}
