package com.example.moth7lesson1.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moth7lesson1.domain.models.ContactEntity
import com.example.moth7lesson1.domain.usecases.DeleteContactUseCasess
import com.example.moth7lesson1.domain.usecases.GetContactUseCases
import com.example.moth7lesson1.domain.usecases.GreatContactUseCases
import com.example.moth7lesson1.domain.usecases.UpDateContactUseCases
import com.example.moth7lesson1.domain.utils.Resource
import com.example.moth7lesson1.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ContactViewModel @Inject constructor(
    private val getContactUseCases: GetContactUseCases,
    private val addContactUseCases: GreatContactUseCases,
    private val updateContactUseCases: UpDateContactUseCases,
    private val deleteContactUseCases: DeleteContactUseCasess
) : ViewModel() {

    private val _mutableStateFlow = MutableStateFlow<UIState<List<ContactEntity>>>(UIState.Empty())
    val getAllContacts: StateFlow<UIState<List<ContactEntity>>> = _mutableStateFlow

    fun getAllContacts() {
        viewModelScope.launch {
            getContactUseCases.getContacts()
                .map { resource ->
                    when (resource) {
                        is Resource.Error -> UIState.Error(resource.message ?: "Some error")
                        is Resource.Loading -> UIState.Loading()
                        is Resource.Success -> UIState.Success(resource.data ?: emptyList())
                    }
                }
                .collect { newState ->
                    _mutableStateFlow.value = newState
                }
        }
    }

    fun addContact(contact: ContactEntity) {
        viewModelScope.launch {
            addContactUseCases.creatContact(contact).collect { resource ->
                handleResourceResult(resource)
            }
        }
    }

    fun updateContact(contact: ContactEntity) {
        viewModelScope.launch {
            updateContactUseCases.updateContact(contact).collect { resource ->
                handleResourceResult(resource)
            }
        }
    }

    fun deleteContact(contact: ContactEntity) {
        viewModelScope.launch {
            deleteContactUseCases.deleteContact(contact).collect { resource ->
                handleResourceResult(resource)
            }
        }
    }

    private fun handleResourceResult(resource: Resource<*>) {
        when (resource) {
            is Resource.Error -> {
                _mutableStateFlow.value = UIState.Error(resource.message ?: "Some error")
            }
            is Resource.Loading -> {
                _mutableStateFlow.value = UIState.Loading()
            }
            is Resource.Success -> {
                getAllContacts()
            }
        }
    }
}
