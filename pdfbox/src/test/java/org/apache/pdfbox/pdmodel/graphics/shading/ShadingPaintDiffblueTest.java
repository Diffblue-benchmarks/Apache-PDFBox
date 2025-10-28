package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class ShadingPaintDiffblueTest {
  /**
   * Method under test: {@link ShadingPaint#getShading()}
   */
  @Test
  void testGetShading() {
    // Arrange
    PDShadingType2 shadingType2 = new PDShadingType2(new COSDictionary());
    AxialShadingPaint axialShadingPaint = new AxialShadingPaint(shadingType2, new Matrix());

    // Act and Assert
    assertSame(axialShadingPaint.shading, axialShadingPaint.getShading());
  }

  /**
   * Method under test: {@link ShadingPaint#getMatrix()}
   */
  @Test
  void testGetMatrix() {
    // Arrange
    PDShadingType2 shadingType2 = new PDShadingType2(new COSDictionary());
    AxialShadingPaint axialShadingPaint = new AxialShadingPaint(shadingType2, new Matrix());

    // Act and Assert
    assertSame(axialShadingPaint.matrix, axialShadingPaint.getMatrix());
  }
}
