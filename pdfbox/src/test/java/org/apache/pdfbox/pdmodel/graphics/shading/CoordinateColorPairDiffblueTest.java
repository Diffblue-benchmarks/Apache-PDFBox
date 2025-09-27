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

class CoordinateColorPairDiffblueTest {
  /**
   * Test {@link CoordinateColorPair#CoordinateColorPair(Point2D, float[])}.
   *
   * <p>Method under test: {@link CoordinateColorPair#CoordinateColorPair(Point2D, float[])}
   */
  @Test
  @DisplayName("Test new CoordinateColorPair(Point2D, float[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoordinateColorPair.<init>(Point2D, float[])"})
  void testNewCoordinateColorPair() {
    // Arrange and Act
    CoordinateColorPair actualCoordinateColorPair =
        new CoordinateColorPair(new Double(), new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    Point2D point2D = actualCoordinateColorPair.coordinate;
    assertTrue(point2D instanceof Double);
    assertEquals(0.0d, point2D.getX());
    assertEquals(0.0d, point2D.getY());
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualCoordinateColorPair.color, 0.0f);
  }
}
