package io.eworks.common.models

class WikiThumbnail {
    val source: String? = null
    val width: Int = 0
    val height: Int = 0
}

class WikiPage {
    var pageid: Int? = null
    var title: String? = null
    var fullurl: String? = null
    var thumbnail: WikiThumbnail? = null
}

class WikiResult {
    val query: WikiQueryData? = null
}
class WikiQueryData {
    val pages: ArrayList<WikiPage> = ArrayList<WikiPage>()
}