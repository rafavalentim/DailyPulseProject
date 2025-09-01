import org.jetbrains.compose.compose
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("org.jetbrains.kotlin.native.cocoapods")
    id("org.jetbrains.kotlin.plugin.serialization") version "2.2.0"
    id("org.jetbrains.kotlin.plugin.compose") version "2.2.0"
    alias(libs.plugins.sqlDelight)
    alias (libs.plugins.compose)

}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_11)
                }
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    jvm("desktop")

    // aplica o -lsqlite3 a todos os binários nativos (inclui iOS)
    targets.withType<KotlinNativeTarget>().configureEach {
        binaries.all {
            linkerOpts("-lsqlite3")
        }
    }

    cocoapods {
        version = "2.2.0"
        summary = "Shared module"
        homepage = "https://yourdomain.com"
        ios.deploymentTarget = "16.1"

        // injeta no .podspec para que o Xcode linke sqlite3 também
        extraSpecAttributes["libraries"] = "sqlite3"

        framework {
            baseName = "shared"
            //export(project(":shared")) // ou use explicitamente export das libs
        }
    }

    sourceSets {
        commonMain.dependencies {


            //ktor
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)

            //coroutines
            implementation(libs.kotlinx.datetime)
            implementation(libs.sql.coroutines.extensions)
            implementation(libs.kotlinx.coroutines.core)

            //koin
            implementation(libs.koin.core)
            implementation(libs.koin.compose)


            //Compose multiplatform
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.material)
            implementation(compose.runtime)
            implementation(compose.components.resources)
            implementation(compose.materialIconsExtended)

            //Kamel (Questões de AsyncImages)
            implementation(libs.kamel.image)
            implementation(libs.kamel.image.default)

            //Voyager (Navegação entre telas)
            implementation(libs.voyager.navigator)
            implementation(libs.voyager.transitions)



        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        //Adicionando depenências específicas para o módulo Android
        androidMain.dependencies {
            implementation(libs.androidx.lifecycle.viewmodel.ktx)
            implementation(libs.ktor.client.android)
            implementation(libs.sql.android.driver)
        }

        //Adicionando dependências específicas para o módulo IOS
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
            implementation(libs.sql.native.driver)
        }

        val desktopMain by getting{
            dependencies {
                implementation(libs.ktor.client.cio)
                implementation(libs.sql.desktop.driver)
            }
        }

    }
}

android {
    namespace = "com.rafael.dailypulse"
    compileSdk = 36
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

sqldelight {
    databases {
        create(name = "DailyPulseDatabase") {
            packageName.set("com.rafael.dailypulse.db")
        }
    }
}
