package com.example.statessearchview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class StatesViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private TextView capitalTextView;




    public StatesViewHolder(@NonNull View itemView) {
        super(itemView);

        nameTextView = itemView.findViewById(R.id.name_textView);
        capitalTextView = itemView.findViewById(R.id.capital_textView);
    }




    public void onBind(State state){
        nameTextView.setText(state.getName());
        capitalTextView.setText(state.getCapital());


    }
}
