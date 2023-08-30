package com.example.moth7lesson1.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.moth7lesson1.R
import com.example.moth7lesson1.data.models.Contact
import com.example.moth7lesson1.domain.models.ContactEntity
import com.example.moth7lesson1.presentation.utils.UIState
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<ContactViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getContacts()
        getCreatContats()
        getDeleteContact()
        getUpdateContact()

    }

    private fun getContacts(){
        viewModel.getAllContacts()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getAllContacts.collect {
                    when (it) {
                        is UIState.Loading -> {
                            println("Show progress bar")
                        }
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Success -> {
                            println("Show data in recycler view")
                        }
                    }
                }
            }
        }
    }

    private fun getCreatContats(){
        viewModel.addContact(contact = ContactEntity(id = 0, name = "Katya", number = ""))

        lifecycleScope.launch {
             repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getAllContacts.collect {
                    when (it) {
                        is UIState.Loading -> {
                            println("Show progress bar")
                        }
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Success -> {
                            println("Show data in recycler view")
                        }
                    }
                }
            }
        }
    }
    private fun getUpdateContact(){
        viewModel.updateContact(contact = ContactEntity(id = 1, name = "tea", number = ""))
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getAllContacts.collect {
                    when (it) {
                        is UIState.Loading -> {
                            println("Show progress bar")
                        }
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Success -> {
                            println("Show data in recycler view")
                        }
                    }
                }
            }
        }
    }
    private fun getDeleteContact(){
        viewModel.deleteContact(contact = ContactEntity(id = 2, name = "Who", number = ""))
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getAllContacts.collect {
                    when (it) {
                        is UIState.Loading -> {
                            println("Show progress bar")
                        }
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Success -> {
                            println("Show data in recycler view")
                        }
                    }
                }
            }
        }
    }
}