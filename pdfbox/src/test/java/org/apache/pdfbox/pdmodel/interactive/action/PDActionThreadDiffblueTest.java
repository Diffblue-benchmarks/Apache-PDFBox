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

class PDActionThreadDiffblueTest {
  /**
   * Test {@link PDActionThread#PDActionThread(COSDictionary)}.
   * <p>
   * Method under test: {@link PDActionThread#PDActionThread(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionThread(COSDictionary)")
  void testNewPDActionThread() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionThread(a)).getCOSObject());
  }

  /**
   * Test {@link PDActionThread#PDActionThread()}.
   * <p>
   * Method under test: {@link PDActionThread#PDActionThread()}
   */
  @Test
  @DisplayName("Test new PDActionThread()")
  void testNewPDActionThread2() throws IOException {
    // Arrange and Act
    PDActionThread actualPdActionThread = new PDActionThread();

    // Assert
    assertNull(actualPdActionThread.getNext());
    assertNull(actualPdActionThread.getB());
    assertNull(actualPdActionThread.getD());
    COSDictionary cOSObject = actualPdActionThread.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdActionThread.getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPdActionThread.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualPdActionThread.getSubType());
  }

  /**
   * Test {@link PDActionThread#getD()}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   *   <li>Then return {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#getD()}
   */
  @Test
  @DisplayName("Test getD(); given COSObjectKey(long, int) with num is one and gen is one; then return FALSE")
  void testGetD_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnFalse() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    pdActionThread.setD(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act
    COSBase actualD = pdActionThread.getD();

    // Assert
    assertSame(((COSBoolean) actualD).FALSE, actualD);
  }

  /**
   * Test {@link PDActionThread#getD()}.
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread(COSDictionary)} with a is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#getD()}
   */
  @Test
  @DisplayName("Test getD(); given PDActionThread(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetD_givenPDActionThreadWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionThread(new COSDictionary())).getD());
  }

  /**
   * Test {@link PDActionThread#getD()}.
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#getD()}
   */
  @Test
  @DisplayName("Test getD(); given PDActionThread(); then return 'null'")
  void testGetD_givenPDActionThread_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionThread()).getD());
  }

  /**
   * Test {@link PDActionThread#setD(COSBase)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#setD(COSBase)}
   */
  @Test
  @DisplayName("Test setD(COSBase); given COSObjectKey(long, int) with num is one and gen is one")
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
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then {@link PDActionThread#PDActionThread()} D is
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#setD(COSBase)}
   */
  @Test
  @DisplayName("Test setD(COSBase); when COSArray(); then PDActionThread() D is COSArray()")
  void testSetD_whenCOSArray_thenPDActionThreadDIsCOSArray() {
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
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link PDActionThread#PDActionThread()} D is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#setD(COSBase)}
   */
  @Test
  @DisplayName("Test setD(COSBase); when COSDictionary(); then PDActionThread() D is COSDictionary()")
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
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#setD(COSBase)}
   */
  @Test
  @DisplayName("Test setD(COSBase); when COSObjectKey(long, int) with num is one and gen is one")
  void testSetD_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setD(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionThread#setD(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link PDActionThread#PDActionThread()} D is
   * {@link COSBoolean#FALSE} {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#setD(COSBase)}
   */
  @Test
  @DisplayName("Test setD(COSBase); when FALSE; then PDActionThread() D is FALSE FALSE")
  void testSetD_whenFalse_thenPDActionThreadDIsFalseFalse() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    COSBoolean d = COSBoolean.FALSE;

    // Act
    pdActionThread.setD(d);

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSBoolean expectedD = d.FALSE;
    assertSame(expectedD, pdActionThread.getD());
  }

  /**
   * Test {@link PDActionThread#setD(COSBase)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDActionThread#PDActionThread()} D is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#setD(COSBase)}
   */
  @Test
  @DisplayName("Test setD(COSBase); when 'null'; then PDActionThread() D is 'null'")
  void testSetD_whenNull_thenPDActionThreadDIsNull() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setD(null);

    // Assert
    assertNull(pdActionThread.getD());
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionThread#getFile()}.
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread(COSDictionary)} with a is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given PDActionThread(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetFile_givenPDActionThreadWithAIsCOSDictionary_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDActionThread(new COSDictionary())).getFile());
  }

  /**
   * Test {@link PDActionThread#getFile()}.
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given PDActionThread(); then return 'null'")
  void testGetFile_givenPDActionThread_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDActionThread()).getFile());
  }

  /**
   * Test {@link PDActionThread#getFile()}.
   * <ul>
   *   <li>Then COSObject return {@link COSString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then COSObject return COSString")
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
    assertEquals(0, ((COSString) cOSObject).getBytes().length);
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
  }

  /**
   * Test {@link PDActionThread#getFile()}.
   * <ul>
   *   <li>Then return {@link PDComplexFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then return PDComplexFileSpecification")
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
   * Test {@link PDActionThread#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDActionThread#PDActionThread()} File is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); given PDActionThread(); when 'null'; then PDActionThread() File is 'null'")
  void testSetFile_givenPDActionThread_whenNull_thenPDActionThreadFileIsNull() throws IOException {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setFile(null);

    // Assert
    assertNull(pdActionThread.getFile());
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionThread#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>Then {@link PDActionThread#PDActionThread()} File
   * {@link PDComplexFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); then PDActionThread() File PDComplexFileSpecification")
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
   * <ul>
   *   <li>Then {@link PDActionThread#PDActionThread()} File
   * {@link PDSimpleFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); then PDActionThread() File PDSimpleFileSpecification")
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
   * Test {@link PDActionThread#getB()}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   *   <li>Then return {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#getB()}
   */
  @Test
  @DisplayName("Test getB(); given COSObjectKey(long, int) with num is one and gen is one; then return FALSE")
  void testGetB_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnFalse() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    pdActionThread.setB(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act
    COSBase actualB = pdActionThread.getB();

    // Assert
    assertSame(((COSBoolean) actualB).FALSE, actualB);
  }

  /**
   * Test {@link PDActionThread#getB()}.
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread(COSDictionary)} with a is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#getB()}
   */
  @Test
  @DisplayName("Test getB(); given PDActionThread(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetB_givenPDActionThreadWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionThread(new COSDictionary())).getB());
  }

  /**
   * Test {@link PDActionThread#getB()}.
   * <ul>
   *   <li>Given {@link PDActionThread#PDActionThread()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#getB()}
   */
  @Test
  @DisplayName("Test getB(); given PDActionThread(); then return 'null'")
  void testGetB_givenPDActionThread_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionThread()).getB());
  }

  /**
   * Test {@link PDActionThread#setB(COSBase)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#setB(COSBase)}
   */
  @Test
  @DisplayName("Test setB(COSBase); given COSObjectKey(long, int) with num is one and gen is one")
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
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then {@link PDActionThread#PDActionThread()} B is
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#setB(COSBase)}
   */
  @Test
  @DisplayName("Test setB(COSBase); when COSArray(); then PDActionThread() B is COSArray()")
  void testSetB_whenCOSArray_thenPDActionThreadBIsCOSArray() {
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
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link PDActionThread#PDActionThread()} B is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#setB(COSBase)}
   */
  @Test
  @DisplayName("Test setB(COSBase); when COSDictionary(); then PDActionThread() B is COSDictionary()")
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
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#setB(COSBase)}
   */
  @Test
  @DisplayName("Test setB(COSBase); when COSObjectKey(long, int) with num is one and gen is one")
  void testSetB_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setB(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionThread#setB(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link PDActionThread#PDActionThread()} B is
   * {@link COSBoolean#FALSE} {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#setB(COSBase)}
   */
  @Test
  @DisplayName("Test setB(COSBase); when FALSE; then PDActionThread() B is FALSE FALSE")
  void testSetB_whenFalse_thenPDActionThreadBIsFalseFalse() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    COSBoolean b = COSBoolean.FALSE;

    // Act
    pdActionThread.setB(b);

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSBoolean expectedB = b.FALSE;
    assertSame(expectedB, pdActionThread.getB());
  }

  /**
   * Test {@link PDActionThread#setB(COSBase)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDActionThread#PDActionThread()} B is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionThread#setB(COSBase)}
   */
  @Test
  @DisplayName("Test setB(COSBase); when 'null'; then PDActionThread() B is 'null'")
  void testSetB_whenNull_thenPDActionThreadBIsNull() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setB(null);

    // Assert
    assertNull(pdActionThread.getB());
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }
}
