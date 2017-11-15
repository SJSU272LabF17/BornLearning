package com.grp15.cmpe272.unitedwayapp.bornlearning

/**
 * Created by marvi on 11/14/2017.
 */
class Constants {
    companion object {
        val DEVELOPMENT_TYPE = "development_type"
    }

    enum class DevelopmentType(val type: String) {
        SCHOOL_READINESS("schoolReadiness"),
        INFRASTRUCTURE("infrastructure"),
        COMMUNITY_READINESS("communityReadiness")
    }
}