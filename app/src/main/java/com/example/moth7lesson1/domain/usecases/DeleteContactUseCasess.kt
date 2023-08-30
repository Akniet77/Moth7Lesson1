package com.example.moth7lesson1.domain.usecases

import com.example.moth7lesson1.domain.contactRepository.ContactRepository
import com.example.moth7lesson1.domain.models.ContactEntity

class DeleteContactUseCasess(
    private val repo: ContactRepository
) {

    fun deleteContact(contact: ContactEntity) = repo.createContact(contact)
}