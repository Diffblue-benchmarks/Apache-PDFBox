package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

class FDFDocumentDiffblueTest {
  /**
   * Test {@link FDFDocument#FDFDocument()}.
   * <p>
   * Method under test: {@link FDFDocument#FDFDocument()}
   */
  @Test
  @DisplayName("Test new FDFDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDocument.<init>()"})
  void testNewFDFDocument() {
    // Arrange and Act
    FDFDocument actualFdfDocument = new FDFDocument();

    // Assert
    FDFCatalog catalog = actualFdfDocument.getCatalog();
    assertNull(catalog.getVersion());
    COSDocument document = actualFdfDocument.getDocument();
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(document.getLinearizedDictionary());
    assertNull(document.getKey());
    assertNull(catalog.getSignature());
    assertEquals(0L, document.getHighestXRefObjectNumber());
    assertEquals(0L, document.getStartXref());
    assertEquals(1.2f, document.getVersion());
    assertFalse(document.isDirect());
    assertFalse(document.hasHybridXRef());
    assertFalse(document.isClosed());
    assertFalse(document.isDecrypted());
    assertFalse(document.isEncrypted());
    assertFalse(document.isXRefStream());
    assertTrue(document.getXrefTable().isEmpty());
  }

  /**
   * Test {@link FDFDocument#FDFDocument(Document)}.
   * <p>
   * Method under test: {@link FDFDocument#FDFDocument(Document)}
   */
  @Test
  @DisplayName("Test new FDFDocument(Document)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDocument.<init>(Document)"})
  void testNewFDFDocument2() throws IOException {
    // Arrange
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("xfdf");
    IIOMetadataNode iioMetadataNode2 = new IIOMetadataNode("xfdf");
    iioMetadataNode.insertBefore(iioMetadataNode2, new IIOMetadataNode("xfdf"));
    Document doc = mock(Document.class);
    when(doc.getDocumentElement()).thenReturn(iioMetadataNode);

    // Act
    FDFDocument actualFdfDocument = new FDFDocument(doc);

    // Assert
    verify(doc).getDocumentElement();
    FDFCatalog catalog = actualFdfDocument.getCatalog();
    assertNull(catalog.getVersion());
    COSDocument document = actualFdfDocument.getDocument();
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(document.getLinearizedDictionary());
    assertNull(document.getKey());
    assertNull(catalog.getSignature());
    assertEquals(0L, document.getHighestXRefObjectNumber());
    assertEquals(0L, document.getStartXref());
    assertEquals(1.2f, document.getVersion());
    assertFalse(document.isDirect());
    assertFalse(document.hasHybridXRef());
    assertFalse(document.isClosed());
    assertFalse(document.isDecrypted());
    assertFalse(document.isEncrypted());
    assertFalse(document.isXRefStream());
    assertTrue(document.getXrefTable().isEmpty());
  }

  /**
   * Test {@link FDFDocument#FDFDocument(Document)}.
   * <p>
   * Method under test: {@link FDFDocument#FDFDocument(Document)}
   */
  @Test
  @DisplayName("Test new FDFDocument(Document)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDocument.<init>(Document)"})
  void testNewFDFDocument3() throws IOException {
    // Arrange
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("xfdf");
    iioMetadataNode.appendChild(new IIOMetadataNode("xfdf"));
    Document doc = mock(Document.class);
    when(doc.getDocumentElement()).thenReturn(iioMetadataNode);

    // Act
    FDFDocument actualFdfDocument = new FDFDocument(doc);

    // Assert
    verify(doc).getDocumentElement();
    FDFCatalog catalog = actualFdfDocument.getCatalog();
    assertNull(catalog.getVersion());
    COSDocument document = actualFdfDocument.getDocument();
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(document.getLinearizedDictionary());
    assertNull(document.getKey());
    assertNull(catalog.getSignature());
    assertEquals(0L, document.getHighestXRefObjectNumber());
    assertEquals(0L, document.getStartXref());
    assertEquals(1.2f, document.getVersion());
    assertFalse(document.isDirect());
    assertFalse(document.hasHybridXRef());
    assertFalse(document.isClosed());
    assertFalse(document.isDecrypted());
    assertFalse(document.isEncrypted());
    assertFalse(document.isXRefStream());
    assertTrue(document.getXrefTable().isEmpty());
  }

  /**
   * Test {@link FDFDocument#FDFDocument(Document)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDocument#FDFDocument(Document)}
   */
  @Test
  @DisplayName("Test new FDFDocument(Document); given IIOMetadataNode(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDocument.<init>(Document)"})
  void testNewFDFDocument_givenIIOMetadataNodeWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    Document doc = mock(Document.class);
    when(doc.getDocumentElement()).thenReturn(new IIOMetadataNode("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> new FDFDocument(doc));
    verify(doc).getDocumentElement();
  }

  /**
   * Test {@link FDFDocument#FDFDocument(Document)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code xfdf}.</li>
   *   <li>Then return Catalog Version is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDocument#FDFDocument(Document)}
   */
  @Test
  @DisplayName("Test new FDFDocument(Document); given IIOMetadataNode(String) with 'xfdf'; then return Catalog Version is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDocument.<init>(Document)"})
  void testNewFDFDocument_givenIIOMetadataNodeWithXfdf_thenReturnCatalogVersionIsNull() throws IOException {
    // Arrange
    Document doc = mock(Document.class);
    when(doc.getDocumentElement()).thenReturn(new IIOMetadataNode("xfdf"));

    // Act
    FDFDocument actualFdfDocument = new FDFDocument(doc);

    // Assert
    verify(doc).getDocumentElement();
    FDFCatalog catalog = actualFdfDocument.getCatalog();
    assertNull(catalog.getVersion());
    COSDocument document = actualFdfDocument.getDocument();
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(document.getLinearizedDictionary());
    assertNull(document.getKey());
    assertNull(catalog.getSignature());
    assertEquals(0L, document.getHighestXRefObjectNumber());
    assertEquals(0L, document.getStartXref());
    assertEquals(1.2f, document.getVersion());
    assertFalse(document.isDirect());
    assertFalse(document.hasHybridXRef());
    assertFalse(document.isClosed());
    assertFalse(document.isDecrypted());
    assertFalse(document.isEncrypted());
    assertFalse(document.isXRefStream());
    assertTrue(document.getXrefTable().isEmpty());
  }

  /**
   * Test {@link FDFDocument#writeXML(Writer)}.
   * <ul>
   *   <li>Given {@link FDFDocument#FDFDocument()}.</li>
   *   <li>When {@link StringWriter#StringWriter()}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDocument#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given FDFDocument(); when StringWriter(); then StringWriter() toString is a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDocument.writeXML(Writer)"})
  void testWriteXML_givenFDFDocument_whenStringWriter_thenStringWriterToStringIsAString() throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();
    StringWriter output = new StringWriter();

    // Act
    fdfDocument.writeXML(output);

    // Assert
    assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
        + "<xfdf xmlns=\"http://ns.adobe.com/xfdf/\" xml:space=\"preserve\">\n" + "</xfdf>\n", output.toString());
  }

  /**
   * Test {@link FDFDocument#getCatalog()}.
   * <ul>
   *   <li>Given {@link FDFDocument#FDFDocument()}.</li>
   *   <li>Then return FDF Encoding is {@code PDFDocEncoding}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDocument#getCatalog()}
   */
  @Test
  @DisplayName("Test getCatalog(); given FDFDocument(); then return FDF Encoding is 'PDFDocEncoding'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FDFCatalog FDFDocument.getCatalog()"})
  void testGetCatalog_givenFDFDocument_thenReturnFdfEncodingIsPDFDocEncoding() throws IOException {
    // Arrange and Act
    FDFCatalog actualCatalog = (new FDFDocument()).getCatalog();

    // Assert
    FDFDictionary fDF = actualCatalog.getFDF();
    assertEquals("PDFDocEncoding", fDF.getEncoding());
    assertNull(actualCatalog.getVersion());
    assertNull(fDF.getStatus());
    assertNull(fDF.getTarget());
    assertNull(fDF.getEmbeddedFDFs());
    assertNull(fDF.getAnnotations());
    assertNull(fDF.getFields());
    assertNull(fDF.getPages());
    assertNull(fDF.getID());
    COSDictionary cOSObject = actualCatalog.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(fDF.getDifferences());
    assertNull(fDF.getFile());
    assertNull(fDF.getJavaScript());
    assertNull(actualCatalog.getSignature());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertTrue(cOSObject.isNeedToBeUpdated());
  }

  /**
   * Test {@link FDFDocument#save(OutputStream)} with {@code OutputStream}.
   * <ul>
   *   <li>Given {@link FDFDocument#FDFDocument()}.</li>
   *   <li>Then array length is one hundred thirty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDocument#save(OutputStream)}
   */
  @Test
  @DisplayName("Test save(OutputStream) with 'OutputStream'; given FDFDocument(); then array length is one hundred thirty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDocument.save(OutputStream)"})
  void testSaveWithOutputStream_givenFDFDocument_thenArrayLengthIsOneHundredThirtyEight() throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    fdfDocument.save(output);

    // Assert
    assertEquals(138, output.toByteArray().length);
  }

  /**
   * Test {@link FDFDocument#saveXFDF(Writer)} with {@code Writer}.
   * <ul>
   *   <li>Given {@link FDFDocument#FDFDocument()}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDocument#saveXFDF(Writer)}
   */
  @Test
  @DisplayName("Test saveXFDF(Writer) with 'Writer'; given FDFDocument(); then StringWriter() toString is a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDocument.saveXFDF(Writer)"})
  void testSaveXFDFWithWriter_givenFDFDocument_thenStringWriterToStringIsAString() throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();
    StringWriter output = new StringWriter();

    // Act
    fdfDocument.saveXFDF(output);

    // Assert
    assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
        + "<xfdf xmlns=\"http://ns.adobe.com/xfdf/\" xml:space=\"preserve\">\n" + "</xfdf>\n", output.toString());
  }

  /**
   * Test {@link FDFDocument#close()}.
   * <ul>
   *   <li>Given {@link FDFDocument#FDFDocument()}.</li>
   *   <li>Then {@link FDFDocument#FDFDocument()} Document Closed.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFDocument#close()}
   */
  @Test
  @DisplayName("Test close(); given FDFDocument(); then FDFDocument() Document Closed")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFDocument.close()"})
  void testClose_givenFDFDocument_thenFDFDocumentDocumentClosed() throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();

    // Act
    fdfDocument.close();

    // Assert
    assertTrue(fdfDocument.getDocument().isClosed());
  }
}
