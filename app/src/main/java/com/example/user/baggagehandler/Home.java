package com.example.user.baggagehandler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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

}
