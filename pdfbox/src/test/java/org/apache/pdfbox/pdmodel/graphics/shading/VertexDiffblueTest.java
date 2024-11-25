package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Point;
import java.awt.geom.Point2D;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VertexDiffblueTest {
  /**
   * Test {@link Vertex#Vertex(Point2D, float[])}.
   * <p>
   * Method under test: {@link Vertex#Vertex(Point2D, float[])}
   */
  @Test
  @DisplayName("Test new Vertex(Point2D, float[])")
  void testNewVertex() {
    // Arrange
    Point p = new Point(1, 1);

    // Act
    Vertex actualVertex = new Vertex(p, new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    Point2D point2D = actualVertex.point;
    assertTrue(point2D instanceof Point);
    assertEquals(1, ((Point) point2D).x);
    assertEquals(1, ((Point) point2D).y);
    assertEquals(1.0d, point2D.getX());
    assertEquals(1.0d, point2D.getY());
    Point2D point2D2 = actualVertex.point;
    assertEquals(point2D2, p.getLocation());
    assertEquals(point2D2, ((Point) point2D).getLocation());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualVertex.color, 0.0f);
  }

  /**
   * Test {@link Vertex#toString()}.
   * <p>
   * Method under test: {@link Vertex#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("Vertex{ java.awt.Point[x=1,y=1], colors=[10.00 0.50 10.00 0.50] }",
        (new Vertex(new Point(1, 1), new float[]{10.0f, 0.5f, 10.0f, 0.5f})).toString());
  }
}
