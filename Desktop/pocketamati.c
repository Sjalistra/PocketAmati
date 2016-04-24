#include <stdio.h>
#include <stdbool.h>

void SizeViolin (double boardLength){
int indicator = 0;
    if (boardLength >= 280 && boardLength < 300) {indicator = 1;}
    if (boardLength >= 300 && boardLength < 320) {indicator = 2;}
    if (boardLength >= 320 && boardLength < 340) {indicator = 3;}
    if (boardLength >= 340 && boardLength < 350) {indicator = 4;}
    if (boardLength >= 350 && boardLength <= 360){indicator = 5;}

switch (indicator){
case 1: printf("1/4\n\n"); break;
case 2: printf("1/2\n\n"); break;
case 3: printf("3/4\n\n"); break;
case 4: printf("7/8\n\n"); break;
case 5: printf("4/4\n\n"); break;
default:printf("Niewymiarowe skrzypce\n\n"); break;}}
void WoodDensity (double mass, double volume){
if (volume > 0 && mass > 0){
    printf("Objetosc wynosi: %lf g/cm^3\n\n",mass / volume);} else {
    printf("Zle wartosci! \n\n");}
}
void StopLength (double boardLength){
printf("Menzurka szyjki wynosi: %lf\n Menzurka plyty wynosi: %lf\n\n",boardLength * 0.181 * 2,boardLength * 0.181 * 3);}
void FingerboardViolin (double boardLength){
printf("Dlugosc podstrunnicy skrzypiec wynosi: %lf\n\n",(boardLength * 3) / 4);}
void FingerboardViola (double boardLength){
printf("Dlugosc podstrunnicy altowki wynosi: %lf\n\n",(((boardLength * 0.181 * 3) + (boardLength * 0.181 * 2)) * 5) / 6);}

int main (){

bool run = true;
int choice = 0;
double version = 1;
double mass = 0;
double volume = 0;
double boardLength = 0;

printf("Pocket Amati\nwersja %lf\n\nKalkulatory:\n",version);
while (run){
printf("[0] Gestosc drewna\n");
printf("[1] Menzurka (Skrzypce)\n");
printf("[2] Dlugosc podstrunnicy (Skrzypce)\n");
printf("[3] Dlugosc podstrunnicy (Altowka)\n");
printf("[4] Rozmiar skrzypiec\n");
printf("[5] Wyjdz z programu\n\n");

printf("Wybierz opcje: ");
scanf("%d",&choice);
printf("\n");

switch (choice){

case 0:{ printf("Gestosc drewna\nPodaj mase drewna w gramach: ");
         scanf("%lf",&mass);
         printf("Podaj gestosc drewna w cm^3: ");
         scanf("%lf",&volume); printf("\n");
         WoodDensity(mass,volume);
         break;}
case 1:{ printf("Menzurka (Skrzypce)\nPodaj dlugosc plyty:");
         scanf("%lf",&boardLength);
         StopLength(boardLength);
         break;}
case 2:{ printf("Dlugosc podstrunnicy (Skrzypce)\nPodaj dlugosc plyty:");
         scanf("%lf",&boardLength);
         FingerboardViolin(boardLength);
         break;}
case 3:{ printf("Dlugosc podstrunnicy (Altowka)\nPodaj dlugosc plyty:");
         scanf("%lf",&boardLength);
         FingerboardViola(boardLength);
         break;}
case 4:{ printf("Rozmiar skrzypiec\nPodaj dlugosc plyty:");
         scanf("%lf",&boardLength);
         SizeViolin(boardLength);
         break;}
case 5:{ run = false;
         break;}
default:{ printf("Podaj poprawna wartosc\n");}
}
    }

return 0;
}
