package com.grp15.cmpe272.unitedwayapp.bornlearning.profile

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.grp15.cmpe272.unitedwayapp.bornlearning.R
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Child
import com.grp15.cmpe272.unitedwayapp.bornlearning.profile.child.UpsertChildProfileFragment
import com.grp15.cmpe272.unitedwayapp.bornlearning.profile.child.ChildProfileActivity

/**
 * Created by vin on 12/3/17.
 */
class ChildrenCustomAdapter(var context: Context, private var children: ArrayList<Child>): BaseAdapter() {

    private var inflater: LayoutInflater? = null

    init {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: inflater?.inflate(R.layout.listview_row_children, parent, false)

        val childNameTextView: TextView? = view?.findViewById(R.id.textview_row_child_name)
        val childAgeTextView: TextView? = view?.findViewById(R.id.textview_row_child_age)
        val childGenderTextView: TextView? = view?.findViewById(R.id.textview_row_child_gender)
        val editChildImageView: ImageView? = view?.findViewById(R.id.imageview_row_edit_icon)
        editChildImageView?.setOnClickListener { editChild(it, children[position]) }

        val childFullName = children[position].childFName + " " + children[position].childLName
        childNameTextView?.text = childFullName

        childAgeTextView?.text = children[position].age.toString()

        childGenderTextView?.text = children[position].gender

        return view!!
    }

    private fun editChild(view: View, child: Child) {
        val intent = Intent(context, ChildProfileActivity::class.java)
        intent.putExtra(UpsertChildProfileFragment.EXTRA_REQUEST_UPDATE, child)
        intent.putExtra(ChildProfileActivity.SELECT_ACTION, ChildProfileActivity.EDIT_CHILD_PROFILE)
        context.startActivity(intent)
    }

    override fun getItem(position: Int): Any {
        return children[position]
    }

    override fun getItemId(position: Int): Long {
        return children[position].childID.toLong()
    }

    override fun getCount(): Int {
        return children.size
    }
}