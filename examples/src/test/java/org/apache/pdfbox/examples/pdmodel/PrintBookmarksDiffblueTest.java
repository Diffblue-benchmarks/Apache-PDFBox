package org.apache.pdfbox.examples.pdmodel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;
import org.junit.jupiter.api.Test;

class PrintBookmarksDiffblueTest {
  /**
   * Method under test:
   * {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}
   */
  @Test
  void testPrintBookmark() throws IOException {
    // Arrange
    PrintBookmarks printBookmarks = new PrintBookmarks();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    printBookmarks.printBookmark(document, new PDDocumentOutline(), "Indentation");

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}
   */
  @Test
  void testPrintBookmark2() throws IOException {
    // Arrange
    PrintBookmarks printBookmarks = new PrintBookmarks();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    PDDocumentOutline bookmark = new PDDocumentOutline();
    bookmark.addLast(new PDOutlineItem());

    // Act
    printBookmarks.printBookmark(document, bookmark, "Indentation");

    // Assert
    verify(streamCacheCreateFunction).create();
  }
}
