package com.example.flaggame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.navArgs

class ResultActivity : AppCompatActivity() {
    private lateinit var tv_name: TextView
    private lateinit var tv_score: TextView
    private lateinit var btn_finish: Button

    val args: ResultActivityArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

tv_name = findViewById<TextView>(R.id.tv_name)
tv_score = findViewById<TextView>(R.id.tv_score)
btn_finish = findViewById<Button>(R.id.btn_finish)

        val username = intent.getStringExtra(Constants.USER_NAME)
        tv_name.text = username
        tv_score.text = args.resultData.userDisplayScore

        btn_finish.setOnClickListener {

            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}