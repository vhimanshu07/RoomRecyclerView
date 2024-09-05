package com.example.roomrecyclerview.RecyclerView

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val itemList: ArrayList<ItemList>) : RecyclerView.Adapter<ViewHolder>() {
    private lateinit var currentViewHolder: ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return currentViewHolder
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        buildViewHolder(holder, position)
    }

    private fun buildViewHolder(holder: ViewHolder, position: Int) {

        currentViewHolder = holder
    }


}