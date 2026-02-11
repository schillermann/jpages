package org.elegantobjects.jpages.messages;

import java.util.Iterator;

public final class FilteredHeaders implements Iterable<String> {
  private final Iterable<String> origin;

  public FilteredHeaders(final Iterable<String> lines) {
    this.origin = lines;
  }

  @Override
  public Iterator<String> iterator() {
    final Iterator<String> it = this.origin.iterator();
    if (it.hasNext()) {
      it.next(); // Skip the Request-Line
    }
    return it;
  }
}
