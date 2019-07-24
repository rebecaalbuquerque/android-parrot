package com.albuquerque.parrot.core.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseNetwork {

    companion object {
        const val BASE_URL = "https://200.19.188.7:3010/"
    }

    protected fun getRetrofitBuilder(baseUrl: String = BASE_URL): Retrofit.Builder{

        val retrofitBuilder = Retrofit.Builder()

        with(retrofitBuilder){
            baseUrl(baseUrl)
            addConverterFactory(GsonConverterFactory.create())
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            client( OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build()
            )
        }

        return retrofitBuilder

    }

    protected fun <T, A> doRequest(api: A, onSucess: (response: T) -> Unit, onError: ((error: Throwable) -> Unit)? = null, func: A.() -> Observable<T>): Disposable {

        return api.func()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    onSucess(response)
                },
                {
                    onError?.invoke(it)
                }
            )

    }

}