package org.skaza.pocketamati;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class CalculatorActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        setTitle(getResources().getText(R.string.calcName));
    }

    public void switchToScaleLengthViolin(View v) {
        startActivity(new Intent(getApplicationContext(),
                org.skaza.pocketamati.CalculatorActivities.ScaleLengthActivity.class));

    }
    public void switchToFingerboardLengthViolin(View v) {
        startActivity(new Intent(getApplicationContext(),
                org.skaza.pocketamati.CalculatorActivities.FingerBoardViolinActivity.class));

    }
    public void switchToFingerboardLengthViola(View v) {
        startActivity(new Intent(getApplicationContext(),
                org.skaza.pocketamati.CalculatorActivities.FingerBoardViolaActivity.class));

    }
}
