package com.grp15.cmpe272.unitedwayapp.bornlearning

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Facilitator
import com.grp15.cmpe272.unitedwayapp.bornlearning.task.FacilitatorGetTask
import com.grp15.cmpe272.unitedwayapp.bornlearning.util.GlobalProperties
import java.io.Serializable


/**
 * Created by amita on 11/9/2017.
 */
class LoginFragment : Fragment() {

    lateinit var facilitatorGetTask: FacilitatorGetTask

    private var facilitator: Facilitator? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_login, container, false)

        // load global properties
        GlobalProperties.loadProperties(context!!, GlobalProperties.APPLICATION_PROPERTIES_FILENAME)

        val uwSid: EditText  = view.findViewById(R.id.edit_text_facilitator_id)


        val takeAssessmentButton : Button = view.findViewById(R.id.button_main_take_assessment)
        takeAssessmentButton.setOnClickListener { login(it, uwSid) }

        return view
    }

    private fun getFacilitator(id: Int) {
        facilitatorGetTask = FacilitatorGetTask()
        facilitatorGetTask.execute(FacilitatorGetTask.GET_FACILITATOR_BY_ID + id.toString())
        facilitator = facilitatorGetTask.get()
    }


    private fun login(view: View, id: EditText) {
        if (id.text.toString().matches(Regex("[0-9]+"))) {
            val intent = Intent(this.activity, MainActivity::class.java)

            getFacilitator(id.text.toString().toInt())
            if (facilitator == null) {
                Toast.makeText(context, "Unable to find facilitator: ${id.text}", Toast.LENGTH_SHORT).show()
            } else {
                intent.putExtra(Facilitator::class.simpleName, facilitator as Serializable)
                Toast.makeText(this.activity, "Logging in: " + id.text, Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }

        } else {
            Toast.makeText(context, "ID should be an Integer.", Toast.LENGTH_SHORT).show()
        }
    }
}