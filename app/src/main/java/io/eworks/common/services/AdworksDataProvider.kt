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
        ImageAsset("1", "image 1", R.drawable.s1),
        ImageAsset("2", "image 2", R.drawable.s2),
        ImageAsset("3", "image 3", R.drawable.s3),
        ImageAsset("4", "image 4", R.drawable.s4),
        ImageAsset("5", "image 5", R.drawable.s5),
        ImageAsset("6", "image 6", R.drawable.s6),
        ImageAsset("7", "image 7", R.drawable.s7),
        ImageAsset("8", "image 8", R.drawable.s8),
        ImageAsset("9", "image 9", R.drawable.s9),
        ImageAsset("10","image 10", R.drawable.s10),
        ImageAsset("11","image 11", R.drawable.s11),
        ImageAsset("12","image 12", R.drawable.s12),
        ImageAsset("13","image 13", R.drawable.s13),
        ImageAsset("14","image 14", R.drawable.s14),
        ImageAsset("15","image 15", R.drawable.s15),
        ImageAsset("16","image 16", R.drawable.s16),
        ImageAsset("17","image 17", R.drawable.s17),
        ImageAsset("18","image 18", R.drawable.s18),
        ImageAsset("19","image 19", R.drawable.s19),
        ImageAsset("20","image 20", R.drawable.s20),
        ImageAsset("21","image 21", R.drawable.s21),
        ImageAsset("22","image 22", R.drawable.s22),
        ImageAsset("23","image 23", R.drawable.s23),
    )

}

//class VideoDataService(context: Context): ManagedSQLiteOpenHelper(context, "AssetDatabase.db", null, 1) {
//
//}

