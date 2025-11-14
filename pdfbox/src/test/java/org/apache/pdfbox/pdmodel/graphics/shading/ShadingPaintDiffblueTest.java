package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ShadingPaintDiffblueTest {
  /**
   * Test {@link ShadingPaint#getShading()}.
   *
   * <p>Method under test: {@link ShadingPaint#getShading()}
   */
  @Test
  @DisplayName("Test getShading()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.graphics.shading.PDShading ShadingPaint.getShading()"
  })
  void testGetShading() {
    // Arrange
    PDShadingType2 shadingType2 = new PDShadingType2(new COSDictionary());
    AxialShadingPaint axialShadingPaint = new AxialShadingPaint(shadingType2, new Matrix());

    // Act
    PDShadingType2 actualShading = axialShadingPaint.getShading();

    // Assert
    assertSame(axialShadingPaint.shading, actualShading);
  }

  /**
   * Test {@link ShadingPaint#getMatrix()}.
   *
   * <p>Method under test: {@link ShadingPaint#getMatrix()}
   */
  @Test
  @DisplayName("Test getMatrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix ShadingPaint.getMatrix()"})
  void testGetMatrix() {
    // Arrange
    PDShadingType2 shadingType2 = new PDShadingType2(new COSDictionary());
    AxialShadingPaint axialShadingPaint = new AxialShadingPaint(shadingType2, new Matrix());

    // Act
    Matrix actualMatrix = axialShadingPaint.getMatrix();

    // Assert
    assertSame(axialShadingPaint.matrix, actualMatrix);
  }
}
