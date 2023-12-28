package io.eworks.common.services

import io.eworks.common.models.Video

object VideoService {
    val videos = ArrayList<Video>()

    init {
        loadVideos("1")
    }

    private fun loadVideos(userId: String): ArrayList<Video> {
        videos.add(Video("1", "Magic Studio", "http://eworks.io/1.mpg"))
        videos.add(Video("2", "Fantastic Four", "http://eworks.io/2.mpg"))
        videos.add(Video("3", "Amazon Love", "http://eworks.io/3.mpg"))
        videos.add(Video("4", "Kingdom Hall", "http://eworks.io/4.mpg"))

        return videos;
    }
}