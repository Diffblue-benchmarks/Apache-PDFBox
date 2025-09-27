package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ShadedTriangleDiffblueTest {
  /**
   * Test {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}.
   *
   * <ul>
   *   <li>Then first element return {@link Point2D.Double}.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  @DisplayName("Test new ShadedTriangle(Point2D[], float[][]); then first element return Double")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShadedTriangle.<init>(Point2D[], float[][])"})
  void testNewShadedTriangle_thenFirstElementReturnDouble() {
    // Arrange
    Double resultDouble = new Double(1000.0d, 10.0d);
    Double resultDouble2 = new Double();

    // Act
    ShadedTriangle actualShadedTriangle =
        new ShadedTriangle(
            new Point2D[] {resultDouble, resultDouble2, new Double()},
            new float[][] {
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f}
            });

    // Assert
    Point2D[] point2DArray = actualShadedTriangle.corner;
    Point2D point2D = point2DArray[0];
    assertTrue(point2D instanceof Double);
    Point2D point2D2 = point2DArray[2];
    assertTrue(point2D2 instanceof Double);
    assertEquals(1000.0d, point2D.getX());
    assertEquals(1001, actualShadedTriangle.getLine().linePoints.size());
    float[][] floatArray = actualShadedTriangle.color;
    assertEquals(3, floatArray.length);
    assertEquals(3, point2DArray.length);
    assertEquals(point2DArray[1], point2D2);
    assertSame(resultDouble, point2D);
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, floatArray[0], 0.0f);
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, floatArray[1], 0.0f);
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, floatArray[2], 0.0f);
    assertArrayEquals(new int[] {0, 1000, 0, 10}, actualShadedTriangle.getBoundary());
  }

  /**
   * Test {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}.
   *
   * <ul>
   *   <li>Then return first element is {@link Point2D.Double#Double(double, double)} with zero and
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  @DisplayName(
      "Test new ShadedTriangle(Point2D[], float[][]); then return first element is Double(double, double) with zero and ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShadedTriangle.<init>(Point2D[], float[][])"})
  void testNewShadedTriangle_thenReturnFirstElementIsDoubleWithZeroAndTen() {
    // Arrange
    Double resultDouble = new Double(0.0d, 10.0d);
    Double resultDouble2 = new Double();

    // Act
    ShadedTriangle actualShadedTriangle =
        new ShadedTriangle(
            new Point2D[] {resultDouble, resultDouble2, new Double()},
            new float[][] {
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f}
            });

    // Assert
    Point2D[] point2DArray = actualShadedTriangle.corner;
    Point2D point2D = point2DArray[2];
    assertTrue(point2D instanceof Double);
    float[][] floatArray = actualShadedTriangle.color;
    assertEquals(3, floatArray.length);
    assertEquals(3, point2DArray.length);
    assertEquals(point2DArray[1], point2D);
    assertSame(resultDouble, point2DArray[0]);
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, floatArray[0], 0.0f);
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, floatArray[1], 0.0f);
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, floatArray[2], 0.0f);
    assertArrayEquals(new int[] {0, 0, 0, 10}, actualShadedTriangle.getBoundary());
  }

  /**
   * Test {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}.
   *
   * <ul>
   *   <li>Then return second element is {@link Point2D.Double#Double(double, double)} with ten and
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  @DisplayName(
      "Test new ShadedTriangle(Point2D[], float[][]); then return second element is Double(double, double) with ten and ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShadedTriangle.<init>(Point2D[], float[][])"})
  void testNewShadedTriangle_thenReturnSecondElementIsDoubleWithTenAndTen() {
    // Arrange
    Double resultDouble = new Double();
    Double resultDouble2 = new Double(10.0d, 10.0d);

    // Act
    ShadedTriangle actualShadedTriangle =
        new ShadedTriangle(
            new Point2D[] {resultDouble, resultDouble2, new Double()},
            new float[][] {
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f}
            });

    // Assert
    Point2D[] point2DArray = actualShadedTriangle.corner;
    Point2D point2D = point2DArray[2];
    assertTrue(point2D instanceof Double);
    float[][] floatArray = actualShadedTriangle.color;
    assertEquals(3, floatArray.length);
    assertEquals(3, point2DArray.length);
    assertEquals(point2DArray[0], point2D);
    assertSame(resultDouble2, point2DArray[1]);
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, floatArray[0], 0.0f);
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, floatArray[1], 0.0f);
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, floatArray[2], 0.0f);
    assertArrayEquals(new int[] {0, 10, 0, 10}, actualShadedTriangle.getBoundary());
  }

  /**
   * Test {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}.
   *
   * <ul>
   *   <li>Then return third element is {@link Point2D.Double#Double(double, double)} with ten and
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  @DisplayName(
      "Test new ShadedTriangle(Point2D[], float[][]); then return third element is Double(double, double) with ten and ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShadedTriangle.<init>(Point2D[], float[][])"})
  void testNewShadedTriangle_thenReturnThirdElementIsDoubleWithTenAndTen() {
    // Arrange
    Double resultDouble = new Double(10.0d, 10.0d);
    Double resultDouble2 = new Double();
    Double resultDouble3 = new Double(10.0d, 10.0d);

    // Act
    ShadedTriangle actualShadedTriangle =
        new ShadedTriangle(
            new Point2D[] {resultDouble, resultDouble2, resultDouble3},
            new float[][] {
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f}
            });

    // Assert
    float[][] floatArray = actualShadedTriangle.color;
    assertEquals(3, floatArray.length);
    Point2D[] point2DArray = actualShadedTriangle.corner;
    assertEquals(3, point2DArray.length);
    assertSame(resultDouble3, point2DArray[2]);
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, floatArray[0], 0.0f);
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, floatArray[1], 0.0f);
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, floatArray[2], 0.0f);
    assertArrayEquals(new int[] {0, 10, 0, 10}, actualShadedTriangle.getBoundary());
  }

  /**
   * Test {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}.
   *
   * <ul>
   *   <li>Then return third element is second element.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  @DisplayName(
      "Test new ShadedTriangle(Point2D[], float[][]); then return third element is second element")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShadedTriangle.<init>(Point2D[], float[][])"})
  void testNewShadedTriangle_thenReturnThirdElementIsSecondElement() {
    // Arrange
    Double resultDouble = new Double(10.0d, 10.0d);
    Double resultDouble2 = new Double();

    // Act
    ShadedTriangle actualShadedTriangle =
        new ShadedTriangle(
            new Point2D[] {resultDouble, resultDouble2, new Double()},
            new float[][] {
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f}
            });

    // Assert
    Point2D[] point2DArray = actualShadedTriangle.corner;
    Point2D point2D = point2DArray[2];
    assertTrue(point2D instanceof Double);
    float[][] floatArray = actualShadedTriangle.color;
    assertEquals(3, floatArray.length);
    assertEquals(3, point2DArray.length);
    assertEquals(point2DArray[1], point2D);
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, floatArray[0], 0.0f);
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, floatArray[1], 0.0f);
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, floatArray[2], 0.0f);
    assertArrayEquals(new int[] {0, 10, 0, 10}, actualShadedTriangle.getBoundary());
  }

  /**
   * Test {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}.
   *
   * <ul>
   *   <li>Then second element return {@link Point2D.Double}.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  @DisplayName("Test new ShadedTriangle(Point2D[], float[][]); then second element return Double")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShadedTriangle.<init>(Point2D[], float[][])"})
  void testNewShadedTriangle_thenSecondElementReturnDouble() {
    // Arrange
    Double resultDouble = new Double();
    Double resultDouble2 = new Double();
    float[][] c = new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}};

    // Act
    ShadedTriangle actualShadedTriangle =
        new ShadedTriangle(new Point2D[] {resultDouble, resultDouble2, new Double()}, c);

    // Assert
    Point2D[] point2DArray = actualShadedTriangle.corner;
    assertTrue(point2DArray[1] instanceof Double);
    Point2D point2D = point2DArray[2];
    assertTrue(point2D instanceof Double);
    assertNull(actualShadedTriangle.getLine());
    assertEquals(1, actualShadedTriangle.getDeg());
    float[][] floatArray = actualShadedTriangle.color;
    assertEquals(1, floatArray.length);
    assertEquals(3, point2DArray.length);
    assertEquals(point2DArray[0], point2D);
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, floatArray[0], 0.0f);
    assertArrayEquals(new int[] {0, 0, 0, 0}, actualShadedTriangle.getBoundary());
  }

  /**
   * Test {@link ShadedTriangle#getBoundary()}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#getBoundary()}
   */
  @Test
  @DisplayName("Test getBoundary(); then return array of int with zero and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ShadedTriangle.getBoundary()"})
  void testGetBoundary_thenReturnArrayOfIntWithZeroAndZero() {
    // Arrange
    Double resultDouble = new Double();
    Double resultDouble2 = new Double();
    float[][] c = new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}};
    ShadedTriangle shadedTriangle =
        new ShadedTriangle(new Point2D[] {resultDouble, resultDouble2, new Double()}, c);

    // Act and Assert
    assertArrayEquals(new int[] {0, 0, 0, 0}, shadedTriangle.getBoundary());
  }

  /**
   * Test {@link ShadedTriangle#contains(Point2D)}.
   *
   * <ul>
   *   <li>When {@link Point2D.Double#Double(double, double)} with ten and ten.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#contains(Point2D)}
   */
  @Test
  @DisplayName(
      "Test contains(Point2D); when Double(double, double) with ten and ten; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShadedTriangle.contains(Point2D)"})
  void testContains_whenDoubleWithTenAndTen_thenReturnFalse() {
    // Arrange
    Double resultDouble = new Double();
    Double resultDouble2 = new Double();
    float[][] c = new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}};
    ShadedTriangle shadedTriangle =
        new ShadedTriangle(new Point2D[] {resultDouble, resultDouble2, new Double()}, c);

    // Act
    boolean actualContainsResult = shadedTriangle.contains(new Double(10.0d, 10.0d));

    // Assert
    assertFalse(actualContainsResult);
  }

  /**
   * Test {@link ShadedTriangle#contains(Point2D)}.
   *
   * <ul>
   *   <li>When {@link Point2D.Double#Double()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#contains(Point2D)}
   */
  @Test
  @DisplayName("Test contains(Point2D); when Double(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShadedTriangle.contains(Point2D)"})
  void testContains_whenDouble_thenReturnTrue() {
    // Arrange
    Double resultDouble = new Double();
    Double resultDouble2 = new Double();
    float[][] c = new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}};
    ShadedTriangle shadedTriangle =
        new ShadedTriangle(new Point2D[] {resultDouble, resultDouble2, new Double()}, c);

    // Act and Assert
    assertTrue(shadedTriangle.contains(new Double()));
  }

  /**
   * Test {@link ShadedTriangle#calcColor(Point2D)}.
   *
   * <ul>
   *   <li>Given array of {@link Point2D} with {@link Point2D.Double#Double(double, double)} with
   *       {@code -0.5} and {@code -0.5} and {@link Point2D.Double#Double()}.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#calcColor(Point2D)}
   */
  @Test
  @DisplayName(
      "Test calcColor(Point2D); given array of Point2D with Double(double, double) with '-0.5' and '-0.5' and Double()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] ShadedTriangle.calcColor(Point2D)"})
  void testCalcColor_givenArrayOfPoint2DWithDoubleWith05And05AndDouble() {
    // Arrange
    Double resultDouble = new Double(-0.5d, -0.5d);
    Double resultDouble2 = new Double();
    ShadedTriangle shadedTriangle =
        new ShadedTriangle(
            new Point2D[] {resultDouble, resultDouble2, new Double()},
            new float[][] {
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f}
            });

    // Act and Assert
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, shadedTriangle.calcColor(new Double()), 0.0f);
  }

  /**
   * Test {@link ShadedTriangle#calcColor(Point2D)}.
   *
   * <ul>
   *   <li>Given array of {@link Point2D} with {@link Point2D.Double#Double(double, double)} with
   *       {@code -0.5} and ten and {@link Point2D.Double#Double()}.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#calcColor(Point2D)}
   */
  @Test
  @DisplayName(
      "Test calcColor(Point2D); given array of Point2D with Double(double, double) with '-0.5' and ten and Double()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] ShadedTriangle.calcColor(Point2D)"})
  void testCalcColor_givenArrayOfPoint2DWithDoubleWith05AndTenAndDouble() {
    // Arrange
    Double resultDouble = new Double(-0.5d, 10.0d);
    Double resultDouble2 = new Double();
    ShadedTriangle shadedTriangle =
        new ShadedTriangle(
            new Point2D[] {resultDouble, resultDouble2, new Double()},
            new float[][] {
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f}
            });

    // Act and Assert
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, shadedTriangle.calcColor(new Double()), 0.0f);
  }

  /**
   * Test {@link ShadedTriangle#calcColor(Point2D)}.
   *
   * <ul>
   *   <li>Given array of {@link Point2D} with {@link Point2D.Double#Double(double, double)} with
   *       ten and ten and {@link Point2D.Double#Double()}.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#calcColor(Point2D)}
   */
  @Test
  @DisplayName(
      "Test calcColor(Point2D); given array of Point2D with Double(double, double) with ten and ten and Double()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] ShadedTriangle.calcColor(Point2D)"})
  void testCalcColor_givenArrayOfPoint2DWithDoubleWithTenAndTenAndDouble() {
    // Arrange
    Double resultDouble = new Double(10.0d, 10.0d);
    Double resultDouble2 = new Double();
    ShadedTriangle shadedTriangle =
        new ShadedTriangle(
            new Point2D[] {resultDouble, resultDouble2, new Double()},
            new float[][] {
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f}
            });

    // Act and Assert
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, shadedTriangle.calcColor(new Double()), 0.0f);
  }

  /**
   * Test {@link ShadedTriangle#calcColor(Point2D)}.
   *
   * <ul>
   *   <li>Then return array of {@code float} with {@link Float#NaN} and {@link Float#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#calcColor(Point2D)}
   */
  @Test
  @DisplayName("Test calcColor(Point2D); then return array of float with NaN and NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] ShadedTriangle.calcColor(Point2D)"})
  void testCalcColor_thenReturnArrayOfFloatWithNaNAndNaN() {
    // Arrange
    Double resultDouble = new Double(10.0d, 10.0d);
    Point point = new Point(1, 1);
    ShadedTriangle shadedTriangle =
        new ShadedTriangle(
            new Point2D[] {resultDouble, point, new Double()},
            new float[][] {
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f}
            });

    // Act and Assert
    assertArrayEquals(
        new float[] {Float.NaN, Float.NaN, Float.NaN, Float.NaN},
        shadedTriangle.calcColor(new Double()),
        0.0f);
  }

  /**
   * Test {@link ShadedTriangle#calcColor(Point2D)}.
   *
   * <ul>
   *   <li>Then return array of {@code float} with ten and {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#calcColor(Point2D)}
   */
  @Test
  @DisplayName("Test calcColor(Point2D); then return array of float with ten and '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] ShadedTriangle.calcColor(Point2D)"})
  void testCalcColor_thenReturnArrayOfFloatWithTenAnd05() {
    // Arrange
    Double resultDouble = new Double();
    Double resultDouble2 = new Double();
    ShadedTriangle shadedTriangle =
        new ShadedTriangle(
            new Point2D[] {resultDouble, resultDouble2, new Double()},
            new float[][] {
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f},
              new float[] {10.0f, 0.5f, 10.0f, 0.5f}
            });

    // Act and Assert
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, shadedTriangle.calcColor(new Double()), 0.0f);
  }

  /**
   * Test {@link ShadedTriangle#calcColor(Point2D)}.
   *
   * <ul>
   *   <li>Then return empty array of {@code float}.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#calcColor(Point2D)}
   */
  @Test
  @DisplayName("Test calcColor(Point2D); then return empty array of float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] ShadedTriangle.calcColor(Point2D)"})
  void testCalcColor_thenReturnEmptyArrayOfFloat() {
    // Arrange
    Double resultDouble = new Double();
    Double resultDouble2 = new Double();
    float[][] c = new float[][] {new float[] {}};
    ShadedTriangle shadedTriangle =
        new ShadedTriangle(new Point2D[] {resultDouble, resultDouble2, new Double()}, c);

    // Act and Assert
    assertArrayEquals(new float[] {}, shadedTriangle.calcColor(new Double()), 0.0f);
  }
}
