package com.example.statessearchview;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * https://gist.githubusercontent.com/jpriebe/d62a45e29f24e843c974/raw/b1d3066d245e742018bce56e41788ac7afa60e29/us_state_capitals.json
 */
public class StatesClient {
    private static final String BASE_URL = "https://gist.githubusercontent.com/";
    private static StatesClient instance;
    private Retrofit retrofit;

    public static StatesClient getInstance(){
        if (instance == null){
            instance = new StatesClient();
        }
        return instance;
    }

    private StatesClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
    }

    private StatesService getStatesService(){
        return retrofit.create(StatesService.class);
    }

    public Call<States> getStatesResponse(){
        return getStatesService().getStates();
    }
}
