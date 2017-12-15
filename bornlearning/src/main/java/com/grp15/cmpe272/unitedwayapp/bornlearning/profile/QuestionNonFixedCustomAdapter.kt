package com.grp15.cmpe272.unitedwayapp.bornlearning.profile

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.grp15.cmpe272.unitedwayapp.bornlearning.R
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.CenterSourceResponse
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Indicator
import com.grp15.cmpe272.unitedwayapp.bornlearning.model.Response

/**
 * Created by vin on 12/11/17.
 *
 * Adapter for Questions that don't use fixed number of indicator choices.
 */
class QuestionNonFixedCustomAdapter (var context: Context, private var indicators: List<Indicator>,
                                     private var responses: MutableList<Response>)
    : QuestionCustomAdapter() {

    private val TAG = QuestionNonFixedCustomAdapter::javaClass.name

    private var inflater: LayoutInflater? = null

    var cachedValues: HashMap<Int, Int?> = HashMap()

    init {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var customViewHolder: CustomViewHolder
        val view: View?
//        if (convertView == null) {
            // TODO: refactor this to use ViewHolder
            view = inflater?.inflate(R.layout.listview_row_indicators_nonfixed, parent, false)
            customViewHolder = CustomViewHolder(view = view!!,
                    indicatorDescTextView = view.findViewById(R.id.textview_row_indicator_edittext_desc),
                    indicatorValueEditText = view.findViewById(R.id.edit_text_row_indicator_value),
                    index = position)

            view.tag = customViewHolder
//        } else {
//            view = convertView
//            customViewHolder = view.tag as CustomViewHolder
//        }

        customViewHolder.indicatorDescTextView.text = indicators[position].indicatorLabel


        if (cachedValues[position] != null) {
            val currentValue = cachedValues[position] as Int
            if (currentValue > -1) {
                customViewHolder.indicatorValueEditText.setText(currentValue.toString())
            } else {
                // clear because of Recycling
                customViewHolder.indicatorValueEditText.text?.clear()
            }
        }
//        var currentValue = -1
//        if (cachedValues[position] != null) {
//            currentValue = cachedValues[position] as Int
//        }
//
//        customViewHolder.indicatorValueEditText.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun afterTextChanged(text: Editable) {
//                if (!text.isBlank() || currentValue < 0){
//                    responses[position].responses = text.toString().toInt()
//                }
//            }
//        })

        customViewHolder.indicatorValueEditText.setOnFocusChangeListener(object: View.OnFocusChangeListener {

            override fun onFocusChange(view: View?, hasFocus: Boolean) {
               if (!hasFocus) {
                   val currentValueInString: String =  (view as EditText).text.toString()
                      if (currentValueInString.length > 0) {
                          val currentValue = currentValueInString.toInt()
                          (responses[position] as CenterSourceResponse).response = currentValue
                          cachedValues.put(position, (responses[position] as CenterSourceResponse).response)
                          Log.i(TAG, "Saving:" + position + " : " + (responses[position] as CenterSourceResponse).response)
                      }
                   }
               }
        })

//        customViewHolder.indicatorValueEditText.setOnClickListener { onClickListener(it, position)}

        return view
    }

//    private fun onClickListener(view: View, position: Int) {
//        cachedValues.put(position, responses[position].responses)
//    }

    override fun getFilledResponses(): MutableList<Response> {
        return responses
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

    inner class CustomViewHolder(view: View,  var indicatorDescTextView: TextView,
                                 var indicatorValueEditText: EditText,
                                 var index: Int): RecyclerView.ViewHolder(view) {
    }
}