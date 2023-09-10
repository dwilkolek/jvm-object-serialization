import java.io.Serializable
import java.time.LocalDate
import java.util.UUID
import kotlin.random.Random


data class Human(val name: String, val age: Int, val dateOfBirth: LocalDate, val children: List<Human>) : Serializable {
    constructor() : this("dummy title", 0, LocalDate.now(), emptyList())
}


fun generate(children: Int = 0): Human {
    return Human("Human ${UUID.randomUUID()}",
        Random.nextInt(),
        LocalDate.of(Random.nextInt(2000, 2022), Random.nextInt(1, 10), Random.nextInt(1, 10)),
        (0 until children).map { generate() }
    )
}