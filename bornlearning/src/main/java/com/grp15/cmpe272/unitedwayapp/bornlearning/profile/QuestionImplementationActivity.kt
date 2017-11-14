package com.grp15.cmpe272.unitedwayapp.bornlearning.profile

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.grp15.cmpe272.unitedwayapp.bornlearning.R


/**
 * Created by madhu on 11/9/2017.
 */
class QuestionImplementationActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_implementation)

        val ll : LinearLayout = findViewById(R.id.ll)

        ll.orientation = LinearLayout.VERTICAL

        for(j in 0..2) {
            val rg = RadioGroup(this)
            rg.orientation = RadioGroup.VERTICAL
            val tv = TextView(this);
            tv.textSize = 20f
            tv.text = "Question"+(j+1)
            for (i in 0..2) {
                // create a radio button
                val rb = RadioButton(this)
                // set text for the radio button
                rb.text = i.toString()
                // assign an automatically generated id to the radio button
                rb.id = i;
                // add radio button to the radio group
                rg.addView(rb)
            }
            ll.addView(tv)
            ll.addView(rg)
        }

    }

}