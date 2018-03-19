package com.asquare_solutions.www.drawerlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ServicesActivity extends AppCompatActivity {
    Button btn_goback;


    public void ReturnHome(View view){
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
    }
}
