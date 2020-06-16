package taki.running.runningapp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import com.bumptech.glide.load.model.ByteBufferEncoder
import java.io.ByteArrayOutputStream

class TypeConverter {

    ///From Bitmap to ByteArray
    @TypeConverter
    private fun fromBitmap(bmp : Bitmap) : ByteArray{
        var outputStream = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.PNG,100,outputStream)
        return outputStream.toByteArray()
    }
    //To Bitmap
    @TypeConverter
    private fun ToBitmap(byte : ByteArray) : Bitmap{
        return BitmapFactory.decodeByteArray(byte,0,byte.size)

    }
}