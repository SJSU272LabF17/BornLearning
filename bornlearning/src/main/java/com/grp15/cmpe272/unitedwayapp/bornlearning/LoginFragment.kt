package com.grp15.cmpe272.unitedwayapp.bornlearning

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Facilitator
import java.io.Serializable


/**
 * Created by amita on 11/9/2017.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.fragment_login, container, false)


        var uwSid: EditText  = view.findViewById(R.id.edit_text_facilitator_id)


        var takeAssessmentButton : Button = view.findViewById(R.id.button_main_take_assessment)
        takeAssessmentButton.setOnClickListener { login(it, uwSid) }

        return view
    }


    fun login(view: View, id: EditText) {
        if (id.text.toString().matches(Regex("[0-9]+"))) {
            val intent = Intent(this.activity, FirstActivity::class.java)

            var facilitator: Facilitator = Facilitator(id.text.toString().toInt(), "Madhur", "650-111-2234")

            intent.putExtra(Facilitator.toString(), facilitator as Serializable)
            Toast.makeText(this.activity, "Logging in: " + id.text, Toast.LENGTH_SHORT).show()
            startActivity(intent)
        } else {
            Toast.makeText(context, "ID should be an Integer.", Toast.LENGTH_SHORT).show()
        }
    }
}