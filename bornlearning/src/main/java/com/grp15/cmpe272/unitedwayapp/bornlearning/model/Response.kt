package com.grp15.cmpe272.unitedwayapp.bornlearning.model

import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by vin on 12/11/17.
 */
abstract class Response: Serializable {

    companion object {
        val simpleDateFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

        fun convertDateToString(date: Date): String {
            return simpleDateFormatter.format(date)
        }

        enum class ResponseType(val type: String) {
            CENTER_SOURCE_TYPE("centerSourceType"),
            CHILD_SOURCE_TYPE("childSourceType")
        }
    }

    abstract fun getType(): ResponseType

}