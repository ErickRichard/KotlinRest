import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.1"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "br.itau"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	//Spring
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	//kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	//mapper
	implementation("com.github.dozermapper:dozer-core:6.5.2")
	//fasterxml
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	//Spring doc openAPI
	implementation("org.springdoc:springdoc-openapi-data-rest:1.6.9")
	implementation("org.springdoc:springdoc-openapi-ui:1.6.9")
	implementation("org.springdoc:springdoc-openapi-kotlin:1.6.9")
	implementation("com.opencsv:opencsv:5.6")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
	//hateoas
	implementation("org.springframework.boot:spring-boot-starter-hateoas")
	//jwt
	implementation("com.auth0:auth0:1.42.0")
	implementation("com.auth0:java-jwt:4.0.0")
	//test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testImplementation("org.mockito:mockito-core:4.6.1")
	testImplementation("io.rest-assured:rest-assured:4.5.1")
	//conexoes
	runtimeOnly("mysql:mysql-connector-java")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.testcontainers:mysql:1.17.3")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
