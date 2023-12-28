package io.eworks.common.models

import java.sql.Time

class Video(val id: String, title: String, url: String) {
    var pausedAt: Time = Time(0);

    fun play(): Unit {

    }
}