#include <stdio.h>
#include <stdlib.h>

int main(){


    int vector[]={3,1,5,7,9,8,2,4};
    int tamVector = sizeof(vector)/sizeof(int);
    int i=0;
    int hayEspacio=1;

    //Programa que imprime los grupos consecutivos de un vector de N elementos, en grupos de 1 hasta N elementos

    for(int tamGrupo = 1;tamGrupo<=tamVector;tamGrupo++){
        i=0;
        hayEspacio=1;
        while(hayEspacio){
            if(i > tamVector-tamGrupo){
                hayEspacio=0;
            }
            else{
                for(int j=0;j<tamGrupo;j++){
                    printf("%d",vector[j+i]);
                }
                printf("|");
            }
            i++;
        }
        printf("\n");
    }






    /*for(int tamGrupo = 1;tamGrupo<=tamVector;tamGrupo++){
        for(int i=0;i<tamVector;i+=1){
            if(i > tamVector-tamGrupo){
                break;
            }
            else{
                for(int j=0;j<tamGrupo;j++){
                    printf("%d",vector[j+i]);
                }
            }
            printf("|");
        }
        printf("\n");
    }*/
}
