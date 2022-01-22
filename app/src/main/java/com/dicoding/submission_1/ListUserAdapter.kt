package com.dicoding.submission_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListUserAdapter(private val listUser: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    private lateinit var onButtonClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(user: User)
    }

    fun setOnButtonClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onButtonClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvCompany: TextView = itemView.findViewById(R.id.tv_item_company)
        var tvLocation: TextView = itemView.findViewById(R.id.tv_item_location)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_user, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, company, location, avatar) = listUser[position]
        holder.imgPhoto.setImageResource(avatar)
        holder.tvName.text = name
        holder.tvCompany.text = company
        holder.tvLocation.text = location
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listUser[holder.adapterPosition]) }

    }

    override fun getItemCount(): Int = listUser.size
}