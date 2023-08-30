package com.example.moth7lesson1.domain.contactRepository


import com.example.moth7lesson1.domain.models.ContactEntity
import com.example.moth7lesson1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow


interface ContactRepository {

     fun getContact() : Flow<Resource<List<ContactEntity>>>


     fun createContact(contact: ContactEntity) : Flow<Resource<Unit>>


     fun updateContact(contact: ContactEntity) : Flow<Resource<Unit>>


     fun deleteContact(contact: ContactEntity) : Flow<Resource<Unit>>
}