package org.elegantobjects.jpages.messages;

public final class HttpProtocol implements Protocol {
  private final FirstLine line;

  public HttpProtocol(final FirstLine origin) {
    this.line = origin;
  }

  @Override
  public String string() {
    return new HttpPartAt(this.line.string(), 2).text();
  }
}
