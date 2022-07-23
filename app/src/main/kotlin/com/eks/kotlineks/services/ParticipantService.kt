package com.eks.kotlineks.services

import com.eks.kotlineks.data.vo.v1.response.ParticipantVO
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate


@Service
class ParticipantService {

    fun findParticipantData(cpf: String): List<ParticipantVO>? {
        //val url = "https://servicodados.ibge.gov.br/api/v1/localidades/regioes/"
        val url = "http://localhost:8080/api/portal/v1/list?cpf=$cpf"
        val restTemplate = RestTemplate()
        val json: String? = restTemplate.getForObject(url, String::class.java)
        val mapper = jacksonObjectMapper()
        val item: ParticipantVO = mapper.readValue(json, ParticipantVO::class.java)
        val listParticipantJson: MutableList<ParticipantVO> = arrayListOf()
        listParticipantJson.add(item)
        return listParticipantJson
    }

    fun findParticipantDataObject(cpf: String): List<ParticipantVO> {
        val listParticipantJson1: MutableList<ParticipantVO> = arrayListOf()
        val participantVO1 = ParticipantVO(
            nomeCompleto = "Erick Santos",
            cpf = "01810432200",
            dataNascimento = "08/09/1993",
            genero = "Não Informado",
            rua = "Rua Luiz Antônio de Oliveira Alves",
            numero = 242,
            bairro = "Vila Nova Mazzei",
            complemento = "Prox ao lado da rua",
            cidade = "São Paulo",
            estado = "SP",
            cep = "02314050",
            telefone = 999999999,
            email = "jeanluc1701@filevino.com"
        )
        listParticipantJson1.add(participantVO1)

        val listParticipantJson2: MutableList<ParticipantVO> = arrayListOf()
        val participantVO2 = ParticipantVO(
            nomeCompleto = "Erick Santos",
            cpf = "28071506087",
            dataNascimento = "08/09/1993",
            genero = "Não Informado",
            rua = "Rua Luiz Antônio de Oliveira Alves",
            numero = 242,
            bairro = "Vila Nova Mazzei",
            complemento = "Prox ao lado da rua",
            cidade = "São Paulo",
            estado = "SP",
            cep = "02314050",
            telefone = 999999999,
            email = "jeanluc1701@filevino.com"
        )
        listParticipantJson2.add(participantVO2)

        val listParticipantJsonG: MutableList<ParticipantVO> = arrayListOf()
        listParticipantJsonG.addAll(listParticipantJson1)
        listParticipantJsonG.addAll(listParticipantJson2)

        for (item in listParticipantJsonG) {
            if (cpf == "01810432200") {
                listParticipantJsonG.remove(item)
            }
        }

        return listParticipantJsonG
    }


}