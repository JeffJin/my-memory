package io.eworks.common.services

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import io.eworks.common.models.WikiResult
import java.io.Reader

class WikiDataDeserializer: ResponseDeserializable<WikiResult> {
    override fun deserialize(reader: Reader): WikiResult? {

        return Gson().fromJson(reader, WikiResult:: class.java)
    }
}

