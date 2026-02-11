package org.elegantobjects.jpages.messages;

import java.io.IOException;
import java.io.InputStream;

public interface Body {
  InputStream stream() throws IOException;
}
