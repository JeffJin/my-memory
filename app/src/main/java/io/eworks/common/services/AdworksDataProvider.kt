package io.eworks.common.services

import android.content.Context
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet
import io.eworks.common.models.ImageAsset
import io.eworks.memory.R

object AdworksDataProvider {
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

    val sampleImages: List<ImageAsset> = listOf<ImageAsset>(
        ImageAsset("1", "image 1", R.drawable.img_abc),
        ImageAsset("2", "image 2", R.drawable.img_abc),
        ImageAsset("3", "image 3", R.drawable.img_abc),
        ImageAsset("4", "image 4", R.drawable.img_abc),
        ImageAsset("5", "image 5", R.drawable.img_abc),
        ImageAsset("6", "image 6", R.drawable.img_abc),
        ImageAsset("7", "image 7", R.drawable.img_abc),
        ImageAsset("8", "image 8", R.drawable.img_abc),
        ImageAsset("9", "image 9", R.drawable.img_abc),
        ImageAsset("10","image 10", R.drawable.img_abc),
        ImageAsset("11","image 11", R.drawable.img_abc),
        ImageAsset("12","image 12", R.drawable.img_abc),
        ImageAsset("13","image 13", R.drawable.img_abc),
        ImageAsset("14","image 14", R.drawable.img_abc),
        ImageAsset("15","image 15", R.drawable.img_abc),
        ImageAsset("16","image 16", R.drawable.img_abc),
        ImageAsset("17","image 17", R.drawable.img_abc),
        ImageAsset("18","image 18", R.drawable.img_abc),
        ImageAsset("19","image 19", R.drawable.img_abc),
        ImageAsset("20","image 20", R.drawable.img_abc),
        ImageAsset("21","image 21", R.drawable.img_abc),
        ImageAsset("22","image 22", R.drawable.img_abc),
        ImageAsset("23","image 23", R.drawable.img_abc),
    )

}

//class VideoDataService(context: Context): ManagedSQLiteOpenHelper(context, "AssetDatabase.db", null, 1) {
//
//}

