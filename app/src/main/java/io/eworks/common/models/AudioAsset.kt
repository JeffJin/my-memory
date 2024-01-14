package io.eworks.common.models

import java.sql.Time

class AudioAsset(id: String): Asset(id) {
    var duration: Int = 0
    var pausedAt: Time = Time(0);

    fun play(): Unit {

    }
    fun stop(): Unit {

    }
}
