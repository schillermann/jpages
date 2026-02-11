package org.elegantobjects.jpages.messages;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class HttpNextLine {
  private final InputStream origin;

  public HttpNextLine(final InputStream stream) {
    this.origin = stream;
  }

  public String string() {
    try {
      final ByteArrayOutputStream baos = new ByteArrayOutputStream();
      int b;
      while ((b = this.origin.read()) != -1) {
        if (b == '\r') {
          int next = this.origin.read();
          if (next == '\n') {
            break;
          }
          baos.write(b);
          baos.write(next);
        } else {
          baos.write(b);
        }
      }
      return baos.toString("UTF-8");
    } catch (IOException ex) {
      throw new IllegalStateException(ex);
    }
  }
}
