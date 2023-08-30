package com.example.moth7lesson1.domain.usecases

import com.example.moth7lesson1.domain.contactRepository.ContactRepository
import com.example.moth7lesson1.domain.mappers.mapToContactEntity
import com.example.moth7lesson1.domain.models.ContactEntity
import com.example.moth7lesson1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetContactUseCases @Inject constructor(
    private val repository: ContactRepository
) {

    fun getContacts(): Flow<Resource<List<ContactEntity>>> {
        return repository.getContact()
    }
}