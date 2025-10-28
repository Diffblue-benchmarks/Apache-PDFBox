package org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class PDPageFitHeightDestinationDiffblueTest {
  /**
   * Method under test: {@link PDPageFitHeightDestination#getLeft()}
   */
  @Test
  void testGetLeft() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitHeightDestination()).getLeft());
    assertEquals(-1, (new PDPageFitHeightDestination(new COSArray())).getLeft());
  }

  /**
   * Method under test: {@link PDPageFitHeightDestination#getLeft()}
   */
  @Test
  void testGetLeft2() {
    // Arrange
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination();
    pdPageFitHeightDestination.setLeft(2);

    // Act and Assert
    assertEquals(2, pdPageFitHeightDestination.getLeft());
  }

  /**
   * Method under test: {@link PDPageFitHeightDestination#getLeft()}
   */
  @Test
  void testGetLeft3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);

    // Act
    int actualLeft = (new PDPageFitHeightDestination(arr)).getLeft();

    // Assert
    verify(object).getCOSObject();
    assertEquals(-1, actualLeft);
  }

  /**
   * Method under test: {@link PDPageFitHeightDestination#setLeft(int)}
   */
  @Test
  void testSetLeft() {
    // Arrange
    COSArray arr = new COSArray();
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination(arr);

    // Act
    pdPageFitHeightDestination.setLeft(2);

    // Assert
    assertEquals(2, pdPageFitHeightDestination.getLeft());
    assertSame(arr, pdPageFitHeightDestination.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageFitHeightDestination#setLeft(int)}
   */
  @Test
  void testSetLeft2() {
    // Arrange
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination();

    // Act
    pdPageFitHeightDestination.setLeft(-1);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitHeightDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    assertNull(toListResult.get(2));
    assertEquals(-1, pdPageFitHeightDestination.getLeft());
  }

  /**
   * Method under test: {@link PDPageFitHeightDestination#setLeft(int)}
   */
  @Test
  void testSetLeft3() {
    // Arrange
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination();

    // Act
    pdPageFitHeightDestination.setLeft(-100);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitHeightDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertEquals(-100, pdPageFitHeightDestination.getLeft());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Method under test: {@link PDPageFitHeightDestination#setLeft(int)}
   */
  @Test
  void testSetLeft4() {
    // Arrange
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination();

    // Act
    pdPageFitHeightDestination.setLeft(Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitHeightDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(Integer.MIN_VALUE, pdPageFitHeightDestination.getLeft());
  }

  /**
   * Method under test: {@link PDPageFitHeightDestination#setLeft(int)}
   */
  @Test
  void testSetLeft5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination(arr);

    // Act
    pdPageFitHeightDestination.setLeft(2);

    // Assert
    verify(object).getCOSObject();
    assertEquals(2, pdPageFitHeightDestination.getLeft());
    assertSame(arr, pdPageFitHeightDestination.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageFitHeightDestination#fitBoundingBox()}
   */
  @Test
  void testFitBoundingBox() {
    // Arrange, Act and Assert
    assertFalse((new PDPageFitHeightDestination()).fitBoundingBox());
    assertFalse((new PDPageFitHeightDestination(new COSArray())).fitBoundingBox());
  }

  /**
   * Method under test: {@link PDPageFitHeightDestination#fitBoundingBox()}
   */
  @Test
  void testFitBoundingBox2() {
    // Arrange
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination();
    pdPageFitHeightDestination.setFitBoundingBox(true);

    // Act and Assert
    assertTrue(pdPageFitHeightDestination.fitBoundingBox());
  }

  /**
   * Method under test: {@link PDPageFitHeightDestination#fitBoundingBox()}
   */
  @Test
  void testFitBoundingBox3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);

    // Act
    boolean actualFitBoundingBoxResult = (new PDPageFitHeightDestination(arr)).fitBoundingBox();

    // Assert
    verify(object).getCOSObject();
    assertFalse(actualFitBoundingBoxResult);
  }

  /**
   * Method under test: {@link PDPageFitHeightDestination#fitBoundingBox()}
   */
  @Test
  void testFitBoundingBox4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(COSBoolean.FALSE);
    arr.add(object);

    // Act
    boolean actualFitBoundingBoxResult = (new PDPageFitHeightDestination(arr)).fitBoundingBox();

    // Assert
    verify(object).getCOSObject();
    assertFalse(actualFitBoundingBoxResult);
  }

  /**
   * Method under test:
   * {@link PDPageFitHeightDestination#setFitBoundingBox(boolean)}
   */
  @Test
  void testSetFitBoundingBox() {
    // Arrange
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination();

    // Act
    pdPageFitHeightDestination.setFitBoundingBox(true);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitHeightDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("FitBV", ((COSName) getResult).getName());
  }

  /**
   * Method under test:
   * {@link PDPageFitHeightDestination#setFitBoundingBox(boolean)}
   */
  @Test
  void testSetFitBoundingBox2() {
    // Arrange
    COSArray arr = new COSArray();
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination(arr);

    // Act
    pdPageFitHeightDestination.setFitBoundingBox(true);

    // Assert
    assertSame(arr, pdPageFitHeightDestination.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDPageFitHeightDestination#setFitBoundingBox(boolean)}
   */
  @Test
  void testSetFitBoundingBox3() {
    // Arrange
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination();

    // Act
    pdPageFitHeightDestination.setFitBoundingBox(false);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitHeightDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("FitV", ((COSName) getResult).getName());
  }

  /**
   * Method under test:
   * {@link PDPageFitHeightDestination#setFitBoundingBox(boolean)}
   */
  @Test
  void testSetFitBoundingBox4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);
    PDPageFitHeightDestination pdPageFitHeightDestination = new PDPageFitHeightDestination(arr);

    // Act
    pdPageFitHeightDestination.setFitBoundingBox(true);

    // Assert
    verify(object).getCOSObject();
    assertSame(arr, pdPageFitHeightDestination.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDPageFitHeightDestination#PDPageFitHeightDestination(COSArray)}
   */
  @Test
  void testNewPDPageFitHeightDestination() {
    // Arrange
    COSArray arr = new COSArray();

    // Act and Assert
    COSArray cOSObject = (new PDPageFitHeightDestination(arr)).getCOSObject();
    assertTrue(cOSObject.toList().isEmpty());
    assertSame(arr, cOSObject);
  }

  /**
   * Method under test:
   * {@link PDPageFitHeightDestination#PDPageFitHeightDestination()}
   */
  @Test
  void testNewPDPageFitHeightDestination2() {
    // Arrange and Act
    PDPageFitHeightDestination actualPdPageFitHeightDestination = new PDPageFitHeightDestination();

    // Assert
    List<? extends COSBase> toListResult = actualPdPageFitHeightDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("FitV", ((COSName) getResult).getName());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertNull(getResult.getKey());
    assertNull(actualPdPageFitHeightDestination.getPage());
    assertEquals(-1, actualPdPageFitHeightDestination.getPageNumber());
    assertEquals(-1, actualPdPageFitHeightDestination.getLeft());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }
}
