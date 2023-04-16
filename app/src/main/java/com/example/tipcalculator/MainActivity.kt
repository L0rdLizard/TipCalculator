package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.jvm.internal.Intrinsics.Kotlin

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        binding.calculateButton.setOnClickListener {
            calculateTip()
        }

    //    setContentView(R.layout.activity_main)
    }
    fun calculateTip() {
        val stringInputField = binding.costOfService.text.toString()
        val amount = stringInputField.toDouble()
        if (amount <= 0){
//            val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
//            binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
            binding.errorMessageZero.text = getString(R.string.error_message_zero)
        }
        val selectedTip = binding.tipOptions.checkedRadioButtonId
        val tipPercent = when (selectedTip) {
            R.id.tip_option_twenty_percent -> 0.2
            R.id.tip_option_eighteen_percent -> 0.18
            R.id.tip_option_fifteen_percent -> 0.15
            R.id.tip_option_five_percent -> 0.05
            else -> 0.0
        }
        var tip = amount * tipPercent
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}



