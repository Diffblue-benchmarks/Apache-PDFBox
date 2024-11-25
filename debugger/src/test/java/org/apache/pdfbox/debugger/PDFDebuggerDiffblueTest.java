package org.apache.pdfbox.debugger;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFDebuggerDiffblueTest {
  /**
   * Test {@link PDFDebugger#getPageLabel(PDDocument, int)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFDebugger#getPageLabel(PDDocument, int)}
   */
  @Test
  @DisplayName("Test getPageLabel(PDDocument, int); given PDPage()")
  void testGetPageLabel_givenPDPage() throws IOException {
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

  /**
   * Test {@link PDFDebugger#getPageLabel(PDDocument, int)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument(StreamCacheCreateFunction)} with
   * {@link StreamCacheCreateFunction}.</li>
   *   <li>Then calls {@link StreamCacheCreateFunction#create()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFDebugger#getPageLabel(PDDocument, int)}
   */
  @Test
  @DisplayName("Test getPageLabel(PDDocument, int); when PDDocument(StreamCacheCreateFunction) with StreamCacheCreateFunction; then calls create()")
  void testGetPageLabel_whenPDDocumentWithStreamCacheCreateFunction_thenCallsCreate() throws IOException {
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
   * Test {@link PDFDebugger#getPageLabel(PDDocument, int)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFDebugger#getPageLabel(PDDocument, int)}
   */
  @Test
  @DisplayName("Test getPageLabel(PDDocument, int); when PDDocument(); then return 'null'")
  void testGetPageLabel_whenPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PDFDebugger.getPageLabel(new PDDocument(), 1));
  }
}
