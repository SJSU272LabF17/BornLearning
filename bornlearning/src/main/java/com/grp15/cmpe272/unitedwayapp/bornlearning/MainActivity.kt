package com.grp15.cmpe272.unitedwayapp.bornlearning

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

/**
 * This class handles the main page of the application. This will include:
 * Born Learning, Infrastructure Development, Community Involvement & Readiness
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openSchoolReadiness(view : View) : Boolean {
        val intent = Intent(this,
                com.pixelconic.schoolreadiness.SchoolReadinessActivity::class.java)
        startActivity(intent)
        return true
    }
}
