package com.grp15.cmpe272.unitedwayapp.bornlearning.task

import android.os.AsyncTask
import android.util.Log
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result

/**
 * Created by vin on 12/9/17.
 */
abstract class RestPutTask<T>: AsyncTask<T, Void, Boolean>() {

    private val TAG = RestPutTask<T>::javaClass.name

    var mapper = ObjectMapper().registerKotlinModule()

    abstract fun getUrl(): String

    abstract fun getObjectId(obj: T): Any

    private fun getEntity(body: T): Boolean? {
        var bodyToJsonString = mapper.writeValueAsString(body)
        Log.i(TAG,"Body: " + bodyToJsonString)
        val request = getUrl().httpPut().body(bodyToJsonString)
        request.headers["Content-Type"] = "application/json"

        var isSuccessful = true
        request.response {
            request, response, result ->
            when(result) {
                is Result.Failure -> {
                    Log.e(TAG, result.getException().message)
                    isSuccessful = false
                }
            }
        }

        return isSuccessful
    }

    override fun onPostExecute(result: Boolean?) {
        super.onPostExecute(result)
    }

    override fun doInBackground(vararg p0: T?): Boolean? {
        return getEntity(p0[0]!!)
    }
}