package org.skaza.pocketamati;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class CraftingActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crafting);
        setTitle(getResources().getText(R.string.craftName));
    }
}
