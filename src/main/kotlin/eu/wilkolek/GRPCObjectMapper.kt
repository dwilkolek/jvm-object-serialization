package eu.wilkolek


import com.google.protobuf.Timestamp
import eu.wilkolek.protobuf.HumanMessage
import java.time.*


class GRPCObjectMapper : ObjectMapper {

    override val name: String = "gRPC"
    override fun toBytea(data: Human?): ByteArray? {
        if (data == null) {
            return null
        }
        return toMessage(data).toByteArray()
    }

    override fun fromBytea(bytes: ByteArray?): Human? {
        if (bytes == null) {
            return null
        }
        return fromMessage(HumanMessage.parseFrom(bytes))
    }


}

fun toMessage(data: Human): HumanMessage = with(data) {
    HumanMessage.newBuilder()
        .setName(name)
        .setAge(age)
        .addAllChildren(children.map { toMessage(it) })
        .setDateOfBirth(fromLocalDate(dateOfBirth))
        .build()
}

fun fromMessage(message: HumanMessage): Human = Human(
    name = message.name,
    age = message.age,
    dateOfBirth = toLocalDate(message.dateOfBirth),
    children = message.childrenList.map { fromMessage(it) }
)


fun fromLocalDate(localDate: LocalDate): Timestamp {
    val instant = localDate.atStartOfDay().toInstant(ZoneOffset.UTC)
    return Timestamp.newBuilder()
        .setSeconds(instant.epochSecond)
        .setNanos(instant.nano)
        .build()
}

fun toLocalDate(timestamp: Timestamp): LocalDate {
    return LocalDateTime.ofInstant(
        Instant.ofEpochSecond(timestamp.seconds, timestamp.nanos.toLong()),
        ZoneId.of("UTC")
    )
        .toLocalDate()
}