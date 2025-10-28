package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Point;
import java.awt.geom.Point2D;
import org.junit.jupiter.api.Test;

class CoordinateColorPairDiffblueTest {
  /**
   * Method under test:
   * {@link CoordinateColorPair#CoordinateColorPair(Point2D, float[])}
   */
  @Test
  void testNewCoordinateColorPair() {
    // Arrange
    Point p = new Point(1, 1);

    // Act
    CoordinateColorPair actualCoordinateColorPair = new CoordinateColorPair(p, new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    Point2D point2D = actualCoordinateColorPair.coordinate;
    assertTrue(point2D instanceof Point);
    assertEquals(1, ((Point) point2D).x);
    assertEquals(1, ((Point) point2D).y);
    assertEquals(1.0d, point2D.getX());
    assertEquals(1.0d, point2D.getY());
    Point2D point2D2 = actualCoordinateColorPair.coordinate;
    assertEquals(point2D2, p.getLocation());
    assertEquals(point2D2, ((Point) point2D).getLocation());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualCoordinateColorPair.color, 0.0f);
  }
}
