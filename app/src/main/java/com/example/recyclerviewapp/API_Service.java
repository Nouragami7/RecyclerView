package com.example.recyclerviewapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_Service {
    @GET("products")
    Call<MyResponse> getProducts();
}
