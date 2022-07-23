package com.eks.kotlineks.unittests.mocks

import com.eks.kotlineks.data.vo.v1.request.RuleRequestVO
import com.eks.kotlineks.data.vo.v1.response.RuleResponseVO
import com.eks.kotlineks.model.Rule
import com.eks.kotlineks.unittests.utils.format.DateFormatTest
import java.math.BigDecimal
import java.util.*


class MockRule {
    fun mockEntity(): Rule {
        return mockEntity(0)
    }

    fun mockVO(): RuleRequestVO {
        return mockRequestVO(0)
    }

    fun mockResponseVO(): RuleResponseVO {
        return mockResponseVO(0)
    }

    fun mockEntityList(): ArrayList<Rule> {
        val rules: ArrayList<Rule> = ArrayList<Rule>()
        for (i in 0..1) {
            rules.add(mockEntity(i))
        }
        return rules
    }

    fun mockVOList(): ArrayList<RuleResponseVO> {
        val rules: ArrayList<RuleResponseVO> = ArrayList()
        for (i in 0..1) {
            rules.add(mockResponseVO(i))
        }
        return rules
    }

    fun mockEntity(number: Int): Rule {
        val rule = Rule()
        rule.ruleId = number.toLong()
        rule.name = "Name Test$number"
        rule.createBy = "CreateBy Test$number"
        rule.cpp = BigDecimal.TEN
        rule.dataCreation = DateFormatTest.formatDateObject(Date())
        rule.initialDate = DateFormatTest.createIniDateTest()
        rule.endDate = DateFormatTest.createEndDateTest()
        //rule.statusRule = Status.PENDING.value
        return rule
    }

    fun mockRequestVO(number: Int): RuleRequestVO {
        val rule = RuleRequestVO()
        rule.key = number.toLong()
        rule.name = "Name Test$number"
        rule.createBy = "CreateBy Test$number"
        rule.cpp = BigDecimal.TEN
        rule.initialDate = DateFormatTest.createIniDateTest()
        rule.endDate = DateFormatTest.createEndDateTest()
        return rule
    }

    private fun mockResponseVO(number: Int): RuleResponseVO {
        val rule = RuleResponseVO()
        rule.key = number.toLong()
        rule.name = "Name Test$number"
        rule.createBy = "CreateBy Test$number"
        rule.cpp = BigDecimal.TEN
        rule.initialDate = DateFormatTest.formatDateList("2022-07-14 20:21:00")
        rule.endDate = DateFormatTest.formatDateList("2022-07-14 20:21:00")
        return rule
    }

}