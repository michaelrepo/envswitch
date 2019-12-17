package com.michael.demo.net;

import android.content.Context;

import com.michael.demo.BuildConfig;
import com.michael.envswitch.EnvSwitch;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppRetrofit {

    private static Retrofit sMusicRetrofit;

    private static String sMusicHost = "";

    public static Retrofit getMusicRetrofit(Context context) {
        String host = EnvSwitch.getAppEnvironment(context);
        if (sMusicRetrofit == null || sMusicHost == null || !sMusicHost.equals((host))) {
            sMusicHost = host;
            sMusicRetrofit = new Retrofit.Builder()
                    .baseUrl(sMusicHost)
                    .client(new OkHttpClient.Builder()
                            .build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sMusicRetrofit;
    }

    private static Retrofit sAppRetrofit;

    private static String sAppHost = "";

    public static Retrofit getAppRetrofit(Context context) {
        String host = EnvSwitch.getAppEnvironment(context);
        if (sAppRetrofit == null || sAppHost == null || !sAppHost.equals((host))) {
            sAppHost = host;
            sAppRetrofit = new Retrofit.Builder()
                    .baseUrl(sAppHost)
                    .client(new OkHttpClient.Builder()
                            .build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sAppRetrofit;
    }
}
