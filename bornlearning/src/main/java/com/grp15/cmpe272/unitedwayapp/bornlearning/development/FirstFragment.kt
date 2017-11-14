package com.grp15.cmpe272.unitedwayapp.bornlearning.development

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.grp15.cmpe272.unitedwayapp.bornlearning.R
import java.util.*

/**
 * Created by amita on 11/9/2017.
 */
class FirstFragment: Fragment() {

    lateinit var centerSelectionSpinner : Spinner

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view : View = inflater.inflate(R.layout.fragment_main, container, false)

        centerSelectionSpinner = view.findViewById(R.id.spinner_main_center_selection)

        initializeSelectCenterSpinner()

        var takeAssessmentButton : Button = view.findViewById(R.id.button_main_take_assessment)
        takeAssessmentButton.setOnClickListener { takeAssessment(it) }

        var viewHistory : Button = view.findViewById(R.id.button_main_view_history)
        viewHistory.setOnClickListener { viewHistory(it) }

        // Inflate the layout for this fragment
        return view
    }

    fun takeAssessment(view : View) {
        // TODO: set intent as assessment and open Development Activity
        val intent = Intent(this.activity, DevelopmentActivity::class.java)
        Toast.makeText(this.activity, "Take Assessment", Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }

    fun viewHistory(view : View) {
        // TODO: set intent as view history and open Development Activity
        Toast.makeText(this.activity, "View History", Toast.LENGTH_SHORT).show()
    }

    private fun getCenterNames(userUid : UUID) : List<String> {

        // TODO: look up database for the list of available Centers for this user
        var centerNames : MutableList<String> = mutableListOf("Center Name 1", "Center Name 2", "Center Name 3")
        centerNames.add(0, "Select Center")
        return centerNames
    }

    private fun initializeSelectCenterSpinner() {
        var centerNames : Array<String> = getCenterNames(UUID.randomUUID()).toTypedArray()

        centerSelectionSpinner.adapter = ArrayAdapter<String>(this.activity,
                android.R.layout.simple_list_item_1, centerNames)

        centerSelectionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }
}