package com.popflyxp.feedvideoplayer

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.video_item.view.*

class VideoVideoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val player = itemView.exoPlayer

    fun bind() {
        with(ExoPlayerFactory.newSimpleInstance(itemView.context, DefaultTrackSelector())) {
            val userAgent = Util.getUserAgent(itemView.context, "APP_NAME")
            val factory = DefaultDataSourceFactory(itemView.context, userAgent)
            prepare(ProgressiveMediaSource.Factory(factory).createMediaSource(Uri.parse("https://file-examples.com/wp-content/uploads/2017/04/file_example_MP4_480_1_5MG.mp4")))
            player.player = this
        }
    }

    fun play() {
        player.player.playWhenReady = true
    }

    fun stop() {
        player.player.playWhenReady = false
    }
}