package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.junit.jupiter.api.Test;

class ImportFDFDiffblueTest {
  /**
   * Method under test: {@link ImportFDF#importFDF(PDDocument, FDFDocument)}
   */
  @Test
  void testImportFDF() throws IOException {
    // Arrange
    ImportFDF importFDF = new ImportFDF();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument pdfDocument = new PDDocument(streamCacheCreateFunction);

    // Act
    importFDF.importFDF(pdfDocument, new FDFDocument());

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(pdfDocument.getDocumentCatalog().getAcroForm());
  }
}
