package com.example.notasseguras.security

import android.content.Context
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

/**
 * Helper para manejar la autenticación biométrica.
 */
class BiometricHelper {

    fun biometriaDisponible(context: Context): Boolean {
        val biometricManager = BiometricManager.from(context)
        return biometricManager.canAuthenticate(BIOMETRIC_STRONG) == BiometricManager.BIOMETRIC_SUCCESS
    }

    fun autenticar(
        activity: FragmentActivity,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        val executor = ContextCompat.getMainExecutor(activity)
        val biometricPrompt = BiometricPrompt(activity, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    onError(errString.toString())
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    onSuccess()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    onError("Autenticación fallida")
                }
            })

        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Autenticación Biométrica")
            .setSubtitle("Requerido para ver el token")
            .setNegativeButtonText("Cancelar")
            .setAllowedAuthenticators(BIOMETRIC_STRONG)
            .build()

        biometricPrompt.authenticate(promptInfo)
    }
}
