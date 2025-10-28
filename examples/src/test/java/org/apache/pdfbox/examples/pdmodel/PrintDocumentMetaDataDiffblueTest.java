package org.apache.pdfbox.examples.pdmodel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.junit.jupiter.api.Test;

class PrintDocumentMetaDataDiffblueTest {
  /**
   * Method under test: {@link PrintDocumentMetaData#printMetadata(PDDocument)}
   */
  @Test
  void testPrintMetadata() throws IOException {
    // Arrange
    PrintDocumentMetaData printDocumentMetaData = new PrintDocumentMetaData();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    printDocumentMetaData.printMetadata(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PrintDocumentMetaData#printMetadata(PDDocument)}
   */
  @Test
  void testPrintMetadata2() throws IOException {
    // Arrange
    PrintDocumentMetaData printDocumentMetaData = new PrintDocumentMetaData();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.setDocumentInformation(new PDDocumentInformation());

    // Act
    printDocumentMetaData.printMetadata(document);

    // Assert
    verify(streamCacheCreateFunction).create();
  }
}
