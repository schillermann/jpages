package org.elegantobjects.jpages.messages;

public final class HttpHeader implements Header {
  private final String line;

  public HttpHeader(final String text) {
    this.line = text;
  }

  @Override
  public String name() {
    return new Trimmed(
        new PartBefore(this.line, ":")).string();
  }

  @Override
  public String value() {
    return new Trimmed(
        new PartAfter(this.line, ":")).string();
  }
}
