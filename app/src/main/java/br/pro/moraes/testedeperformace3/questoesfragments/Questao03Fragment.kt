package br.pro.moraes.testedeperformace3.questoesfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.pro.moraes.testedeperformace3.R
import br.pro.moraes.testedeperformace3.databinding.FragmentQuestao03Binding
import br.pro.moraes.testedeperformace3.interfaces.FragmentAnswerListener


class Questao03Fragment : Fragment() {

    private var _binding: FragmentQuestao03Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestao03Binding.inflate(inflater,container, false)
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
        binding.btnConfirmarQuestao03.setOnClickListener{
            val resposta = respostaSelecionada()
            if(resposta != -1){
                listener.onSendAnswer(resposta)
            }
        }
    }

    private fun respostaSelecionada(): Int {
        if (binding.rgQuestao03.checkedRadioButtonId == -1) {
            return -1
        } else {
            when (binding.rgQuestao03.checkedRadioButtonId) {
                R.id.rba_alternativa03 -> return 0
                R.id.rbb_alternativa03 -> return 2
                R.id.rbc_alternativa03 -> return 4
                R.id.rbd_alternativa03 -> return 5
            }
        }
        return -1
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}