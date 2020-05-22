# Hello World!

This is a example application to test native image

Install sdkman, and then install graalvm:

```shell
$ curl -s "https://get.sdkman.io" | bash
$ sdk install java 20.1.0.r8-grl
```

And then, build the native image:

```shell
$ ./gradlew clean nativeImage
$ ./build/native-image/hello-world
```

Java 8 is required also.