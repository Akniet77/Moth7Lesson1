package com.example.moth7lesson1.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.moth7lesson1.data.models.Contact
import com.example.moth7lesson1.domain.models.ContactEntity

@Dao
interface ContactDao {

    @Query("SELECT * FROM contact" )
    suspend fun getContact() : List<Contact>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createContact(contact: ContactEntity)

    @Update
    suspend fun updateContact(contact: ContactEntity)

    @Delete
    suspend fun deleteContact(contact: ContactEntity)
}