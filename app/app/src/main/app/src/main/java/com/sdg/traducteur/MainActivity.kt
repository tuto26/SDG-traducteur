
package com.sdg.traducteur

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    private lateinit var input: EditText
    private lateinit var result: TextView
    private lateinit var source: android.widget.Spinner
    private lateinit var target: android.widget.Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 40, 32, 24)
            setBackgroundColor(Color.WHITE)
        }

        val title = TextView(this).apply {
            text = "SDG Traducteur"
            textSize = 26f
            setTextColor(Color.rgb(25, 90, 180))
            gravity = Gravity.CENTER
        }
        layout.addView(title)

        source = android.widget.Spinner(this)
        target = android.widget.Spinner(this)

        val languages = listOf("Français", "English", "中文")
        val adapter = android.widget.ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            languages
        )
        source.adapter = adapter
        target.adapter = adapter
        source.setSelection(0)
        target.setSelection(2)

        layout.addView(source)
        layout.addView(target)

        input = EditText(this).apply {
            hint = "Écris ou colle ton texte ici..."
            minLines = 4
            gravity = Gravity.TOP
        }
        layout.addView(
            input,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        val button = Button(this).apply {
            text = "Traduire"
        }
        layout.addView(button)

        result = TextView(this).apply {
            text = "La traduction apparaîtra ici."
            textSize = 18f
            setTextColor(Color.DKGRAY)
            setPadding(0, 24, 0, 0)
        }
        layout.addView(result)

        button.setOnClickListener {
            result.text =
                "Interface prête. Le moteur de traduction sera ajouté à l'étape suivante."
        }

        setContentView(layout)
    }
}
