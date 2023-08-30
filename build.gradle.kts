plugins {
    id("java")
}

group = "com.patres.messanger"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.13.4.1")
    implementation ("jakarta.persistence:jakarta.persistence-api:3.0.0")
//    implementation ("org.hibernate:hibernate-core:5.6.3.Final")
    implementation ("log4j:log4j:1.2.17")
    implementation ("org.postgresql:postgresql:42.3.8")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa:3.1.3")
    implementation ("org.springframework.boot:spring-boot-starter-web:3.1.3")
    implementation ("org.apache.commons:commons-text:1.10.0")



    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}