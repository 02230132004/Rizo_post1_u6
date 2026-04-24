package com.example.securenotesapp.security

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

object SecureStorageManager {
    private const val PREFS_NAME = "secure_prefs"
    private const val TOKEN_KEY = "session_token"

    private fun getEncryptedPrefs(context: Context) = EncryptedSharedPreferences.create(
        context,
        PREFS_NAME,
        MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build(),
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun guardarToken(context: Context, token: String) {
        getEncryptedPrefs(context).edit().putString(TOKEN_KEY, token).apply()
    }

    fun obtenerToken(context: Context): String? {
        return getEncryptedPrefs(context).getString(TOKEN_KEY, null)
    }

    fun limpiarSesion(context: Context) {
        getEncryptedPrefs(context).edit().remove(TOKEN_KEY).apply()
    }
}
