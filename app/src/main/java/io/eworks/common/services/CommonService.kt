package io.eworks.common.services

import io.eworks.common.models.Category
import io.eworks.common.models.Video

object CommonService {

    init {
        loadCategories()
    }

    fun loadCategories(): HashMap<String, Category>{
        val categories = HashMap<String, Category>()
        categories["1"] = Category("1", "Advertisement")
        categories["2"] = Category("2", "Corals")
        categories["3"] = Category("3", "Education")
        categories["4"] = Category("4", "Fishing")
        categories["5"] = Category("5", "Sports")
        categories["6"] = Category("6", "Wild Life")
        categories["7"] = Category("7", "Unknown")
        return categories
    }
}