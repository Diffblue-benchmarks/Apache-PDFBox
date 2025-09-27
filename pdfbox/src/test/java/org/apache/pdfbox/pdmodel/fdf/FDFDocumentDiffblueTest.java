package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FDFDocumentDiffblueTest {
  /**
   * Test {@link FDFDocument#FDFDocument()}.
   *
   * <p>Method under test: {@link FDFDocument#FDFDocument()}
   */
  @Test
  @DisplayName("Test new FDFDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link FDFDocument#writeXML(Writer)}.
   *
   * <ul>
   *   <li>Given {@link FDFDocument#FDFDocument()}.
   *   <li>When {@link StringWriter#StringWriter()}.
   *   <li>Then {@link StringWriter#StringWriter()} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#writeXML(Writer)}
   */
  @Test
  @DisplayName(
      "Test writeXML(Writer); given FDFDocument(); when StringWriter(); then StringWriter() toString is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.writeXML(Writer)"})
  void testWriteXML_givenFDFDocument_whenStringWriter_thenStringWriterToStringIsAString()
      throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();
    StringWriter output = new StringWriter();

    // Act
    fdfDocument.writeXML(output);

    // Assert
    assertEquals(
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<xfdf xmlns=\"http://ns.adobe.com/xfdf/\" xml:space=\"preserve\">\n"
            + "</xfdf>\n",
        output.toString());
  }

  /**
   * Test {@link FDFDocument#setCatalog(FDFCatalog)}.
   *
   * <p>Method under test: {@link FDFDocument#setCatalog(FDFCatalog)}
   */
  @Test
  @DisplayName("Test setCatalog(FDFCatalog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.setCatalog(FDFCatalog)"})
  void testSetCatalog() {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();

    COSArray id = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    id.add((COSBase) object);

    FDFDictionary fdf = new FDFDictionary();
    fdf.setID(id);

    FDFCatalog cat = new FDFCatalog();
    cat.setFDF(fdf);

    // Act
    fdfDocument.setCatalog(cat);

    // Assert
    List<? extends COSBase> toListResult = cat.getFDF().getID().toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSObject);
    assertTrue(((COSObject) getResult).isNeedToBeUpdated());
    assertTrue(((COSObject) getResult).getUpdateState().isUpdated());
    assertSame(id, fdfDocument.getCatalog().getFDF().getID());
  }

  /**
   * Test {@link FDFDocument#setCatalog(FDFCatalog)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#setCatalog(FDFCatalog)}
   */
  @Test
  @DisplayName("Test setCatalog(FDFCatalog); given COSArray() add COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.setCatalog(FDFCatalog)"})
  void testSetCatalog_givenCOSArrayAddCOSArray() {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();

    FDFCatalog cat = new FDFCatalog();

    FDFDictionary fdf = new FDFDictionary();

    COSArray id = new COSArray();
    id.add((COSBase) new COSArray());
    fdf.setID(id);
    cat.setFDF(fdf);

    // Act
    fdfDocument.setCatalog(cat);

    // Assert
    COSDictionary cOSObject = cat.getCOSObject();
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertEquals(2, toIncrementResult.getObjects().size());
    Iterator<COSBase> iteratorResult = toIncrementResult.iterator();
    COSBase actualNextResult = iteratorResult.next();
    COSBase actualNextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(cOSObject, actualNextResult);
    COSDictionary cOSObject2 = cat.getFDF().getCOSObject();
    assertEquals(1, cOSObject2.toIncrement().getObjects().size());
    assertSame(cOSObject2, actualNextResult2);
    FDFCatalog catalog = fdfDocument.getCatalog();
    assertSame(cOSObject, catalog.getCOSObject());
    FDFDictionary fDF = catalog.getFDF();
    assertSame(cOSObject2, fDF.getCOSObject());
    assertSame(id, fDF.getID());
  }

  /**
   * Test {@link FDFDocument#setCatalog(FDFCatalog)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#setCatalog(FDFCatalog)}
   */
  @Test
  @DisplayName("Test setCatalog(FDFCatalog); given COSArray() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.setCatalog(FDFCatalog)"})
  void testSetCatalog_givenCOSArrayAddFalse() {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();

    FDFCatalog cat = new FDFCatalog();

    FDFDictionary fdf = new FDFDictionary();

    COSArray id = new COSArray();
    id.add(COSBoolean.FALSE);
    fdf.setID(id);
    cat.setFDF(fdf);

    // Act
    fdfDocument.setCatalog(cat);

    // Assert
    COSDictionary cOSObject = cat.getCOSObject();
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertEquals(2, toIncrementResult.getObjects().size());
    Iterator<COSBase> iteratorResult = toIncrementResult.iterator();
    COSBase actualNextResult = iteratorResult.next();
    COSBase actualNextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(cOSObject, actualNextResult);
    COSDictionary cOSObject2 = cat.getFDF().getCOSObject();
    assertEquals(1, cOSObject2.toIncrement().getObjects().size());
    assertSame(cOSObject2, actualNextResult2);
    FDFCatalog catalog = fdfDocument.getCatalog();
    assertSame(cOSObject, catalog.getCOSObject());
    FDFDictionary fDF = catalog.getFDF();
    assertSame(cOSObject2, fDF.getCOSObject());
    assertSame(id, fDF.getID());
  }

  /**
   * Test {@link FDFDocument#setCatalog(FDFCatalog)}.
   *
   * <ul>
   *   <li>Then {@link FDFCatalog#FDFCatalog()} COSObject toIncrement Objects size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#setCatalog(FDFCatalog)}
   */
  @Test
  @DisplayName(
      "Test setCatalog(FDFCatalog); then FDFCatalog() COSObject toIncrement Objects size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.setCatalog(FDFCatalog)"})
  void testSetCatalog_thenFDFCatalogCOSObjectToIncrementObjectsSizeIsTwo() {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();

    FDFCatalog cat = new FDFCatalog();

    FDFDictionary fdf = new FDFDictionary();
    COSArray id = new COSArray();
    fdf.setID(id);
    cat.setFDF(fdf);

    // Act
    fdfDocument.setCatalog(cat);

    // Assert
    COSDictionary cOSObject = cat.getCOSObject();
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertEquals(2, toIncrementResult.getObjects().size());
    Iterator<COSBase> iteratorResult = toIncrementResult.iterator();
    COSBase actualNextResult = iteratorResult.next();
    COSBase actualNextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(cOSObject, actualNextResult);
    COSDictionary cOSObject2 = cat.getFDF().getCOSObject();
    assertEquals(1, cOSObject2.toIncrement().getObjects().size());
    assertSame(cOSObject2, actualNextResult2);
    FDFCatalog catalog = fdfDocument.getCatalog();
    assertSame(cOSObject, catalog.getCOSObject());
    FDFDictionary fDF = catalog.getFDF();
    assertSame(cOSObject2, fDF.getCOSObject());
    assertSame(id, fDF.getID());
  }

  /**
   * Test {@link FDFDocument#save(OutputStream)} with {@code OutputStream}.
   *
   * <ul>
   *   <li>Given {@link FDFDocument#FDFDocument()}.
   *   <li>Then array length is one hundred thirty-eight.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#save(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test save(OutputStream) with 'OutputStream'; given FDFDocument(); then array length is one hundred thirty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.save(OutputStream)"})
  void testSaveWithOutputStream_givenFDFDocument_thenArrayLengthIsOneHundredThirtyEight()
      throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    fdfDocument.save(output);

    // Assert
    assertEquals(138, output.toByteArray().length);
  }

  /**
   * Test {@link FDFDocument#saveXFDF(Writer)} with {@code Writer}.
   *
   * <ul>
   *   <li>Given {@link FDFDocument#FDFDocument()}.
   *   <li>Then {@link StringWriter#StringWriter()} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#saveXFDF(Writer)}
   */
  @Test
  @DisplayName(
      "Test saveXFDF(Writer) with 'Writer'; given FDFDocument(); then StringWriter() toString is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.saveXFDF(Writer)"})
  void testSaveXFDFWithWriter_givenFDFDocument_thenStringWriterToStringIsAString()
      throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();
    StringWriter output = new StringWriter();

    // Act
    fdfDocument.saveXFDF(output);

    // Assert
    assertEquals(
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<xfdf xmlns=\"http://ns.adobe.com/xfdf/\" xml:space=\"preserve\">\n"
            + "</xfdf>\n",
        output.toString());
  }

  /**
   * Test {@link FDFDocument#close()}.
   *
   * <ul>
   *   <li>Given {@link FDFDocument#FDFDocument()}.
   *   <li>Then {@link FDFDocument#FDFDocument()} Document Closed.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#close()}
   */
  @Test
  @DisplayName("Test close(); given FDFDocument(); then FDFDocument() Document Closed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
