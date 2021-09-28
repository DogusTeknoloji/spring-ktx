plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    api(project(":core"))
    api(project(":webflux:core"))
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("io.r2dbc:r2dbc-postgresql")
}
