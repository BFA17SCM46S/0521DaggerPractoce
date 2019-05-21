package com.example.a0521daggerpractoce.di;

import com.example.a0521daggerpractoce.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {RetrofitModule.class})
@Singleton
public interface MyComponent {
    void injectRetrofit(MainActivity activity);

}
