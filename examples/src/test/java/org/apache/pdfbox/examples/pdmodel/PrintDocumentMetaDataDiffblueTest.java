package org.apache.pdfbox.examples.pdmodel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.GregorianCalendar;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrintDocumentMetaDataDiffblueTest {
  /**
   * Test {@link PrintDocumentMetaData#printMetadata(PDDocument)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrintDocumentMetaData#printMetadata(PDDocument)}
   */
  @Test
  @DisplayName("Test printMetadata(PDDocument); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  void testPrintMetadata_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    PrintDocumentMetaData printDocumentMetaData = new PrintDocumentMetaData();
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    PDDocument doc = new PDDocument();
    when(pdDocumentCatalog.getMetadata())
        .thenReturn(new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    PDDocument document = mock(PDDocument.class);
    when(document.getNumberOfPages()).thenReturn(10);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(document.getDocumentInformation()).thenReturn(new PDDocumentInformation());

    // Act
    printDocumentMetaData.printMetadata(document);

    // Assert
    verify(document).getDocumentCatalog();
    verify(document).getDocumentInformation();
    verify(document).getNumberOfPages();
    verify(pdDocumentCatalog).getMetadata();
  }

  /**
   * Test {@link PrintDocumentMetaData#printMetadata(PDDocument)}.
   * <ul>
   *   <li>Then calls {@link PDDocumentInformation#getAuthor()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrintDocumentMetaData#printMetadata(PDDocument)}
   */
  @Test
  @DisplayName("Test printMetadata(PDDocument); then calls getAuthor()")
  void testPrintMetadata_thenCallsGetAuthor() throws IOException {
    // Arrange
    PrintDocumentMetaData printDocumentMetaData = new PrintDocumentMetaData();
    PDMetadata pdMetadata = mock(PDMetadata.class);
    when(pdMetadata.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getMetadata()).thenReturn(pdMetadata);
    PDDocumentInformation pdDocumentInformation = mock(PDDocumentInformation.class);
    when(pdDocumentInformation.getAuthor()).thenReturn("JaneDoe");
    when(pdDocumentInformation.getCreator()).thenReturn("Creator");
    when(pdDocumentInformation.getKeywords()).thenReturn("Keywords");
    when(pdDocumentInformation.getProducer()).thenReturn("Producer");
    when(pdDocumentInformation.getSubject()).thenReturn("Hello from the Dreaming Spires");
    when(pdDocumentInformation.getTitle()).thenReturn("Dr");
    when(pdDocumentInformation.getTrapped()).thenReturn("Trapped");
    when(pdDocumentInformation.getCreationDate()).thenReturn(new GregorianCalendar(1, 1, 1));
    when(pdDocumentInformation.getModificationDate()).thenReturn(new GregorianCalendar(1, 1, 1));
    PDDocument document = mock(PDDocument.class);
    when(document.getNumberOfPages()).thenReturn(10);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(document.getDocumentInformation()).thenReturn(pdDocumentInformation);

    // Act
    printDocumentMetaData.printMetadata(document);

    // Assert that nothing has changed
    verify(document).getDocumentCatalog();
    verify(document).getDocumentInformation();
    verify(document).getNumberOfPages();
    verify(pdDocumentCatalog).getMetadata();
    verify(pdDocumentInformation).getAuthor();
    verify(pdDocumentInformation).getCreationDate();
    verify(pdDocumentInformation).getCreator();
    verify(pdDocumentInformation).getKeywords();
    verify(pdDocumentInformation).getModificationDate();
    verify(pdDocumentInformation).getProducer();
    verify(pdDocumentInformation).getSubject();
    verify(pdDocumentInformation).getTitle();
    verify(pdDocumentInformation).getTrapped();
    verify(pdMetadata).toByteArray();
  }

  /**
   * Test {@link PrintDocumentMetaData#printMetadata(PDDocument)}.
   * <ul>
   *   <li>Then calls {@link PDStream#toByteArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PrintDocumentMetaData#printMetadata(PDDocument)}
   */
  @Test
  @DisplayName("Test printMetadata(PDDocument); then calls toByteArray()")
  void testPrintMetadata_thenCallsToByteArray() throws IOException {
    // Arrange
    PrintDocumentMetaData printDocumentMetaData = new PrintDocumentMetaData();
    PDMetadata pdMetadata = mock(PDMetadata.class);
    when(pdMetadata.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getMetadata()).thenReturn(pdMetadata);
    PDDocument document = mock(PDDocument.class);
    when(document.getNumberOfPages()).thenReturn(10);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    when(document.getDocumentInformation()).thenReturn(new PDDocumentInformation());

    // Act
    printDocumentMetaData.printMetadata(document);

    // Assert that nothing has changed
    verify(document).getDocumentCatalog();
    verify(document).getDocumentInformation();
    verify(document).getNumberOfPages();
    verify(pdDocumentCatalog).getMetadata();
    verify(pdMetadata).toByteArray();
  }
}
