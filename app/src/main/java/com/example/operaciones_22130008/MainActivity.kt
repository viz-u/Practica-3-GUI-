package com.example.operaciones_22130008

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lado1 = findViewById<EditText>(R.id.etNum1)
        val lado2 = findViewById<EditText>(R.id.etNum2)
        val lado3 = findViewById<EditText>(R.id.etNum3)
        val tipo = findViewById<TextView>(R.id.tvTipo)
        val verificar = findViewById<Button>(R.id.btnCalcular)

        verificar.setOnClickListener {
            val A = lado1.text.toString().toDoubleOrNull()
            val B = lado2.text.toString().toDoubleOrNull()
            val C = lado3.text.toString().toDoubleOrNull()

            if (A == null || B == null || C == null) {
                tipo.text = "Ingrese valores válidos"
                return@setOnClickListener
            }

            tipo.text = tipoTriangulo(A, B, C)
        }
    }
}

fun tipoTriangulo(a: Double, b: Double, c: Double): String {
    if (a <= 0 || b <= 0 || c <= 0) return "No es posible formar el triángulo."
    if (a + b <= c || a + c <= b || b + c <= a) return "No es posible formar el triángulo."

    return when {
        a == b && b == c -> "Es Equilátero"
        a == b || a == c || b == c -> "Es Isósceles"
        else -> "Es Escaleno"
    }
}
