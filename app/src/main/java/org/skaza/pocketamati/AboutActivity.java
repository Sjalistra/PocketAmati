package org.skaza.pocketamati;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class AboutActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle(getResources().getText(R.string.aboutName));
    }

    public void sjal(View v) {
        Uri uri = Uri.parse("http://www.skaza.org");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void betno(View v) {
        Uri uri = Uri.parse("https://www.behance.net/betno");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void irv(View v) {
        Uri uri = Uri.parse("https://www.facebook.com/irv.alters/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
