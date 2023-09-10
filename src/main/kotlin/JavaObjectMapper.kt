import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class JavaObjectMapper : ObjectMapper {
    override val name: String = "Java"
    override fun toBytea(data: Human?): ByteArray? {
        if (data == null) return null
        val bos = ByteArrayOutputStream()
        val out = ObjectOutputStream(bos)
        try {
            out.writeObject(data)
            out.flush()
            return bos.toByteArray()
        } finally {
            try {
                bos.close()
            } catch (ex: IOException) {

            }
        }
    }

    override fun fromBytea(bytes: ByteArray?): Human? {
        if (bytes == null) return null
        val bis = ByteArrayInputStream(bytes)
        val inStream = ObjectInputStream(bis)
        try {
            return inStream.readObject() as Human?
        } finally {
            try {
                inStream.close()
            } catch (ex: IOException) {

            }
        }
    }
}