package com.example.moth7lesson1.data.db

import androidx.room.Database
import com.example.moth7lesson1.data.db.dao.ContactDao
import com.example.moth7lesson1.data.models.Contact

@Database(entities = [Contact:: class], views = [], version = 1)
abstract class ContactDataBase {

    abstract fun getContactDao() : ContactDao
}