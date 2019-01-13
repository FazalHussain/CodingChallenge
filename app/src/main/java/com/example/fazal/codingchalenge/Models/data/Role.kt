package com.example.fazal.codingchalenge.Models.data

import com.google.gson.annotations.SerializedName

data class Role (
        var type: String,
        var id: Int,
        var attributes: Attributes,
        var role: String,
        @SerializedName("full_name")
        var fullName: String
)