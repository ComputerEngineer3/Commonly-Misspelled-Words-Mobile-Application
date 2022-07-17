package com.example.kartrlanszckler

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.create

object RetrofitProvider {
    private val contentType = MediaType.get("application/json")

    private val retrofit :Retrofit = Retrofit.Builder()
            .baseUrl("http://karistirilansozcukler.somee.com/webapi/api/")
            .addConverterFactory(Json {
                ignoreUnknownKeys = true
                isLenient = true
                allowSpecialFloatingPointValues = true
                encodeDefaults = false
            }.asConverterFactory(contentType))
            .build()

    val newsApi = retrofit.create<NewsApi>()

}