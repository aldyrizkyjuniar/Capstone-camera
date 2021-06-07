package com.example.capstone.networking

import com.google.gson.annotations.SerializedName

data class PostResponse(
//    val id:Int,
//    val title: String?,
//    Format Response
//    "Confidence" : "Prediction confidence"
//    "Name" : "Disease Name",
//    "Detail" : "Detailed Information of Disease"
//    "Treatment" : "Disease Treatment"
    @SerializedName("Confidence")
    val confidence: String?,
    @SerializedName("Name")
    val name: String?,
    @SerializedName("Detail")
    val detail : String?,
    @SerializedName("Treatment")
    val treatment : String?
)