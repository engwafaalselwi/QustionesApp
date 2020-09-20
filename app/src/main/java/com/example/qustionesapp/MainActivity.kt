package com.example.qustionesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton :Button
    private lateinit var questionTextView : TextView




    private val questionBank = listOf(
        Question(R.string.question_africa,true),
        Question(R.string.question_americas,false),
        Question(R.string.question_oceans,true),
        Question(R.string.question_mideast,false),
        Question(R.string.question_asia,true))
    private var currentIndex = 0






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton=findViewById(R.id.flase_button)
        nextButton=findViewById(R.id.next_button)
        questionTextView=findViewById(R.id.question_text_view)


        trueButton.setOnClickListener {

          checkAnswer(true)

        }

        falseButton.setOnClickListener {
            checkAnswer(false)

        }

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
           updateQusetion()

        }

        updateQusetion()

    }
    private fun updateQusetion (){
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer :Boolean){
        val correctAnswer = questionBank[currentIndex].answer
       var messageResId =  if(userAnswer==correctAnswer){
            R.string.correct_toast
        }else{
            R.string.incorrect_toast
        }
         var toast= Toast.makeText(this,messageResId,Toast.LENGTH_LONG)
             toast.setGravity(Gravity.TOP,0,0)
        toast.show()

    }
}