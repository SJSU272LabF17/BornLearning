package com.grp15.cmpe272.unitedwayapp.bornlearning.profile

import android.widget.BaseAdapter
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Response

/**
 * Created by vin on 12/11/17.
 */
abstract class QuestionCustomAdapter: BaseAdapter() {

    abstract fun getFilledResponses(): MutableList<Response>

}