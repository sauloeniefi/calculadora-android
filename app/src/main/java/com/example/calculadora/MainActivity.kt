package com.example.calculadora

import android.graphics.Color
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcular(componente: View) {

        if (etNome.text.isEmpty() || etNota1.text.isEmpty() || etNota2.text.isEmpty() || etMedia.text.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        } else {
            val nome = etNome.text.toString()
            val nota1: Double = etNota1.text.toString().toDouble()
            val nota2: Double = etNota2.text.toString().toDouble()
            val mediaNecessaria: Double = etMedia.text.toString().toDouble()
            val mediaFinal: Double = (nota1 + nota2) / 2.0

            val corReprovado = "#933d41"
            val corNaMedia = "#daa520"
            val corAprovado = "#2e8b57"

            val fraseReprovado =
                "Olá $nome, a média necessária é $mediaNecessaria, sua média foi ${String.format(
                    "%.2f",
                    mediaFinal
                )}. Você está reprovado. Que pena :("
            val fraseNaMedia =
                "Olá $nome, a média necessária é $mediaNecessaria, sua média foi ${String.format(
                    "%.2f",
                    mediaFinal
                )}. Você está aprovado, mas passou raspando! Estude mais."
            val fraseAprovado =
                "Olá $nome, a média necessária é $mediaNecessaria, sua média foi ${String.format(
                    "%.2f",
                    mediaFinal
                )}. Você está aprovado. Parabéns!"

            if (mediaNecessaria > 10 || nota1 > 10 || nota2 > 10) {
                Toast.makeText(this, "Apenas valores entre 0 e 10", Toast.LENGTH_SHORT).show()
                tvResultado.visibility = View.GONE
            } else {
                if (mediaFinal < mediaNecessaria) {
                    tvResultado.text = fraseReprovado
                    tvResultado.setTextColor(Color.parseColor(corReprovado))
                    tvResultado.visibility = View.VISIBLE
                } else if (mediaFinal == mediaNecessaria) {
                    if (mediaNecessaria == 10.0) {
                        tvResultado.text = fraseAprovado
                        tvResultado.setTextColor(Color.parseColor(corAprovado))
                        tvResultado.visibility = View.VISIBLE
                    } else {
                        tvResultado.text = fraseNaMedia
                        tvResultado.setTextColor(Color.parseColor(corNaMedia))
                        tvResultado.visibility = View.VISIBLE
                    }

                } else {
                    tvResultado.text = fraseAprovado
                    tvResultado.setTextColor(Color.parseColor(corAprovado))
                    tvResultado.visibility = View.VISIBLE
                }
            }
        }


    }
}