package org.skaza.pocketamati;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class CalculatorActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        setTitle(getResources().getText(R.string.calcName));
    }
}
