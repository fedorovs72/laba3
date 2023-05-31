package com.example.a3laba

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        number_btn0 = findViewById(R.id.button0)
        number_btn1 = findViewById(R.id.button1)
        number_btn2 = findViewById(R.id.button2)
        number_btn3 = findViewById(R.id.button3)
        number_btn4 = findViewById(R.id.button4)
        number_btn5 = findViewById(R.id.button5)
        number_btn6 = findViewById(R.id.button6)
        number_btn7 = findViewById(R.id.button7)
        number_btn8 = findViewById(R.id.button8)
        number_btn9 = findViewById(R.id.button9)

        clear_btn = findViewById(R.id.button16)
        resultText = findViewById(R.id.textView)
        result_btn = findViewById(R.id.button23)
        point_btn = findViewById(R.id.button15)
        signChange_btn = findViewById(R.id.button17)

        division_btn = findViewById(R.id.division)
        multiplicate_btn = findViewById(R.id.multiplicate)
        plus_btn = findViewById(R.id.plus)
        minus_btn = findViewById(R.id.minus)

        clear_btn?.setOnClickListener{
            firstNumberLength = 0
            resultText?.hint = "0"
            resultText?.text = ""
            number = ""
            delimiter = ""
            numbers = arrayOf(0.0, 0.0)
        }
        result_btn?.setOnClickListener{
            try{
                resultText?.hint = ""
                val num: Array<Double> = setArray(resultText?.text.toString(),delimiter)
                resultText?.text = ""
                if(delimiter == "/"){
                    if(num[1] == 0.0)   resultText?.hint = "Нельзя"
                    else                result = (num[0] / num[1]).toString()
                }
                if(delimiter == "*")    result = (num[0] * num[1]).toString()
                if(delimiter == "-")    result = (num[0] - num[1]).toString()
                if(delimiter == "+")    result = (num[0] + num[1]).toString()

                firstNumberLength = 0

                delimiter = ""
                if(resultText?.hint != "Нельзя")
                    resultText?.text = intFormat(result.toDouble()).toString()
                number =  resultText?.text.toString()
                result = "0"
                numbers = arrayOf(0.0, 0.0)
            }
            catch (e : Exception){

            }

        }
        division_btn?.setOnClickListener{
            delimiter = delimiterTextView("/")
        }
        multiplicate_btn?.setOnClickListener{
            delimiter = delimiterTextView("*")
        }
        plus_btn?.setOnClickListener{
            delimiter = delimiterTextView("+")
        }
        minus_btn?.setOnClickListener{
            delimiter = delimiterTextView("-")
        }

        point_btn?.setOnClickListener{
            point = pointTextView(point)
        }
        signChange_btn?.setOnClickListener{

            if(delimiter == ""){
                if("-" !in resultText?.text.toString())
                    resultText?.text = "-"+ resultText?.text.toString()
                else resultText?.text = resultText?.text.toString().replace("-","")
            }
            else{
                if(delimiter + "-" !in resultText?.text.toString() && delimiter != "-")
                    resultText?.text = resultText?.text.toString().replace(delimiter,delimiter+"-")
                else
                    resultText?.text = resultText?.text.toString().replace(delimiter+"-",delimiter)
            }

        }
        number_btn0?.setOnClickListener{number += "0"
            resultText?.text = resultText?.text.toString() + number.last()
        }
        number_btn1?.setOnClickListener{number += "1"
            resultText?.text = resultText?.text.toString() + number.last()
        }
        number_btn2?.setOnClickListener{number += "2"
            resultText?.text = resultText?.text.toString() + number.last()
        }
        number_btn3?.setOnClickListener{number += "3"
            resultText?.text = resultText?.text.toString() + number.last()
        }
        number_btn4?.setOnClickListener{number += "4"
            resultText?.text = resultText?.text.toString() + number.last()
        }
        number_btn5?.setOnClickListener{number += "5"
            resultText?.text = resultText?.text.toString() + number.last()
        }
        number_btn6?.setOnClickListener{number += "6"
            resultText?.text = resultText?.text.toString() + number.last()
        }
        number_btn7?.setOnClickListener{number += "7"
            resultText?.text = resultText?.text.toString() + number.last()
        }
        number_btn8?.setOnClickListener{number += "8"
            resultText?.text = resultText?.text.toString() + number.last()
        }
        number_btn9?.setOnClickListener{number += "9"
            resultText?.text = resultText?.text.toString() + number.last()
        }
    }
    private var delimiter : String = ""
    private var point : String = "."
    private fun setArray(x : String, split: String): Array<Double> {
        if(x[0] == '-'){
            var parts = x.substring(1).split(split)
            numbers[0] = -parts[0].toDouble()
            numbers[1] = parts[1].toDouble()
        }
        else{
            var parts = x.split(split)
            numbers[0] = parts[0].toDouble()
            numbers[1] = parts[1].toDouble()
        }
        return numbers
    }
    private fun pointTextView(point: String): String{
        if (point !in number){
            resultText?.text = resultText?.text.toString() + point
            number += point
        }
        return point
    }
    private fun delimiterTextView(delimiter: String): String{
        if (resultText?.text.toString() != "" && delimiter !in resultText?.text.toString().substring(1)){
            if("-" in resultText?.text.toString())  firstNumberLength = 1 + resultText?.text.toString().length
            else                                    firstNumberLength = resultText?.text.toString().length
            resultText?.text = resultText?.text.toString() + delimiter
            number = ""
        }
        return delimiter
    }
    fun intFormat(x : Double): Any {
        if(x == x.roundToInt().toDouble())
            return  x.roundToInt()
        else
            return x
    }
    private var firstNumberLength: Int = 0;
    private var number: String = ""
    private var firstNum: Double = 0.0
    private var secondNum: Double = 0.0
    private var numbers: Array<Double> = arrayOf(0.0, 0.0)

    private var resultText: TextView? = null
    private var result_btn: Button? = null

    private var point_btn: Button? = null
    private var signChange_btn: Button? = null
    private var division_btn: Button? = null
    private var multiplicate_btn: Button? = null
    private var minus_btn: Button? = null
    private var plus_btn: Button? = null

    private var number_btn0: Button? = null
    private var number_btn1: Button? = null
    private var number_btn2: Button? = null
    private var number_btn3: Button? = null
    private var number_btn4: Button? = null
    private var number_btn5: Button? = null
    private var number_btn6: Button? = null
    private var number_btn7: Button? = null
    private var number_btn8: Button? = null
    private var number_btn9: Button? = null
    private var clear_btn: Button? = null

    private var result = ""
}