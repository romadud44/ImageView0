package com.example.timecalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var firsOperandET: EditText
    private lateinit var secondOperandET: EditText
    private lateinit var buttonSumBTN: Button
    private lateinit var buttonSubBTN: Button
    private lateinit var resultTV: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        firsOperandET = findViewById(R.id.firstOperandET)
        secondOperandET = findViewById(R.id.secondOperandET)

        buttonSumBTN = findViewById(R.id.buttonSumBTN)
        buttonSubBTN = findViewById(R.id.buttonSubBTN)

        resultTV = findViewById(R.id.resultTV)

        buttonSumBTN.setOnClickListener(this)
        buttonSubBTN.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if(firsOperandET.text.isEmpty() || secondOperandET.text.isEmpty()){
            return
        }
        val first = stringToSeconds(firsOperandET.toString())
        val second = stringToSeconds(secondOperandET.toString())

        val result = when(v!!.id){
            R.id.buttonSumBTN -> Operation(first, second).sum()
            R.id.buttonSubBTN -> Operation(first, second).sub()
            else -> 0
        }
        resultTV.text = "${result / 60}m${result % 60}s"

    }

}
fun stringToSeconds(input:String): Int {
    val outMinutes = input.substringBefore('m').toInt()
    val outSeconds = input.substringBefore('s').substringAfterLast('m').toInt()
    val secondsSum = (outMinutes * 60) + outSeconds
    return secondsSum
}