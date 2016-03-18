package org.skaza.pocketamati.CalculatorActivities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        Button buttonCompute = (Button) findViewById(R.id.computeScaleLengthViolin);
        buttonCompute.setEnabled(true);

        EditText boardLengthText = (EditText) findViewById(R.id.scaleLenghtViolinInput);
        boardLength = Double.parseDouble(boardLengthText.getText().toString());

        neckScaleLength = boardLength * 0.181 * 2;
        boardScaleLength = boardLength * 0.181 * 3;

        TextView neck = (TextView) findViewById(R.id.neckComputed);
        TextView board = (TextView) findViewById(R.id.boardComputed);

        String neckScaleLengthText = String.valueOf(neckScaleLength);
        String boardScaleLengthText = String.valueOf(boardScaleLength);

        neck.setText(neckScaleLengthText);
        board.setText(boardScaleLengthText);

        neck.invalidate();
        board.invalidate();
    }

}
