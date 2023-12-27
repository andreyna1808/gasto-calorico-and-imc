package com.example.gasto_calorico_and_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner


class CaloricLossActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caloric_loss)

        val selectPhysicalActivity = findViewById<Spinner>(R.id.selectPhysicalActivity)
        val optionsPhysicalActivities = arrayOf("Leve", "Moderado", "Intenso")
        val adapter = ArrayAdapter(this, R.layout.spinner_item_layout, optionsPhysicalActivities)
        selectPhysicalActivity.adapter = adapter;
    }


}