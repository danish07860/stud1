package com.example.stud1

import android.graphics.Color
import android.graphics.Color.GREEN
import android.graphics.Color.green
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        assignNumbersToButtons()
        btnLeft.setOnClickListener {
            checkAnswer(true)
            assignNumbersToButtons()
        }
        btnRight.setOnClickListener {
            checkAnswer(false)
            assignNumbersToButtons()
        }


    }
    private fun checkAnswer( isLeftButtonSelected: Boolean)
    {
        val leftNum= btnLeft.text.toString().toInt()
            val rightNum=btnRight.text.toString().toInt()
        val isAnswerCorrect=if (isLeftButtonSelected) leftNum>rightNum else rightNum>leftNum
            if (isAnswerCorrect)
            {
                backgroundView.setBackgroundColor(Color.GREEN)
                Toast.makeText(this,"correct",Toast.LENGTH_SHORT).show()
            }else{
                backgroundView.setBackgroundColor(Color.RED)
                Toast.makeText(this,"incorrect",Toast.LENGTH_SHORT).show()
            }
    }

    private fun assignNumbersToButtons() {
        var r=Random()
        val leflNum=r.nextInt(10)

        var rightNum=leflNum
        while (rightNum==leflNum){
            rightNum=r.nextInt(10)
        }
        btnLeft.text=leflNum.toString()
        btnRight.text=rightNum.toString()
    }
}