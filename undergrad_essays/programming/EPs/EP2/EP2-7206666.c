/**********************************************************************/
/**                                                                  **/
/**   Bruno Henrique Lôbo Netto Peixoto          Número USP 7206666  **/
/**   Exercício-Programa 1 - EP1                                     **/
/**   Professor: Nina S. T. Hirata                                   **/
/**   Turma: 8                                                       **/
/**                                                                  **/
/**********************************************************************/
#include <stdio.h>
int main(){
    int num, mode, x1, x2, x3, x4, x5, x6, x7, x8, x9, no_jog, troq1, troq2, alert;
    printf("Entre com um quadrado: ");
    scanf("%d", &num);
    x1=x2=x3=x4=x5=x6=x7=x8=x9=0;
    while(num!=0){
        x9=num%10;
        num=num/10;
        x8=num%10;
        num=num/10;
        x7=num%10;
        num=num/10;
        x6=num%10;
        num=num/10;
        x5=num%10;
        num=num/10;
        x4=num%10;
        num=num/10;
        x3=num%10;
        num=num/10;
        x2=num%10;
        num=num/10;
        x1=num%10;
        num=num/10;
        if (x1!=x2 && x1!=x3 && x1!=x4 && x1!=x5 && x1!=x6 && x1!=x7 && x1!=x8 && x1!=x9 && x1!=0 && x7!= x8 && x7!=x9 && x7!=0 && x7!=x8 && x7!=x9 && x8!=0 && x8!=x9 && x9!=0){
            if (x2!=x3 && x2!=x4 && x2!=x5 && x2!=x6 && x2!=x7 && x2!=x8 && x2!=x9 && x2!=0 && x3!=x4 && x3!=x5 && x3!=x6 && x3!=x7 && x3!=x8 && x3!=x9 && x3!=0){
                    if (x4!= x5 && x4!= x6 && x4!= x7 && x4!= x8 && x4!=x9 && x4!=0 && x5!= x6 && x5!=x7 && x5!=x8 && x5!=x9 && x5!=0 && x6!=x7 && x6!=x8 && x6!=x9){
                                        printf("Tipo de jogo (0 = semitorre , 1 = rei): ");
                                        scanf("%d", &mode);
                                        if (mode==0){/*modo semitorre*/
                                            no_jog=1, alert=0;
                                            while (alert==0){/*while semitorre*/
                                                printf("    %2d %2d %2d - %2d\n", x1, x2, x3, x1+x2+x3);
                                                printf("    %2d %2d %2d - %2d\n", x4, x5, x6, x4+x5+x6);
                                                printf("    %2d %2d %2d - %2d\n", x7, x8, x9, x7+x8+x9);
                                                printf("   / -- -- -- \\ \n");
                                                printf(" %2d %2d %2d % 2d % 2d\n\n", x3+x5+x7, x1+x4+x7, x2+x5+x8, x3+x6+x9, x1+x5+x9);
                                                if (x1+x2+x3==x4+x5+x6 && x4+x5+x6==x7+x8+x9 && x7+x8+x9==x1+x4+x7 && x1+x4+x7==x2+x5+x8 && x2+x5+x8==x3+x6+x9 && x3+x6+x9==x3+x5+x7 && x3+x5+x7==x1+x5+x9){
                                                    printf("O quadrado e' magico. :-)\nLevou %d jogada(s)\n\n", no_jog);
                                                    alert++;
                                                }
                                                else{/*else nao igual*/
                                                    printf("[%d] Digitos para trocar ( 0 0 para parar): ", no_jog);
                                                    scanf("%d", &troq1);
                                                    scanf("%d", &troq2);
                                                    printf("\n\n");
                                                    if (troq1==0 && troq2==0){
                                                        printf("Desistiu... :-(\n\n");
                                                        alert++;
                                                    }
                                                    else{/*nao desistiu*/
                                                    if (troq1==x1){/*1*/
                                                        if (troq2==x2){
                                                            x1=troq2;
                                                            x2=troq1;
                                                            no_jog++;
                                                        }
                                                        else{
                                                            if (troq2==x4){
                                                                x1=troq2;
                                                                x4=troq1;
                                                                no_jog++;
                                                            }
                                                            else printf("********************\n* Jogada invalida! *\n********************\n\n");
                                                        }
                                                    }/*1*/
                                                    else {
                                                        if (troq1==x2){/*2*/
                                                            if (troq2==x1){
                                                                x2=troq2;
                                                                x1=troq1;
                                                                no_jog++;
                                                            }
                                                            else{
                                                                if (troq2==x3){
                                                                    x2=troq2;
                                                                    x3=troq1;
                                                                    no_jog++;
                                                                }
                                                                else{
                                                                    if (troq2==x5){
                                                                        x2=troq2;
                                                                        x5=troq1;
                                                                        no_jog++;
                                                                    }
                                                                    else printf("********************\n* Jogada invalida! *\n********************\n\n");                                                                }
                                                            }
                                                        }/*2*/
                                                        else {
                                                            if (troq1==x3){/*3*/
                                                                if (troq2==x2){
                                                                    x3=troq2;
                                                                    x2=troq1;
                                                                    no_jog++;
                                                                }
                                                                else{
                                                                    if (troq2==x6){
                                                                        x3=troq2;
                                                                        x6=troq1;
                                                                        no_jog++;
                                                                    }
                                                                    else printf("********************\n* Jogada invalida! *\n********************\n\n");
                                                                }
                                                            }/*3*/
                                                            else{
                                                                if (troq1==x4){/*4*/
                                                                    if (troq2==x1){
                                                                        x4=troq2;
                                                                        x1=troq1;
                                                                        no_jog++;
                                                                    }
                                                                    else{
                                                                        if (troq2==x5){
                                                                            x4=troq2;
                                                                            x5=troq1;
                                                                            no_jog++;
                                                                        }
                                                                        else{
                                                                            if (troq2==x7){
                                                                                x4=troq2;
                                                                                x7=troq1;
                                                                                no_jog++;
                                                                            }
                                                                            else printf("********************\n* Jogada invalida! *\n********************\n\n");
                                                                        }
                                                                    }
                                                                }/*4*/
                                                                else{
                                                                    if (troq1==x5){/*5*/
                                                                        if (troq2==x2){
                                                                            x5=troq2;
                                                                            x2=troq1;
                                                                            no_jog++;
                                                                        }
                                                                        else{
                                                                            if (troq2==x4){
                                                                                x5=troq2;
                                                                                x4=troq1;
                                                                                no_jog++;
                                                                            }
                                                                            else{
                                                                                if(troq2==x6){
                                                                                    x5=troq2;
                                                                                    x6=troq1;
                                                                                    no_jog++;
                                                                                }
                                                                                else{
                                                                                    if (troq2==x8){
                                                                                        x5=troq2;
                                                                                        x8=troq1;
                                                                                        no_jog++;
                                                                                    }
                                                                                    else printf("********************\n* Jogada invalida! *\n********************\n\n");
                                                                                }
                                                                            }
                                                                        }
                                                                    }/*5*/
                                                                    else{
                                                                        if (troq1==x6){/*6*/
                                                                            if (troq2==x3){
                                                                                x6=troq2;
                                                                                x3=troq1;
                                                                                no_jog++;
                                                                            }
                                                                            else{
                                                                                if (troq2==x5){
                                                                                    x6=troq2;
                                                                                    x5=troq1;
                                                                                    no_jog++;
                                                                                }
                                                                                else{
                                                                                    if (troq2==x9){
                                                                                        x6=troq2;
                                                                                        x9=troq1;
                                                                                        no_jog++;
                                                                                    }
                                                                                    else printf("********************\n* Jogada invalida! *\n********************\n\n");
                                                                                }
                                                                            }
                                                                        }/*6*/
                                                                        else{
                                                                            if (troq1==x7){/*7*/
                                                                                if (troq2==x4){
                                                                                    x7=troq2;
                                                                                    x4=troq1;
                                                                                    no_jog++;
                                                                                }
                                                                                else{
                                                                                    if (troq2==x8){
                                                                                        x7=troq2;
                                                                                        x8=troq1;
                                                                                        no_jog++;
                                                                                    }
                                                                                    else printf("********************\n* Jogada invalida! *\n********************\n\n");
                                                                                }
                                                                            }/*7*/
                                                                            else{
                                                                                if (troq1==x8){/*8*/
                                                                                    if (troq2==x7){
                                                                                        x8=troq2;
                                                                                        x7=troq1;
                                                                                        no_jog++;
                                                                                    }
                                                                                    else{
                                                                                        if (troq2==x5){
                                                                                            x8=troq2;
                                                                                            x5=troq1;
                                                                                            no_jog++;
                                                                                        }
                                                                                        else{
                                                                                            if (troq2==x9){
                                                                                                x8=troq2;
                                                                                                x9=troq1;
                                                                                                no_jog++;
                                                                                            }
                                                                                            else printf("********************\n* Jogada invalida! *\n********************\n\n");
                                                                                        }
                                                                                    }
                                                                                }/*8*/
                                                                                else{
                                                                                    if (troq1==x9){/*9*/
                                                                                        if (troq2==x6){
                                                                                            x9=troq2;
                                                                                            x6=troq1;
                                                                                            no_jog++;
                                                                                        }
                                                                                        else{
                                                                                            if (troq2==x8){
                                                                                                x9=troq2;
                                                                                                x8=troq1;
                                                                                                no_jog++;
                                                                                            }
                                                                                            else printf("********************\n* Jogada invalida! *\n********************\n\n");
                                                                                        }
                                                                                    }/*9*/
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    }/*nao desistiu*/
                                                }/*else nao igual*/
                                            }/*while semitorre*/
                                        }/*modo semitorre*/
                                        else{/*modo rei*/
                                            no_jog=1, alert=0;
                                            while (alert==0){/*while rei*/
                                                printf("    %2d %2d %2d - %2d\n    %2d %2d %2d - %2d\n    %2d %2d %2d - %2d\n   / -- -- -- \\ \n %2d %2d %2d % 2d % 2d\n\n", x1, x2, x3, x1+x2+x3, x4, x5, x6, x4+x5+x6, x7, x8, x9, x7+x8+x9, x3+x5+x7, x1+x4+x7,x2+x5+x8,x3+x6+x9,x3+x5+x7);
                                                if (x1+x2+x3==x4+x5+x6 && x4+x5+x6==x7+x8+x9 && x7+x8+x9==x1+x4+x7 && x1+x4+x7==x2+x5+x8 && x2+x5+x8==x3+x6+x9 && x3+x6+x9==x3+x5+x7 && x3+x5+x7==x1+x5+x9){
                                                    printf("O quadrado e' magico. :-)\nLevou %d jogada(s)\n\n", no_jog);
                                                    alert++;
                                                }
                                                else{/*else nao igual*/
                                                    printf("[%d] Digitos para trocar ( 0 0 para parar): ", no_jog);
                                                    scanf("%d", &troq1);
                                                    scanf("%d", &troq2);
                                                    printf("\n\n");
                                                    if (troq1==0 && troq2==0){
                                                        printf("Desistiu... :-(\n\n");
                                                        alert++;
                                                    }
                                                    else{/*nao desistiu*/
                                                    if (troq1==x1){/*1*/
                                                        if (troq2==x2){
                                                            x1=troq2;
                                                            x2=troq1;
                                                            no_jog++;
                                                        }
                                                        else{
                                                            if (troq2==x4){
                                                                x1=troq2;
                                                                x4=troq1;
                                                                no_jog++;
                                                            }
                                                            else{
                                                                if (troq2==x5){
                                                                    x1=troq2;
                                                                    x5=troq1;
                                                                    no_jog++;
                                                                }
                                                                else printf("********************\n* Jogada invalida! *\n********************\n\n");
                                                            }
                                                        }
                                                    }/*1*/
                                                    else {
                                                        if (troq1==x2){/*2*/
                                                            if (troq2==x1){
                                                                x2=troq2;
                                                                x1=troq1;
                                                                no_jog++;
                                                            }
                                                            else{
                                                                if (troq2==x3){
                                                                    x2=troq2;
                                                                    x3=troq1;
                                                                    no_jog++;
                                                                }
                                                                else{
                                                                    if (troq2==x5){
                                                                        x2=troq2;
                                                                        x5=troq1;
                                                                        no_jog++;
                                                                    }
                                                                    else{
                                                                        if (troq2==x4){
                                                                            x2=troq2;
                                                                            x4=troq1;
                                                                            no_jog++;
                                                                        }
                                                                        else{
                                                                            if (troq2==x6){
                                                                                x2=troq2;
                                                                                x6=troq1;
                                                                                no_jog++;
                                                                            }
                                                                            else printf("********************\n* Jogada invalida! *\n********************\n\n");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }/*2*/
                                                        else {
                                                            if (troq1==x3){/*3*/
                                                                if (troq2==x2){
                                                                    x3=troq2;
                                                                    x2=troq1;
                                                                    no_jog++;
                                                                }
                                                                else{
                                                                    if (troq2==x6){
                                                                        x3=troq2;
                                                                        x6=troq1;
                                                                        no_jog++;
                                                                    }
                                                                    else{
                                                                        if (troq2==x5){
                                                                            x3=troq2;
                                                                            x5=troq1;
                                                                            no_jog++;
                                                                        }
                                                                        else printf("********************\n* Jogada invalida! *\n********************\n\n");
                                                                    }
                                                                }
                                                            }/*3*/
                                                            else{
                                                                if (troq1==x4){/*4*/
                                                                    if (troq2==x1){
                                                                        x4=troq2;
                                                                        x1=troq1;
                                                                        no_jog++;
                                                                    }
                                                                    else{
                                                                        if (troq2==x5){
                                                                            x4=troq2;
                                                                            x5=troq1;
                                                                            no_jog++;
                                                                        }
                                                                        else{
                                                                            if (troq2==x7){
                                                                                x4=troq2;
                                                                                x7=troq1;
                                                                                no_jog++;
                                                                            }
                                                                            else{
                                                                                if (troq2==x2){
                                                                                   x4=troq2;
                                                                                    x7=troq1;
                                                                                    no_jog++;
                                                                                }
                                                                                else{
                                                                                    if (troq2==x8){
                                                                                        x4=troq2;
                                                                                        x7=troq1;
                                                                                        no_jog++;
                                                                                    }
                                                                                   else printf("********************\n* Jogada invalida! *\n********************\n\n");
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }/*4*/
                                                                else{
                                                                    if (troq1==x5){/*5*/
                                                                        if (troq2==x2){
                                                                            x5=troq2;
                                                                            x2=troq1;
                                                                            no_jog++;
                                                                        }
                                                                        else{
                                                                            if (troq2==x4){
                                                                                x5=troq2;
                                                                                x4=troq1;
                                                                                no_jog++;
                                                                            }
                                                                            else{
                                                                                if(troq2==x6){
                                                                                    x5=troq2;
                                                                                    x6=troq1;
                                                                                    no_jog++;
                                                                                }
                                                                                else{
                                                                                    if (troq2==x8){
                                                                                        x5=troq2;
                                                                                        x8=troq1;
                                                                                        no_jog++;
                                                                                    }
                                                                                    else{
                                                                                        if (troq2==x1){
                                                                                            x5=troq2;
                                                                                            x1=troq1;
                                                                                            no_jog++;
                                                                                            }
                                                                                        else{
                                                                                            if (troq2==x3){
                                                                                                x5=troq2;
                                                                                                x3=troq1;
                                                                                                no_jog++;
                                                                                            }
                                                                                            else{
                                                                                                if (troq2==x7){
                                                                                                    x5=troq2;
                                                                                                    x7=troq1;
                                                                                                    no_jog++;
                                                                                                }
                                                                                                else{
                                                                                                    x5=troq2;
                                                                                                    x9=troq1;
                                                                                                    no_jog++;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }/*5*/
                                                                    else{
                                                                        if (troq1==x6){/*6*/
                                                                            if (troq2==x3){
                                                                                x6=troq2;
                                                                                x3=troq1;
                                                                                no_jog++;
                                                                            }
                                                                            else{
                                                                                if (troq2==x5){
                                                                                    x6=troq2;
                                                                                    x5=troq1;
                                                                                    no_jog++;
                                                                                }
                                                                                else{
                                                                                    if (troq2==x9){
                                                                                        x6=troq2;
                                                                                        x9=troq1;
                                                                                        no_jog++;
                                                                                    }
                                                                                    else{
                                                                                         if (troq2==x2){
                                                                                            x4=troq2;
                                                                                            x7=troq1;
                                                                                            no_jog++;
                                                                                        }
                                                                                        else{
                                                                                            if (troq2==x8){
                                                                                                x4=troq2;
                                                                                                x7=troq1;
                                                                                                no_jog++;
                                                                                            }
                                                                                            else printf("********************\n* Jogada invalida! *\n********************\n\n");
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }/*6*/
                                                                        else{
                                                                            if (troq1==x7){/*7*/
                                                                                if (troq2==x4){
                                                                                    x7=troq2;
                                                                                    x4=troq1;
                                                                                    no_jog++;
                                                                                }
                                                                                else{
                                                                                    if (troq2==x8){
                                                                                        x7=troq2;
                                                                                        x8=troq1;
                                                                                        no_jog++;
                                                                                    }
                                                                                    else printf("********************\n* Jogada invalida! *\n********************\n\n");
                                                                                }
                                                                            }/*7*/
                                                                            else{
                                                                                if (troq1==x8){/*8*/
                                                                                    if (troq2==x7){
                                                                                        x8=troq2;
                                                                                        x7=troq1;
                                                                                        no_jog++;
                                                                                    }
                                                                                    else{
                                                                                        if (troq2==x5){
                                                                                            x8=troq2;
                                                                                            x5=troq1;
                                                                                            no_jog++;
                                                                                        }
                                                                                        else{
                                                                                            if (troq2==x9){
                                                                                                x8=troq2;
                                                                                                x9=troq1;
                                                                                                no_jog++;
                                                                                            }
                                                                                            else{
                                                                                                if (troq2==x5){
                                                                                                    x3=troq2;
                                                                                                    x5=troq1;
                                                                                                    no_jog++;
                                                                                                }
                                                                                                else{
                                                                                                    if (troq2==x4){
                                                                                                        x2=troq2;
                                                                                                        x4=troq1;
                                                                                                        no_jog++;
                                                                                                    }
                                                                                                    else{
                                                                                                        if (troq2==x6){
                                                                                                            x2=troq2;
                                                                                                            x6=troq1;
                                                                                                            no_jog++;
                                                                                                        }
                                                                                                        else printf("********************\n* Jogada invalida! *\n********************\n\n");
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }/*8*/
                                                                                else{
                                                                                    if (troq1==x9){/*9*/
                                                                                        if (troq2==x6){
                                                                                            x9=troq2;
                                                                                            x6=troq1;
                                                                                            no_jog++;
                                                                                        }
                                                                                        else{
                                                                                            if (troq2==x8){
                                                                                                x9=troq2;
                                                                                                x8=troq1;
                                                                                                no_jog++;
                                                                                            }
                                                                                            else{
                                                                                                if (troq2==x5){
                                                                                                    x3=troq2;
                                                                                                    x5=troq1;
                                                                                                    no_jog++;
                                                                                                }
                                                                                                else printf("********************\n* Jogada invalida! *\n********************\n\n");
                                                                                            }
                                                                                        }
                                                                                    }/*9*/
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    }/*nao desistiu*/
                                                }/*else nao igual*/
                                            }/*while rei*/
                                        }/*modo rei*/
                    }
                    else printf("Falta pelo menos um digito. Rejeitado.\n\n");
            }
            else printf("Falta pelo menos um digito. Rejeitado.\n\n");
        }
        else printf("Falta pelo menos um digito. Rejeitado.\n\n");
        printf("Entre com outro quadrado: ");
        scanf("%d", &num);
    }
    return 0;
}
