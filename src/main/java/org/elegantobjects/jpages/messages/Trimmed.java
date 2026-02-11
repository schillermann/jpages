package org.elegantobjects.jpages.messages;

public final class Trimmed implements Text {
  private final Text origin;

  public Trimmed(final Text text) {
    this.origin = text;
  }

  @Override
  public String string() {
    return this.origin.string().trim();
  }
}
