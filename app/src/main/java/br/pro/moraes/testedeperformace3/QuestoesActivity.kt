package br.pro.moraes.testedeperformace3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.pro.moraes.testedeperformace3.databinding.ActivityQuestoesBinding
import br.pro.moraes.testedeperformace3.interfaces.FragmentAnswerListener

class QuestoesActivity : AppCompatActivity(), FragmentAnswerListener {

    private lateinit var binding: ActivityQuestoesBinding

    var nome = ""

    var pontuacao = 0
    var contador_questoes= 0
    // Lista de Pontuação serve para saber quanto foi pontuado em cada quest


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestoesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setup()
    }
    private fun setup() {
        setupViews()
    }


    override fun onSendAnswer(value: Int) {
        pontuacao += value
        contador_questoes ++
        Log.i("Pontuação:", "${pontuacao}" )

        if(contador_questoes < 9){
            binding.tvTituloQuestoes.text = "Questão                   ${contador_questoes + 1}/9"
        }
        else{
            finalizarSimulado()
        }
    }

    private fun finalizarSimulado() {
        var pontuacaoResultado = pontuacao

        val intent = ResultadoActivity.getIntent(this, nome, pontuacaoResultado)
        startActivity(intent)

    }


    private fun setupViews() {
        nome = intent.getStringExtra(NOME) ?: "Nome não preenchido"
        binding.tvNomeQuestoes.text = "Investidor:  ${nome}"
    }

    companion object {
        val NOME = "Nome"

        fun getIntent(context: Context, nome: String): Intent {
            val newIntent = Intent(context, QuestoesActivity::class.java)
            newIntent.putExtra(NOME, nome)
            return newIntent
        }
    }


}