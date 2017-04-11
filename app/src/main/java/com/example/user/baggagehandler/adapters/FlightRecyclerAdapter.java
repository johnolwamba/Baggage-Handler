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

public class FlightRecyclerAdapter extends  RecyclerView.Adapter<FlightRecyclerHolder> {

    ProgressDialog pDialog;
    AlertDialogManager alert = new AlertDialogManager();

    private String[] flightID;
    private String[] flightNo;
    private String[] flightDetails;
    private String[] departureTime;
    private String[] arrivalTime;


    Context context;
    LayoutInflater inflater;
    public FlightRecyclerAdapter(Context context,String[] flightID, String[] flightNo, String[] flightDetails,
                                     String[] departureTime,String[] arrivalTime) {
        this.context=context;
        this.flightID = flightID;
        this.flightNo = flightNo;
        this.flightDetails = flightDetails;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;

        inflater=LayoutInflater.from(context);
    }
    @Override
    public FlightRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.flight_list_item, parent, false);

        FlightRecyclerHolder viewHolder=new FlightRecyclerHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FlightRecyclerHolder holder, int position) {
        holder.txtFlightNo.setText(flightNo[position]);
        holder.txtFlightDetails.setText(flightDetails[position]);
        holder.txtDepartureTime.setText(departureTime[position]);
        holder.txtArrivalTime.setText(arrivalTime[position]);
    }


    @Override
    public int getItemCount() {
        return flightID.length;
    }



}




