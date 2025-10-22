package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

class PDActionImportDataDiffblueTest {
  /**
   * Test {@link PDActionImportData#PDActionImportData(COSDictionary)}.
   * <p>
   * Method under test: {@link PDActionImportData#PDActionImportData(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionImportData(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionImportData.<init>(COSDictionary)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionImportData.<init>()"})
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
   *   <li>Given {@link PDActionImportData#PDActionImportData()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionImportData#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given PDActionImportData(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFileSpecification PDActionImportData.getFile()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFileSpecification PDActionImportData.getFile()"})
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
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
    assertArrayEquals(new byte[]{}, ((COSString) cOSObject).getBytes());
  }

  /**
   * Test {@link PDActionImportData#getFile()}.
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionImportData#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then return COSObject is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFileSpecification PDActionImportData.getFile()"})
  void testGetFile_thenReturnCOSObjectIsCOSDictionary() throws IOException {
    // Arrange
    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));
    PDComplexFileSpecification fs = new PDComplexFileSpecification(dict);

    PDActionImportData pdActionImportData = new PDActionImportData();
    pdActionImportData.setFile(fs);

    // Act
    PDFileSpecification actualFile = pdActionImportData.getFile();

    // Assert
    assertTrue(actualFile instanceof PDComplexFileSpecification);
    assertSame(dict, actualFile.getCOSObject());
  }

  /**
   * Test {@link PDActionImportData#getFile()}.
   * <ul>
   *   <li>Then return FileDescription is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionImportData#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then return FileDescription is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFileSpecification PDActionImportData.getFile()"})
  void testGetFile_thenReturnFileDescriptionIsNull() throws IOException {
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
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileUnix());
    assertFalse(((PDComplexFileSpecification) actualFile).isVolatile());
  }

  /**
   * Test {@link PDActionImportData#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>Then {@link PDActionImportData#PDActionImportData()} File {@link PDComplexFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionImportData#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); then PDActionImportData() File PDComplexFileSpecification")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionImportData.setFile(PDFileSpecification)"})
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
   *   <li>Then {@link PDActionImportData#PDActionImportData()} File {@link PDSimpleFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionImportData#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); then PDActionImportData() File PDSimpleFileSpecification")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionImportData.setFile(PDFileSpecification)"})
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

  /**
   * Test {@link PDActionImportData#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDActionImportData#PDActionImportData()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionImportData#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); when 'null'; then PDActionImportData() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionImportData.setFile(PDFileSpecification)"})
  void testSetFile_whenNull_thenPDActionImportDataCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionImportData pdActionImportData = new PDActionImportData();

    // Act
    pdActionImportData.setFile(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionImportData.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }
}
