package io.eworks.memory.ui.home.images

import android.content.Context
import android.content.res.Resources
import android.graphics.ImageDecoder.ImageInfo
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import io.eworks.common.models.ImageAsset
import io.eworks.memory.MemoryApplication
import io.eworks.memory.R
import io.eworks.memory.ui.home.images.placeholder.PlaceholderContent.PlaceholderItem

class ImageRecyclerViewAdapter(private val context: Context,
                               private val items: List<ImageAsset>
) : RecyclerView.Adapter<ImageRecyclerViewAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.image_list_item, parent, false)
        return ViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.imageView?.setImageResource(item.drawableSrc)
        holder.textView?.text = item.title
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView? = itemView.findViewById<ImageView?>(R.id.imageView)
        val textView: TextView? = itemView.findViewById(R.id.image_title)

        override fun toString(): String {
            return super.toString() + " '" + textView?.text + "'"
        }
    }

}