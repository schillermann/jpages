package org.elegantobjects.jpages.messages;

import java.io.InputStream;

public final class HttpRequestLine implements RequestLine {
  private final InputStream origin;

  public HttpRequestLine(final InputStream stream) {
    this.origin = stream;
  }

  @Override
  public Method method() {
    return new HttpMethod(new HttpFirstLine(this.origin));
  }

  @Override
  public Uri uri() {
    return new HttpUri(new HttpFirstLine(this.origin));
  }

  @Override
  public Protocol protocol() {
    return new HttpProtocol(new HttpFirstLine(this.origin));
  }
}
