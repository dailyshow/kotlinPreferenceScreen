package com.cis.kotlinpreferencescreen


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.fragment_view.view.*

/**
 * A simple [Fragment] subclass.
 */
class ViewFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_view, container, false)

        view.viewBtn.setOnClickListener {
            val pref = PreferenceManager.getDefaultSharedPreferences(activity)
            val data1 = pref.getString("data1", null)
            view.viewTv.text = "문자열 : ${data1}\n"

            val data2 = pref.getBoolean("data2", false)
            if (data2 == true) {
                view.viewTv.append("체크박스가 체크되어 있습니다.\n")
            } else {
                view.viewTv.append("체크박스가 체크되어 있지 않습니다.\n")
            }

            val data3 = pref.getBoolean("data3", false)
            if (data3 == true) {
                view.viewTv.append("스위치 켜져있습니다.\n")
            } else {
                view.viewTv.append("스위치 꺼져있습니다.\n")
            }

            val data4 = pref.getString("data4", null)
            view.viewTv.append("data4 : ${data4}\n")

            val data5 = pref.getStringSet("data5", null)
            for (str in data5!!) {
                view.viewTv.append("data5 : ${str}\n")
            }
        }

        return view
    }


}
