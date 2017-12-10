package com.grp15.cmpe272.unitedwayapp.bornlearning.profile.child

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.FrameLayout
import com.grp15.cmpe272.unitedwayapp.bornlearning.R

class ChildProfileActivity : AppCompatActivity() {

    companion object {
        val SELECT_ACTION = "select_action"
        val ADD_CHILD_PROFILE = "add_child_profile"
        val VIEW_CHILD_PROFILE = "view_child_profle"
        val EDIT_CHILD_PROFILE = "edit_child_profile"
    }

    lateinit var currentFragment : Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child_profile)

        if (findViewById<FrameLayout>(R.id.framelayout_child_profile_fragment_container) != null) {
            //val intent : Intent = getIntent()
            when (intent.extras.getString(SELECT_ACTION)) {
                ADD_CHILD_PROFILE -> currentFragment = AddUpdateChildProfileFragment()
                EDIT_CHILD_PROFILE -> currentFragment = AddUpdateChildProfileFragment()
                else -> currentFragment = ViewChildProfileFragment()
            }

            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.framelayout_child_profile_fragment_container, currentFragment)
                    .commit()
        }
    }

}
