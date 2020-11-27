package com.webtrekk.example.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.webtrekk.example.R
import com.webtrekk.example.utils.MappSharedPrefs
import webtrekk.android.sdk.Webtrekk


/**
 * The sole purpose of this fragment is to request permissions and, once granted, display the
 * camera fragment to the user.
 */
class SettingsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        val trackingId = view.findViewById<EditText>(R.id.trackingId)
        val trackingDomain = view.findViewById<EditText>(R.id.trackingDomain)
        trackingId.setText(MappSharedPrefs(activity!!.applicationContext).trackingId)
        trackingDomain.setText(MappSharedPrefs(activity!!.applicationContext).trackingDomain)

        view.findViewById<Button>(R.id.button).setOnClickListener {
            context?.let { it1 ->
                MappSharedPrefs(it1).trackingDomain = trackingDomain.text.toString()
            }
            context?.let { it1 -> MappSharedPrefs(it1).trackingId = trackingId.text.toString() }
            Webtrekk.getInstance()
                .setIdsAndDomain(listOf(trackingId.text.toString()), trackingDomain.text.toString())

            Toast.makeText(context, "Settings changed", Toast.LENGTH_SHORT).show()
        }

        return view
    }

}
