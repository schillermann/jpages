package org.elegantobjects.jpages.messages;

import org.elegantobjects.jpages.Page;

public final class HttpResponse implements Response {
  private final Request request;

  public HttpResponse(final Request request) {
    this.request = request;
  }

  @Override
  public Page target(final Page page) {
    Page target = page;
    target = target.header("JPages-Method",
        this.request.requestLine().method().string());
    final Uri uri = this.request.requestLine().uri();
    target = target.header("JPages-Path", uri.path().string());
    target = target.header("JPages-Query", uri.query().string());
    target = target.header("JPages-Method",
        this.request.requestLine().protocol().string());

    for (final Header header : this.request.headers()) {
      target = target.header(header.name(), header.value());
    }

    return target;
  }
}
