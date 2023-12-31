package io.eworks.common.models

import java.util.Date

open class Asset(val id: String, open var title: String = "", open var cloudUrl: String = "",
                 var fileSize: Int = 0, var tags: String = "", var description: String = "",
                 var fileType: String? = null, var category: String? = null,
                 var createdOn: Date? = null, var updatedOn: Date? = null,
                 var createdBy: String? = null, var updatedBy: String? = null) {
}
