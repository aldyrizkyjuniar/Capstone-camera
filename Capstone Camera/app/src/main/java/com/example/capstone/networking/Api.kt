package com.example.capstone.networking


import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


interface Api {
//    @GET("function-4")
//    fun getPosts(): Call<ArrayList<PostResponse>>
    @Multipart
    @POST("/functions-4")
    fun postImage(@Part image: MultipartBody.Part?): Call<ArrayList<PostResponse>>
}