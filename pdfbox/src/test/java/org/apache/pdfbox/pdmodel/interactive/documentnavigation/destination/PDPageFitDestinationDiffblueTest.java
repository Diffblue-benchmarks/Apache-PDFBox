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
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class PDPageFitDestinationDiffblueTest {
  /**
   * Method under test: {@link PDPageFitDestination#fitBoundingBox()}
   */
  @Test
  void testFitBoundingBox() {
    // Arrange, Act and Assert
    assertFalse((new PDPageFitDestination()).fitBoundingBox());
    assertFalse((new PDPageFitDestination(new COSArray())).fitBoundingBox());
  }

  /**
   * Method under test: {@link PDPageFitDestination#fitBoundingBox()}
   */
  @Test
  void testFitBoundingBox2() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();
    pdPageFitDestination.setFitBoundingBox(true);

    // Act and Assert
    assertTrue(pdPageFitDestination.fitBoundingBox());
  }

  /**
   * Method under test: {@link PDPageFitDestination#fitBoundingBox()}
   */
  @Test
  void testFitBoundingBox3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);

    // Act
    boolean actualFitBoundingBoxResult = (new PDPageFitDestination(arr)).fitBoundingBox();

    // Assert
    verify(object).getCOSObject();
    assertFalse(actualFitBoundingBoxResult);
  }

  /**
   * Method under test: {@link PDPageFitDestination#fitBoundingBox()}
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
    boolean actualFitBoundingBoxResult = (new PDPageFitDestination(arr)).fitBoundingBox();

    // Assert
    verify(object).getCOSObject();
    assertFalse(actualFitBoundingBoxResult);
  }

  /**
   * Method under test: {@link PDPageFitDestination#setFitBoundingBox(boolean)}
   */
  @Test
  void testSetFitBoundingBox() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();

    // Act
    pdPageFitDestination.setFitBoundingBox(true);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitDestination.getCOSObject().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("FitB", ((COSName) getResult).getName());
  }

  /**
   * Method under test: {@link PDPageFitDestination#setFitBoundingBox(boolean)}
   */
  @Test
  void testSetFitBoundingBox2() {
    // Arrange
    COSArray arr = new COSArray();
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    // Act
    pdPageFitDestination.setFitBoundingBox(true);

    // Assert
    assertSame(arr, pdPageFitDestination.getCOSObject());
  }

  /**
   * Method under test: {@link PDPageFitDestination#setFitBoundingBox(boolean)}
   */
  @Test
  void testSetFitBoundingBox3() {
    // Arrange
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination();

    // Act
    pdPageFitDestination.setFitBoundingBox(false);

    // Assert
    List<? extends COSBase> toListResult = pdPageFitDestination.getCOSObject().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("Fit", ((COSName) getResult).getName());
  }

  /**
   * Method under test: {@link PDPageFitDestination#setFitBoundingBox(boolean)}
   */
  @Test
  void testSetFitBoundingBox4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray arr = new COSArray();
    arr.add(object);
    PDPageFitDestination pdPageFitDestination = new PDPageFitDestination(arr);

    // Act
    pdPageFitDestination.setFitBoundingBox(true);

    // Assert
    verify(object).getCOSObject();
    assertSame(arr, pdPageFitDestination.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDPageFitDestination#PDPageFitDestination(COSArray)}
   */
  @Test
  void testNewPDPageFitDestination() {
    // Arrange
    COSArray arr = new COSArray();

    // Act and Assert
    COSArray cOSObject = (new PDPageFitDestination(arr)).getCOSObject();
    assertTrue(cOSObject.toList().isEmpty());
    assertSame(arr, cOSObject);
  }

  /**
   * Method under test: {@link PDPageFitDestination#PDPageFitDestination()}
   */
  @Test
  void testNewPDPageFitDestination2() {
    // Arrange and Act
    PDPageFitDestination actualPdPageFitDestination = new PDPageFitDestination();

    // Assert
    List<? extends COSBase> toListResult = actualPdPageFitDestination.getCOSObject().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("Fit", ((COSName) getResult).getName());
    assertNull(toListResult.get(0));
    assertNull(getResult.getKey());
    assertNull(actualPdPageFitDestination.getPage());
    assertEquals(-1, actualPdPageFitDestination.getPageNumber());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }
}
