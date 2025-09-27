package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VertexDiffblueTest {
  /**
   * Test {@link Vertex#Vertex(Point2D, float[])}.
   *
   * <p>Method under test: {@link Vertex#Vertex(Point2D, float[])}
   */
  @Test
  @DisplayName("Test new Vertex(Point2D, float[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vertex.<init>(Point2D, float[])"})
  void testNewVertex() {
    // Arrange and Act
    Vertex actualVertex = new Vertex(new Double(), new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    Point2D point2D = actualVertex.point;
    assertTrue(point2D instanceof Double);
    assertEquals(0.0d, point2D.getX());
    assertEquals(0.0d, point2D.getY());
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualVertex.color, 0.0f);
  }

  /**
   * Test {@link Vertex#toString()}.
   *
   * <p>Method under test: {@link Vertex#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Vertex.toString()"})
  void testToString() {
    // Arrange
    Vertex vertex = new Vertex(new Double(), new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertEquals(
        "Vertex{ Point2D.Double[0.0, 0.0], colors=[10.00 0.50 10.00 0.50] }", vertex.toString());
  }
}
