package com.example.tugasmvvm.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tugasmvvm.Model.GetDataCountryResponseItem
import com.example.tugasmvvm.Network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCountry : ViewModel(){
    lateinit var livedataCountry : MutableLiveData<List<GetDataCountryResponseItem>>
    init {
        livedataCountry = MutableLiveData()
    }
    fun getDataCountryObserve() : MutableLiveData<List<GetDataCountryResponseItem>>{
        return livedataCountry
    }

    fun makeApiCountry(){
        ApiClient.instance.getAllCountry()
            .enqueue(object : Callback<List<GetDataCountryResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetDataCountryResponseItem>>,
                    response: Response<List<GetDataCountryResponseItem>>
                ) {
                    if (response.isSuccessful){
                        livedataCountry.postValue(response.body())
                    }else{
                        livedataCountry.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetDataCountryResponseItem>>, t: Throwable) {
                    livedataCountry.postValue(null)
                }

            })
    }
}