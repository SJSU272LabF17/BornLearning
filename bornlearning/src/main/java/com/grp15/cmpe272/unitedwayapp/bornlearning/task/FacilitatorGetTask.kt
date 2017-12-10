package com.grp15.cmpe272.unitedwayapp.bornlearning.task

import com.fasterxml.jackson.module.kotlin.readValue
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Facilitator
import com.grp15.cmpe272.unitedwayapp.bornlearning.util.GlobalProperties

/**
 * Created by vin on 12/9/17.
 */
class FacilitatorGetTask : RestGetTask<Facilitator>() {

    companion object {
        val GET_FACILITATOR_BY_ID: String? = GlobalProperties.properties.getProperty(GlobalProperties.GET_FACILITATOR_BY_ID_API_KEY)
    }

    override fun convertToDTO(data: String):Facilitator {
        return mapper.readValue(data)
    }
}