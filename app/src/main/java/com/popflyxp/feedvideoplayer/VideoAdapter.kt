package com.popflyxp.feedvideoplayer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class VideoAdapter(
    private val recyclerView: RecyclerView
) : RecyclerView.Adapter<VideoViewHolder>() {

    private var hasFocus = false

    init {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (hasFocus) tryToPlay()
                else tryToStop()
            }
        })
    }

    override fun getItemCount() = 3

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VideoViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
    )

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) = holder.bind()

    fun play() {
        hasFocus = true
        tryToPlay()
    }

    fun stop() {
        hasFocus = false
        tryToStop()
    }

    private fun tryToPlay() {
        tryToStop()
        with(recyclerView.layoutManager as LinearLayoutManager) {
            findFirstCompletelyVisibleItemPosition().let {
                if (it != -1) (recyclerView.findViewHolderForAdapterPosition(it) as? VideoViewHolder)?.play()
            }
        }
    }

    private fun tryToStop() {
        with(recyclerView.layoutManager as LinearLayoutManager) {
            for (position in 0..itemCount) {
                (recyclerView.findViewHolderForAdapterPosition(position) as? VideoViewHolder)?.stop()
            }
        }
    }
}
