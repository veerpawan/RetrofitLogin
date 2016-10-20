package com.example.pawan.retrofitlogin.Interface;

/**
 * Created by Pawan on 10/14/2016.
 */


import android.database.Observable;

import com.example.pawan.retrofitlogin.Model.ServerRequest;
import com.example.pawan.retrofitlogin.Model.ServerResponse;
import com.example.pawan.retrofitlogin.Model.UsersVisitors;
import com.google.gson.annotations.SerializedName;

import java.util.List;


import retrofit.Call;
import retrofit.Callback;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;


public interface RequestInterface {

    @GET("loginUsersVisitorsGSON")
    Call<List<ServerRequest>> getrequest();

    /* @FormUrlEncoded
     @POST("/GetDetailWithMonthWithCode")
     void getLandingPageReport(@Field("user_visitors_emailId") String emailId,
                               @Field("user_visitors_mobile") String mobile,
                               Callback<ServerRequest> cb);*/
    @FormUrlEncoded
    @POST("loginUsersVisitorsGSON")
    Call<List<ServerRequest>> login(@Field("user_visitors_emailId") String email, @Field("user_visitors_mobile") String password);


   /* @FormUrlEncoded
    @POST("loginUsersVisitorsGSON")
    Call<List<ServerRequest>> registration(@Field("user_visitors_emailId") String email, @Field("user_visitors_mobile") String password);
*/


    @FormUrlEncoded
    @POST("registerUsersVisitorsGSON")
    Call<List<ServerRequest>> registerUser(@Field("user_visitors_fname") String name,
                                                      @Field("user_visitors_emailId") String email,
                                                      @Field("user_visitors_mobile") String mobile,
                                                      @Field("user_visitors_native_location_id") int currentCity,
                                                      @Field("user_visitors_current_location_id") int permanentCity);



}