#include <stdio.h>

void SizeViolin (double boardLength){
int indicator = 0;
    if (boardLength >= 280 && boardLength < 300) {indicator = 1;}
    if (boardLength >= 300 && boardLength < 320) {indicator = 2;}
    if (boardLength >= 320 && boardLength < 340) {indicator = 3;}
    if (boardLength >= 340 && boardLength < 350) {indicator = 4;}
    if (boardLength >= 350 && boardLength <= 360){indicator = 5;}

switch (indicator){
case 1: printf("1/4\n"); break;
case 2: printf("1/2\n"); break;
case 3: printf("3/4\n"); break;
case 4: printf("7/8\n"); break;
case 5: printf("4/4\n"); break;
default:printf("Niewymiarowe skrzypce"); break;}}
void WoodDensity (double mass, double volume){
if (volume > 0 && mass > 0){
    printf("Gestosc wynosi: %lf g/cm^3\n",mass / volume);} else {
    printf("Zle wartosci! \n");}
}
void StopLength (double boardLength){
printf("Menzurka szyjki wynosi: %lf\n Menzurka plyty wynosi: %lf\n",boardLength * 0.181 * 2,boardLength * 0.181 * 3);}
void FingerboardViolin (double boardLength){
printf("Dlugosc podstrunnicy skrzypiec wynosi: %lf\n",(boardLength * 3) / 4);}
void FingerboardViola (double boardLength){
printf("Dlugosc podstrunnicy altowki wynosi: %lf\n",(((boardLength * 0.181 * 3) + (boardLength * 0.181 * 2)) * 5) / 6);}

int main (){

int i = 0;
int choice = 0;
double version = 1;
double mass = 0;
double volume = 0;
double boardLength = 0;

printf("Pocket Amati wersja %lf\n\nKalkulatory:\n",version);
printf("[%d] Gestosc drewna\n",i); ++i;
printf("[%d] Menzurka (Skrzypce)\n",i); ++i;
printf("[%d] Dlugosc podstrunnicy (Skrzypce)\n",i); ++i;
printf("[%d] Dlugosc podstrunnicy (Altowka)\n",i); ++i;
printf("[%d] Rozmiar skrzypiec\n\n",i); ++i;
START:
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
default:{ printf("Podaj poprawna wartosc\n"); goto START;}
}

return 0;
}
