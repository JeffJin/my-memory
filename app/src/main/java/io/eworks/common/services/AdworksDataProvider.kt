package io.eworks.common.services

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet

class AdworksDataProvider {
    init {
        FuelManager.instance.baseHeaders = mapOf("User-Agent" to "Adworks my-memory")
    }
    fun searchWiki(term: String, skip: Int, take: Int) {
        Urls.getSearchUrl(term, skip, take).httpGet()
            .responseObject(WikiDataDeserializer()){ _, res, result ->
                if (res.statusCode != 200) {
                   throw Exception("Unable to get resources")
                }

                val(data, _) = result
            }
    }

}

