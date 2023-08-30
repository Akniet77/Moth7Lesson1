package com.example.moth7lesson1.data.repository

import com.example.moth7lesson1.data.db.dao.ContactDao
import com.example.moth7lesson1.domain.contactRepository.ContactRepository
import com.example.moth7lesson1.domain.mappers.mapToContactEntity
import com.example.moth7lesson1.domain.models.ContactEntity
import com.example.moth7lesson1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


import javax.inject.Inject

abstract class ContactRepositoryImpl @Inject constructor(
     private val contactDao : ContactDao
) : ContactRepository {

    override fun getContact(): Flow<Resource<List<ContactEntity>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = contactDao.getContact()
                emit(Resource.Success(data.mapToContactEntity()))
            }catch (e: Exception){
                emit(Resource.Error(e.localizedMessage))
            }
        }
    }

    override  fun createContact(contact: ContactEntity): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(contactDao.createContact(contact))
            }catch (e : Exception){
                Resource.Error(e.localizedMessage)
            }
        }
    }

    override fun updateContact(contact: ContactEntity) : Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(contactDao.updateContact(contact))
            } catch (e: Exception) {
                Resource.Error(e.localizedMessage)
            }
        }
    }


     override fun deleteContact(contact: ContactEntity): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(contactDao.deleteContact(contact))
            } catch (e: Exception) {
                Resource.Error(e.localizedMessage)
            }
        }
    }
}