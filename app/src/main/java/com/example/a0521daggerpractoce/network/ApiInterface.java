package com.example.a0521daggerpractoce.network;

import com.example.a0521daggerpractoce.model.Response;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("photos/")
    Observable<List<Response>> getphotos();
}
