package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Paint;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class PDShadingType3DiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDShadingType3#PDShadingType3(COSDictionary)}
   *   <li>{@link PDShadingType3#getShadingType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    // Act
    PDShadingType3 actualPdShadingType3 = new PDShadingType3(shadingDictionary);

    // Assert
    assertEquals(3, actualPdShadingType3.getShadingType());
    assertSame(shadingDictionary, actualPdShadingType3.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingType3#toPaint(Matrix)}
   */
  @Test
  void testToPaint() {
    // Arrange
    PDShadingType3 pdShadingType3 = new PDShadingType3(new COSDictionary());
    Matrix matrix = new Matrix();

    // Act
    Paint actualToPaintResult = pdShadingType3.toPaint(matrix);

    // Assert
    assertTrue(actualToPaintResult instanceof RadialShadingPaint);
    assertEquals(0, actualToPaintResult.getTransparency());
    assertSame(pdShadingType3, ((RadialShadingPaint) actualToPaintResult).getShading());
    assertSame(matrix, ((RadialShadingPaint) actualToPaintResult).getMatrix());
  }
}
