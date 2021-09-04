import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.net.URI

plugins {
    `java-library`
    `maven-publish`
    signing
    kotlin("jvm") version "1.5.30"
}

group = "io.github.daniel-tucano"
version = "0.2.2"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

java {
    withJavadocJar()
    withSourcesJar()
}

val ossrhUsername: String by project
val ossrhPassword: String by project

publishing {
    publications {
        create<MavenPublication>("mavenKotlin") {
            artifactId = "matplotlib4k"
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }

            pom {
                name.set("matplotlib4k")
                description.set("Matplotlib for kotlin: A simple graph plot library for kotlin with powerful python matplotlib")
                url.set("https://github.com/daniel-tucano/matplotlib4k")

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set("daniel-tucano")
                        name.set("Daniel Ribeiro Santiago")
                        email.set("daanrsantiago@gmail.com")
                    }
                }
                scm {
                    url.set("https://github.com/daniel-tucano/matplotlib4k")
                }
            }
        }
    }
    repositories {
        maven {
            // change URLs to point to your repos, e.g. http://my.org/repo
            val releasesRepoUrl = URI("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            val snapshotsRepoUrl = URI("https://s01.oss.sonatype.org/content/repositories/snapshots/")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl

            credentials {
                username = ossrhUsername
                password = ossrhPassword
            }
        }
    }
}

signing {
    sign(publishing.publications["mavenKotlin"])
}

dependencies {
    implementation("com.google.guava:guava:15.0")
    implementation("org.slf4j:slf4j-api:1.7.7")
    implementation("org.slf4j:slf4j-log4j12:1.7.7")
    implementation("log4j:log4j:1.2.17")
    implementation("space.kscience:kmath-ejml:0.2.1")
    implementation("org.ejml:ejml-simple:0.41")

    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.0")
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
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
