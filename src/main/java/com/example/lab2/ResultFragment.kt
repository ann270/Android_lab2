package com.example.lab2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        val textViewResult: TextView = view.findViewById(R.id.textViewResult)
        val btnCancel: Button = view.findViewById(R.id.btnCancel)

        val text = arguments?.getString("text") ?: ""
        val textSize = arguments?.getFloat("size") ?: 18f

        textViewResult.text = text
        textViewResult.textSize = textSize

        btnCancel.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }

    companion object {
        fun newInstance(text: String, size: Float): ResultFragment {
            val fragment = ResultFragment()
            val args = Bundle()
            args.putString("text", text)
            args.putFloat("size", size)
            fragment.arguments = args
            return fragment
        }
    }
}