package com.example.callbacks

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var switch: SwitchMaterial
    private lateinit var button: Button

    companion object {
        const val LOG_TAG = "MyActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initViews()
        addCallbacks()
    }

    private fun initViews() {
        editText = findViewById(R.id.edit_text)
        switch = findViewById(R.id.switch_)
        button = findViewById(R.id.button)
    }

    private fun addCallbacks() {
        switch.setOnCheckedChangeListener { _, isChecked ->
            Log.d(LOG_TAG, isChecked.toString())
            button.isEnabled = isChecked
        }
        editText.addTextChangedListener { text ->
            Log.d(LOG_TAG, text.toString())
        }
    }

}