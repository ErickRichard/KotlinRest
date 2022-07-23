package com.eks.kotlineks.util

class Parameter <V> {
    private var nome: String? = null
    private var valor: V? = null

    fun getNome(): String? {
        return nome
    }

    fun setNome(nome: String?) {
        this.nome = nome
    }

    fun getValor(): V? {
        return valor
    }

    fun setValor(valor: V) {
        this.valor = valor
    }
}