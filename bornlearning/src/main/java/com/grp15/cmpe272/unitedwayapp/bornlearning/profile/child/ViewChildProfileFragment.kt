package com.grp15.cmpe272.unitedwayapp.bornlearning.profile.child


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.grp15.cmpe272.unitedwayapp.bornlearning.R


/**
 * A simple [Fragment] subclass.
 */
class ViewChildProfileFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_child_profile, container, false)
    }

}// Required empty public constructor
