package com.grp15.cmpe272.unitedwayapp.bornlearning.model

/**
 * Created by vin on 12/10/17.
 *
 * Class that represents a child source response.
 */
data class ChildSourceResponse(

    var indicatorID: Int,

    var childID: Int,

    var response: Int,

    var assessmentDate: String

): Response() {

    override fun getType(): ResponseType {
        return ResponseType.CHILD_SOURCE_TYPE
    }
}