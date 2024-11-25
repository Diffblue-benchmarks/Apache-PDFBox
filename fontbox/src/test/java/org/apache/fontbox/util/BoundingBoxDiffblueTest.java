package org.apache.fontbox.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoundingBoxDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BoundingBox#BoundingBox()}
   *   <li>{@link BoundingBox#setLowerLeftX(float)}
   *   <li>{@link BoundingBox#setLowerLeftY(float)}
   *   <li>{@link BoundingBox#setUpperRightX(float)}
   *   <li>{@link BoundingBox#setUpperRightY(float)}
   *   <li>{@link BoundingBox#toString()}
   *   <li>{@link BoundingBox#getLowerLeftX()}
   *   <li>{@link BoundingBox#getLowerLeftY()}
   *   <li>{@link BoundingBox#getUpperRightX()}
   *   <li>{@link BoundingBox#getUpperRightY()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BoundingBox actualBoundingBox = new BoundingBox();
    actualBoundingBox.setLowerLeftX(10.0f);
    actualBoundingBox.setLowerLeftY(10.0f);
    actualBoundingBox.setUpperRightX(10.0f);
    actualBoundingBox.setUpperRightY(10.0f);
    String actualToStringResult = actualBoundingBox.toString();
    float actualLowerLeftX = actualBoundingBox.getLowerLeftX();
    float actualLowerLeftY = actualBoundingBox.getLowerLeftY();
    float actualUpperRightX = actualBoundingBox.getUpperRightX();

    // Assert that nothing has changed
    assertEquals("[10.0,10.0,10.0,10.0]", actualToStringResult);
    assertEquals(10.0f, actualLowerLeftX);
    assertEquals(10.0f, actualLowerLeftY);
    assertEquals(10.0f, actualUpperRightX);
    assertEquals(10.0f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When ten.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BoundingBox#BoundingBox(float, float, float, float)}
   *   <li>{@link BoundingBox#setLowerLeftX(float)}
   *   <li>{@link BoundingBox#setLowerLeftY(float)}
   *   <li>{@link BoundingBox#setUpperRightX(float)}
   *   <li>{@link BoundingBox#setUpperRightY(float)}
   *   <li>{@link BoundingBox#toString()}
   *   <li>{@link BoundingBox#getLowerLeftX()}
   *   <li>{@link BoundingBox#getLowerLeftY()}
   *   <li>{@link BoundingBox#getUpperRightX()}
   *   <li>{@link BoundingBox#getUpperRightY()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ten")
  void testGettersAndSetters_whenTen() {
    // Arrange and Act
    BoundingBox actualBoundingBox = new BoundingBox(10.0f, 10.0f, 10.0f, 10.0f);
    actualBoundingBox.setLowerLeftX(10.0f);
    actualBoundingBox.setLowerLeftY(10.0f);
    actualBoundingBox.setUpperRightX(10.0f);
    actualBoundingBox.setUpperRightY(10.0f);
    String actualToStringResult = actualBoundingBox.toString();
    float actualLowerLeftX = actualBoundingBox.getLowerLeftX();
    float actualLowerLeftY = actualBoundingBox.getLowerLeftY();
    float actualUpperRightX = actualBoundingBox.getUpperRightX();

    // Assert that nothing has changed
    assertEquals("[10.0,10.0,10.0,10.0]", actualToStringResult);
    assertEquals(10.0f, actualLowerLeftX);
    assertEquals(10.0f, actualLowerLeftY);
    assertEquals(10.0f, actualUpperRightX);
    assertEquals(10.0f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link BoundingBox#BoundingBox(List)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   *   <li>Then return Height is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link BoundingBox#BoundingBox(List)}
   */
  @Test
  @DisplayName("Test new BoundingBox(List); given valueOf one; then return Height is zero")
  void testNewBoundingBox_givenValueOfOne_thenReturnHeightIsZero() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));
    numbers.add(Integer.valueOf(1));
    numbers.add(Integer.valueOf(1));
    numbers.add(Integer.valueOf(1));

    // Act
    BoundingBox actualBoundingBox = new BoundingBox(numbers);

    // Assert
    assertEquals(0.0f, actualBoundingBox.getHeight());
    assertEquals(0.0f, actualBoundingBox.getWidth());
    assertEquals(1.0f, actualBoundingBox.getLowerLeftX());
    assertEquals(1.0f, actualBoundingBox.getLowerLeftY());
    assertEquals(1.0f, actualBoundingBox.getUpperRightX());
    assertEquals(1.0f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link BoundingBox#getWidth()}.
   * <p>
   * Method under test: {@link BoundingBox#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  void testGetWidth() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new BoundingBox(10.0f, 10.0f, 10.0f, 10.0f)).getWidth());
  }

  /**
   * Test {@link BoundingBox#getHeight()}.
   * <p>
   * Method under test: {@link BoundingBox#getHeight()}
   */
  @Test
  @DisplayName("Test getHeight()")
  void testGetHeight() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new BoundingBox(10.0f, 10.0f, 10.0f, 10.0f)).getHeight());
  }

  /**
   * Test {@link BoundingBox#contains(float, float)}.
   * <ul>
   *   <li>Given {@link BoundingBox#BoundingBox(float, float, float, float)} with
   * minX is {@link Float#NaN} and minY is ten and maxX is ten and maxY is
   * ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link BoundingBox#contains(float, float)}
   */
  @Test
  @DisplayName("Test contains(float, float); given BoundingBox(float, float, float, float) with minX is NaN and minY is ten and maxX is ten and maxY is ten")
  void testContains_givenBoundingBoxWithMinXIsNaNAndMinYIsTenAndMaxXIsTenAndMaxYIsTen() {
    // Arrange, Act and Assert
    assertFalse((new BoundingBox(Float.NaN, 10.0f, 10.0f, 10.0f)).contains(10.0f, 10.0f));
  }

  /**
   * Test {@link BoundingBox#contains(float, float)}.
   * <ul>
   *   <li>Given {@link BoundingBox#BoundingBox(float, float, float, float)} with
   * minX is ten and minY is {@link Float#NaN} and maxX is ten and maxY is
   * ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link BoundingBox#contains(float, float)}
   */
  @Test
  @DisplayName("Test contains(float, float); given BoundingBox(float, float, float, float) with minX is ten and minY is NaN and maxX is ten and maxY is ten")
  void testContains_givenBoundingBoxWithMinXIsTenAndMinYIsNaNAndMaxXIsTenAndMaxYIsTen() {
    // Arrange, Act and Assert
    assertFalse((new BoundingBox(10.0f, Float.NaN, 10.0f, 10.0f)).contains(10.0f, 10.0f));
  }

  /**
   * Test {@link BoundingBox#contains(float, float)}.
   * <ul>
   *   <li>Given {@link BoundingBox#BoundingBox(float, float, float, float)} with
   * minX is ten and minY is ten and maxX is {@code 0.5} and maxY is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link BoundingBox#contains(float, float)}
   */
  @Test
  @DisplayName("Test contains(float, float); given BoundingBox(float, float, float, float) with minX is ten and minY is ten and maxX is '0.5' and maxY is ten")
  void testContains_givenBoundingBoxWithMinXIsTenAndMinYIsTenAndMaxXIs05AndMaxYIsTen() {
    // Arrange, Act and Assert
    assertFalse((new BoundingBox(10.0f, 10.0f, 0.5f, 10.0f)).contains(10.0f, 10.0f));
  }

  /**
   * Test {@link BoundingBox#contains(float, float)}.
   * <ul>
   *   <li>Given {@link BoundingBox#BoundingBox(float, float, float, float)} with
   * minX is ten and minY is ten and maxX is ten and maxY is {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BoundingBox#contains(float, float)}
   */
  @Test
  @DisplayName("Test contains(float, float); given BoundingBox(float, float, float, float) with minX is ten and minY is ten and maxX is ten and maxY is '0.5'")
  void testContains_givenBoundingBoxWithMinXIsTenAndMinYIsTenAndMaxXIsTenAndMaxYIs05() {
    // Arrange, Act and Assert
    assertFalse((new BoundingBox(10.0f, 10.0f, 10.0f, 0.5f)).contains(10.0f, 10.0f));
  }

  /**
   * Test {@link BoundingBox#contains(float, float)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BoundingBox#contains(float, float)}
   */
  @Test
  @DisplayName("Test contains(float, float); then return 'true'")
  void testContains_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new BoundingBox(10.0f, 10.0f, 10.0f, 10.0f)).contains(10.0f, 10.0f));
  }
}
