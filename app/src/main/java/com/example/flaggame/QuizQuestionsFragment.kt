package com.example.flaggame

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup

class QuizQuestionsFragment : Fragment(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0

    private lateinit var progressBar: ProgressBar
    private lateinit var tv_progress: TextView
    private lateinit var tv_question: TextView
    private lateinit var tv_option_one: MaterialButton
    private lateinit var tv_option_two: MaterialButton
    private lateinit var tv_option_three: MaterialButton
    private lateinit var tv_option_four: MaterialButton
    private lateinit var iv_image: ImageView

    private lateinit var btn_submit: Button

    private lateinit var mbtg: MaterialButtonToggleGroup

    val idToAnswer = mapOf(1 to R.id.tv_option_one, 2 to R.id.tv_option_two, 3 to R.id.tv_option_three, 4 to R.id.tv_option_four)
    val args: QuizQuestionsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_quiz_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_progress = view.findViewById(R.id.tv_progress)
        tv_question = view.findViewById(R.id.tv_question)
        tv_option_one = view.findViewById(R.id.tv_option_one)
        tv_option_two = view.findViewById(R.id.tv_option_two)
        tv_option_three = view.findViewById(R.id.tv_option_three)
        tv_option_four = view.findViewById(R.id.tv_option_four)
        iv_image = view.findViewById(R.id.iv_image)
        btn_submit = view.findViewById<Button>(R.id.btn_submit)
        progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        mbtg = view.findViewById(R.id.mtg_select_flag)

        progressBar.max = Constants.questionsList.size

        setQuestion()


        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    private fun setQuestion() {
        val question = Constants.questionsList!![mCurrentPosition - 1]


        defaultOptionsView()


        if (mCurrentPosition == Constants.questionsList!!.size) {
            btn_submit.text = "FINISH"
        } else {
            btn_submit.text = "SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition/${progressBar.max}"

        tv_question.text = question.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }


    private fun defaultOptionsView() {
//        val options = ArrayList<TextView>()
//        options.add(0, tv_option_one)
//        options.add(1, tv_option_two)
//        options.add(2, tv_option_three)
//        options.add(3, tv_option_four)
//
//
//
//        for (option in options) {
//
//
//            option.setTextColor(Color.parseColor("#7A8089"))
//            option.typeface = Typeface.DEFAULT
//            option.background = ContextCompat.getDrawable(requireContext(), R.drawable.default_option_border_bg)
//        }

        mbtg.clearChecked()

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }

            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }

            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }

            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }

            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= Constants.questionsList.size -> {
                            mbtg.children.forEach {
                                (it as MaterialButton).invalidate()
                            }
                            setQuestion()
                        }

                        else -> {
                            val userScore = getString(R.string.user_score, mCorrectAnswers, Constants.questionsList.size)
                            val resultData = ResultData (
                                args.userName,
                                userScore
                            )

                            val bundle = bundleOf("resultData" to resultData)
                            findNavController().navigate(R.id.action_quizQuestionsFragment_to_resultActivity, bundle)
                Toast.makeText(requireActivity(), "You have successfully completed the Quiz", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    val question = Constants.questionsList.get(mCurrentPosition - 1)
                    if (question.correctAnswer == mSelectedOptionPosition) {
                        mCorrectAnswers++
                    }

                    answerView(question.correctAnswer)


                    if (mCurrentPosition == Constants.questionsList!!.size) {
                        btn_submit.text = "FINISH"
                    } else {

                        btn_submit.text = "GO TO THE NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }

            }

        }
    }


    private fun answerView(answer: Int) {

        val id = idToAnswer[answer]
        if(id == mbtg.checkedButtonId) {
            mbtg.findViewById<MaterialButton>(mbtg.checkedButtonId)
                .setBackgroundColor(Color.GREEN)
        } else {
            mbtg.findViewById<MaterialButton>(mbtg.checkedButtonId).setBackgroundColor(Color.RED)
            id?.let {
                mbtg.findViewById<MaterialButton>(id).setBackgroundColor(Color.GREEN)
            }
        }
//        if (id == mbtg.checkedButtonId) {
//            mbtg.findViewById<MaterialButton>(id).setBackgroundColor(Color.GREEN)
//        }
//        mbtg.children.forEach {
//            if(id != it.id  && id == mbtg.checkedButtonId){
//                (it as MaterialButton).setBackgroundColor(Color.RED)
//            }
//        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

//        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum


//        tv.setTextColor(Color.parseColor("#363A43"))
//        tv.setTypeface(tv.typeface, Typeface.BOLD)
//        tv.background = ContextCompat.getDrawable(requireContext(), R.drawable.selected_option_border_bg)


    }


}
