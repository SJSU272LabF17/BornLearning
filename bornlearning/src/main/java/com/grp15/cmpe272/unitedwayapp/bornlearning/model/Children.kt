package com.grp15.cmpe272.unitedwayapp.bornlearning.model

import java.io.Serializable

/**
 * Created by ManaliJain on 11/13/17.
 * Represents Children entity.
 */


data class Children(

        var childID: Int,

        var childFName: String,

        var childLName: String? = null,

        var childDOB: String,

        var gender: String,

        var guardianName: String,

        var guardianPhone: String,

        var centerID: Int,

        var imageID: String? = null,

        var active: String

) : Serializable {
}