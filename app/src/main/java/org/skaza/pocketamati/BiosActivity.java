package org.skaza.pocketamati;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class BiosActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bios);
        setTitle(getResources().getText(R.string.biosName));
    }

    public void amatiGo(View v) {

    }
    public void stradivariGo(View v) {

    }
}
