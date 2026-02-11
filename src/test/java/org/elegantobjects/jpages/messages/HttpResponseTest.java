package org.elegantobjects.jpages.messages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.elegantobjects.jpages.Page;
import org.elegantobjects.jpages.Output;
import org.elegantobjects.jpages.SimpleOutput;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class HttpResponseTest {

  @Test
  public void testWorks() throws Exception {
    final Request request = new HttpRequestFake();
    final List<List<String>> headers = new ArrayList<>();
    Page page = new HttpResponse(request).target(
        new Page() {
          @Override
          public Page header(final String key, final String value) {
            headers.add(Arrays.asList(key, value));
            return this;
          }

          @Override
          public Output output(final Output output) {
            return output.extension("Content-Type", "text/plain")
                .extension("Content-Length", "13")
                .extension("JPages-Body", "Hello, world!");
          }
        });

    final Output output = page.output(new SimpleOutput(""));
    MatcherAssert.assertThat(
        output.toString(),
        Matchers.containsString("HTTP/1.1 200 OK\r\n"));
  }

}
