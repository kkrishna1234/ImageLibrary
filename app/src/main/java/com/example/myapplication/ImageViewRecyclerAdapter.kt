package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.imageloader.util.fetch
import com.example.imageloader.util.fitCenter
import com.example.imageloader.util.whenError
import com.example.imageloader.util.withPlaceholder

class ImageViewRecyclerAdapter(
    private val context: Context,
    private val imageList: List<String?>
) : RecyclerView.Adapter<ImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false)

        return ImageViewHolder(itemView)
    }


    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindData(imageList[position])
    }
}

class ImageViewHolder(private val item: View) : RecyclerView.ViewHolder(item) {

    fun bindData(url: String?) {
        item.findViewById<ImageView>(R.id.itemRecyclerView).fetch(url.orEmpty()) {
            fitCenter()
            withPlaceholder(R.drawable.ic_launcher_foreground)
            whenError(R.drawable.ic_launcher_background, R.color.black)
        }
    }

}
