package com.grp15.cmpe272.unitedwayapp.bornlearning.development


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

import com.grp15.cmpe272.unitedwayapp.bornlearning.R
import com.grp15.cmpe272.unitedwayapp.bornlearning.profile.QuestionImplementationActivity


/**
 * A simple [Fragment] subclass.
 */
class InfrastructureFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_infrastructure, container, false)

        var CognitiveButton : Button = view.findViewById(R.id.button_building_infrastracture)
        CognitiveButton.setOnClickListener{ openChildrenProfile(it) }

        var movementAndPhysicalDevelopmentButton : Button = view.findViewById(R.id.button_portable_infrastructure)
        movementAndPhysicalDevelopmentButton.setOnClickListener{ openChildrenProfile(it) }

        var PhysicalWellbeingButton : Button = view.findViewById(R.id.button_educational_materials)
        PhysicalWellbeingButton.setOnClickListener{ openChildrenProfile(it) }

        // Inflate the layout for this fragment
        return view;
    }

    /**
     * This method is invoked by all buttons, they just have varying data to pass via intent.
     */
    fun openChildrenProfile(view : View) {
        val intent = Intent(this.activity, QuestionImplementationActivity::class.java)
        startActivity(intent)
    }

}// Required empty public constructor
