package com.example.user.baggagehandler.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.baggagehandler.R;

/**
 * Created by apple on 10/04/2017.
 */

public class PassengersRecyclerAdapter extends  RecyclerView.Adapter<PassengersRecyclerHolder> {

    ProgressDialog pDialog;
    AlertDialogManager alert = new AlertDialogManager();

    private String[] passengerID;
    private String[] flightNo;
    private String[] luggageNo;
    private String[] passengerName;
    private String[] seatNo;


    Context context;
    LayoutInflater inflater;
    public PassengersRecyclerAdapter(Context context,String[] passengerID, String[] flightNo, String[] luggageNo,
                                        String[] passengerName,String[] seatNo) {
        this.context=context;
        this.passengerID = passengerID;
        this.flightNo = flightNo;
        this.luggageNo = luggageNo;
        this.passengerName = passengerName;
        this.seatNo = seatNo;

        inflater=LayoutInflater.from(context);
    }
    @Override
    public PassengersRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.passengers_list_item, parent, false);

        PassengersRecyclerHolder viewHolder=new PassengersRecyclerHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PassengersRecyclerHolder holder, int position) {
        holder.txtFlightNo.setText(flightNo[position]);
        holder.txtLuggageNo.setText(luggageNo[position]);
        holder.txtName.setText(passengerName[position]);
        holder.txtSeatNo.setText(seatNo[position]);
    }


    @Override
    public int getItemCount() {
        return passengerID.length;
    }



}



