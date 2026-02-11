package org.elegantobjects.jpages.messages;

import java.io.InputStream;
import java.io.IOException;

public final class SkipHeaderLogic {
  private final InputStream stream;

  public SkipHeaderLogic(final InputStream src) {
    this.stream = src;
  }

  public void apply() throws IOException {
    int cursor = 0;
    final int[] pattern = { '\r', '\n', '\r', '\n' };
    int b = this.stream.read();
    while (b != -1) {
      if (b == pattern[cursor]) {
        cursor++;
        if (cursor == pattern.length) {
          break;
        }
      } else {
        cursor = (b == pattern[0]) ? 1 : 0;
      }
      b = this.stream.read();
    }
  }
}
