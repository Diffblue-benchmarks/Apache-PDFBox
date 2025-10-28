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
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class PDPageXYZDestinationDiffblueTest {
  /**
   * Method under test: {@link PDPageXYZDestination#getLeft()}
   */
  @Test
  void testGetLeft() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageXYZDestination()).getLeft());
    assertEquals(-1, (new PDPageXYZDestination(new COSArray())).getLeft());
  }

  /**
   * Method under test: {@link PDPageXYZDestination#getLeft()}
   */
  @Test
  void testGetLeft2() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();
    pdPageXYZDestination.setLeft(2);

    // Act and Assert
    assertEquals(2, pdPageXYZDestination.getLeft());
  }

  /**
   * Method under test: {@link PDPageXYZDestination#getLeft()}
   */
  @Test
  void testGetLeft3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);

    // Act
    int actualLeft = (new PDPageXYZDestination(arr)).getLeft();

    // Assert
    verify(object).getCOSObject();
    assertEquals(-1, actualLeft);
  }

  /**
   * Method under test: {@link PDPageXYZDestination#setLeft(int)}
   */
  @Test
  void testSetLeft() {
    // Arrange
    COSArray arr = new COSArray();
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination(arr);

    // Act
    pdPageXYZDestination.setLeft(2);

    // Assert
    assertEquals(-1.0f, pdPageXYZDestination.getZoom());
    assertEquals(2, pdPageXYZDestination.getLeft());
    assertSame(arr, pdPageXYZDestination.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageXYZDestination#setLeft(int)}
   */
  @Test
  void testSetLeft2() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();

    // Act
    pdPageXYZDestination.setLeft(-1);

    // Assert
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    assertNull(toListResult.get(2));
    assertEquals(-1, pdPageXYZDestination.getLeft());
  }

  /**
   * Method under test: {@link PDPageXYZDestination#setLeft(int)}
   */
  @Test
  void testSetLeft3() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();

    // Act
    pdPageXYZDestination.setLeft(Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(Integer.MIN_VALUE, pdPageXYZDestination.getLeft());
  }

  /**
   * Method under test: {@link PDPageXYZDestination#setLeft(int)}
   */
  @Test
  void testSetLeft4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination(arr);

    // Act
    pdPageXYZDestination.setLeft(2);

    // Assert
    verify(object).getCOSObject();
    assertEquals(-1.0f, pdPageXYZDestination.getZoom());
    assertEquals(2, pdPageXYZDestination.getLeft());
    assertSame(arr, pdPageXYZDestination.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageXYZDestination#getTop()}
   */
  @Test
  void testGetTop() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDPageXYZDestination()).getTop());
    assertEquals(-1, (new PDPageXYZDestination(new COSArray())).getTop());
  }

  /**
   * Method under test: {@link PDPageXYZDestination#getTop()}
   */
  @Test
  void testGetTop2() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();
    pdPageXYZDestination.setTop(3);

    // Act and Assert
    assertEquals(3, pdPageXYZDestination.getTop());
  }

  /**
   * Method under test: {@link PDPageXYZDestination#getTop()}
   */
  @Test
  void testGetTop3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);

    // Act
    int actualTop = (new PDPageXYZDestination(arr)).getTop();

    // Assert
    verify(object).getCOSObject();
    assertEquals(-1, actualTop);
  }

  /**
   * Method under test: {@link PDPageXYZDestination#setTop(int)}
   */
  @Test
  void testSetTop() {
    // Arrange
    COSArray arr = new COSArray();
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination(arr);

    // Act
    pdPageXYZDestination.setTop(3);

    // Assert
    assertEquals(-1.0f, pdPageXYZDestination.getZoom());
    assertEquals(3, pdPageXYZDestination.getTop());
    assertSame(arr, pdPageXYZDestination.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageXYZDestination#setTop(int)}
   */
  @Test
  void testSetTop2() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();

    // Act
    pdPageXYZDestination.setTop(-1);

    // Assert
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    assertNull(toListResult.get(3));
    assertEquals(-1, pdPageXYZDestination.getTop());
  }

  /**
   * Method under test: {@link PDPageXYZDestination#setTop(int)}
   */
  @Test
  void testSetTop3() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();

    // Act
    pdPageXYZDestination.setTop(Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(Integer.MIN_VALUE, pdPageXYZDestination.getTop());
  }

  /**
   * Method under test: {@link PDPageXYZDestination#setTop(int)}
   */
  @Test
  void testSetTop4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination(arr);

    // Act
    pdPageXYZDestination.setTop(3);

    // Assert
    verify(object).getCOSObject();
    assertEquals(-1.0f, pdPageXYZDestination.getZoom());
    assertEquals(3, pdPageXYZDestination.getTop());
    assertSame(arr, pdPageXYZDestination.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageXYZDestination#getZoom()}
   */
  @Test
  void testGetZoom() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new PDPageXYZDestination()).getZoom());
  }

  /**
   * Method under test: {@link PDPageXYZDestination#getZoom()}
   */
  @Test
  void testGetZoom2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);

    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination(arr);
    pdPageXYZDestination.setZoom(10.0f);

    // Act
    float actualZoom = pdPageXYZDestination.getZoom();

    // Assert
    verify(object).getCOSObject();
    assertEquals(10.0f, actualZoom);
  }

  /**
   * Method under test: {@link PDPageXYZDestination#setZoom(float)}
   */
  @Test
  void testSetZoom() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();

    // Act
    pdPageXYZDestination.setZoom(10.0f);

    // Assert
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(4);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(10.0f, pdPageXYZDestination.getZoom());
    assertFalse(getResult.isDirect());
  }

  /**
   * Method under test: {@link PDPageXYZDestination#setZoom(float)}
   */
  @Test
  void testSetZoom2() {
    // Arrange
    COSArray arr = new COSArray();
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination(arr);

    // Act
    pdPageXYZDestination.setZoom(10.0f);

    // Assert
    assertEquals(10.0f, pdPageXYZDestination.getZoom());
    assertSame(arr, pdPageXYZDestination.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageXYZDestination#setZoom(float)}
   */
  @Test
  void testSetZoom3() {
    // Arrange
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination();

    // Act
    pdPageXYZDestination.setZoom(-1.0f);

    // Assert
    List<? extends COSBase> toListResult = pdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    assertNull(toListResult.get(4));
    assertEquals(-1.0f, pdPageXYZDestination.getZoom());
  }

  /**
   * Method under test: {@link PDPageXYZDestination#setZoom(float)}
   */
  @Test
  void testSetZoom4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);
    PDPageXYZDestination pdPageXYZDestination = new PDPageXYZDestination(arr);

    // Act
    pdPageXYZDestination.setZoom(10.0f);

    // Assert
    verify(object).getCOSObject();
    assertEquals(10.0f, pdPageXYZDestination.getZoom());
    assertSame(arr, pdPageXYZDestination.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDPageXYZDestination#PDPageXYZDestination(COSArray)}
   */
  @Test
  void testNewPDPageXYZDestination() {
    // Arrange
    COSArray arr = new COSArray();

    // Act and Assert
    COSArray cOSObject = (new PDPageXYZDestination(arr)).getCOSObject();
    assertTrue(cOSObject.toList().isEmpty());
    assertSame(arr, cOSObject);
  }

  /**
   * Method under test: {@link PDPageXYZDestination#PDPageXYZDestination()}
   */
  @Test
  void testNewPDPageXYZDestination2() {
    // Arrange and Act
    PDPageXYZDestination actualPdPageXYZDestination = new PDPageXYZDestination();

    // Assert
    List<? extends COSBase> toListResult = actualPdPageXYZDestination.getCOSObject().toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("XYZ", ((COSName) getResult).getName());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(2));
    assertNull(toListResult.get(3));
    assertNull(toListResult.get(4));
    assertNull(getResult.getKey());
    assertNull(actualPdPageXYZDestination.getPage());
    assertEquals(-1, actualPdPageXYZDestination.getPageNumber());
    assertEquals(-1, actualPdPageXYZDestination.getLeft());
    assertEquals(-1, actualPdPageXYZDestination.getTop());
    assertEquals(-1.0f, actualPdPageXYZDestination.getZoom());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }
}
