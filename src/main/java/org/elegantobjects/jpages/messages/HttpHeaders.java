package org.elegantobjects.jpages.messages;

import java.io.InputStream;
import java.io.IOException;
import java.util.Iterator;

public final class HttpHeaders implements Headers {
  private final InputStream origin;

  public HttpHeaders(final InputStream stream) {
    this.origin = stream;
  }

  @Override
  public Iterator<Header> iterator() {
    try {
      this.origin.reset();
      return new HeaderMappingIterator(
          new FilteredHeaders(
              new Lines(this.origin)).iterator());
    } catch (IOException ex) {
      throw new IllegalStateException(ex);
    }
  }
}
