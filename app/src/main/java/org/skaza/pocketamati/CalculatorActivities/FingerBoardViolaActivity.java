package org.skaza.pocketamati.CalculatorActivities;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.skaza.pocketamati.R;

public class FingerBoardViolaActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_board_viola);
        setTitle(getResources().getText(R.string.fingerboardLengthViola));

    }

    double fingerboardLength = 0;
    double boardLength = 0;

    public void Compute(View v) {
        Button buttonCompute = (Button) findViewById(R.id.computeScaleLengthViolin);
        buttonCompute.setEnabled(true);
        InputMethodManager inputManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        EditText boardLengthText = (EditText) findViewById(R.id.scaleLenghtViolinInput);
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
// 5/6 of the stop length = fingerboard length
        fingerboardLength = (boardLength * 0.181 * 3 * 5) / 6;
// Fingerboard length for 3 digits after the dot
        fingerboardLength = Math.floor(fingerboardLength * 1000) / 1000;

        TextView fingerboardTextView = (TextView) findViewById(R.id.neckComputed);
        String fingerboardLengthText = String.valueOf(fingerboardLength);

        fingerboardTextView.setText(fingerboardLengthText);
        fingerboardTextView.invalidate();
    }
}
