package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDNamedDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitDestination;
import org.junit.jupiter.api.Test;

class PDActionEmbeddedGoToDiffblueTest {
  /**
   * Method under test: {@link PDActionEmbeddedGoTo#setDestination(PDDestination)}
   */
  @Test
  void testSetDestination() throws IOException {
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
   * Method under test: {@link PDActionEmbeddedGoTo#setDestination(PDDestination)}
   */
  @Test
  void testSetDestination2() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdActionEmbeddedGoTo.setDestination(new PDPageFitDestination()));
  }

  /**
   * Method under test: {@link PDActionEmbeddedGoTo#setDestination(PDDestination)}
   */
  @Test
  void testSetDestination3() {
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
   * Method under test: {@link PDActionEmbeddedGoTo#setDestination(PDDestination)}
   */
  @Test
  void testSetDestination4() throws IOException {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setDestination(null);

    // Assert
    assertNull(pdActionEmbeddedGoTo.getDestination());
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionEmbeddedGoTo#getFile()}
   */
  @Test
  void testGetFile() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDActionEmbeddedGoTo()).getFile());
  }

  /**
   * Method under test: {@link PDActionEmbeddedGoTo#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile() throws IOException {
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
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
  }

  /**
   * Method under test: {@link PDActionEmbeddedGoTo#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile2() throws IOException {
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
   * Method under test: {@link PDActionEmbeddedGoTo#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile3() throws IOException {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setFile(null);

    // Assert
    assertNull(pdActionEmbeddedGoTo.getFile());
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionEmbeddedGoTo#getOpenInNewWindow()}
   */
  @Test
  void testGetOpenInNewWindow() {
    // Arrange, Act and Assert
    assertEquals(OpenMode.USER_PREFERENCE, (new PDActionEmbeddedGoTo()).getOpenInNewWindow());
  }

  /**
   * Method under test: {@link PDActionEmbeddedGoTo#setOpenInNewWindow(OpenMode)}
   */
  @Test
  void testSetOpenInNewWindow() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setOpenInNewWindow(OpenMode.USER_PREFERENCE);

    // Assert
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, pdActionEmbeddedGoTo.getOpenInNewWindow());
  }

  /**
   * Method under test: {@link PDActionEmbeddedGoTo#setOpenInNewWindow(OpenMode)}
   */
  @Test
  void testSetOpenInNewWindow2() {
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
   * Method under test: {@link PDActionEmbeddedGoTo#setOpenInNewWindow(OpenMode)}
   */
  @Test
  void testSetOpenInNewWindow3() {
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
   * Method under test: {@link PDActionEmbeddedGoTo#getTargetDirectory()}
   */
  @Test
  void testGetTargetDirectory() {
    // Arrange, Act and Assert
    assertNull((new PDActionEmbeddedGoTo()).getTargetDirectory());
  }

  /**
   * Method under test:
   * {@link PDActionEmbeddedGoTo#setTargetDirectory(PDTargetDirectory)}
   */
  @Test
  void testSetTargetDirectory() {
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

  /**
   * Method under test:
   * {@link PDActionEmbeddedGoTo#setTargetDirectory(PDTargetDirectory)}
   */
  @Test
  void testSetTargetDirectory2() {
    // Arrange
    PDActionEmbeddedGoTo pdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Act
    pdActionEmbeddedGoTo.setTargetDirectory(null);

    // Assert
    assertNull(pdActionEmbeddedGoTo.getTargetDirectory());
    COSDictionary cOSObject = pdActionEmbeddedGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDActionEmbeddedGoTo#setTargetDirectory(PDTargetDirectory)}
   */
  @Test
  void testSetTargetDirectory3() {
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
   * Method under test:
   * {@link PDActionEmbeddedGoTo#setTargetDirectory(PDTargetDirectory)}
   */
  @Test
  void testSetTargetDirectory4() {
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
   * Method under test:
   * {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)}
   */
  @Test
  void testNewPDActionEmbeddedGoTo() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionEmbeddedGoTo(a)).getCOSObject());
  }

  /**
   * Method under test: {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo()}
   */
  @Test
  void testNewPDActionEmbeddedGoTo2() throws IOException {
    // Arrange and Act
    PDActionEmbeddedGoTo actualPdActionEmbeddedGoTo = new PDActionEmbeddedGoTo();

    // Assert
    assertNull(actualPdActionEmbeddedGoTo.getNext());
    COSDictionary cOSObject = actualPdActionEmbeddedGoTo.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdActionEmbeddedGoTo.getFile());
    assertNull(actualPdActionEmbeddedGoTo.getTargetDirectory());
    assertNull(actualPdActionEmbeddedGoTo.getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, actualPdActionEmbeddedGoTo.getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPdActionEmbeddedGoTo.getType());
    assertEquals(PDActionEmbeddedGoTo.SUB_TYPE, actualPdActionEmbeddedGoTo.getSubType());
  }
}
