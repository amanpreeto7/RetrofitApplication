package com.o7services.retrofitapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitInterface {

    @GET("users")
    fun getUsers(): Call<UserResponse>

    @GET("users/{userId}")
    fun getSingleUser(@Path("userId") userId: Int): Call<UserResponseItem>
}