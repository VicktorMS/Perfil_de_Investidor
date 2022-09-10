package br.pro.moraes.testedeperformace3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.pro.moraes.testedeperformace3.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupViews()
    }

    private fun setupViews() {
        val nome = intent.getStringExtra(NOME)
        val pontuacaoResultado = intent.getIntExtra(PONTUACAO_RESULTADO, 0)
        var perfil = ""
        if (pontuacaoResultado <= 14) {
            perfil = "Conservador"
        }
        else if (pontuacaoResultado <= 35){
            perfil = "Moderado"
        }
        else{
            perfil = "Arrojado"
        }

        binding.tvResultadoTexto.text = perfil
        binding.tvResultadoNome.text = "Investidor: ${nome}"
    }

    companion object{
        val NOME = "NOME"
        val PONTUACAO_RESULTADO = "PONTUACAO_RESULTADO"

        fun getIntent(context: Context, nome: String, pontuacaoResultado: Int): Intent{
            val newIntent = Intent(context, ResultadoActivity::class.java)
            newIntent.putExtra(NOME, nome)
            newIntent.putExtra(PONTUACAO_RESULTADO, pontuacaoResultado)
            return newIntent
        }
    }
}