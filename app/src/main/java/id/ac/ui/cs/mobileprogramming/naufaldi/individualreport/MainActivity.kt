package id.ac.ui.cs.mobileprogramming.naufaldi.individualreport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.ui.cs.mobileprogramming.naufaldi.individualreport.view.FirstFragment

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstFragment = FirstFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, firstFragment)
            .commit()
    }
}