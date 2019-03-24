package com.example.statessearchview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class StatesAdapter extends RecyclerView.Adapter<StatesViewHolder> {
    private List<State> stateList;

    public StatesAdapter(List<State> stateList) {
        this.stateList = stateList;
    }

    @NonNull
    @Override
    public StatesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.states_itemview,viewGroup,false);
        return new StatesViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull StatesViewHolder statesViewHolder, int i) {
        State state = stateList.get(i);
        statesViewHolder.onBind(state);
    }

    @Override
    public int getItemCount() {
        return stateList.size();
    }

    public void setData(List<State> states){
        this.stateList = states;
        notifyDataSetChanged();
    }
}
