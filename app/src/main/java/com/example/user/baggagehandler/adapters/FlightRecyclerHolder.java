package com.example.user.baggagehandler.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.user.baggagehandler.R;

/**
 * Created by apple on 10/04/2017.
 */

public class FlightRecyclerHolder extends RecyclerView.ViewHolder {

    TextView txtFlightNo,txtFlightDetails,txtDepartureTime,txtArrivalTime;


    public FlightRecyclerHolder(View itemView) {
        super(itemView);

        txtFlightNo= (TextView) itemView.findViewById(R.id.txtFlightNo);
        txtFlightDetails= (TextView) itemView.findViewById(R.id.txtFlightDetails);
        txtDepartureTime= (TextView) itemView.findViewById(R.id.txtDepartureTime);
        txtArrivalTime= (TextView) itemView.findViewById(R.id.txtArrivalTime);
    }
}

