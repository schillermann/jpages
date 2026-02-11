package org.elegantobjects.jpages.messages;

public interface RequestLine {
  Method method();

  Uri uri();

  Protocol protocol();
}
