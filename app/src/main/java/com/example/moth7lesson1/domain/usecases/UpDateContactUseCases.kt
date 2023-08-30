package com.example.moth7lesson1.domain.usecases

import com.example.moth7lesson1.domain.contactRepository.ContactRepository
import com.example.moth7lesson1.domain.models.ContactEntity
import javax.inject.Inject

class UpDateContactUseCases @Inject constructor(
    private val contactRepo: ContactRepository
) {

    fun updateContact(contact: ContactEntity) = contactRepo.updateContact(contact)
}