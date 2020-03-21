package octo.dao

import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase
import octo.utils.PropertiesUtil
import org.litote.kmongo.KMongo

class DBConnection private constructor() {

    companion object {
        private lateinit var client: MongoClient
        private lateinit var instance: MongoDatabase

        fun getInstance() : MongoDatabase {
            if (!::instance.isInitialized) {
                client = KMongo.createClient(
                    PropertiesUtil.DB_HOST,
                    PropertiesUtil.DB_PORT
                )
                instance = client.getDatabase(PropertiesUtil.DB_NAME)
            }
            return instance
        }
    }
}