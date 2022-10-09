package com.example.mad_nishant_prac4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
class MainActivity : AppCompatActivity() { override fun
        onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val buttonBrowse = findViewById<Button>(R.id.button_browse)
    buttonBrowse.setOnClickListener {
        val url = findViewById<TextInputEditText>(R.id.input_browse).text
        var url_text = url.toString()
        Intent(Intent.ACTION_VIEW).setData(Uri.parse(url_text)).apply {
            startActivity(this)
        } }
    val buttonCall =
        findViewById<Button>(R.id.button_call)
    buttonCall.setOnClickListener {


        var number = findViewById<TextInputEditText>(R.id.input_call).text
        var number_text = "tel: $number"
        Intent(Intent.ACTION_DIAL).setData(Uri.parse(number_text)).apply {
            startActivity(this)
        }
    }
    val buttonContact =
        findViewById<Button>(R.id.button_contact)
    buttonContact.setOnClickListener {
        Intent(Intent.ACTION_VIEW).setType(ContactsContract.Contacts.CONTENT_TYPE).apply{ startActivity(this)
        }
    }
    val buttonCalllog =
        findViewById<Button>(R.id.button_calllog)
    buttonCalllog.setOnClickListener {
        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).apply{
            startActivity(this)
        }
    }
    val buttonGallery =
        findViewById<Button>(R.id.button_gallery)
    buttonGallery.setOnClickListener {
        Intent(Intent.ACTION_VIEW).setType("image/*").apply {
            startActivity(this)
        }
    }
    val buttonCamera =
        findViewById<Button>(R.id.button_camera)
    buttonCamera.setOnClickListener {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
            startActivity(this)
        }
    }
    val buttonAlarm =
        findViewById<Button>(R.id.button_alarm)
    buttonAlarm.setOnClickListener {
        Intent(AlarmClock.ACTION_SHOW_ALARMS).apply {
            startActivity(this)
        }
    }
}



}