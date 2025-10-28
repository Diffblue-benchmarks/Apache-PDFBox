package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.junit.jupiter.api.Test;

class FDFNamedPageReferenceDiffblueTest {
  /**
   * Method under test: {@link FDFNamedPageReference#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new FDFNamedPageReference()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFNamedPageReference#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertNull((new FDFNamedPageReference()).getName());
  }

  /**
   * Method under test: {@link FDFNamedPageReference#getName()}
   */
  @Test
  void testGetName2() {
    // Arrange
    FDFNamedPageReference fdfNamedPageReference = new FDFNamedPageReference();
    fdfNamedPageReference.setName("Name");

    // Act and Assert
    assertEquals("Name", fdfNamedPageReference.getName());
  }

  /**
   * Method under test: {@link FDFNamedPageReference#getName()}
   */
  @Test
  void testGetName3() {
    // Arrange
    FDFNamedPageReference fdfNamedPageReference = new FDFNamedPageReference();
    fdfNamedPageReference.setName("");

    // Act and Assert
    assertEquals("", fdfNamedPageReference.getName());
  }

  /**
   * Method under test: {@link FDFNamedPageReference#setName(String)}
   */
  @Test
  void testSetName() {
    // Arrange
    FDFNamedPageReference fdfNamedPageReference = new FDFNamedPageReference();

    // Act
    fdfNamedPageReference.setName("Name");

    // Assert
    assertEquals("Name", fdfNamedPageReference.getName());
    COSDictionary cOSObject = fdfNamedPageReference.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFNamedPageReference#getFileSpecification()}
   */
  @Test
  void testGetFileSpecification() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFNamedPageReference()).getFileSpecification());
  }

  /**
   * Method under test: {@link FDFNamedPageReference#getFileSpecification()}
   */
  @Test
  void testGetFileSpecification2() throws IOException {
    // Arrange
    FDFNamedPageReference fdfNamedPageReference = new FDFNamedPageReference();
    fdfNamedPageReference.setFileSpecification(new PDComplexFileSpecification());

    // Act
    PDFileSpecification actualFileSpecification = fdfNamedPageReference.getFileSpecification();

    // Assert
    assertTrue(actualFileSpecification instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getFileDescription());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getFileDos());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getFileMac());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getFileUnicode());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getFileUnix());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getFilename());
    assertNull(actualFileSpecification.getFile());
    COSBase cOSObject = actualFileSpecification.getCOSObject();
    COSUpdateState updateState = ((COSDictionary) cOSObject).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getEmbeddedFileUnix());
    assertEquals(1, ((COSDictionary) cOSObject).getValues().size());
    assertEquals(1, ((COSDictionary) cOSObject).size());
    COSIncrement toIncrementResult = ((COSDictionary) cOSObject).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSDictionary) cOSObject).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDComplexFileSpecification) actualFileSpecification).isVolatile());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFNamedPageReference#getFileSpecification()}
   */
  @Test
  void testGetFileSpecification3() throws IOException {
    // Arrange
    FDFNamedPageReference fdfNamedPageReference = new FDFNamedPageReference();
    fdfNamedPageReference.setFileSpecification(new PDSimpleFileSpecification());

    // Act
    PDFileSpecification actualFileSpecification = fdfNamedPageReference.getFileSpecification();

    // Assert
    COSBase cOSObject = actualFileSpecification.getCOSObject();
    assertTrue(cOSObject instanceof COSString);
    assertTrue(actualFileSpecification instanceof PDSimpleFileSpecification);
    assertEquals("", ((COSString) cOSObject).getASCII());
    assertEquals("", ((COSString) cOSObject).getString());
    assertEquals("", ((COSString) cOSObject).toHexString());
    assertEquals("", actualFileSpecification.getFile());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((COSString) cOSObject).getBytes().length);
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
  }

  /**
   * Method under test: {@link FDFNamedPageReference#getFileSpecification()}
   */
  @Test
  void testGetFileSpecification4() throws IOException {
    // Arrange
    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));
    PDComplexFileSpecification fs = new PDComplexFileSpecification(dict);

    FDFNamedPageReference fdfNamedPageReference = new FDFNamedPageReference();
    fdfNamedPageReference.setFileSpecification(fs);

    // Act
    PDFileSpecification actualFileSpecification = fdfNamedPageReference.getFileSpecification();

    // Assert
    assertTrue(actualFileSpecification instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getFileDescription());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getFileDos());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getFileMac());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getFileUnicode());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getFileUnix());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getFilename());
    assertNull(actualFileSpecification.getFile());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) actualFileSpecification).getEmbeddedFileUnix());
    assertFalse(((PDComplexFileSpecification) actualFileSpecification).isVolatile());
    assertSame(dict, actualFileSpecification.getCOSObject());
  }

  /**
   * Method under test:
   * {@link FDFNamedPageReference#setFileSpecification(PDFileSpecification)}
   */
  @Test
  void testSetFileSpecification() throws IOException {
    // Arrange
    FDFNamedPageReference fdfNamedPageReference = new FDFNamedPageReference();

    // Act
    fdfNamedPageReference.setFileSpecification(new PDComplexFileSpecification());

    // Assert
    PDFileSpecification fileSpecification = fdfNamedPageReference.getFileSpecification();
    assertTrue(fileSpecification instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) fileSpecification).getFileDescription());
    assertNull(((PDComplexFileSpecification) fileSpecification).getFileDos());
    assertNull(((PDComplexFileSpecification) fileSpecification).getFileMac());
    assertNull(((PDComplexFileSpecification) fileSpecification).getFileUnicode());
    assertNull(((PDComplexFileSpecification) fileSpecification).getFileUnix());
    assertNull(((PDComplexFileSpecification) fileSpecification).getFilename());
    assertNull(fileSpecification.getFile());
    assertNull(((PDComplexFileSpecification) fileSpecification).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) fileSpecification).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) fileSpecification).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) fileSpecification).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) fileSpecification).getEmbeddedFileUnix());
    COSDictionary cOSObject = fdfNamedPageReference.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(((PDComplexFileSpecification) fileSpecification).isVolatile());
  }

  /**
   * Method under test:
   * {@link FDFNamedPageReference#setFileSpecification(PDFileSpecification)}
   */
  @Test
  void testSetFileSpecification2() throws IOException {
    // Arrange
    FDFNamedPageReference fdfNamedPageReference = new FDFNamedPageReference();

    // Act
    fdfNamedPageReference.setFileSpecification(new PDSimpleFileSpecification());

    // Assert
    PDFileSpecification fileSpecification = fdfNamedPageReference.getFileSpecification();
    assertTrue(fileSpecification instanceof PDSimpleFileSpecification);
    assertEquals("", fileSpecification.getFile());
    COSDictionary cOSObject = fdfNamedPageReference.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link FDFNamedPageReference#setFileSpecification(PDFileSpecification)}
   */
  @Test
  void testSetFileSpecification3() throws IOException {
    // Arrange
    FDFNamedPageReference fdfNamedPageReference = new FDFNamedPageReference();

    // Act
    fdfNamedPageReference.setFileSpecification(null);

    // Assert
    assertNull(fdfNamedPageReference.getFileSpecification());
    COSDictionary cOSObject = fdfNamedPageReference.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test:
   * {@link FDFNamedPageReference#setFileSpecification(PDFileSpecification)}
   */
  @Test
  void testSetFileSpecification4() throws IOException {
    // Arrange
    FDFNamedPageReference fdfNamedPageReference = new FDFNamedPageReference();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    fdfNamedPageReference.setFileSpecification(new PDComplexFileSpecification(dict));

    // Assert
    PDFileSpecification fileSpecification = fdfNamedPageReference.getFileSpecification();
    assertTrue(fileSpecification instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) fileSpecification).getFileDescription());
    assertNull(((PDComplexFileSpecification) fileSpecification).getFileDos());
    assertNull(((PDComplexFileSpecification) fileSpecification).getFileMac());
    assertNull(((PDComplexFileSpecification) fileSpecification).getFileUnicode());
    assertNull(((PDComplexFileSpecification) fileSpecification).getFileUnix());
    assertNull(((PDComplexFileSpecification) fileSpecification).getFilename());
    assertNull(fileSpecification.getFile());
    assertNull(((PDComplexFileSpecification) fileSpecification).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) fileSpecification).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) fileSpecification).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) fileSpecification).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) fileSpecification).getEmbeddedFileUnix());
    COSDictionary cOSObject = fdfNamedPageReference.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(((PDComplexFileSpecification) fileSpecification).isVolatile());
    assertSame(dict, fileSpecification.getCOSObject());
  }

  /**
   * Method under test:
   * {@link FDFNamedPageReference#setFileSpecification(PDFileSpecification)}
   */
  @Test
  void testSetFileSpecification5() throws IOException {
    // Arrange
    FDFNamedPageReference fdfNamedPageReference = new FDFNamedPageReference();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    fdfNamedPageReference.setFileSpecification(new PDComplexFileSpecification(dict));

    // Assert
    PDFileSpecification fileSpecification = fdfNamedPageReference.getFileSpecification();
    assertTrue(fileSpecification instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) fileSpecification).getFileDescription());
    assertNull(((PDComplexFileSpecification) fileSpecification).getFileDos());
    assertNull(((PDComplexFileSpecification) fileSpecification).getFileMac());
    assertNull(((PDComplexFileSpecification) fileSpecification).getFileUnicode());
    assertNull(((PDComplexFileSpecification) fileSpecification).getFileUnix());
    assertNull(((PDComplexFileSpecification) fileSpecification).getFilename());
    assertNull(fileSpecification.getFile());
    assertNull(((PDComplexFileSpecification) fileSpecification).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) fileSpecification).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) fileSpecification).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) fileSpecification).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) fileSpecification).getEmbeddedFileUnix());
    COSDictionary cOSObject = fdfNamedPageReference.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(((PDComplexFileSpecification) fileSpecification).isVolatile());
    assertSame(dict, fileSpecification.getCOSObject());
  }

  /**
   * Method under test:
   * {@link FDFNamedPageReference#FDFNamedPageReference(COSDictionary)}
   */
  @Test
  void testNewFDFNamedPageReference() {
    // Arrange
    COSDictionary r = new COSDictionary();

    // Act and Assert
    assertSame(r, (new FDFNamedPageReference(r)).getCOSObject());
  }

  /**
   * Method under test: {@link FDFNamedPageReference#FDFNamedPageReference()}
   */
  @Test
  void testNewFDFNamedPageReference2() throws IOException {
    // Arrange and Act
    FDFNamedPageReference actualFdfNamedPageReference = new FDFNamedPageReference();

    // Assert
    assertNull(actualFdfNamedPageReference.getName());
    COSDictionary cOSObject = actualFdfNamedPageReference.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfNamedPageReference.getFileSpecification());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
