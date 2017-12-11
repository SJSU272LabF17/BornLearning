package com.grp15.cmpe272.unitedwayapp.bornlearning.task

import android.util.Log
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.kittinunf.fuel.httpGet
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Indicator
import com.grp15.cmpe272.unitedwayapp.bornlearning.util.GlobalProperties

/**
 * Created by vin on 12/10/17.
 */
class IndicatorGetListTask: RestGetListTask<Indicator>() {

    private val TAG = IndicatorGetListTask::javaClass.name

    companion object {
        val GET_INDICATORS_ENDPOINT = GlobalProperties.properties.getProperty(GlobalProperties.GET_INDICATORS_API)
        val SUB_CATEGORY_KEYNAME = "subCategory"
        val AGE_GROUP_KEYNAME = "ageGroup"
    }

    override fun convertToDTOs(data: String): MutableList<Indicator> {
        return mapper.readValue(data)
    }

    private fun getEntitiesRaw(subCategory: String?, ageGroup: String?): MutableList<Indicator>? {

        var entities: MutableList<Indicator>? = null
        val requestWithParam = if (ageGroup == null) {
            GET_INDICATORS_ENDPOINT.httpGet(listOf(SUB_CATEGORY_KEYNAME to subCategory))
        } else { GET_INDICATORS_ENDPOINT.httpGet(listOf(SUB_CATEGORY_KEYNAME to subCategory,
                    AGE_GROUP_KEYNAME to ageGroup))
        }
        Log.i(TAG, "Request: " + requestWithParam.cUrlString())

        val (request, response, result) = requestWithParam.timeoutRead(RestGetListTask.READ_TIMEOUT_MS).responseString()
        if (response.statusCode >= 400) {
            return null
        }
        val data = result.get()
        entities = convertToDTOs(data)
        return entities
    }

    /**
     * Override this function to pass extra parameters.
     */
    override fun doInBackground(vararg params: String?): MutableList<Indicator>? {
        return getEntitiesRaw(params[0], params[1])
    }

}