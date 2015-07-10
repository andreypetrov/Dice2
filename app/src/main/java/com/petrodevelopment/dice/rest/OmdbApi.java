package com.petrodevelopment.dice.rest;

import android.net.http.HttpResponseCache;

import com.facebook.stetho.okhttp.StethoInterceptor;
import com.petrodevelopment.dice.rest.model.Result;
import com.squareup.okhttp.OkHttpClient;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by andrey on 09/07/2015.
 */
public class OmdbApi {
    public static final String API_URL = "http://www.omdbapi.com";
    private static OmdbApi instance;
    private final OmdbSearch omdbSearch;

    private RestAdapter restAdapter;


    public interface OmdbSearch {
        @GET("/")
        void getMovies(@Query("s") String search_query, Callback<Result> callback);
    }



    /**
     * Singleton instance
     * @return
     */
    public static OmdbApi getInstance() {
        if (instance == null) {
            instance = new OmdbApi();
        }
        return instance;
    }

    private OmdbApi() {
        initRestAdapter();
        omdbSearch = restAdapter.create(OmdbSearch.class);
    }




    public OmdbSearch getOmdbSearch() {
        return omdbSearch;
    }

    private void initRestAdapter() {
        OkHttpClient httpClient = new OkHttpClient();
        httpClient.networkInterceptors().add(new StethoInterceptor()); //add chrome console debugging
        Client client = new OkClient(httpClient);

        restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();
    }

}
