package org.apache.pdfbox.debugger.colorpane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IndexedColorantDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IndexedColorant}
   *   <li>{@link IndexedColorant#setIndex(int)}
   *   <li>{@link IndexedColorant#setRgbValues(float[])}
   *   <li>{@link IndexedColorant#getIndex()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    IndexedColorant actualIndexedColorant = new IndexedColorant();
    actualIndexedColorant.setIndex(1);
    actualIndexedColorant.setRgbValues(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert that nothing has changed
    assertEquals(1, actualIndexedColorant.getIndex());
  }

  /**
   * Test {@link IndexedColorant#getColor()}.
   * <ul>
   *   <li>Then return {@link Color#gray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexedColorant#getColor()}
   */
  @Test
  @DisplayName("Test getColor(); then return gray")
  void testGetColor_thenReturnGray() {
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
   * Test {@link IndexedColorant#getRGBValuesString()}.
   * <ul>
   *   <li>Then return {@code 2550, 127, 2550, 127}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexedColorant#getRGBValuesString()}
   */
  @Test
  @DisplayName("Test getRGBValuesString(); then return '2550, 127, 2550, 127'")
  void testGetRGBValuesString_thenReturn25501272550127() {
    // Arrange
    IndexedColorant indexedColorant = new IndexedColorant();
    indexedColorant.setIndex(1);
    indexedColorant.setRgbValues(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertEquals("2550, 127, 2550, 127 ", indexedColorant.getRGBValuesString());
  }
}
