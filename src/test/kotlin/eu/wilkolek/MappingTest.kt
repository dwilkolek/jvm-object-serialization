package eu.wilkolek

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

abstract class AbstractMappingTest {
    abstract val mapper: ObjectMapper

    @Test
    fun `given Human mapper serialize and deserialize to equal object`() {
        val testCase = generate(5)
        Assertions.assertEquals(testCase, mapper.fromBytea(mapper.toBytea(testCase)))
    }

    @Test
    fun `given null mapper do roundup on nulls`() {
        Assertions.assertEquals(null, mapper.fromBytea(mapper.toBytea(null)))
    }
}