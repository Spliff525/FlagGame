package com.example.flaggame

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout

class MainFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        val etname = view.findViewById<AppCompatEditText>(R.id.et_name)
        val btn = view.findViewById<Button>(R.id.btn_start)
        val tilName = view.findViewById<TextInputLayout>(R.id.til_name)

        btn.setOnClickListener {
            if (etname.text.isNullOrEmpty()) {
                tilName.error = "Please enter your name"
            } else {
                val userName = bundleOf("user_name" to etname.text.toString())
                findNavController().navigate(R.id.action_mainFragment_to_quizQuestionsFragment, userName)
            }
        }
    }
}