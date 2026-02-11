package org.elegantobjects.jpages.messages;

final class HttpUri implements Uri {
  private final FirstLine origin;

  public HttpUri(final FirstLine origin) {
    this.origin = origin;
  }

  @Override
  public Path path() {
    return new HttpPath(new HttpRawUri(this.origin));
  }

  @Override
  public Query query() {
    return new HttpQuery(new HttpRawUri(this.origin));
  }
}
