package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.geom.Point2D.Float;
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
    Double resultDouble = new Double(1000.0d, 3.0d);
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
    assertArrayEquals(new int[] {0, 1000, 0, 3}, actualShadedTriangle.getBoundary());
  }

  /**
   * Test {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}.
   *
   * <ul>
   *   <li>Then return first element is {@link Point2D.Double#Double(double, double)} with zero and
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  @DisplayName(
      "Test new ShadedTriangle(Point2D[], float[][]); then return first element is Double(double, double) with zero and three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShadedTriangle.<init>(Point2D[], float[][])"})
  void testNewShadedTriangle_thenReturnFirstElementIsDoubleWithZeroAndThree() {
    // Arrange
    Double resultDouble = new Double(0.0d, 3.0d);
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
    assertArrayEquals(new int[] {0, 0, 0, 3}, actualShadedTriangle.getBoundary());
  }

  /**
   * Test {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}.
   *
   * <ul>
   *   <li>Then return second element is {@link Point2D.Double#Double(double, double)} with two and
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  @DisplayName(
      "Test new ShadedTriangle(Point2D[], float[][]); then return second element is Double(double, double) with two and three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShadedTriangle.<init>(Point2D[], float[][])"})
  void testNewShadedTriangle_thenReturnSecondElementIsDoubleWithTwoAndThree() {
    // Arrange
    Double resultDouble = new Double();
    Double resultDouble2 = new Double(2.0d, 3.0d);

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
    assertArrayEquals(new int[] {0, 2, 0, 3}, actualShadedTriangle.getBoundary());
  }

  /**
   * Test {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}.
   *
   * <ul>
   *   <li>Then return third element is {@link Point2D.Double#Double(double, double)} with two and
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  @DisplayName(
      "Test new ShadedTriangle(Point2D[], float[][]); then return third element is Double(double, double) with two and three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShadedTriangle.<init>(Point2D[], float[][])"})
  void testNewShadedTriangle_thenReturnThirdElementIsDoubleWithTwoAndThree() {
    // Arrange
    Double resultDouble = new Double(2.0d, 3.0d);
    Double resultDouble2 = new Double();
    Double resultDouble3 = new Double(2.0d, 3.0d);

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
    assertArrayEquals(new int[] {0, 2, 0, 3}, actualShadedTriangle.getBoundary());
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
    Double resultDouble = new Double(2.0d, 3.0d);
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
    assertArrayEquals(new int[] {0, 2, 0, 3}, actualShadedTriangle.getBoundary());
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
   *   <li>When {@link Point2D.Double#Double(double, double)} with two and three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#contains(Point2D)}
   */
  @Test
  @DisplayName(
      "Test contains(Point2D); when Double(double, double) with two and three; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShadedTriangle.contains(Point2D)"})
  void testContains_whenDoubleWithTwoAndThree_thenReturnFalse() {
    // Arrange
    Double resultDouble = new Double();
    Double resultDouble2 = new Double();
    float[][] c = new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}};
    ShadedTriangle shadedTriangle =
        new ShadedTriangle(new Point2D[] {resultDouble, resultDouble2, new Double()}, c);

    // Act
    boolean actualContainsResult = shadedTriangle.contains(new Double(2.0d, 3.0d));

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
   *       {@code -0.5} and three and {@link Point2D.Double#Double()}.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#calcColor(Point2D)}
   */
  @Test
  @DisplayName(
      "Test calcColor(Point2D); given array of Point2D with Double(double, double) with '-0.5' and three and Double()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] ShadedTriangle.calcColor(Point2D)"})
  void testCalcColor_givenArrayOfPoint2DWithDoubleWith05AndThreeAndDouble() {
    // Arrange
    Double resultDouble = new Double(-0.5d, 3.0d);
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
   *       two and three and {@link Point2D.Double#Double()}.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#calcColor(Point2D)}
   */
  @Test
  @DisplayName(
      "Test calcColor(Point2D); given array of Point2D with Double(double, double) with two and three and Double()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] ShadedTriangle.calcColor(Point2D)"})
  void testCalcColor_givenArrayOfPoint2DWithDoubleWithTwoAndThreeAndDouble() {
    // Arrange
    Double resultDouble = new Double(2.0d, 3.0d);
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
   *       two and three and {@link Float#Float(float, float)} with ten and ten.
   * </ul>
   *
   * <p>Method under test: {@link ShadedTriangle#calcColor(Point2D)}
   */
  @Test
  @DisplayName(
      "Test calcColor(Point2D); given array of Point2D with Double(double, double) with two and three and Float(float, float) with ten and ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] ShadedTriangle.calcColor(Point2D)"})
  void testCalcColor_givenArrayOfPoint2DWithDoubleWithTwoAndThreeAndFloatWithTenAndTen() {
    // Arrange
    Double resultDouble = new Double(2.0d, 3.0d);
    Float resultFloat = new Float(10.0f, 10.0f);
    ShadedTriangle shadedTriangle =
        new ShadedTriangle(
            new Point2D[] {resultDouble, resultFloat, new Double()},
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
