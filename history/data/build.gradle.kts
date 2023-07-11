plugins {
    id("java-library")
    alias(libs.plugins.org.jetbrains.kotlin.jvm)
    id("org.jlleitschuh.gradle.ktlint")
    id("io.gitlab.arturbosch.detekt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

ktlint {
    version.set("0.49.1")
    android.set(true)
}

detekt {
    config.setFrom("$projectDir/detekt.yml")
}

dependencies {
    implementation(project(":history-domain"))
    implementation(project(":architecture-domain"))

    implementation(project(":datasource-architecture"))
    implementation(project(":datasource-source"))

    implementation(libs.kotlinx.coroutines.core)

    testImplementation(libs.test.junit)
    testImplementation(libs.test.mockito)
    testImplementation(libs.test.mockito.kotlin)
    testImplementation(libs.test.hamcrest)
}
