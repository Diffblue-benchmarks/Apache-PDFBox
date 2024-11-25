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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FDFNamedPageReferenceDiffblueTest {
  /**
   * Test {@link FDFNamedPageReference#FDFNamedPageReference(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link FDFNamedPageReference#FDFNamedPageReference(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFNamedPageReference(COSDictionary)")
  void testNewFDFNamedPageReference() {
    // Arrange
    COSDictionary r = new COSDictionary();

    // Act and Assert
    assertSame(r, (new FDFNamedPageReference(r)).getCOSObject());
  }

  /**
   * Test {@link FDFNamedPageReference#FDFNamedPageReference()}.
   * <p>
   * Method under test: {@link FDFNamedPageReference#FDFNamedPageReference()}
   */
  @Test
  @DisplayName("Test new FDFNamedPageReference()")
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

  /**
   * Test {@link FDFNamedPageReference#getCOSObject()}.
   * <p>
   * Method under test: {@link FDFNamedPageReference#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
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
   * Test {@link FDFNamedPageReference#getName()}.
   * <ul>
   *   <li>Given {@link FDFNamedPageReference#FDFNamedPageReference()} Name is empty
   * string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFNamedPageReference#getName()}
   */
  @Test
  @DisplayName("Test getName(); given FDFNamedPageReference() Name is empty string; then return empty string")
  void testGetName_givenFDFNamedPageReferenceNameIsEmptyString_thenReturnEmptyString() {
    // Arrange
    FDFNamedPageReference fdfNamedPageReference = new FDFNamedPageReference();
    fdfNamedPageReference.setName("");

    // Act and Assert
    assertEquals("", fdfNamedPageReference.getName());
  }

  /**
   * Test {@link FDFNamedPageReference#getName()}.
   * <ul>
   *   <li>Given {@link FDFNamedPageReference#FDFNamedPageReference()} Name is
   * {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFNamedPageReference#getName()}
   */
  @Test
  @DisplayName("Test getName(); given FDFNamedPageReference() Name is 'Name'; then return 'Name'")
  void testGetName_givenFDFNamedPageReferenceNameIsName_thenReturnName() {
    // Arrange
    FDFNamedPageReference fdfNamedPageReference = new FDFNamedPageReference();
    fdfNamedPageReference.setName("Name");

    // Act and Assert
    assertEquals("Name", fdfNamedPageReference.getName());
  }

  /**
   * Test {@link FDFNamedPageReference#getName()}.
   * <ul>
   *   <li>Given {@link FDFNamedPageReference#FDFNamedPageReference()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFNamedPageReference#getName()}
   */
  @Test
  @DisplayName("Test getName(); given FDFNamedPageReference(); then return 'null'")
  void testGetName_givenFDFNamedPageReference_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFNamedPageReference()).getName());
  }

  /**
   * Test {@link FDFNamedPageReference#setName(String)}.
   * <ul>
   *   <li>Given {@link FDFNamedPageReference#FDFNamedPageReference()}.</li>
   *   <li>Then {@link FDFNamedPageReference#FDFNamedPageReference()} Name is
   * {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFNamedPageReference#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); given FDFNamedPageReference(); then FDFNamedPageReference() Name is 'Name'")
  void testSetName_givenFDFNamedPageReference_thenFDFNamedPageReferenceNameIsName() {
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
   * Test {@link FDFNamedPageReference#getFileSpecification()}.
   * <ul>
   *   <li>Given {@link FDFNamedPageReference#FDFNamedPageReference()} Name is
   * {@code Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFNamedPageReference#getFileSpecification()}
   */
  @Test
  @DisplayName("Test getFileSpecification(); given FDFNamedPageReference() Name is 'Name'; then return 'null'")
  void testGetFileSpecification_givenFDFNamedPageReferenceNameIsName_thenReturnNull() throws IOException {
    // Arrange
    FDFNamedPageReference fdfNamedPageReference = new FDFNamedPageReference();
    fdfNamedPageReference.setName("Name");

    // Act and Assert
    assertNull(fdfNamedPageReference.getFileSpecification());
  }

  /**
   * Test {@link FDFNamedPageReference#getFileSpecification()}.
   * <ul>
   *   <li>Given {@link FDFNamedPageReference#FDFNamedPageReference()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFNamedPageReference#getFileSpecification()}
   */
  @Test
  @DisplayName("Test getFileSpecification(); given FDFNamedPageReference(); then return 'null'")
  void testGetFileSpecification_givenFDFNamedPageReference_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFNamedPageReference()).getFileSpecification());
  }

  /**
   * Test {@link FDFNamedPageReference#getFileSpecification()}.
   * <ul>
   *   <li>Then COSObject return {@link COSString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFNamedPageReference#getFileSpecification()}
   */
  @Test
  @DisplayName("Test getFileSpecification(); then COSObject return COSString")
  void testGetFileSpecification_thenCOSObjectReturnCOSString() throws IOException {
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
   * Test {@link FDFNamedPageReference#getFileSpecification()}.
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFNamedPageReference#getFileSpecification()}
   */
  @Test
  @DisplayName("Test getFileSpecification(); then return COSObject is COSDictionary()")
  void testGetFileSpecification_thenReturnCOSObjectIsCOSDictionary() throws IOException {
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
    assertSame(dict, actualFileSpecification.getCOSObject());
  }

  /**
   * Test {@link FDFNamedPageReference#getFileSpecification()}.
   * <ul>
   *   <li>Then return FileDescription is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFNamedPageReference#getFileSpecification()}
   */
  @Test
  @DisplayName("Test getFileSpecification(); then return FileDescription is 'null'")
  void testGetFileSpecification_thenReturnFileDescriptionIsNull() throws IOException {
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
   * Test {@link FDFNamedPageReference#setFileSpecification(PDFileSpecification)}.
   * <p>
   * Method under test:
   * {@link FDFNamedPageReference#setFileSpecification(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFileSpecification(PDFileSpecification)")
  void testSetFileSpecification() throws IOException {
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
   * Test {@link FDFNamedPageReference#setFileSpecification(PDFileSpecification)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FDFNamedPageReference#setFileSpecification(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFileSpecification(PDFileSpecification); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetFileSpecification_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
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
    assertFalse(((PDComplexFileSpecification) fileSpecification).isVolatile());
    assertSame(dict, fileSpecification.getCOSObject());
  }

  /**
   * Test {@link FDFNamedPageReference#setFileSpecification(PDFileSpecification)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FDFNamedPageReference#setFileSpecification(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFileSpecification(PDFileSpecification); given 'true'; when COSDictionary() Direct is 'true'")
  void testSetFileSpecification_givenTrue_whenCOSDictionaryDirectIsTrue() throws IOException {
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
    assertFalse(((PDComplexFileSpecification) fileSpecification).isVolatile());
    assertSame(dict, fileSpecification.getCOSObject());
  }

  /**
   * Test {@link FDFNamedPageReference#setFileSpecification(PDFileSpecification)}.
   * <ul>
   *   <li>Then {@link FDFNamedPageReference#FDFNamedPageReference()}
   * FileSpecification is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FDFNamedPageReference#setFileSpecification(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFileSpecification(PDFileSpecification); then FDFNamedPageReference() FileSpecification is 'null'")
  void testSetFileSpecification_thenFDFNamedPageReferenceFileSpecificationIsNull() throws IOException {
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
   * Test {@link FDFNamedPageReference#setFileSpecification(PDFileSpecification)}.
   * <ul>
   *   <li>When
   * {@link PDComplexFileSpecification#PDComplexFileSpecification()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FDFNamedPageReference#setFileSpecification(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFileSpecification(PDFileSpecification); when PDComplexFileSpecification()")
  void testSetFileSpecification_whenPDComplexFileSpecification() throws IOException {
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
    assertFalse(((PDComplexFileSpecification) fileSpecification).isVolatile());
  }
}
