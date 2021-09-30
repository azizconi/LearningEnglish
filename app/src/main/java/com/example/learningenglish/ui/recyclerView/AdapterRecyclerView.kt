package com.example.learningenglish.ui.recyclerView

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.learningenglish.R
import com.example.learningenglish.data.Entity
import com.example.learningenglish.utils.OnClick

class AdapterRecyclerView(
    private var onClick: OnClick
) : RecyclerView.Adapter<AdapterRecyclerView.RecyclerViewHolder>() {

    private var entity: List<Entity> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Entity>){
        entity = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_learning,
            parent, false
        )
        return RecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val currentItem = entity[position]
        holder.englishTranslate.text = currentItem.englishVariant
        holder.russianTranslate.text = currentItem.russianVariant

        holder.itemView.setOnClickListener {
            onClick.onClickList(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return entity.size
    }


    class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val englishTranslate: TextView = itemView.findViewById(R.id.englishTranslate)
        val russianTranslate: TextView = itemView.findViewById(R.id.russianTranslate)
    }


}