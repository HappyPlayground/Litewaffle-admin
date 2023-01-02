import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
}

group = "com.github.sapokr"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib:1.6.0")
    compileOnly("org.spigotmc:spigot-api:1.17.1-R0.1-SNAPSHOT")
    compileOnly("net.dv8tion:JDA:5.0.0-alpha.4") {
        exclude("opus-java")
    }
    compileOnly(files("libs/LiteWaffle-0.1.jar"))
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_16.toString()
    }
}