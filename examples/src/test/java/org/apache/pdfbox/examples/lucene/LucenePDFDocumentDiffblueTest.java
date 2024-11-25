package org.apache.pdfbox.examples.lucene;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LucenePDFDocumentDiffblueTest {
  /**
   * Test {@link LucenePDFDocument#createUID(File)} with {@code file}.
   * <p>
   * Method under test: {@link LucenePDFDocument#createUID(File)}
   */
  @Test
  @DisplayName("Test createUID(File) with 'file'")
  void testCreateUIDWithFile() {
    // Arrange, Act and Assert
    assertEquals("C:\u0000Users\u0000JBARRI~1\u0000AppData\u0000Local\u0000Temp\u0000test.txt\u000020241119132931",
        LucenePDFDocument.createUID(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }

  /**
   * Test {@link LucenePDFDocument#createUID(URL, long)} with {@code url},
   * {@code time}.
   * <p>
   * Method under test: {@link LucenePDFDocument#createUID(URL, long)}
   */
  @Test
  @DisplayName("Test createUID(URL, long) with 'url', 'time'")
  void testCreateUIDWithUrlTime() throws MalformedURLException {
    // Arrange, Act and Assert
    assertEquals("file:/C:/Users/JBARRI~1/AppData/Local/Temp/test.txt\u000019700101000000",
        LucenePDFDocument.createUID(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(), 10L));
  }
}
