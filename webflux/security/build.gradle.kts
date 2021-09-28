plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    api(project(":core"))
    api(project(":webflux:core"))
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
}