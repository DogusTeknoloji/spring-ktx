import org.jetbrains.kotlin.utils.alwaysTrue

plugins {
    `java-library`
    `maven-publish`
    `kotlin-dsl`
    kotlin("jvm") version "1.5.31" apply false
    id("org.springframework.boot") version "2.4.5" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
    id("org.jetbrains.dokka") version "1.5.30"
}

group = "com.dteknoloji"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}

configure(subprojects.filter { it.name != "webflux" }) {
    apply(plugin = "java-library")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "maven-publish")
    apply(plugin = "org.jetbrains.dokka")
    apply(plugin = "org.springframework.boot")

    java {
        withSourcesJar()
        targetCompatibility = JavaVersion.VERSION_11
        sourceCompatibility = JavaVersion.VERSION_11
    }

    publishing {
        publications {
            create<MavenPublication>(project.name) {
                print(createArtifactName())
                artifactId = project.name
                groupId = rootProject.group.toString()
                version = rootProject.version.toString()
                from(components["java"])
            }
        }
    }

    dependencies {
        dokkaHtmlPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.5.30")
    }

    tasks {
        jar {
            enabled = true
        }

        findByName("bootJar")?.enabled = false

        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict", "-Xopt-in=kotlin.RequiresOptIn")
                jvmTarget = "11"
            }
        }

        withType<Test> {
            useJUnitPlatform()
        }
    }
}

fun Project.createArtifactName() = if(parent != rootProject) "${rootProject.name}-${parent?.name}-$name" else "${rootProject.name}-$name"
