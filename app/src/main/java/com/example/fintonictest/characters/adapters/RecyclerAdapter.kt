package com.example.fintonictest.characters.adapters

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fintonictest.characters.interfaces.ItemClickListener
import com.example.fintonictest.R
import com.example.fintonictest.domain.client.model.Superhero

class RecyclerAdapter(val items: List<Superhero>, val clickListener: ItemClickListener) : RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        context = parent.context
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_item_character,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val typeface = Typeface.createFromAsset(context.assets, "roboto_condensed.bold.ttf")
        Glide
            .with(context)
            .load(items.get(position).photo)
            .into(holder.charImage)

        holder.charName.typeface = typeface
        holder.charName.text = items.get(position).name
        holder.charDescription.typeface = typeface
        holder.charDescription.text = items.get(position).abilities
        holder.charImage.setOnClickListener {
            clickListener.onItemSelected(items.get(position))
        }

    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val charImage = itemView.findViewById<ImageView>(R.id.image_char)
        val charName = itemView.findViewById<TextView>(R.id.tv_name_char)
        val charDescription = itemView.findViewById<TextView>(R.id.tv_desc_char)
    }
}