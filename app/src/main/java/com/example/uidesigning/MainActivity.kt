package com.example.uidesigning

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import de.hdodenhof.circleimageview.CircleImageView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitButton : Button = findViewById(R.id.submit_btn)
        val resetButton : Button = findViewById(R.id.reset_btn)
        val ageEditText : EditText = findViewById(R.id.age)
        val nameEditText : EditText = findViewById(R.id.name)
        val circleImageView : CircleImageView = findViewById(R.id.image_picker)

        circleImageView.setOnClickListener {
            if (hasCameraPermission()) {
                openCamera()
            } else {
                requestCameraPermission()
            }
        }

        submitButton.setOnClickListener {

            val name = nameEditText.text.toString().trim()
            val age = ageEditText.text.toString().trim()

            if (validateForm(name, age)) {
                Toast.makeText(this, "Submit Successful", Toast.LENGTH_SHORT).show()


                val intent = Intent(this, Server::class.java)

                intent.putExtra("name", name)
                intent.putExtra("age", age)

                startActivity(intent)

            }
        }

        resetButton.setOnClickListener{
            nameEditText.setText("")
            ageEditText.setText("")
        }
    }

    private fun hasCameraPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this, Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun validateForm(name: String, age: String): Boolean {
        if (name.isEmpty()){
            showToast("Name is Required")
            return false
        }

        if (age.isEmpty()){
            showToast("Age is Required")
            return false
        }
        return true
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}