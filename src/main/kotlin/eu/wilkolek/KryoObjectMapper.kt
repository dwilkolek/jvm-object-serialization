package eu.wilkolek

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

class KryoObjectMapper : ObjectMapper {
    override val name: String = "Kryo"

    companion object {
        val kryo = Kryo().also {
            it.isRegistrationRequired = false
            it.register(Human::class.java)
            it.register(ArrayList::class.java)
            it.register(java.time.LocalDate::class.java)
        }

    }


    override fun toBytea(data: Human?): ByteArray? {
        val bytea = ByteArrayOutputStream()
        val output = Output(bytea)
        output.use {
            kryo.writeClassAndObject(it, data)
        }
        return bytea.toByteArray()
    }

    override fun fromBytea(bytes: ByteArray?): Human? {
        val input = Input(ByteArrayInputStream(bytes))
        return input.use { kryo.readClassAndObject(it) } as Human?
    }

}