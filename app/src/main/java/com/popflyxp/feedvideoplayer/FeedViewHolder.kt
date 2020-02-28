package com.popflyxp.feedvideoplayer

import android.view.View
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.feed_item.view.*

class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val carousel = itemView.carousel
    private val adapter by lazy { VideoAdapter(carousel) }

    fun bind() {
        carousel.onFlingListener = null
        PagerSnapHelper().attachToRecyclerView(carousel)
        carousel.adapter = adapter
    }

    fun play() = adapter.play()

    fun stop() = adapter.stop()
}
