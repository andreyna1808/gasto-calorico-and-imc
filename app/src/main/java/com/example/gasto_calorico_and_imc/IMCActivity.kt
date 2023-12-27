package com.example.gasto_calorico_and_imc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class IMCActivity : AppCompatActivity() {

    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_activity)

        editWeight = findViewById(R.id.value_weight)
        editHeight = findViewById(R.id.value_height)
        textResult = findViewById(R.id.result_imc)
    }

    fun calculateIMC(view: View) {
        val weight = editWeight.text.toString().toDoubleOrNull() ?: 0.0
        val height = editHeight.text.toString().toDoubleOrNull() ?: 0.0

        val imc = weight / (height * height)

        val result = when {
            imc < 18.5 -> "O resultado do seu IMC: Baixo"
            imc in 18.5..24.9 -> "O resultado do seu IMC: Normal"
            imc in 25.0..29.9 -> "O resultado do seu IMC: Sobrepeso"
            imc > 29.9 -> "O resultado do seu IMC: Obeso"
            else -> "Error! Verifique novamente os valores informados"
        }

        textResult.text = result
        textResult.setTextColor(Color.parseColor("#0000FF"));
    }
}