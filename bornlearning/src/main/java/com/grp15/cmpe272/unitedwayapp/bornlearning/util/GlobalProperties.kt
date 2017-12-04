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