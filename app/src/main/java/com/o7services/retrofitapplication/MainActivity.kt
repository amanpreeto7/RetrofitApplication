package com.o7services.retrofitapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

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
        "o7services@o7services", "O7services", "male", "active").enqueue(
            object  : Callback<UserResponseItem>{
                override fun onResponse(
                    call: Call<UserResponseItem>,
                    response: Response<UserResponseItem>
                ) {
                    Log.e("TAG", " in success")
                    Toast.makeText(this@MainActivity, " User created successfully", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<UserResponseItem>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "in error ${t.toString()}", Toast.LENGTH_LONG).show()
                    Log.e("TAG", " in error")

                }
            }
        )
    }
}