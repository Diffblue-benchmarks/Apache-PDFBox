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

class PDPageFitRectangleDestinationDiffblueTest {
  /**
   * Method under test: {@link PDPageFitRectangleDestination#getLeft()}
   */
  @Test
  void testGetLeft() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitRectangleDestination()).getLeft());
    assertEquals(-1, (new PDPageFitRectangleDestination(new COSArray())).getLeft());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#getLeft()}
   */
  @Test
  void testGetLeft2() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();
    pdPageFitRectangleDestination.setLeft(2);

    // Act and Assert
    assertEquals(2, pdPageFitRectangleDestination.getLeft());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#getLeft()}
   */
  @Test
  void testGetLeft3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);

    // Act
    int actualLeft = (new PDPageFitRectangleDestination(arr)).getLeft();

    // Assert
    verify(object).getCOSObject();
    assertEquals(-1, actualLeft);
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#setLeft(int)}
   */
  @Test
  void testSetLeft() {
    // Arrange
    COSArray arr = new COSArray();
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination(arr);

    // Act
    pdPageFitRectangleDestination.setLeft(2);

    // Assert
    assertEquals(2, pdPageFitRectangleDestination.getLeft());
    assertSame(arr, pdPageFitRectangleDestination.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#setLeft(int)}
   */
  @Test
  void testSetLeft2() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setLeft(-1);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    assertNull(toListResult.get(2));
    assertEquals(-1, pdPageFitRectangleDestination.getLeft());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#setLeft(int)}
   */
  @Test
  void testSetLeft3() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setLeft(Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(Integer.MIN_VALUE, pdPageFitRectangleDestination.getLeft());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#setLeft(int)}
   */
  @Test
  void testSetLeft4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination(arr);

    // Act
    pdPageFitRectangleDestination.setLeft(2);

    // Assert
    verify(object).getCOSObject();
    assertEquals(2, pdPageFitRectangleDestination.getLeft());
    assertSame(arr, pdPageFitRectangleDestination.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#getBottom()}
   */
  @Test
  void testGetBottom() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitRectangleDestination()).getBottom());
    assertEquals(-1, (new PDPageFitRectangleDestination(new COSArray())).getBottom());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#getBottom()}
   */
  @Test
  void testGetBottom2() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();
    pdPageFitRectangleDestination.setBottom(3);

    // Act and Assert
    assertEquals(3, pdPageFitRectangleDestination.getBottom());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#getBottom()}
   */
  @Test
  void testGetBottom3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);

    // Act
    int actualBottom = (new PDPageFitRectangleDestination(arr)).getBottom();

    // Assert
    verify(object).getCOSObject();
    assertEquals(-1, actualBottom);
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#setBottom(int)}
   */
  @Test
  void testSetBottom() {
    // Arrange
    COSArray arr = new COSArray();
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination(arr);

    // Act
    pdPageFitRectangleDestination.setBottom(3);

    // Assert
    assertEquals(3, pdPageFitRectangleDestination.getBottom());
    assertSame(arr, pdPageFitRectangleDestination.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#setBottom(int)}
   */
  @Test
  void testSetBottom2() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setBottom(-1);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    assertNull(toListResult.get(3));
    assertEquals(-1, pdPageFitRectangleDestination.getBottom());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#setBottom(int)}
   */
  @Test
  void testSetBottom3() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setBottom(Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(Integer.MIN_VALUE, pdPageFitRectangleDestination.getBottom());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#setBottom(int)}
   */
  @Test
  void testSetBottom4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination(arr);

    // Act
    pdPageFitRectangleDestination.setBottom(3);

    // Assert
    verify(object).getCOSObject();
    assertEquals(3, pdPageFitRectangleDestination.getBottom());
    assertSame(arr, pdPageFitRectangleDestination.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#getRight()}
   */
  @Test
  void testGetRight() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitRectangleDestination()).getRight());
    assertEquals(-1, (new PDPageFitRectangleDestination(new COSArray())).getRight());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#getRight()}
   */
  @Test
  void testGetRight2() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();
    pdPageFitRectangleDestination.setRight(2);

    // Act and Assert
    assertEquals(2, pdPageFitRectangleDestination.getRight());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#getRight()}
   */
  @Test
  void testGetRight3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);

    // Act
    int actualRight = (new PDPageFitRectangleDestination(arr)).getRight();

    // Assert
    verify(object).getCOSObject();
    assertEquals(-1, actualRight);
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#setRight(int)}
   */
  @Test
  void testSetRight() {
    // Arrange
    COSArray arr = new COSArray();
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination(arr);

    // Act
    pdPageFitRectangleDestination.setRight(2);

    // Assert
    assertEquals(2, pdPageFitRectangleDestination.getRight());
    assertSame(arr, pdPageFitRectangleDestination.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#setRight(int)}
   */
  @Test
  void testSetRight2() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setRight(-1);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    assertNull(toListResult.get(4));
    assertEquals(-1, pdPageFitRectangleDestination.getRight());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#setRight(int)}
   */
  @Test
  void testSetRight3() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setRight(Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    COSBase getResult = toListResult.get(4);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(Integer.MIN_VALUE, pdPageFitRectangleDestination.getRight());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#setRight(int)}
   */
  @Test
  void testSetRight4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination(arr);

    // Act
    pdPageFitRectangleDestination.setRight(2);

    // Assert
    verify(object).getCOSObject();
    assertEquals(2, pdPageFitRectangleDestination.getRight());
    assertSame(arr, pdPageFitRectangleDestination.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#getTop()}
   */
  @Test
  void testGetTop() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageFitRectangleDestination()).getTop());
    assertEquals(-1, (new PDPageFitRectangleDestination(new COSArray())).getTop());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#getTop()}
   */
  @Test
  void testGetTop2() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();
    pdPageFitRectangleDestination.setTop(3);

    // Act and Assert
    assertEquals(3, pdPageFitRectangleDestination.getTop());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#getTop()}
   */
  @Test
  void testGetTop3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);

    // Act
    int actualTop = (new PDPageFitRectangleDestination(arr)).getTop();

    // Assert
    verify(object).getCOSObject();
    assertEquals(-1, actualTop);
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#setTop(int)}
   */
  @Test
  void testSetTop() {
    // Arrange
    COSArray arr = new COSArray();
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination(arr);

    // Act
    pdPageFitRectangleDestination.setTop(3);

    // Assert
    assertEquals(3, pdPageFitRectangleDestination.getTop());
    assertSame(arr, pdPageFitRectangleDestination.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#setTop(int)}
   */
  @Test
  void testSetTop2() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setTop(-1);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    assertNull(toListResult.get(5));
    assertEquals(-1, pdPageFitRectangleDestination.getTop());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#setTop(int)}
   */
  @Test
  void testSetTop3() {
    // Arrange
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Act
    pdPageFitRectangleDestination.setTop(Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    COSBase getResult = toListResult.get(5);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(Integer.MIN_VALUE, pdPageFitRectangleDestination.getTop());
  }

  /**
   * Method under test: {@link PDPageFitRectangleDestination#setTop(int)}
   */
  @Test
  void testSetTop4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);
    PDPageFitRectangleDestination pdPageFitRectangleDestination = new PDPageFitRectangleDestination(arr);

    // Act
    pdPageFitRectangleDestination.setTop(3);

    // Assert
    verify(object).getCOSObject();
    assertEquals(3, pdPageFitRectangleDestination.getTop());
    assertSame(arr, pdPageFitRectangleDestination.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination(COSArray)}
   */
  @Test
  void testNewPDPageFitRectangleDestination() {
    // Arrange
    COSArray arr = new COSArray();

    // Act and Assert
    COSArray cOSObject = (new PDPageFitRectangleDestination(arr)).getCOSObject();
    assertTrue(cOSObject.toList().isEmpty());
    assertSame(arr, cOSObject);
  }

  /**
   * Method under test:
   * {@link PDPageFitRectangleDestination#PDPageFitRectangleDestination()}
   */
  @Test
  void testNewPDPageFitRectangleDestination2() {
    // Arrange and Act
    PDPageFitRectangleDestination actualPdPageFitRectangleDestination = new PDPageFitRectangleDestination();

    // Assert
    List<? extends COSBase> toListResult = actualPdPageFitRectangleDestination.getCOSObject().toList();
    assertEquals(6, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("FitR", ((COSName) getResult).getName());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertNull(toListResult.get(3));
    assertNull(toListResult.get(4));
    assertNull(toListResult.get(5));
    assertNull(getResult.getKey());
    assertNull(actualPdPageFitRectangleDestination.getPage());
    assertEquals(-1, actualPdPageFitRectangleDestination.getPageNumber());
    assertEquals(-1, actualPdPageFitRectangleDestination.getBottom());
    assertEquals(-1, actualPdPageFitRectangleDestination.getLeft());
    assertEquals(-1, actualPdPageFitRectangleDestination.getRight());
    assertEquals(-1, actualPdPageFitRectangleDestination.getTop());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }
}
