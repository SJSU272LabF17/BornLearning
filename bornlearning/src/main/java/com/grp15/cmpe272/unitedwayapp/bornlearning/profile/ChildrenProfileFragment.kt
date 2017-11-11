package com.grp15.cmpe272.unitedwayapp.bornlearning.profile


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

import com.grp15.cmpe272.unitedwayapp.bornlearning.R
import com.grp15.cmpe272.unitedwayapp.bornlearning.development.AssessmentActivity


/**
 * A simple [Fragment] subclass.
 */
class ChildrenProfileFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_children_profile, container, false)

        var placeHolderButton : Button = view.findViewById(R.id.button_place_holder_take_assessment)

        // here we assume bundle will contain the necessary data to take the assessment
        var bundle = this.activity?.intent?.getBundleExtra("payload")
        placeHolderButton.setOnClickListener{ takeAssessment(it, bundle ?: Bundle()) }

        // Inflate the layout for this fragment
        return view
    }

    fun takeAssessment(view : View, bundle : Bundle) {
        val intent = Intent(this.activity, QuestionImplementationActivity::class.java)
        intent.putExtra("data", bundle)
        Toast.makeText(this.activity, "Taking assessment", Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }
}
