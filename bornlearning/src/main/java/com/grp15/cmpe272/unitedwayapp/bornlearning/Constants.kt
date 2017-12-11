package com.grp15.cmpe272.unitedwayapp.bornlearning

/**
 * Created by marvi on 11/14/2017.
 */
class Constants {
    companion object {
        val DEVELOPMENT_TYPE = "development_type"
        val SUBCATEGORY_TYPE = "subcatergory_type"
    }

    enum class DevelopmentType(val type: String) {
        SCHOOL_READINESS("schoolReadiness"),
        INFRASTRUCTURE("infrastructure"),
        COMMUNITY_READINESS("communityReadiness")
    }

    enum class SubcategoryType(val type: String) {
        SOCIAL_AND_EMOTIONAL("Social and Emotional"),
        LANGUAGE_AND_COMMUNICATOIN("Language and Communication"),
        COGNITIVE("Cognitive"),
        MOVEMENT_PHYSICAL_DEVELOPMENT("Movement/Physical Development"),
        PHYSICAL_WELLBEING("Physical Wellbeing"),

        LANGUAGE_AND_COMMUNICATION("Language and Communication"),
        BUILDING_INFRASTRUCTURE("Building Infrastructure"),
        EDUCATIONAL_MATERIAL("Educational Material"),
        PORTABLE_INFRASTRUCTURE("Portable Infrastructure")
    }
}