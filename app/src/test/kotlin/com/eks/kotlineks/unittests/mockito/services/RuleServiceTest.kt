package com.eks.kotlineks.unittests.mockito.services

import com.eks.kotlineks.repository.RuleRepository
import com.eks.kotlineks.services.RuleService
import com.eks.kotlineks.unittests.mocks.MockRule
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class RuleServiceTest {

    private lateinit var inputObject: MockRule

    @InjectMocks
    private lateinit var service: RuleService

    @Mock
    private lateinit var repository: RuleRepository

    @BeforeEach
    fun setUpMock() {
        inputObject = MockRule()
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun createNewRuleTestPending() {
    //    val entity = inputObject.mockEntity(1)
    //    val persisted = entity.copy()
    //    persisted.ruleId = 1
    //    `when`(repository.save(entity)).thenReturn(persisted)
    //    val vo = inputObject.mockRequestVO(1)
    //    val result = service.createNewRule(vo)
    //    Assertions.assertNotNull(result)
    //    Assertions.assertNotNull(result.key)
    //    Assertions.assertNotNull(result.links)
    //   Assertions.assertEquals("Name Test1", result.name)
    //   Assertions.assertEquals("CreateBy Test1", result.createBy)
    //   Assertions.assertEquals(BigDecimal.TEN, result.cpp)
    //   Assertions.assertEquals(DateFormatTest.createIniDateTest(), result.initialDate)
    //  Assertions.assertEquals(DateFormatTest.createEndDateTest(), result.endDate)
    //  Assertions.assertEquals(Status.PENDING.value, persisted.status)
    //   assertTrue(result.links.toString().contains("</api/cpp/v1/1>;rel=\"self\""))
    }
}