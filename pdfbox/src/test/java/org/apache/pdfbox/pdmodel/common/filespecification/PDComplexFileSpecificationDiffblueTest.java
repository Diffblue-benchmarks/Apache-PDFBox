package org.apache.pdfbox.pdmodel.common.filespecification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDComplexFileSpecificationDiffblueTest {
  /**
   * Test {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   *
   * <p>Method under test: {@link PDComplexFileSpecification#PDComplexFileSpecification()}
   */
  @Test
  @DisplayName("Test new PDComplexFileSpecification()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.<init>()"})
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
    assertNull(actualPdComplexFileSpecification.getEmbeddedFile());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileDos());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileMac());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileUnicode());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileUnix());
    assertFalse(actualPdComplexFileSpecification.isVolatile());
  }

  /**
   * Test {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}.
   *
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDComplexFileSpecification(COSDictionary); then return COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.<init>(COSDictionary)"})
  void testNewPDComplexFileSpecification_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDComplexFileSpecification actualPdComplexFileSpecification =
        new PDComplexFileSpecification(dict);

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
   * Test {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDComplexFileSpecification(COSDictionary); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.<init>(COSDictionary)"})
  void testNewPDComplexFileSpecification_whenNull() {
    // Arrange and Act
    PDComplexFileSpecification actualPdComplexFileSpecification =
        new PDComplexFileSpecification(null);

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
  }

  /**
   * Test {@link PDComplexFileSpecification#getCOSObject()}.
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDComplexFileSpecification.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDComplexFileSpecification().getCOSObject();

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
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()} FileUnicode is
   *       {@code File}.
   *   <li>Then return {@code File}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFilename()}
   */
  @Test
  @DisplayName(
      "Test getFilename(); given PDComplexFileSpecification() FileUnicode is 'File'; then return 'File'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFilename()"})
  void testGetFilename_givenPDComplexFileSpecificationFileUnicodeIsFile_thenReturnFile() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFileUnicode("File");

    // Act and Assert
    assertEquals("File", pdComplexFileSpecification.getFilename());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFilename()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFilename()}
   */
  @Test
  @DisplayName("Test getFilename(); given PDComplexFileSpecification(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFilename()"})
  void testGetFilename_givenPDComplexFileSpecification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification().getFilename());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFilename()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFilename()}
   */
  @Test
  @DisplayName("Test getFilename(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFilename()"})
  void testGetFilename_thenReturnEmptyString() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFileUnicode("");

    // Act and Assert
    assertEquals("", pdComplexFileSpecification.getFilename());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileUnicode()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileUnicode()}
   */
  @Test
  @DisplayName("Test getFileUnicode(); given PDComplexFileSpecification(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileUnicode()"})
  void testGetFileUnicode_givenPDComplexFileSpecification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification().getFileUnicode());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileUnicode()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileUnicode()}
   */
  @Test
  @DisplayName("Test getFileUnicode(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileUnicode()"})
  void testGetFileUnicode_thenReturnEmptyString() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFileUnicode("");

    // Act and Assert
    assertEquals("", pdComplexFileSpecification.getFileUnicode());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileUnicode()}.
   *
   * <ul>
   *   <li>Then return {@code File}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileUnicode()}
   */
  @Test
  @DisplayName("Test getFileUnicode(); then return 'File'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileUnicode()"})
  void testGetFileUnicode_thenReturnFile() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFileUnicode("File");

    // Act and Assert
    assertEquals("File", pdComplexFileSpecification.getFileUnicode());
  }

  /**
   * Test {@link PDComplexFileSpecification#setFileUnicode(String)}.
   *
   * <ul>
   *   <li>Then {@link PDComplexFileSpecification#PDComplexFileSpecification()} COSObject Values
   *       size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setFileUnicode(String)}
   */
  @Test
  @DisplayName(
      "Test setFileUnicode(String); then PDComplexFileSpecification() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setFileUnicode(String)"})
  void testSetFileUnicode_thenPDComplexFileSpecificationCOSObjectValuesSizeIsOne() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setFileUnicode(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDComplexFileSpecification#setFileUnicode(String)}.
   *
   * <ul>
   *   <li>When {@code File}.
   *   <li>Then {@link PDComplexFileSpecification#PDComplexFileSpecification()} FileUnicode is
   *       {@code File}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setFileUnicode(String)}
   */
  @Test
  @DisplayName(
      "Test setFileUnicode(String); when 'File'; then PDComplexFileSpecification() FileUnicode is 'File'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setFileUnicode(String)"})
  void testSetFileUnicode_whenFile_thenPDComplexFileSpecificationFileUnicodeIsFile() {
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
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()} File is {@code
   *       File}.
   *   <li>Then return {@code File}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFile()}
   */
  @Test
  @DisplayName(
      "Test getFile(); given PDComplexFileSpecification() File is 'File'; then return 'File'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFile()"})
  void testGetFile_givenPDComplexFileSpecificationFileIsFile_thenReturnFile() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFile("File");

    // Act and Assert
    assertEquals("File", pdComplexFileSpecification.getFile());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFile()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given PDComplexFileSpecification(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFile()"})
  void testGetFile_givenPDComplexFileSpecification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification().getFile());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFile()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFile()"})
  void testGetFile_thenReturnEmptyString() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFile("");

    // Act and Assert
    assertEquals("", pdComplexFileSpecification.getFile());
  }

  /**
   * Test {@link PDComplexFileSpecification#setFile(String)}.
   *
   * <ul>
   *   <li>When {@code File}.
   *   <li>Then {@link PDComplexFileSpecification#PDComplexFileSpecification()} File is {@code
   *       File}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setFile(String)}
   */
  @Test
  @DisplayName(
      "Test setFile(String); when 'File'; then PDComplexFileSpecification() File is 'File'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setFile(String)"})
  void testSetFile_whenFile_thenPDComplexFileSpecificationFileIsFile() {
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
   * Test {@link PDComplexFileSpecification#setFile(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDComplexFileSpecification#PDComplexFileSpecification()} COSObject Values
   *       size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setFile(String)}
   */
  @Test
  @DisplayName(
      "Test setFile(String); when 'null'; then PDComplexFileSpecification() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setFile(String)"})
  void testSetFile_whenNull_thenPDComplexFileSpecificationCOSObjectValuesSizeIsOne() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setFile(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileDos()}.
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileDos()}
   */
  @Test
  @DisplayName("Test getFileDos()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileDos()"})
  void testGetFileDos() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification().getFileDos());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileMac()}.
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileMac()}
   */
  @Test
  @DisplayName("Test getFileMac()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileMac()"})
  void testGetFileMac() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification().getFileMac());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileUnix()}.
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileUnix()}
   */
  @Test
  @DisplayName("Test getFileUnix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileUnix()"})
  void testGetFileUnix() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification().getFileUnix());
  }

  /**
   * Test {@link PDComplexFileSpecification#setVolatile(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link PDComplexFileSpecification#PDComplexFileSpecification()} Volatile.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setVolatile(boolean)}
   */
  @Test
  @DisplayName(
      "Test setVolatile(boolean); when 'false'; then not PDComplexFileSpecification() Volatile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setVolatile(boolean)"})
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
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDComplexFileSpecification#PDComplexFileSpecification()} Volatile.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setVolatile(boolean)}
   */
  @Test
  @DisplayName("Test setVolatile(boolean); when 'true'; then PDComplexFileSpecification() Volatile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setVolatile(boolean)"})
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
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()} Volatile is {@code
   *       false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#isVolatile()}
   */
  @Test
  @DisplayName(
      "Test isVolatile(); given PDComplexFileSpecification() Volatile is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDComplexFileSpecification.isVolatile()"})
  void testIsVolatile_givenPDComplexFileSpecificationVolatileIsFalse_thenReturnFalse() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setVolatile(false);

    // Act and Assert
    assertFalse(pdComplexFileSpecification.isVolatile());
  }

  /**
   * Test {@link PDComplexFileSpecification#isVolatile()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()} Volatile is {@code
   *       true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#isVolatile()}
   */
  @Test
  @DisplayName(
      "Test isVolatile(); given PDComplexFileSpecification() Volatile is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDComplexFileSpecification.isVolatile()"})
  void testIsVolatile_givenPDComplexFileSpecificationVolatileIsTrue_thenReturnTrue() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setVolatile(true);

    // Act and Assert
    assertTrue(pdComplexFileSpecification.isVolatile());
  }

  /**
   * Test {@link PDComplexFileSpecification#isVolatile()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#isVolatile()}
   */
  @Test
  @DisplayName("Test isVolatile(); given PDComplexFileSpecification(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDComplexFileSpecification.isVolatile()"})
  void testIsVolatile_givenPDComplexFileSpecification_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDComplexFileSpecification().isVolatile());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFile()}.
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFile()}
   */
  @Test
  @DisplayName("Test getEmbeddedFile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFile()"})
  void testGetEmbeddedFile() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(new COSStream()));
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
   * Test {@link PDComplexFileSpecification#getEmbeddedFile()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFile()}
   */
  @Test
  @DisplayName("Test getEmbeddedFile(); given PDComplexFileSpecification(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFile()"})
  void testGetEmbeddedFile_givenPDComplexFileSpecification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification().getEmbeddedFile());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFile()}.
   *
   * <ul>
   *   <li>Then return COSObject Key is {@link COSObjectKey#COSObjectKey(long, int)} with num is one
   *       and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFile()}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedFile(); then return COSObject Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFile()"})
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
   *
   * <ul>
   *   <li>Then return CheckSum is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFile()}
   */
  @Test
  @DisplayName("Test getEmbeddedFile(); then return CheckSum is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFile()"})
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
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFile(PDEmbeddedFile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFile(PDEmbeddedFile)"})
  void testSetEmbeddedFile() throws IOException {
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
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFile(PDEmbeddedFile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFile(PDEmbeddedFile)"})
  void testSetEmbeddedFile2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(new COSStream()));

    // Act
    pdComplexFileSpecification.setEmbeddedFile(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedFile(PDEmbeddedFile); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFile(PDEmbeddedFile)"})
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
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedFile(PDEmbeddedFile); given 'true'; when COSStream() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFile(PDEmbeddedFile)"})
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
   *
   * <ul>
   *   <li>Then {@link PDComplexFileSpecification#PDComplexFileSpecification()} COSObject Values
   *       size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedFile(PDEmbeddedFile); then PDComplexFileSpecification() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFile(PDEmbeddedFile)"})
  void testSetEmbeddedFile_thenPDComplexFileSpecificationCOSObjectValuesSizeIsOne() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setEmbeddedFile(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}.
   *
   * <ul>
   *   <li>Then {@link PDComplexFileSpecification#PDComplexFileSpecification()} EmbeddedFile
   *       CheckSum is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedFile(PDEmbeddedFile); then PDComplexFileSpecification() EmbeddedFile CheckSum is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFile(PDEmbeddedFile)"})
  void testSetEmbeddedFile_thenPDComplexFileSpecificationEmbeddedFileCheckSumIsNull()
      throws IOException {
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
   *
   * <ul>
   *   <li>When {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedFile(PDEmbeddedFile); when PDEmbeddedFile(COSStream) with str is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFile(PDEmbeddedFile)"})
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
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileDos()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileDos()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileDos()"})
  void testGetEmbeddedFileDos() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileDos());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileDos()}.
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileDos()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileDos()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileDos()"})
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
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileDos()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileDos(); given PDComplexFileSpecification()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileDos()"})
  void testGetEmbeddedFileDos_givenPDComplexFileSpecification() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification().getEmbeddedFileDos());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileMac()}.
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileMac()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileMac()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileMac()"})
  void testGetEmbeddedFileMac() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileMac());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileMac()}.
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileMac()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileMac()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileMac()"})
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
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileMac()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileMac(); given PDComplexFileSpecification()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileMac()"})
  void testGetEmbeddedFileMac_givenPDComplexFileSpecification() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification().getEmbeddedFileMac());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnix()}.
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnix()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileUnix()"})
  void testGetEmbeddedFileUnix() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileUnix());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnix()}.
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnix()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileUnix()"})
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
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnix()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnix(); given PDComplexFileSpecification()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileUnix()"})
  void testGetEmbeddedFileUnix_givenPDComplexFileSpecification() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification().getEmbeddedFileUnix());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}.
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnicode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileUnicode()"})
  void testGetEmbeddedFileUnicode() {
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
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedFileUnicode(); given PDComplexFileSpecification(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileUnicode()"})
  void testGetEmbeddedFileUnicode_givenPDComplexFileSpecification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification().getEmbeddedFileUnicode());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}.
   *
   * <ul>
   *   <li>Then return CheckSum is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnicode(); then return CheckSum is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileUnicode()"})
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
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}.
   *
   * <ul>
   *   <li>Then return CheckSum is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnicode(); then return CheckSum is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileUnicode()"})
  void testGetEmbeddedFileUnicode_thenReturnCheckSumIsNull2() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    COSStream str = new COSStream();
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(str));
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

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
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnicode(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileUnicode()"})
  void testGetEmbeddedFileUnicode_thenReturnNull() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileUnicode());
  }

  /**
   * Test {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}.
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFileUnicode(PDEmbeddedFile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFileUnicode(PDEmbeddedFile)"})
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
   * Test {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}.
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFileUnicode(PDEmbeddedFile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFileUnicode(PDEmbeddedFile)"})
  void testSetEmbeddedFileUnicode2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setEmbeddedFileUnicode(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}.
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFileUnicode(PDEmbeddedFile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFileUnicode(PDEmbeddedFile)"})
  void testSetEmbeddedFileUnicode3() throws IOException {
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
   * Test {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}.
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFileUnicode(PDEmbeddedFile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFileUnicode(PDEmbeddedFile)"})
  void testSetEmbeddedFileUnicode4() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act
    pdComplexFileSpecification.setEmbeddedFileUnicode(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedFileUnicode(PDEmbeddedFile); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFileUnicode(PDEmbeddedFile)"})
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
   * Test {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedFileUnicode(PDEmbeddedFile); given 'true'; when COSStream() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFileUnicode(PDEmbeddedFile)"})
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
   * Test {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}.
   *
   * <ul>
   *   <li>When {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedFileUnicode(PDEmbeddedFile); when PDEmbeddedFile(COSStream) with str is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFileUnicode(PDEmbeddedFile)"})
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
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setFileDescription(String)}
   */
  @Test
  @DisplayName("Test setFileDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setFileDescription(String)"})
  void testSetFileDescription() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setFileDescription("The characteristics of someone or something");

    // Assert
    assertEquals(
        "The characteristics of someone or something",
        pdComplexFileSpecification.getFileDescription());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDComplexFileSpecification#setFileDescription(String)}.
   *
   * <ul>
   *   <li>Then {@link PDComplexFileSpecification#PDComplexFileSpecification()} COSObject Values
   *       size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setFileDescription(String)}
   */
  @Test
  @DisplayName(
      "Test setFileDescription(String); then PDComplexFileSpecification() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setFileDescription(String)"})
  void testSetFileDescription_thenPDComplexFileSpecificationCOSObjectValuesSizeIsOne() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setFileDescription(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileDescription()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileDescription()}
   */
  @Test
  @DisplayName("Test getFileDescription(); given PDComplexFileSpecification(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileDescription()"})
  void testGetFileDescription_givenPDComplexFileSpecification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification().getFileDescription());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileDescription()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileDescription()}
   */
  @Test
  @DisplayName("Test getFileDescription(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileDescription()"})
  void testGetFileDescription_thenReturnEmptyString() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFileDescription("");

    // Act and Assert
    assertEquals("", pdComplexFileSpecification.getFileDescription());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileDescription()}.
   *
   * <ul>
   *   <li>Then return {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileDescription()}
   */
  @Test
  @DisplayName(
      "Test getFileDescription(); then return 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileDescription()"})
  void testGetFileDescription_thenReturnTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFileDescription("The characteristics of someone or something");

    // Act and Assert
    assertEquals(
        "The characteristics of someone or something",
        pdComplexFileSpecification.getFileDescription());
  }
}
