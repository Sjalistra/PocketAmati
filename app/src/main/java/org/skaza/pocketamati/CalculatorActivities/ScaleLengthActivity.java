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

public class ScaleLengthActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_length);
        setTitle(getResources().getText(R.string.scaleLengthViolin));
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/WorkSans-Medium.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    double neckScaleLengthDouble = 0;
    double boardScaleLengthDouble = 0;
    double bodyLength = 0;
    int neckScaleLength = 0;
    int boardScaleLength = 0;
    int neckScaleLengthFinale = 0;
    int boardScaleLengthFinale = 0;

    public void Compute(View v) {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        EditText boardLengthText = (EditText) findViewById(R.id.scaleLenghtViolinInput);
        if (boardLengthText
                .getText()
                .toString()
                .matches("\\d+(\\.\\d*)?|\\.\\d+")) {
            bodyLength = Double.parseDouble(boardLengthText
                    .getText()
                    .toString());
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Incorrect value";
            int length = Toast.LENGTH_SHORT;
            Toast error = Toast.makeText(context, text, length);
            error.show();
        }
// 0.181 is const.
// x2 is a standard multiplier for a neck and x3 for a board
        neckScaleLengthDouble = bodyLength * 0.181 * 2;
        boardScaleLengthDouble = bodyLength * 0.181 * 3;
        neckScaleLength = (int) neckScaleLengthDouble;
        boardScaleLength = (int) boardScaleLengthDouble;

// Looks like I don't know what I'm doing but it works!
// It's getting the value after the dot appear nicely in the app
        boardScaleLengthDouble = (Math.floor(((Math.floor(boardScaleLengthDouble * 1000) / 1000)
                - boardScaleLength) * 1000) / 1000) * 1000;
        neckScaleLengthDouble = (Math.floor(((Math.floor(neckScaleLengthDouble * 1000) / 1000)
                - neckScaleLength) * 1000) / 1000) * 1000;

        boardScaleLengthFinale = (int) boardScaleLengthDouble;
        neckScaleLengthFinale = (int) neckScaleLengthDouble;

        TextView neckTextView = (TextView) findViewById(R.id.neckComputed);
        TextView boardTextView = (TextView) findViewById(R.id.boardComputed);
        TextView neckTextViewDouble = (TextView) findViewById(R.id.neckComputed2);
        TextView boardTextViewDouble = (TextView) findViewById(R.id.bodyComputed2);

        String neckScaleLengthText = String.valueOf(neckScaleLength);
        String boardScaleLengthText = String.valueOf(boardScaleLength);
        String neckScaleLengthTextDouble = String.valueOf(neckScaleLengthFinale);
        String boardScaleLengthTextDouble = String.valueOf(boardScaleLengthFinale);

        neckTextView.setText(neckScaleLengthText);
        boardTextView.setText(boardScaleLengthText);
        neckTextViewDouble.setText(neckScaleLengthTextDouble);
        boardTextViewDouble.setText(boardScaleLengthTextDouble);

        neckTextView.invalidate();
        boardTextView.invalidate();
        neckTextViewDouble.invalidate();
        boardTextViewDouble.invalidate();

    }
}