package com.example.fazal.codingchalenge.Models.data

import com.google.gson.annotations.SerializedName

data class Attributes (
        var id: Int,
        @SerializedName("site_id")
        var siteId: Long,
        @SerializedName("helmet_color")
        var helmetColor: String,
        @SerializedName("role_id")
        var roleId: Int,
        @SerializedName("first_name")
        var firstName: String,
        @SerializedName("last_name")
        var lastName: String,
        @SerializedName("worker_tag_id")
        var workerTagId: String? = null,
        var contractor: String,
        @SerializedName("mobile_number")
        var mobileNumber: String? = null,
        var name: String,
        var type: String,
        @SerializedName("maximum_voltage")
        var maxVoltage: Int,
        @SerializedName("is_active")
        var isActive: Boolean,
        @SerializedName("last_seen")
        var lastSeen: String,
        var created_at: String,
        var updated_at: String,
        var deleted_at: String? = null,
        @SerializedName("is_online")
        var isOnline: Boolean,
        @SerializedName("Inventories")
        var inventories: List<Inventories>,
        @SerializedName("Role")
        var roleObject: Role? = null,
        var role: String? = "",
        @SerializedName("full_name")
        var fullName: String



)