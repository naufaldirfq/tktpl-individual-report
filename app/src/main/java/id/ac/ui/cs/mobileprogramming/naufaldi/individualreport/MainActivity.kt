package id.ac.ui.cs.mobileprogramming.naufaldi.individualreport

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var START_MILLI_SECONDS = 60000L

    private lateinit var countdown_timer: CountDownTimer
    private var isRunning: Boolean = false;
    var time_in_milli_seconds = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            if (isRunning) {
                pauseTimer()
            } else {
                val time = time_edit_text.text.toString()
                if (time.isEmpty()) {
                    val dialogBuilder = AlertDialog.Builder(this)

                    dialogBuilder.setMessage("Masukkan waktu")
                        .setCancelable(false)
                        .setNegativeButton("Ok", DialogInterface.OnClickListener {
                                dialog, id -> dialog.cancel()
                        })

                    val alert = dialogBuilder.create()
                    alert.setTitle("Belum memasukkan waktu")
                    alert.show()
                }
                else {
                    time_in_milli_seconds = time.toLong() * 60000L
                    startTimer(time_in_milli_seconds)
                }
            }
        }

        reset.setOnClickListener {
            resetTimer()
        }

        close.setOnClickListener {
            finish()
        }

    }

    override fun onBackPressed() {
        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setMessage("Untuk menutup aplikasi, klik tombol EXIT")
            .setCancelable(false)
            .setNegativeButton("Ok", DialogInterface.OnClickListener {
                    dialog, _ -> dialog.cancel()
            })

        val alert = dialogBuilder.create()
        alert.setTitle("Menutup Aplikasi")
        alert.show()

    }

    private fun pauseTimer() {
        button.text = "Start"
        countdown_timer.cancel()
        isRunning = false
        reset.visibility = View.VISIBLE
    }

    private fun startTimer(time_in_seconds: Long) {
        countdown_timer = object : CountDownTimer(time_in_seconds, 1000) {
            override fun onFinish() {
                button.text = "Finish"
            }

            override fun onTick(p0: Long) {
                time_in_milli_seconds = p0
                updateTextUI()
            }
        }
        countdown_timer.start()

        isRunning = true
        button.text = "Pause"
        reset.visibility = View.INVISIBLE

    }

    private fun resetTimer() {
        time_in_milli_seconds = START_MILLI_SECONDS
        updateTextUI()
        reset.visibility = View.INVISIBLE
    }

    private fun updateTextUI() {
        val minute = (time_in_milli_seconds / 1000) / 60
        val seconds = (time_in_milli_seconds / 1000) % 60

        timer.text = "$minute:$seconds"
    }

}
