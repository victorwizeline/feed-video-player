package com.popflyxp.feedvideoplayer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FeedAdapter : RecyclerView.Adapter<FeedViewHolder>() {

    override fun getItemCount() = 10

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FeedViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.feed_item, parent, false)
    )

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) = holder.bind()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                with(recyclerView.layoutManager as LinearLayoutManager) {
                    val focusItem = findFirstCompletelyVisibleItemPosition()
                    for (position in 0..itemCount) {
                        (recyclerView.findViewHolderForAdapterPosition(position) as? FeedViewHolder)?.stop()
                    }
                    if (focusItem != -1) {
                        (recyclerView.findViewHolderForAdapterPosition(focusItem) as? FeedViewHolder)?.play()
                    }
                }
            }
        })
    }
}
