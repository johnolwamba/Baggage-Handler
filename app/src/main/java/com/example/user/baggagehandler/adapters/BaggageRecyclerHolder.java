package com.example.user.baggagehandler.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.user.baggagehandler.R;

/**
 * Created by apple on 11/04/2017.
 */

public class BaggageRecyclerHolder extends RecyclerView.ViewHolder {

    TextView txtName,txtFlightNo,txtBaggageNo,txtStatus;


    public BaggageRecyclerHolder(View itemView) {
        super(itemView);

        txtFlightNo= (TextView) itemView.findViewById(R.id.txtFlightNo);
        txtBaggageNo= (TextView) itemView.findViewById(R.id.txtBaggageNo);
        txtName= (TextView) itemView.findViewById(R.id.txtName);
        txtStatus= (TextView) itemView.findViewById(R.id.txtStatus);
    }
}


