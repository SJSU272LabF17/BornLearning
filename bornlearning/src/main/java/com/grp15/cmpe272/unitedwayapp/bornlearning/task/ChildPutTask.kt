package com.grp15.cmpe272.unitedwayapp.bornlearning.task

import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Child
import com.grp15.cmpe272.unitedwayapp.bornlearning.util.GlobalProperties

/**
 * Created by vin on 12/9/17.
 */
class ChildPutTask: RestPutTask<Child>() {
    companion object {
        val PUT_CHILD_ENDPOINT = GlobalProperties.properties.getProperty(GlobalProperties.PUT_UPDATE_CHILD_API)
    }

    override fun getUrl(): String {
        return PUT_CHILD_ENDPOINT
    }

    override fun getObjectId(obj: Child): Any {
        return obj.childID
    }
}