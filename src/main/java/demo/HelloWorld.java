/*
 * Copyright (c) 2020, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package demo;

import static com.github.tonivade.zeromock.api.Handlers.ok;
import static com.github.tonivade.zeromock.api.Headers.contentPlain;
import static com.github.tonivade.zeromock.api.Matchers.get;
import static com.github.tonivade.zeromock.server.MockHttpServer.listenAt;

public class HelloWorld {
  public static void main(String[] args) {
    listenAt(8080)
        .when(get("/hello")).then(ok("Hello World!")
        .postHandle(contentPlain()))
        .start();
  }
}
