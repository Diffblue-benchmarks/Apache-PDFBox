package org.apache.pdfbox.pdmodel.common.filespecification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDComplexFileSpecificationDiffblueTest {
  /**
   * Test {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#PDComplexFileSpecification()}
   */
  @Test
  @DisplayName("Test new PDComplexFileSpecification()")
  void testNewPDComplexFileSpecification() {
    // Arrange and Act
    PDComplexFileSpecification actualPdComplexFileSpecification = new PDComplexFileSpecification();

    // Assert
    assertNull(actualPdComplexFileSpecification.getFile());
    assertNull(actualPdComplexFileSpecification.getFileDescription());
    assertNull(actualPdComplexFileSpecification.getFileDos());
    assertNull(actualPdComplexFileSpecification.getFileMac());
    assertNull(actualPdComplexFileSpecification.getFileUnicode());
    assertNull(actualPdComplexFileSpecification.getFileUnix());
    assertNull(actualPdComplexFileSpecification.getFilename());
    COSDictionary cOSObject = actualPdComplexFileSpecification.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFile());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileDos());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileMac());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileUnicode());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileUnix());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdComplexFileSpecification.isVolatile());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test
   * {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDComplexFileSpecification(COSDictionary)")
  void testNewPDComplexFileSpecification2() {
    // Arrange and Act
    PDComplexFileSpecification actualPdComplexFileSpecification = new PDComplexFileSpecification(null);

    // Assert
    assertNull(actualPdComplexFileSpecification.getFile());
    assertNull(actualPdComplexFileSpecification.getFileDescription());
    assertNull(actualPdComplexFileSpecification.getFileDos());
    assertNull(actualPdComplexFileSpecification.getFileMac());
    assertNull(actualPdComplexFileSpecification.getFileUnicode());
    assertNull(actualPdComplexFileSpecification.getFileUnix());
    assertNull(actualPdComplexFileSpecification.getFilename());
    COSDictionary cOSObject = actualPdComplexFileSpecification.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFile());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileDos());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileMac());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileUnicode());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileUnix());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdComplexFileSpecification.isVolatile());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test
   * {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}.
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDComplexFileSpecification(COSDictionary); then return COSObject is COSDictionary()")
  void testNewPDComplexFileSpecification_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDComplexFileSpecification actualPdComplexFileSpecification = new PDComplexFileSpecification(dict);

    // Assert
    assertNull(actualPdComplexFileSpecification.getFile());
    assertNull(actualPdComplexFileSpecification.getFileDescription());
    assertNull(actualPdComplexFileSpecification.getFileDos());
    assertNull(actualPdComplexFileSpecification.getFileMac());
    assertNull(actualPdComplexFileSpecification.getFileUnicode());
    assertNull(actualPdComplexFileSpecification.getFileUnix());
    assertNull(actualPdComplexFileSpecification.getFilename());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFile());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileDos());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileMac());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileUnicode());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileUnix());
    assertFalse(actualPdComplexFileSpecification.isVolatile());
    assertSame(dict, actualPdComplexFileSpecification.getCOSObject());
  }

  /**
   * Test {@link PDComplexFileSpecification#getCOSObject()}.
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDComplexFileSpecification()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFilename()}.
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}
   * FileUnicode is {@code File}.</li>
   *   <li>Then return {@code File}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFilename()}
   */
  @Test
  @DisplayName("Test getFilename(); given PDComplexFileSpecification() FileUnicode is 'File'; then return 'File'")
  void testGetFilename_givenPDComplexFileSpecificationFileUnicodeIsFile_thenReturnFile() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFileUnicode("File");

    // Act and Assert
    assertEquals("File", pdComplexFileSpecification.getFilename());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFilename()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}
   * with dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFilename()}
   */
  @Test
  @DisplayName("Test getFilename(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  void testGetFilename_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification(new COSDictionary())).getFilename());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFilename()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFilename()}
   */
  @Test
  @DisplayName("Test getFilename(); given PDComplexFileSpecification(); then return 'null'")
  void testGetFilename_givenPDComplexFileSpecification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getFilename());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFilename()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFilename()}
   */
  @Test
  @DisplayName("Test getFilename(); then return empty string")
  void testGetFilename_thenReturnEmptyString() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFileUnicode("");

    // Act and Assert
    assertEquals("", pdComplexFileSpecification.getFilename());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileUnicode()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}
   * with dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFileUnicode()}
   */
  @Test
  @DisplayName("Test getFileUnicode(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  void testGetFileUnicode_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification(new COSDictionary())).getFileUnicode());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileUnicode()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFileUnicode()}
   */
  @Test
  @DisplayName("Test getFileUnicode(); given PDComplexFileSpecification(); then return 'null'")
  void testGetFileUnicode_givenPDComplexFileSpecification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getFileUnicode());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileUnicode()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFileUnicode()}
   */
  @Test
  @DisplayName("Test getFileUnicode(); then return empty string")
  void testGetFileUnicode_thenReturnEmptyString() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFileUnicode("");

    // Act and Assert
    assertEquals("", pdComplexFileSpecification.getFileUnicode());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileUnicode()}.
   * <ul>
   *   <li>Then return {@code File}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFileUnicode()}
   */
  @Test
  @DisplayName("Test getFileUnicode(); then return 'File'")
  void testGetFileUnicode_thenReturnFile() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFileUnicode("File");

    // Act and Assert
    assertEquals("File", pdComplexFileSpecification.getFileUnicode());
  }

  /**
   * Test {@link PDComplexFileSpecification#setFileUnicode(String)}.
   * <p>
   * Method under test: {@link PDComplexFileSpecification#setFileUnicode(String)}
   */
  @Test
  @DisplayName("Test setFileUnicode(String)")
  void testSetFileUnicode() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setFileUnicode("File");

    // Assert
    assertEquals("File", pdComplexFileSpecification.getFileUnicode());
    assertEquals("File", pdComplexFileSpecification.getFilename());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFile()}.
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}
   * File is {@code File}.</li>
   *   <li>Then return {@code File}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given PDComplexFileSpecification() File is 'File'; then return 'File'")
  void testGetFile_givenPDComplexFileSpecificationFileIsFile_thenReturnFile() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFile("File");

    // Act and Assert
    assertEquals("File", pdComplexFileSpecification.getFile());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFile()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}
   * with dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  void testGetFile_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification(new COSDictionary())).getFile());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFile()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given PDComplexFileSpecification(); then return 'null'")
  void testGetFile_givenPDComplexFileSpecification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getFile());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFile()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then return empty string")
  void testGetFile_thenReturnEmptyString() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFile("");

    // Act and Assert
    assertEquals("", pdComplexFileSpecification.getFile());
  }

  /**
   * Test {@link PDComplexFileSpecification#setFile(String)}.
   * <p>
   * Method under test: {@link PDComplexFileSpecification#setFile(String)}
   */
  @Test
  @DisplayName("Test setFile(String)")
  void testSetFile() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setFile("File");

    // Assert
    assertEquals("File", pdComplexFileSpecification.getFile());
    assertEquals("File", pdComplexFileSpecification.getFilename());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileDos()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFileDos()}
   */
  @Test
  @DisplayName("Test getFileDos(); given PDComplexFileSpecification()")
  void testGetFileDos_givenPDComplexFileSpecification() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getFileDos());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileDos()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}
   * with dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFileDos()}
   */
  @Test
  @DisplayName("Test getFileDos(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  void testGetFileDos_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification(new COSDictionary())).getFileDos());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileMac()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFileMac()}
   */
  @Test
  @DisplayName("Test getFileMac(); given PDComplexFileSpecification()")
  void testGetFileMac_givenPDComplexFileSpecification() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getFileMac());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileMac()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}
   * with dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFileMac()}
   */
  @Test
  @DisplayName("Test getFileMac(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  void testGetFileMac_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification(new COSDictionary())).getFileMac());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileUnix()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFileUnix()}
   */
  @Test
  @DisplayName("Test getFileUnix(); given PDComplexFileSpecification()")
  void testGetFileUnix_givenPDComplexFileSpecification() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getFileUnix());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileUnix()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}
   * with dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFileUnix()}
   */
  @Test
  @DisplayName("Test getFileUnix(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  void testGetFileUnix_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification(new COSDictionary())).getFileUnix());
  }

  /**
   * Test {@link PDComplexFileSpecification#setVolatile(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDComplexFileSpecification#PDComplexFileSpecification()}
   * Volatile.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#setVolatile(boolean)}
   */
  @Test
  @DisplayName("Test setVolatile(boolean); when 'false'; then not PDComplexFileSpecification() Volatile")
  void testSetVolatile_whenFalse_thenNotPDComplexFileSpecificationVolatile() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setVolatile(false);

    // Assert
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdComplexFileSpecification.isVolatile());
  }

  /**
   * Test {@link PDComplexFileSpecification#setVolatile(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDComplexFileSpecification#PDComplexFileSpecification()}
   * Volatile.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#setVolatile(boolean)}
   */
  @Test
  @DisplayName("Test setVolatile(boolean); when 'true'; then PDComplexFileSpecification() Volatile")
  void testSetVolatile_whenTrue_thenPDComplexFileSpecificationVolatile() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setVolatile(true);

    // Assert
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdComplexFileSpecification.isVolatile());
  }

  /**
   * Test {@link PDComplexFileSpecification#isVolatile()}.
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}
   * Volatile is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#isVolatile()}
   */
  @Test
  @DisplayName("Test isVolatile(); given PDComplexFileSpecification() Volatile is 'false'; then return 'false'")
  void testIsVolatile_givenPDComplexFileSpecificationVolatileIsFalse_thenReturnFalse() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setVolatile(false);

    // Act and Assert
    assertFalse(pdComplexFileSpecification.isVolatile());
  }

  /**
   * Test {@link PDComplexFileSpecification#isVolatile()}.
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}
   * Volatile is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#isVolatile()}
   */
  @Test
  @DisplayName("Test isVolatile(); given PDComplexFileSpecification() Volatile is 'true'; then return 'true'")
  void testIsVolatile_givenPDComplexFileSpecificationVolatileIsTrue_thenReturnTrue() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setVolatile(true);

    // Act and Assert
    assertTrue(pdComplexFileSpecification.isVolatile());
  }

  /**
   * Test {@link PDComplexFileSpecification#isVolatile()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}
   * with dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#isVolatile()}
   */
  @Test
  @DisplayName("Test isVolatile(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  void testIsVolatile_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse((new PDComplexFileSpecification(new COSDictionary())).isVolatile());
  }

  /**
   * Test {@link PDComplexFileSpecification#isVolatile()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#isVolatile()}
   */
  @Test
  @DisplayName("Test isVolatile(); given PDComplexFileSpecification(); then return 'false'")
  void testIsVolatile_givenPDComplexFileSpecification_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDComplexFileSpecification()).isVolatile());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFile()}.
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFile()}
   */
  @Test
  @DisplayName("Test getEmbeddedFile()")
  void testGetEmbeddedFile() {
    // Arrange
    COSStream str = new COSStream();
    COSObjectKey key = new COSObjectKey(1L, 1);

    str.setKey(key);
    PDEmbeddedFile file = new PDEmbeddedFile(str);

    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(new COSStream()));
    pdComplexFileSpecification.setEmbeddedFile(file);

    // Act and Assert
    assertSame(key, pdComplexFileSpecification.getEmbeddedFile().getCOSObject().getKey());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFile()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}
   * with dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFile()}
   */
  @Test
  @DisplayName("Test getEmbeddedFile(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  void testGetEmbeddedFile_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification(new COSDictionary())).getEmbeddedFile());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFile()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFile()}
   */
  @Test
  @DisplayName("Test getEmbeddedFile(); given PDComplexFileSpecification(); then return 'null'")
  void testGetEmbeddedFile_givenPDComplexFileSpecification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getEmbeddedFile());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFile()}.
   * <ul>
   *   <li>Then return COSObject Key is {@link COSObjectKey#COSObjectKey(long, int)}
   * with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFile()}
   */
  @Test
  @DisplayName("Test getEmbeddedFile(); then return COSObject Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetEmbeddedFile_thenReturnCOSObjectKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSStream str = new COSStream();
    COSObjectKey key = new COSObjectKey(1L, 1);

    str.setKey(key);
    PDEmbeddedFile file = new PDEmbeddedFile(str);

    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(file);

    // Act and Assert
    assertSame(key, pdComplexFileSpecification.getEmbeddedFile().getCOSObject().getKey());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFile()}.
   * <ul>
   *   <li>Then return CheckSum is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFile()}
   */
  @Test
  @DisplayName("Test getEmbeddedFile(); then return CheckSum is 'null'")
  void testGetEmbeddedFile_thenReturnCheckSumIsNull() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    COSStream str = new COSStream();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(str));

    // Act
    PDEmbeddedFile actualEmbeddedFile = pdComplexFileSpecification.getEmbeddedFile();

    // Assert
    assertNull(actualEmbeddedFile.getCheckSum());
    assertNull(actualEmbeddedFile.getMacCreator());
    assertNull(actualEmbeddedFile.getMacResFork());
    assertNull(actualEmbeddedFile.getMacSubtype());
    assertNull(actualEmbeddedFile.getSubtype());
    assertNull(actualEmbeddedFile.getCreationDate());
    assertNull(actualEmbeddedFile.getModDate());
    assertNull(actualEmbeddedFile.getDecodeParms());
    assertNull(actualEmbeddedFile.getFileDecodeParams());
    assertNull(actualEmbeddedFile.getMetadata());
    assertNull(actualEmbeddedFile.getFile());
    assertEquals(-1, actualEmbeddedFile.getDecodedStreamLength());
    assertEquals(-1, actualEmbeddedFile.getSize());
    assertEquals(0, actualEmbeddedFile.getLength());
    List<String> fileFilters = actualEmbeddedFile.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(str, actualEmbeddedFile.getCOSObject());
    assertSame(fileFilters, actualEmbeddedFile.getFilters());
  }

  /**
   * Test {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}.
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFile(PDEmbeddedFile)")
  void testSetEmbeddedFile() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification(new COSDictionary());
    COSStream str = new COSStream();

    // Act
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(str));

    // Assert
    PDEmbeddedFile embeddedFile = pdComplexFileSpecification.getEmbeddedFile();
    assertNull(embeddedFile.getCheckSum());
    assertNull(embeddedFile.getMacCreator());
    assertNull(embeddedFile.getMacResFork());
    assertNull(embeddedFile.getMacSubtype());
    assertNull(embeddedFile.getSubtype());
    assertNull(embeddedFile.getCreationDate());
    assertNull(embeddedFile.getModDate());
    assertNull(embeddedFile.getDecodeParms());
    assertNull(embeddedFile.getFileDecodeParams());
    assertNull(embeddedFile.getMetadata());
    assertNull(embeddedFile.getFile());
    assertEquals(-1, embeddedFile.getDecodedStreamLength());
    assertEquals(-1, embeddedFile.getSize());
    assertEquals(0, embeddedFile.getLength());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(str, embeddedFile.getCOSObject());
  }

  /**
   * Test {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}.
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFile(PDEmbeddedFile)")
  void testSetEmbeddedFile2() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(new COSStream()));
    COSStream str = new COSStream();

    // Act
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(str));

    // Assert
    PDEmbeddedFile embeddedFile = pdComplexFileSpecification.getEmbeddedFile();
    assertNull(embeddedFile.getCheckSum());
    assertNull(embeddedFile.getMacCreator());
    assertNull(embeddedFile.getMacResFork());
    assertNull(embeddedFile.getMacSubtype());
    assertNull(embeddedFile.getSubtype());
    assertNull(embeddedFile.getCreationDate());
    assertNull(embeddedFile.getModDate());
    assertNull(embeddedFile.getDecodeParms());
    assertNull(embeddedFile.getFileDecodeParams());
    assertNull(embeddedFile.getMetadata());
    assertNull(embeddedFile.getFile());
    assertEquals(-1, embeddedFile.getDecodedStreamLength());
    assertEquals(-1, embeddedFile.getSize());
    assertEquals(0, embeddedFile.getLength());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, embeddedFile.getCOSObject());
  }

  /**
   * Test {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}.
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFile(PDEmbeddedFile)")
  void testSetEmbeddedFile3() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(new COSStream()));

    // Act
    pdComplexFileSpecification.setEmbeddedFile(null);

    // Assert
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFile(PDEmbeddedFile); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetEmbeddedFile_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    COSStream str = new COSStream();
    str.setKey(new COSObjectKey(1L, 1));

    // Act
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(str));

    // Assert
    PDEmbeddedFile embeddedFile = pdComplexFileSpecification.getEmbeddedFile();
    assertNull(embeddedFile.getCheckSum());
    assertNull(embeddedFile.getMacCreator());
    assertNull(embeddedFile.getMacResFork());
    assertNull(embeddedFile.getMacSubtype());
    assertNull(embeddedFile.getSubtype());
    assertNull(embeddedFile.getCreationDate());
    assertNull(embeddedFile.getModDate());
    assertNull(embeddedFile.getDecodeParms());
    assertNull(embeddedFile.getFileDecodeParams());
    assertNull(embeddedFile.getMetadata());
    assertNull(embeddedFile.getFile());
    assertEquals(-1, embeddedFile.getDecodedStreamLength());
    assertEquals(-1, embeddedFile.getSize());
    assertEquals(0, embeddedFile.getLength());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, embeddedFile.getCOSObject());
  }

  /**
   * Test {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFile(PDEmbeddedFile); given 'true'; when COSStream() Direct is 'true'")
  void testSetEmbeddedFile_givenTrue_whenCOSStreamDirectIsTrue() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    COSStream str = new COSStream();
    str.setDirect(true);

    // Act
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(str));

    // Assert
    PDEmbeddedFile embeddedFile = pdComplexFileSpecification.getEmbeddedFile();
    assertNull(embeddedFile.getCheckSum());
    assertNull(embeddedFile.getMacCreator());
    assertNull(embeddedFile.getMacResFork());
    assertNull(embeddedFile.getMacSubtype());
    assertNull(embeddedFile.getSubtype());
    assertNull(embeddedFile.getCreationDate());
    assertNull(embeddedFile.getModDate());
    assertNull(embeddedFile.getDecodeParms());
    assertNull(embeddedFile.getFileDecodeParams());
    assertNull(embeddedFile.getMetadata());
    assertNull(embeddedFile.getFile());
    assertEquals(-1, embeddedFile.getDecodedStreamLength());
    assertEquals(-1, embeddedFile.getSize());
    assertEquals(0, embeddedFile.getLength());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, embeddedFile.getCOSObject());
  }

  /**
   * Test {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}.
   * <ul>
   *   <li>Then {@link PDComplexFileSpecification#PDComplexFileSpecification()}
   * COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFile(PDEmbeddedFile); then PDComplexFileSpecification() COSObject Values size is one")
  void testSetEmbeddedFile_thenPDComplexFileSpecificationCOSObjectValuesSizeIsOne() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setEmbeddedFile(null);

    // Assert
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}.
   * <ul>
   *   <li>Then {@link PDComplexFileSpecification#PDComplexFileSpecification()}
   * EmbeddedFile CheckSum is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFile(PDEmbeddedFile); then PDComplexFileSpecification() EmbeddedFile CheckSum is 'null'")
  void testSetEmbeddedFile_thenPDComplexFileSpecificationEmbeddedFileCheckSumIsNull() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    COSStream str = new COSStream();

    // Act
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(str));

    // Assert
    PDEmbeddedFile embeddedFile = pdComplexFileSpecification.getEmbeddedFile();
    assertNull(embeddedFile.getCheckSum());
    assertNull(embeddedFile.getMacCreator());
    assertNull(embeddedFile.getMacResFork());
    assertNull(embeddedFile.getMacSubtype());
    assertNull(embeddedFile.getSubtype());
    assertNull(embeddedFile.getCreationDate());
    assertNull(embeddedFile.getModDate());
    assertNull(embeddedFile.getDecodeParms());
    assertNull(embeddedFile.getFileDecodeParams());
    assertNull(embeddedFile.getMetadata());
    assertNull(embeddedFile.getFile());
    assertEquals(-1, embeddedFile.getDecodedStreamLength());
    assertEquals(-1, embeddedFile.getSize());
    assertEquals(0, embeddedFile.getLength());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, embeddedFile.getCOSObject());
  }

  /**
   * Test {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}.
   * <ul>
   *   <li>When {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFile(PDEmbeddedFile); when PDEmbeddedFile(COSStream) with str is 'null'")
  void testSetEmbeddedFile_whenPDEmbeddedFileWithStrIsNull() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile((COSStream) null));

    // Assert
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileDos()}.
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileDos()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileDos()")
  void testGetEmbeddedFileDos() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileDos());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileDos()}.
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileDos()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileDos()")
  void testGetEmbeddedFileDos2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(new COSStream()));
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileDos());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileDos()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileDos()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileDos(); given PDComplexFileSpecification()")
  void testGetEmbeddedFileDos_givenPDComplexFileSpecification() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getEmbeddedFileDos());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileDos()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}
   * with dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileDos()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileDos(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  void testGetEmbeddedFileDos_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification(new COSDictionary())).getEmbeddedFileDos());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileMac()}.
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileMac()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileMac()")
  void testGetEmbeddedFileMac() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileMac());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileMac()}.
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileMac()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileMac()")
  void testGetEmbeddedFileMac2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(new COSStream()));
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileMac());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileMac()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileMac()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileMac(); given PDComplexFileSpecification()")
  void testGetEmbeddedFileMac_givenPDComplexFileSpecification() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getEmbeddedFileMac());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileMac()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}
   * with dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileMac()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileMac(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  void testGetEmbeddedFileMac_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification(new COSDictionary())).getEmbeddedFileMac());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnix()}.
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnix()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnix()")
  void testGetEmbeddedFileUnix() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileUnix());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnix()}.
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnix()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnix()")
  void testGetEmbeddedFileUnix2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(new COSStream()));
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileUnix());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnix()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnix()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnix(); given PDComplexFileSpecification()")
  void testGetEmbeddedFileUnix_givenPDComplexFileSpecification() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getEmbeddedFileUnix());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnix()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}
   * with dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnix()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnix(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  void testGetEmbeddedFileUnix_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification(new COSDictionary())).getEmbeddedFileUnix());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}.
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnicode()")
  void testGetEmbeddedFileUnicode() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification(new COSDictionary())).getEmbeddedFileUnicode());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}.
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnicode()")
  void testGetEmbeddedFileUnicode2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileUnicode());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}.
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnicode()")
  void testGetEmbeddedFileUnicode3() {
    // Arrange
    COSStream str = new COSStream();
    COSObjectKey key = new COSObjectKey(1L, 1);

    str.setKey(key);
    PDEmbeddedFile file = new PDEmbeddedFile(str);

    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFileUnicode(file);

    // Act and Assert
    assertSame(key, pdComplexFileSpecification.getEmbeddedFileUnicode().getCOSObject().getKey());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}.
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnicode()")
  void testGetEmbeddedFileUnicode4() {
    // Arrange
    COSStream str = new COSStream();
    COSObjectKey key = new COSObjectKey(1L, 1);

    str.setKey(key);
    PDEmbeddedFile file = new PDEmbeddedFile(str);

    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));
    pdComplexFileSpecification.setEmbeddedFileUnicode(file);

    // Act and Assert
    assertSame(key, pdComplexFileSpecification.getEmbeddedFileUnicode().getCOSObject().getKey());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnicode(); given PDComplexFileSpecification(); then return 'null'")
  void testGetEmbeddedFileUnicode_givenPDComplexFileSpecification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getEmbeddedFileUnicode());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}.
   * <ul>
   *   <li>Then return CheckSum is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnicode(); then return CheckSum is 'null'")
  void testGetEmbeddedFileUnicode_thenReturnCheckSumIsNull() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    COSStream str = new COSStream();
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(str));

    // Act
    PDEmbeddedFile actualEmbeddedFileUnicode = pdComplexFileSpecification.getEmbeddedFileUnicode();

    // Assert
    assertNull(actualEmbeddedFileUnicode.getCheckSum());
    assertNull(actualEmbeddedFileUnicode.getMacCreator());
    assertNull(actualEmbeddedFileUnicode.getMacResFork());
    assertNull(actualEmbeddedFileUnicode.getMacSubtype());
    assertNull(actualEmbeddedFileUnicode.getSubtype());
    assertNull(actualEmbeddedFileUnicode.getCreationDate());
    assertNull(actualEmbeddedFileUnicode.getModDate());
    assertNull(actualEmbeddedFileUnicode.getDecodeParms());
    assertNull(actualEmbeddedFileUnicode.getFileDecodeParams());
    assertNull(actualEmbeddedFileUnicode.getMetadata());
    assertNull(actualEmbeddedFileUnicode.getFile());
    assertEquals(-1, actualEmbeddedFileUnicode.getDecodedStreamLength());
    assertEquals(-1, actualEmbeddedFileUnicode.getSize());
    assertEquals(0, actualEmbeddedFileUnicode.getLength());
    List<String> fileFilters = actualEmbeddedFileUnicode.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(str, actualEmbeddedFileUnicode.getCOSObject());
    assertSame(fileFilters, actualEmbeddedFileUnicode.getFilters());
  }

  /**
   * Test
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}.
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFileUnicode(PDEmbeddedFile)")
  void testSetEmbeddedFileUnicode() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    COSStream str = new COSStream();

    // Act
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(str));

    // Assert
    PDEmbeddedFile embeddedFileUnicode = pdComplexFileSpecification.getEmbeddedFileUnicode();
    assertNull(embeddedFileUnicode.getCheckSum());
    assertNull(embeddedFileUnicode.getMacCreator());
    assertNull(embeddedFileUnicode.getMacResFork());
    assertNull(embeddedFileUnicode.getMacSubtype());
    assertNull(embeddedFileUnicode.getSubtype());
    assertNull(embeddedFileUnicode.getCreationDate());
    assertNull(embeddedFileUnicode.getModDate());
    assertNull(embeddedFileUnicode.getDecodeParms());
    assertNull(embeddedFileUnicode.getFileDecodeParams());
    assertNull(embeddedFileUnicode.getMetadata());
    assertNull(embeddedFileUnicode.getFile());
    assertEquals(-1, embeddedFileUnicode.getDecodedStreamLength());
    assertEquals(-1, embeddedFileUnicode.getSize());
    assertEquals(0, embeddedFileUnicode.getLength());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, embeddedFileUnicode.getCOSObject());
  }

  /**
   * Test
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}.
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFileUnicode(PDEmbeddedFile)")
  void testSetEmbeddedFileUnicode2() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification(new COSDictionary());
    COSStream str = new COSStream();

    // Act
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(str));

    // Assert
    PDEmbeddedFile embeddedFileUnicode = pdComplexFileSpecification.getEmbeddedFileUnicode();
    assertNull(embeddedFileUnicode.getCheckSum());
    assertNull(embeddedFileUnicode.getMacCreator());
    assertNull(embeddedFileUnicode.getMacResFork());
    assertNull(embeddedFileUnicode.getMacSubtype());
    assertNull(embeddedFileUnicode.getSubtype());
    assertNull(embeddedFileUnicode.getCreationDate());
    assertNull(embeddedFileUnicode.getModDate());
    assertNull(embeddedFileUnicode.getDecodeParms());
    assertNull(embeddedFileUnicode.getFileDecodeParams());
    assertNull(embeddedFileUnicode.getMetadata());
    assertNull(embeddedFileUnicode.getFile());
    assertEquals(-1, embeddedFileUnicode.getDecodedStreamLength());
    assertEquals(-1, embeddedFileUnicode.getSize());
    assertEquals(0, embeddedFileUnicode.getLength());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(str, embeddedFileUnicode.getCOSObject());
  }

  /**
   * Test
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}.
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFileUnicode(PDEmbeddedFile)")
  void testSetEmbeddedFileUnicode3() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setEmbeddedFileUnicode(null);

    // Assert
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}.
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFileUnicode(PDEmbeddedFile)")
  void testSetEmbeddedFileUnicode4() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));
    COSStream str = new COSStream();

    // Act
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(str));

    // Assert
    PDEmbeddedFile embeddedFileUnicode = pdComplexFileSpecification.getEmbeddedFileUnicode();
    assertNull(embeddedFileUnicode.getCheckSum());
    assertNull(embeddedFileUnicode.getMacCreator());
    assertNull(embeddedFileUnicode.getMacResFork());
    assertNull(embeddedFileUnicode.getMacSubtype());
    assertNull(embeddedFileUnicode.getSubtype());
    assertNull(embeddedFileUnicode.getCreationDate());
    assertNull(embeddedFileUnicode.getModDate());
    assertNull(embeddedFileUnicode.getDecodeParms());
    assertNull(embeddedFileUnicode.getFileDecodeParams());
    assertNull(embeddedFileUnicode.getMetadata());
    assertNull(embeddedFileUnicode.getFile());
    assertEquals(-1, embeddedFileUnicode.getDecodedStreamLength());
    assertEquals(-1, embeddedFileUnicode.getSize());
    assertEquals(0, embeddedFileUnicode.getLength());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, embeddedFileUnicode.getCOSObject());
  }

  /**
   * Test
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}.
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFileUnicode(PDEmbeddedFile)")
  void testSetEmbeddedFileUnicode5() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act
    pdComplexFileSpecification.setEmbeddedFileUnicode(null);

    // Assert
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFileUnicode(PDEmbeddedFile); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetEmbeddedFileUnicode_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    COSStream str = new COSStream();
    str.setKey(new COSObjectKey(1L, 1));

    // Act
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(str));

    // Assert
    PDEmbeddedFile embeddedFileUnicode = pdComplexFileSpecification.getEmbeddedFileUnicode();
    assertNull(embeddedFileUnicode.getCheckSum());
    assertNull(embeddedFileUnicode.getMacCreator());
    assertNull(embeddedFileUnicode.getMacResFork());
    assertNull(embeddedFileUnicode.getMacSubtype());
    assertNull(embeddedFileUnicode.getSubtype());
    assertNull(embeddedFileUnicode.getCreationDate());
    assertNull(embeddedFileUnicode.getModDate());
    assertNull(embeddedFileUnicode.getDecodeParms());
    assertNull(embeddedFileUnicode.getFileDecodeParams());
    assertNull(embeddedFileUnicode.getMetadata());
    assertNull(embeddedFileUnicode.getFile());
    assertEquals(-1, embeddedFileUnicode.getDecodedStreamLength());
    assertEquals(-1, embeddedFileUnicode.getSize());
    assertEquals(0, embeddedFileUnicode.getLength());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, embeddedFileUnicode.getCOSObject());
  }

  /**
   * Test
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFileUnicode(PDEmbeddedFile); given 'true'; when COSStream() Direct is 'true'")
  void testSetEmbeddedFileUnicode_givenTrue_whenCOSStreamDirectIsTrue() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    COSStream str = new COSStream();
    str.setDirect(true);

    // Act
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(str));

    // Assert
    PDEmbeddedFile embeddedFileUnicode = pdComplexFileSpecification.getEmbeddedFileUnicode();
    assertNull(embeddedFileUnicode.getCheckSum());
    assertNull(embeddedFileUnicode.getMacCreator());
    assertNull(embeddedFileUnicode.getMacResFork());
    assertNull(embeddedFileUnicode.getMacSubtype());
    assertNull(embeddedFileUnicode.getSubtype());
    assertNull(embeddedFileUnicode.getCreationDate());
    assertNull(embeddedFileUnicode.getModDate());
    assertNull(embeddedFileUnicode.getDecodeParms());
    assertNull(embeddedFileUnicode.getFileDecodeParams());
    assertNull(embeddedFileUnicode.getMetadata());
    assertNull(embeddedFileUnicode.getFile());
    assertEquals(-1, embeddedFileUnicode.getDecodedStreamLength());
    assertEquals(-1, embeddedFileUnicode.getSize());
    assertEquals(0, embeddedFileUnicode.getLength());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, embeddedFileUnicode.getCOSObject());
  }

  /**
   * Test
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}.
   * <ul>
   *   <li>When {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFileUnicode(PDEmbeddedFile); when PDEmbeddedFile(COSStream) with str is 'null'")
  void testSetEmbeddedFileUnicode_whenPDEmbeddedFileWithStrIsNull() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile((COSStream) null));

    // Assert
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDComplexFileSpecification#setFileDescription(String)}.
   * <p>
   * Method under test:
   * {@link PDComplexFileSpecification#setFileDescription(String)}
   */
  @Test
  @DisplayName("Test setFileDescription(String)")
  void testSetFileDescription() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setFileDescription("The characteristics of someone or something");

    // Assert
    assertEquals("The characteristics of someone or something", pdComplexFileSpecification.getFileDescription());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileDescription()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}
   * with dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFileDescription()}
   */
  @Test
  @DisplayName("Test getFileDescription(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  void testGetFileDescription_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification(new COSDictionary())).getFileDescription());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileDescription()}.
   * <ul>
   *   <li>Given
   * {@link PDComplexFileSpecification#PDComplexFileSpecification()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFileDescription()}
   */
  @Test
  @DisplayName("Test getFileDescription(); given PDComplexFileSpecification(); then return 'null'")
  void testGetFileDescription_givenPDComplexFileSpecification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getFileDescription());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileDescription()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFileDescription()}
   */
  @Test
  @DisplayName("Test getFileDescription(); then return empty string")
  void testGetFileDescription_thenReturnEmptyString() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFileDescription("");

    // Act and Assert
    assertEquals("", pdComplexFileSpecification.getFileDescription());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileDescription()}.
   * <ul>
   *   <li>Then return {@code The characteristics of someone or something}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDComplexFileSpecification#getFileDescription()}
   */
  @Test
  @DisplayName("Test getFileDescription(); then return 'The characteristics of someone or something'")
  void testGetFileDescription_thenReturnTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFileDescription("The characteristics of someone or something");

    // Act and Assert
    assertEquals("The characteristics of someone or something", pdComplexFileSpecification.getFileDescription());
  }
}
