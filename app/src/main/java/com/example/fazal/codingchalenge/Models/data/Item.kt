package com.example.fazal.codingchalenge.Models.data

/**
 * Interface definition for Checking the row is of section or item
 */
interface Item {
    /**
     * Called for checking the row item is section.
     */
    fun isSection() : Boolean
}