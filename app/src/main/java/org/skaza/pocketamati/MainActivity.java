package org.skaza.pocketamati;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    /*
        ***********ESSENTIALS**************
        TODO: ***** Kalkulator wymiarów
        TODO: ***** Gotowe wymiary małych instrumentów
        TODO: ***** Instrukcje z ilustracjami wykonania elementów i Receptury lakierów
        *************USEFUL****************
        TODO: **** Cechy stylistyczne najwazniejszych twórców, bio
        TODO: **** Emisja herzów do strojenia skrzypków i Mini-pianinko jedna oktawa
        ***********************************
        TODO: *** Galeria drogich modeli skrzypiec
        ***********************************
        TODO: ** Galeria dokumentacji
        ***********************************
        TODO: * Wishlista narzedzi
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void switchToCalc(View v) {
        startActivity(new Intent(getApplicationContext(), org.skaza.pocketamati.CalculatorActivity.class));
    }
    public void switchToMeasure(View v) {

    }
    public void switchToCraft(View v) {
        startActivity(new Intent(getApplicationContext(), org.skaza.pocketamati.CraftingActivity.class));
    }
    public void switchToGallery(View v) {

    }
    public void switchToNotes(View v) {

    }
    public void switchToBios(View v) {
        startActivity(new Intent(getApplicationContext(), org.skaza.pocketamati.BiosActivity.class));
    }
    public void switchToToys(View v) {
        startActivity(new Intent(getApplicationContext(), org.skaza.pocketamati.ToysActivity.class));
    }
    public void switchToAddressBook(View v) {

    }
    public void switchToWish(View v) {

    }
    public void switchToExpensive(View v) {
        startActivity(new Intent(getApplicationContext(), org.skaza.pocketamati.ExpensiveActivity.class));
    }
    public void switchToAbout(View v) {
        startActivity(new Intent(getApplicationContext(), org.skaza.pocketamati.AboutActivity.class));
    }

}
