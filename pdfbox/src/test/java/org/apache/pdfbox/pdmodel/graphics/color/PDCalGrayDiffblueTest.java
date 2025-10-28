package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class PDCalGrayDiffblueTest {
  /**
   * Method under test: {@link PDCalGray#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("CalGray", (new PDCalGray()).getName());
  }

  /**
   * Method under test: {@link PDCalGray#getDefaultDecode(int)}
   */
  @Test
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 1.0f}, (new PDCalGray()).getDefaultDecode(1), 0.0f);
  }

  /**
   * Method under test: {@link PDCalGray#toRGB(float[])}
   */
  @Test
  void testToRGB() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, (new PDCalGray()).toRGB(new float[]{10.0f, 0.0f, 10.0f, 0.0f}),
        0.0f);
  }

  /**
   * Method under test: {@link PDCalGray#getGamma()}
   */
  @Test
  void testGetGamma() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDCalGray()).getGamma());
  }

  /**
   * Method under test: {@link PDCalGray#setGamma(float)}
   */
  @Test
  void testSetGamma() {
    // Arrange
    PDCalGray pdCalGray = new PDCalGray();

    // Act
    pdCalGray.setGamma(10.0f);

    // Assert
    COSDictionary cosDictionary = pdCalGray.dictionary;
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.size());
    assertEquals(10.0f, pdCalGray.getGamma());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDCalGray#getInitialColor()}
   *   <li>{@link PDCalGray#getNumberOfComponents()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDCalGray pdCalGray = new PDCalGray();

    // Act
    PDColor actualInitialColor = pdCalGray.getInitialColor();
    int actualNumberOfComponents = pdCalGray.getNumberOfComponents();

    // Assert
    assertNull(actualInitialColor.getPatternName());
    assertEquals(1, actualNumberOfComponents);
    assertFalse(actualInitialColor.isPattern());
    assertSame(pdCalGray, actualInitialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, actualInitialColor.getComponents(), 0.0f);
  }
}
