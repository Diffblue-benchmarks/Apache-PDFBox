package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Point;
import java.awt.geom.Point2D;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShadedTriangleDiffblueTest {
  /**
   * Test {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}.
   * <ul>
   *   <li>Then return first element is minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  @DisplayName("Test new ShadedTriangle(Point2D[], float[][]); then return first element is minus one")
  void testNewShadedTriangle_thenReturnFirstElementIsMinusOne() {
    // Arrange
    Point point = new Point(-1, 1);

    Point point2 = new Point(1, 1);

    // Act
    ShadedTriangle actualShadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f},
            new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Assert
    Point2D[] point2DArray = actualShadedTriangle.corner;
    Point2D point2D = point2DArray[1];
    assertTrue(point2D instanceof Point);
    Point2D point2D2 = point2DArray[2];
    assertTrue(point2D2 instanceof Point);
    int[] boundary = actualShadedTriangle.getBoundary();
    assertEquals(-1, boundary[0]);
    assertEquals(3, point2DArray.length);
    assertEquals(4, boundary.length);
    assertEquals(point2D, ((Point) point2D).getLocation());
    assertEquals(point2D, point2D2);
    assertSame(point, point2DArray[0]);
  }

  /**
   * Test {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}.
   * <ul>
   *   <li>Then return first element is {@link Point#Point(int, int)} with two and
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  @DisplayName("Test new ShadedTriangle(Point2D[], float[][]); then return first element is Point(int, int) with two and one")
  void testNewShadedTriangle_thenReturnFirstElementIsPointWithTwoAndOne() {
    // Arrange
    Point point = new Point(2, 1);

    Point point2 = new Point(1, 1);

    // Act and Assert
    Point2D[] point2DArray = (new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f},
            new float[]{10.0f, 0.5f, 10.0f, 0.5f}})).corner;
    Point2D point2D = point2DArray[1];
    assertTrue(point2D instanceof Point);
    Point2D point2D2 = point2DArray[2];
    assertTrue(point2D2 instanceof Point);
    assertEquals(3, point2DArray.length);
    assertEquals(point2D, ((Point) point2D).getLocation());
    assertEquals(point2D, point2D2);
    assertSame(point, point2DArray[0]);
  }

  /**
   * Test {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}.
   * <ul>
   *   <li>Then return fourth element is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  @DisplayName("Test new ShadedTriangle(Point2D[], float[][]); then return fourth element is two")
  void testNewShadedTriangle_thenReturnFourthElementIsTwo() {
    // Arrange
    Point point = new Point(1, 2);

    Point point2 = new Point(1, 1);

    // Act
    ShadedTriangle actualShadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f},
            new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Assert
    Point2D[] point2DArray = actualShadedTriangle.corner;
    Point2D point2D = point2DArray[1];
    assertTrue(point2D instanceof Point);
    Point2D point2D2 = point2DArray[2];
    assertTrue(point2D2 instanceof Point);
    int[] boundary = actualShadedTriangle.getBoundary();
    assertEquals(2, boundary[3]);
    assertEquals(3, point2DArray.length);
    assertEquals(4, boundary.length);
    assertEquals(point2D, ((Point) point2D).getLocation());
    assertEquals(point2D, point2D2);
    assertSame(point, point2DArray[0]);
  }

  /**
   * Test {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}.
   * <ul>
   *   <li>Then return Line is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  @DisplayName("Test new ShadedTriangle(Point2D[], float[][]); then return Line is 'null'")
  void testNewShadedTriangle_thenReturnLineIsNull() {
    // Arrange
    Point point = new Point(1, 1);

    Point point2 = new Point(1, 1);

    // Act
    ShadedTriangle actualShadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Assert
    Point2D[] point2DArray = actualShadedTriangle.corner;
    Point2D point2D = point2DArray[0];
    assertTrue(point2D instanceof Point);
    assertTrue(point2DArray[1] instanceof Point);
    Point2D point2D2 = point2DArray[2];
    assertTrue(point2D2 instanceof Point);
    assertNull(actualShadedTriangle.getLine());
    assertEquals(1, actualShadedTriangle.getDeg());
    assertEquals(1, actualShadedTriangle.color.length);
    assertEquals(3, point2DArray.length);
    assertEquals(point2D, ((Point) point2D).getLocation());
    assertEquals(point2D, point2D2);
  }

  /**
   * Test {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}.
   * <ul>
   *   <li>Then return second element is {@link Point#Point(int, int)} with two and
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  @DisplayName("Test new ShadedTriangle(Point2D[], float[][]); then return second element is Point(int, int) with two and one")
  void testNewShadedTriangle_thenReturnSecondElementIsPointWithTwoAndOne() {
    // Arrange
    Point point = new Point(1, 1);

    Point point2 = new Point(2, 1);

    // Act and Assert
    Point2D[] point2DArray = (new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f},
            new float[]{10.0f, 0.5f, 10.0f, 0.5f}})).corner;
    Point2D point2D = point2DArray[0];
    assertTrue(point2D instanceof Point);
    Point2D point2D2 = point2DArray[2];
    assertTrue(point2D2 instanceof Point);
    assertEquals(3, point2DArray.length);
    assertEquals(point2D, ((Point) point2D).getLocation());
    assertEquals(point2D, point2D2);
    assertSame(point2, point2DArray[1]);
  }

  /**
   * Test {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}.
   * <ul>
   *   <li>Then return third element is minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  @DisplayName("Test new ShadedTriangle(Point2D[], float[][]); then return third element is minus one")
  void testNewShadedTriangle_thenReturnThirdElementIsMinusOne() {
    // Arrange
    Point point = new Point(2, -1);

    Point point2 = new Point(1, 1);

    // Act
    ShadedTriangle actualShadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f},
            new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Assert
    Point2D[] point2DArray = actualShadedTriangle.corner;
    Point2D point2D = point2DArray[1];
    assertTrue(point2D instanceof Point);
    Point2D point2D2 = point2DArray[2];
    assertTrue(point2D2 instanceof Point);
    int[] boundary = actualShadedTriangle.getBoundary();
    assertEquals(-1, boundary[2]);
    assertEquals(3, point2DArray.length);
    assertEquals(4, boundary.length);
    assertEquals(point2D, ((Point) point2D).getLocation());
    assertEquals(point2D, point2D2);
    assertSame(point, point2DArray[0]);
  }

  /**
   * Test {@link ShadedTriangle#getBoundary()}.
   * <ul>
   *   <li>Given {@link Point#Point(int, int)} with one and one.</li>
   *   <li>Then return array of {@code int} with one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShadedTriangle#getBoundary()}
   */
  @Test
  @DisplayName("Test getBoundary(); given Point(int, int) with one and one; then return array of int with one and one")
  void testGetBoundary_givenPointWithOneAndOne_thenReturnArrayOfIntWithOneAndOne() {
    // Arrange
    Point point = new Point(1, 1);

    Point point2 = new Point(1, 1);

    // Act and Assert
    assertArrayEquals(new int[]{1, 1, 1, 1}, (new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}})).getBoundary());
  }

  /**
   * Test {@link ShadedTriangle#contains(Point2D)}.
   * <ul>
   *   <li>Given {@link Point#Point(int, int)} with one and one.</li>
   *   <li>When {@link Point#Point(int, int)} with minus one and one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShadedTriangle#contains(Point2D)}
   */
  @Test
  @DisplayName("Test contains(Point2D); given Point(int, int) with one and one; when Point(int, int) with minus one and one; then return 'false'")
  void testContains_givenPointWithOneAndOne_whenPointWithMinusOneAndOne_thenReturnFalse() {
    // Arrange
    Point point = new Point(1, 1);

    Point point2 = new Point(1, 1);

    ShadedTriangle shadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Act and Assert
    assertFalse(shadedTriangle.contains(new Point(-1, 1)));
  }

  /**
   * Test {@link ShadedTriangle#contains(Point2D)}.
   * <ul>
   *   <li>Given {@link Point#Point(int, int)} with one and one.</li>
   *   <li>When {@link Point#Point(int, int)} with one and minus one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShadedTriangle#contains(Point2D)}
   */
  @Test
  @DisplayName("Test contains(Point2D); given Point(int, int) with one and one; when Point(int, int) with one and minus one; then return 'false'")
  void testContains_givenPointWithOneAndOne_whenPointWithOneAndMinusOne_thenReturnFalse() {
    // Arrange
    Point point = new Point(1, 1);

    Point point2 = new Point(1, 1);

    ShadedTriangle shadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Act and Assert
    assertFalse(shadedTriangle.contains(new Point(1, -1)));
  }

  /**
   * Test {@link ShadedTriangle#contains(Point2D)}.
   * <ul>
   *   <li>Given {@link Point#Point(int, int)} with one and one.</li>
   *   <li>When {@link Point#Point(int, int)} with one and one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShadedTriangle#contains(Point2D)}
   */
  @Test
  @DisplayName("Test contains(Point2D); given Point(int, int) with one and one; when Point(int, int) with one and one; then return 'true'")
  void testContains_givenPointWithOneAndOne_whenPointWithOneAndOne_thenReturnTrue() {
    // Arrange
    Point point = new Point(1, 1);

    Point point2 = new Point(1, 1);

    ShadedTriangle shadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Act and Assert
    assertTrue(shadedTriangle.contains(new Point(1, 1)));
  }

  /**
   * Test {@link ShadedTriangle#calcColor(Point2D)}.
   * <ul>
   *   <li>Given array of {@link Point2D} with {@link Point#Point(int, int)} with
   * one and two and {@link Point#Point(int, int)} with one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShadedTriangle#calcColor(Point2D)}
   */
  @Test
  @DisplayName("Test calcColor(Point2D); given array of Point2D with Point(int, int) with one and two and Point(int, int) with one and one")
  void testCalcColor_givenArrayOfPoint2DWithPointWithOneAndTwoAndPointWithOneAndOne() {
    // Arrange
    Point point = new Point(1, 2);

    Point point2 = new Point(1, 1);

    ShadedTriangle shadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f},
            new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Act and Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, shadedTriangle.calcColor(new Point(1, 1)), 0.0f);
  }

  /**
   * Test {@link ShadedTriangle#calcColor(Point2D)}.
   * <ul>
   *   <li>Given array of {@link Point2D} with {@link Point#Point(int, int)} with
   * two and one and {@link Point#Point(int, int)} with one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShadedTriangle#calcColor(Point2D)}
   */
  @Test
  @DisplayName("Test calcColor(Point2D); given array of Point2D with Point(int, int) with two and one and Point(int, int) with one and one")
  void testCalcColor_givenArrayOfPoint2DWithPointWithTwoAndOneAndPointWithOneAndOne() {
    // Arrange
    Point point = new Point(2, 1);

    Point point2 = new Point(1, 1);

    ShadedTriangle shadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f},
            new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Act and Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, shadedTriangle.calcColor(new Point(1, 1)), 0.0f);
  }

  /**
   * Test {@link ShadedTriangle#calcColor(Point2D)}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShadedTriangle#calcColor(Point2D)}
   */
  @Test
  @DisplayName("Test calcColor(Point2D); then return array length is zero")
  void testCalcColor_thenReturnArrayLengthIsZero() {
    // Arrange
    Point point = new Point(1, 1);

    Point point2 = new Point(1, 1);

    ShadedTriangle shadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{}});

    // Act and Assert
    assertEquals(0, shadedTriangle.calcColor(new Point(1, 1)).length);
  }

  /**
   * Test {@link ShadedTriangle#calcColor(Point2D)}.
   * <ul>
   *   <li>Then return array of {@code float} with ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShadedTriangle#calcColor(Point2D)}
   */
  @Test
  @DisplayName("Test calcColor(Point2D); then return array of float with ten and '0.5'")
  void testCalcColor_thenReturnArrayOfFloatWithTenAnd05() {
    // Arrange
    Point point = new Point(1, 1);

    Point point2 = new Point(1, 1);

    ShadedTriangle shadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f},
            new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Act and Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, shadedTriangle.calcColor(new Point(1, 1)), 0.0f);
  }
}
