package org.elegantobjects.jpages.messages;

public final class HttpRawUri implements RawUri {
  private final FirstLine origin;

  public HttpRawUri(final FirstLine line) {
    this.origin = line;
  }

  @Override
  public String text() {
    return new HttpPartAt(this.origin.string(), 1).text();
  }
}
