package com.grp15.cmpe272.unitedwayapp.bornlearning.development


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.grp15.cmpe272.unitedwayapp.bornlearning.Constants

import com.grp15.cmpe272.unitedwayapp.bornlearning.R
import com.grp15.cmpe272.unitedwayapp.bornlearning.profile.ChildrenProfileActivity


/**
 * A simple [Fragment] subclass.
 */
class DevelopmentFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_development, container, false)

        var subCategoryButton : Button = view.findViewById(R.id.button_school_readiness)
        subCategoryButton.setOnClickListener{ openSubCategory(it) }

        var infrastructureDevelopmentButton : Button = view.findViewById(R.id.button_infrastructure_development)
        infrastructureDevelopmentButton.setOnClickListener{ openInfrastructureCategory(it) }

        var communityReadinessButton : Button = view.findViewById(R.id.button_community_readiness)
        communityReadinessButton.setOnClickListener{ openCommunityReadinessCategory(it) }
        // Inflate the layout for this fragment
        return view
    }


    fun openSubCategory(view : View) {
        val intent = Intent(this.activity, ChildrenProfileActivity::class.java)
        intent.putExtra(Constants.DEVELOPMENT_TYPE, Constants.DevelopmentType.SCHOOL_READINESS.name)
        startActivity(intent)
    }

    fun openInfrastructureCategory(view : View) {
        val intent = Intent(this.activity, ChildrenProfileActivity::class.java)
        intent.putExtra(Constants.DEVELOPMENT_TYPE, Constants.DevelopmentType.INFRASTRUCTURE.name)
        startActivity(intent)
    }

    fun openCommunityReadinessCategory(view : View) {
        val intent = Intent(this.activity, ChildrenProfileActivity::class.java)
        intent.putExtra(Constants.DEVELOPMENT_TYPE, Constants.DevelopmentType.COMMUNITY_READINESS.name)
        startActivity(intent)
    }

}
