package org.apache.pdfbox.pdmodel.interactive.pagenavigation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class PDTransitionDiffblueTest {
  /**
   * Method under test: {@link PDTransition#getStyle()}
   */
  @Test
  void testGetStyle() {
    // Arrange, Act and Assert
    assertEquals("R", (new PDTransition()).getStyle());
    assertEquals("R", (new PDTransition(new COSDictionary())).getStyle());
  }

  /**
   * Method under test: {@link PDTransition#getDimension()}
   */
  @Test
  void testGetDimension() {
    // Arrange, Act and Assert
    assertEquals("H", (new PDTransition()).getDimension());
  }

  /**
   * Method under test: {@link PDTransition#setDimension(PDTransitionDimension)}
   */
  @Test
  void testSetDimension() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setDimension(PDTransitionDimension.H);

    // Assert
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTransition#getMotion()}
   */
  @Test
  void testGetMotion() {
    // Arrange, Act and Assert
    assertEquals("I", (new PDTransition()).getMotion());
  }

  /**
   * Method under test: {@link PDTransition#setMotion(PDTransitionMotion)}
   */
  @Test
  void testSetMotion() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setMotion(PDTransitionMotion.I);

    // Assert
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTransition#getDirection()}
   */
  @Test
  void testGetDirection() {
    // Arrange and Act
    COSBase actualDirection = (new PDTransition()).getDirection();

    // Assert
    assertSame(((COSInteger) actualDirection).ZERO, actualDirection);
  }

  /**
   * Method under test: {@link PDTransition#setDirection(PDTransitionDirection)}
   */
  @Test
  void testSetDirection() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setDirection(PDTransitionDirection.LEFT_TO_RIGHT);

    // Assert
    assertTrue(pdTransition.getDirection() instanceof COSInteger);
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTransition#setDirection(PDTransitionDirection)}
   */
  @Test
  void testSetDirection2() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setDirection(PDTransitionDirection.BOTTOM_TO_TOP);

    // Assert
    assertTrue(pdTransition.getDirection() instanceof COSInteger);
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTransition#setDirection(PDTransitionDirection)}
   */
  @Test
  void testSetDirection3() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setDirection(PDTransitionDirection.TOP_TO_BOTTOM);

    // Assert
    assertTrue(pdTransition.getDirection() instanceof COSInteger);
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTransition#setDirection(PDTransitionDirection)}
   */
  @Test
  void testSetDirection4() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setDirection(PDTransitionDirection.NONE);

    // Assert
    COSBase direction = pdTransition.getDirection();
    assertTrue(direction instanceof COSName);
    assertEquals("None", ((COSName) direction).getName());
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(((COSName) direction).isEmpty());
  }

  /**
   * Method under test: {@link PDTransition#getDuration()}
   */
  @Test
  void testGetDuration() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDTransition()).getDuration());
  }

  /**
   * Method under test: {@link PDTransition#setDuration(float)}
   */
  @Test
  void testSetDuration() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setDuration(10.0f);

    // Assert
    assertEquals(10.0f, pdTransition.getDuration());
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTransition#getFlyScale()}
   */
  @Test
  void testGetFlyScale() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDTransition()).getFlyScale());
  }

  /**
   * Method under test: {@link PDTransition#setFlyScale(float)}
   */
  @Test
  void testSetFlyScale() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setFlyScale(10.0f);

    // Assert
    assertEquals(10.0f, pdTransition.getFlyScale());
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDTransition#isFlyAreaOpaque()}
   */
  @Test
  void testIsFlyAreaOpaque() {
    // Arrange, Act and Assert
    assertFalse((new PDTransition()).isFlyAreaOpaque());
  }

  /**
   * Method under test: {@link PDTransition#setFlyAreaOpaque(boolean)}
   */
  @Test
  void testSetFlyAreaOpaque() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setFlyAreaOpaque(true);

    // Assert
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdTransition.isFlyAreaOpaque());
  }

  /**
   * Method under test: {@link PDTransition#setFlyAreaOpaque(boolean)}
   */
  @Test
  void testSetFlyAreaOpaque2() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setFlyAreaOpaque(false);

    // Assert
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdTransition.isFlyAreaOpaque());
  }

  /**
   * Method under test: {@link PDTransition#PDTransition(COSDictionary)}
   */
  @Test
  void testNewPDTransition() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDTransition(dictionary)).getCOSObject());
  }
}
