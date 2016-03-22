package org.skaza.pocketamati;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class CalculatorActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        setTitle(getResources().getText(R.string.calcName));
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/WorkSans-Medium.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
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
