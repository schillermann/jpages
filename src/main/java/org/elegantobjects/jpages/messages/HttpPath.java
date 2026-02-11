package org.elegantobjects.jpages.messages;

public final class HttpPath implements Path {
  private final RawUri uri;

  public HttpPath(final RawUri raw) {
    this.uri = raw;
  }

  @Override
  public String string() {
    final String text = this.uri.text();
    final int pos = text.indexOf('?');
    final String res;
    if (pos >= 0) {
      res = text.substring(0, pos);
    } else {
      res = text;
    }
    return res;
  }
}
