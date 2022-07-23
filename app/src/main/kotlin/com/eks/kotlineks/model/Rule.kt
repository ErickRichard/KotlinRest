package com.eks.kotlineks.model

import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "regr_cust_pont")
class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_REGR_CUST_PONT")
    var ruleId: Long = 0

    @Column(name = "NOM_REGR_CUST_PONT")
    var name: String = ""

    @Column(name = "NOM_ATR_REGR_CUST_PONT")
    var createBy: String = ""

    @Column(name = "DAT_HOR_CRIA_REGR_CUST_PONT")
    var dataCreation: Date? = null

    @Column(name = "VLR_CUST_PONT")
    var cpp: BigDecimal = BigDecimal.ZERO

    @Column(name = "NOM_APRD_REGR_CUST_PONT")
    var approvedBy: String? = null

    @Column(name = "DAT_HOR_APRV_REGR_CUST_PONT")
    var approvalDate: Date? = null

    @Column(name = "DAT_HOR_INI_VIG_CUST_PONT")
    var initialDate: Date? = null

    @Column(name = "DAT_HOR_FIM_VIG_CUST_PONT")
    var endDate: Date? = null

    @ManyToOne
    @JoinColumn(name = "COD_TIPO_SITU_REGR_CUST_PONT", referencedColumnName = "COD_TIPO_SITU_REGR_CUST_PONT")
    lateinit var statusRule: StatusRule

    @ManyToOne
    @JoinColumn(name = "COD_TIPO_CATE_REGR_CUST_PONT", referencedColumnName = "COD_TIPO_CATE_REGR_CUST_PONT")
    lateinit var categoryRule: CategoryRule

}

