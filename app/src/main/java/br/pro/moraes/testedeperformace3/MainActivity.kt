package br.pro.moraes.testedeperformace3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.pro.moraes.testedeperformace3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setup()
    }

    private fun setup() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnStart.setOnClickListener{
            val nome = binding.inputName.text.toString()
            val tamanho_nome = nome.length
            if(tamanho_nome != 0 && tamanho_nome < 26) {
                val intent = QuestoesActivity.getIntent(this, nome)
                Log.i("porra","${tamanho_nome}")
                startActivity(intent)
            }
            else{
                Toast.makeText(applicationContext,"Nome Inválido, Insira novamente",Toast.LENGTH_SHORT).show()
            }
        }
    }
}