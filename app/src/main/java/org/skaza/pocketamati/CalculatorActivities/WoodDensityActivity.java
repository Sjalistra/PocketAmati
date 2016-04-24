package org.skaza.pocketamati.CalculatorActivities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.skaza.pocketamati.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class WoodDensityActivity extends AppCompatActivity {

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

    boolean hasChanged = false;
    int density = 0;
    int densityFinale = 0;
    double massDouble = 0;
    double volumeDouble = 0;
    double densityDouble = 0;

    public void Compute(View v) {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        Context context = getApplicationContext();
        CharSequence text = getResources().getString(R.string.calcError);
        int length = Toast.LENGTH_SHORT;
        Toast error = Toast.makeText(context, text, length);

        EditText violinSizeText = (EditText) findViewById(R.id.sizeViolinInput);

        if (!hasChanged) {
            if (violinSizeText
                    .getText()
                    .toString()
                    .matches("\\d+(\\.\\d*)?|\\.\\d+")) {
                massDouble = Double.parseDouble(violinSizeText
                        .getText()
                        .toString());
            } else {
                error.show();
            }
        } else {
            if (violinSizeText
                    .getText()
                    .toString()
                    .matches("\\d+(\\.\\d*)?|\\.\\d+")) {
                volumeDouble = Double.parseDouble(violinSizeText
                        .getText()
                        .toString());
            } else {
                error.show();
            }
        }
        if (massDouble > 0 && volumeDouble > 0) {
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

        if (violinSizeText
                .getText()
                .toString()
                .matches("\\d+(\\.\\d*)?|\\.\\d+")) {
                if (!hasChanged){
                        hasChanged = true;
                        sizeTextView.setText(R.string.gmdVolume);
                } else {
                        hasChanged = false;
                        sizeTextView.setText(R.string.gmdMass); }
            violinSizeText.setText("");
        }
    }
}