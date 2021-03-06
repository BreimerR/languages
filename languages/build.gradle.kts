val jvmTarget: String by project
val libraryGroup: String by project
val libraryVersion: String by project

plugins {
    kotlin("multiplatform")
    `maven-publish`
}

group = libraryGroup
version = libraryVersion




kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = jvmTarget
            tasks {
                named<Jar>("jvmJar") {
                    archiveBaseName.set("language")
                }
            }
        }
        testRuns["test"].executionTask.configure {
            useTestNG()
        }
    }
    js(IR) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }


    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("kotlinx:strings:1.0")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }
}


val commonVariant by configurations.creating {
    isCanBeConsumed = true
}