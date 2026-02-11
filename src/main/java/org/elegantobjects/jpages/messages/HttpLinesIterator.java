package org.elegantobjects.jpages.messages;

import java.io.InputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class HttpLinesIterator implements Iterator<String> {
  private final InputStream source;
  private String cache;
  private boolean dead = false;

  HttpLinesIterator(final InputStream src) {
    this.source = src;
  }

  @Override
  public boolean hasNext() {
    if (this.cache == null && !this.dead) {
      this.cache = new HttpNextLine(this.source).string();
      if (this.cache.isEmpty()) {
        this.dead = true;
      }
    }
    return !this.dead || this.cache != null;
  }

  @Override
  public String next() {
    if (!this.hasNext()) {
      throw new NoSuchElementException();
    }
    final String res = this.cache;
    this.cache = null;
    return res;
  }
}
