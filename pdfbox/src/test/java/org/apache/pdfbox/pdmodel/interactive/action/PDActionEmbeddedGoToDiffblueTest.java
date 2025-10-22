package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDNamedDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitDestination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDActionEmbeddedGoToDiffblueTest {
  /**
   * Test {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}.
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionEmbeddedGoTo(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionEmbeddedGoTo.<init>(COSDictionary)"})
  void testNewPDActionEmbeddedGoTo() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionEmbeddedGoTo(a)).getCOSObject());
  }

  /**
   * Test {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}
   */
  @Test
  @DisplayName("Test new PDActionEmbeddedGoTo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionEmbeddedGoTo.<init>()"})
  void testNewPDActionEmbeddedGoTo2() throws IOException {
    // Arrange and Act
    PDActionEmbeddedGoTo actualPdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Assert
    assertNull(actualPdActionEmbeddedGoTo.getNext());
    COSDictionary cOSObject = actualPdActionEmbeddedGoTo.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualPdActionEmbeddedGoTo.getFile());
    assertNull(actualPdActionEmbeddedGoTo.getTargetDirectory());
    assertNull(actualPdActionEmbeddedGoTo.getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, actualPdActionEmbeddedGoTo.getOpenInNewWindow());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(PDAction.TYPE, actualPdActionEmbeddedGoTo.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualPdActionEmbeddedGoTo.getSubType());
  }

  /**
   * Test {@link PDActionEmbeddedGoTo#setDestination(PDDestination)}.
   * <ul>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} Destination {@link PDNamedDestination}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#setDestination(PDDestination)}
   */
  @Test
  @DisplayName("Test setDestination(PDDestination); then PDActionEmbeddedGoTo() Destination PDNamedDestination")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionEmbeddedGoTo.setDestination(PDDestination)"})
  void testSetDestination_thenPDActionEmbeddedGoToDestinationPDNamedDestination() throws IOException {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setDestination(new PDNamedDestination("Dest"));

    // Assert
    PDDestination destination = pdActionEmbeddedGoTo.getDestination();
    assertTrue(destination instanceof PDNamedDestination);
    assertEquals("Dest", ((PDNamedDestination) destination).getNamedDestination());
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionEmbeddedGoTo#setDestination(PDDestination)}.
   * <ul>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} Destination {@link PDPageFitDestination}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#setDestination(PDDestination)}
   */
  @Test
  @DisplayName("Test setDestination(PDDestination); then PDActionEmbeddedGoTo() Destination PDPageFitDestination")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionEmbeddedGoTo.setDestination(PDDestination)"})
  void testSetDestination_thenPDActionEmbeddedGoToDestinationPDPageFitDestination() throws IOException {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    PDPageFitDestination d = new PDPageFitDestination();
    d.setPageNumber(10);

    // Act
    pdActionEmbeddedGoTo.setDestination(d);

    // Assert
    PDDestination destination = pdActionEmbeddedGoTo.getDestination();
    assertTrue(destination instanceof PDPageFitDestination);
    assertNull(((PDPageFitDestination) destination).getPage());
    assertEquals(10, ((PDPageFitDestination) destination).getPageNumber());
  }

  /**
   * Test {@link PDActionEmbeddedGoTo#setDestination(PDDestination)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#setDestination(PDDestination)}
   */
  @Test
  @DisplayName("Test setDestination(PDDestination); when 'null'; then PDActionEmbeddedGoTo() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionEmbeddedGoTo.setDestination(PDDestination)"})
  void testSetDestination_whenNull_thenPDActionEmbeddedGoToCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setDestination(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionEmbeddedGoTo#setDestination(PDDestination)}.
   * <ul>
   *   <li>When {@link PDPageFitDestination#PDPageFitDestination(COSArray)} with arr is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#setDestination(PDDestination)}
   */
  @Test
  @DisplayName("Test setDestination(PDDestination); when PDPageFitDestination(COSArray) with arr is COSArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionEmbeddedGoTo.setDestination(PDDestination)"})
  void testSetDestination_whenPDPageFitDestinationWithArrIsCOSArray() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setDestination(new PDPageFitDestination(new COSArray()));

    // Assert
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionEmbeddedGoTo#setDestination(PDDestination)}.
   * <ul>
   *   <li>When {@link PDPageFitDestination#PDPageFitDestination()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#setDestination(PDDestination)}
   */
  @Test
  @DisplayName("Test setDestination(PDDestination); when PDPageFitDestination(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionEmbeddedGoTo.setDestination(PDDestination)"})
  void testSetDestination_whenPDPageFitDestination_thenThrowIllegalArgumentException() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdActionEmbeddedGoTo.setDestination(new PDPageFitDestination()));
  }

  /**
   * Test {@link PDActionEmbeddedGoTo#getFile()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given PDActionEmbeddedGoTo(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFileSpecification PDActionEmbeddedGoTo.getFile()"})
  void testGetFile_givenPDActionEmbeddedGoTo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDActionEmbeddedGoTo()).getFile());
  }

  /**
   * Test {@link PDActionEmbeddedGoTo#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} File {@link PDComplexFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); then PDActionEmbeddedGoTo() File PDComplexFileSpecification")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionEmbeddedGoTo.setFile(PDFileSpecification)"})
  void testSetFile_thenPDActionEmbeddedGoToFilePDComplexFileSpecification() throws IOException {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setFile(new PDComplexFileSpecification());

    // Assert
    PDFileSpecification file = pdActionEmbeddedGoTo.getFile();
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
   * Test {@link PDActionEmbeddedGoTo#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} File {@link PDSimpleFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); then PDActionEmbeddedGoTo() File PDSimpleFileSpecification")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionEmbeddedGoTo.setFile(PDFileSpecification)"})
  void testSetFile_thenPDActionEmbeddedGoToFilePDSimpleFileSpecification() throws IOException {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setFile(new PDSimpleFileSpecification());

    // Assert
    PDFileSpecification file = pdActionEmbeddedGoTo.getFile();
    assertTrue(file instanceof PDSimpleFileSpecification);
    assertEquals("", file.getFile());
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionEmbeddedGoTo#setFile(PDFileSpecification)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); when 'null'; then PDActionEmbeddedGoTo() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionEmbeddedGoTo.setFile(PDFileSpecification)"})
  void testSetFile_whenNull_thenPDActionEmbeddedGoToCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setFile(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionEmbeddedGoTo#getOpenInNewWindow()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   *   <li>Then return {@code USER_PREFERENCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#getOpenInNewWindow()}
   */
  @Test
  @DisplayName("Test getOpenInNewWindow(); given PDActionEmbeddedGoTo(); then return 'USER_PREFERENCE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OpenMode PDActionEmbeddedGoTo.getOpenInNewWindow()"})
  void testGetOpenInNewWindow_givenPDActionEmbeddedGoTo_thenReturnUserPreference() {
    // Arrange, Act and Assert
    assertEquals(OpenMode.USER_PREFERENCE, (new PDActionEmbeddedGoTo()).getOpenInNewWindow());
  }

  /**
   * Test {@link PDActionEmbeddedGoTo#setOpenInNewWindow(OpenMode)}.
   * <ul>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#setOpenInNewWindow(OpenMode)}
   */
  @Test
  @DisplayName("Test setOpenInNewWindow(OpenMode); then PDActionEmbeddedGoTo() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionEmbeddedGoTo.setOpenInNewWindow(OpenMode)"})
  void testSetOpenInNewWindow_thenPDActionEmbeddedGoToCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setOpenInNewWindow(OpenMode.USER_PREFERENCE);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, pdActionEmbeddedGoTo.getOpenInNewWindow());
  }

  /**
   * Test {@link PDActionEmbeddedGoTo#setOpenInNewWindow(OpenMode)}.
   * <ul>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} OpenInNewWindow is {@code NEW_WINDOW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#setOpenInNewWindow(OpenMode)}
   */
  @Test
  @DisplayName("Test setOpenInNewWindow(OpenMode); then PDActionEmbeddedGoTo() OpenInNewWindow is 'NEW_WINDOW'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionEmbeddedGoTo.setOpenInNewWindow(OpenMode)"})
  void testSetOpenInNewWindow_thenPDActionEmbeddedGoToOpenInNewWindowIsNewWindow() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setOpenInNewWindow(OpenMode.NEW_WINDOW);

    // Assert
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(OpenMode.NEW_WINDOW, pdActionEmbeddedGoTo.getOpenInNewWindow());
  }

  /**
   * Test {@link PDActionEmbeddedGoTo#setOpenInNewWindow(OpenMode)}.
   * <ul>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} OpenInNewWindow is {@code SAME_WINDOW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#setOpenInNewWindow(OpenMode)}
   */
  @Test
  @DisplayName("Test setOpenInNewWindow(OpenMode); then PDActionEmbeddedGoTo() OpenInNewWindow is 'SAME_WINDOW'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionEmbeddedGoTo.setOpenInNewWindow(OpenMode)"})
  void testSetOpenInNewWindow_thenPDActionEmbeddedGoToOpenInNewWindowIsSameWindow() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setOpenInNewWindow(OpenMode.SAME_WINDOW);

    // Assert
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(OpenMode.SAME_WINDOW, pdActionEmbeddedGoTo.getOpenInNewWindow());
  }

  /**
   * Test {@link PDActionEmbeddedGoTo#getTargetDirectory()}.
   * <ul>
   *   <li>Given {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#getTargetDirectory()}
   */
  @Test
  @DisplayName("Test getTargetDirectory(); given PDActionEmbeddedGoTo(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDTargetDirectory PDActionEmbeddedGoTo.getTargetDirectory()"})
  void testGetTargetDirectory_givenPDActionEmbeddedGoTo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionEmbeddedGoTo()).getTargetDirectory());
  }

  /**
   * Test {@link PDActionEmbeddedGoTo#setTargetDirectory(PDTargetDirectory)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#setTargetDirectory(PDTargetDirectory)}
   */
  @Test
  @DisplayName("Test setTargetDirectory(PDTargetDirectory); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionEmbeddedGoTo.setTargetDirectory(PDTargetDirectory)"})
  void testSetTargetDirectory_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdActionEmbeddedGoTo.setTargetDirectory(new PDTargetDirectory(dictionary));

    // Assert
    PDTargetDirectory targetDirectory = pdActionEmbeddedGoTo.getTargetDirectory();
    assertNull(targetDirectory.getAnnotationName());
    assertNull(targetDirectory.getFilename());
    assertNull(targetDirectory.getRelationship());
    assertNull(targetDirectory.getTargetDirectory());
    assertNull(targetDirectory.getNamedDestination());
    assertEquals(-1, targetDirectory.getAnnotationIndex());
    assertEquals(-1, targetDirectory.getPageNumber());
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(dictionary, targetDirectory.getCOSObject());
  }

  /**
   * Test {@link PDActionEmbeddedGoTo#setTargetDirectory(PDTargetDirectory)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#setTargetDirectory(PDTargetDirectory)}
   */
  @Test
  @DisplayName("Test setTargetDirectory(PDTargetDirectory); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionEmbeddedGoTo.setTargetDirectory(PDTargetDirectory)"})
  void testSetTargetDirectory_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setDirect(true);

    // Act
    pdActionEmbeddedGoTo.setTargetDirectory(new PDTargetDirectory(dictionary));

    // Assert
    PDTargetDirectory targetDirectory = pdActionEmbeddedGoTo.getTargetDirectory();
    assertNull(targetDirectory.getAnnotationName());
    assertNull(targetDirectory.getFilename());
    assertNull(targetDirectory.getRelationship());
    assertNull(targetDirectory.getTargetDirectory());
    assertNull(targetDirectory.getNamedDestination());
    assertEquals(-1, targetDirectory.getAnnotationIndex());
    assertEquals(-1, targetDirectory.getPageNumber());
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(dictionary, targetDirectory.getCOSObject());
  }

  /**
   * Test {@link PDActionEmbeddedGoTo#setTargetDirectory(PDTargetDirectory)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#setTargetDirectory(PDTargetDirectory)}
   */
  @Test
  @DisplayName("Test setTargetDirectory(PDTargetDirectory); when 'null'; then PDActionEmbeddedGoTo() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionEmbeddedGoTo.setTargetDirectory(PDTargetDirectory)"})
  void testSetTargetDirectory_whenNull_thenPDActionEmbeddedGoToCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setTargetDirectory(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionEmbeddedGoTo#setTargetDirectory(PDTargetDirectory)}.
   * <ul>
   *   <li>When {@link PDTargetDirectory#PDTargetDirectory()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionEmbeddedGoTo#setTargetDirectory(PDTargetDirectory)}
   */
  @Test
  @DisplayName("Test setTargetDirectory(PDTargetDirectory); when PDTargetDirectory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionEmbeddedGoTo.setTargetDirectory(PDTargetDirectory)"})
  void testSetTargetDirectory_whenPDTargetDirectory() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setTargetDirectory(new PDTargetDirectory());

    // Assert
    PDTargetDirectory targetDirectory = pdActionEmbeddedGoTo.getTargetDirectory();
    assertNull(targetDirectory.getAnnotationName());
    assertNull(targetDirectory.getFilename());
    assertNull(targetDirectory.getRelationship());
    assertNull(targetDirectory.getTargetDirectory());
    assertNull(targetDirectory.getNamedDestination());
    assertEquals(-1, targetDirectory.getAnnotationIndex());
    assertEquals(-1, targetDirectory.getPageNumber());
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }
}
