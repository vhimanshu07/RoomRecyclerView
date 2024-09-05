package com.example.roomrecyclerview.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrecyclerview.databinding.TupleLayoutBinding

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    companion object {
        fun from(parent: ViewGroup): TupleLayoutBinding {
            val layoutInflater = LayoutInflater.from(parent.context)
            return TupleLayoutBinding.inflate(layoutInflater, parent, false)
        }
    }


}