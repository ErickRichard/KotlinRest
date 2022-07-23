package com.eks.kotlineks.model

import javax.persistence.*

@Entity
@Table(name = "tipo_situ_regr_cust")
class StatusRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_TIPO_SITU_REGR_CUST_PONT")
    lateinit var statusId: String

    @Column(name = "NOM_TIPO_SITU_STAT_REGR_CUST")
    lateinit var name: String
}