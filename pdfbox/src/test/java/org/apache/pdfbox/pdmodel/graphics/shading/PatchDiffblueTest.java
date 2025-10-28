package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Point;
import java.awt.geom.Point2D;
import org.junit.jupiter.api.Test;

class PatchDiffblueTest {
  /**
   * Method under test: {@link Patch#clonedPoint2DArray(Point2D[])}
   */
  @Test
  void testClonedPoint2DArray() {
    // Arrange
    Point point = new Point(1, 1);

    // Act
    Point2D[] actualClonedPoint2DArrayResult = Patch.clonedPoint2DArray(new Point2D[]{point});

    // Assert
    Point2D point2D = actualClonedPoint2DArrayResult[0];
    assertTrue(point2D instanceof Point);
    assertEquals(1, actualClonedPoint2DArrayResult.length);
    assertEquals(point, point2D);
  }
}
