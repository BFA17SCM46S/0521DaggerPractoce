package com.example.a0521daggerpractoce.di;


import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    private String baseurl;

    public RetrofitModule(String baseurl) {
        this.baseurl = baseurl;
    }

    @Provides
    Retrofit providesRetrofitInstance(){
        return new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseurl)
                .build();
    }

}
