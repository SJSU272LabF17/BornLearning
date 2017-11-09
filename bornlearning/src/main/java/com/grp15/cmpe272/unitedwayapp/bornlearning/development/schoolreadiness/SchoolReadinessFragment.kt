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


/**
 * School Readiness fragment to manage its sub-categories.
 */
class SchoolReadinessFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_school_readiness, container, false)

        var socialAndEmotionalButton : Button = view.findViewById(R.id.button_social_and_emotional)
        socialAndEmotionalButton.setOnClickListener{ openChildrenProfile(it) }

        // Inflate the layout for this fragment
        return view
    }

    /**
     * This method is invoked by all buttons, they just have varying data to pass via intent.
     */
    fun openChildrenProfile(view : View) {
        val intent = Intent(this.activity, ChildrenProfileActivity::class.java)
        Toast.makeText(this.activity, "Profiles", Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }

}
