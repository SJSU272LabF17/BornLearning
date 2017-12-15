package com.grp15.cmpe272.unitedwayapp.bornlearning.development.infrastructure


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.grp15.cmpe272.unitedwayapp.bornlearning.Constants

import com.grp15.cmpe272.unitedwayapp.bornlearning.R
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Center
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Child
import com.grp15.cmpe272.unitedwayapp.bornlearning.profile.QuestionImplementationActivity


/**
 * A simple [Fragment] subclass.
 */
class InfrastructureFragment : Fragment() {

    private var selectedCenter: Center? = null

//    private var selectedChild: Child? = null

    private lateinit var selectedCategory: Constants.DevelopmentType


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_infrastructure, container, false)

        // take the selectedCenter & selectedChild from intent
//        selectedChild = activity?.intent?.getSerializableExtra(Child::class.simpleName) as Child
        selectedCenter = activity?.intent?.getSerializableExtra(Center::class.simpleName) as Center
        selectedCategory = activity?.intent?.getSerializableExtra(Constants.DEVELOPMENT_TYPE) as Constants.DevelopmentType


        val buildingInfrastruvtureButton : Button = view.findViewById(R.id.button_building_infrastracture)
        buildingInfrastruvtureButton.setOnClickListener {
            openChildrenProfile(it, Constants.SubcategoryType.BUILDING_INFRASTRUCTURE.type)
        }

        val portableInfrastructureButton : Button = view.findViewById(R.id.button_portable_infrastructure)
        portableInfrastructureButton.setOnClickListener {
            openChildrenProfile(it, Constants.SubcategoryType.PORTABLE_INFRASTRUCTURE.type)
        }

        val educationalMaterialsButton : Button = view.findViewById(R.id.button_educational_materials)
        educationalMaterialsButton.setOnClickListener {
            openChildrenProfile(it, Constants.SubcategoryType.EDUCATIONAL_MATERIAL.type)
        }

        // Inflate the layout for this fragment
        return view;
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
        intent.putExtra(Child::class.simpleName, createMockedChild())
        intent.putExtra(Constants.DEVELOPMENT_TYPE, selectedCategory)

        startActivity(intent)
    }

    // simple hack to pass a child with zero age.
    private fun createMockedChild(): Child {
        return Child(childID = 0,
                childLName = "Placeholder",
                childFName = "Placeholder",
                active = "Y",
                guardianName = "Placeholder",
                guardianPhone = "111",
                imageID = "",
                gender = "M",
                centerID = selectedCenter!!.centerId,
                childDOB = "2099-12-12",
                age = 0)
    }

}// Required empty public constructor
