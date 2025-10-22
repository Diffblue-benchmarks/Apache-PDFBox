package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Point;
import java.awt.geom.Point2D;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PatchDiffblueTest {
  /**
   * Test {@link Patch#clonedPoint2DArray(Point2D[])}.
   * <ul>
   *   <li>Then first element return {@link Point}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Patch#clonedPoint2DArray(Point2D[])}
   */
  @Test
  @DisplayName("Test clonedPoint2DArray(Point2D[]); then first element return Point")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Point2D[] Patch.clonedPoint2DArray(Point2D[])"})
  void testClonedPoint2DArray_thenFirstElementReturnPoint() {
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
