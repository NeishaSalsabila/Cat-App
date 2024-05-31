package com.neisha.catapps

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListCatAdapter (private val listCat: ArrayList<Cat>) : RecyclerView.Adapter<ListCatAdapter.ListViewHolder>() {
//    private lateinit var onItemClickCallback: OnItemClickCallback
//
//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback
//    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_cat, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listCat.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listCat[position]
        Glide.with(holder.itemView.context)
            .load(
                photo)
            .into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvDescription.text = description
//        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listCat[holder.adapterPosition]) }
//    }
//        holder.itemView.setOnClickListener {
//            Toast.makeText(
//                holder.itemView.context,
//                "Kamu memilih " + listCat[holder.adapterPosition].name,
//                Toast.LENGTH_SHORT
//            ).show()
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailCatActivity::class.java)
            intentDetail.putExtra("cat_data", listCat[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
//        interface OnItemClickCallback {
//            fun onItemClicked(data: Cat)
//    }

}