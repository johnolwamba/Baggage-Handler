package com.example.user.baggagehandler.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.user.baggagehandler.R;

/**
 * Created by apple on 10/04/2017.
 */

public class PassengersRecyclerHolder extends RecyclerView.ViewHolder {

    TextView txtName,txtFlightNo,txtSeatNo,txtLuggageNo;


    public PassengersRecyclerHolder(View itemView) {
        super(itemView);

        txtFlightNo= (TextView) itemView.findViewById(R.id.txtFlightNo);
        txtLuggageNo= (TextView) itemView.findViewById(R.id.txtLuggageNo);
        txtName= (TextView) itemView.findViewById(R.id.txtName);
        txtSeatNo= (TextView) itemView.findViewById(R.id.txtSeatNo);
    }
}

