package com.grp15.cmpe272.unitedwayapp.bornlearning.profile

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.grp15.cmpe272.unitedwayapp.bornlearning.R

@Suppress("UNREACHABLE_CODE")
/**
 * Created by madhu on 11/9/2017.
 */
class QuestionImplementationFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_question_implementation,
                container, false)

        var submitButton : Button = view.findViewById(R.id.button_question_implementation_submit)
        submitButton.setOnClickListener{ submitForm(it) }

        val linearLayout: LinearLayout = view.findViewById(R.id.linearlayout_question_implementation)
        linearLayout.orientation = LinearLayout.VERTICAL

        for (j in 0..3) {
            val rg = RadioGroup(context)
            rg.orientation = RadioGroup.HORIZONTAL
            val tv = TextView(context)
            tv.textSize = 20f
            tv.text = "Question" + (j + 1)
            for (i in 0..2) {
                // create a radio button
                val rb = RadioButton(context)
                // set text for the radio button
                rb.text = i.toString()
                // assign an automatically generated id to the radio button
                rb.id = i
                // add radio button to the radio group
                rg.addView(rb)
            }
            linearLayout.addView(tv)
            linearLayout.addView(rg)
        }

        return view
    }

    fun submitForm(view: View) {
        Toast.makeText(this.activity, "Submit", Toast.LENGTH_SHORT).show()
    }
}