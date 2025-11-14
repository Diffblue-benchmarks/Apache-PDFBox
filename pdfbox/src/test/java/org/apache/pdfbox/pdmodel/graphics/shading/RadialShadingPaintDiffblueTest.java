package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RadialShadingPaintDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RadialShadingPaint#RadialShadingPaint(PDShadingType3, Matrix)}
   *   <li>{@link RadialShadingPaint#getTransparency()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RadialShadingPaint.<init>(PDShadingType3, Matrix)",
    "int RadialShadingPaint.getTransparency()"
  })
  void testGettersAndSetters() {
    // Arrange
    PDShadingType3 shading = new PDShadingType3(new COSDictionary());
    Matrix matrix = new Matrix();

    // Act
    RadialShadingPaint actualRadialShadingPaint = new RadialShadingPaint(shading, matrix);

    // Assert
    assertEquals(0, actualRadialShadingPaint.getTransparency());
    assertSame(shading, actualRadialShadingPaint.getShading());
    assertSame(matrix, actualRadialShadingPaint.getMatrix());
  }
}
