plugins {
    `java-library`
    id("org.mikeneck.graalvm-native-image") version "0.5.0"
}

repositories {
    mavenCentral()
}

dependencies {
    api("com.github.tonivade:zeromock-server:0.12.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
}

nativeImage {
    setGraalVmHome("/home/slimbook/.sdkman/candidates/java/20.1.0.r8-grl")
    setMainClass("demo.HelloWorld")
    setExecutableName("hello-world")
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}
