package com.project.first

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


class RemoteDataSource {
    private interface RestCountryApi {
        @GET("name/{name}")
        suspend fun getCountryByName(@Path("name") name: String): List<Country>
    }

    private var retrofit = Retrofit.Builder()
        .baseUrl("https://restcountries.com/v3.1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var restCountryApi: RestCountryApi =
        retrofit.create<RestCountryApi>(RestCountryApi::class.java)

    suspend fun getCountryInfo(countryName: String): List<Country> {
        return restCountryApi.getCountryByName(countryName);
    }
}