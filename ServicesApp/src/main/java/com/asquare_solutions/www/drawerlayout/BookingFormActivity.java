package com.asquare_solutions.www.drawerlayout;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BookingFormActivity extends AppCompatActivity {
    EditText editText_name;
    EditText editText_address;
    EditText editText_email;
    EditText editText_contactnumber;
    Spinner spinner;
    EditText editText_date;
    EditText editText_time;
    Button btn_submit;
    Button btn_goback;

    //Place shippingAddress;


    private static final String REGISTER_URL = "https://www.workmanservicespk.com/bookings/bookings.php";

    public void ReturnHome(View view){
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_form);
        editText_name = (EditText) findViewById(R.id.editText_name);
        editText_address = (EditText) findViewById(R.id.editText_address);

        //PlaceAutocompleteFragment editText_address = (PlaceAutocompleteFragment)getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        //Hide search icon before fragment
        //editText_address.getView().findViewById(R.id.place_autocomplete_search_button).setVisibility(View.GONE);
        //Set Hint for Autocomplete Edit Text
        //((EditText)editText_address.getView().findViewById(R.id.place_autocomplete_search_input))
        //        .setHint("Please enter your address");
        //Set Text Size
        //((EditText)editText_address.getView().findViewById(R.id.place_autocomplete_search_input))
        //        .setTextSize(14);
        //Get address from Autocomplete
        //editText_address.setOnPlaceSelectedListener(new PlaceSelectionListener() {
          //  @Override
           // public void onPlaceSelected(Place place) {
            //    shippingAddress = place;
            //}

            //@Override
            //public void onError(Status status) {
              //  Log.e("ERROR",status.getStatusMessage());
            //}
        //});


        editText_email = (EditText) findViewById(R.id.editText_email);
        editText_contactnumber = (EditText) findViewById(R.id.editText_contactnumber);
        editText_date = (EditText) findViewById(R.id.editText_date);
        editText_time = (EditText) findViewById(R.id.editText_time);
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
        String address = editText_address.getText().toString();
        //String address = shippingAddress.getAddress().toString();
        //String.format("%s,%s",shippingAddress.getLatLng().latitude,shippingAddress.getLatLng().longitude);

        String email = editText_email.getText().toString();
        String contactnumber = editText_contactnumber.getText().toString();
        String date = editText_date.getText().toString();
        String time = editText_time.getText().toString();
        register(name, address, email, contactnumber, date, time);
    }

    private void register(String name, String address, String email, String contactnumber, String date, String time) {
        String urlSuffix = "?name=" + name + "&address=" + address + "&email=" + email + "&contactnumber=" + contactnumber + "&date=" + date + "&time=" + time;
        class RegisterUser extends AsyncTask<String, Void, String> {
            ProgressDialog loading;



            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(BookingFormActivity.this, "Please wait", null, true, true);
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