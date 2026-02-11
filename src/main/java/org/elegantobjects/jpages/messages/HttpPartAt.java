package org.elegantobjects.jpages.messages;

public final class HttpPartAt implements PartAt {
  private final String raw;
  private final int index;

  public HttpPartAt(final String text, final int pos) {
    this.raw = text;
    this.index = pos;
  }

  @Override
  public String text() {
    final String[] parts = this.raw.split(" ");
    if (this.index >= parts.length) {
      throw new IllegalStateException(
          String.format("Invalid request line: %s", this.raw));
    }
    return parts[this.index];
  }
}
