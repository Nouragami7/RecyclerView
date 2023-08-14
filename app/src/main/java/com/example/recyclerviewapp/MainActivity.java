package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "API_CLient";
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter = new ProductAdapter(new ArrayList<>());
        recyclerView.setAdapter(productAdapter);

        API_Client apiClient = new API_Client();
        apiClient.startCall();
        apiClient.api_service.getProducts().enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    productAdapter.productList = response.body().getProducts();
                    productAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }
}