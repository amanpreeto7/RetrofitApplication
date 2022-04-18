package com.o7services.retrofitapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {
    lateinit var retrofit: retrofit
    lateinit var commentsAdapter: CommentsAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var llUsers: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        recyclerView = findViewById(R.id.rv)
        progressBar = findViewById(R.id.progressBar)
        llUsers = findViewById(R.id.llUsers)
        llUsers.visibility = View.GONE
        retrofit = retrofit()
        commentsAdapter = CommentsAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = commentsAdapter
        getComments()

    }

    fun getComments() {
        progressBar.visibility = View.VISIBLE
        commentsAdapter.clearList()
        retrofit.retrofitInterface.getComments().enqueue(object : Callback<CommentsResponse> {
            override fun onResponse(call: Call<CommentsResponse>, response: Response<CommentsResponse>) {
                Log.e("TAG", "response ${response.body()}")
                if(response.code() ==  200) {
                    response.body()?.let { commentsAdapter.updateList(it) }
                }else{

                }
                progressBar.visibility = View.GONE

            }

            override fun onFailure(call: Call<CommentsResponse>, t: Throwable) {
                Log.e("TAG", "response ${t}")
                Toast.makeText(this@CommentsActivity, t.toString(), Toast.LENGTH_LONG).show()
                progressBar.visibility = View.GONE
            }
        })
    }


}