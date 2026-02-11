package org.elegantobjects.jpages.messages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class HttpHeadersFake implements Headers {
  private final List<Header> origin;

  public HttpHeadersFake() {
    this(Collections.emptyList());
  }

  public HttpHeadersFake(final Iterable<Header> headers) {
    final List<Header> list = new ArrayList<>();
    for (final Header header : headers) {
      list.add(header);
    }
    this.origin = list;
  }

  @Override
  public Iterator<Header> iterator() {
    return this.origin.iterator();
  }
}
