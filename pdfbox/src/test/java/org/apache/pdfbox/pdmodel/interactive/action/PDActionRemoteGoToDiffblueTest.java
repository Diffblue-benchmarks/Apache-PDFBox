package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDActionRemoteGoToDiffblueTest {
  /**
   * Test {@link PDActionRemoteGoTo#PDActionRemoteGoTo(COSDictionary)}.
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#PDActionRemoteGoTo(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionRemoteGoTo(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionRemoteGoTo.<init>(COSDictionary)"})
  void testNewPDActionRemoteGoTo() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new PDActionRemoteGoTo(a).getCOSObject());
  }

  /**
   * Test {@link PDActionRemoteGoTo#PDActionRemoteGoTo()}.
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#PDActionRemoteGoTo()}
   */
  @Test
  @DisplayName("Test new PDActionRemoteGoTo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionRemoteGoTo.<init>()"})
  void testNewPDActionRemoteGoTo2() throws IOException {
    // Arrange and Act
    PDActionRemoteGoTo actualPdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Assert
    assertNull(actualPdActionRemoteGoTo.getNext());
    assertNull(actualPdActionRemoteGoTo.getD());
    COSDictionary cOSObject = actualPdActionRemoteGoTo.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualPdActionRemoteGoTo.getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, actualPdActionRemoteGoTo.getOpenInNewWindow());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualPdActionRemoteGoTo.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualPdActionRemoteGoTo.getSubType());
  }

  /**
   * Test {@link PDActionRemoteGoTo#getFile()}.
   *
   * <ul>
   *   <li>Given {@link PDActionRemoteGoTo#PDActionRemoteGoTo()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given PDActionRemoteGoTo(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFileSpecification PDActionRemoteGoTo.getFile()"})
  void testGetFile_givenPDActionRemoteGoTo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDActionRemoteGoTo().getFile());
  }

  /**
   * Test {@link PDActionRemoteGoTo#getFile()}.
   *
   * <ul>
   *   <li>Then COSObject return {@link COSString}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then COSObject return COSString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFileSpecification PDActionRemoteGoTo.getFile()"})
  void testGetFile_thenCOSObjectReturnCOSString() throws IOException {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    pdActionRemoteGoTo.setFile(new PDSimpleFileSpecification());

    // Act
    PDFileSpecification actualFile = pdActionRemoteGoTo.getFile();

    // Assert
    COSBase cOSObject = actualFile.getCOSObject();
    assertTrue(cOSObject instanceof COSString);
    assertTrue(actualFile instanceof PDSimpleFileSpecification);
    assertEquals("", ((COSString) cOSObject).getASCII());
    assertEquals("", ((COSString) cOSObject).getString());
    assertEquals("", ((COSString) cOSObject).toHexString());
    assertEquals("", actualFile.getFile());
    assertNull(cOSObject.getKey());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
    assertArrayEquals(new byte[] {}, ((COSString) cOSObject).getBytes());
  }

  /**
   * Test {@link PDActionRemoteGoTo#getFile()}.
   *
   * <ul>
   *   <li>Then return {@link PDComplexFileSpecification}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then return PDComplexFileSpecification")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFileSpecification PDActionRemoteGoTo.getFile()"})
  void testGetFile_thenReturnPDComplexFileSpecification() throws IOException {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    pdActionRemoteGoTo.setFile(new PDComplexFileSpecification());

    // Act
    PDFileSpecification actualFile = pdActionRemoteGoTo.getFile();

    // Assert
    assertTrue(actualFile instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) actualFile).getFileDescription());
    assertNull(((PDComplexFileSpecification) actualFile).getFileDos());
    assertNull(((PDComplexFileSpecification) actualFile).getFileMac());
    assertNull(((PDComplexFileSpecification) actualFile).getFileUnicode());
    assertNull(((PDComplexFileSpecification) actualFile).getFileUnix());
    assertNull(((PDComplexFileSpecification) actualFile).getFilename());
    assertNull(actualFile.getFile());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileUnix());
    assertFalse(((PDComplexFileSpecification) actualFile).isVolatile());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName(
      "Test setFile(PDFileSpecification); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionRemoteGoTo.setFile(PDFileSpecification)"})
  void testSetFile_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdActionRemoteGoTo.setFile(new PDComplexFileSpecification(dict));

    // Assert
    PDFileSpecification file = pdActionRemoteGoTo.getFile();
    assertTrue(file instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) file).getFileDescription());
    assertNull(((PDComplexFileSpecification) file).getFileDos());
    assertNull(((PDComplexFileSpecification) file).getFileMac());
    assertNull(((PDComplexFileSpecification) file).getFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getFileUnix());
    assertNull(((PDComplexFileSpecification) file).getFilename());
    assertNull(file.getFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnix());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
    assertSame(dict, file.getCOSObject());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName(
      "Test setFile(PDFileSpecification); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionRemoteGoTo.setFile(PDFileSpecification)"})
  void testSetFile_givenTrue_whenCOSDictionaryDirectIsTrue() throws IOException {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdActionRemoteGoTo.setFile(new PDComplexFileSpecification(dict));

    // Assert
    PDFileSpecification file = pdActionRemoteGoTo.getFile();
    assertTrue(file instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) file).getFileDescription());
    assertNull(((PDComplexFileSpecification) file).getFileDos());
    assertNull(((PDComplexFileSpecification) file).getFileMac());
    assertNull(((PDComplexFileSpecification) file).getFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getFileUnix());
    assertNull(((PDComplexFileSpecification) file).getFilename());
    assertNull(file.getFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnix());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
    assertSame(dict, file.getCOSObject());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} File {@link
   *       PDSimpleFileSpecification}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName(
      "Test setFile(PDFileSpecification); then PDActionRemoteGoTo() File PDSimpleFileSpecification")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionRemoteGoTo.setFile(PDFileSpecification)"})
  void testSetFile_thenPDActionRemoteGoToFilePDSimpleFileSpecification() throws IOException {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setFile(new PDSimpleFileSpecification());

    // Assert
    PDFileSpecification file = pdActionRemoteGoTo.getFile();
    assertTrue(file instanceof PDSimpleFileSpecification);
    assertEquals("", file.getFile());
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName(
      "Test setFile(PDFileSpecification); when 'null'; then PDActionRemoteGoTo() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionRemoteGoTo.setFile(PDFileSpecification)"})
  void testSetFile_whenNull_thenPDActionRemoteGoToCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setFile(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>When {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); when PDComplexFileSpecification()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionRemoteGoTo.setFile(PDFileSpecification)"})
  void testSetFile_whenPDComplexFileSpecification() throws IOException {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setFile(new PDComplexFileSpecification());

    // Assert
    PDFileSpecification file = pdActionRemoteGoTo.getFile();
    assertTrue(file instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) file).getFileDescription());
    assertNull(((PDComplexFileSpecification) file).getFileDos());
    assertNull(((PDComplexFileSpecification) file).getFileMac());
    assertNull(((PDComplexFileSpecification) file).getFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getFileUnix());
    assertNull(((PDComplexFileSpecification) file).getFilename());
    assertNull(file.getFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnix());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
  }

  /**
   * Test {@link PDActionRemoteGoTo#getD()}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   *   <li>Then return {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#getD()}
   */
  @Test
  @DisplayName(
      "Test getD(); given COSObjectKey(long, int) with num is one and gen is one; then return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDActionRemoteGoTo.getD()"})
  void testGetD_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnFalse() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    COSObject d = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    pdActionRemoteGoTo.setD(d);

    // Act
    COSBase actualD = pdActionRemoteGoTo.getD();

    // Assert
    assertSame(((COSBoolean) actualD).FALSE, actualD);
  }

  /**
   * Test {@link PDActionRemoteGoTo#getD()}.
   *
   * <ul>
   *   <li>Given {@link PDActionRemoteGoTo#PDActionRemoteGoTo()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#getD()}
   */
  @Test
  @DisplayName("Test getD(); given PDActionRemoteGoTo(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDActionRemoteGoTo.getD()"})
  void testGetD_givenPDActionRemoteGoTo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionRemoteGoTo().getD());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setD(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#setD(COSBase)}
   */
  @Test
  @DisplayName("Test setD(COSBase); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionRemoteGoTo.setD(COSBase)"})
  void testSetD_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    COSDictionary d = new COSDictionary();
    d.setKey(new COSObjectKey(1L, 1));

    // Act
    pdActionRemoteGoTo.setD(d);

    // Assert
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(d, pdActionRemoteGoTo.getD());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setD(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link PDActionRemoteGoTo#PDActionRemoteGoTo()}.
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} D is {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#setD(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setD(COSBase); given PDActionRemoteGoTo(); when COSArray(); then PDActionRemoteGoTo() D is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionRemoteGoTo.setD(COSBase)"})
  void testSetD_givenPDActionRemoteGoTo_whenCOSArray_thenPDActionRemoteGoToDIsCOSArray() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    COSArray d = new COSArray();

    // Act
    pdActionRemoteGoTo.setD(d);

    // Assert
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(d, pdActionRemoteGoTo.getD());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setD(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link PDActionRemoteGoTo#PDActionRemoteGoTo()}.
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} D is {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#setD(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setD(COSBase); given PDActionRemoteGoTo(); when FALSE; then PDActionRemoteGoTo() D is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionRemoteGoTo.setD(COSBase)"})
  void testSetD_givenPDActionRemoteGoTo_whenFalse_thenPDActionRemoteGoToDIsFalse() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setD(COSBoolean.FALSE);

    // Assert
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(COSBoolean.FALSE, pdActionRemoteGoTo.getD());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setD(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} D is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#setD(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setD(COSBase); when COSDictionary(); then PDActionRemoteGoTo() D is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionRemoteGoTo.setD(COSBase)"})
  void testSetD_whenCOSDictionary_thenPDActionRemoteGoToDIsCOSDictionary() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    COSDictionary d = new COSDictionary();

    // Act
    pdActionRemoteGoTo.setD(d);

    // Assert
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(d, pdActionRemoteGoTo.getD());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setD(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#setD(COSBase)}
   */
  @Test
  @DisplayName("Test setD(COSBase); when COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionRemoteGoTo.setD(COSBase)"})
  void testSetD_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    COSObject d = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    pdActionRemoteGoTo.setD(d);

    // Assert
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setD(COSBase)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#setD(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setD(COSBase); when 'null'; then PDActionRemoteGoTo() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionRemoteGoTo.setD(COSBase)"})
  void testSetD_whenNull_thenPDActionRemoteGoToCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setD(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionRemoteGoTo#getOpenInNewWindow()}.
   *
   * <ul>
   *   <li>Given {@link PDActionRemoteGoTo#PDActionRemoteGoTo()}.
   *   <li>Then return {@code USER_PREFERENCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#getOpenInNewWindow()}
   */
  @Test
  @DisplayName(
      "Test getOpenInNewWindow(); given PDActionRemoteGoTo(); then return 'USER_PREFERENCE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenMode PDActionRemoteGoTo.getOpenInNewWindow()"})
  void testGetOpenInNewWindow_givenPDActionRemoteGoTo_thenReturnUserPreference() {
    // Arrange, Act and Assert
    assertEquals(OpenMode.USER_PREFERENCE, new PDActionRemoteGoTo().getOpenInNewWindow());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setOpenInNewWindow(OpenMode)}.
   *
   * <ul>
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#setOpenInNewWindow(OpenMode)}
   */
  @Test
  @DisplayName(
      "Test setOpenInNewWindow(OpenMode); then PDActionRemoteGoTo() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionRemoteGoTo.setOpenInNewWindow(OpenMode)"})
  void testSetOpenInNewWindow_thenPDActionRemoteGoToCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setOpenInNewWindow(OpenMode.USER_PREFERENCE);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, pdActionRemoteGoTo.getOpenInNewWindow());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setOpenInNewWindow(OpenMode)}.
   *
   * <ul>
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} OpenInNewWindow is {@code
   *       NEW_WINDOW}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#setOpenInNewWindow(OpenMode)}
   */
  @Test
  @DisplayName(
      "Test setOpenInNewWindow(OpenMode); then PDActionRemoteGoTo() OpenInNewWindow is 'NEW_WINDOW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionRemoteGoTo.setOpenInNewWindow(OpenMode)"})
  void testSetOpenInNewWindow_thenPDActionRemoteGoToOpenInNewWindowIsNewWindow() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setOpenInNewWindow(OpenMode.NEW_WINDOW);

    // Assert
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(OpenMode.NEW_WINDOW, pdActionRemoteGoTo.getOpenInNewWindow());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setOpenInNewWindow(OpenMode)}.
   *
   * <ul>
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} OpenInNewWindow is {@code
   *       SAME_WINDOW}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#setOpenInNewWindow(OpenMode)}
   */
  @Test
  @DisplayName(
      "Test setOpenInNewWindow(OpenMode); then PDActionRemoteGoTo() OpenInNewWindow is 'SAME_WINDOW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionRemoteGoTo.setOpenInNewWindow(OpenMode)"})
  void testSetOpenInNewWindow_thenPDActionRemoteGoToOpenInNewWindowIsSameWindow() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setOpenInNewWindow(OpenMode.SAME_WINDOW);

    // Assert
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(OpenMode.SAME_WINDOW, pdActionRemoteGoTo.getOpenInNewWindow());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setOpenInNewWindow(OpenMode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionRemoteGoTo#setOpenInNewWindow(OpenMode)}
   */
  @Test
  @DisplayName(
      "Test setOpenInNewWindow(OpenMode); when 'null'; then PDActionRemoteGoTo() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionRemoteGoTo.setOpenInNewWindow(OpenMode)"})
  void testSetOpenInNewWindow_whenNull_thenPDActionRemoteGoToCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setOpenInNewWindow(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, pdActionRemoteGoTo.getOpenInNewWindow());
  }
}
