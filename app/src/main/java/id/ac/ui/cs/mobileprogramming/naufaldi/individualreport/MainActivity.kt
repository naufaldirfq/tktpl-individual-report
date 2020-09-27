package id.ac.ui.cs.mobileprogramming.naufaldi.individualreport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var res : Int = 0

    fun incrementNumber(num : Int): NumResult {
        res = num + 1

        return NumResult(res)
    }

    fun decrementNumber(num : Int): NumResult {
        res = num - 1

        return NumResult(res)
    }

    data class NumResult(val num: Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        value.text = res.toString()

        buttonMinus.setOnClickListener {
            decrementNumber(res)
            value.text = res.toString()
        }

        buttonPlus.setOnClickListener {
            incrementNumber(res)
            value.text = res.toString()
        }

    }

}