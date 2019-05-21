package com.example.a0521daggerpractoce;

import android.app.Application;

import com.example.a0521daggerpractoce.di.DaggerMyComponent;
import com.example.a0521daggerpractoce.di.MyComponent;
import com.example.a0521daggerpractoce.di.RetrofitModule;

public class MyApplication extends Application {
    private MyComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerMyComponent.builder()
                .retrofitModule(new RetrofitModule("https://jsonplaceholder.typicode.com/")).build();
    }

    public MyComponent getComponent() {
        return component;
    }
}
