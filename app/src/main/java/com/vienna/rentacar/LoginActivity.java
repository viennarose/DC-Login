package com.vienna.rentacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.vienna.rentacar.api.RequestPlaceholder;
import com.vienna.rentacar.api.RetrofitBuilder;
import com.vienna.rentacar.pojos.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    public EditText username, password;
    public RetrofitBuilder retrofitBuilder;
    public RequestPlaceholder requestPlaceholder;
    public TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.signup);
        MaterialButton loginBtn = (MaterialButton) findViewById(R.id.loginBtn);
        retrofitBuilder = new RetrofitBuilder();
        requestPlaceholder = retrofitBuilder.getRetrofit().create(RequestPlaceholder.class);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUp();
            }
        });


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText() != null && password.getText() != null) {
                    Call<Login> loginCall = requestPlaceholder.login(new Login(null, username.getText().toString(), null, null, password.getText().toString()));

                    loginCall.enqueue(new Callback<Login>() {
                        @Override
                        public void onResponse(Call<Login> call, Response<Login> response) {
                            if (!response.isSuccessful()) {
                                if (response.code() == 404) {
                                    Toast.makeText(LoginActivity.this, "User Not Found", Toast.LENGTH_SHORT).show();
                                    Log.e("LOGGING_ERR", response.message());

                                }
                            } else {
                                if (response.code() == 200) {
                                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }

                        }

                        @Override
                        public void onFailure(Call<Login> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "Error Logging In", Toast.LENGTH_SHORT).show();
                            Log.e("LOGGING_ERR", t.getMessage());
                        }
                    });
                } else {
                    Toast.makeText(LoginActivity.this, "All Fields are Required!", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    private void openSignUp() {
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(intent);
    }
}
