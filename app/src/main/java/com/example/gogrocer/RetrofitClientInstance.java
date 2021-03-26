package com.example.gogrocer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class RetrofitClientInstance {

    private static Retrofit retrofit;


    public static final String BASE_URL = "https://thecodecafe.in/gogrocer-ver2.0/api/"; 


    public static Retrofit getRetrofitInstance() {
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.level(HttpLoggingInterceptor.Level.BODY);

//        OkHttpClient innerClientNotification = new OkHttpClient.Builder()
//                .connectTimeout( 2, TimeUnit.MINUTES) // connect timeout
//                .writeTimeout(5, TimeUnit.MINUTES) // write timeout
//                .readTimeout(5, TimeUnit.MINUTES) // read timeout
//                .addInterceptor(logging) //logging
//                .build();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
//                    .client(innerClientNotification)
                    .addConverterFactory( GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
