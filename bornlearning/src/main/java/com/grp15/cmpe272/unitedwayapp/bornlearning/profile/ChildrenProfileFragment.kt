package com.grp15.cmpe272.unitedwayapp.bornlearning.profile


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.grp15.cmpe272.unitedwayapp.bornlearning.Constants

import com.grp15.cmpe272.unitedwayapp.bornlearning.R
import com.grp15.cmpe272.unitedwayapp.bornlearning.development.AssessmentActivity
import com.grp15.cmpe272.unitedwayapp.bornlearning.development.CommunityReadinessActivity
import com.grp15.cmpe272.unitedwayapp.bornlearning.development.InfrastructureActivity
import com.grp15.cmpe272.unitedwayapp.bornlearning.development.schoolreadiness.SchoolReadinessActivity


/**
 * A simple [Fragment] subclass.
 */
class ChildrenProfileFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_children_profile, container, false)

        var placeHolderButton: Button = view.findViewById(R.id.button_place_holder_take_assessment)

        var listView: ListView = view.findViewById(R.id.listview_children_profile)
        var childrenNamesMock = arrayOf("ChildName1 : 3 : M ",
                "ChildName2 : 4 : M ",
                "ChildName3 : 5 : F ",
                "ChildName4 : 3 : F ",
                "ChildName5 : 4 : M ")

        var adapter: ArrayAdapter<String> = ArrayAdapter(activity,
                android.R.layout.simple_list_item_1, childrenNamesMock)
        listView.setAdapter(adapter)


        // here we assume bundle will contain the necessary data to take the assessment
        var bundle = this.activity?.intent?.getBundleExtra("payload")

        // get development type
        var developmentType = this.activity?.intent?.getStringExtra(Constants.DEVELOPMENT_TYPE)


        placeHolderButton.setOnClickListener{ takeAssessment(it, bundle ?: Bundle(),
                developmentType!!) }

        // Inflate the layout for this fragment
        return view
    }

    fun takeAssessment(view: View, bundle: Bundle, developmentType: String) {
        var intent = Intent()
        when(developmentType) {
            Constants.DevelopmentType.SCHOOL_READINESS.name ->
                intent = Intent(this.activity, SchoolReadinessActivity::class.java)
            Constants.DevelopmentType.INFRASTRUCTURE.name ->
                intent = Intent(this.activity, InfrastructureActivity::class.java)
            Constants.DevelopmentType.COMMUNITY_READINESS.name ->
                // community readiness currently doesn't have a subcategory so it
                // goes directly to the question view
                intent = Intent(this.activity, QuestionImplementationActivity::class.java)
        }

        intent.putExtra("data", bundle)
        Toast.makeText(this.activity, "Taking assessment", Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }
}
