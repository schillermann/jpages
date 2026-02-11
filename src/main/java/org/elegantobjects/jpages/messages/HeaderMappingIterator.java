package org.elegantobjects.jpages.messages;

import java.util.Iterator;

public final class HeaderMappingIterator implements Iterator<Header> {
  private final Iterator<String> origin;

  public HeaderMappingIterator(final Iterator<String> lines) {
    this.origin = lines;
  }

  @Override
  public boolean hasNext() {
    return this.origin.hasNext();
  }

  @Override
  public HttpHeader next() {
    return new HttpHeader(this.origin.next());
  }
}
