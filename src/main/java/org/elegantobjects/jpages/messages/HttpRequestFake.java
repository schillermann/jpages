package org.elegantobjects.jpages.messages;

public final class HttpRequestFake implements Request {
  private final RequestLine line;
  private final Headers headers;
  private final Body body;

  public HttpRequestFake() {
    this("GET", "/", "", "HTTP/1.1");
  }

  public HttpRequestFake(
      final String method,
      final String path,
      final String query,
      final String protocol) {
    this(
        new HttpRequestLineFake(method, path, query, protocol),
        new HttpHeadersFake(),
        new HttpBodyFake()
    );
  }

  public HttpRequestFake(
      final RequestLine request,
      final Headers all,
      final Body payload) {
    this.line = request;
    this.headers = all;
    this.body = payload;
  }

  @Override
  public RequestLine requestLine() {
    return this.line;
  }

  @Override
  public Headers headers() {
    return this.headers;
  }

  @Override
  public Body body() {
    return this.body;
  }

  @Override
  public void close() {
    // Nothing to close in the fake.
  }
}
