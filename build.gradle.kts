plugins {
    `java-library`
    id("org.mikeneck.graalvm-native-image") version "0.5.0"
}

repositories {
    mavenCentral()
}

dependencies {
    api("com.github.tonivade:zeromock-server:0.12.0")
}

nativeImage {
    setGraalVmHome("/home/slimbook/.sdkman/candidates/java/20.1.0.r8-grl")
    setMainClass("demo.HelloWorld")
    setExecutableName("hello-world")
}
