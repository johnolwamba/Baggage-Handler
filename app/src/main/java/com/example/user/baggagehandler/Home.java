package com.example.user.baggagehandler;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.user.baggagehandler.adapters.AlertDialogManager;
import com.example.user.baggagehandler.adapters.ServiceHandler;
import com.example.user.baggagehandler.adapters.Variables;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    //create sessions to store/retrieve selections
    SharedPreferences sharedpreferences;

    SharedPreferences.Editor editor;
    public static final String USERPREFERENCES = "UserDetails";

    ProgressDialog loading = null;
    private static Variables address = new Variables();
    // API urls
    private static String URL_LOGOUT = address.getAddress() + "/logout";

    ProgressDialog pDialog;
    AlertDialogManager alert = new AlertDialogManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedpreferences = getSharedPreferences(USERPREFERENCES,
                Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();

        ImageButton btnScan = (ImageButton) findViewById(R.id.btnScan);
        ImageButton btnNotifications = (ImageButton) findViewById(R.id.btnNotifications);
        ImageButton btnAllFlights = (ImageButton) findViewById(R.id.btnAllFlights);
        ImageButton btnAllPassengers = (ImageButton) findViewById(R.id.btnAllPassengers);
        ImageButton btnAllBaggage = (ImageButton) findViewById(R.id.btnAllBaggage);
        ImageButton btnLogout= (ImageButton) findViewById(R.id.btnLogout);

       btnScan.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent scanner = new Intent(Home.this,ScanCode.class);
               startActivity(scanner);
           }
       });

        btnNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent notifications = new Intent(Home.this,Notifications.class);
                startActivity(notifications);
            }
        });

        btnAllFlights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent flights = new Intent(Home.this,Flights.class);
                startActivity(flights);
            }
        });

        btnAllPassengers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent passengers = new Intent(Home.this,Passengers.class);
                startActivity(passengers);
            }
        });

        btnAllBaggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent baggage = new Intent(Home.this,Baggage.class);
                startActivity(baggage);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(Home.this, StaffLogin.class);
                startActivity(logout);
            }
        });
    }


    /**
     * Async task class to get json by making HTTP call
     * */
    private class logout extends AsyncTask<Void, Void, Void> {
        String token =sharedpreferences.getString("token",null);
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Home.this);
            pDialog.setMessage("Signing out...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            // params.add(new BasicNameValuePair("token", token));

            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();
            // Making a request to url and getting response
            String json = sh.makeServiceCall(URL_LOGOUT + "?token="+sharedpreferences.getString("token",null), ServiceHandler.GET,null);

            //shows the response that we got from the http request on the logcat
            Log.d("Response: ", "> " + json + sharedpreferences.getString("token",null));
            //result = jsonStr;
            if (json != null) {
                try {
                    JSONObject jsonObj = new JSONObject(json);
                    if (jsonObj != null) {

                        if(jsonObj.get("status").toString() == null){
                            final String message = jsonObj.getString("message");
                            // Existing data
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    AlertDialog.Builder builder = new AlertDialog.Builder(
                                            Home.this);
                                    builder.setMessage(message)
                                            .setCancelable(false)
                                            .setPositiveButton("Login",
                                                    new DialogInterface.OnClickListener() {
                                                        public void onClick(
                                                                DialogInterface dialog, int id) {
                                                            Intent i = new Intent(Home.this,Home.class);
                                                            startActivity(i);

                                                        }

                                                    });
                                    AlertDialog alert = builder.create();
                                    alert.show();
                                    pDialog.dismiss();
                                }
                            });

                        }

                        String status = jsonObj.get("status").toString();
                        if (status.equals("success")) {
                            // Existing data

                            editor.clear();
                            editor.commit();

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Intent i = new Intent(Home.this,StaffLogin.class);
                                    startActivity(i);
                                    finish();
                                    pDialog.dismiss();
                                }
                            });


                        }
                        else {
                            // Existing data
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    alert.showAlertDialog(
                                            Home.this,
                                           "Failed",
                                            "No internet connection",
                                            false);
                                    pDialog.dismiss();
                                }
                            });


                        }
                    }else{



                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else {
                // Error in connection
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        alert.showAlertDialog(
                                Home.this,
                                "Error",
                                "No internet connection",
                                false);
                        pDialog.dismiss();
                    }
                });

            }
            return null;
        }
        protected void onPostExecute(Void result) {
            // dismiss the dialog once done
            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();
            //add intent
        }
    }


}
