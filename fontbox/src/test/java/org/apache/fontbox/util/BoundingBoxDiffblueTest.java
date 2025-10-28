package org.apache.fontbox.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BoundingBoxDiffblueTest {
  /**
   * Method under test: {@link BoundingBox#getWidth()}
   */
  @Test
  void testGetWidth() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new BoundingBox(10.0f, 10.0f, 10.0f, 10.0f)).getWidth());
  }

  /**
   * Method under test: {@link BoundingBox#getHeight()}
   */
  @Test
  void testGetHeight() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new BoundingBox(10.0f, 10.0f, 10.0f, 10.0f)).getHeight());
  }

  /**
   * Method under test: {@link BoundingBox#contains(float, float)}
   */
  @Test
  void testContains() {
    // Arrange, Act and Assert
    assertTrue((new BoundingBox(10.0f, 10.0f, 10.0f, 10.0f)).contains(10.0f, 10.0f));
    assertFalse((new BoundingBox(Float.NaN, 10.0f, 10.0f, 10.0f)).contains(10.0f, 10.0f));
    assertFalse((new BoundingBox(10.0f, Float.NaN, 10.0f, 10.0f)).contains(10.0f, 10.0f));
    assertFalse((new BoundingBox(10.0f, 10.0f, 0.5f, 10.0f)).contains(10.0f, 10.0f));
    assertFalse((new BoundingBox(10.0f, 10.0f, 10.0f, 0.5f)).contains(10.0f, 10.0f));
  }

  /**
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
  void testGettersAndSetters2() {
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
   * Method under test: {@link BoundingBox#BoundingBox(List)}
   */
  @Test
  void testNewBoundingBox() {
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
}
