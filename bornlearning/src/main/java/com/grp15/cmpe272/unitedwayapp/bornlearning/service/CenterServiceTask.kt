package com.grp15.cmpe272.unitedwayapp.bornlearning.service

import com.fasterxml.jackson.module.kotlin.readValue
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Center
import com.grp15.cmpe272.unitedwayapp.bornlearning.util.GlobalProperties

/**
 * Created by vin on 11/27/17.
 */
class CenterServiceTask : RestServiceTask<Center>() {

    companion object {
        var getCentersByFacilitatorIdEndpoint = GlobalProperties.properties.getProperty(GlobalProperties.GET_CENTERS_BY_FACILITATORID_API_KEY)
    }

    override fun convertToDTOs(data: String): MutableList<Center> {
        return mapper.readValue(data)
    }
}