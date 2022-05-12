package com.example.imc_android_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val resultado = findViewById<TextView>(R.id.result)
        val infoResult = findViewById<TextView>(R.id.infoResult)
        val calcularNovamente = findViewById<Button>(R.id.calcularNovamente)
        val intent = intent
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        val imc = df.format(intent.getDoubleExtra("RESULT", 0.00)).toDouble()

        fun resultInfo(imc: Double) : String {
            return when {
                imc < 18.5 -> {
                    "Magreza"
                }
                imc in 18.5..24.9 -> {
                    "Normal"
                }
                imc in 25.0..29.9 -> {
                    "Sobrepeso"
                }
                imc in 30.0..39.9 -> {
                    "Obesidade"
                }
                else -> "Obesidade GRAVE"
            }
        }

        resultado.text = imc.toString()
        infoResult.text = resultInfo(imc)

        calcularNovamente.setOnClickListener {
            val intent2 = Intent(this@Resultado, MainActivity::class.java)
            startActivity(intent2)
        }
    }
}