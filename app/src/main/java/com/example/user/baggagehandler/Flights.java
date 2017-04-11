package com.example.user.baggagehandler;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.user.baggagehandler.adapters.AlertDialogManager;
import com.example.user.baggagehandler.adapters.FlightRecyclerAdapter;
import com.example.user.baggagehandler.adapters.PassengersRecyclerAdapter;

import java.util.ArrayList;

public class Flights extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<String> listflightID = new ArrayList();
    ArrayList<String> listflightNo = new ArrayList();
    ArrayList<String> listflightDetails= new ArrayList();
    ArrayList<String> listdepartureTime = new ArrayList();
    ArrayList<String> listarrivalTime = new ArrayList();

    ProgressDialog pDialog;
    AlertDialogManager alert = new AlertDialogManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights);

        recyclerView= (RecyclerView) findViewById(R.id.flightsRecycler);
        prepareData();

        FlightRecyclerAdapter adapter=new FlightRecyclerAdapter(Flights.this,listflightID.toArray(new String[listflightID.size()]),
                listflightNo.toArray(new String[listflightNo.size()]),listflightDetails.toArray(new String[listflightDetails.size()]),
                listdepartureTime.toArray(new String[listdepartureTime.size()]),listarrivalTime.toArray(new String[listarrivalTime.size()]));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(Flights.this));

    }


    public void prepareData(){

        listflightID.add("1");
        listflightNo.add("12345");
        listflightDetails.add("To Pass through Doha Qatar");
        listdepartureTime.add("1500H");
        listarrivalTime.add("1800H");


        listflightID.add("1");
        listflightNo.add("12345");
        listflightDetails.add("To Pass through Doha Qatar");
        listdepartureTime.add("1500H");
        listarrivalTime.add("1800H");

        listflightID.add("1");
        listflightNo.add("12345");
        listflightDetails.add("To Pass through Doha Qatar");
        listdepartureTime.add("1500H");
        listarrivalTime.add("1800H");

        listflightID.add("1");
        listflightNo.add("12345");
        listflightDetails.add("To Pass through Doha Qatar");
        listdepartureTime.add("1500H");
        listarrivalTime.add("1800H");

    }


    // Private class isNetworkAvailable
    private boolean isNetworkAvailable() {
        // Using ConnectivityManager to check for Network Connection
        ConnectivityManager connectivityManager = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent i = new Intent(Flights.this,Home.class);
        startActivity(i);
        Flights.this.finish();

    }

}
