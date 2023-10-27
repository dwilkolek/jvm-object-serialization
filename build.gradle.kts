plugins {
    id("java")
    kotlin("jvm") version "1.8.21"
    id("org.springframework.boot") version "3.1.3"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("plugin.spring") version "1.8.21"
}

group = "eu.wilkolek"
version = "1.0-SNAPSHOT"


java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    jvmToolchain(17)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":protobuf"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("com.esotericsoftware:kryo:5.5.0")
    implementation("com.google.protobuf:protobuf-kotlin:3.24.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}