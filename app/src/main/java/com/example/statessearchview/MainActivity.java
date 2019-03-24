package com.example.statessearchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<States>, SearchView.OnQueryTextListener {
    private RecyclerView recyclerView;
    private StatesAdapter statesAdapter;
    private static final String TAG = "Main";
    private List<State> stateList;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);


        getStates();
    }


    public void getStates() {
        Call<States> statesResponseCall = StatesClient.getInstance().getStatesResponse();
        statesResponseCall.enqueue(this);
    }


    @Override
    public void onResponse(Call<States> call, Response<States> response) {
        States statesResponse = response.body();
        stateList = statesResponse.getStatesList();
        if (stateList != null) {
            createRecyclerView(stateList);
        } else {
            Log.d(TAG, "List is Empty");
        }
    }


    @Override
    public void onFailure(Call<States> call, Throwable t) {
        Log.d(TAG, t.toString());

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        List<State> newStateList = new ArrayList<>();
        for (State state : stateList) {
            if (state.getName().toLowerCase().startsWith(s.toLowerCase())){
                newStateList.add(state);
            }
        }
        statesAdapter.setData(newStateList);
        return false;
    }

    private void createRecyclerView(List<State> stateList) {
        statesAdapter = new StatesAdapter(stateList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(statesAdapter);
    }
}
