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

public class StopLengthActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_length);
        setTitle(getResources().getText(R.string.stopLengthViolin));
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/WorkSans-Medium.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    double neckStopLengthDouble = 0;
    double boardStopLengthDouble = 0;
    double bodyLength = 0;
    int neckStopLength = 0;
    int boardStopLength = 0;
    int neckStopLengthFinale = 0;
    int boardStopLengthFinale = 0;

    public void Compute(View v) {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        EditText boardLengthText = (EditText) findViewById(R.id.stopLenghtViolinInput);
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
        neckStopLengthDouble = bodyLength * 0.181 * 2;
        boardStopLengthDouble = bodyLength * 0.181 * 3;
        neckStopLength = (int) neckStopLengthDouble;
        boardStopLength = (int) boardStopLengthDouble;

// Looks like I don't know what I'm doing but it works!
// It's getting the value after the dot appear nicely in the app
        boardStopLengthDouble = (Math.floor(((Math.floor(boardStopLengthDouble * 1000) / 1000)
                - boardStopLength) * 1000) / 1000) * 1000;
        neckStopLengthDouble = (Math.floor(((Math.floor(neckStopLengthDouble * 1000) / 1000)
                - neckStopLength) * 1000) / 1000) * 1000;

        boardStopLengthFinale = (int) boardStopLengthDouble;
        neckStopLengthFinale = (int) neckStopLengthDouble;

        TextView neckTextView = (TextView) findViewById(R.id.neckComputed);
        TextView boardTextView = (TextView) findViewById(R.id.boardComputed);
        TextView neckTextViewDouble = (TextView) findViewById(R.id.neckComputed2);
        TextView boardTextViewDouble = (TextView) findViewById(R.id.bodyComputed2);

        String neckStopLengthText = String.valueOf(neckStopLength);
        String boardStopLengthText = String.valueOf(boardStopLength);
        String neckStopLengthTextDouble = String.valueOf(neckStopLengthFinale);
        String boardStopLengthTextDouble = String.valueOf(boardStopLengthFinale);

        neckTextView.setText(neckStopLengthText);
        boardTextView.setText(boardStopLengthText);
        neckTextViewDouble.setText(neckStopLengthTextDouble);
        boardTextViewDouble.setText(boardStopLengthTextDouble);

        neckTextView.invalidate();
        boardTextView.invalidate();
        neckTextViewDouble.invalidate();
        boardTextViewDouble.invalidate();

    }
}