package com.maksapp.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.maksapp.question.databinding.FragmentForQuestionBinding
import kotlinx.android.synthetic.main.fragment_for_question.*

class FragmentQuestion:Fragment() {
    private var numberquestions = 0
    private val questions: List<Question> = getQuestion()
    private val correctAnswer = listOf(2,4,2,1,1,2,3,2,3,1)
    private var finish = 0
    private lateinit var binding: FragmentForQuestionBinding
    companion object{
        fun newInstance() = FragmentQuestion()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForQuestionBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        render()

        binding.accept.setOnClickListener {

            try {
                val answer:Int = number_answer.text.toString().toInt()
                number_answer.text.clear()
                renderQuestion(answer)
            }catch (e:Exception){
                Toast.makeText(context,"Введите номер ответа",Toast.LENGTH_SHORT).show()}
        }


    }

    private fun render() {
        with(binding) {
            question.text = questions[numberquestions].question
            answerOne.text = questions[numberquestions].one_answer
            answerTwo.text = questions[numberquestions].two_answer
            answerThree.text = questions[numberquestions].three_answer
            answerFore.text = questions[numberquestions].fore_answer
        }
    }


    private fun renderQuestion(answer: Int) = with(binding) {

            if (answer==correctAnswer[numberquestions]){
                numberquestions++
                finish++
                render()
            }else{
                numberquestions++
                render()
            }
        when (numberquestions) {
            10 ->startQualityAnswer()
            else -> {}
        }

    }



    private fun startQualityAnswer(): Int {
        val bundle = Bundle().apply { putInt("answer_key", finish) }
        return requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FragmentForFinish.newInstance(bundle))
            .addToBackStack("")
            .commit()
    }
}





