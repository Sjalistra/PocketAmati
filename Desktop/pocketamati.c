#include <stdio.h>

double WoodDensity (double mass, double volume){
if (volume != 0){
printf("Gestosc wynosi: %d",mass / volume);}
}

double StopLength ()

int main (){

double version = 1;
int i = 0;
int choice = 0;

printf("Pocket Amati wersja %f\n\nKalkulatory:\n",version);
printf("[%d] Gestosc drewna\n",i); ++i;
printf("[%d] Menzurka (Skrzypce)\n",i); ++i;
printf("[%d] Dlugosc podstrunnicy (Skrzypce)\n",i); ++i;
printf("[%d] Dlugosc podstrunnicy (Altowka)\n",i); ++i;
printf("[%d] Rozmiar skrzypiec\n\n",i); ++i;
START:
printf("Wybierz opcje: ");
scanf("%d",&choice);

switch (choice){

case 0:{ printf("0"); break;}
case 1:{ printf("1"); break;}
case 2:{ printf("2"); break;}
case 3:{ printf("3"); break;}
case 4:{ printf("4"); break;}
default:{ printf("default\n"); goto START;}
}

return 0;
}
