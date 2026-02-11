package org.elegantobjects.jpages.messages;

import java.io.InputStream;
import java.io.IOException;
import java.net.Socket;

public final class HttpRequest implements Request {
  private final InputStream sticky;
  private final RequestLine line;
  private final Headers headers;
  private final Body body;

  public HttpRequest(final Socket socket) throws IOException {
    this(new StickyInputStream(socket.getInputStream()));
  }

  HttpRequest(final InputStream stream) {
    this.sticky = stream;
    this.line = new HttpRequestLine(this.sticky);
    this.headers = new HttpHeaders(this.sticky);
    this.body = new HttpBody(this.sticky);
  }

  public RequestLine requestLine() {
    return this.line;
  }

  public Headers headers() {
    return this.headers;
  }

  public Body body() {
    return this.body;
  }

  public void close() throws IOException {
    this.sticky.close();
  }
}
