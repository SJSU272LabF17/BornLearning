package com.grp15.cmpe272.unitedwayapp.bornlearning.model

/**
 * Created by vin on 12/10/17.
 * Currently not used; Plan is to have only one base RestRequestTask.
 */
data class CustomHttpEntity<T> (

    var payload: T? = null,

    var url: String,

    var requestType: RequestType

) {
    companion object {
        enum class RequestType {
            GET, POST, PUT
        }
    }
}