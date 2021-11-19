package com.vienna.rentacar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.vienna.rentacar.adapters.RentsAdapter;
import com.vienna.rentacar.api.RequestPlaceholder;
import com.vienna.rentacar.api.RetrofitBuilder;
import com.vienna.rentacar.pojos.Rents;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    public RecyclerView rentsRecyclerView;
    public List<Rents> rentsList;
    public RentsAdapter rentsAdapter;

    public RetrofitBuilder retrofitBuilder;
    public RequestPlaceholder requestPlaceholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        retrofitBuilder = new RetrofitBuilder();
        requestPlaceholder = retrofitBuilder.getRetrofit().create(RequestPlaceholder.class);

        rentsRecyclerView = findViewById(R.id.rentsRecyclerView);
        rentsList = new ArrayList<>();
        rentsAdapter = new RentsAdapter(rentsList, this);

        rentsRecyclerView.setAdapter(rentsAdapter);
        rentsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        populateRents();

    }

    public void populateRents(){
        try {
            Call<List<Rents>> rentsCall = requestPlaceholder.getAllRents("7wlKyTErWEzCngl2rIIyRNLWdB9H0lv3", "1");

            rentsCall.enqueue(new Callback<List<Rents>>() {
                @Override
                public void onResponse(Call<List<Rents>> call, Response<List<Rents>> response) {
                    if (response.isSuccessful()){
                        if (response.code() == 200){
                            rentsList.addAll(response.body());
                            rentsAdapter.notifyDataSetChanged();

                        }else{
                            Log.e("ERROR_GET_RENTALS", response.errorBody() + "");
                            Toast.makeText(HomeActivity.this, "Error getting rents", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Log.e("ERROR_GET_RENTALS", response.errorBody() + "");
                        Toast.makeText(HomeActivity.this, "Error getting rents dzuh", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<List<Rents>> call, Throwable t) {

                }
            });
        }catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }
    }
}
