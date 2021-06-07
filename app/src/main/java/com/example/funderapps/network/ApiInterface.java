package com.example.funderapps.network;

import com.example.funderapps.model.User;
import com.example.funderapps.network.response.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("api/auth/login")
    Call<UserResponse> postLogin(@Field("email") String email,
                                 @Field("password") String password);

    @GET("api/auth/user_profile")
    Call<User> getUser(@Header("Authorization") String token);

    @GET("api/auth/get_recommendation")
    Call<User> geRecommendation(@Header("Authorization") String token);

    @POST("api/auth/refresh_token")
    Call<UserResponse> refreshToken(@Header("Authorization") String token);

    @POST("api/auth/register")
    Call<UserResponse> postRegister(@Field("name") String name,
                                    @Field("email") String email,
                                    @Field("password") String password);

    @POST("api/auth/update_user")
    Call<UserResponse> updateProfile(@Header("Authorization") String token,
                                     @Field("name") String name,
                                     @Field("email") String email,
                                     @Field("password") String password,
                                     @Field("deskripsi") String deskripsi,
                                     @Field("id_kabkota") String id_kabkota,
                                     @Field("alamat") String alamat,
                                     @Field("gambar") String gambar);

    @POST("api/auth/update_dataset")
    Call<UserResponse> updateDataset(@Header("Authorization") String token,
                                     @Field("id_kategori") Integer id_kategori,
                                     @Field("id_lokasi") Integer id_lokasi,
                                     @Field("id_range_funds") Integer id_range_funds,
                                     @Field("id_range_employees") Integer id_range_employees);

}
