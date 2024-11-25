package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDActionImportDataDiffblueTest {
  /**
   * Test {@link PDActionImportData#PDActionImportData(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDActionImportData#PDActionImportData(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionImportData(COSDictionary)")
  void testNewPDActionImportData() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionImportData(a)).getCOSObject());
  }

  /**
   * Test {@link PDActionImportData#PDActionImportData()}.
   * <p>
   * Method under test: {@link PDActionImportData#PDActionImportData()}
   */
  @Test
  @DisplayName("Test new PDActionImportData()")
  void testNewPDActionImportData2() throws IOException {
    // Arrange and Act
    PDActionImportData actualPdActionImportData = new PDActionImportData();

    // Assert
    assertNull(actualPdActionImportData.getNext());
    COSDictionary cOSObject = actualPdActionImportData.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdActionImportData.getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPdActionImportData.getType());
    assertEquals(PDActionImportData.SUB_TYPE, actualPdActionImportData.getSubType());
  }

  /**
   * Test {@link PDActionImportData#getFile()}.
   * <ul>
   *   <li>Given {@link PDActionImportData#PDActionImportData(COSDictionary)} with a
   * is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionImportData#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given PDActionImportData(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetFile_givenPDActionImportDataWithAIsCOSDictionary_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDActionImportData(new COSDictionary())).getFile());
  }

  /**
   * Test {@link PDActionImportData#getFile()}.
   * <ul>
   *   <li>Given {@link PDActionImportData#PDActionImportData()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionImportData#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given PDActionImportData(); then return 'null'")
  void testGetFile_givenPDActionImportData_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDActionImportData()).getFile());
  }

  /**
   * Test {@link PDActionImportData#getFile()}.
   * <ul>
   *   <li>Then COSObject return {@link COSString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionImportData#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then COSObject return COSString")
  void testGetFile_thenCOSObjectReturnCOSString() throws IOException {
    // Arrange
    PDActionImportData pdActionImportData = new PDActionImportData();
    pdActionImportData.setFile(new PDSimpleFileSpecification());

    // Act
    PDFileSpecification actualFile = pdActionImportData.getFile();

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
   * Test {@link PDActionImportData#getFile()}.
   * <ul>
   *   <li>Then return {@link PDComplexFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionImportData#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then return PDComplexFileSpecification")
  void testGetFile_thenReturnPDComplexFileSpecification() throws IOException {
    // Arrange
    PDActionImportData pdActionImportData = new PDActionImportData();
    pdActionImportData.setFile(new PDComplexFileSpecification());

    // Act
    PDFileSpecification actualFile = pdActionImportData.getFile();

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
   * Test {@link PDActionImportData#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>Given {@link PDActionImportData#PDActionImportData()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDActionImportData#PDActionImportData()} File is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionImportData#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); given PDActionImportData(); when 'null'; then PDActionImportData() File is 'null'")
  void testSetFile_givenPDActionImportData_whenNull_thenPDActionImportDataFileIsNull() throws IOException {
    // Arrange
    PDActionImportData pdActionImportData = new PDActionImportData();

    // Act
    pdActionImportData.setFile(null);

    // Assert
    assertNull(pdActionImportData.getFile());
    COSDictionary cOSObject = pdActionImportData.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionImportData#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>Then {@link PDActionImportData#PDActionImportData()} File
   * {@link PDComplexFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionImportData#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); then PDActionImportData() File PDComplexFileSpecification")
  void testSetFile_thenPDActionImportDataFilePDComplexFileSpecification() throws IOException {
    // Arrange
    PDActionImportData pdActionImportData = new PDActionImportData();

    // Act
    pdActionImportData.setFile(new PDComplexFileSpecification());

    // Assert
    PDFileSpecification file = pdActionImportData.getFile();
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
   * Test {@link PDActionImportData#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>Then {@link PDActionImportData#PDActionImportData()} File
   * {@link PDSimpleFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionImportData#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); then PDActionImportData() File PDSimpleFileSpecification")
  void testSetFile_thenPDActionImportDataFilePDSimpleFileSpecification() throws IOException {
    // Arrange
    PDActionImportData pdActionImportData = new PDActionImportData();

    // Act
    pdActionImportData.setFile(new PDSimpleFileSpecification());

    // Assert
    PDFileSpecification file = pdActionImportData.getFile();
    assertTrue(file instanceof PDSimpleFileSpecification);
    assertEquals("", file.getFile());
    COSDictionary cOSObject = pdActionImportData.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }
}
