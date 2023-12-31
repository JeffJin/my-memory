package io.eworks.memory.ui.home.images

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import io.eworks.memory.R
import io.eworks.memory.ui.home.images.placeholder.PlaceholderContent.PlaceholderItem
import io.eworks.memory.databinding.ImageListItemBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class ImageRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<ImageRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ImageListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.imgView.setImageResource(R.drawable.s1)
        holder.contentView.text = item.content
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: ImageListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val imgView: ImageView = binding.imageId
        val contentView: TextView = binding.imageTitle

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}