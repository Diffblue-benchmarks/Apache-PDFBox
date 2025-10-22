package org.apache.pdfbox.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VectorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Vector#Vector(float, float)}
   *   <li>{@link Vector#toString()}
   *   <li>{@link Vector#getX()}
   *   <li>{@link Vector#getY()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Vector.<init>(float, float)", "float Vector.getX()", "float Vector.getY()",
      "String Vector.toString()"})
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
   * Test {@link Vector#scale(float)}.
   * <p>
   * Method under test: {@link Vector#scale(float)}
   */
  @Test
  @DisplayName("Test scale(float)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Vector Vector.scale(float)"})
  void testScale() {
    // Arrange and Act
    Vector actualScaleResult = (new Vector(10.0f, 10.0f)).scale(10.0f);

    // Assert
    assertEquals(100.0f, actualScaleResult.getX());
    assertEquals(100.0f, actualScaleResult.getY());
  }
}
