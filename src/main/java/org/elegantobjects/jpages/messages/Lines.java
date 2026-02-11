package org.elegantobjects.jpages.messages;

import java.io.InputStream;
import java.util.Iterator;

public final class Lines implements Iterable<String> {
  private final InputStream source;

  public Lines(final InputStream src) {
    this.source = src;
  }

  @Override
  public Iterator<String> iterator() {
    // Logic to read the stream line by line until an empty line is reached
    // Using a Scanner or a custom CRLF reader
    return new HttpLinesIterator(this.source);
  }
}
