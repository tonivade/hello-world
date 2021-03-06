import org.gradle.jvm.tasks.Jar

plugins {
    `java-library`
    id("org.mikeneck.graalvm-native-image") version "0.6.1"
}

repositories {
    mavenCentral()
}

dependencies {
    api("com.github.tonivade:zeromock-server:0.13.0")
}

val userHome = System.getProperty("user.home")

nativeImage {
    setGraalVmHome("$userHome/.sdkman/candidates/java/20.1.0.r8-grl")
    setMainClass("demo.HelloWorld")
    setExecutableName("hello-world")
}

tasks {
    "build" {
        dependsOn(fatJar)
        dependsOn(nativeImage)
    }
}

val fatJar = task("fatJar", type = Jar::class) {
    manifest {
        attributes["Main-Class"] = "demo.HelloWorld"
    }
    classifier = "all"
    from(configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    with(tasks["jar"] as CopySpec)
}
