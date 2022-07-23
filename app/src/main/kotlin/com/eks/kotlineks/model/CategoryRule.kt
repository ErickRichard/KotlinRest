package com.eks.kotlineks.model

import javax.persistence.*

@Entity
@Table(name = "tipo_cate_regr_cust")
class CategoryRule{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_TIPO_CATE_REGR_CUST_PONT")
    lateinit var categoryId: String

    @Column(name = "NOM_TIPO_CATE_REGR_CUST_PONT")
    lateinit var name: String

}