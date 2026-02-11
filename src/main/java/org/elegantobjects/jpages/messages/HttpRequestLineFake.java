package org.elegantobjects.jpages.messages;

public final class HttpRequestLineFake implements RequestLine {
  private final String method;
  private final String path;
  private final String query;
  private final String protocol;

  public HttpRequestLineFake() {
    this("GET", "/", "", "HTTP/1.1");
  }

  public HttpRequestLineFake(
      final String mtd,
      final String pth,
      final String qry,
      final String ptl) {
    this.method = mtd;
    this.path = pth;
    this.query = qry;
    this.protocol = ptl;
  }

  @Override
  public Method method() {
    return () -> this.method;
  }

  @Override
  public Uri uri() {
    return new Uri() {
      @Override
      public Path path() {
        return () -> HttpRequestLineFake.this.path;
      }

      @Override
      public Query query() {
        return () -> HttpRequestLineFake.this.query;
      }
    };
  }

  @Override
  public Protocol protocol() {
    return () -> this.protocol;
  }
}
