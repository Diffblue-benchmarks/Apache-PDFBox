package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineDiffblueTest {
  /**
   * Test {@link Line#Line(Point, Point, float[], float[])}.
   * <ul>
   *   <li>When {@link Point#Point(int, int)} with minus one and one.</li>
   *   <li>Then return {@link Line#linePoints} size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Line#Line(Point, Point, float[], float[])}
   */
  @Test
  @DisplayName("Test new Line(Point, Point, float[], float[]); when Point(int, int) with minus one and one; then return linePoints size is three")
  void testNewLine_whenPointWithMinusOneAndOne_thenReturnLinePointsSizeIsThree() {
    // Arrange
    Point p0 = new Point(-1, 1);

    // Act and Assert
    assertEquals(3, (new Line(p0, new Point(1, 1), new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        new float[]{10.0f, 0.5f, 10.0f, 0.5f})).linePoints.size());
  }

  /**
   * Test {@link Line#Line(Point, Point, float[], float[])}.
   * <ul>
   *   <li>When {@link Point#Point(int, int)} with one and minus one.</li>
   *   <li>Then return {@link Line#linePoints} size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Line#Line(Point, Point, float[], float[])}
   */
  @Test
  @DisplayName("Test new Line(Point, Point, float[], float[]); when Point(int, int) with one and minus one; then return linePoints size is three")
  void testNewLine_whenPointWithOneAndMinusOne_thenReturnLinePointsSizeIsThree() {
    // Arrange
    Point p0 = new Point(1, -1);

    // Act and Assert
    assertEquals(3, (new Line(p0, new Point(1, 1), new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        new float[]{10.0f, 0.5f, 10.0f, 0.5f})).linePoints.size());
  }

  /**
   * Test {@link Line#Line(Point, Point, float[], float[])}.
   * <ul>
   *   <li>When {@link Point#Point(int, int)} with one and one.</li>
   *   <li>Then return {@link Line#linePoints} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Line#Line(Point, Point, float[], float[])}
   */
  @Test
  @DisplayName("Test new Line(Point, Point, float[], float[]); when Point(int, int) with one and one; then return linePoints size is one")
  void testNewLine_whenPointWithOneAndOne_thenReturnLinePointsSizeIsOne() {
    // Arrange
    Point p0 = new Point(1, 1);

    // Act and Assert
    assertEquals(1, (new Line(p0, new Point(1, 1), new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        new float[]{10.0f, 0.5f, 10.0f, 0.5f})).linePoints.size());
  }

  /**
   * Test {@link Line#Line(Point, Point, float[], float[])}.
   * <ul>
   *   <li>When {@link Point#Point(int, int)} with one and three.</li>
   *   <li>Then return {@link Line#linePoints} size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Line#Line(Point, Point, float[], float[])}
   */
  @Test
  @DisplayName("Test new Line(Point, Point, float[], float[]); when Point(int, int) with one and three; then return linePoints size is three")
  void testNewLine_whenPointWithOneAndThree_thenReturnLinePointsSizeIsThree() {
    // Arrange
    Point p0 = new Point(1, 3);

    // Act and Assert
    assertEquals(3, (new Line(p0, new Point(1, 1), new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        new float[]{10.0f, 0.5f, 10.0f, 0.5f})).linePoints.size());
  }

  /**
   * Test {@link Line#Line(Point, Point, float[], float[])}.
   * <ul>
   *   <li>When {@link Point#Point(int, int)} with three and one.</li>
   *   <li>Then return {@link Line#linePoints} size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Line#Line(Point, Point, float[], float[])}
   */
  @Test
  @DisplayName("Test new Line(Point, Point, float[], float[]); when Point(int, int) with three and one; then return linePoints size is three")
  void testNewLine_whenPointWithThreeAndOne_thenReturnLinePointsSizeIsThree() {
    // Arrange
    Point p0 = new Point(3, 1);

    // Act and Assert
    assertEquals(3, (new Line(p0, new Point(1, 1), new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        new float[]{10.0f, 0.5f, 10.0f, 0.5f})).linePoints.size());
  }

  /**
   * Test {@link Line#calcColor(Point)}.
   * <ul>
   *   <li>Given {@link Point#Point(int, int)} with one and zero.</li>
   *   <li>Then return array of {@code float} with ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Line#calcColor(Point)}
   */
  @Test
  @DisplayName("Test calcColor(Point); given Point(int, int) with one and zero; then return array of float with ten and '0.5'")
  void testCalcColor_givenPointWithOneAndZero_thenReturnArrayOfFloatWithTenAnd05() {
    // Arrange
    Point p0 = new Point(1, 0);

    Line line = new Line(p0, new Point(1, 1), new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, line.calcColor(new Point(1, 1)), 0.0f);
  }

  /**
   * Test {@link Line#calcColor(Point)}.
   * <ul>
   *   <li>Given {@link Point#Point(int, int)} with zero and one.</li>
   *   <li>Then return array of {@code float} with ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Line#calcColor(Point)}
   */
  @Test
  @DisplayName("Test calcColor(Point); given Point(int, int) with zero and one; then return array of float with ten and '0.5'")
  void testCalcColor_givenPointWithZeroAndOne_thenReturnArrayOfFloatWithTenAnd05() {
    // Arrange
    Point p0 = new Point(0, 1);

    Line line = new Line(p0, new Point(1, 1), new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, line.calcColor(new Point(1, 1)), 0.0f);
  }

  /**
   * Test {@link Line#calcColor(Point)}.
   * <ul>
   *   <li>When {@link Point#Point(int, int)} with one and one.</li>
   *   <li>Then return array of {@code float} with ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Line#calcColor(Point)}
   */
  @Test
  @DisplayName("Test calcColor(Point); when Point(int, int) with one and one; then return array of float with ten and '0.5'")
  void testCalcColor_whenPointWithOneAndOne_thenReturnArrayOfFloatWithTenAnd05() {
    // Arrange
    Point p0 = new Point(1, 1);

    Line line = new Line(p0, new Point(1, 1), new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, line.calcColor(new Point(1, 1)), 0.0f);
  }
}
