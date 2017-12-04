package com.grp15.cmpe272.unitedwayapp.bornlearning.service

import android.os.AsyncTask
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.kittinunf.fuel.httpGet

/**
 * Created by vin on 11/27/17.
 */
abstract class RestServiceTask<T>: AsyncTask<String, Void, MutableList<T>>() {

    var mapper = ObjectMapper().registerKotlinModule()

    private fun getEntitiesRaw(url: String): MutableList<T>? {

        val entities: MutableList<T>
        val (request, response, result) = url.httpGet().responseString()
        if (response.statusCode >= 400) {
            return null
        }
        val data = result.get()
        entities = convertToDTOs(data)
        return entities
    }

    abstract fun convertToDTOs(data: String): MutableList<T>

    override fun onPostExecute(result: MutableList<T>?) {
        super.onPostExecute(result)
    }

    override fun doInBackground(vararg p0: String?): MutableList<T>? {
        return getEntitiesRaw(p0[0]!!)
    }
}