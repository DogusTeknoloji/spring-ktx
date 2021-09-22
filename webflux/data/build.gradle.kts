plugins {
    `java-library`
    kotlin("jvm")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    implementation(project(":core"))
    implementation(project(":webflux:core"))
    compileOnly("org.springframework.boot:spring-boot-starter-data-r2dbc")
    compileOnly("io.r2dbc:r2dbc-postgresql")
}