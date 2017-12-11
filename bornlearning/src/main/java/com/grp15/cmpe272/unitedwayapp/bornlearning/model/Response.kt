package com.grp15.cmpe272.unitedwayapp.bornlearning.model

import org.joda.time.DateTime
import java.io.Serializable

/**
 * Created by vin on 12/10/17.
 *
 * Class that represents a response to an Indicator.
 */
data class Response (

    var indicatorID: Int,

    var centerID: Int,

    var response: Int,

    var assessmentDate: DateTime

): Serializable