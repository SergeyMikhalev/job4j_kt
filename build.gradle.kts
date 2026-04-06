plugins {
    kotlin("jvm") version "2.0.0"
    id("io.gitlab.arturbosch.detekt") version "1.23.6"
}

group = "ru.job4j"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.assertj:assertj-core:3.24.2")
    implementation("org.junit.jupiter:junit-jupiter-engine:5.10.1")

    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.1")
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
}

detekt {
    toolVersion = "1.23.6" // Версия Detekt
    config = files("$projectDir/config/detekt/detekt.yml")
    buildUponDefaultConfig = true // Настройки будут расширять дефолтный конфиг Detekt
    allRules = false // Использовать только правила, указанные в конфиге
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt> {
    reports {
        html.required.set(true) // Отчет в формате HTML
        xml.required.set(true)  // Отчет в формате XML
        txt.required.set(false) // Текстовый отчет
    }
}

tasks.test {
    useJUnitPlatform()
}