package com.example.tugasmvvm.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugasmvvm.Model.GetDataCountryResponseItem
import com.example.tugasmvvm.R
import kotlinx.android.synthetic.main.item_country.view.*

class AdapterCountry(private var onclik : (GetDataCountryResponseItem)->Unit): RecyclerView.Adapter<AdapterCountry.ViewHolder>() {

    private var datacountry : List<GetDataCountryResponseItem>? = null

    fun setDataCountry(country : List<GetDataCountryResponseItem>){
        this.datacountry = country
    }

    class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview)  {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val tampilkan = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return ViewHolder(tampilkan)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.nm_negara.text = datacountry!![position].name
        holder.itemView.text_subregion.text = datacountry!![position].timezones.toString()
        holder.itemView.text_population.text = datacountry!![position].population.toString()
        holder.itemView.text_population1.text = datacountry!![position].subregion

//        //get data dan menampilkan gambar
        Glide.with(holder.itemView.context)
            .load(datacountry!![position].flags.png)
            .into(holder.itemView.img_country)

        holder.itemView.card_contry.setOnClickListener {
            onclik(datacountry!![position])
        }
    }

    override fun getItemCount(): Int {
        if (datacountry == null){
            return 0
        } else{
            return datacountry!!.size
        }
    }
}