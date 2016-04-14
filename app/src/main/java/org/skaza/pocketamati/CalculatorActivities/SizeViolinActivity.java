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

public class SizeViolinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size_violin);
        setTitle(getResources().getText(R.string.sizeViolin));
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/WorkSans-Medium.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    String violinSize = "NaN";
    double bodyLength = 0;
    int indicator = 0;

    public void Compute(View v) {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        EditText bodyLengthText = (EditText) findViewById(R.id.sizeViolinInput);

        if (bodyLengthText
                .getText()
                .toString()
                .matches("\\d+(\\.\\d*)?|\\.\\d+")) {
            bodyLength = Double.parseDouble(bodyLengthText
                    .getText()
                    .toString());
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Incorrect value";
            int length = Toast.LENGTH_SHORT;
            Toast error = Toast.makeText(context, text, length);
            error.show();
        }

        if (bodyLength >= 280 && bodyLength < 300) {indicator = 1;}
        if (bodyLength >= 300 && bodyLength < 320) {indicator = 2;}
        if (bodyLength >= 320 && bodyLength < 340) {indicator = 3;}
        if (bodyLength >= 340 && bodyLength < 350) {indicator = 4;}
        if (bodyLength >= 350 && bodyLength <= 360){indicator = 5;}

        switch (indicator){
            case 1: violinSize = "1/4"; break;
            case 2: violinSize = "1/2"; break;
            case 3: violinSize = "3/4"; break;
            case 4: violinSize = "7/8"; break;
            case 5: violinSize = "4/4"; break;
            default: break;}

    TextView sizeTextView = (TextView) findViewById(R.id.sizeView);
    sizeTextView.setText(violinSize);
    sizeTextView.invalidate();}
    }