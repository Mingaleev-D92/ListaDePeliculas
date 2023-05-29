package com.example.listadepeliculas.di

import com.example.listadepeliculas.data.common.Constants.BASE_URL
import com.example.listadepeliculas.data.remote.api.ApiService
import com.example.listadepeliculas.data.repository.MovieRepositoryImpl
import com.example.listadepeliculas.domain.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

   @Provides
   @Singleton
   fun provideApi(): ApiService {
      val client = OkHttpClient.Builder().build()
      return Retrofit
          .Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(MoshiConverterFactory.create())
          .client(client)
          .build()
          .create()
   }

   @Provides
   @Singleton
   fun provideRepository(
       api:ApiService
   ):MovieRepository{
      return MovieRepositoryImpl(api)
   }
}