package com.grp15.cmpe272.unitedwayapp.bornlearning.task

import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Child
import com.grp15.cmpe272.unitedwayapp.bornlearning.util.GlobalProperties

/**
 * Created by vin on 12/9/17.
 */
class ChildPostTask: RestPostTask<Child>() {
    companion object {
        val ADD_CHILD_ENDPOINT: String? = GlobalProperties.properties.getProperty(GlobalProperties.POST_ADD_CHILD_API)
    }

    override fun getUrl(): String {
        return ADD_CHILD_ENDPOINT!!
    }
}