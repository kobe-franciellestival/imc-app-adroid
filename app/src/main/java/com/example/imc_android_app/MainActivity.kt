package com.example.imc_android_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    var height = 150.0
    var weight = 50.0
    var imcRes = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonRes = findViewById<Button>(R.id.calcularIMC)
        var addHeight = findViewById<Button>(R.id.addHeight)
        var dimHeight = findViewById<Button>(R.id.dimHeight)
        var addWeight = findViewById<Button>(R.id.addWeight)
        var dimWeight = findViewById<Button>(R.id.dimWeight)
        var heightValue = findViewById<TextView>(R.id.height)
        var weightValue = findViewById<TextView>(R.id.weight)

        buttonRes.setOnClickListener {
            imcRes = weight / (height/100).pow(2.0)
            val intent = Intent(this@MainActivity, Resultado::class.java)

            intent.putExtra("RESULT", imcRes)
            startActivity(intent)
        }

        addHeight.setOnClickListener {
            height += 1
            heightValue.text = height.toString()
        }

        dimHeight.setOnClickListener {
            height -= 1
            heightValue.text = height.toString()
        }

        addWeight.setOnClickListener {
            weight += 1
            weightValue.text = weight.toString()
        }

        dimWeight.setOnClickListener {
            weight -= 1
            weightValue.text = weight.toString()
        }
    }

}