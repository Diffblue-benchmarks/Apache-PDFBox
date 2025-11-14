package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LineDiffblueTest {
  /**
   * Test {@link Line#Line(Point, Point, float[], float[])}.
   *
   * <ul>
   *   <li>When array of {@code float} with ten and {@code 0.5}.
   *   <li>Then return {@link Line#linePoints} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Line#Line(Point, Point, float[], float[])}
   */
  @Test
  @DisplayName(
      "Test new Line(Point, Point, float[], float[]); when array of float with ten and '0.5'; then return linePoints size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Line.<init>(Point, Point, float[], float[])"})
  void testNewLine_whenArrayOfFloatWithTenAnd05_thenReturnLinePointsSizeIsOne() {
    // Arrange
    Point p0 = new Point();

    // Act
    Line actualLine =
        new Line(
            p0,
            new Point(),
            new float[] {10.0f, 0.5f, 10.0f, 0.5f},
            new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertEquals(1, actualLine.linePoints.size());
  }

  /**
   * Test {@link Line#Line(Point, Point, float[], float[])}.
   *
   * <ul>
   *   <li>When {@link Point#Point(int, int)} with minus four and three.
   *   <li>Then return {@link Line#linePoints} size is five.
   * </ul>
   *
   * <p>Method under test: {@link Line#Line(Point, Point, float[], float[])}
   */
  @Test
  @DisplayName(
      "Test new Line(Point, Point, float[], float[]); when Point(int, int) with minus four and three; then return linePoints size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Line.<init>(Point, Point, float[], float[])"})
  void testNewLine_whenPointWithMinusFourAndThree_thenReturnLinePointsSizeIsFive() {
    // Arrange
    Point p0 = new Point(-4, 3);

    // Act
    Line actualLine =
        new Line(
            p0,
            new Point(),
            new float[] {10.0f, 0.5f, 10.0f, 0.5f},
            new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertEquals(5, actualLine.linePoints.size());
  }

  /**
   * Test {@link Line#Line(Point, Point, float[], float[])}.
   *
   * <ul>
   *   <li>When {@link Point#Point(int, int)} with minus one and three.
   *   <li>Then return {@link Line#linePoints} size is four.
   * </ul>
   *
   * <p>Method under test: {@link Line#Line(Point, Point, float[], float[])}
   */
  @Test
  @DisplayName(
      "Test new Line(Point, Point, float[], float[]); when Point(int, int) with minus one and three; then return linePoints size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Line.<init>(Point, Point, float[], float[])"})
  void testNewLine_whenPointWithMinusOneAndThree_thenReturnLinePointsSizeIsFour() {
    // Arrange
    Point p0 = new Point(-1, 3);

    // Act
    Line actualLine =
        new Line(
            p0,
            new Point(),
            new float[] {10.0f, 0.5f, 10.0f, 0.5f},
            new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertEquals(4, actualLine.linePoints.size());
  }

  /**
   * Test {@link Line#Line(Point, Point, float[], float[])}.
   *
   * <ul>
   *   <li>When {@link Point#Point(int, int)} with two and three.
   *   <li>Then return {@link Line#linePoints} size is four.
   * </ul>
   *
   * <p>Method under test: {@link Line#Line(Point, Point, float[], float[])}
   */
  @Test
  @DisplayName(
      "Test new Line(Point, Point, float[], float[]); when Point(int, int) with two and three; then return linePoints size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Line.<init>(Point, Point, float[], float[])"})
  void testNewLine_whenPointWithTwoAndThree_thenReturnLinePointsSizeIsFour() {
    // Arrange
    Point p0 = new Point(2, 3);

    // Act
    Line actualLine =
        new Line(
            p0,
            new Point(),
            new float[] {10.0f, 0.5f, 10.0f, 0.5f},
            new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertEquals(4, actualLine.linePoints.size());
  }

  /**
   * Test {@link Line#Line(Point, Point, float[], float[])}.
   *
   * <ul>
   *   <li>When {@link Point#Point(int, int)} with two and three.
   *   <li>Then return {@link Line#linePoints} size is four.
   * </ul>
   *
   * <p>Method under test: {@link Line#Line(Point, Point, float[], float[])}
   */
  @Test
  @DisplayName(
      "Test new Line(Point, Point, float[], float[]); when Point(int, int) with two and three; then return linePoints size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Line.<init>(Point, Point, float[], float[])"})
  void testNewLine_whenPointWithTwoAndThree_thenReturnLinePointsSizeIsFour2() {
    // Arrange
    Point p0 = new Point();

    // Act
    Line actualLine =
        new Line(
            p0,
            new Point(2, 3),
            new float[] {10.0f, 0.5f, 10.0f, 0.5f},
            new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertEquals(4, actualLine.linePoints.size());
  }

  /**
   * Test {@link Line#calcColor(Point)}.
   *
   * <p>Method under test: {@link Line#calcColor(Point)}
   */
  @Test
  @DisplayName("Test calcColor(Point)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] Line.calcColor(Point)"})
  void testCalcColor() {
    // Arrange
    Point p0 = new Point();
    Line line =
        new Line(
            p0,
            new Point(),
            new float[] {10.0f, 0.5f, 10.0f, 0.5f},
            new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, line.calcColor(new Point()), 0.0f);
  }

  /**
   * Test {@link Line#calcColor(Point)}.
   *
   * <ul>
   *   <li>Given {@link Point#Point(int, int)} with two and three.
   *   <li>Then return array of {@code float} with ten and {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link Line#calcColor(Point)}
   */
  @Test
  @DisplayName(
      "Test calcColor(Point); given Point(int, int) with two and three; then return array of float with ten and '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] Line.calcColor(Point)"})
  void testCalcColor_givenPointWithTwoAndThree_thenReturnArrayOfFloatWithTenAnd05() {
    // Arrange
    Point p0 = new Point(2, 3);
    Line line =
        new Line(
            p0,
            new Point(),
            new float[] {10.0f, 0.5f, 10.0f, 0.5f},
            new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, line.calcColor(new Point()), 0.0f);
  }

  /**
   * Test {@link Line#calcColor(Point)}.
   *
   * <ul>
   *   <li>Given {@link Point#Point(int, int)} with zero and three.
   *   <li>Then return array of {@code float} with ten and {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link Line#calcColor(Point)}
   */
  @Test
  @DisplayName(
      "Test calcColor(Point); given Point(int, int) with zero and three; then return array of float with ten and '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] Line.calcColor(Point)"})
  void testCalcColor_givenPointWithZeroAndThree_thenReturnArrayOfFloatWithTenAnd05() {
    // Arrange
    Point p0 = new Point(0, 3);
    Line line =
        new Line(
            p0,
            new Point(),
            new float[] {10.0f, 0.5f, 10.0f, 0.5f},
            new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, line.calcColor(new Point()), 0.0f);
  }
}
