package com.grp15.cmpe272.unitedwayapp.bornlearning.model

import java.io.Serializable


/**
 * Represents Center entity.
 */
data class Center(

    var centerId: Int,

    var centerName: String,

    var centerAddress: String? = null,

    var pincode: Int,

    var type: String,

    var chapter: String,

    var city: String,

    var district: String,

    var sevika: String,

    var sevikaPhone: String,

    var facilitatorId: Int,

    var geoLocation: String? = null
) : Serializable {
}