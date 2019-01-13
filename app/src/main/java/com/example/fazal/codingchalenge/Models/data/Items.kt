package com.example.fazal.codingchalenge.Models.data

class Items : Item {
    var type: String = ""
    var id: Int = 0
    var attributes: Attributes? = null

    override fun isSection(): Boolean {
        return false
    }
}