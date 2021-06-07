package com.example.capstone.networking


import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("function-4")
    fun getPosts(): Call<ArrayList<PostResponse>>
}