package com.eks.kotlineks.model

import com.opencsv.bean.CsvBindByName
import com.opencsv.bean.CsvBindByPosition

data class SkuFile(
    @CsvBindByName(column = "Sku LTM")
    var skuLTM: String? = null,
    @CsvBindByName(column = "Sku Parceiro")
    var skuParceiro: String? = null,
    @CsvBindByName(column = "Id Parceiro")
    var parceiroId: String? = null
)

data class SkuFileWithCsvBindByPosition(
    @CsvBindByPosition(position = 1)
    var skuLTM: String? = null,
    @CsvBindByPosition(position = 2)
    var skuParceiro: String? = null,
    @CsvBindByPosition(position = 3)
    var parceiroId: String? = null
)