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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.user.baggagehandler.adapters.AlertDialogManager;
import com.example.user.baggagehandler.adapters.PassengersRecyclerAdapter;

import java.util.ArrayList;

public class Passengers extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<String> listpassengerID = new ArrayList();
    ArrayList<String> listflightNo = new ArrayList();
    ArrayList<String> listluggageNo = new ArrayList();
    ArrayList<String> listpassengerName = new ArrayList();
    ArrayList<String> listseatNo = new ArrayList();

    ProgressDialog pDialog;
    AlertDialogManager alert = new AlertDialogManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passengers);

        recyclerView= (RecyclerView) findViewById(R.id.passengerRecycler);
        prepareData();
        Log.d("listNugget_size",listflightNo.size()+"");

        PassengersRecyclerAdapter adapter=new PassengersRecyclerAdapter(Passengers.this,listpassengerID.toArray(new String[listpassengerID.size()]),
                listflightNo.toArray(new String[listflightNo.size()]),listluggageNo.toArray(new String[listluggageNo.size()]),
                listpassengerName.toArray(new String[listpassengerName.size()]),listseatNo.toArray(new String[listseatNo.size()]));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(Passengers.this));

    }


    public void prepareData(){

        listpassengerID.add("1");
        listflightNo.add("12345");
        listluggageNo.add("L_21");
        listpassengerName.add("Mercy Kimaku");
        listseatNo.add("1");


        listpassengerID.add("1");
        listflightNo.add("12345");
        listluggageNo.add("L_21");
        listpassengerName.add("Mercy Kimaku");
        listseatNo.add("1");

        listpassengerID.add("1");
        listflightNo.add("12345");
        listluggageNo.add("L_21");
        listpassengerName.add("Mercy Kimaku");
        listseatNo.add("1");

        listpassengerID.add("1");
        listflightNo.add("12345");
        listluggageNo.add("L_21");
        listpassengerName.add("Mercy Kimaku");
        listseatNo.add("1");



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
        Intent i = new Intent(Passengers.this,Home.class);
        startActivity(i);
        Passengers.this.finish();

    }

}
