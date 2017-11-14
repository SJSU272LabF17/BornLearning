package com.grp15.cmpe272.unitedwayapp.bornlearning.model

import org.joda.time.DateTime
import java.io.Serializable

/**
 * Created by ManaliJain on 11/13/17.
 * Represents InfrastructureDev entity.
 */
data class InfrastructureDev(

        var indicatorID: Int,

        var centerID: Int,

        var response: Int,

        var assessmentDate: DateTime

) : Serializable {
}