package com.grp15.cmpe272.unitedwayapp.bornlearning.model

/**
 * Created by vin on 12/11/17.
 *
 * Class that represents a response from a center source.
 */
class CenterSourceResponse(

        var indicatorID: Int,

        var centerId: Int,

        var response: Int,

        var assessmentDate: String

): Response() {

    override fun getType(): ResponseType {
        return ResponseType.CENTER_SOURCE_TYPE
    }
}