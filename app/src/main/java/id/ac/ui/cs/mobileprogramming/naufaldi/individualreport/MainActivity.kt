package id.ac.ui.cs.mobileprogramming.naufaldi.individualreport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import id.ac.ui.cs.mobileprogramming.naufaldi.individualreport.view.FirstFragment
import id.ac.ui.cs.mobileprogramming.naufaldi.individualreport.view.SecondFragment

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstFragment = FirstFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.frame, firstFragment)
            .commit()
    }

    fun dataPassed() {
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentTwo = SecondFragment()
        transaction.replace(R.id.frame, fragmentTwo)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}