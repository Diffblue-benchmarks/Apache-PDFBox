package org.apache.pdfbox.debugger.colorpane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IndexedColorantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link IndexedColorant}
   *   <li>{@link IndexedColorant#setIndex(int)}
   *   <li>{@link IndexedColorant#setRgbValues(float[])}
   *   <li>{@link IndexedColorant#getIndex()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IndexedColorant.<init>()",
    "int IndexedColorant.getIndex()",
    "void IndexedColorant.setIndex(int)",
    "void IndexedColorant.setRgbValues(float[])"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    IndexedColorant actualIndexedColorant = new IndexedColorant();
    actualIndexedColorant.setIndex(1);
    actualIndexedColorant.setRgbValues(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertEquals(1, actualIndexedColorant.getIndex());
  }

  /**
   * Test {@link IndexedColorant#getColor()}.
   *
   * <ul>
   *   <li>Then return {@link Color#gray}.
   * </ul>
   *
   * <p>Method under test: {@link IndexedColorant#getColor()}
   */
  @Test
  @DisplayName("Test getColor(); then return gray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color IndexedColorant.getColor()"})
  void testGetColor_thenReturnGray() {
    // Arrange
    IndexedColorant indexedColorant = new IndexedColorant();
    indexedColorant.setIndex(1);
    indexedColorant.setRgbValues(new float[] {0.5f, 0.5f, 0.5f, 0.5f});

    // Act and Assert
    assertEquals(Color.gray, indexedColorant.getColor());
  }

  /**
   * Test {@link IndexedColorant#getRGBValuesString()}.
   *
   * <ul>
   *   <li>Then return {@code 2550, 127, 2550, 127}.
   * </ul>
   *
   * <p>Method under test: {@link IndexedColorant#getRGBValuesString()}
   */
  @Test
  @DisplayName("Test getRGBValuesString(); then return '2550, 127, 2550, 127'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String IndexedColorant.getRGBValuesString()"})
  void testGetRGBValuesString_thenReturn25501272550127() {
    // Arrange
    IndexedColorant indexedColorant = new IndexedColorant();
    indexedColorant.setIndex(1);
    indexedColorant.setRgbValues(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertEquals("2550, 127, 2550, 127 ", indexedColorant.getRGBValuesString());
  }
}
