plugins {
	java
	id("org.springframework.boot") version "3.3.1"
	id("io.spring.dependency-management") version "1.1.5"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencyManagement {
	imports {
		mavenBom("io.opentelemetry.instrumentation:opentelemetry-instrumentation-bom-alpha:2.5.0-alpha")
		mavenBom("io.opentelemetry:opentelemetry-bom:1.40.0")
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("io.opentelemetry.instrumentation:opentelemetry-spring-boot-starter")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
