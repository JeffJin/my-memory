package io.eworks.common.services

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.eworks.common.models.Image
import java.io.Reader
class ImageDataDeserializer: ResponseDeserializable<List<Image>> {
    val itemType = object : TypeToken<List<Image>>() {}.type
    override fun deserialize(reader: Reader): List<Image> {

        return Gson().fromJson(reader, itemType)
    }
}