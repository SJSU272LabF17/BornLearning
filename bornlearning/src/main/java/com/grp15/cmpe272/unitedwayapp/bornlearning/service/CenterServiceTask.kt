package com.grp15.cmpe272.unitedwayapp.bornlearning.service

import com.fasterxml.jackson.module.kotlin.readValue
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Center

/**
 * Created by vin on 11/27/17.
 */
class CenterServiceTask : RestServiceTask<Center>() {

    companion object {
        var getCentersByFacilitatorIdEndpoint = "https://cmpe272-gr15-unitedway.appspot.com/centers/byFacilitator/"
    }

    override fun convertToDTOs(data: String): MutableList<Center> {
        return mapper.readValue(data)
    }
}