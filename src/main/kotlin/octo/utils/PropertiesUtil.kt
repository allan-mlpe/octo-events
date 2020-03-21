package octo.utils

import java.io.FileInputStream
import java.util.Properties

class PropertiesUtil {
    companion object {
        private val props = Properties()

        init {
            val fis = this::class.java.classLoader
                .getResourceAsStream("octo.properties")
            props.load(fis)
        }

        val DB_HOST: String = props.getProperty("db_host")
        val DB_PORT : Int = props.getProperty("db_port").toInt()
        val DB_NAME: String = props.getProperty("db_name")
        val SERVER_PORT: Int = props.getProperty("server_port").toInt()
    }
}