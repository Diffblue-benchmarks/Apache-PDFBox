package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.UnsupportedEncodingException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDNamedDestination;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDTargetDirectoryDiffblueTest {
  /**
   * Method under test: {@link PDTargetDirectory#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDTargetDirectory()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDTargetDirectory#getRelationship()}
   */
  @Test
  void testGetRelationship() {
    // Arrange, Act and Assert
    assertNull((new PDTargetDirectory()).getRelationship());
  }

  /**
   * Method under test: {@link PDTargetDirectory#setRelationship(COSName)}
   */
  @Test
  void testSetRelationship() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDTargetDirectory()).setRelationship(COSName.A));
  }

  /**
   * Method under test: {@link PDTargetDirectory#getFilename()}
   */
  @Test
  void testGetFilename() {
    // Arrange, Act and Assert
    assertNull((new PDTargetDirectory()).getFilename());
  }

  /**
   * Method under test: {@link PDTargetDirectory#getFilename()}
   */
  @Test
  void testGetFilename2() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setFilename("foo.txt");

    // Act and Assert
    assertEquals("foo.txt", pdTargetDirectory.getFilename());
  }

  /**
   * Method under test: {@link PDTargetDirectory#getFilename()}
   */
  @Test
  void testGetFilename3() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setFilename("");

    // Act and Assert
    assertEquals("", pdTargetDirectory.getFilename());
  }

  /**
   * Method under test: {@link PDTargetDirectory#setFilename(String)}
   */
  @Test
  void testSetFilename() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setFilename("foo.txt");

    // Assert
    assertEquals("foo.txt", pdTargetDirectory.getFilename());
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTargetDirectory#getTargetDirectory()}
   */
  @Test
  void testGetTargetDirectory() {
    // Arrange, Act and Assert
    assertNull((new PDTargetDirectory()).getTargetDirectory());
  }

  /**
   * Method under test: {@link PDTargetDirectory#getTargetDirectory()}
   */
  @Test
  void testGetTargetDirectory2() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setTargetDirectory(new PDTargetDirectory());

    // Act
    PDTargetDirectory actualTargetDirectory = pdTargetDirectory.getTargetDirectory();

    // Assert
    assertNull(actualTargetDirectory.getAnnotationName());
    assertNull(actualTargetDirectory.getFilename());
    COSDictionary cOSObject = actualTargetDirectory.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualTargetDirectory.getRelationship());
    assertNull(cOSObject.getKey());
    assertNull(actualTargetDirectory.getNamedDestination());
    assertEquals(-1, actualTargetDirectory.getAnnotationIndex());
    assertEquals(-1, actualTargetDirectory.getPageNumber());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDTargetDirectory#getTargetDirectory()}
   */
  @Test
  void testGetTargetDirectory3() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));
    PDTargetDirectory targetDirectory = new PDTargetDirectory(dictionary);

    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setTargetDirectory(targetDirectory);

    // Act
    PDTargetDirectory actualTargetDirectory = pdTargetDirectory.getTargetDirectory();

    // Assert
    assertNull(actualTargetDirectory.getAnnotationName());
    assertNull(actualTargetDirectory.getFilename());
    assertNull(actualTargetDirectory.getRelationship());
    assertNull(actualTargetDirectory.getNamedDestination());
    assertEquals(-1, actualTargetDirectory.getAnnotationIndex());
    assertEquals(-1, actualTargetDirectory.getPageNumber());
    assertSame(dictionary, actualTargetDirectory.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDTargetDirectory#setTargetDirectory(PDTargetDirectory)}
   */
  @Test
  void testSetTargetDirectory() {
    // Arrange
    COSDictionary dictionary = mock(COSDictionary.class);
    doNothing().when(dictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory(dictionary);

    // Act
    pdTargetDirectory.setTargetDirectory(new PDTargetDirectory());

    // Assert that nothing has changed
    verify(dictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Method under test: {@link PDTargetDirectory#getPageNumber()}
   */
  @Test
  void testGetPageNumber() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDTargetDirectory()).getPageNumber());
  }

  /**
   * Method under test: {@link PDTargetDirectory#getPageNumber()}
   */
  @Test
  void testGetPageNumber2() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setPageNumber(10);

    // Act and Assert
    assertEquals(10, pdTargetDirectory.getPageNumber());
  }

  /**
   * Method under test: {@link PDTargetDirectory#setPageNumber(int)}
   */
  @Test
  void testSetPageNumber() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setPageNumber(10);

    // Assert
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(10, pdTargetDirectory.getPageNumber());
  }

  /**
   * Method under test: {@link PDTargetDirectory#setPageNumber(int)}
   */
  @Test
  void testSetPageNumber2() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setPageNumber(-100);

    // Assert
    assertEquals(-1, pdTargetDirectory.getPageNumber());
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link PDTargetDirectory#getNamedDestination()}
   */
  @Test
  void testGetNamedDestination() {
    // Arrange, Act and Assert
    assertNull((new PDTargetDirectory()).getNamedDestination());
  }

  /**
   * Method under test: {@link PDTargetDirectory#getNamedDestination()}
   */
  @Test
  void testGetNamedDestination2() throws UnsupportedEncodingException {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setNamedDestination(new PDNamedDestination("Dest"));

    // Act
    PDNamedDestination actualNamedDestination = pdTargetDirectory.getNamedDestination();

    // Assert
    COSBase cOSObject = actualNamedDestination.getCOSObject();
    assertTrue(cOSObject instanceof COSString);
    assertEquals("44657374", ((COSString) cOSObject).toHexString());
    assertEquals("Dest", ((COSString) cOSObject).getASCII());
    assertEquals("Dest", ((COSString) cOSObject).getString());
    assertEquals("Dest", actualNamedDestination.getNamedDestination());
    assertNull(cOSObject.getKey());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
    byte[] expectedBytes = "Dest".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((COSString) cOSObject).getBytes());
  }

  /**
   * Method under test:
   * {@link PDTargetDirectory#setNamedDestination(PDNamedDestination)}
   */
  @Test
  void testSetNamedDestination() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setNamedDestination(new PDNamedDestination("Dest"));

    // Assert
    assertEquals("Dest", pdTargetDirectory.getNamedDestination().getNamedDestination());
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDTargetDirectory#setNamedDestination(PDNamedDestination)}
   */
  @Test
  void testSetNamedDestination2() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setNamedDestination(new PDNamedDestination());

    // Assert
    assertNull(pdTargetDirectory.getNamedDestination());
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDTargetDirectory#setNamedDestination(PDNamedDestination)}
   */
  @Test
  void testSetNamedDestination3() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setNamedDestination(null);

    // Assert
    assertNull(pdTargetDirectory.getNamedDestination());
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link PDTargetDirectory#getAnnotationIndex()}
   */
  @Test
  void testGetAnnotationIndex() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDTargetDirectory()).getAnnotationIndex());
  }

  /**
   * Method under test: {@link PDTargetDirectory#getAnnotationIndex()}
   */
  @Test
  void testGetAnnotationIndex2() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setAnnotationIndex(1);

    // Act and Assert
    assertEquals(1, pdTargetDirectory.getAnnotationIndex());
  }

  /**
   * Method under test: {@link PDTargetDirectory#setAnnotationIndex(int)}
   */
  @Test
  void testSetAnnotationIndex() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setAnnotationIndex(1);

    // Assert
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdTargetDirectory.getAnnotationIndex());
  }

  /**
   * Method under test: {@link PDTargetDirectory#setAnnotationIndex(int)}
   */
  @Test
  void testSetAnnotationIndex2() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setAnnotationIndex(-100);

    // Assert
    assertEquals(-1, pdTargetDirectory.getAnnotationIndex());
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link PDTargetDirectory#getAnnotationName()}
   */
  @Test
  void testGetAnnotationName() {
    // Arrange, Act and Assert
    assertNull((new PDTargetDirectory()).getAnnotationName());
  }

  /**
   * Method under test: {@link PDTargetDirectory#getAnnotationName()}
   */
  @Test
  void testGetAnnotationName2() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setAnnotationName("Name");

    // Act and Assert
    assertEquals("Name", pdTargetDirectory.getAnnotationName());
  }

  /**
   * Method under test: {@link PDTargetDirectory#getAnnotationName()}
   */
  @Test
  void testGetAnnotationName3() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();
    pdTargetDirectory.setAnnotationName("");

    // Act and Assert
    assertEquals("", pdTargetDirectory.getAnnotationName());
  }

  /**
   * Method under test: {@link PDTargetDirectory#setAnnotationName(String)}
   */
  @Test
  void testSetAnnotationName() {
    // Arrange
    PDTargetDirectory pdTargetDirectory = new PDTargetDirectory();

    // Act
    pdTargetDirectory.setAnnotationName("Name");

    // Assert
    assertEquals("Name", pdTargetDirectory.getAnnotationName());
    COSDictionary cOSObject = pdTargetDirectory.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTargetDirectory#PDTargetDirectory(COSDictionary)}
   */
  @Test
  void testNewPDTargetDirectory() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDTargetDirectory(dictionary)).getCOSObject());
  }

  /**
   * Method under test: {@link PDTargetDirectory#PDTargetDirectory()}
   */
  @Test
  void testNewPDTargetDirectory2() {
    // Arrange and Act
    PDTargetDirectory actualPdTargetDirectory = new PDTargetDirectory();

    // Assert
    assertNull(actualPdTargetDirectory.getAnnotationName());
    assertNull(actualPdTargetDirectory.getFilename());
    COSDictionary cOSObject = actualPdTargetDirectory.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualPdTargetDirectory.getRelationship());
    assertNull(cOSObject.getKey());
    assertNull(actualPdTargetDirectory.getTargetDirectory());
    assertNull(actualPdTargetDirectory.getNamedDestination());
    assertEquals(-1, actualPdTargetDirectory.getAnnotationIndex());
    assertEquals(-1, actualPdTargetDirectory.getPageNumber());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
