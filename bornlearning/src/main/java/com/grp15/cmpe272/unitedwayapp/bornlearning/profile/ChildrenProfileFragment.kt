package com.grp15.cmpe272.unitedwayapp.bornlearning.profile


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.grp15.cmpe272.unitedwayapp.bornlearning.R


/**
 * A simple [Fragment] subclass.
 */
class ChildrenProfileFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_children_profile, container, false)
    }

}
