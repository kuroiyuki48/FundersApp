package com.example.funderapps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.funderapps.model.UserProfile;
import com.example.funderapps.network.ApiClient;
import com.example.funderapps.network.ApiInterface;
import com.example.funderapps.network.response.UserProfileResponse;
import com.example.funderapps.network.response.UserResponse;
import com.example.funderapps.utils.SharedPrefManager;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    ApiInterface apiInterface;

    SharedPrefManager SharedPrefManager;

    @BindView(R.id.tvNama)
    TextView tvNama;

    @BindView(R.id.tvEmail)
    TextView tvEmail;

    @BindView(R.id.tvRole)
    TextView tvRole;

    @BindView(R.id.tvProvinsi)
    TextView tvProvinsi;

    @BindView(R.id.tvKabkota)
    TextView tvKabkota;

    @BindView(R.id.tvLokasi)
    TextView tvLokasi;

    @BindView(R.id.tvKategori)
    TextView tvKategori;

    @BindView(R.id.tvRangeFund)
    TextView tvRangeFund;

    @BindView(R.id.tvRangeEmployee)
    TextView tvRangeEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ButterKnife.bind(this);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        SharedPrefManager = new SharedPrefManager(this);

        Call<UserProfileResponse> get_user = apiInterface.getUser(SharedPrefManager.getSPToken());

        get_user.enqueue(new Callback<UserProfileResponse>()
        {

            @Override
            public void onResponse(Call<UserProfileResponse> call, Response<UserProfileResponse> response)
            {
                if (response.isSuccessful())
                {
                    UserProfileResponse user = response.body();

                    //API response

                    tvNama.setText(user.getName());
                    tvEmail.setText(user.getEmail());

                    tvRole.setText(user.getRole());
                    tvProvinsi.setText(user.getProvinsi());
                    tvKabkota.setText(user.getKabkota());

                    tvLokasi.setText(user.getLokasi());
                    tvKategori.setText(user.getKategori());
                    tvRangeEmployee.setText(user.getRangeEmployee());
                    tvRangeFund.setText(user.getRangeFund());

//                    System.out.println(response.body());
                }
                else
                {
                    System.out.println("Request Error :: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<UserProfileResponse> call, Throwable t) {

            }
        });

    }

    @OnClick(R.id.btnLogout) void logout() {
        SharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
        startActivity(new Intent(ProfileActivity.this, LoginActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        finish();
    }

}