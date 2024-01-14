package io.eworks.common.services

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.eworks.common.models.ImageAsset
import java.io.Reader
class ImageDataDeserializer: ResponseDeserializable<List<ImageAsset>> {
    val itemType = object : TypeToken<List<ImageAsset>>() {}.type
    override fun deserialize(reader: Reader): List<ImageAsset> {

        return Gson().fromJson(reader, itemType)
    }
}