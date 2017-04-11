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
import android.view.View;

import com.example.user.baggagehandler.adapters.AlertDialogManager;
import com.example.user.baggagehandler.adapters.BaggageRecyclerAdapter;
import com.example.user.baggagehandler.adapters.FlightRecyclerAdapter;

import java.util.ArrayList;

public class Baggage extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<String> listbaggageID = new ArrayList();
    ArrayList<String> listflightNo = new ArrayList();
    ArrayList<String> listbaggageNo= new ArrayList();
    ArrayList<String> listStatus = new ArrayList();
    ArrayList<String> listpassengerName = new ArrayList();

    ProgressDialog pDialog;
    AlertDialogManager alert = new AlertDialogManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baggage);

        recyclerView= (RecyclerView) findViewById(R.id.baggageRecycler);
        prepareData();

        BaggageRecyclerAdapter adapter=new BaggageRecyclerAdapter(Baggage.this,listbaggageID.toArray(new String[listbaggageID.size()]),
                listflightNo.toArray(new String[listflightNo.size()]),listbaggageNo.toArray(new String[listbaggageNo.size()]),
                listStatus.toArray(new String[listStatus.size()]),listpassengerName.toArray(new String[listpassengerName.size()]));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(Baggage.this));

    }


    public void prepareData(){

        listbaggageID.add("1");
        listflightNo.add("12345");
        listbaggageNo.add("43243");
        listStatus.add("Success");
        listpassengerName.add("Mercy Kimaku");

        listbaggageID.add("1");
        listflightNo.add("12345");
        listbaggageNo.add("43243");
        listStatus.add("Success");
        listpassengerName.add("Mercy Kimaku");

        listbaggageID.add("1");
        listflightNo.add("12345");
        listbaggageNo.add("43243");
        listStatus.add("Success");
        listpassengerName.add("Mercy Kimaku");

        listbaggageID.add("1");
        listflightNo.add("12345");
        listbaggageNo.add("43243");
        listStatus.add("Success");
        listpassengerName.add("Mercy Kimaku");

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
        Intent i = new Intent(Baggage.this,Home.class);
        startActivity(i);
        Baggage.this.finish();

    }

}
