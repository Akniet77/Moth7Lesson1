package com.example.moth7lesson1.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val number: String
        )