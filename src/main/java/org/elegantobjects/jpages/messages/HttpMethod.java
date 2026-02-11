package org.elegantobjects.jpages.messages;

public final class HttpMethod implements Method {
  private final FirstLine line;

  public HttpMethod(final FirstLine origin) {
    this.line = origin;
  }

  @Override
  public String string() {
    return new HttpPartAt(this.line.string(), 0).text();
  }
}
