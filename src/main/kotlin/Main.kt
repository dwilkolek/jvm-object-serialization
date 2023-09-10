import java.lang.IllegalStateException
import kotlin.system.measureTimeMillis

val javaObjectMapper = JavaObjectMapper()
val kryoObjectMapper = KryoObjectMapper()
val mappers = listOf(javaObjectMapper, kryoObjectMapper)

const val loops = 1000
const val pad = 20
val childrenCases = listOf(1, 10, 20, 50, 100, 200, 500, 1_000, 2_000, 5_000, 10_000, 20_000, 50_000)
val totalTests = mappers.size * childrenCases.size * 3


fun main() {
    mappers.forEach { mapper -> verifyMapper(mapper) }
    val results = mutableListOf<TestResult>()
    val childrenTestCases = childrenCases.associateWith {
        generate(it - 1)
    }
    mappers.map { mapper ->
        childrenTestCases.forEach { case ->
            val testCaseBytes = mapper.toBytea(case.value)

            results.add(
                TestResult(
                    Process.Compression,
                    mapper.name,
                    case.key,
                    testCaseBytes?.size?.toLong() ?: -1L
                )
            )
            printProgress(results)

            results.add(
                TestResult(
                    Process.Serialization,
                    mapper.name,
                    case.key,
                    mapper.measureSerialization(case.value)
                )
            )
            printProgress(results)

            results.add(
                TestResult(
                    Process.Deserialization,
                    mapper.name,
                    case.key,
                    mapper.measureDeserialization(testCaseBytes)
                )
            )
            printProgress(results)
        }
    }


    printHeader("Serialized object size")
    printResults(results, Process.Compression)

    printHeader("Time required to serialize")
    printResults(results, Process.Serialization)

    printHeader("Time required to deserialize")
    printResults(results, Process.Deserialization)
}

enum class Process {
    Serialization, Deserialization, Compression;

    fun format(value: Long): String {
        return if (Compression == this) {
            "$value bytes"
        } else {
            "$value ms"
        }
    }

}

data class TestResult(val process: Process, val mapperName: String, val children: Int, val value: Long)


fun printProgress(results: List<TestResult>) {
    return println("Progress: ${results.size}/$totalTests")
}

fun printHeader(label: String) {
    println("### $label")
    println("|${valueToStr("Sample size")}|${mappers.joinToString("|") { valueToStr(it.name) }}|")
    print("|")
    (0..mappers.size).forEach { _ ->
        print(valueToStr((0 until pad).joinToString("") { "-" }) + "|")
    }
    println()
}

fun printResults(results: List<TestResult>, process: Process) {
    results.filter { it.process === process }
        .groupBy { it.children }
        .map { it.toPair() }
        .sortedBy { it.first }
        .forEach {
            println(
                "|${valueToStr("${it.first}")}|${
                    it.second.joinToString("|") { res ->
                        valueToStr(process.format(res.value))
                    }
                }|"
            )
        }
    println()
}

fun valueToStr(value: String): String {
    val strLen = value.length
    return "${(0 until (pad - strLen)).joinToString("") { " " }}$value"
}

fun verifyMapper(mapper: ObjectMapper) {
    val testCase = generate(1)
    val kryoBytes = mapper.toBytea(testCase)
    if (mapper.fromBytea(kryoBytes) != testCase) {
        throw IllegalStateException("${mapper.name} failed")
    }
}


fun ObjectMapper.measureSerialization(testCase: Human?): Long {
    return measureTimeMillis {
        (0 until loops).forEach { _ ->
            this.toBytea(testCase)
        }
    }
}


fun ObjectMapper.measureDeserialization(testCaseBytes: ByteArray?): Long {
    return measureTimeMillis {
        (0 until loops).forEach { _ ->
            this.fromBytea(testCaseBytes)
        }
    }
}