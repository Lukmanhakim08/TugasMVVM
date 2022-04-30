package com.example.tugasmvvm.View

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugasmvvm.R
import com.example.tugasmvvm.ViewModel.ViewModelCountry
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    lateinit var adaptercount : AdapterCountry
    private lateinit var count : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        count = this
        getDataCountry()
        inirecyler()

    }

    fun inirecyler(){
        rv_country.layoutManager = LinearLayoutManager(this)
        adaptercount = AdapterCountry()
        rv_country.adapter = adaptercount
    }

    fun getDataCountry(){
        val viewModel = ViewModelProvider(this).get(ViewModelCountry::class.java)
        viewModel.getDataCountryObserve().observe(this, Observer {
            if (it != null){
                adaptercount.setDataCountry(it)
                adaptercount.notifyDataSetChanged()
            }
        })
        viewModel.makeApiCountry()
    }
}