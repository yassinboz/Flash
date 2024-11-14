plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.flashresto"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.flashresto"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)  // Cette ligne est déjà présente, donc vous pouvez retirer l'autre
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    implementation ("com.google.android.material:material:1.8.0")
    implementation ("androidx.appcompat:appcompat:1.6.0" ) // Ajoutez ou vérifiez la version d'appcompat
// Exemple de mise à jour

}
