package com.example.funderapps;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.funderapps.model.User;
import com.example.funderapps.model.UserProfile;
import com.example.funderapps.network.ApiClient;
import com.example.funderapps.network.ApiInterface;
import com.example.funderapps.network.response.UserResponse;
import com.example.funderapps.utils.SharedPrefManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etPassword)
    EditText etPassword;

    Context mContext;
    ApiInterface apiInterface;
    SharedPrefManager sharedPrefManager;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        mContext = this;

        ButterKnife.bind(this);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        sharedPrefManager = new SharedPrefManager(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(false);


        if (sharedPrefManager.getSPSudahLogin()){
            startActivity(new Intent(LoginActivity.this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

    }

    @OnClick(R.id.btnLogin) void login() {
        progressDialog.show();
        Call<UserResponse> postLogin = apiInterface.postLogin(etEmail.getText().toString(),
                etPassword.getText().toString());
        postLogin.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                progressDialog.dismiss();

                if (response.code() == 200) {
                    User user = response.body().getUser();
                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMA, user.getName());
                    sharedPrefManager.saveSPString(SharedPrefManager.SP_EMAIL, user.getEmail());
                    sharedPrefManager.saveSPString(SharedPrefManager.SP_TOKEN, "Bearer " +response.body().getToken());
                    sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
                    startActivity(new Intent(mContext, MainActivity.class)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                    finish();
                } else {
                    Toast.makeText(mContext, "Email/Password salah", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                progressDialog.dismiss();
            }
        });
    }
}