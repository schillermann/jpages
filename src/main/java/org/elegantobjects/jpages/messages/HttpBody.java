package org.elegantobjects.jpages.messages;

import java.io.InputStream;
import java.io.IOException;

public final class HttpBody implements Body {
  private final InputStream origin;

  public HttpBody(final InputStream stream) {
    this.origin = stream;
  }

  @Override
  public InputStream stream() throws IOException {
    this.origin.reset();
    return new PayloadStream(this.origin);
  }
}
