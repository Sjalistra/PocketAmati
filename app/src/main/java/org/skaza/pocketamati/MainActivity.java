package org.skaza.pocketamati;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends ActionBarActivity {

        /**********************************
        * TODO: 1.0
        * TODO: Calculators
        * TODO: Measurements for smaller instruments
        * TODO: Instructions for crafting instrument components and varnishes
        ***********************************
        * TODO: 2.0
        * TODO: Bios, info about the luthiers style
        * TODO: Herz emission, a portable piano with just one scale
        ***********************************
        * TODO: THE IDEAS
        * TODO: Gallery of expensive instruments
        * TODO: Tools wishlist
        ***********************************
        * TODO: FIXES
        * TODO: All instances of 'scale length' into 'stop length' as I incorrectly translated it
        * TODO: ID of layout activities of Calculator Activities to be done properly
        * TODO: Comments on the code (calculators)
        * TODO: [Calc] Compute on done
        **********************************/

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
