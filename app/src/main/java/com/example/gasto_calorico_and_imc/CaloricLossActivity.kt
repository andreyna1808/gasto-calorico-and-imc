package com.example.gasto_calorico_and_imc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView


class CaloricLossActivity : AppCompatActivity() {

    private lateinit var editAge: EditText
    private lateinit var editWeight: EditText
    private lateinit var textResult: TextView

    var selectedActivity = ""
    var gender = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caloric_loss)

        editAge = findViewById(R.id.value_age)
        editWeight = findViewById(R.id.value_weight_caloric)
        textResult = findViewById(R.id.result_caloric_loss)

        val selectPhysicalActivity = findViewById<Spinner>(R.id.selectPhysicalActivity)
        val optionsPhysicalActivities = arrayOf("Leve", "Moderado", "Intenso")
        val adapter = ArrayAdapter(this, R.layout.spinner_item_layout, optionsPhysicalActivities)
        selectPhysicalActivity.adapter = adapter;

        selectPhysicalActivity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                selectedActivity = optionsPhysicalActivities[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }

    fun selectedMan(view: View) {
        val imgMan: ImageView = findViewById(R.id.select_man)
        val imgWoman: ImageView = findViewById(R.id.select_woman)

        imgMan.setImageResource(R.drawable.selected_man)
        imgWoman.setImageResource(R.drawable.woman)
        gender = "man"
    }

    fun selectedWoman(view: View) {
        val imgMan: ImageView = findViewById(R.id.select_man)
        val imgWoman: ImageView = findViewById(R.id.select_woman)

        imgMan.setImageResource(R.drawable.man)
        imgWoman.setImageResource(R.drawable.selected_woman)
        gender = "woman"
    }

    private fun basalEnergetic(age: Int, gender: String, weight: Double): Double {
        // man
        if (age in 1..2 && gender == "man") {
            return (59.512 / 1000 * weight) - (304 / 10)

        } else if (age in 3..9 && gender == "man") {
            return (22706 / 1000 * weight) + (5043 / 10)
        }
        else if (age in 10..17 && gender == "man") {
            return (17686 / 1000 * weight) + (6582 / 10)
        }
        else if (age in 18..30 && gender == "man") {
            return (15057 / 1000 * weight) + (69224 / 100)
        }
        else if (age in 31..60 && gender == "man") {
            return (11472 / 1000  * weight) + (8731 / 10)
        }
        else if (age > 60 && gender == "man") {
            return (11711 / 1000 * weight) + (5877 / 10)
        }

        // woman
        else if (age in 1..2 && gender == "woman") {
            return (58317 / 1000 * weight) - (311 / 10)

        } else if (age in 3..9 && gender == "woman") {
            return (20315 / 1000 * weight) + (4859 / 10)

        }
        else if (age in 10..17 && gender == "woman") {
            return (13384 / 1000 * weight) + (6926 / 10)

        }
        else if (age in 18..30 && gender == "woman") {
            return (14818 / 1000 * weight) + (4866 / 10)

        }
        else if (age in 31..60 && gender == "woman") {
            return (8126 / 1000 * weight) + (8456 / 10)

        }
        else if (age > 60 && gender == "woman") {
            return (9082 / 1000  * weight) + (6585 / 10)

        } else {
            return 0.0
        }
    }

    private fun activityFactor(basalValue: Double): Double {
        if (selectedActivity == "Leve") {
            return basalValue * 1.55
        } else if (selectedActivity == "Moderado") {
            return basalValue * 1.84
        } else {
            return basalValue * 2.2
        }
    }

    fun calculateCaloricLoss(view: View) {
        val age = editAge.text.toString().toIntOrNull() ?: 0
        val weight = editWeight.text.toString().toDoubleOrNull() ?: 0.0

        val resultBasalEnergetic = basalEnergetic(age, gender, weight)
        val resultActivityFactor = activityFactor(resultBasalEnergetic)

        textResult.text = "Seu gasto calórico estimado é: ${resultActivityFactor.toInt()}kcal por dia"
        textResult.setTextColor(Color.parseColor("#0000FF"));
    }
}