package com.asquare_solutions.www.drawerlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PricesActivity extends AppCompatActivity {
    Button btn_goback;

    public void ReturnHome(View view){
        super.onBackPressed();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prices);
        final TextView textView_prices = (TextView) findViewById(R.id.textView_prices);
        textView_prices.setText(R.string.text_prices);
    }
}
