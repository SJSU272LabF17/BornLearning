package com.grp15.cmpe272.unitedwayapp.bornlearning.profile.child


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

import com.grp15.cmpe272.unitedwayapp.bornlearning.R
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Center
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Child
import com.grp15.cmpe272.unitedwayapp.bornlearning.task.ChildPostTask
import com.grp15.cmpe272.unitedwayapp.bornlearning.task.ChildPutTask
import java.text.SimpleDateFormat
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class AddUpdateChildProfileFragment : Fragment() {

    companion object {
        val EXTRA_REQUEST_UPDATE = "EXTRA_REQUEST_UPDATE"
    }

    private val TAG = AddUpdateChildProfileFragment::javaClass.name

    private var selectedCenter: Center? = null

    private var childToUpdate: Child? = null

    private var selectedCenterId: Int? = null

    private var isUpdating = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_update_child_profile, container, false)

        if (activity?.intent!!.hasExtra(EXTRA_REQUEST_UPDATE)) {
            childToUpdate = activity?.intent?.getSerializableExtra(EXTRA_REQUEST_UPDATE) as Child
        }
        if (childToUpdate == null) {
            selectedCenter = activity?.intent?.getSerializableExtra(Center::javaClass.name) as Center
            selectedCenterId = selectedCenter!!.centerId
        } else {
            isUpdating = true
            selectedCenterId = childToUpdate!!.centerID
            loadViews(view)
        }


        val submitButton: Button = view.findViewById(R.id.button_add_child_submit)
        submitButton.setOnClickListener { submit(view) }


        return view
    }

    private fun postChild(child: Child) {
        val postTask = ChildPostTask()
        postTask.execute(child)

        // TODO: fix this, currently not handling the error properly.
        if (postTask.get()) {
            Toast.makeText(context, "Child creation successful.", Toast.LENGTH_SHORT).show()
            activity?.finish()
        } else {
            Toast.makeText(context, "Error occurred on POST request.", Toast.LENGTH_SHORT).show()
        }

    }

    private fun putChild(child: Child) {
        val putTask = ChildPutTask()
        putTask.execute(child)

        // TODO: fix this, currently not handling the error properly.
        if (putTask.get()) {
            Toast.makeText(context, "Child update successful.", Toast.LENGTH_SHORT).show()
            activity?.finish()
        } else {
            Toast.makeText(context, "Error occurred on PUT request.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadViews(view: View) {
        var editTextViewId = view.findViewById<EditText>(R.id.edit_text_add_child_id)
        editTextViewId.setText(childToUpdate?.childID.toString())
        editTextViewId.isEnabled = false

        view.findViewById<EditText>(R.id.edit_text_add_child_first_name).setText(childToUpdate?.childFName)
        view.findViewById<EditText>(R.id.edit_text_add_child_last_name).setText(childToUpdate?.childLName)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        var datePickerView: DatePicker = view.findViewById(R.id.datepicker_add_child_dob)
        val date: Date = dateFormat.parse(childToUpdate?.childDOB)
        var calendar: Calendar = Calendar.getInstance()
        calendar.time = date
        datePickerView.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), null)

        val radioGroup: RadioGroup = view.findViewById(R.id.radiogroup_add_child_gender)
        if (childToUpdate?.gender == "M") {
            radioGroup.check(R.id.radiobutton_gender_male)
        } else {
            radioGroup.check(R.id.radiobutton_gender_female)
        }

        view.findViewById<EditText>(R.id.edit_text_add_child_guardian_name).setText(childToUpdate?.guardianName)
        view.findViewById<EditText>(R.id.edit_text_add_child_guardian_phone).setText(childToUpdate?.guardianPhone)

    }

    private fun submit(view: View) {
        var childId: Int = view.findViewById<EditText>(R.id.edit_text_add_child_id).text.toString().toInt()
        var childFirstName: String = view.findViewById<EditText>(R.id.edit_text_add_child_first_name).text.toString()
        var childLastName: String = view.findViewById<EditText>(R.id.edit_text_add_child_last_name).text.toString()
        var childDoBInString: String

        var datePickerView: DatePicker = view.findViewById(R.id.datepicker_add_child_dob)
        var calendar: Calendar = Calendar.getInstance()
        calendar.set(datePickerView.year, datePickerView.month, datePickerView.dayOfMonth)
        var childDoB = Date(calendar.timeInMillis)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        childDoBInString = dateFormat.format(childDoB)

        val radioGroup: RadioGroup = view.findViewById(R.id.radiogroup_add_child_gender)
        val childGender = view.findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text.toString()
        val guardianName: String = view.findViewById<EditText>(R.id.edit_text_add_child_guardian_name).text.toString()
        val guardianPhone: String = view.findViewById<EditText>(R.id.edit_text_add_child_guardian_phone).text.toString()

        val child = Child(childID = childId,
                childFName = childFirstName,
                childLName = childLastName,
                childDOB = childDoBInString,
                gender = childGender,
                guardianName = guardianName,
                guardianPhone = guardianPhone,
                centerID = selectedCenterId!!,
                active = "Y")

        if (isUpdating) {
            putChild(child)
        } else {
            postChild(child)
        }
    }

}
