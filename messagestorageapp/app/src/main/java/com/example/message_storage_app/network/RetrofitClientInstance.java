package com.example.message_storage_app.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {


    private static Retrofit retrofit = null ;
    //public static final String BASE_URL = "https://msg-storage-service.herokuapp.com/server/";
    public static final String BASE_URL = "http://192.168.0.13:8080/server/";
    public static final String AUTH_URL ="auth";
    public static final String USER_URL = "user";
    public static final String MESSAGE_URL = "message";


    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    //public static AuthServiceAPI authService = retrofit.create(AuthServiceAPI.class);
    //public static UserServiceAPI userService = retrofit.create(UserServiceAPI.class);
}
