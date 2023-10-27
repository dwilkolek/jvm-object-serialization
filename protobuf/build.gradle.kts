plugins {
    id("java")
    id("com.google.protobuf") version "0.9.4"
}

group = "eu.wilkolek.protobuf"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("com.google.protobuf:protobuf-java:3.24.0")
}
protobuf{
    protoc {artifact = "com.google.protobuf:protoc:3.24.0"}
    generateProtoTasks{
        plugins {
             java
        }
    }
    // default proto plugin generate stub in build folder
    // change the stub generate folder
    //  generatedFilesBaseDir = "$projectDir/src/generated"
}