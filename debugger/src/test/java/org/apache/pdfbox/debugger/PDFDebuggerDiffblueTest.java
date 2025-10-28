package org.apache.pdfbox.debugger;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.Test;

class PDFDebuggerDiffblueTest {
  /**
   * Method under test: {@link PDFDebugger#getPageLabel(PDDocument, int)}
   */
  @Test
  void testGetPageLabel() {
    // Arrange, Act and Assert
    assertNull(PDFDebugger.getPageLabel(new PDDocument(), 1));
  }

  /**
   * Method under test: {@link PDFDebugger#getPageLabel(PDDocument, int)}
   */
  @Test
  void testGetPageLabel2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualPageLabel = PDFDebugger.getPageLabel(new PDDocument(streamCacheCreateFunction), 1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPageLabel);
  }

  /**
   * Method under test: {@link PDFDebugger#getPageLabel(PDDocument, int)}
   */
  @Test
  void testGetPageLabel3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());

    // Act
    String actualPageLabel = PDFDebugger.getPageLabel(document, 1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPageLabel);
  }
}
