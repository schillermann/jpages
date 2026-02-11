package org.elegantobjects.jpages.messages;

import java.io.InputStream;
import java.io.IOException;

/**
 * Its only job is to consume bytes from the source until it passes the double
 * CRLF (\r\n\r\n), then step aside.
 */
public final class PayloadStream extends InputStream {
  private final InputStream source;
  private boolean skipped = false;

  public PayloadStream(final InputStream src) {
    this.source = src;
  }

  @Override
  public int read() throws IOException {
    if (!this.skipped) {
      new SkipHeaderLogic(this.source).apply();
      this.skipped = true;
    }
    return this.source.read();
  }
}
