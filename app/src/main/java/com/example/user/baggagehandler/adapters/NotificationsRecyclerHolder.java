package com.example.user.baggagehandler.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.user.baggagehandler.R;


/**
 * Created by apple on 09/04/2017.
 */

public class NotificationsRecyclerHolder extends RecyclerView.ViewHolder {

    TextView txtFlightNo,txtLuggageNo,txtDate;


    public NotificationsRecyclerHolder(View itemView) {
        super(itemView);

        txtFlightNo= (TextView) itemView.findViewById(R.id.txtFlightNo);
        txtLuggageNo= (TextView) itemView.findViewById(R.id.txtLuggageNo);
        txtDate= (TextView) itemView.findViewById(R.id.txtDate);
    }
}
