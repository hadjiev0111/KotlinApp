package com.amir.kotlinapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amir.kotlinapp.R
import com.amir.kotlinapp.data.model.VideoInfo
import com.amir.kotlinapp.utils.setImageFromUrl
import kotlinx.android.synthetic.main.playlist_item.view.*
import kotlinx.android.synthetic.main.playlist_item.view.playlist_title

class PlaylistsAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    var items = mutableListOf<VideoInfo.Info>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.playlist_item, parent, false)
        return PlaylistsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun addItems(list: MutableList<VideoInfo.Info>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    inner class PlaylistsViewHolder(itemView: View) : BaseViewHolder(itemView) {
        override fun onBind(position: Int) {
            itemView.playlist_title.text = items[position].snippet?.title
            itemView.imagePlaylist.setImageFromUrl(items[position].snippet?.thumbnails?.medium?.url, itemView.imagePlaylist)
        }
    }
}