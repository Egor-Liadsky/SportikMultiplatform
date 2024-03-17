import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    id("kotlinx-serialization")
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.buildKonfig)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "composeApp"
        browser {
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(project.projectDir.path)
                    }
                }
            }
        }
        binaries.executable()
    }

    jvm("desktop")
    
    sourceSets {
        val desktopMain by getting
        
        commonMain.dependencies {

            implementation(libs.decompose)
            implementation(libs.decompose.compose)
            implementation(libs.koin.compose)
            implementation(libs.bundles.ktor.common)

            implementation(libs.kotlinx.coroutines)
            implementation(libs.coil)

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.ktor.client.java)
        }
        val wasmJsMain by getting {
            dependencies {
                implementation(libs.ktor.client.js)
            }
        }
    }
}

buildkonfig {
    packageName = "com.lyadsky.sportik"

    defaultConfigs {
        buildConfigField(Type.STRING, "BASE_URL", "http://localhost:8086/api/")
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.lyadsky.sportik"
            packageVersion = "1.0.0"
        }
    }
}
