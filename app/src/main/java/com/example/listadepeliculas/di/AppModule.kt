package com.example.listadepeliculas.di

import android.app.Application
import androidx.room.Room
import com.example.listadepeliculas.data.common.Constants.BASE_URL
import com.example.listadepeliculas.data.interceptor.ApiKeyInterceptor
import com.example.listadepeliculas.data.local.MovieDao
import com.example.listadepeliculas.data.local.MovieDatabase
import com.example.listadepeliculas.data.remote.api.ApiService
import com.example.listadepeliculas.data.repository.MovieRepositoryImpl
import com.example.listadepeliculas.domain.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

   @Provides
   @Singleton
   fun provideApi(): ApiService {
      val client = OkHttpClient.Builder()
          .addInterceptor(ApiKeyInterceptor())
          .addInterceptor(
              HttpLoggingInterceptor().apply {
                 level = HttpLoggingInterceptor.Level.BODY
              }
          ).build()
      return Retrofit
          .Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .client(client)
          .build()
          .create()
   }

   @Provides
   @Singleton
   fun provideRepository(
       api: ApiService,
       dao: MovieDao
   ): MovieRepository {
      return MovieRepositoryImpl(api, dao)
   }

   @Provides
   @Singleton
   fun provideDatabase(application: Application): MovieDatabase {
      return Room.databaseBuilder(application, MovieDatabase::class.java, "movie_db").build()
   }

   @Provides
   @Singleton
   fun provideDatabaseDao(database: MovieDatabase): MovieDao {
      return database.dao
   }
}