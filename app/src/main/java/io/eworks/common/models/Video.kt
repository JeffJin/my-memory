package io.eworks.common.models

import java.sql.Time

class Video(id: String, override var title: String, override var cloudUrl: String): Asset(id) {
    val thumbnails: ArrayList<String> = ArrayList<String>()
    var duration: Int = 0
    var pausedAt: Time = Time(0);

    fun play(): Unit {

    }

    fun stop(): Unit {

    }
}