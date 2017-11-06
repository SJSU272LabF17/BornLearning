package com.grp15.cmpe272.unitedwayapp.bornlearning.profile

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.grp15.cmpe272.unitedwayapp.bornlearning.R
import com.grp15.cmpe272.unitedwayapp.bornlearning.profile.child.ChildProfileActivity

class ChildrenProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_children_profile)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_children_profile, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        return when (item?.itemId) {
            R.id.item_children_profile_add_profile -> addChildProfile()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun addChildProfile() : Boolean {
        val intent = Intent(this, ChildProfileActivity::class.java)
        intent.putExtra(ChildProfileActivity.SELECT_ACTION, ChildProfileActivity.ADD_CHILD_PROFILE)
        startActivity(intent)
        return true
    }
}
