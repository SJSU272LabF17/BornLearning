package com.grp15.cmpe272.unitedwayapp.bornlearning.development

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.grp15.cmpe272.unitedwayapp.bornlearning.R
import com.grp15.cmpe272.unitedwayapp.bornlearning.development.schoolreadiness.SchoolReadinessActivity
import kotlinx.android.synthetic.main.login.view.*
import android.content.Intent.getIntent



/**
 * Created by amita on 11/9/2017.
 */
class LoginFragment : Fragment() {

    //var login_id:String="";
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.login, container, false)


        var uwSid: EditText  = view.findViewById(R.id.txt_sid)


        var takeAssessmentButton : Button = view.findViewById(R.id.button_main_take_assessment)
        takeAssessmentButton.setOnClickListener { login(it, uwSid) }

        return view
    }


    fun login(view: View, id: EditText) {
        // TODO: set intent as assessment and open Development Activity
        val intent = Intent(this.activity, FirstActivity::class.java)

        intent.putExtra("fname", id.text)
        Toast.makeText(this.activity, "Logging in: " + id.text, Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }
}