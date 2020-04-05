package smallville7123.profile.image.extractor

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.annotation.ColorInt
import com.madrapps.eyedropper.EyeDropper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        frameLeft.setBackgroundColor(android.graphics.Color.RED)
        frameRight.setBackgroundColor(android.graphics.Color.RED)
        frameTop.setBackgroundColor(android.graphics.Color.RED)
        frameBottom.setBackgroundColor(android.graphics.Color.RED)
        textView2.text = "Selected Color: null"
        val targetView: ImageView = colorSample
        targetView.setOnTouchListener { v, ev -> // TODO Auto-generated method stub
            val img = v as ImageView
            val evX = ev.x.toInt()
            val evY = ev.y.toInt()
            img.isDrawingCacheEnabled = true
            val imgbmp = Bitmap.createBitmap(img.drawingCache)
            img.isDrawingCacheEnabled = false
            try {
                val pxl = imgbmp.getPixel(evX, evY)
                ColorView.setBackgroundColor(pxl)
            } catch (ignore: Exception) {
            }
            imgbmp.recycle()
            true
        }
    }
}