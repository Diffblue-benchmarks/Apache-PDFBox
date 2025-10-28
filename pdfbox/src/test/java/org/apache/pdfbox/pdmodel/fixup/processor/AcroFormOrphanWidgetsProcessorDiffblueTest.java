package org.apache.pdfbox.pdmodel.fixup.processor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.junit.jupiter.api.Test;

class AcroFormOrphanWidgetsProcessorDiffblueTest {
  /**
   * Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    (new AcroFormOrphanWidgetsProcessor(new PDDocument(streamCacheCreateFunction))).process();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  void testProcess2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());

    // Act
    (new AcroFormOrphanWidgetsProcessor(document)).process();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  void testProcess3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    document.addSignature(new PDSignature());

    // Act
    (new AcroFormOrphanWidgetsProcessor(document)).process();

    // Assert
    verify(streamCacheCreateFunction).create();
  }
}
