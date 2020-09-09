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
            val nota1 = etNota1.text.toString().toInt()
            val nota2 = etNota2.text.toString().toInt()
            val mediaNecessaria = etMedia.text.toString().toInt()
            val mediaFinal = (nota1 + nota2) / 2

            val corReprovado = "#933d41"
            val corNaMedia = "#daa520"
            val corAprovado = "#2e8b57"

            val fraseReprovado = "Olá $nome, sua média foi $mediaFinal. Você está reprovado"
            val fraseNaMedia =
                "Olá $nome, sua média foi $mediaFinal. Você está aprovado, mas passou raspando!"
            val fraseAprovado =
                "Olá $nome, sua média foi $mediaFinal. Você está aprovado. Parabéns!"

            if (mediaNecessaria > 10 || nota1 > 10 || nota2 > 10) {
                Toast.makeText(this, "Apenas valores entre 0 e 10", Toast.LENGTH_SHORT).show()
                tvResultado.visibility = View.GONE
            } else {
                if (mediaFinal < mediaNecessaria) {
                    tvResultado.text = fraseReprovado
                    tvResultado.setTextColor(Color.parseColor(corReprovado))
                    tvResultado.visibility = View.VISIBLE
                } else if (mediaFinal == mediaNecessaria) {
                    if (mediaNecessaria == 10) {
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