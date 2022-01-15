package com.maksapp.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maksapp.question.databinding.FragmentStartBinding

class FragmentForStart: Fragment() {

    private lateinit var binding: FragmentStartBinding

    companion object{
        fun newInstance() = FragmentForStart()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonStart.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,FragmentQuestion.newInstance())
                .addToBackStack("")
                .commit()
        }
    }
}