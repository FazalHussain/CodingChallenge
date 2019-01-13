package com.example.fazal.codingchalenge.Models.data

class SectionRole(role: String) : Item {

    var role: String? = role

    override fun isSection(): Boolean {
        return true
    }

}
