package br.pro.moraes.testedeperformace3.questoesfragments.utils

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.nav(id: Int){
    this.findNavController().navigate(id)
}