package com.mr_mir.mvvmimlementation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mr_mir.mvvmimlementation.R
import com.mr_mir.mvvmimlementation.model.ModelClass

/**
 * Created by Shitab Mir on 20,June,2020
 */
class MyAdapter(var context: Context, var list: List<ModelClass?>?): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvId: TextView = itemView.findViewById<TextView>(R.id.tvId) as TextView
        val tvData: TextView = itemView.findViewById<TextView>(R.id.tvData) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycleview_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvData.text = list?.get(position).toString()
        holder.tvData.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Item number: $position ", Toast.LENGTH_LONG).show()
        })
    }

}