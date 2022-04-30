package com.example.tugasmvvm.Network

import com.example.tugasmvvm.Model.GetDataCountryResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("all")
    fun getAllCountry(): Call<List<GetDataCountryResponseItem>>

}