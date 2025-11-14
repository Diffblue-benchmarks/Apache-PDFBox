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

class PDActionThreadDiffblueTest {
  /**
   * Test {@link PDActionThread#PDActionThread(COSDictionary)}.
   *
   * <p>Method under test: {@link PDActionThread#PDActionThread(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionThread(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionThread.<init>(COSDictionary)"})
  void testNewPDActionThread() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new PDActionThread(a).getCOSObject());
  }

  /**
   * Test {@link PDActionThread#PDActionThread()}.
   *
   * <p>Method under test: {@link PDActionThread#PDActionThread()}
   */
  @Test
  @DisplayName("Test new PDActionThread()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionThread.<init>()"})
  void testNewPDActionThread2() throws IOException {
    // Arrange and Act
    PDActionThread actualPdActionThread = new PDActionThread();

    // Assert
    assertNull(actualPdActionThread.getNext());
    assertNull(actualPdActionThread.getB());
    assertNull(actualPdActionThread.getD());
    COSDictionary cOSObject = actualPdActionThread.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualPdActionThread.getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualPdActionThread.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualPdActionThread.getSubType());
  }

  /**
   * Test {@link PDActionThread#getD()}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   *   <li>Then return {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#getD()}
   */
  @Test
  @DisplayName(
      "Test getD(); given COSObjectKey(long, int) with num is one and gen is one; then return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDActionThread.getD()"})
  void testGetD_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnFalse() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    COSObject d = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    pdActionThread.setD(d);

    // Act
    COSBase actualD = pdActionThread.getD();

    // Assert
    assertSame(((COSBoolean) actualD).FALSE, actualD);
  }

  /**
   * Test {@link PDActionThread#getD()}.
   *
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#getD()}
   */
  @Test
  @DisplayName(
      "Test getD(); given PDActionThread(COSDictionary) with a is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDActionThread.getD()"})
  void testGetD_givenPDActionThreadWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionThread(new COSDictionary()).getD());
  }

  /**
   * Test {@link PDActionThread#getD()}.
   *
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#getD()}
   */
  @Test
  @DisplayName("Test getD(); given PDActionThread(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDActionThread.getD()"})
  void testGetD_givenPDActionThread_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionThread().getD());
  }

  /**
   * Test {@link PDActionThread#setD(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#setD(COSBase)}
   */
  @Test
  @DisplayName("Test setD(COSBase); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionThread.setD(COSBase)"})
  void testSetD_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    COSDictionary d = new COSDictionary();
    d.setKey(new COSObjectKey(1L, 1));

    // Act
    pdActionThread.setD(d);

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(d, pdActionThread.getD());
  }

  /**
   * Test {@link PDActionThread#setD(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread()}.
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then {@link PDActionThread#PDActionThread()} D is {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#setD(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setD(COSBase); given PDActionThread(); when COSArray(); then PDActionThread() D is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionThread.setD(COSBase)"})
  void testSetD_givenPDActionThread_whenCOSArray_thenPDActionThreadDIsCOSArray() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    COSArray d = new COSArray();

    // Act
    pdActionThread.setD(d);

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(d, pdActionThread.getD());
  }

  /**
   * Test {@link PDActionThread#setD(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread()}.
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link PDActionThread#PDActionThread()} D is {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#setD(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setD(COSBase); given PDActionThread(); when FALSE; then PDActionThread() D is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionThread.setD(COSBase)"})
  void testSetD_givenPDActionThread_whenFalse_thenPDActionThreadDIsFalse() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setD(COSBoolean.FALSE);

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(COSBoolean.FALSE, pdActionThread.getD());
  }

  /**
   * Test {@link PDActionThread#setD(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread()}.
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionThread#PDActionThread()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#setD(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setD(COSBase); given PDActionThread(); when 'null'; then PDActionThread() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionThread.setD(COSBase)"})
  void testSetD_givenPDActionThread_whenNull_thenPDActionThreadCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setD(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionThread#setD(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link PDActionThread#PDActionThread()} D is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#setD(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setD(COSBase); when COSDictionary(); then PDActionThread() D is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionThread.setD(COSBase)"})
  void testSetD_whenCOSDictionary_thenPDActionThreadDIsCOSDictionary() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    COSDictionary d = new COSDictionary();

    // Act
    pdActionThread.setD(d);

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(d, pdActionThread.getD());
  }

  /**
   * Test {@link PDActionThread#setD(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#setD(COSBase)}
   */
  @Test
  @DisplayName("Test setD(COSBase); when COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionThread.setD(COSBase)"})
  void testSetD_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    COSObject d = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    pdActionThread.setD(d);

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionThread#getFile()}.
   *
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#getFile()}
   */
  @Test
  @DisplayName(
      "Test getFile(); given PDActionThread(COSDictionary) with a is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFileSpecification PDActionThread.getFile()"})
  void testGetFile_givenPDActionThreadWithAIsCOSDictionary_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDActionThread(new COSDictionary()).getFile());
  }

  /**
   * Test {@link PDActionThread#getFile()}.
   *
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given PDActionThread(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFileSpecification PDActionThread.getFile()"})
  void testGetFile_givenPDActionThread_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDActionThread().getFile());
  }

  /**
   * Test {@link PDActionThread#getFile()}.
   *
   * <ul>
   *   <li>Then COSObject return {@link COSString}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then COSObject return COSString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFileSpecification PDActionThread.getFile()"})
  void testGetFile_thenCOSObjectReturnCOSString() throws IOException {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    pdActionThread.setFile(new PDSimpleFileSpecification());

    // Act
    PDFileSpecification actualFile = pdActionThread.getFile();

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
   * Test {@link PDActionThread#getFile()}.
   *
   * <ul>
   *   <li>Then return {@link PDComplexFileSpecification}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then return PDComplexFileSpecification")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFileSpecification PDActionThread.getFile()"})
  void testGetFile_thenReturnPDComplexFileSpecification() throws IOException {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    pdActionThread.setFile(new PDComplexFileSpecification());

    // Act
    PDFileSpecification actualFile = pdActionThread.getFile();

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
   * Test {@link PDActionThread#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>Then {@link PDActionThread#PDActionThread()} File {@link PDComplexFileSpecification}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName(
      "Test setFile(PDFileSpecification); then PDActionThread() File PDComplexFileSpecification")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionThread.setFile(PDFileSpecification)"})
  void testSetFile_thenPDActionThreadFilePDComplexFileSpecification() throws IOException {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setFile(new PDComplexFileSpecification());

    // Assert
    PDFileSpecification file = pdActionThread.getFile();
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
   * Test {@link PDActionThread#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>Then {@link PDActionThread#PDActionThread()} File {@link PDSimpleFileSpecification}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName(
      "Test setFile(PDFileSpecification); then PDActionThread() File PDSimpleFileSpecification")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionThread.setFile(PDFileSpecification)"})
  void testSetFile_thenPDActionThreadFilePDSimpleFileSpecification() throws IOException {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setFile(new PDSimpleFileSpecification());

    // Assert
    PDFileSpecification file = pdActionThread.getFile();
    assertTrue(file instanceof PDSimpleFileSpecification);
    assertEquals("", file.getFile());
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionThread#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionThread#PDActionThread()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName(
      "Test setFile(PDFileSpecification); when 'null'; then PDActionThread() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionThread.setFile(PDFileSpecification)"})
  void testSetFile_whenNull_thenPDActionThreadCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setFile(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionThread#getB()}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   *   <li>Then return {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#getB()}
   */
  @Test
  @DisplayName(
      "Test getB(); given COSObjectKey(long, int) with num is one and gen is one; then return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDActionThread.getB()"})
  void testGetB_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnFalse() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    COSObject b = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    pdActionThread.setB(b);

    // Act
    COSBase actualB = pdActionThread.getB();

    // Assert
    assertSame(((COSBoolean) actualB).FALSE, actualB);
  }

  /**
   * Test {@link PDActionThread#getB()}.
   *
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#getB()}
   */
  @Test
  @DisplayName(
      "Test getB(); given PDActionThread(COSDictionary) with a is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDActionThread.getB()"})
  void testGetB_givenPDActionThreadWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionThread(new COSDictionary()).getB());
  }

  /**
   * Test {@link PDActionThread#getB()}.
   *
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#getB()}
   */
  @Test
  @DisplayName("Test getB(); given PDActionThread(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDActionThread.getB()"})
  void testGetB_givenPDActionThread_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionThread().getB());
  }

  /**
   * Test {@link PDActionThread#setB(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#setB(COSBase)}
   */
  @Test
  @DisplayName("Test setB(COSBase); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionThread.setB(COSBase)"})
  void testSetB_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    COSDictionary b = new COSDictionary();
    b.setKey(new COSObjectKey(1L, 1));

    // Act
    pdActionThread.setB(b);

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(b, pdActionThread.getB());
  }

  /**
   * Test {@link PDActionThread#setB(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread()}.
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then {@link PDActionThread#PDActionThread()} B is {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#setB(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setB(COSBase); given PDActionThread(); when COSArray(); then PDActionThread() B is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionThread.setB(COSBase)"})
  void testSetB_givenPDActionThread_whenCOSArray_thenPDActionThreadBIsCOSArray() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    COSArray b = new COSArray();

    // Act
    pdActionThread.setB(b);

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(b, pdActionThread.getB());
  }

  /**
   * Test {@link PDActionThread#setB(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread()}.
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link PDActionThread#PDActionThread()} B is {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#setB(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setB(COSBase); given PDActionThread(); when FALSE; then PDActionThread() B is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionThread.setB(COSBase)"})
  void testSetB_givenPDActionThread_whenFalse_thenPDActionThreadBIsFalse() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setB(COSBoolean.FALSE);

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(COSBoolean.FALSE, pdActionThread.getB());
  }

  /**
   * Test {@link PDActionThread#setB(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread()}.
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionThread#PDActionThread()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#setB(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setB(COSBase); given PDActionThread(); when 'null'; then PDActionThread() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionThread.setB(COSBase)"})
  void testSetB_givenPDActionThread_whenNull_thenPDActionThreadCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setB(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionThread#setB(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link PDActionThread#PDActionThread()} B is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#setB(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setB(COSBase); when COSDictionary(); then PDActionThread() B is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionThread.setB(COSBase)"})
  void testSetB_whenCOSDictionary_thenPDActionThreadBIsCOSDictionary() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    COSDictionary b = new COSDictionary();

    // Act
    pdActionThread.setB(b);

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(b, pdActionThread.getB());
  }

  /**
   * Test {@link PDActionThread#setB(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDActionThread#setB(COSBase)}
   */
  @Test
  @DisplayName("Test setB(COSBase); when COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionThread.setB(COSBase)"})
  void testSetB_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    COSObject b = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    pdActionThread.setB(b);

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }
}
