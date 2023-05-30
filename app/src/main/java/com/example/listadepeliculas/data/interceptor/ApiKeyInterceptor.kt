package com.example.listadepeliculas.data.interceptor

import com.example.listadepeliculas.data.common.Constants.BASE_API_KEY
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author : Mingaleev D
 * @data : 30.05.2023
 */

class ApiKeyInterceptor : Interceptor {
   override fun intercept(chain: Interceptor.Chain): Response {
      val request = chain.request()
      val url = request.url.newBuilder().addQueryParameter("api_key", BASE_API_KEY).build()
      val newRequest = request.newBuilder().url(url).build()
      return chain.proceed(newRequest)
   }
}