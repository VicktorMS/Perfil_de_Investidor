package br.pro.moraes.testedeperformace3.questoesfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.pro.moraes.testedeperformace3.R
import br.pro.moraes.testedeperformace3.databinding.FragmentQuestao04Binding
import br.pro.moraes.testedeperformace3.interfaces.FragmentAnswerListener
import br.pro.moraes.testedeperformace3.questoesfragments.utils.nav


class Questao04Fragment : Fragment() {

    private var _binding: FragmentQuestao04Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestao04Binding.inflate(inflater,container, false)
        val view = binding.root

        setupClickListeners()

        return view
    }

    private lateinit var listener: FragmentAnswerListener
    override fun onAttach(context: Context) {
        if (context is FragmentAnswerListener){
            listener = context
        }
        super.onAttach(context)
    }

    private fun setupClickListeners() {
        binding.btnConfirmarQuestao04.setOnClickListener{
            val resposta = respostaSelecionada()
            if(resposta != -1){
                listener.onSendAnswer(resposta)
                nav(R.id.action_questao04Fragment_to_questao05Fragment)
            }
        }
    }

    private fun respostaSelecionada(): Int {
        if (binding.rgQuestao04.checkedRadioButtonId == -1) {
            return -1
        } else {
            when (binding.rgQuestao04.checkedRadioButtonId) {
                R.id.rba_alternativa04 -> return 0
                R.id.rbb_alternativa04 -> return 2
                R.id.rbc_alternativa04 -> return 4
            }
        }
        return -1
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}