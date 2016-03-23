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
import org.w3c.dom.Text;

public class ScaleLengthActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_length);
        setTitle(getResources().getText(R.string.scaleLengthViolin));
    }

    double neckScaleLength = 0;
    double boardScaleLength = 0;
    double boardLength = 0;

    public void Compute(View v) {
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
// 0.181 is const.
// x2 is a standard multiplier for a neck and x3 for a board
        neckScaleLength = boardLength * 0.181 * 2;
        boardScaleLength = boardLength * 0.181 * 3;
// Stop length for 3 digits after the dot
        boardScaleLength = Math.floor(boardScaleLength * 1000) / 1000;
        neckScaleLength = Math.floor(neckScaleLength * 1000) / 1000;

        TextView neckTextView = (TextView) findViewById(R.id.neckComputed);
        TextView boardTextView = (TextView) findViewById(R.id.boardComputed);

        String neckScaleLengthText = String.valueOf(neckScaleLength);
        String boardScaleLengthText = String.valueOf(boardScaleLength);

        neckTextView.setText(neckScaleLengthText);
        boardTextView.setText(boardScaleLengthText);

        neckTextView.invalidate();
        boardTextView.invalidate();
    }

}
