package com.grp15.cmpe272.unitedwayapp.bornlearning.profile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.grp15.cmpe272.unitedwayapp.bornlearning.R
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Indicator

/**
 * Created by vin on 12/10/17.
 */
class QuestionCustomAdapter(var context: Context, private var indicators: List<Indicator>)
            : BaseAdapter() {

    private var inflater: LayoutInflater? = null
    private var checkedIndicators: HashMap<Int, Int> = HashMap()

    init {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: inflater?.inflate(R.layout.listview_row_indicators, parent, false)

        val indicatorDescTextView: TextView? = view?.findViewById(R.id.textview_row_indicator_desc)
        indicatorDescTextView?.text = indicators[position].indicatorLabel

        val indicatorRadioButton1: RadioButton? = view?.findViewById(R.id.radiobutton_indicator_1)
        indicatorRadioButton1?.setOnClickListener { buttonOnClick(it, position, indicatorRadioButton1.id) }

        val indicatorRadioButton2: RadioButton? = view?.findViewById(R.id.radiobutton_indicator_2)
        indicatorRadioButton2?.setOnClickListener { buttonOnClick(it, position, indicatorRadioButton2.id) }

        val indicatorRadioButton3: RadioButton? = view?.findViewById(R.id.radiobutton_indicator_3)
        indicatorRadioButton3?.setOnClickListener { buttonOnClick(it, position, indicatorRadioButton3.id) }

        val indicatorRadioGroup: RadioGroup? = view?.findViewById(R.id.radiogroup_row_indicators)
        indicatorRadioGroup?.clearCheck()

        checkedIndicators.forEach{k, v -> if (position == k) {
            indicatorRadioGroup?.check(v)
        }}


        return view!!
    }

    private fun buttonOnClick(view: View, position: Int, buttonId: Int) {
        checkedIndicators.put(position, buttonId)
    }

    override fun getItem(position: Int): Any {
        return indicators[position]
    }

    override fun getItemId(position: Int): Long {
        return indicators[position].indicatorID.toLong()
    }

    override fun getCount(): Int {
        return indicators.size
    }
}