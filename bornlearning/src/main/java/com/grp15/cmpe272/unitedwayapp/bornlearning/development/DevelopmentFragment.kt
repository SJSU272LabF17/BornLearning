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
import com.grp15.cmpe272.unitedwayapp.bornlearning.development.schoolreadiness.SchoolReadinessActivity


/**
 * A simple [Fragment] subclass.
 */
class DevelopmentFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_development, container, false)

        var subCategoryButton : Button = view.findViewById(R.id.button_school_readiness)
        subCategoryButton.setOnClickListener{ openSubCategory(it) }
        // Inflate the layout for this fragment
        return view
    }


    fun openSubCategory(view : View) {
        val intent = Intent(this.activity, SchoolReadinessActivity::class.java)
        Toast.makeText(this.activity, "Sub-category", Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }

}
