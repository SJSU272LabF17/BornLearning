package com.grp15.cmpe272.unitedwayapp.bornlearning.model

import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by vin on 12/10/17.
 *
 * Class that represents a response to an Indicator.
 */
data class Response (

    var indicatorID: Int,

    var childID: Int,

    var response: Int,

    var assessmentDate: String

): Serializable {
    companion object {
        val simpleDateFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

        fun convertDateToString(date: Date): String {
            return simpleDateFormatter.format(date)
        }
    }
}