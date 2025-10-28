package org.apache.pdfbox.debugger.colorpane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.Color;
import org.junit.jupiter.api.Test;

class IndexedColorantDiffblueTest {
  /**
   * Method under test: {@link IndexedColorant#getColor()}
   */
  @Test
  void testGetColor() {
    // Arrange
    IndexedColorant indexedColorant = new IndexedColorant();
    indexedColorant.setIndex(1);
    indexedColorant.setRgbValues(new float[]{0.5f, 0.5f, 0.5f, 0.5f});

    // Act
    Color actualColor = indexedColorant.getColor();

    // Assert
    assertEquals(actualColor.gray, actualColor);
  }

  /**
   * Method under test: {@link IndexedColorant#getRGBValuesString()}
   */
  @Test
  void testGetRGBValuesString() {
    // Arrange
    IndexedColorant indexedColorant = new IndexedColorant();
    indexedColorant.setIndex(1);
    indexedColorant.setRgbValues(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertEquals("2550, 127, 2550, 127 ", indexedColorant.getRGBValuesString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IndexedColorant}
   *   <li>{@link IndexedColorant#setIndex(int)}
   *   <li>{@link IndexedColorant#setRgbValues(float[])}
   *   <li>{@link IndexedColorant#getIndex()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    IndexedColorant actualIndexedColorant = new IndexedColorant();
    actualIndexedColorant.setIndex(1);
    actualIndexedColorant.setRgbValues(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert that nothing has changed
    assertEquals(1, actualIndexedColorant.getIndex());
  }
}
