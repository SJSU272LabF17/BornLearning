package com.grp15.cmpe272.unitedwayapp.bornlearning.model

import java.io.Serializable

/**
 * Created by ManaliJain on 11/13/17.
 * Represents Community entity.
 */
data class Indicators(

        var indicatorID: Int,

        var indicatorLabel: String,

        var category: Int,

        var subCategory: String? = null,

        var ageGroup: String

) : Serializable {
}