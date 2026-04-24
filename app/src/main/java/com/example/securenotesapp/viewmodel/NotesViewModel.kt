package com.example.securenotesapp.viewmodel

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.example.securenotesapp.security.SecureStorageManager

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    private val _tokenState = mutableStateOf<String?>(null)
    val tokenState: State<String?> = _tokenState

    private val _messageState = mutableStateOf("")
    val messageState: State<String> = _messageState

    fun guardarToken(token: String) {
        if (token.isBlank()) {
            _messageState.value = "El token no puede estar vacío"
            return
        }
        SecureStorageManager.guardarToken(getApplication(), token)
        _messageState.value = "Token guardado de forma segura"
    }

    fun mostrarToken() {
        val token = SecureStorageManager.obtenerToken(getApplication())
        if (token != null) {
            _tokenState.value = token
            _messageState.value = "Token recuperado"
        } else {
            _messageState.value = "No hay token guardado"
        }
    }

    fun cerrarSesion() {
        SecureStorageManager.limpiarSesion(getApplication())
        _tokenState.value = null
        _messageState.value = "Sesión cerrada y token eliminado"
    }

    fun limpiarMensaje() {
        _messageState.value = ""
    }
}
