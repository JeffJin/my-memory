package io.eworks.common.services

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import io.eworks.common.models.WikiResult
import java.io.Reader

class AdworksDataProvider {

    fun searchWiki(term: String, skip: Int, take: Int) {
        Urls.getSearchUrl(term, skip, take).httpGet()
            .responseObject(WikiDataDeserializer()){req, res, result ->
                val(data, _) = result
            }
    }
    class WikiDataDeserializer: ResponseDeserializable<WikiResult> {
        override fun deserialize(reader: Reader): WikiResult? {

            return Gson().fromJson(reader, WikiResult:: class.java)
        }
    }
}