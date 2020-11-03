package com.example.android.aplikasiloginsederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var username: String
    lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun verifikasi(view: View) {
        var username = ""
        var password = ""

        if (checkInput(et_username) && checkInput(et_password)){
            username = et_username.text.toString()
            password = et_password.text.toString()

            var dummyUsername = "zain"
            var dummyPassword = "zain123"

            if (username.equals(dummyUsername)){
                if (password.equals(dummyPassword))
                    Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "Password anda Salah", Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(this, "Username anda tidak terdaftar", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkInput(et: EditText) : Boolean {
        return if (et.text.toString() != ""){
            true
        } else {
            et.setError("Wajib Diisi")
            false
        }
    }
}