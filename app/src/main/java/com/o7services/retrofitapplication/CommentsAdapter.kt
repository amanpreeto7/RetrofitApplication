package com.o7services.retrofitapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentsAdapter : RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {
    var array = ArrayList<CommentsResponseItem>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvName = view.findViewById<TextView>(R.id.tvName)
        var tvEmail = view.findViewById<TextView>(R.id.tvEmail)
        var tvBody = view.findViewById<TextView>(R.id.tvBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.layout_comments, parent, false)
        return ViewHolder(view.rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.setText(array[position].name)
        holder.tvEmail.setText(array[position].email)
        holder.tvBody.setText(array[position].body)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    fun updateList(array: ArrayList<CommentsResponseItem>){
        this.array.addAll(array)
        notifyDataSetChanged()
    }

    fun clearList(){
        this.array.clear()
        notifyDataSetChanged()
    }
}