package eu.wilkolek

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class JavaObjectMapperTest {
    private val mapper = JavaObjectMapper()

    @Test
    fun mapperMaps() {
        val testCase = generate(1)
        assertEquals(testCase, mapper.fromBytea(mapper.toBytea(testCase)))
    }

}