package com.grp15.cmpe272.unitedwayapp.bornlearning.util

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import java.io.IOException
import java.io.InputStream
import java.util.*

/**
 * Created by vin on 12/3/17.
 */
object GlobalProperties {
    val TAG = GlobalProperties::class.java.name
    val APPLICATION_PROPERTIES_FILENAME = "application.properties"

    // keys
    val GET_CENTERS_BY_FACILITATORID_API_KEY = "getCentersByFacilitatorIdAPI"
    val GET_CHILDREN_BY_CENTERID_API_KEY = "getChildrenByCenterIdAPI"
    val GET_FACILITATOR_BY_ID_API_KEY = "getFacilitatorByIdAPI"
    val POST_ADD_CHILD_API = "postAddChildAPI"
    val PUT_UPDATE_CHILD_API = "putUpdateChildAPI"
    val GET_INDICATORS_API = "getIndicatorsAPI"
    val POST_SCHOOL_READINESS_API = "postSchoolReadinessAPI"
    val POST_INFRASTRUCTURE_DEV_API = "postInsfrastructureDevAPI"
    val POST_COMMUNITY_READINESS_API = "postCommunityReadinessAPI"

    val READ_TIMEOUT_MILLIS = "readTimeoutInMillis"

    var properties: Properties = Properties()

    fun loadProperties(context: Context, filename: String) {
        val assetManager: AssetManager = context.assets
        var inputStream: InputStream? = null
        try {
            inputStream = assetManager.open(filename)
            properties.load(inputStream)
        } catch (ioEx: IOException) {
            Log.e(TAG, ioEx.message)
        } finally {
            inputStream?.close()
        }
    }
}