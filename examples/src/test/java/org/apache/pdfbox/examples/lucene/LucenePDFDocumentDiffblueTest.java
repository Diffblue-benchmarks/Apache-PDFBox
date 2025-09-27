package org.apache.pdfbox.examples.lucene;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LucenePDFDocumentDiffblueTest {
  /**
   * Test {@link LucenePDFDocument#createUID(URL, long)} with {@code url}, {@code time}.
   *
   * <p>Method under test: {@link LucenePDFDocument#createUID(URL, long)}
   */
  @Test
  @DisplayName("Test createUID(URL, long) with 'url', 'time'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LucenePDFDocument.createUID(URL, long)"})
  void testCreateUIDWithUrlTime() throws MalformedURLException {
    // Arrange, Act and Assert
    assertEquals(
        "file:\u0000tmp\u0000test.txt\u0000\u000019700101000000",
        LucenePDFDocument.createUID(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(), 10L));
  }
}
