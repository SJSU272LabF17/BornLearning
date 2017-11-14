package com.grp15.cmpe272.unitedwayapp.bornlearning.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Represents Center entity.
 */
@Entity(tableName = "Centers")
data class Center(

    @PrimaryKey(autoGenerate = true)
    var centerId: Int = 0,

    var centerName: String? = null,

    var centerAddress: String? = null,

    var pincode: Double? = null,

    var type: String? = null,

    var chapter: String? = null,

    var city: String? = null,

    var district: String? = null,

    var sevika: String? = null,

    var sevikaPhone: String? = null,

    @ColumnInfo(name = "FacilitatorId")
    var facilitatorId: Int? = null,

    @ColumnInfo(name = "geolocation")
    var geoLocation: String? = null
) {
}