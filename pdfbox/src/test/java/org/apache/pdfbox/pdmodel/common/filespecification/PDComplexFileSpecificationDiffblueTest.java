package org.apache.pdfbox.pdmodel.common.filespecification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PDComplexFileSpecificationDiffblueTest {
  @Mock private COSDictionary cOSDictionary;

  @InjectMocks private PDComplexFileSpecification pDComplexFileSpecification;

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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getString(COSName)} return {@code null}.
   *   <li>Then calls {@link COSDictionary#getString(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFilename()}
   */
  @Test
  @DisplayName(
      "Test getFilename(); given COSDictionary getString(COSName) return 'null'; then calls getString(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFilename()"})
  void testGetFilename_givenCOSDictionaryGetStringReturnNull_thenCallsGetString() {
    // Arrange
    when(cOSDictionary.getString(Mockito.<COSName>any())).thenReturn(null);

    // Act
    String actualFilename = pDComplexFileSpecification.getFilename();

    // Assert
    verify(cOSDictionary, atLeast(1)).getString(Mockito.<COSName>any());
    assertNull(actualFilename);
  }

  /**
   * Test {@link PDComplexFileSpecification#getFilename()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getString(COSName)} return {@code
   *       String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFilename()}
   */
  @Test
  @DisplayName(
      "Test getFilename(); given COSDictionary getString(COSName) return 'String'; then return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFilename()"})
  void testGetFilename_givenCOSDictionaryGetStringReturnString_thenReturnString() {
    // Arrange
    when(cOSDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    // Act
    String actualFilename = pDComplexFileSpecification.getFilename();

    // Assert
    verify(cOSDictionary).getString(isA(COSName.class));
    assertEquals("String", actualFilename);
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
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)} with
   *       dict is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFilename()}
   */
  @Test
  @DisplayName(
      "Test getFilename(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFilename()"})
  void testGetFilename_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification(new COSDictionary()).getFilename());
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getString(COSName)} return {@code
   *       String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileUnicode()}
   */
  @Test
  @DisplayName(
      "Test getFileUnicode(); given COSDictionary getString(COSName) return 'String'; then return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileUnicode()"})
  void testGetFileUnicode_givenCOSDictionaryGetStringReturnString_thenReturnString() {
    // Arrange
    when(cOSDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    // Act
    String actualFileUnicode = pDComplexFileSpecification.getFileUnicode();

    // Assert
    verify(cOSDictionary).getString(isA(COSName.class));
    assertEquals("String", actualFileUnicode);
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileUnicode()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)} with
   *       dict is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileUnicode()}
   */
  @Test
  @DisplayName(
      "Test getFileUnicode(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileUnicode()"})
  void testGetFileUnicode_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification(new COSDictionary()).getFileUnicode());
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setString(COSName, String)} does
   *       nothing.
   *   <li>Then calls {@link COSDictionary#setString(COSName, String)}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setFileUnicode(String)}
   */
  @Test
  @DisplayName(
      "Test setFileUnicode(String); given COSDictionary setString(COSName, String) does nothing; then calls setString(COSName, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setFileUnicode(String)"})
  void testSetFileUnicode_givenCOSDictionarySetStringDoesNothing_thenCallsSetString() {
    // Arrange
    doNothing().when(cOSDictionary).setString(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pDComplexFileSpecification.setFileUnicode("File");

    // Assert
    verify(cOSDictionary).setString(isA(COSName.class), eq("File"));
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
   *   <li>Then {@link PDComplexFileSpecification#PDComplexFileSpecification()} FileUnicode is
   *       {@code File}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setFileUnicode(String)}
   */
  @Test
  @DisplayName(
      "Test setFileUnicode(String); then PDComplexFileSpecification() FileUnicode is 'File'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setFileUnicode(String)"})
  void testSetFileUnicode_thenPDComplexFileSpecificationFileUnicodeIsFile() {
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getString(COSName)} return {@code
   *       String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFile()}
   */
  @Test
  @DisplayName(
      "Test getFile(); given COSDictionary getString(COSName) return 'String'; then return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFile()"})
  void testGetFile_givenCOSDictionaryGetStringReturnString_thenReturnString() {
    // Arrange
    when(cOSDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    // Act
    String actualFile = pDComplexFileSpecification.getFile();

    // Assert
    verify(cOSDictionary).getString(isA(COSName.class));
    assertEquals("String", actualFile);
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
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)} with
   *       dict is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFile()}
   */
  @Test
  @DisplayName(
      "Test getFile(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFile()"})
  void testGetFile_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification(new COSDictionary()).getFile());
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setString(COSName, String)} does
   *       nothing.
   *   <li>When {@code File}.
   *   <li>Then calls {@link COSDictionary#setString(COSName, String)}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setFile(String)}
   */
  @Test
  @DisplayName(
      "Test setFile(String); given COSDictionary setString(COSName, String) does nothing; when 'File'; then calls setString(COSName, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setFile(String)"})
  void testSetFile_givenCOSDictionarySetStringDoesNothing_whenFile_thenCallsSetString() {
    // Arrange
    doNothing().when(cOSDictionary).setString(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pDComplexFileSpecification.setFile("File");

    // Assert
    verify(cOSDictionary).setString(isA(COSName.class), eq("File"));
  }

  /**
   * Test {@link PDComplexFileSpecification#setFile(String)}.
   *
   * <ul>
   *   <li>Then {@link PDComplexFileSpecification#PDComplexFileSpecification()} File is {@code
   *       File}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setFile(String)}
   */
  @Test
  @DisplayName("Test setFile(String); then PDComplexFileSpecification() File is 'File'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setFile(String)"})
  void testSetFile_thenPDComplexFileSpecificationFileIsFile() {
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
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getString(COSName)} return {@code
   *       String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileDos()}
   */
  @Test
  @DisplayName(
      "Test getFileDos(); given COSDictionary getString(COSName) return 'String'; then return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileDos()"})
  void testGetFileDos_givenCOSDictionaryGetStringReturnString_thenReturnString() {
    // Arrange
    when(cOSDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    // Act
    String actualFileDos = pDComplexFileSpecification.getFileDos();

    // Assert
    verify(cOSDictionary).getString(isA(COSName.class));
    assertEquals("String", actualFileDos);
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileDos()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)} with
   *       dict is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileDos()}
   */
  @Test
  @DisplayName(
      "Test getFileDos(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileDos()"})
  void testGetFileDos_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification(new COSDictionary()).getFileDos());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileDos()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileDos()}
   */
  @Test
  @DisplayName("Test getFileDos(); given PDComplexFileSpecification(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileDos()"})
  void testGetFileDos_givenPDComplexFileSpecification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification().getFileDos());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileMac()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getString(COSName)} return {@code
   *       String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileMac()}
   */
  @Test
  @DisplayName(
      "Test getFileMac(); given COSDictionary getString(COSName) return 'String'; then return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileMac()"})
  void testGetFileMac_givenCOSDictionaryGetStringReturnString_thenReturnString() {
    // Arrange
    when(cOSDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    // Act
    String actualFileMac = pDComplexFileSpecification.getFileMac();

    // Assert
    verify(cOSDictionary).getString(isA(COSName.class));
    assertEquals("String", actualFileMac);
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileMac()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)} with
   *       dict is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileMac()}
   */
  @Test
  @DisplayName(
      "Test getFileMac(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileMac()"})
  void testGetFileMac_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification(new COSDictionary()).getFileMac());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileMac()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileMac()}
   */
  @Test
  @DisplayName("Test getFileMac(); given PDComplexFileSpecification(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileMac()"})
  void testGetFileMac_givenPDComplexFileSpecification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification().getFileMac());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileUnix()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getString(COSName)} return {@code
   *       String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileUnix()}
   */
  @Test
  @DisplayName(
      "Test getFileUnix(); given COSDictionary getString(COSName) return 'String'; then return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileUnix()"})
  void testGetFileUnix_givenCOSDictionaryGetStringReturnString_thenReturnString() {
    // Arrange
    when(cOSDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    // Act
    String actualFileUnix = pDComplexFileSpecification.getFileUnix();

    // Assert
    verify(cOSDictionary).getString(isA(COSName.class));
    assertEquals("String", actualFileUnix);
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileUnix()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)} with
   *       dict is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileUnix()}
   */
  @Test
  @DisplayName(
      "Test getFileUnix(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileUnix()"})
  void testGetFileUnix_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification(new COSDictionary()).getFileUnix());
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileUnix()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileUnix()}
   */
  @Test
  @DisplayName("Test getFileUnix(); given PDComplexFileSpecification(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileUnix()"})
  void testGetFileUnix_givenPDComplexFileSpecification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification().getFileUnix());
  }

  /**
   * Test {@link PDComplexFileSpecification#setVolatile(boolean)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setBoolean(COSName, boolean)} does
   *       nothing.
   *   <li>Then calls {@link COSDictionary#setBoolean(COSName, boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setVolatile(boolean)}
   */
  @Test
  @DisplayName(
      "Test setVolatile(boolean); given COSDictionary setBoolean(COSName, boolean) does nothing; then calls setBoolean(COSName, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setVolatile(boolean)"})
  void testSetVolatile_givenCOSDictionarySetBooleanDoesNothing_thenCallsSetBoolean() {
    // Arrange
    doNothing().when(cOSDictionary).setBoolean(Mockito.<COSName>any(), anyBoolean());

    // Act
    pDComplexFileSpecification.setVolatile(true);

    // Assert
    verify(cOSDictionary).setBoolean(isA(COSName.class), eq(true));
  }

  /**
   * Test {@link PDComplexFileSpecification#setVolatile(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDComplexFileSpecification#PDComplexFileSpecification()} Volatile.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setVolatile(boolean)}
   */
  @Test
  @DisplayName("Test setVolatile(boolean); then PDComplexFileSpecification() Volatile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setVolatile(boolean)"})
  void testSetVolatile_thenPDComplexFileSpecificationVolatile() {
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
   * Test {@link PDComplexFileSpecification#isVolatile()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getBoolean(COSName, boolean)} return
   *       {@code true}.
   *   <li>Then calls {@link COSDictionary#getBoolean(COSName, boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#isVolatile()}
   */
  @Test
  @DisplayName(
      "Test isVolatile(); given COSDictionary getBoolean(COSName, boolean) return 'true'; then calls getBoolean(COSName, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDComplexFileSpecification.isVolatile()"})
  void testIsVolatile_givenCOSDictionaryGetBooleanReturnTrue_thenCallsGetBoolean() {
    // Arrange
    when(cOSDictionary.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);

    // Act
    boolean actualIsVolatileResult = pDComplexFileSpecification.isVolatile();

    // Assert
    verify(cOSDictionary).getBoolean(isA(COSName.class), eq(false));
    assertTrue(actualIsVolatileResult);
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
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)} with
   *       dict is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#isVolatile()}
   */
  @Test
  @DisplayName(
      "Test isVolatile(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDComplexFileSpecification.isVolatile()"})
  void testIsVolatile_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse(new PDComplexFileSpecification(new COSDictionary()).isVolatile());
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFile()}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedFile(); given COSDictionary getCOSDictionary(COSName) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFile()"})
  void testGetEmbeddedFile_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary() {
    // Arrange
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    PDEmbeddedFile actualEmbeddedFile = pDComplexFileSpecification.getEmbeddedFile();

    // Assert
    verify(cOSDictionary).getCOSDictionary(isA(COSName.class));
    assertNull(actualEmbeddedFile);
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFile()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)} with
   *       dict is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFile()}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedFile(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFile()"})
  void testGetEmbeddedFile_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification(new COSDictionary()).getEmbeddedFile());
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
   *   <li>Then calls {@link COSDictionary#getDictionaryObject(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFile()}
   */
  @Test
  @DisplayName("Test getEmbeddedFile(); then calls getDictionaryObject(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFile()"})
  void testGetEmbeddedFile_thenCallsGetDictionaryObject() {
    // Arrange
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cOSDictionary);

    // Act
    PDEmbeddedFile actualEmbeddedFile = pDComplexFileSpecification.getEmbeddedFile();

    // Assert
    verify(cOSDictionary).getCOSDictionary(isA(COSName.class));
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    assertNull(actualEmbeddedFile);
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
    PDComplexFileSpecification pdComplexFileSpecification =
        new PDComplexFileSpecification(new COSDictionary());
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
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFile(PDEmbeddedFile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFile(PDEmbeddedFile)"})
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
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFile(PDEmbeddedFile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFile(PDEmbeddedFile)"})
  void testSetEmbeddedFile3() {
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSObjectable)} does
   *       nothing.
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedFile(PDEmbeddedFile); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFile(PDEmbeddedFile)"})
  void testSetEmbeddedFile_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    doNothing().when(cOSDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cOSDictionary);

    // Act
    pDComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Assert
    verify(cOSDictionary).getCOSDictionary(isA(COSName.class));
    verify(cOSDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
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
   *   <li>Then {@link PDComplexFileSpecification} EmbeddedFile CheckSum is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedFile(PDEmbeddedFile); then PDComplexFileSpecification EmbeddedFile CheckSum is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFile(PDEmbeddedFile)"})
  void testSetEmbeddedFile_thenPDComplexFileSpecificationEmbeddedFileCheckSumIsNull2()
      throws IOException {
    // Arrange
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    COSStream str = new COSStream();

    // Act
    pDComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(str));

    // Assert
    verify(cOSDictionary).getCOSDictionary(isA(COSName.class));
    PDEmbeddedFile embeddedFile = pDComplexFileSpecification.getEmbeddedFile();
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileDos()}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedFileDos(); given COSDictionary getCOSDictionary(COSName) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileDos()"})
  void testGetEmbeddedFileDos_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary() {
    // Arrange
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    PDEmbeddedFile actualEmbeddedFileDos = pDComplexFileSpecification.getEmbeddedFileDos();

    // Assert
    verify(cOSDictionary).getCOSDictionary(isA(COSName.class));
    assertNull(actualEmbeddedFileDos);
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileDos()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileDos()}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedFileDos(); given COSDictionary getDictionaryObject(COSName) return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileDos()"})
  void testGetEmbeddedFileDos_givenCOSDictionaryGetDictionaryObjectReturnFalse() {
    // Arrange
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cOSDictionary);

    // Act
    PDEmbeddedFile actualEmbeddedFileDos = pDComplexFileSpecification.getEmbeddedFileDos();

    // Assert
    verify(cOSDictionary).getCOSDictionary(isA(COSName.class));
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    assertNull(actualEmbeddedFileDos);
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileDos()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)} with
   *       dict is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileDos()}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedFileDos(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileDos()"})
  void testGetEmbeddedFileDos_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification(new COSDictionary()).getEmbeddedFileDos());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileDos()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileDos()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileDos(); given PDComplexFileSpecification(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileDos()"})
  void testGetEmbeddedFileDos_givenPDComplexFileSpecification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification().getEmbeddedFileDos());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileDos()}.
   *
   * <ul>
   *   <li>Then return CheckSum is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileDos()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileDos(); then return CheckSum is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileDos()"})
  void testGetEmbeddedFileDos_thenReturnCheckSumIsNull() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosStream);
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cOSDictionary);

    // Act
    PDEmbeddedFile actualEmbeddedFileDos = pDComplexFileSpecification.getEmbeddedFileDos();

    // Assert
    verify(cOSDictionary).getCOSDictionary(isA(COSName.class));
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    assertNull(actualEmbeddedFileDos.getCheckSum());
    assertNull(actualEmbeddedFileDos.getMacCreator());
    assertNull(actualEmbeddedFileDos.getMacResFork());
    assertNull(actualEmbeddedFileDos.getMacSubtype());
    assertNull(actualEmbeddedFileDos.getSubtype());
    assertNull(actualEmbeddedFileDos.getCreationDate());
    assertNull(actualEmbeddedFileDos.getModDate());
    assertNull(actualEmbeddedFileDos.getDecodeParms());
    assertNull(actualEmbeddedFileDos.getFileDecodeParams());
    assertNull(actualEmbeddedFileDos.getMetadata());
    assertNull(actualEmbeddedFileDos.getFile());
    assertEquals(-1, actualEmbeddedFileDos.getDecodedStreamLength());
    assertEquals(-1, actualEmbeddedFileDos.getSize());
    assertEquals(0, actualEmbeddedFileDos.getLength());
    List<String> fileFilters = actualEmbeddedFileDos.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(cosStream, actualEmbeddedFileDos.getCOSObject());
    assertSame(fileFilters, actualEmbeddedFileDos.getFilters());
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileMac()}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedFileMac(); given COSDictionary getCOSDictionary(COSName) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileMac()"})
  void testGetEmbeddedFileMac_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary() {
    // Arrange
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    PDEmbeddedFile actualEmbeddedFileMac = pDComplexFileSpecification.getEmbeddedFileMac();

    // Assert
    verify(cOSDictionary).getCOSDictionary(isA(COSName.class));
    assertNull(actualEmbeddedFileMac);
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileMac()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileMac()}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedFileMac(); given COSDictionary getDictionaryObject(COSName) return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileMac()"})
  void testGetEmbeddedFileMac_givenCOSDictionaryGetDictionaryObjectReturnFalse() {
    // Arrange
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cOSDictionary);

    // Act
    PDEmbeddedFile actualEmbeddedFileMac = pDComplexFileSpecification.getEmbeddedFileMac();

    // Assert
    verify(cOSDictionary).getCOSDictionary(isA(COSName.class));
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    assertNull(actualEmbeddedFileMac);
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileMac()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)} with
   *       dict is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileMac()}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedFileMac(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileMac()"})
  void testGetEmbeddedFileMac_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification(new COSDictionary()).getEmbeddedFileMac());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileMac()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileMac()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileMac(); given PDComplexFileSpecification(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileMac()"})
  void testGetEmbeddedFileMac_givenPDComplexFileSpecification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification().getEmbeddedFileMac());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileMac()}.
   *
   * <ul>
   *   <li>Then return CheckSum is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileMac()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileMac(); then return CheckSum is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileMac()"})
  void testGetEmbeddedFileMac_thenReturnCheckSumIsNull() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosStream);
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cOSDictionary);

    // Act
    PDEmbeddedFile actualEmbeddedFileMac = pDComplexFileSpecification.getEmbeddedFileMac();

    // Assert
    verify(cOSDictionary).getCOSDictionary(isA(COSName.class));
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    assertNull(actualEmbeddedFileMac.getCheckSum());
    assertNull(actualEmbeddedFileMac.getMacCreator());
    assertNull(actualEmbeddedFileMac.getMacResFork());
    assertNull(actualEmbeddedFileMac.getMacSubtype());
    assertNull(actualEmbeddedFileMac.getSubtype());
    assertNull(actualEmbeddedFileMac.getCreationDate());
    assertNull(actualEmbeddedFileMac.getModDate());
    assertNull(actualEmbeddedFileMac.getDecodeParms());
    assertNull(actualEmbeddedFileMac.getFileDecodeParams());
    assertNull(actualEmbeddedFileMac.getMetadata());
    assertNull(actualEmbeddedFileMac.getFile());
    assertEquals(-1, actualEmbeddedFileMac.getDecodedStreamLength());
    assertEquals(-1, actualEmbeddedFileMac.getSize());
    assertEquals(0, actualEmbeddedFileMac.getLength());
    List<String> fileFilters = actualEmbeddedFileMac.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(cosStream, actualEmbeddedFileMac.getCOSObject());
    assertSame(fileFilters, actualEmbeddedFileMac.getFilters());
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnix()}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedFileUnix(); given COSDictionary getCOSDictionary(COSName) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileUnix()"})
  void testGetEmbeddedFileUnix_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary() {
    // Arrange
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    PDEmbeddedFile actualEmbeddedFileUnix = pDComplexFileSpecification.getEmbeddedFileUnix();

    // Assert
    verify(cOSDictionary).getCOSDictionary(isA(COSName.class));
    assertNull(actualEmbeddedFileUnix);
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnix()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnix()}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedFileUnix(); given COSDictionary getDictionaryObject(COSName) return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileUnix()"})
  void testGetEmbeddedFileUnix_givenCOSDictionaryGetDictionaryObjectReturnFalse() {
    // Arrange
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cOSDictionary);

    // Act
    PDEmbeddedFile actualEmbeddedFileUnix = pDComplexFileSpecification.getEmbeddedFileUnix();

    // Assert
    verify(cOSDictionary).getCOSDictionary(isA(COSName.class));
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    assertNull(actualEmbeddedFileUnix);
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnix()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)} with
   *       dict is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnix()}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedFileUnix(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileUnix()"})
  void testGetEmbeddedFileUnix_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification(new COSDictionary()).getEmbeddedFileUnix());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnix()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnix()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnix(); given PDComplexFileSpecification(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileUnix()"})
  void testGetEmbeddedFileUnix_givenPDComplexFileSpecification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification().getEmbeddedFileUnix());
  }

  /**
   * Test {@link PDComplexFileSpecification#getEmbeddedFileUnix()}.
   *
   * <ul>
   *   <li>Then return CheckSum is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnix()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnix(); then return CheckSum is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileUnix()"})
  void testGetEmbeddedFileUnix_thenReturnCheckSumIsNull() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosStream);
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cOSDictionary);

    // Act
    PDEmbeddedFile actualEmbeddedFileUnix = pDComplexFileSpecification.getEmbeddedFileUnix();

    // Assert
    verify(cOSDictionary).getCOSDictionary(isA(COSName.class));
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    assertNull(actualEmbeddedFileUnix.getCheckSum());
    assertNull(actualEmbeddedFileUnix.getMacCreator());
    assertNull(actualEmbeddedFileUnix.getMacResFork());
    assertNull(actualEmbeddedFileUnix.getMacSubtype());
    assertNull(actualEmbeddedFileUnix.getSubtype());
    assertNull(actualEmbeddedFileUnix.getCreationDate());
    assertNull(actualEmbeddedFileUnix.getModDate());
    assertNull(actualEmbeddedFileUnix.getDecodeParms());
    assertNull(actualEmbeddedFileUnix.getFileDecodeParams());
    assertNull(actualEmbeddedFileUnix.getMetadata());
    assertNull(actualEmbeddedFileUnix.getFile());
    assertEquals(-1, actualEmbeddedFileUnix.getDecodedStreamLength());
    assertEquals(-1, actualEmbeddedFileUnix.getSize());
    assertEquals(0, actualEmbeddedFileUnix.getLength());
    List<String> fileFilters = actualEmbeddedFileUnix.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(cosStream, actualEmbeddedFileUnix.getCOSObject());
    assertSame(fileFilters, actualEmbeddedFileUnix.getFilters());
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
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification(new COSDictionary()).getEmbeddedFileUnicode());
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
  void testGetEmbeddedFileUnicode2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileUnicode());
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
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedFileUnicode(); given COSDictionary getCOSDictionary(COSName) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileUnicode()"})
  void testGetEmbeddedFileUnicode_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary() {
    // Arrange
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    PDEmbeddedFile actualEmbeddedFileUnicode = pDComplexFileSpecification.getEmbeddedFileUnicode();

    // Assert
    verify(cOSDictionary).getCOSDictionary(isA(COSName.class));
    assertNull(actualEmbeddedFileUnicode);
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
   *   <li>Then calls {@link COSDictionary#getDictionaryObject(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}
   */
  @Test
  @DisplayName("Test getEmbeddedFileUnicode(); then calls getDictionaryObject(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDEmbeddedFile PDComplexFileSpecification.getEmbeddedFileUnicode()"})
  void testGetEmbeddedFileUnicode_thenCallsGetDictionaryObject() {
    // Arrange
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cOSDictionary);

    // Act
    PDEmbeddedFile actualEmbeddedFileUnicode = pDComplexFileSpecification.getEmbeddedFileUnicode();

    // Assert
    verify(cOSDictionary).getCOSDictionary(isA(COSName.class));
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    assertNull(actualEmbeddedFileUnicode);
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
    PDComplexFileSpecification pdComplexFileSpecification =
        new PDComplexFileSpecification(new COSDictionary());
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
   * Test {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}.
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFileUnicode(PDEmbeddedFile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFileUnicode(PDEmbeddedFile)"})
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
   * Test {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}.
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFileUnicode(PDEmbeddedFile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFileUnicode(PDEmbeddedFile)"})
  void testSetEmbeddedFileUnicode5() {
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
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName("Test setEmbeddedFileUnicode(PDEmbeddedFile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFileUnicode(PDEmbeddedFile)"})
  void testSetEmbeddedFileUnicode6() throws IOException {
    // Arrange
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    COSStream str = new COSStream();

    // Act
    pDComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(str));

    // Assert
    verify(cOSDictionary).getCOSDictionary(isA(COSName.class));
    PDEmbeddedFile embeddedFileUnicode = pDComplexFileSpecification.getEmbeddedFileUnicode();
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
    assertSame(str, embeddedFileUnicode.getCOSObject());
  }

  /**
   * Test {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSObjectable)} does
   *       nothing.
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedFileUnicode(PDEmbeddedFile); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setEmbeddedFileUnicode(PDEmbeddedFile)"})
  void testSetEmbeddedFileUnicode_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    doNothing().when(cOSDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cOSDictionary);

    // Act
    pDComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(new COSStream()));

    // Assert
    verify(cOSDictionary).getCOSDictionary(isA(COSName.class));
    verify(cOSDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setString(COSName, String)} does
   *       nothing.
   *   <li>Then calls {@link COSDictionary#setString(COSName, String)}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#setFileDescription(String)}
   */
  @Test
  @DisplayName(
      "Test setFileDescription(String); given COSDictionary setString(COSName, String) does nothing; then calls setString(COSName, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDComplexFileSpecification.setFileDescription(String)"})
  void testSetFileDescription_givenCOSDictionarySetStringDoesNothing_thenCallsSetString() {
    // Arrange
    doNothing().when(cOSDictionary).setString(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pDComplexFileSpecification.setFileDescription("The characteristics of someone or something");

    // Assert
    verify(cOSDictionary)
        .setString(isA(COSName.class), eq("The characteristics of someone or something"));
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getString(COSName)} return {@code
   *       String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileDescription()}
   */
  @Test
  @DisplayName(
      "Test getFileDescription(); given COSDictionary getString(COSName) return 'String'; then return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileDescription()"})
  void testGetFileDescription_givenCOSDictionaryGetStringReturnString_thenReturnString() {
    // Arrange
    when(cOSDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    // Act
    String actualFileDescription = pDComplexFileSpecification.getFileDescription();

    // Assert
    verify(cOSDictionary).getString(isA(COSName.class));
    assertEquals("String", actualFileDescription);
  }

  /**
   * Test {@link PDComplexFileSpecification#getFileDescription()}.
   *
   * <ul>
   *   <li>Given {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)} with
   *       dict is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDComplexFileSpecification#getFileDescription()}
   */
  @Test
  @DisplayName(
      "Test getFileDescription(); given PDComplexFileSpecification(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDComplexFileSpecification.getFileDescription()"})
  void testGetFileDescription_givenPDComplexFileSpecificationWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDComplexFileSpecification(new COSDictionary()).getFileDescription());
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
