package taki.running.runningapp.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "running_table")
data class RunModel(
    var img : Bitmap? = null,
    var timestamp : Long? = 0L, ///the date of running
    var avgSpeedInKm : Float = 0f, // the average speed of the run
    var distanceInMeters : Int = 0,
    var timeInMillis : Long = 0L,
    var caloriesBurned : Int = 0

) {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    var runID : Int? = null
}