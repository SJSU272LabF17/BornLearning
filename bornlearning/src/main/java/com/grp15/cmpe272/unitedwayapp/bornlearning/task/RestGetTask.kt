package com.grp15.cmpe272.unitedwayapp.bornlearning.task

import android.os.AsyncTask
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.kittinunf.fuel.httpGet
import com.grp15.cmpe272.unitedwayapp.bornlearning.util.GlobalProperties

/**
 * Created by vin on 12/9/17.
 */
abstract class RestGetTask<T>: AsyncTask<String, Void, T>() {
    companion object {
        val READ_TIMOUT_MS = GlobalProperties.properties.getProperty(GlobalProperties.READ_TIMEOUT_MILLIS).toInt()
    }

    var mapper = ObjectMapper().registerKotlinModule()

    private fun getEntity(url: String): T? {

        val entity: T
        val (request, response, result) = url.httpGet().timeoutRead(READ_TIMOUT_MS).responseString()
        if (response.statusCode >= 400) {
            return null
        }
        val data = result.get()
        entity = convertToDTO(data)
        return entity
    }

    abstract fun convertToDTO(data: String): T

    override fun onPostExecute(result: T?) {
        super.onPostExecute(result)
    }

    override fun doInBackground(vararg p0: String?): T? {
        return getEntity(p0[0]!!)
    }
}