package com.example.fragment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class GenericFragment : Fragment() {
    private var backgroundColor: Int = 0
    private var title: String = ""

    companion object{

        private const val FRAGMENT_COLOR = "FRAGMENT_COLOR"
        private const val FRAGMENT_TITLE = "FRAGMENT_TITLE"

        fun newInstance(color: Int, data: String): GenericFragment{

            val args = Bundle()

            args.putInt(FRAGMENT_COLOR, color)
            args.putString(FRAGMENT_TITLE, data)

            val fragment = GenericFragment()

            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if(bundle != null){
            if(bundle.containsKey(FRAGMENT_TITLE)){
                title = bundle.getString(FRAGMENT_TITLE).toString()
            }
            if(bundle.containsKey(FRAGMENT_COLOR)){
                backgroundColor = bundle.getInt(FRAGMENT_COLOR)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_generic, container, false)

        val relative = view.findViewById(R.id.relative) as RelativeLayout
        val text = view.findViewById(R.id.text) as TextView

        relative.setBackgroundColor(backgroundColor)
        text.text = title

        return view
    }


}