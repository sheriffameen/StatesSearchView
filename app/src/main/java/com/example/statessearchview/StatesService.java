package com.example.statessearchview;

/**
 * https://gist.githubusercontent.com/jpriebe/d62a45e29f24e843c974/raw/b1d3066d245e742018bce56e41788ac7afa60e29/us_state_capitals.json
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StatesService {
    @GET("jpriebe/d62a45e29f24e843c974/raw/b1d3066d245e742018bce56e41788ac7afa60e29/us_state_capitals.json")
    Call<States>getStates();
}
