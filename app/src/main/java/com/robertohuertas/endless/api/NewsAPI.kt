package com.robertohuertas.endless.api

import com.robertohuertas.endless.EndlessService
import com.robertohuertas.endless.models.Covid
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/appointment/sessions/public/findByDistrict")
   suspend fun getcov(
        @Query("district_id")
        distid: String = "512",
        @Query("date")
        dateid: String = "31-03-2021"

    ): Response<EndlessService.Covid>








}
class RetrofitInstance {
    companion object {

        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            Retrofit.Builder()
                .baseUrl("https://cdn-api.co-vin.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        val api by lazy {
            retrofit.create(NewsAPI::class.java)
        }
    }
}