package org.elegantobjects.jpages.messages;

import java.io.InputStream;
import java.io.IOException;

public final class HttpFirstLine implements FirstLine {
  private final InputStream source;

  public HttpFirstLine(final InputStream src) {
    this.source = src;
  }

  @Override
  public String string() {
    try {
      this.source.reset();
      return new HttpNextLine(this.source).string();
    } catch (IOException ex) {
      throw new IllegalStateException(ex);
    }
  }
}
