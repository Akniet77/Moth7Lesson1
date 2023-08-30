package com.example.moth7lesson1.domain.mappers

import com.example.moth7lesson1.data.models.Contact
import com.example.moth7lesson1.domain.models.ContactEntity

fun List<Contact>.mapToContactEntity() = this.map {
    ContactEntity(
        id = it.id,
        name = it.name,
        number = it.number

    )
}