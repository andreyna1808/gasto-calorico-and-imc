package com.example.gasto_calorico_and_imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnIMC: Button;
    private lateinit var btnCaloricLoss: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIMC = findViewById(R.id.btn_imc);
        btnIMC.setOnClickListener{
            val intent = Intent(this, IMCActivity::class.java);
            startActivity(intent)
        }

        btnCaloricLoss = findViewById(R.id.btn_caloric_loss);
        btnCaloricLoss.setOnClickListener{
            val intent = Intent(this, CaloricLossActivity::class.java);
            startActivity(intent)
        }

    }
}