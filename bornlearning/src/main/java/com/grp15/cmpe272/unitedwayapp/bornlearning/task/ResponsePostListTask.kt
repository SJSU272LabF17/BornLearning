package com.grp15.cmpe272.unitedwayapp.bornlearning.task

import com.grp15.cmpe272.unitedwayapp.bornlearning.Constants
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Response
import com.grp15.cmpe272.unitedwayapp.bornlearning.util.GlobalProperties

/**
 * Created by vin on 12/10/17.
 */
class ResponsePostListTask(var category: Constants.DevelopmentType): RestPostTask<List<Response>>() {
    companion object {
        val POST_SCHOOL_READINESS_ENDPOINT: String? = GlobalProperties.properties.getProperty(GlobalProperties.POST_SCHOOL_READINESS_API)
        val POST_INFRASTRUCTURE_DEV_ENDPOINT: String? = GlobalProperties.properties.getProperty(GlobalProperties.POST_INFRASTRUCTURE_DEV_API)
        val POST_COMMUNITY_READINESS_ENDPOINT: String? = GlobalProperties.properties.getProperty(GlobalProperties.POST_COMMUNITY_READINESS_API)
    }
    override fun getUrl(): String {

        when(category.type) {
            Constants.DevelopmentType.SCHOOL_READINESS.type -> return POST_SCHOOL_READINESS_ENDPOINT!!
            Constants.DevelopmentType.INFRASTRUCTURE.type -> return POST_INFRASTRUCTURE_DEV_ENDPOINT!!
            Constants.DevelopmentType.COMMUNITY_READINESS.type -> return POST_COMMUNITY_READINESS_ENDPOINT!!
            else -> return ""
        }
    }
}