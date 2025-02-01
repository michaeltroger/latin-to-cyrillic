import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.vanniktech.mavenPublish)
    alias(libs.plugins.kotlinx.binary.compatibility.validator)
}

group = "com.michaeltroger"
version = "1.1.0"

kotlin {
    explicitApi()
    compilerOptions {
        allWarningsAsErrors = true
    }

    tasks.withType<Jar>().configureEach {
        from("LICENSE") {
            into("META-INF")
        }
    }
    jvm {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(libs.kotlinx.coroutines.test)
            }
        }
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
    coordinates(groupId = group.toString(), artifactId = "latin-to-cyrillic", version = version.toString())

    pom {
        name = "Latin to Cyrillic Library"
        description = "A Kotlin Multiplatform Library for Latin to Cyrillic transliteration"
        inceptionYear = "2021"
        url = "https://github.com/michaeltroger/latin-to-cyrillic"
        licenses {
            license {
                name = "MIT"
                url = "https://opensource.org/license/mit"
                distribution = "repo"
            }
        }
        developers {
            developer {
                id = "michaeltroger"
                name = "Michael Troger"
                url = "https://michaeltroger.com"
            }
        }
        scm {
            url = "https://github.com/michaeltroger/latin-to-cyrillic"
            connection = "scm:git:git://github.com/michaeltroger/latin-to-cyrillic.git"
            developerConnection = "scm:git:ssh://git@github.com/michaeltroger/latin-to-cyrillic.git"
        }
    }
}
