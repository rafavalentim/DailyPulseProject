

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMutltiplatformPlugin)
    alias(libs.plugins.compose.compiler)
}

kotlin{

    js(IR){
        browser{
            commonWebpackConfig {
                outputFileName = "DailyPulse.js"
            }
        }
        binaries.executable()
    }

    sourceSets{
        jsMain.dependencies {
            implementation(project(":shared"))
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.ui)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(libs.koin.core)
        }
    }
}

compose.experimental {
   // web.application
}

