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
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDActionLaunchDiffblueTest {
  /**
   * Test {@link PDActionLaunch#PDActionLaunch(COSDictionary)}.
   *
   * <p>Method under test: {@link PDActionLaunch#PDActionLaunch(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionLaunch(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.<init>(COSDictionary)"})
  void testNewPDActionLaunch() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new PDActionLaunch(a).getCOSObject());
  }

  /**
   * Test {@link PDActionLaunch#PDActionLaunch()}.
   *
   * <p>Method under test: {@link PDActionLaunch#PDActionLaunch()}
   */
  @Test
  @DisplayName("Test new PDActionLaunch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.<init>()"})
  void testNewPDActionLaunch2() throws IOException {
    // Arrange and Act
    PDActionLaunch actualPdActionLaunch = new PDActionLaunch();

    // Assert
    assertNull(actualPdActionLaunch.getD());
    assertNull(actualPdActionLaunch.getF());
    assertNull(actualPdActionLaunch.getO());
    assertNull(actualPdActionLaunch.getP());
    assertNull(actualPdActionLaunch.getNext());
    assertNull(actualPdActionLaunch.getFile());
    assertNull(actualPdActionLaunch.getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, actualPdActionLaunch.getOpenInNewWindow());
    assertEquals(PDAction.TYPE, actualPdActionLaunch.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualPdActionLaunch.getSubType());
  }

  /**
   * Test {@link PDActionLaunch#getFile()}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()} F is {@code foo}.
   *   <li>Then COSObject return {@link COSString}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given PDActionLaunch() F is 'foo'; then COSObject return COSString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFileSpecification PDActionLaunch.getFile()"})
  void testGetFile_givenPDActionLaunchFIsFoo_thenCOSObjectReturnCOSString() throws IOException {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setF("foo");

    // Act
    PDFileSpecification actualFile = pdActionLaunch.getFile();

    // Assert
    COSBase cOSObject = actualFile.getCOSObject();
    assertTrue(cOSObject instanceof COSString);
    assertTrue(actualFile instanceof PDSimpleFileSpecification);
    assertEquals("666F6F", ((COSString) cOSObject).toHexString());
    assertEquals("foo", ((COSString) cOSObject).getASCII());
    assertEquals("foo", ((COSString) cOSObject).getString());
    assertEquals("foo", actualFile.getFile());
    assertNull(cOSObject.getKey());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
    assertArrayEquals("foo".getBytes("UTF-8"), ((COSString) cOSObject).getBytes());
  }

  /**
   * Test {@link PDActionLaunch#getFile()}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given PDActionLaunch(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFileSpecification PDActionLaunch.getFile()"})
  void testGetFile_givenPDActionLaunch_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDActionLaunch().getFile());
  }

  /**
   * Test {@link PDActionLaunch#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName(
      "Test setFile(PDFileSpecification); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setFile(PDFileSpecification)"})
  void testSetFile_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdActionLaunch.setFile(new PDComplexFileSpecification(dict));

    // Assert
    PDFileSpecification file = pdActionLaunch.getFile();
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
   * Test {@link PDActionLaunch#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()}.
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionLaunch#PDActionLaunch()} F is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName(
      "Test setFile(PDFileSpecification); given PDActionLaunch(); when 'null'; then PDActionLaunch() F is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setFile(PDFileSpecification)"})
  void testSetFile_givenPDActionLaunch_whenNull_thenPDActionLaunchFIsNull() throws IOException {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setFile(null);

    // Assert that nothing has changed
    assertNull(pdActionLaunch.getF());
    assertNull(pdActionLaunch.getFile());
  }

  /**
   * Test {@link PDActionLaunch#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName(
      "Test setFile(PDFileSpecification); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setFile(PDFileSpecification)"})
  void testSetFile_givenTrue_whenCOSDictionaryDirectIsTrue() throws IOException {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdActionLaunch.setFile(new PDComplexFileSpecification(dict));

    // Assert
    PDFileSpecification file = pdActionLaunch.getFile();
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
   * Test {@link PDActionLaunch#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>Then {@link PDActionLaunch#PDActionLaunch()} File {@link PDSimpleFileSpecification}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName(
      "Test setFile(PDFileSpecification); then PDActionLaunch() File PDSimpleFileSpecification")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setFile(PDFileSpecification)"})
  void testSetFile_thenPDActionLaunchFilePDSimpleFileSpecification() throws IOException {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setFile(new PDSimpleFileSpecification());

    // Assert
    PDFileSpecification file = pdActionLaunch.getFile();
    assertTrue(file instanceof PDSimpleFileSpecification);
    assertEquals("", file.getFile());
    assertEquals("", pdActionLaunch.getF());
  }

  /**
   * Test {@link PDActionLaunch#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>When {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); when PDComplexFileSpecification()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setFile(PDFileSpecification)"})
  void testSetFile_whenPDComplexFileSpecification() throws IOException {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setFile(new PDComplexFileSpecification());

    // Assert
    PDFileSpecification file = pdActionLaunch.getFile();
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
   * Test {@link PDActionLaunch#getWinLaunchParams()}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#getWinLaunchParams()}
   */
  @Test
  @DisplayName("Test getWinLaunchParams(); given PDActionLaunch(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDWindowsLaunchParams PDActionLaunch.getWinLaunchParams()"})
  void testGetWinLaunchParams_givenPDActionLaunch_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionLaunch().getWinLaunchParams());
  }

  /**
   * Test {@link PDActionLaunch#getWinLaunchParams()}.
   *
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#getWinLaunchParams()}
   */
  @Test
  @DisplayName("Test getWinLaunchParams(); then return COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDWindowsLaunchParams PDActionLaunch.getWinLaunchParams()"})
  void testGetWinLaunchParams_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    COSDictionary p = new COSDictionary();
    p.setKey(new COSObjectKey(1L, 1));
    PDWindowsLaunchParams win = new PDWindowsLaunchParams(p);

    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setWinLaunchParams(win);

    // Act and Assert
    assertSame(p, pdActionLaunch.getWinLaunchParams().getCOSObject());
  }

  /**
   * Test {@link PDActionLaunch#getWinLaunchParams()}.
   *
   * <ul>
   *   <li>Then return Directory is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#getWinLaunchParams()}
   */
  @Test
  @DisplayName("Test getWinLaunchParams(); then return Directory is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDWindowsLaunchParams PDActionLaunch.getWinLaunchParams()"})
  void testGetWinLaunchParams_thenReturnDirectoryIsNull() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setWinLaunchParams(new PDWindowsLaunchParams());

    // Act
    PDWindowsLaunchParams actualWinLaunchParams = pdActionLaunch.getWinLaunchParams();

    // Assert
    assertNull(actualWinLaunchParams.getDirectory());
    assertNull(actualWinLaunchParams.getExecuteParam());
    assertNull(actualWinLaunchParams.getFilename());
    COSDictionary cOSObject = actualWinLaunchParams.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDWindowsLaunchParams.OPERATION_OPEN, actualWinLaunchParams.getOperation());
  }

  /**
   * Test {@link PDActionLaunch#setWinLaunchParams(PDWindowsLaunchParams)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setWinLaunchParams(PDWindowsLaunchParams)}
   */
  @Test
  @DisplayName(
      "Test setWinLaunchParams(PDWindowsLaunchParams); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setWinLaunchParams(PDWindowsLaunchParams)"})
  void testSetWinLaunchParams_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    COSDictionary p = new COSDictionary();
    p.setKey(new COSObjectKey(1L, 1));

    // Act
    pdActionLaunch.setWinLaunchParams(new PDWindowsLaunchParams(p));

    // Assert
    PDWindowsLaunchParams winLaunchParams = pdActionLaunch.getWinLaunchParams();
    assertNull(winLaunchParams.getDirectory());
    assertNull(winLaunchParams.getExecuteParam());
    assertNull(winLaunchParams.getFilename());
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDWindowsLaunchParams.OPERATION_OPEN, winLaunchParams.getOperation());
    assertSame(p, winLaunchParams.getCOSObject());
  }

  /**
   * Test {@link PDActionLaunch#setWinLaunchParams(PDWindowsLaunchParams)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setWinLaunchParams(PDWindowsLaunchParams)}
   */
  @Test
  @DisplayName(
      "Test setWinLaunchParams(PDWindowsLaunchParams); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setWinLaunchParams(PDWindowsLaunchParams)"})
  void testSetWinLaunchParams_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    COSDictionary p = new COSDictionary();
    p.setDirect(true);

    // Act
    pdActionLaunch.setWinLaunchParams(new PDWindowsLaunchParams(p));

    // Assert
    PDWindowsLaunchParams winLaunchParams = pdActionLaunch.getWinLaunchParams();
    assertNull(winLaunchParams.getDirectory());
    assertNull(winLaunchParams.getExecuteParam());
    assertNull(winLaunchParams.getFilename());
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDWindowsLaunchParams.OPERATION_OPEN, winLaunchParams.getOperation());
    assertSame(p, winLaunchParams.getCOSObject());
  }

  /**
   * Test {@link PDActionLaunch#setWinLaunchParams(PDWindowsLaunchParams)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionLaunch#PDActionLaunch()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setWinLaunchParams(PDWindowsLaunchParams)}
   */
  @Test
  @DisplayName(
      "Test setWinLaunchParams(PDWindowsLaunchParams); when 'null'; then PDActionLaunch() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setWinLaunchParams(PDWindowsLaunchParams)"})
  void testSetWinLaunchParams_whenNull_thenPDActionLaunchCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setWinLaunchParams(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionLaunch#setWinLaunchParams(PDWindowsLaunchParams)}.
   *
   * <ul>
   *   <li>When {@link PDWindowsLaunchParams#PDWindowsLaunchParams()}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setWinLaunchParams(PDWindowsLaunchParams)}
   */
  @Test
  @DisplayName("Test setWinLaunchParams(PDWindowsLaunchParams); when PDWindowsLaunchParams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setWinLaunchParams(PDWindowsLaunchParams)"})
  void testSetWinLaunchParams_whenPDWindowsLaunchParams() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setWinLaunchParams(new PDWindowsLaunchParams());

    // Assert
    PDWindowsLaunchParams winLaunchParams = pdActionLaunch.getWinLaunchParams();
    assertNull(winLaunchParams.getDirectory());
    assertNull(winLaunchParams.getExecuteParam());
    assertNull(winLaunchParams.getFilename());
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDWindowsLaunchParams.OPERATION_OPEN, winLaunchParams.getOperation());
  }

  /**
   * Test {@link PDActionLaunch#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()} F is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#getF()}
   */
  @Test
  @DisplayName("Test getF(); given PDActionLaunch() F is empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionLaunch.getF()"})
  void testGetF_givenPDActionLaunchFIsEmptyString_thenReturnEmptyString() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setF("");

    // Act and Assert
    assertEquals("", pdActionLaunch.getF());
  }

  /**
   * Test {@link PDActionLaunch#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()} F is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#getF()}
   */
  @Test
  @DisplayName("Test getF(); given PDActionLaunch() F is 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionLaunch.getF()"})
  void testGetF_givenPDActionLaunchFIsFoo_thenReturnFoo() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setF("foo");

    // Act and Assert
    assertEquals("foo", pdActionLaunch.getF());
  }

  /**
   * Test {@link PDActionLaunch#getF()}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#getF()}
   */
  @Test
  @DisplayName("Test getF(); given PDActionLaunch(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionLaunch.getF()"})
  void testGetF_givenPDActionLaunch_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionLaunch().getF());
  }

  /**
   * Test {@link PDActionLaunch#setF(String)}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()}.
   *   <li>When {@code foo}.
   *   <li>Then {@link PDActionLaunch#PDActionLaunch()} File COSObject {@link COSString}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setF(String)}
   */
  @Test
  @DisplayName(
      "Test setF(String); given PDActionLaunch(); when 'foo'; then PDActionLaunch() File COSObject COSString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setF(String)"})
  void testSetF_givenPDActionLaunch_whenFoo_thenPDActionLaunchFileCOSObjectCOSString()
      throws IOException {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setF("foo");

    // Assert
    PDFileSpecification file = pdActionLaunch.getFile();
    COSBase cOSObject = file.getCOSObject();
    assertTrue(cOSObject instanceof COSString);
    assertTrue(file instanceof PDSimpleFileSpecification);
    assertEquals("666F6F", ((COSString) cOSObject).toHexString());
    assertEquals("foo", ((COSString) cOSObject).getASCII());
    assertEquals("foo", ((COSString) cOSObject).getString());
    assertEquals("foo", file.getFile());
    assertEquals("foo", pdActionLaunch.getF());
    assertNull(cOSObject.getKey());
    COSDictionary cOSObject2 = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject2.getValues().size());
    assertEquals(3, cOSObject2.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
    assertArrayEquals("foo".getBytes("UTF-8"), ((COSString) cOSObject).getBytes());
  }

  /**
   * Test {@link PDActionLaunch#setF(String)}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()}.
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionLaunch#PDActionLaunch()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setF(String)}
   */
  @Test
  @DisplayName(
      "Test setF(String); given PDActionLaunch(); when 'null'; then PDActionLaunch() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setF(String)"})
  void testSetF_givenPDActionLaunch_whenNull_thenPDActionLaunchCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setF(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionLaunch#getD()}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()} D is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#getD()}
   */
  @Test
  @DisplayName("Test getD(); given PDActionLaunch() D is empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionLaunch.getD()"})
  void testGetD_givenPDActionLaunchDIsEmptyString_thenReturnEmptyString() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setD("");

    // Act and Assert
    assertEquals("", pdActionLaunch.getD());
  }

  /**
   * Test {@link PDActionLaunch#getD()}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()} D is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#getD()}
   */
  @Test
  @DisplayName("Test getD(); given PDActionLaunch() D is 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionLaunch.getD()"})
  void testGetD_givenPDActionLaunchDIsFoo_thenReturnFoo() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setD("foo");

    // Act and Assert
    assertEquals("foo", pdActionLaunch.getD());
  }

  /**
   * Test {@link PDActionLaunch#getD()}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#getD()}
   */
  @Test
  @DisplayName("Test getD(); given PDActionLaunch(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionLaunch.getD()"})
  void testGetD_givenPDActionLaunch_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionLaunch().getD());
  }

  /**
   * Test {@link PDActionLaunch#setD(String)}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()}.
   *   <li>When {@code foo}.
   *   <li>Then {@link PDActionLaunch#PDActionLaunch()} D is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setD(String)}
   */
  @Test
  @DisplayName(
      "Test setD(String); given PDActionLaunch(); when 'foo'; then PDActionLaunch() D is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setD(String)"})
  void testSetD_givenPDActionLaunch_whenFoo_thenPDActionLaunchDIsFoo() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setD("foo");

    // Assert
    assertEquals("foo", pdActionLaunch.getD());
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionLaunch#setD(String)}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()}.
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionLaunch#PDActionLaunch()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setD(String)}
   */
  @Test
  @DisplayName(
      "Test setD(String); given PDActionLaunch(); when 'null'; then PDActionLaunch() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setD(String)"})
  void testSetD_givenPDActionLaunch_whenNull_thenPDActionLaunchCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setD(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionLaunch#getO()}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()} O is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#getO()}
   */
  @Test
  @DisplayName("Test getO(); given PDActionLaunch() O is empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionLaunch.getO()"})
  void testGetO_givenPDActionLaunchOIsEmptyString_thenReturnEmptyString() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setO("");

    // Act and Assert
    assertEquals("", pdActionLaunch.getO());
  }

  /**
   * Test {@link PDActionLaunch#getO()}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()} O is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#getO()}
   */
  @Test
  @DisplayName("Test getO(); given PDActionLaunch() O is 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionLaunch.getO()"})
  void testGetO_givenPDActionLaunchOIsFoo_thenReturnFoo() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setO("foo");

    // Act and Assert
    assertEquals("foo", pdActionLaunch.getO());
  }

  /**
   * Test {@link PDActionLaunch#getO()}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#getO()}
   */
  @Test
  @DisplayName("Test getO(); given PDActionLaunch(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionLaunch.getO()"})
  void testGetO_givenPDActionLaunch_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionLaunch().getO());
  }

  /**
   * Test {@link PDActionLaunch#setO(String)}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()}.
   *   <li>When {@code foo}.
   *   <li>Then {@link PDActionLaunch#PDActionLaunch()} O is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setO(String)}
   */
  @Test
  @DisplayName(
      "Test setO(String); given PDActionLaunch(); when 'foo'; then PDActionLaunch() O is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setO(String)"})
  void testSetO_givenPDActionLaunch_whenFoo_thenPDActionLaunchOIsFoo() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setO("foo");

    // Assert
    assertEquals("foo", pdActionLaunch.getO());
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionLaunch#setO(String)}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()}.
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionLaunch#PDActionLaunch()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setO(String)}
   */
  @Test
  @DisplayName(
      "Test setO(String); given PDActionLaunch(); when 'null'; then PDActionLaunch() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setO(String)"})
  void testSetO_givenPDActionLaunch_whenNull_thenPDActionLaunchCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setO(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionLaunch#getP()}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()} P is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#getP()}
   */
  @Test
  @DisplayName("Test getP(); given PDActionLaunch() P is empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionLaunch.getP()"})
  void testGetP_givenPDActionLaunchPIsEmptyString_thenReturnEmptyString() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setP("");

    // Act and Assert
    assertEquals("", pdActionLaunch.getP());
  }

  /**
   * Test {@link PDActionLaunch#getP()}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()} P is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#getP()}
   */
  @Test
  @DisplayName("Test getP(); given PDActionLaunch() P is 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionLaunch.getP()"})
  void testGetP_givenPDActionLaunchPIsFoo_thenReturnFoo() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setP("foo");

    // Act and Assert
    assertEquals("foo", pdActionLaunch.getP());
  }

  /**
   * Test {@link PDActionLaunch#getP()}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#getP()}
   */
  @Test
  @DisplayName("Test getP(); given PDActionLaunch(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionLaunch.getP()"})
  void testGetP_givenPDActionLaunch_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionLaunch().getP());
  }

  /**
   * Test {@link PDActionLaunch#setP(String)}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()}.
   *   <li>When {@code foo}.
   *   <li>Then {@link PDActionLaunch#PDActionLaunch()} P is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setP(String)}
   */
  @Test
  @DisplayName(
      "Test setP(String); given PDActionLaunch(); when 'foo'; then PDActionLaunch() P is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setP(String)"})
  void testSetP_givenPDActionLaunch_whenFoo_thenPDActionLaunchPIsFoo() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setP("foo");

    // Assert
    assertEquals("foo", pdActionLaunch.getP());
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionLaunch#setP(String)}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()}.
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionLaunch#PDActionLaunch()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setP(String)}
   */
  @Test
  @DisplayName(
      "Test setP(String); given PDActionLaunch(); when 'null'; then PDActionLaunch() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setP(String)"})
  void testSetP_givenPDActionLaunch_whenNull_thenPDActionLaunchCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setP(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionLaunch#getOpenInNewWindow()}.
   *
   * <ul>
   *   <li>Given {@link PDActionLaunch#PDActionLaunch()}.
   *   <li>Then return {@code USER_PREFERENCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#getOpenInNewWindow()}
   */
  @Test
  @DisplayName("Test getOpenInNewWindow(); given PDActionLaunch(); then return 'USER_PREFERENCE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenMode PDActionLaunch.getOpenInNewWindow()"})
  void testGetOpenInNewWindow_givenPDActionLaunch_thenReturnUserPreference() {
    // Arrange, Act and Assert
    assertEquals(OpenMode.USER_PREFERENCE, new PDActionLaunch().getOpenInNewWindow());
  }

  /**
   * Test {@link PDActionLaunch#setOpenInNewWindow(OpenMode)}.
   *
   * <ul>
   *   <li>Then {@link PDActionLaunch#PDActionLaunch()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setOpenInNewWindow(OpenMode)}
   */
  @Test
  @DisplayName(
      "Test setOpenInNewWindow(OpenMode); then PDActionLaunch() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setOpenInNewWindow(OpenMode)"})
  void testSetOpenInNewWindow_thenPDActionLaunchCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setOpenInNewWindow(OpenMode.USER_PREFERENCE);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, pdActionLaunch.getOpenInNewWindow());
  }

  /**
   * Test {@link PDActionLaunch#setOpenInNewWindow(OpenMode)}.
   *
   * <ul>
   *   <li>Then {@link PDActionLaunch#PDActionLaunch()} OpenInNewWindow is {@code NEW_WINDOW}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setOpenInNewWindow(OpenMode)}
   */
  @Test
  @DisplayName(
      "Test setOpenInNewWindow(OpenMode); then PDActionLaunch() OpenInNewWindow is 'NEW_WINDOW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setOpenInNewWindow(OpenMode)"})
  void testSetOpenInNewWindow_thenPDActionLaunchOpenInNewWindowIsNewWindow() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setOpenInNewWindow(OpenMode.NEW_WINDOW);

    // Assert
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(OpenMode.NEW_WINDOW, pdActionLaunch.getOpenInNewWindow());
  }

  /**
   * Test {@link PDActionLaunch#setOpenInNewWindow(OpenMode)}.
   *
   * <ul>
   *   <li>Then {@link PDActionLaunch#PDActionLaunch()} OpenInNewWindow is {@code SAME_WINDOW}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setOpenInNewWindow(OpenMode)}
   */
  @Test
  @DisplayName(
      "Test setOpenInNewWindow(OpenMode); then PDActionLaunch() OpenInNewWindow is 'SAME_WINDOW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setOpenInNewWindow(OpenMode)"})
  void testSetOpenInNewWindow_thenPDActionLaunchOpenInNewWindowIsSameWindow() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setOpenInNewWindow(OpenMode.SAME_WINDOW);

    // Assert
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(OpenMode.SAME_WINDOW, pdActionLaunch.getOpenInNewWindow());
  }

  /**
   * Test {@link PDActionLaunch#setOpenInNewWindow(OpenMode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionLaunch#PDActionLaunch()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionLaunch#setOpenInNewWindow(OpenMode)}
   */
  @Test
  @DisplayName(
      "Test setOpenInNewWindow(OpenMode); when 'null'; then PDActionLaunch() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionLaunch.setOpenInNewWindow(OpenMode)"})
  void testSetOpenInNewWindow_whenNull_thenPDActionLaunchCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setOpenInNewWindow(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, pdActionLaunch.getOpenInNewWindow());
  }
}
