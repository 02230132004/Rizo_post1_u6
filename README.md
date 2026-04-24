# Rizo_post1_u6
# NotasSeguras - Seguridad Móvil

##  Descripción

Aplicación Android desarrollada en Kotlin que implementa almacenamiento seguro de datos utilizando EncryptedSharedPreferences y Android Keystore. Además, integra autenticación biométrica con BiometricPrompt para proteger el acceso a información sensible.

##  Funcionalidades principales

* Almacenamiento cifrado de token de sesión
* Protección mediante autenticación biométrica
* Eliminación segura de datos (logout)
* Interfaz moderna con Jetpack Compose

##  Tecnologías utilizadas

* Kotlin
* Android Studio
* EncryptedSharedPreferences
* Android Keystore (AES256_GCM)
* BiometricPrompt
* ViewModel + LiveData

##  Instalación y ejecución

1. Clonar el repositorio
2. Abrir en Android Studio
3. Sincronizar Gradle
4. Ejecutar en emulador o dispositivo (API 30+)

##  Clases principales

### SecureStorageManager

Gestiona el almacenamiento seguro utilizando EncryptedSharedPreferences y MasterKey.

### BiometricHelper

Encapsula la autenticación biométrica mediante BiometricPrompt.

### NotesViewModel

Controla la lógica de negocio entre la interfaz y el almacenamiento seguro.

##  Evidencias

Las evidencias se encuentran en la carpeta `/evidencias`:

* Checkpoint 1: Verificación de datos cifrados con ADB
* Checkpoint 2: Autenticación biométrica en ejecución
* Checkpoint 3: Eliminación de datos tras logout

##  Decisiones de seguridad

Se implementó EncryptedSharedPreferences para evitar almacenamiento en texto plano.
La clave se gestiona mediante Android Keystore.
Se añadió autenticación biométrica para proteger el acceso a datos sensibles.
El logout elimina completamente la información almacenada.


