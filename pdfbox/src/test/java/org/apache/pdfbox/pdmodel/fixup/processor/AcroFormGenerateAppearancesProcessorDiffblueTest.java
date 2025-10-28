package org.apache.pdfbox.pdmodel.fixup.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.junit.jupiter.api.Test;

class AcroFormGenerateAppearancesProcessorDiffblueTest {
  /**
   * Method under test: {@link AcroFormGenerateAppearancesProcessor#process()}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    AcroFormGenerateAppearancesProcessor acroFormGenerateAppearancesProcessor = new AcroFormGenerateAppearancesProcessor(
        new PDDocument(streamCacheCreateFunction));

    // Act
    acroFormGenerateAppearancesProcessor.process();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(acroFormGenerateAppearancesProcessor.document.getDocumentCatalog().getAcroForm());
  }

  /**
   * Method under test: {@link AcroFormGenerateAppearancesProcessor#process()}
   */
  @Test
  void testProcess2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    AcroFormGenerateAppearancesProcessor acroFormGenerateAppearancesProcessor = new AcroFormGenerateAppearancesProcessor(
        document);

    // Act
    acroFormGenerateAppearancesProcessor.process();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(acroFormGenerateAppearancesProcessor.document.getDocumentCatalog().getAcroForm());
  }

  /**
   * Method under test: {@link AcroFormGenerateAppearancesProcessor#process()}
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
    AcroFormGenerateAppearancesProcessor acroFormGenerateAppearancesProcessor = new AcroFormGenerateAppearancesProcessor(
        document);

    // Act
    acroFormGenerateAppearancesProcessor.process();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = acroFormGenerateAppearancesProcessor.document.getDocumentCatalog()
        .getAcroForm()
        .getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }
}
