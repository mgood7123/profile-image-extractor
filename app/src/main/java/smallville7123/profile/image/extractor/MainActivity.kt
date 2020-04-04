package smallville7123.profile.image.extractor

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
        frameLeft.setBackgroundColor(android.graphics.Color.BLACK)
        frameRight.setBackgroundColor(android.graphics.Color.BLACK)
        frameTop.setBackgroundColor(android.graphics.Color.BLACK)
        frameBottom.setBackgroundColor(android.graphics.Color.BLACK)
        textView2.text = "Selected Color: null"
        EyeDropper(imageView, object : EyeDropper.ColorSelectionListener {
            override fun onTouch(x: Int, y: Int) {
                // x,y is given when you touch the targetView
                textView3.text = "x: $x\ny: $y"
            }
            override fun onColorSelected(@ColorInt color: Int) {
                // color is the color selected when you touch the targetView
                ColorView.setBackgroundColor(color)
                textView2.text = "Selected Color: $color"
            }
        })
    }
}