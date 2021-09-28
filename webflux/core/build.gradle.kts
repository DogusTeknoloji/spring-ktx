plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    api(project(":core"))
    api("org.jetbrains.kotlin:kotlin-reflect")
    api("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    api("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8")
    api("io.projectreactor.kotlin:reactor-kotlin-extensions")
}