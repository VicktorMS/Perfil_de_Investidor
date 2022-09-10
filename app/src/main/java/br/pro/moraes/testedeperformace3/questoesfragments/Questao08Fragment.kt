package br.pro.moraes.testedeperformace3.questoesfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.pro.moraes.testedeperformace3.R
import br.pro.moraes.testedeperformace3.databinding.FragmentQuestao08Binding
import br.pro.moraes.testedeperformace3.interfaces.FragmentAnswerListener
import br.pro.moraes.testedeperformace3.questoesfragments.utils.nav


class Questao08Fragment : Fragment() {

    private var _binding: FragmentQuestao08Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestao08Binding.inflate(inflater,container, false)
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
        binding.btnConfirmarQuestao08.setOnClickListener{
            val resposta = respostaSelecionada()
            if(resposta != -1){
                listener.onSendAnswer(resposta)
                nav(R.id.action_questao08Fragment_to_questao09Fragment)
            }
        }
    }

    private fun respostaSelecionada(): Int {
        if (binding.rgQuestao08.checkedRadioButtonId == -1) {
            return -1
        } else {
            when (binding.rgQuestao08.checkedRadioButtonId) {
                R.id.rba_alternativa08 -> return 0
                R.id.rbb_alternativa08 -> return 1
                R.id.rbc_alternativa08 -> return 2
                R.id.rbd_alternativa08 -> return 4
            }
        }
        return -1
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}