package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Point;
import java.awt.geom.Point2D;
import org.junit.jupiter.api.Test;

class ShadedTriangleDiffblueTest {
  /**
   * Method under test: {@link ShadedTriangle#getBoundary()}
   */
  @Test
  void testGetBoundary() {
    // Arrange
    Point point = new Point(1, 1);

    Point point2 = new Point(1, 1);

    // Act and Assert
    assertArrayEquals(new int[]{1, 1, 1, 1}, (new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}})).getBoundary());
  }

  /**
   * Method under test: {@link ShadedTriangle#contains(Point2D)}
   */
  @Test
  void testContains() {
    // Arrange
    Point point = new Point(1, 1);

    Point point2 = new Point(1, 1);

    ShadedTriangle shadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Act and Assert
    assertTrue(shadedTriangle.contains(new Point(1, 1)));
  }

  /**
   * Method under test: {@link ShadedTriangle#contains(Point2D)}
   */
  @Test
  void testContains2() {
    // Arrange
    Point point = new Point(1, 1);

    Point point2 = new Point(1, 1);

    ShadedTriangle shadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Act and Assert
    assertFalse(shadedTriangle.contains(new Point(-1, 1)));
  }

  /**
   * Method under test: {@link ShadedTriangle#contains(Point2D)}
   */
  @Test
  void testContains3() {
    // Arrange
    Point point = new Point(1, 1);

    Point point2 = new Point(1, 1);

    ShadedTriangle shadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Act and Assert
    assertFalse(shadedTriangle.contains(new Point(1, -1)));
  }

  /**
   * Method under test: {@link ShadedTriangle#calcColor(Point2D)}
   */
  @Test
  void testCalcColor() {
    // Arrange
    Point point = new Point(1, 1);

    Point point2 = new Point(1, 1);

    ShadedTriangle shadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{}});

    // Act and Assert
    assertEquals(0, shadedTriangle.calcColor(new Point(1, 1)).length);
  }

  /**
   * Method under test: {@link ShadedTriangle#calcColor(Point2D)}
   */
  @Test
  void testCalcColor2() {
    // Arrange
    Point point = new Point(1, 1);

    Point point2 = new Point(1, 1);

    ShadedTriangle shadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f},
            new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Act and Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, shadedTriangle.calcColor(new Point(1, 1)), 0.0f);
  }

  /**
   * Method under test: {@link ShadedTriangle#calcColor(Point2D)}
   */
  @Test
  void testCalcColor3() {
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
   * Method under test: {@link ShadedTriangle#calcColor(Point2D)}
   */
  @Test
  void testCalcColor4() {
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
   * Method under test:
   * {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  void testNewShadedTriangle() {
    // Arrange
    Point point = new Point(1, 1);

    Point point2 = new Point(1, 1);

    Point point3 = new Point(1, 1);

    // Act
    ShadedTriangle actualShadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, point3},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Assert
    assertNull(actualShadedTriangle.getLine());
    assertEquals(1, actualShadedTriangle.getDeg());
    float[][] floatArray = actualShadedTriangle.color;
    assertEquals(1, floatArray.length);
    Point2D[] point2DArray = actualShadedTriangle.corner;
    assertEquals(3, point2DArray.length);
    assertSame(point, point2DArray[0]);
    assertSame(point2, point2DArray[1]);
    assertSame(point3, point2DArray[2]);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, floatArray[0], 0.0f);
    assertArrayEquals(new int[]{1, 1, 1, 1}, actualShadedTriangle.getBoundary());
  }

  /**
   * Method under test:
   * {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  void testNewShadedTriangle2() {
    // Arrange
    Point point = new Point(2, 1);

    Point point2 = new Point(1, 1);

    Point point3 = new Point(1, 1);

    // Act
    ShadedTriangle actualShadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, point3},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f},
            new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Assert
    assertEquals(2, actualShadedTriangle.getLine().linePoints.size());
    assertEquals(2, actualShadedTriangle.getDeg());
    float[][] floatArray = actualShadedTriangle.color;
    assertEquals(3, floatArray.length);
    Point2D[] point2DArray = actualShadedTriangle.corner;
    assertEquals(3, point2DArray.length);
    assertSame(point2, point2DArray[1]);
    assertSame(point3, point2DArray[2]);
    assertSame(point, point2DArray[0]);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, floatArray[0], 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, floatArray[1], 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, floatArray[2], 0.0f);
    assertArrayEquals(new int[]{1, 2, 1, 1}, actualShadedTriangle.getBoundary());
  }

  /**
   * Method under test:
   * {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  void testNewShadedTriangle3() {
    // Arrange
    Point point = new Point(1, 2);

    Point point2 = new Point(1, 1);

    Point point3 = new Point(1, 1);

    // Act
    ShadedTriangle actualShadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, point3},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f},
            new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Assert
    assertEquals(2, actualShadedTriangle.getLine().linePoints.size());
    assertEquals(2, actualShadedTriangle.getDeg());
    float[][] floatArray = actualShadedTriangle.color;
    assertEquals(3, floatArray.length);
    Point2D[] point2DArray = actualShadedTriangle.corner;
    assertEquals(3, point2DArray.length);
    assertSame(point2, point2DArray[1]);
    assertSame(point3, point2DArray[2]);
    assertSame(point, point2DArray[0]);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, floatArray[0], 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, floatArray[1], 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, floatArray[2], 0.0f);
    assertArrayEquals(new int[]{1, 1, 1, 2}, actualShadedTriangle.getBoundary());
  }

  /**
   * Method under test:
   * {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  void testNewShadedTriangle4() {
    // Arrange
    Point point = new Point(1, 1);

    Point point2 = new Point(2, 1);

    Point point3 = new Point(1, 1);

    // Act
    ShadedTriangle actualShadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, point3},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f},
            new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Assert
    assertEquals(2, actualShadedTriangle.getLine().linePoints.size());
    assertEquals(2, actualShadedTriangle.getDeg());
    float[][] floatArray = actualShadedTriangle.color;
    assertEquals(3, floatArray.length);
    Point2D[] point2DArray = actualShadedTriangle.corner;
    assertEquals(3, point2DArray.length);
    assertSame(point, point2DArray[0]);
    assertSame(point3, point2DArray[2]);
    assertSame(point2, point2DArray[1]);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, floatArray[0], 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, floatArray[1], 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, floatArray[2], 0.0f);
    assertArrayEquals(new int[]{1, 2, 1, 1}, actualShadedTriangle.getBoundary());
  }

  /**
   * Method under test:
   * {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  void testNewShadedTriangle5() {
    // Arrange
    Point point = new Point(-1, 1);

    Point point2 = new Point(1, 1);

    Point point3 = new Point(1, 1);

    // Act
    ShadedTriangle actualShadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, point3},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f},
            new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Assert
    assertEquals(2, actualShadedTriangle.getDeg());
    assertEquals(3, actualShadedTriangle.getLine().linePoints.size());
    float[][] floatArray = actualShadedTriangle.color;
    assertEquals(3, floatArray.length);
    Point2D[] point2DArray = actualShadedTriangle.corner;
    assertEquals(3, point2DArray.length);
    assertSame(point, point2DArray[0]);
    assertSame(point2, point2DArray[1]);
    assertSame(point3, point2DArray[2]);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, floatArray[0], 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, floatArray[1], 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, floatArray[2], 0.0f);
    assertArrayEquals(new int[]{-1, 1, 1, 1}, actualShadedTriangle.getBoundary());
  }

  /**
   * Method under test:
   * {@link ShadedTriangle#ShadedTriangle(Point2D[], float[][])}
   */
  @Test
  void testNewShadedTriangle6() {
    // Arrange
    Point point = new Point(2, -1);

    Point point2 = new Point(1, 1);

    Point point3 = new Point(1, 1);

    // Act
    ShadedTriangle actualShadedTriangle = new ShadedTriangle(new Point2D[]{point, point2, point3},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f},
            new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Assert
    assertEquals(2, actualShadedTriangle.getDeg());
    assertEquals(3, actualShadedTriangle.getLine().linePoints.size());
    float[][] floatArray = actualShadedTriangle.color;
    assertEquals(3, floatArray.length);
    Point2D[] point2DArray = actualShadedTriangle.corner;
    assertEquals(3, point2DArray.length);
    assertSame(point2, point2DArray[1]);
    assertSame(point3, point2DArray[2]);
    assertSame(point, point2DArray[0]);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, floatArray[0], 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, floatArray[1], 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, floatArray[2], 0.0f);
    assertArrayEquals(new int[]{1, 2, -1, 1}, actualShadedTriangle.getBoundary());
  }
}
