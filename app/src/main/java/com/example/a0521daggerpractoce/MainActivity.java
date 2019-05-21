package com.example.a0521daggerpractoce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.a0521daggerpractoce.di.RetrofitModule;
import com.example.a0521daggerpractoce.model.Response;
import com.example.a0521daggerpractoce.network.ApiInterface;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initial component
        ((MyApplication)getApplication()).getComponent().injectRetrofit(this);

        ApiInterface retrofitModule = retrofit.create(ApiInterface.class);
        //call end point methos
        Observable <List<Response>>  observabl = retrofitModule.getphotos();

        //subscribe two methods with lamda
        //scheduler for backgroud threac
        //main threaf for ui

        observabl.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResult,this::handleError);
    }

    private void handleResult(List<Response> responses) {
        Log.e("bin", "handleError: "+responses.toString());
    }

    private void handleError(Throwable throwable) {
        Log.e("bin", "handleError: "+throwable.getMessage());
    }




}
