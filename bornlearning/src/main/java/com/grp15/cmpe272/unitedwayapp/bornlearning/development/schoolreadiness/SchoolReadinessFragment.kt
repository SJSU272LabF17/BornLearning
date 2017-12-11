package com.grp15.cmpe272.unitedwayapp.bornlearning.development.schoolreadiness


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.grp15.cmpe272.unitedwayapp.bornlearning.Constants

import com.grp15.cmpe272.unitedwayapp.bornlearning.R
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Center
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Child
import com.grp15.cmpe272.unitedwayapp.bornlearning.profile.ChildrenProfileActivity
import com.grp15.cmpe272.unitedwayapp.bornlearning.profile.QuestionImplementationActivity


/**
 * School Readiness fragment to manage its sub-categories.
 */
class SchoolReadinessFragment : Fragment() {

    private var selectedCenter: Center? = null

    private var selectedChild: Child? = null

    private lateinit var selectedCategory: Constants.DevelopmentType

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_school_readiness, container, false)


        // take the selectedCenter & selectedChild from intent
        selectedChild = activity?.intent?.getSerializableExtra(Child::class.simpleName) as Child
        selectedCenter = activity?.intent?.getSerializableExtra(Center::class.simpleName) as Center
        selectedCategory = activity?.intent?.getSerializableExtra(Constants.DEVELOPMENT_TYPE) as Constants.DevelopmentType


        var socialAndEmotionalButton : Button = view.findViewById(R.id.button_social_and_emotional)

        socialAndEmotionalButton.setOnClickListener {
            openChildrenProfile(it, Constants.SubcategoryType.SOCIAL_AND_EMOTIONAL.type)
        }

        var languageAndCommunication : Button = view.findViewById(R.id.button_language_and_communication)
        languageAndCommunication.setOnClickListener {
            openChildrenProfile(it, Constants.SubcategoryType.LANGUAGE_AND_COMMUNICATION.type)
        }

        var CognitiveButton : Button = view.findViewById(R.id.button_cognitive)
        CognitiveButton.setOnClickListener {
            openChildrenProfile(it, Constants.SubcategoryType.COGNITIVE.type)
        }

        var movementAndPhysicalDevelopmentButton : Button = view.findViewById(R.id.button_movement_and_physical_development)
        movementAndPhysicalDevelopmentButton.setOnClickListener {
            openChildrenProfile(it, Constants.SubcategoryType.MOVEMENT_PHYSICAL_DEVELOPMENT.type)
        }

        var PhysicalWellbeingButton : Button = view.findViewById(R.id.button_physical_wellbeing)
        PhysicalWellbeingButton.setOnClickListener {
            openChildrenProfile(it, Constants.SubcategoryType.PHYSICAL_WELLBEING.type)
        }
        // Inflate the layout for this fragment
        return view
    }

    /**
     * This method is invoked by all buttons, they just have varying data to pass via intent.
     */
    fun openChildrenProfile(view : View, subCategory: String?) {
        val intent = Intent(this.activity, QuestionImplementationActivity::class.java)
        if (subCategory != null) {
            intent.putExtra(Constants.SUBCATEGORY_TYPE, subCategory)
        }
        intent.putExtra(Center::class.simpleName, selectedCenter)
        intent.putExtra(Child::class.simpleName, selectedChild)
        intent.putExtra(Constants.DEVELOPMENT_TYPE, selectedCategory)

        startActivity(intent)
    }

}
