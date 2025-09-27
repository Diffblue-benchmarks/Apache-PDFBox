package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PatchDiffblueTest {
  /**
   * Test {@link Patch#clonedPoint2DArray(Point2D[])}.
   *
   * <ul>
   *   <li>When array of {@link Point2D} with {@link Point2D.Double#Double()}.
   *   <li>Then first element return {@link Point2D.Double}.
   * </ul>
   *
   * <p>Method under test: {@link Patch#clonedPoint2DArray(Point2D[])}
   */
  @Test
  @DisplayName(
      "Test clonedPoint2DArray(Point2D[]); when array of Point2D with Double(); then first element return Double")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Point2D[] Patch.clonedPoint2DArray(Point2D[])"})
  void testClonedPoint2DArray_whenArrayOfPoint2DWithDouble_thenFirstElementReturnDouble() {
    // Arrange
    Double resultDouble = new Double();

    // Act
    Point2D[] actualClonedPoint2DArrayResult =
        Patch.clonedPoint2DArray(new Point2D[] {resultDouble});

    // Assert
    Point2D point2D = actualClonedPoint2DArrayResult[0];
    assertTrue(point2D instanceof Double);
    assertEquals(1, actualClonedPoint2DArrayResult.length);
    assertEquals(resultDouble, point2D);
  }
}
