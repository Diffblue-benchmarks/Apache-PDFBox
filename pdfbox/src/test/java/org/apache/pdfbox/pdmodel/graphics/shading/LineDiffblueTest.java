package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.Point;
import org.junit.jupiter.api.Test;

class LineDiffblueTest {
  /**
   * Method under test: {@link Line#calcColor(Point)}
   */
  @Test
  void testCalcColor() {
    // Arrange
    Point p0 = new Point(1, 1);

    Line line = new Line(p0, new Point(1, 1), new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, line.calcColor(new Point(1, 1)), 0.0f);
  }

  /**
   * Method under test: {@link Line#calcColor(Point)}
   */
  @Test
  void testCalcColor2() {
    // Arrange
    Point p0 = new Point(0, 1);

    Line line = new Line(p0, new Point(1, 1), new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, line.calcColor(new Point(1, 1)), 0.0f);
  }

  /**
   * Method under test: {@link Line#calcColor(Point)}
   */
  @Test
  void testCalcColor3() {
    // Arrange
    Point p0 = new Point(1, 0);

    Line line = new Line(p0, new Point(1, 1), new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, line.calcColor(new Point(1, 1)), 0.0f);
  }

  /**
   * Method under test: {@link Line#Line(Point, Point, float[], float[])}
   */
  @Test
  void testNewLine() {
    // Arrange
    Point p0 = new Point(1, 1);

    // Act and Assert
    assertEquals(1, (new Line(p0, new Point(1, 1), new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        new float[]{10.0f, 0.5f, 10.0f, 0.5f})).linePoints.size());
  }

  /**
   * Method under test: {@link Line#Line(Point, Point, float[], float[])}
   */
  @Test
  void testNewLine2() {
    // Arrange
    Point p0 = new Point(3, 1);

    // Act and Assert
    assertEquals(3, (new Line(p0, new Point(1, 1), new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        new float[]{10.0f, 0.5f, 10.0f, 0.5f})).linePoints.size());
  }

  /**
   * Method under test: {@link Line#Line(Point, Point, float[], float[])}
   */
  @Test
  void testNewLine3() {
    // Arrange
    Point p0 = new Point(-1, 1);

    // Act and Assert
    assertEquals(3, (new Line(p0, new Point(1, 1), new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        new float[]{10.0f, 0.5f, 10.0f, 0.5f})).linePoints.size());
  }

  /**
   * Method under test: {@link Line#Line(Point, Point, float[], float[])}
   */
  @Test
  void testNewLine4() {
    // Arrange
    Point p0 = new Point(1, 3);

    // Act and Assert
    assertEquals(3, (new Line(p0, new Point(1, 1), new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        new float[]{10.0f, 0.5f, 10.0f, 0.5f})).linePoints.size());
  }

  /**
   * Method under test: {@link Line#Line(Point, Point, float[], float[])}
   */
  @Test
  void testNewLine5() {
    // Arrange
    Point p0 = new Point(1, -1);

    // Act and Assert
    assertEquals(3, (new Line(p0, new Point(1, 1), new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        new float[]{10.0f, 0.5f, 10.0f, 0.5f})).linePoints.size());
  }
}
