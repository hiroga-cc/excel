buildscript {
    repositories {
        jcenter()
    }
    dependencies{
        classpath("org.jetbrains.kotlin","kotlin-gradle-plugin","1.3.61")
        classpath("com.github.jengelman.gradle.plugins","shadow","4.0.3")
    }
}

plugins {
    java
    kotlin("jvm") version "1.3.61"
    application
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

group = "cc.hiroga"
version = "1.0-SNAPSHOT"

application.mainClassName = "cc.hiroga.excel.ApplicationKt"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.github.ajalt","clikt","1.7.0")
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}