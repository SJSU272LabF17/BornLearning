package com.grp15.cmpe272.unitedwayapp.bornlearning

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.grp15.cmpe272.unitedwayapp.bornlearning.development.DevelopmentActivity
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Center
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Facilitator
import com.grp15.cmpe272.unitedwayapp.bornlearning.task.CenterGetListTask
import java.io.Serializable

/**
 * Created by amita on 11/9/2017.
 */
class MainFragment : Fragment() {

    lateinit var centerSelectionSpinner : Spinner

    lateinit var facilitator: Facilitator

    private lateinit var centerGetListTask: CenterGetListTask

    var centers: List<Center>? = mutableListOf()

    var selectedCenter: Center? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_main, container, false)

        centerSelectionSpinner = view.findViewById(R.id.spinner_main_center_selection)

        val takeAssessmentButton : Button = view.findViewById(R.id.button_main_take_assessment)
        takeAssessmentButton.setOnClickListener { takeAssessment(it) }

        val viewHistory : Button = view.findViewById(R.id.button_main_view_history)
        viewHistory.setOnClickListener { viewHistory(it) }

        facilitator = activity?.intent?.getSerializableExtra(Facilitator::javaClass.name) as Facilitator

        val facilitatorTextView: TextView = view.findViewById(R.id.text_main_facilitator_id)
        facilitatorTextView.text = facilitator.name

        initializeSelectCenterSpinner()

        // Inflate the layout for this fragment
        return view
    }

    fun takeAssessment(view : View) {
        val intent = Intent(this.activity, DevelopmentActivity::class.java)
        if (selectedCenter == null) {
            Toast.makeText(this.activity, "No Center is selected.", Toast.LENGTH_SHORT).show()
        } else {
            intent.putExtra(Center::javaClass.name, selectedCenter as Serializable)
            Toast.makeText(this.activity, "Take Assessment", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }

    fun viewHistory(view : View) {
        // TODO: set intent as view history and open Development Activity
        Toast.makeText(this.activity, "View History", Toast.LENGTH_SHORT).show()
    }

    private fun getCenters(){
        centerGetListTask = CenterGetListTask()
        centerGetListTask.execute(CenterGetListTask.getCentersByFacilitatorIdEndpoint + facilitator.facilitatorID)
        centers = centerGetListTask.get()?.toMutableList()
        if (centers == null) {
            Toast.makeText(activity, "Unable to find Centers", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initializeSelectCenterSpinner() {

        getCenters()

        var spinner: Spinner? = activity?.findViewById(R.id.spinner_main_center_selection)
        val centerNames = centers?.map {it.centerName}?.toTypedArray() ?: emptyArray()
        centerSelectionSpinner.adapter = ArrayAdapter<String>(this.activity,
                android.R.layout.simple_list_item_1, centerNames)

        centerSelectionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedCenter = centers!![0]
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedCenter = centers!![position]
            }
        }
    }
}