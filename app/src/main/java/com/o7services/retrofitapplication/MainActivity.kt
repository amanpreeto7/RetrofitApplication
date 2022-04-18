package com.o7services.retrofitapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var retrofit: retrofit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retrofit = retrofit()
    }


    fun Comments(view: View) {
        startActivity(Intent(this, CommentsActivity::class.java))
    }

    fun Users(view: View) {
        startActivity(Intent(this, UsersActivity::class.java))

    }

    fun CreateUser(view: View) {

        retrofit.retrofitInterface.createUser(
            "Bearer 3ee949f72c6f36c0d90a9cb2b4cbcb91176626fcbf387a2daa2894750686de9e",
            mapOf(
                "email" to "email@gmail.com", "name" to
                        "name", "gender" to "male", "status" to "active"
            )
        ).enqueue(
            object : Callback<UserResponseItem> {
                override fun onResponse(
                    call: Call<UserResponseItem>,
                    response: Response<UserResponseItem>
                ) {
                    Log.e("TAG", " in success")
                    Toast.makeText(
                        this@MainActivity,
                        " User created successfully",
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onFailure(call: Call<UserResponseItem>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "in error ${t.toString()}", Toast.LENGTH_LONG)
                        .show()
                    Log.e("TAG", " in error")

                }
            }
        )
    }

    fun changeLanguage(view: View) {}
}