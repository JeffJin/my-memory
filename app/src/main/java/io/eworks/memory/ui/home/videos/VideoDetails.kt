package io.eworks.memory.ui.home.videos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import io.eworks.common.models.Category
import io.eworks.common.services.CommonService
import io.eworks.memory.R

class VideoDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_details)

//        var categorySpinner: Spinner = binding.spinnerCategoryVideo
//        val categories = CommonService.loadCategories()
//        val adapterCategories = ArrayAdapter<Category>(
//            requireContext(),
//            android.R.layout.simple_spinner_item,
//            categories.values.toList()
//        )
//
//        adapterCategories.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        categorySpinner.adapter = adapterCategories
    }
}