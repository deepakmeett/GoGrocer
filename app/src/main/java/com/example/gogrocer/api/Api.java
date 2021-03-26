package com.example.gogrocer.api;
import com.example.gogrocer.model.Banner_Model;
import com.example.gogrocer.model.Get_Data_Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
public interface Api {
    
    String BASE_URL = "https://thecodecafe.in/gogrocer-ver2.0/api/";
    String IMAGE_URL = "https://thecodecafe.in/gogrocer-ver2.0/";
    
    @GET("banner")
    Call<Banner_Model> getBanner();
    
    @GET
    Call<Get_Data_Model> getData(@Url String url);


}
