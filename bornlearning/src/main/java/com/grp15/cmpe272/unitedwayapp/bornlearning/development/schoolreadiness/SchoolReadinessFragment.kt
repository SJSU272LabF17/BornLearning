package com.grp15.cmpe272.unitedwayapp.bornlearning.development.schoolreadiness


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

import com.grp15.cmpe272.unitedwayapp.bornlearning.R
import com.grp15.cmpe272.unitedwayapp.bornlearning.profile.ChildrenProfileActivity
import com.grp15.cmpe272.unitedwayapp.bornlearning.profile.QuestionImplementationActivity


/**
 * School Readiness fragment to manage its sub-categories.
 */
class SchoolReadinessFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_school_readiness, container, false)

        var socialAndEmotionalButton : Button = view.findViewById(R.id.button_social_and_emotional)
        socialAndEmotionalButton.setOnClickListener{ openChildrenProfile(it) }

        var languageAndCommunication : Button = view.findViewById(R.id.button_language_and_communication)
        languageAndCommunication.setOnClickListener{ openChildrenProfile(it) }

        var CognitiveButton : Button = view.findViewById(R.id.button_cognitive)
        CognitiveButton.setOnClickListener{ openChildrenProfile(it) }

        var movementAndPhysicalDevelopmentButton : Button = view.findViewById(R.id.button_movement_and_physical_development)
        movementAndPhysicalDevelopmentButton.setOnClickListener{ openChildrenProfile(it) }

        var PhysicalWellbeingButton : Button = view.findViewById(R.id.button_physical_wellbeing)
        PhysicalWellbeingButton.setOnClickListener{ openChildrenProfile(it) }
        // Inflate the layout for this fragment
        return view
    }

    /**
     * This method is invoked by all buttons, they just have varying data to pass via intent.
     */
    fun openChildrenProfile(view : View) {
        val intent = Intent(this.activity, QuestionImplementationActivity::class.java)
        startActivity(intent)
    }

}
