package org.elegantobjects.jpages.messages;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public final class HttpBodyFake implements Body {
  private final byte[] content;

  public HttpBodyFake() {
    this(new byte[0]);
  }

  public HttpBodyFake(final String text) {
    this(text.getBytes(StandardCharsets.UTF_8));
  }

  public HttpBodyFake(final byte[] bytes) {
    this.content = bytes.clone();
  }

  @Override
  public InputStream stream() {
    return new ByteArrayInputStream(this.content);
  }
}
