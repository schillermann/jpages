package org.elegantobjects.jpages.messages;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class StickyInputStream extends InputStream {
  private final InputStream origin;
  private final ByteArrayOutputStream cache = new ByteArrayOutputStream();
  private int position = 0;

  public StickyInputStream(final InputStream stream) {
    this.origin = stream;
  }

  @Override
  public int read() throws IOException {
    final byte[] data = this.cache.toByteArray();
    final int result;
    if (this.position < data.length) {
      // We have this byte in the cache, return it
      result = data[this.position] & 0xFF;
    } else {
      // We need to pull a new byte from the socket
      result = this.origin.read();
      if (result != -1) {
        this.cache.write(result);
      }
    }
    if (result != -1) {
      this.position++;
    }
    return result;
  }

  @Override
  public synchronized void reset() {
    this.position = 0; // "Rewind" without losing the cache
  }
}
