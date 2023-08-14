package com.example.recyclerviewapp;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API_Client {
    API_Service api_service;

    private static final String BASE_URL = "https://dummyjson.com/";
    private static final String TAG = "API_CLient";

    void startCall(){
        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();

        api_service = retrofit.create(API_Service.class);

        Call<MyResponse> products = api_service.getProducts();
        Callback<MyResponse> mproduct = new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                Log.i(TAG,"onResponce:");
                if (response.isSuccessful()&& response.body()!=null){
                    for (Product p : response.body().getProducts()){
                        Log.i(TAG, p.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                Log.i(TAG, "onFailure: ");
                Log.i(TAG, t.getMessage());
                t.getStackTrace();

            }
        };
        products.enqueue(mproduct);
    }
}
