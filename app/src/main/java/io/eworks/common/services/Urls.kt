package io.eworks.common.services

object Urls {
    const val AdworksBaseUrl = "http://localhost:5000"
    const val AdworksHubUrl = "$AdworksBaseUrl/"
    const val AdworksApiBaseUrl = "$AdworksBaseUrl/api"
    const val AdworksImageApiUrl = "http://127.0.0.1:5000/api/images"
    const val AdworksVideoApiUrl = "$AdworksApiBaseUrl/videos"

    const val WikiBaseUrl = "https://en.wikipedia.org/w/api.php"
    fun getSearchUrl(term: String, skip: Int, take: Int): String {
        return WikiBaseUrl + "?action=query" +
                "&formatversion=2" +
                "&generator=prefixsearch" +
                "&gpssearch=$term" +
                "&gpslimit=$take" +
                "&gpsoffset=$skip" +
                "&prop=pageimages|info" +
                "&piprop=thumbnail|url" +
                "&pithumbbsize=200" +
                "&pilimit=$take" +
                "&wbptterms=description" +
                "&format=json" +
                "&inprop=url"
    }

    fun getRandomUrl(take: Int): String {
        return WikiBaseUrl + "?action=query" +
                "&formatversion=2" +
                "&generator=random" +
                "&prop=pageimages|info" +
                "&pithumbbsize=200" +
                "&grnlimit=$take" +
                "&format=json" +
                "&inprop=url"
    }

}