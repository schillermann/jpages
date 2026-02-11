package org.elegantobjects.jpages.messages;

import java.io.Closeable;

public interface Request extends Closeable {
  RequestLine requestLine();

  Headers headers();

  Body body();
}
