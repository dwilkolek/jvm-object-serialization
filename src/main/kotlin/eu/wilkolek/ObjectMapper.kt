package eu.wilkolek

interface ObjectMapper {
    val name: String
    fun toBytea(data: Human?) : ByteArray?
    fun fromBytea(bytes: ByteArray?): Human?

}