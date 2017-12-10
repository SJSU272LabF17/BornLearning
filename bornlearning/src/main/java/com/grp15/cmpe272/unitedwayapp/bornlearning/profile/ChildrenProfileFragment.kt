package com.grp15.cmpe272.unitedwayapp.bornlearning.profile


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.grp15.cmpe272.unitedwayapp.bornlearning.Constants

import com.grp15.cmpe272.unitedwayapp.bornlearning.R
import com.grp15.cmpe272.unitedwayapp.bornlearning.development.infrastructure.InfrastructureActivity
import com.grp15.cmpe272.unitedwayapp.bornlearning.development.schoolreadiness.SchoolReadinessActivity
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Center
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Child
import com.grp15.cmpe272.unitedwayapp.bornlearning.task.ChildTask


/**
 * A simple [Fragment] subclass.
 */
class ChildrenProfileFragment : Fragment() {

    private lateinit var selectedCenter: Center

    private var childTask: ChildTask = ChildTask()

    private var children: List<Child>? = mutableListOf()

    private lateinit var childrenCustomAdapter: ChildrenCustomAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_children_profile, container, false)

        // get development type
        var developmentType = activity?.intent?.getStringExtra(Constants.DEVELOPMENT_TYPE)

        // take the selectedCenter from intent
        selectedCenter = activity?.intent?.getSerializableExtra(Center::javaClass.name) as Center

        var centerTextView: TextView = view.findViewById(R.id.textview_children_profile_center_name_value)
        centerTextView.text = selectedCenter.centerName

        getChildren()

        // setup listview
        var listView: ListView = view.findViewById(R.id.listview_children_profile)
        childrenCustomAdapter = ChildrenCustomAdapter(activity!!.applicationContext, ArrayList(children))
        listView.adapter = childrenCustomAdapter
        listView.onItemClickListener = (object: AdapterView.OnItemClickListener {
            override fun onItemClick(adapter: AdapterView<*>?, view: View?, position: Int, id: Long) {
                takeAssessment(view!!, developmentType!!, children!![position])
            }
        })


        // Inflate the layout for this fragment
        return view
    }

    /**
     * Execute a GET request to retrieve children based on the centerId.
     */
    private fun getChildren() {
        childTask.execute(ChildTask.GET_CHILDREN_BY_CENTERID_ENDPOINT + selectedCenter.centerId)
        children = childTask.get()?.toMutableList()
        if (children == null) {
            Toast.makeText(activity, "Unable to find Children.", Toast.LENGTH_SHORT).show()
            children = emptyList()
        }
    }

    /**
     * Take assessment based on the selected development.
     */
    fun takeAssessment(view: View, developmentType: String, child: Child) {
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
        intent.putExtra(Child::javaClass.name, child)
        intent.putExtra(Center::javaClass.name, selectedCenter)
        Toast.makeText(this.activity, "Taking assessment", Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }
}
