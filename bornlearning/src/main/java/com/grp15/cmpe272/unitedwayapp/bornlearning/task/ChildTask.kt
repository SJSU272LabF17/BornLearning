package com.grp15.cmpe272.unitedwayapp.bornlearning.task

import com.fasterxml.jackson.module.kotlin.readValue
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Child
import com.grp15.cmpe272.unitedwayapp.bornlearning.util.GlobalProperties

/**
 * Created by vin on 12/3/17.
 */
class ChildTask : RestGetListTask<Child>() {
    companion object {
        val GET_CHILDREN_BY_CENTERID_ENDPOINT = GlobalProperties.properties.getProperty(GlobalProperties.GET_CHILDREN_BY_CENTERID_API_KEY)
    }

    override fun convertToDTOs(data: String): MutableList<Child> {
        return mapper.readValue(data)
    }
}