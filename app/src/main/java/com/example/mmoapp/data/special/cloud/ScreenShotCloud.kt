package com.example.mmoapp.data.special.cloud

import com.google.gson.annotations.SerializedName

data class ScreenShotCloud(
    @SerializedName("id")
    private val id: Int?,
    @SerializedName("image")
    private val image: String?
) {
}