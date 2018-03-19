package com.asquare_solutions.www.drawerlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {
      Button btn_goback;

    public void ReturnHome(View view){
        super.onBackPressed();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        final TextView textView_about = (TextView) findViewById(R.id.textView_about);
        textView_about.setText(R.string.text_about);
    }
}
