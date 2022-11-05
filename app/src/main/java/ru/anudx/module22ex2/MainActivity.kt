package ru.anudx.module22ex2

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.anudx.module22ex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            b.scroll.setOnScrollChangeListener{ view, scrollX, scrollY, oldScrollX, oldScrollY ->
                if (scrollY > oldScrollY){
                    dY -= 1
                    this.apply {
                        b.backGroundSmall.animate()
                            .setDuration(0)
                            .translationY(dY*2f)
                            .start()
                        b.backGroundMedium.animate()
                            .setDuration(0)
                            .translationY(dY*1f)
                            .start()
                        b.backGroundLarge.animate()
                            .setDuration(0)
                            .translationY(dY*0.5f)
                            .start()
                    }
                }
                else if (scrollY < oldScrollY){
                    dY += 1
                    this.apply {
                        b.backGroundSmall.animate()
                            .setDuration(0)
                            .translationY(dY*2f)
                            .start()
                        b.backGroundMedium.animate()
                            .setDuration(0)
                            .translationY(dY*1f)
                            .start()
                        b.backGroundLarge.animate()
                            .setDuration(0)
                            .translationY(dY*0.5f)
                            .start()
                    }
                }

            }
        }

    }
    companion object{
        var dY: Float = 0f
    }
}