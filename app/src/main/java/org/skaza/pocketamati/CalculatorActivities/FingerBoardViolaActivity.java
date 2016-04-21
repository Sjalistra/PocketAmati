package org.skaza.pocketamati.CalculatorActivities;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.skaza.pocketamati.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FingerBoardViolaActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_board_viola);
        setTitle(getResources().getText(R.string.fingerboardLengthViola));
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/WorkSans-Medium.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    double fingerboardLengthDouble = 0;
    double boardLength = 0;
    int fingerboardLength = 0;
    int fingerboardLengthFinale = 0;

    public void Compute(View v) {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        EditText boardLengthText = (EditText) findViewById(R.id.fingerboardLengthViolaInput);

        if (boardLengthText
                .getText()
                .toString()
                .matches("\\d+(\\.\\d*)?|\\.\\d+")) {
            boardLength = Double.parseDouble(boardLengthText
                    .getText()
                    .toString());
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Incorrect value";
            int length = Toast.LENGTH_SHORT;
            Toast error = Toast.makeText(context, text, length);
            error.show();
        }

        fingerboardLengthDouble = (((boardLength * 0.181 * 3) + (boardLength * 0.181 * 2)) * 5) / 6;
        fingerboardLength = (int) fingerboardLengthDouble;

        fingerboardLengthDouble = (Math.floor(((Math.floor(fingerboardLengthDouble * 1000) / 1000)
                - fingerboardLength) * 1000) / 1000) * 1000;
        fingerboardLengthFinale = (int) fingerboardLengthDouble;

        TextView fingerboardTextView = (TextView) findViewById(R.id.fingerboardComputed);
        TextView fingerboard2TextView = (TextView) findViewById(R.id.fingerboardComputed2);
        String fingerboardLengthText = String.valueOf(fingerboardLength);
        String fingerboardLengthFinaleText = String.valueOf(fingerboardLengthFinale);

        fingerboardTextView.setText(fingerboardLengthText);
        fingerboard2TextView.setText(fingerboardLengthFinaleText);

        fingerboardTextView.invalidate();
        fingerboard2TextView.invalidate();
        boardLengthText.setText("");
    }
}