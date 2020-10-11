package id.ac.ui.cs.mobileprogramming.naufaldi.individualreport

import android.content.Intent
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Tween Animation Example (Uncomment code below)
        val image: ImageView = findViewById(R.id.image)
        val hyperspaceJump: Animation = AnimationUtils.loadAnimation(this, R.anim.hyperspace_jump)
        image.startAnimation(hyperspaceJump)


        //Frame Animation Example
        val imageAnimation = image.background
        if (imageAnimation is Animatable) {
            imageAnimation.start()
        }


        //Color list Example (Uncomment code below)
        button.visibility = View.VISIBLE


        //Drawable Shapes Example (Uncomment code below)
        button.setOnClickListener {
            val intent = Intent(this, ShapesExample::class.java)
            startActivity(intent)
        }

    }
}