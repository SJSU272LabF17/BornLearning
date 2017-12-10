package com.grp15.cmpe272.unitedwayapp.bornlearning.model

import java.io.Serializable

/**
 * Class that represents Facilitator.
 */
data class Facilitator(

    val facilitatorID: Int,

    val name: String,

    val phone: String

) : Serializable {
    companion object {
        val FACILITATOR_TITLE = "facilitator_id"
    }
}