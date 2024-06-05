package com.farwah.daggerhiltexample.di

import com.farwah.daggerhiltexample.data.remote.MyApi
import com.farwah.daggerhiltexample.data.repository.MyRepositoryImplementation
import com.farwah.daggerhiltexample.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val BASE_URL="https://fakestoreapi.com"

    @Provides
    @Singleton
    fun provideMyApi(): MyApi{
        val loggingInterceptor= HttpLoggingInterceptor().apply {
            this.level=HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient= OkHttpClient().newBuilder()
            .connectTimeout(30,TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }
    @Provides
    @Singleton
    fun provideMyRepository(api: MyApi): MyRepository{
        return MyRepositoryImplementation(api)
    }

}