package taki.running.runningapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.google.android.gms.common.api.GoogleApiClient

@Dao
interface RunDao {


    //Insert Runs
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRuns(runModel: RunModel)

    //Delete Per One Run
    @Delete
    suspend fun deleteRun(runModel: RunModel)

    //Delete All Runs
    @Query("DELETE FROM running_table")
    suspend fun deleteAllRuns()

    //Get All Runs Sorted By Date
    @Query("SELECT * FROM RUNNING_TABLE ORDER BY timestamp DESC")
    fun  getAllRunsSortedByDate() : LiveData<List<RunModel>>

    //Get All Runs Sorted By avgSpeedInKm
    @Query("SELECT * FROM RUNNING_TABLE ORDER BY avgSpeedInKm DESC")
    fun  getAllRunsSortedByAvgSpeedInKm() : LiveData<List<RunModel>>

    //Get All Runs Sorted By Distance In Meters
    @Query("SELECT * FROM RUNNING_TABLE ORDER BY distanceInMeters DESC")
    fun  getAllRunsSortedByDistanceInMeters() : LiveData<List<RunModel>>

    //Get All Runs Sorted By TimeInMillis
    @Query("SELECT * FROM RUNNING_TABLE ORDER BY timeInMillis DESC")
    fun  getAllRunsSortedByTimeInMillis() : LiveData<List<RunModel>>

    //Get All Runs Sorted By CaloriesBurned
    @Query("SELECT * FROM RUNNING_TABLE ORDER BY caloriesBurned DESC")
    fun  getAllRunsSortedByCaloriesBurned() : LiveData<List<RunModel>>


    //Get Total Time In Millis
    @Query("SELECT SUM(timeInMillis) FROM running_table ")
    fun  getTotalTimeInMillis() : LiveData<Long>

    //Get All Burned Calories
    @Query("SELECT SUM(caloriesBurned) FROM RUNNING_TABLE")
    fun getAllCaloriesBurned() : LiveData<Int>

    //Get All Distance In Meters
    @Query("SELECT SUM(distanceInMeters) FROM RUNNING_TABLE")
    fun getAllDistanceInMeters() : LiveData<Int>

    //Get the sum of avg speeds
    @Query("SELECT AVG(avgSpeedInKm) FROM RUNNING_TABLE")
    fun getAllAvgSpeed() : LiveData<Float>



}