package com.example.android.aplikasiloginsederhana

import android.os.Bundle
import android.text.InputType.*
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var username: String
    lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun verifikasi(view: View) {
        if (checkInput(et_username) && checkInput(et_password)){
            username = et_username.text.toString()
            password = et_password.text.toString()

            val dummyUsername = "zain"
            val dummyPassword = "zain123"

            if (username.equals(dummyUsername)){
                if (password.equals(dummyPassword)){
                    var myToast = Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT)
                    myToast.setGravity(Gravity.CENTER, 0, 500)
                    myToast.show()
                }
                else {
                    var myToast = Toast.makeText(this, "Password anda Salah", Toast.LENGTH_SHORT)
                    myToast.setGravity(Gravity.CENTER, 0, 500)
                    myToast.show()
                }
            } else{
                var myToast = Toast.makeText(this, "Username anda tidak terdaftar", Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.CENTER, 0, 500)
                myToast.show()
            }
        } else {
            var myToast = Toast.makeText(this, "Data Belum Lengkap", Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.CENTER, 0, 500)
            myToast.show()
        }
    }

    private fun checkInput(et: EditText) : Boolean {
        return if (et.text.toString() != ""){
            true
        } else {
            et.error = "Wajib Diisi"
            false
        }
    }

    fun showHidePassword(view: View) {
        if (cb_show_password.isChecked)
            et_password.inputType =
                TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        else
            et_password.inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
    }
}