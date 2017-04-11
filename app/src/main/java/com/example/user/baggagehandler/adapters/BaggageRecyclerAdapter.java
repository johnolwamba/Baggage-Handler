package com.example.user.baggagehandler.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.baggagehandler.R;

/**
 * Created by apple on 11/04/2017.
 */

public class BaggageRecyclerAdapter extends  RecyclerView.Adapter<BaggageRecyclerHolder> {

    ProgressDialog pDialog;
    AlertDialogManager alert = new AlertDialogManager();

    private String[] baggageID;
    private String[] flightNo;
    private String[] baggageNo;
    private String[] status;
    private String[] passengerName;


    Context context;
    LayoutInflater inflater;
    public BaggageRecyclerAdapter(Context context,String[] baggageID, String[] flightNo, String[] baggageNo,
                                 String[] status,String[] passengerName) {
        this.context=context;
        this.baggageID = baggageID;
        this.flightNo = flightNo;
        this.baggageNo = baggageNo;
        this.status = status;
        this.passengerName = passengerName;

        inflater=LayoutInflater.from(context);
    }
    @Override
    public BaggageRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.baggage_list_item, parent, false);

        BaggageRecyclerHolder viewHolder=new BaggageRecyclerHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaggageRecyclerHolder holder, int position) {
        holder.txtFlightNo.setText(flightNo[position]);
        holder.txtName.setText(passengerName[position]);
        holder.txtBaggageNo.setText(baggageNo[position]);
        holder.txtStatus.setText(status[position]);
    }


    @Override
    public int getItemCount() {
        return baggageID.length;
    }



}




