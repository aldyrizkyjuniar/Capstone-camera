package com.example.capstone

import android.graphics.Bitmap
import android.media.Image
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.networking.PostAdapter
import com.example.capstone.networking.PostResponse
import com.example.capstone.networking.RetrofitClient
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class DetailActivity :AppCompatActivity(){
    lateinit var rvPost: RecyclerView
    lateinit var tvResponseCode: TextView
    lateinit var imageView : ImageView

    private val list = ArrayList<PostResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        rvPost = findViewById(R.id.rvPost)
        tvResponseCode = findViewById(R.id.tvResponseCode)
        imageView = findViewById(R.id.imagePreview)

//        Receive ImageBitMap from Previous Activity and Display it
        val bundle: Bundle? = intent?.extras
        val imageBitmap : Bitmap? = bundle?.get("imageBitmap") as Bitmap?
        imageView.setImageBitmap(imageBitmap)

        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getPosts().enqueue(object: retrofit2.Callback<ArrayList<PostResponse>>{
            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>
            ) {
                val responseCode = response.code().toString()
                tvResponseCode.text = responseCode
                response.body()?.let { list.addAll(it) }
                val adapter = PostAdapter(list)
                rvPost.adapter = adapter
            }


        })

    }

    private fun sendPostRequest() {

    }

}