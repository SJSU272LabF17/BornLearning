package com.grp15.cmpe272.unitedwayapp.bornlearning.model

import java.io.Serializable

/**
 * Represents Center entity.
 */
data class Center(

    var centerId: Int = 0,

    var centerName: String? = null,

    var centerAddress: String? = null,

    var pincode: Double? = null,

    var type: String? = null,

    var chapter: String? = null,

    var city: String? = null,

    var district: String? = null,

    var sevika: String? = null,

    var sevikaPhone: String? = null,

    var facilitatorId: Int? = null,

    var geoLocation: String? = null
) : Serializable {
}