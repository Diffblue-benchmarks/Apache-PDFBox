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

class PDPageFitWidthDestinationDiffblueTest {
  /**
   * Method under test: {@link PDPageFitWidthDestination#getTop()}
   */
  @Test
  void testGetTop() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitWidthDestination()).getTop());
    assertEquals(-1, (new PDPageFitWidthDestination(new COSArray())).getTop());
  }

  /**
   * Method under test: {@link PDPageFitWidthDestination#getTop()}
   */
  @Test
  void testGetTop2() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination();
    pdPageFitWidthDestination.setTop(3);

    // Act and Assert
    assertEquals(3, pdPageFitWidthDestination.getTop());
  }

  /**
   * Method under test: {@link PDPageFitWidthDestination#getTop()}
   */
  @Test
  void testGetTop3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);

    // Act
    int actualTop = (new PDPageFitWidthDestination(arr)).getTop();

    // Assert
    verify(object).getCOSObject();
    assertEquals(-1, actualTop);
  }

  /**
   * Method under test: {@link PDPageFitWidthDestination#setTop(int)}
   */
  @Test
  void testSetTop() {
    // Arrange
    COSArray arr = new COSArray();
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination(arr);

    // Act
    pdPageFitWidthDestination.setTop(3);

    // Assert
    assertEquals(3, pdPageFitWidthDestination.getTop());
    assertSame(arr, pdPageFitWidthDestination.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageFitWidthDestination#setTop(int)}
   */
  @Test
  void testSetTop2() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination();

    // Act
    pdPageFitWidthDestination.setTop(-1);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitWidthDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    assertNull(toListResult.get(2));
    assertEquals(-1, pdPageFitWidthDestination.getTop());
  }

  /**
   * Method under test: {@link PDPageFitWidthDestination#setTop(int)}
   */
  @Test
  void testSetTop3() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination();

    // Act
    pdPageFitWidthDestination.setTop(Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitWidthDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(Integer.MIN_VALUE, pdPageFitWidthDestination.getTop());
  }

  /**
   * Method under test: {@link PDPageFitWidthDestination#setTop(int)}
   */
  @Test
  void testSetTop4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination(arr);

    // Act
    pdPageFitWidthDestination.setTop(3);

    // Assert
    verify(object).getCOSObject();
    assertEquals(3, pdPageFitWidthDestination.getTop());
    assertSame(arr, pdPageFitWidthDestination.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageFitWidthDestination#fitBoundingBox()}
   */
  @Test
  void testFitBoundingBox() {
    // Arrange, Act and Assert
    assertFalse((new PDPageFitWidthDestination()).fitBoundingBox());
    assertFalse((new PDPageFitWidthDestination(new COSArray())).fitBoundingBox());
  }

  /**
   * Method under test: {@link PDPageFitWidthDestination#fitBoundingBox()}
   */
  @Test
  void testFitBoundingBox2() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination();
    pdPageFitWidthDestination.setFitBoundingBox(true);

    // Act and Assert
    assertTrue(pdPageFitWidthDestination.fitBoundingBox());
  }

  /**
   * Method under test: {@link PDPageFitWidthDestination#fitBoundingBox()}
   */
  @Test
  void testFitBoundingBox3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);

    // Act
    boolean actualFitBoundingBoxResult = (new PDPageFitWidthDestination(arr)).fitBoundingBox();

    // Assert
    verify(object).getCOSObject();
    assertFalse(actualFitBoundingBoxResult);
  }

  /**
   * Method under test: {@link PDPageFitWidthDestination#fitBoundingBox()}
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
    boolean actualFitBoundingBoxResult = (new PDPageFitWidthDestination(arr)).fitBoundingBox();

    // Assert
    verify(object).getCOSObject();
    assertFalse(actualFitBoundingBoxResult);
  }

  /**
   * Method under test:
   * {@link PDPageFitWidthDestination#setFitBoundingBox(boolean)}
   */
  @Test
  void testSetFitBoundingBox() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination();

    // Act
    pdPageFitWidthDestination.setFitBoundingBox(true);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitWidthDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("FitBH", ((COSName) getResult).getName());
  }

  /**
   * Method under test:
   * {@link PDPageFitWidthDestination#setFitBoundingBox(boolean)}
   */
  @Test
  void testSetFitBoundingBox2() {
    // Arrange
    COSArray arr = new COSArray();
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination(arr);

    // Act
    pdPageFitWidthDestination.setFitBoundingBox(true);

    // Assert
    assertSame(arr, pdPageFitWidthDestination.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDPageFitWidthDestination#setFitBoundingBox(boolean)}
   */
  @Test
  void testSetFitBoundingBox3() {
    // Arrange
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination();

    // Act
    pdPageFitWidthDestination.setFitBoundingBox(false);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitWidthDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("FitH", ((COSName) getResult).getName());
  }

  /**
   * Method under test:
   * {@link PDPageFitWidthDestination#setFitBoundingBox(boolean)}
   */
  @Test
  void testSetFitBoundingBox4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);
    PDPageFitWidthDestination pdPageFitWidthDestination = new PDPageFitWidthDestination(arr);

    // Act
    pdPageFitWidthDestination.setFitBoundingBox(true);

    // Assert
    verify(object).getCOSObject();
    assertSame(arr, pdPageFitWidthDestination.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDPageFitWidthDestination#PDPageFitWidthDestination(COSArray)}
   */
  @Test
  void testNewPDPageFitWidthDestination() {
    // Arrange
    COSArray arr = new COSArray();

    // Act and Assert
    COSArray cOSObject = (new PDPageFitWidthDestination(arr)).getCOSObject();
    assertTrue(cOSObject.toList().isEmpty());
    assertSame(arr, cOSObject);
  }

  /**
   * Method under test:
   * {@link PDPageFitWidthDestination#PDPageFitWidthDestination()}
   */
  @Test
  void testNewPDPageFitWidthDestination2() {
    // Arrange and Act
    PDPageFitWidthDestination actualPdPageFitWidthDestination = new PDPageFitWidthDestination();

    // Assert
    List<? extends COSBase> toListResult = actualPdPageFitWidthDestination.getCOSObject().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("FitH", ((COSName) getResult).getName());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertNull(getResult.getKey());
    assertNull(actualPdPageFitWidthDestination.getPage());
    assertEquals(-1, actualPdPageFitWidthDestination.getPageNumber());
    assertEquals(-1, actualPdPageFitWidthDestination.getTop());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }
}
