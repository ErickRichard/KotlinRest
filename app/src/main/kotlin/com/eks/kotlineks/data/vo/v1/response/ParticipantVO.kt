package com.eks.kotlineks.data.vo.v1.response

data class ParticipantVO(
    //var nameComplete: String = "",
    //var CPF: String = "",
    //var birthDate: String = "",
    //var gender: String = "",
    //var id: String = "",
    //var sigla: String = "",
    //var nome: String = ""
    var nomeCompleto: String = "",
    var cpf: String = "",
    var dataNascimento: String = "",
    var genero: String = "",
    var rua: String = "",
    var numero: Int = 0,
    var bairro: String = "",
    var complemento: String = "",
    var cidade: String = "",
    var estado: String = "",
    var cep: String = "",
    var telefone: Int = 0,
    var email: String = "",
)