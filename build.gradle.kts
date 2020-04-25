plugins {
    java
    kotlin("jvm") version "1.3.61"
}

group = "cc.hiroga"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { setUrl("https://kotlin.bintray.com/kotlinx") }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.2.1")
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