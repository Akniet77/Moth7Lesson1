package com.example.moth7lesson1.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moth7lesson1.data.db.ContactDataBase
import com.example.moth7lesson1.data.db.dao.ContactDao
import com.example.moth7lesson1.data.repository.ContactRepositoryImpl
import com.example.moth7lesson1.domain.contactRepository.ContactRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModel {

    @Singleton
    @Provides
    fun provideRoomDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context,
        RoomDatabase::class.java,
    "contacts").build()

    fun provideContactDao(contactDataBase: ContactDataBase) =
        contactDataBase.getContactDao()

    @Provides
    fun provideContactRepository(contactDao: ContactDao) : ContactRepository =
        ContactRepositoryImpl(contactDao)

}