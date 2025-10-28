package org.apache.pdfbox.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class VectorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Vector#Vector(float, float)}
   *   <li>{@link Vector#toString()}
   *   <li>{@link Vector#getX()}
   *   <li>{@link Vector#getY()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Vector actualVector = new Vector(10.0f, 10.0f);
    String actualToStringResult = actualVector.toString();
    float actualX = actualVector.getX();

    // Assert
    assertEquals("(10.0, 10.0)", actualToStringResult);
    assertEquals(10.0f, actualX);
    assertEquals(10.0f, actualVector.getY());
  }

  /**
   * Method under test: {@link Vector#scale(float)}
   */
  @Test
  void testScale() {
    // Arrange and Act
    Vector actualScaleResult = (new Vector(10.0f, 10.0f)).scale(10.0f);

    // Assert
    assertEquals(100.0f, actualScaleResult.getX());
    assertEquals(100.0f, actualScaleResult.getY());
  }
}
