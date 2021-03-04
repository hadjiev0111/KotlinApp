package com.amir.kotlinapp.ui.activities.disconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amir.kotlinapp.R
import com.amir.kotlinapp.ui.activities.playlist.PlaylistActivity
import com.amir.kotlinapp.utils.isConnected
import kotlinx.android.synthetic.main.activity_disconnect.*

class DisconnectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disconnect)
        btnDisc.setOnClickListener {
            if (this.isConnected(this)) {
                val intent = Intent(this, PlaylistActivity::class.java)
                startActivity(intent)
                finish()
            } else return@setOnClickListener
        }
    }
}