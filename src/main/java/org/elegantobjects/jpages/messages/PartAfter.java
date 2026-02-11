package org.elegantobjects.jpages.messages;

public final class PartAfter implements Text {
  private final String raw;
  private final String delimiter;

  public PartAfter(final String text, final String del) {
    this.raw = text;
    this.delimiter = del;
  }

  @Override
  public String string() {
    final int idx = this.raw.indexOf(this.delimiter);
    final String res;
    if (idx >= 0) {
      res = this.raw.substring(idx + this.delimiter.length());
    } else {
      res = "";
    }
    return res;
  }
}
