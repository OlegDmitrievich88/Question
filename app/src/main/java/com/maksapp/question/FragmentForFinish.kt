package com.maksapp.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maksapp.question.databinding.FragmentResultQuestionBinding

class FragmentForFinish:Fragment() {

private lateinit var binding: FragmentResultQuestionBinding

    companion object{
        fun newInstance(bundle: Bundle): FragmentForFinish {
            val fragment = FragmentForFinish ()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultQuestionBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val quantityAnswer = arguments?.getInt("answer_key")
        with(binding){
            quantity.text = quantityAnswer.toString()
            back.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,FragmentForStart.newInstance())
                    .addToBackStack("")
                    .commit()
            }
        }

    }
}