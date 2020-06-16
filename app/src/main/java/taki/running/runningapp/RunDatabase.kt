package taki.running.runningapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import taki.running.runningapp.db.RunDao
import taki.running.runningapp.db.RunModel

@Database(entities = [RunModel::class],version = 1,exportSchema = false)
@TypeConverters(TypeConverter::class)
abstract class RunDatabase : RoomDatabase() {

    abstract fun runDao() : RunDao
    companion object{
        @Volatile private var INSTANCE : RunDatabase? = null
        private var LOCK = Any()
        fun getInstance(context: Context) = INSTANCE ?: synchronized(LOCK){
            INSTANCE ?: buildDataBase(context).also {
                INSTANCE = it
            }
        }
        private fun buildDataBase(context: Context) = Room.databaseBuilder(context.applicationContext,
        RunDatabase::class.java,"rundb.db").fallbackToDestructiveMigration().build()
    }
}