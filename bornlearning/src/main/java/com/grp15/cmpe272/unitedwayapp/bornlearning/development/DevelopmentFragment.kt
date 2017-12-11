package com.grp15.cmpe272.unitedwayapp.bornlearning.development


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.grp15.cmpe272.unitedwayapp.bornlearning.Constants

import com.grp15.cmpe272.unitedwayapp.bornlearning.R
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Center
import com.grp15.cmpe272.unitedwayapp.bornlearning.profile.ChildrenProfileActivity
import java.io.Serializable


/**
 * A simple [Fragment] subclass.
 */
class DevelopmentFragment : Fragment() {

    companion object {
        private val CENTER_EXTRA_KEY = "CENTER_EXTRA_KEY"
    }

    lateinit var selectedCenter: Center

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_development, container, false)

        val subCategoryButton : Button = view.findViewById(R.id.button_school_readiness)
        subCategoryButton.setOnClickListener{ openSchoolReadiness(it) }

        val infrastructureDevelopmentButton : Button = view.findViewById(R.id.button_infrastructure_development)
        infrastructureDevelopmentButton.setOnClickListener{ openInfrastructureCategory(it) }

        val communityReadinessButton : Button = view.findViewById(R.id.button_community_readiness)
        communityReadinessButton.setOnClickListener{ openCommunityReadinessCategory(it) }

        selectedCenter = activity?.intent?.getSerializableExtra(Center::class.simpleName) as Center

        initializeTextViews(view)

        // Inflate the layout for this fragment
        return view
    }

    fun initializeTextViews(view: View) {
        val centerNameValueTextView: TextView = view.findViewById(R.id.textview_development_center_name_value)
        centerNameValueTextView.text = selectedCenter.centerName

        val sevikaNameValueTextView: TextView = view.findViewById(R.id.textview_development_sevika_name_value)
        sevikaNameValueTextView.text = selectedCenter.sevika

        val sevikaPhoneValueTextView: TextView = view.findViewById(R.id.textview_development_sevika_contact_value)
        sevikaPhoneValueTextView.text = selectedCenter.sevikaPhone
    }


    fun openSchoolReadiness(view : View) {
        val intent = Intent(this.activity, ChildrenProfileActivity::class.java)
        intent.putExtra(Constants.DEVELOPMENT_TYPE, Constants.DevelopmentType.SCHOOL_READINESS.name)
        intent.putExtra(Center::class.simpleName, selectedCenter as Serializable)
        startActivity(intent)
    }

    fun openInfrastructureCategory(view : View) {
        val intent = Intent(this.activity, ChildrenProfileActivity::class.java)
        intent.putExtra(Constants.DEVELOPMENT_TYPE, Constants.DevelopmentType.INFRASTRUCTURE.name)
        intent.putExtra(Center::class.simpleName, selectedCenter as Serializable)
        startActivity(intent)
    }

    fun openCommunityReadinessCategory(view : View) {
        val intent = Intent(this.activity, ChildrenProfileActivity::class.java)
        intent.putExtra(Constants.DEVELOPMENT_TYPE, Constants.DevelopmentType.COMMUNITY_READINESS.name)
        intent.putExtra(Center::class.simpleName, selectedCenter as Serializable)
        startActivity(intent)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(CENTER_EXTRA_KEY, selectedCenter)
    }

}
