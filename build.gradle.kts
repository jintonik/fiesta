plugins {
	kotlin("jvm") version "2.0.20"
	kotlin("plugin.spring") version "2.0.20"
	kotlin("plugin.jpa") version "2.0.20"
	kotlin("plugin.allopen") version "2.0.20"
	id("org.springframework.boot") version "3.4.2"
	id("io.spring.dependency-management") version "1.1.7"
}

val jacksonVersion = "2.18.2"
val kotlinLoggingVersion = "7.0.3"
val kotlinJunitVersion = "2.1.0"

group = "org.kotlin"
version = "0.0.1"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("io.github.oshai:kotlin-logging-jvm:$kotlinLoggingVersion")

	runtimeOnly("org.postgresql:postgresql")
	runtimeOnly("org.springframework.boot:spring-boot-devtools")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:$kotlinJunitVersion")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.Embeddable")
	annotation("jakarta.persistence.MappedSuperclass")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
