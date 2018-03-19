package com.asquare_solutions.www.drawerlayout;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ContactUsActivity extends AppCompatActivity {
    EditText editText_name;
    EditText editText_email;
    EditText editText_subject;
    EditText editText_message;
    Button btn_submit;
    Button btn_goback;

    private static final String REGISTER_URL = "https://www.workmanservicespk.com/contactUsAndroid/contactUs.php";

    public void ReturnHome(View view){
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        editText_name = (EditText) findViewById(R.id.editText_name);
        editText_email = (EditText) findViewById(R.id.editText_email);
        editText_subject = (EditText) findViewById(R.id.editText_subject);
        editText_message = (EditText) findViewById(R.id.editText_message);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

    }

    private void registerUser() {
        String name = editText_name.getText().toString();
        String email = editText_email.getText().toString();
        String subject = editText_subject.getText().toString();
        String message = editText_message.getText().toString();
        register(name, email, subject, message);
    }

    private void register(String name, String email, String subject, String message) {
        String urlSuffix = "?name=" + name + "&email=" + email + "&subject=" + subject + "&message=" + message;
        class RegisterUser extends AsyncTask<String, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ContactUsActivity.this, "Please wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(getApplicationContext(), "Internet not found. Please check the connection", Toast.LENGTH_SHORT).show();
            }


            @Override
            protected String doInBackground(String... params) {
                String s = params[0];
                BufferedReader bufferReader = null;
                try {
                    URL url = new URL(REGISTER_URL+s);
                    HttpURLConnection con=(HttpURLConnection)url.openConnection();
                    bufferReader=new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String result;
                    result=bufferReader.readLine();
                    return result;

                }catch (Exception e) {
                    return null;
                }
            }


        }
        RegisterUser ur=new RegisterUser();
        ur.execute(urlSuffix);
    }
}