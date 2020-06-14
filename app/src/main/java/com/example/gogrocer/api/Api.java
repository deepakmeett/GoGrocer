package com.example.gogrocer.api;
import com.example.gogrocer.model.Banner_Model;
import com.example.gogrocer.model.Deal_Model;
import com.example.gogrocer.model.New_Model;
import com.example.gogrocer.model.Recent_Model;
import com.example.gogrocer.model.Top_Selling_Model;

import retrofit2.Call;
import retrofit2.http.GET;
public interface Api {
    
    String BASE_URL = "https://thecodecafe.in/gogrocer-ver2.0/api/";
    String IMAGE_URL = "https://thecodecafe.in/gogrocer-ver2.0/";
    
    @GET("banner")
    Call<Banner_Model> getBanner();
    
    @GET("top_selling")
    Call<Top_Selling_Model> getTopSelling();

    @GET("recentselling")
    Call<Recent_Model> getrecent();
    
    @GET("dealproduct")
    Call<Deal_Model> getdeal();

    @GET("whatsnew")
    Call<New_Model> getNew();

}
