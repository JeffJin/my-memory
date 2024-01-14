package io.eworks.common.models

import android.graphics.drawable.BitmapDrawable
import io.eworks.memory.R

class ImageAsset(id: String, override var title: String, val drawableSrc: Int = R.drawable.ic_image): Asset(id) {
    var imageType: String? = null
}
