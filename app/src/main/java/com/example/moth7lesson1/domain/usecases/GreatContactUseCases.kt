package com.example.moth7lesson1.domain.usecases

import com.example.moth7lesson1.domain.contactRepository.ContactRepository
import com.example.moth7lesson1.domain.models.ContactEntity

class GreatContactUseCases(
    private val repo: ContactRepository
) {

    fun creatContact(contact: ContactEntity) = repo.createContact(contact)
}