package com.jabezmagomere.core.di


import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

val networkModule = module {
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun provideGson(): Gson = Gson()
        .newBuilder()
        .create()

    fun provideChuckInterceptor(context: Context): ChuckerInterceptor = ChuckerInterceptor(context)
    fun provideOkhttpInterceptor(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        chuckerInterceptor: ChuckerInterceptor
    ) = OkHttpClient()
        .newBuilder()
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(chuckerInterceptor)
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .build()

    single { provideHttpLoggingInterceptor() }
    single { provideGson() }
    single { provideChuckInterceptor(get()) }
    single { provideOkhttpInterceptor(get(), get()) }
}



