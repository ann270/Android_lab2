package com.example.lab2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class InputFragment : Fragment() {

    private lateinit var editText: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var btnOk: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input, container, false)

        editText = view.findViewById(R.id.editText)
        radioGroup = view.findViewById(R.id.radioGroup)
        btnOk = view.findViewById(R.id.btnOk)

        btnOk.setOnClickListener {
            val text = editText.text.toString()
            if (text.isEmpty()) {
                Toast.makeText(requireContext(), "Введіть текст", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(requireContext(), "Оберіть розмір шрифту", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val size = when (selectedId) {
                R.id.radioSmall -> 14f
                R.id.radioMedium -> 18f
                R.id.radioLarge -> 24f
                else -> 18f
            }

            val resultFragment = ResultFragment.newInstance(text, size)

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, resultFragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}