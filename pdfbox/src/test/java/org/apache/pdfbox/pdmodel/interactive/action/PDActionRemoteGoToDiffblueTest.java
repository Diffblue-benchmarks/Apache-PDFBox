package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDActionRemoteGoToDiffblueTest {
  /**
   * Test {@link PDActionRemoteGoTo#PDActionRemoteGoTo(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDActionRemoteGoTo#PDActionRemoteGoTo(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionRemoteGoTo(COSDictionary)")
  void testNewPDActionRemoteGoTo() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionRemoteGoTo(a)).getCOSObject());
  }

  /**
   * Test {@link PDActionRemoteGoTo#PDActionRemoteGoTo()}.
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#PDActionRemoteGoTo()}
   */
  @Test
  @DisplayName("Test new PDActionRemoteGoTo()")
  void testNewPDActionRemoteGoTo2() throws IOException {
    // Arrange and Act
    PDActionRemoteGoTo actualPdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Assert
    assertNull(actualPdActionRemoteGoTo.getNext());
    assertNull(actualPdActionRemoteGoTo.getD());
    COSDictionary cOSObject = actualPdActionRemoteGoTo.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdActionRemoteGoTo.getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, actualPdActionRemoteGoTo.getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPdActionRemoteGoTo.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualPdActionRemoteGoTo.getSubType());
  }

  /**
   * Test {@link PDActionRemoteGoTo#getFile()}.
   * <ul>
   *   <li>Given {@link PDActionRemoteGoTo#PDActionRemoteGoTo(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given PDActionRemoteGoTo(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetFile_givenPDActionRemoteGoToWithAIsCOSDictionary_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDActionRemoteGoTo(new COSDictionary())).getFile());
  }

  /**
   * Test {@link PDActionRemoteGoTo#getFile()}.
   * <ul>
   *   <li>Given {@link PDActionRemoteGoTo#PDActionRemoteGoTo()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given PDActionRemoteGoTo(); then return 'null'")
  void testGetFile_givenPDActionRemoteGoTo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDActionRemoteGoTo()).getFile());
  }

  /**
   * Test {@link PDActionRemoteGoTo#getFile()}.
   * <ul>
   *   <li>Then COSObject return {@link COSString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then COSObject return COSString")
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
    assertEquals(0, ((COSString) cOSObject).getBytes().length);
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
  }

  /**
   * Test {@link PDActionRemoteGoTo#getFile()}.
   * <ul>
   *   <li>Then return {@link PDComplexFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then return PDComplexFileSpecification")
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
    COSBase cOSObject = actualFile.getCOSObject();
    COSUpdateState updateState = ((COSDictionary) cOSObject).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileUnix());
    assertEquals(1, ((COSDictionary) cOSObject).getValues().size());
    assertEquals(1, ((COSDictionary) cOSObject).size());
    COSIncrement toIncrementResult = ((COSDictionary) cOSObject).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSDictionary) cOSObject).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDComplexFileSpecification) actualFile).isVolatile());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>Given {@link PDActionRemoteGoTo#PDActionRemoteGoTo()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} File is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); given PDActionRemoteGoTo(); when 'null'; then PDActionRemoteGoTo() File is 'null'")
  void testSetFile_givenPDActionRemoteGoTo_whenNull_thenPDActionRemoteGoToFileIsNull() throws IOException {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setFile(null);

    // Assert
    assertNull(pdActionRemoteGoTo.getFile());
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} File
   * {@link PDComplexFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); then PDActionRemoteGoTo() File PDComplexFileSpecification")
  void testSetFile_thenPDActionRemoteGoToFilePDComplexFileSpecification() throws IOException {
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
   * Test {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} File
   * {@link PDSimpleFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); then PDActionRemoteGoTo() File PDSimpleFileSpecification")
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
   * Test {@link PDActionRemoteGoTo#getD()}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   *   <li>Then return {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#getD()}
   */
  @Test
  @DisplayName("Test getD(); given COSObjectKey(long, int) with num is one and gen is one; then return FALSE")
  void testGetD_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnFalse() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    pdActionRemoteGoTo.setD(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act
    COSBase actualD = pdActionRemoteGoTo.getD();

    // Assert
    assertSame(((COSBoolean) actualD).FALSE, actualD);
  }

  /**
   * Test {@link PDActionRemoteGoTo#getD()}.
   * <ul>
   *   <li>Given {@link PDActionRemoteGoTo#PDActionRemoteGoTo(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#getD()}
   */
  @Test
  @DisplayName("Test getD(); given PDActionRemoteGoTo(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetD_givenPDActionRemoteGoToWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionRemoteGoTo(new COSDictionary())).getD());
  }

  /**
   * Test {@link PDActionRemoteGoTo#getD()}.
   * <ul>
   *   <li>Given {@link PDActionRemoteGoTo#PDActionRemoteGoTo()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#getD()}
   */
  @Test
  @DisplayName("Test getD(); given PDActionRemoteGoTo(); then return 'null'")
  void testGetD_givenPDActionRemoteGoTo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionRemoteGoTo()).getD());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setD(COSBase)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#setD(COSBase)}
   */
  @Test
  @DisplayName("Test setD(COSBase); given COSObjectKey(long, int) with num is one and gen is one")
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
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} D is
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#setD(COSBase)}
   */
  @Test
  @DisplayName("Test setD(COSBase); when COSArray(); then PDActionRemoteGoTo() D is COSArray()")
  void testSetD_whenCOSArray_thenPDActionRemoteGoToDIsCOSArray() {
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
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} D is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#setD(COSBase)}
   */
  @Test
  @DisplayName("Test setD(COSBase); when COSDictionary(); then PDActionRemoteGoTo() D is COSDictionary()")
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
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#setD(COSBase)}
   */
  @Test
  @DisplayName("Test setD(COSBase); when COSObjectKey(long, int) with num is one and gen is one")
  void testSetD_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setD(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setD(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} D is
   * {@link COSBoolean#FALSE} {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#setD(COSBase)}
   */
  @Test
  @DisplayName("Test setD(COSBase); when FALSE; then PDActionRemoteGoTo() D is FALSE FALSE")
  void testSetD_whenFalse_thenPDActionRemoteGoToDIsFalseFalse() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    COSBoolean d = COSBoolean.FALSE;

    // Act
    pdActionRemoteGoTo.setD(d);

    // Assert
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSBoolean expectedD = d.FALSE;
    assertSame(expectedD, pdActionRemoteGoTo.getD());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setD(COSBase)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} D is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#setD(COSBase)}
   */
  @Test
  @DisplayName("Test setD(COSBase); when 'null'; then PDActionRemoteGoTo() D is 'null'")
  void testSetD_whenNull_thenPDActionRemoteGoToDIsNull() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setD(null);

    // Assert
    assertNull(pdActionRemoteGoTo.getD());
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionRemoteGoTo#getOpenInNewWindow()}.
   * <ul>
   *   <li>Given {@link PDActionRemoteGoTo#PDActionRemoteGoTo(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#getOpenInNewWindow()}
   */
  @Test
  @DisplayName("Test getOpenInNewWindow(); given PDActionRemoteGoTo(COSDictionary) with a is COSDictionary()")
  void testGetOpenInNewWindow_givenPDActionRemoteGoToWithAIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(OpenMode.USER_PREFERENCE, (new PDActionRemoteGoTo(new COSDictionary())).getOpenInNewWindow());
  }

  /**
   * Test {@link PDActionRemoteGoTo#getOpenInNewWindow()}.
   * <ul>
   *   <li>Given {@link PDActionRemoteGoTo#PDActionRemoteGoTo()}.</li>
   *   <li>Then return {@code USER_PREFERENCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#getOpenInNewWindow()}
   */
  @Test
  @DisplayName("Test getOpenInNewWindow(); given PDActionRemoteGoTo(); then return 'USER_PREFERENCE'")
  void testGetOpenInNewWindow_givenPDActionRemoteGoTo_thenReturnUserPreference() {
    // Arrange, Act and Assert
    assertEquals(OpenMode.USER_PREFERENCE, (new PDActionRemoteGoTo()).getOpenInNewWindow());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setOpenInNewWindow(OpenMode)}.
   * <ul>
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} COSObject Values
   * size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#setOpenInNewWindow(OpenMode)}
   */
  @Test
  @DisplayName("Test setOpenInNewWindow(OpenMode); then PDActionRemoteGoTo() COSObject Values size is two")
  void testSetOpenInNewWindow_thenPDActionRemoteGoToCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setOpenInNewWindow(OpenMode.USER_PREFERENCE);

    // Assert
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, pdActionRemoteGoTo.getOpenInNewWindow());
  }

  /**
   * Test {@link PDActionRemoteGoTo#setOpenInNewWindow(OpenMode)}.
   * <ul>
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} OpenInNewWindow is
   * {@code NEW_WINDOW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#setOpenInNewWindow(OpenMode)}
   */
  @Test
  @DisplayName("Test setOpenInNewWindow(OpenMode); then PDActionRemoteGoTo() OpenInNewWindow is 'NEW_WINDOW'")
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
   * <ul>
   *   <li>Then {@link PDActionRemoteGoTo#PDActionRemoteGoTo()} OpenInNewWindow is
   * {@code SAME_WINDOW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionRemoteGoTo#setOpenInNewWindow(OpenMode)}
   */
  @Test
  @DisplayName("Test setOpenInNewWindow(OpenMode); then PDActionRemoteGoTo() OpenInNewWindow is 'SAME_WINDOW'")
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
}
