package org.skaza.pocketamati.CalculatorActivities;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.skaza.pocketamati.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class WoodDensityActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wood_density);
        setTitle(getResources().getText(R.string.woodDensity));
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/WorkSans-Medium.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    double massDouble = 0;
    double volumeDouble = 0;
    double densityDouble = 0;
    int density = 0;
    int densityFinale = 0;

    public void Compute(View v) {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        EditText bodyLengthText = (EditText) findViewById(R.id.sizeViolinInput);
        if (massDouble == 0) {
            if (bodyLengthText
                    .getText()
                    .toString()
                    .matches("\\d+(\\.\\d*)?|\\.\\d+")) {
                massDouble = Double.parseDouble(bodyLengthText
                        .getText()
                        .toString());
            } else {
                Context context = getApplicationContext();
                CharSequence text = getResources().getString(R.string.calcError);
                int length = Toast.LENGTH_SHORT;
                Toast error = Toast.makeText(context, text, length);
                error.show();
            }
        } else {
            if (bodyLengthText
                    .getText()
                    .toString()
                    .matches("\\d+(\\.\\d*)?|\\.\\d+")) {
                volumeDouble = Double.parseDouble(bodyLengthText
                        .getText()
                        .toString());
            } else {
                Context context = getApplicationContext();
                CharSequence text = getResources().getString(R.string.calcError);
                int length = Toast.LENGTH_SHORT;
                Toast error = Toast.makeText(context, text, length);
                error.show();
            }
        }
        if (massDouble != 0 && volumeDouble != 0) {
            densityDouble = massDouble / volumeDouble;
            density = (int) densityDouble;

// Looks like I don't know what I'm doing but it works!
// It's getting the value after the dot appear nicely in the app
            densityDouble = (Math.floor(((Math.floor(densityDouble * 1000) / 1000)
                    - density) * 1000) / 1000) * 1000;

            densityFinale = (int) densityDouble;

            TextView densityTextView = (TextView) findViewById(R.id.fingerboardComputed);
            TextView density2TextView = (TextView) findViewById(R.id.fingerboardComputed2);
            String densityText = String.valueOf(density);
            String densityFinaleText = String.valueOf(densityFinale);

            densityTextView.setText(densityText);
            density2TextView.setText(densityFinaleText);

            densityTextView.invalidate();
            density2TextView.invalidate();          }

        TextView sizeTextView = (TextView) findViewById(R.id.inputTextView);
        sizeTextView.setText(R.string.gmdVolume);
    }
}