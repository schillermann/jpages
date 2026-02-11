package org.elegantobjects.jpages.messages;

public final class HttpQuery implements Query {
  private final RawUri uri;

  public HttpQuery(final RawUri raw) {
    this.uri = raw;
  }

  @Override
  public String string() {
    final String text = this.uri.text();
    final int pos = text.indexOf('?');
    final String res;
    if (pos >= 0) {
      res = text.substring(pos + 1);
    } else {
      res = "";
    }
    return res;
  }
}
