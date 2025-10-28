package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Paint;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class PDShadingType6DiffblueTest {
  /**
   * Method under test: {@link PDShadingType6#getShadingType()}
   */
  @Test
  void testGetShadingType() {
    // Arrange, Act and Assert
    assertEquals(6, (new PDShadingType6(new COSDictionary())).getShadingType());
  }

  /**
   * Method under test: {@link PDShadingType6#toPaint(Matrix)}
   */
  @Test
  void testToPaint() {
    // Arrange
    PDShadingType6 pdShadingType6 = new PDShadingType6(new COSDictionary());
    Matrix matrix = new Matrix();

    // Act
    Paint actualToPaintResult = pdShadingType6.toPaint(matrix);

    // Assert
    assertTrue(actualToPaintResult instanceof Type6ShadingPaint);
    assertEquals(0, actualToPaintResult.getTransparency());
    assertSame(pdShadingType6, ((Type6ShadingPaint) actualToPaintResult).getShading());
    assertSame(matrix, ((Type6ShadingPaint) actualToPaintResult).getMatrix());
  }

  /**
   * Method under test: {@link PDShadingType6#getBounds(AffineTransform, Matrix)}
   */
  @Test
  void testGetBounds() throws IOException {
    // Arrange
    PDShadingType6 pdShadingType6 = new PDShadingType6(new COSDictionary());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertNull(pdShadingType6.getBounds(xform, new Matrix()));
  }

  /**
   * Method under test: {@link PDShadingType6#PDShadingType6(COSDictionary)}
   */
  @Test
  void testNewPDShadingType6() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    // Act and Assert
    assertSame(shadingDictionary, (new PDShadingType6(shadingDictionary)).getCOSObject());
  }
}
