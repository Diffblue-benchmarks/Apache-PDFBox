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

class PDShadingType7DiffblueTest {
  /**
   * Method under test: {@link PDShadingType7#getShadingType()}
   */
  @Test
  void testGetShadingType() {
    // Arrange, Act and Assert
    assertEquals(7, (new PDShadingType7(new COSDictionary())).getShadingType());
  }

  /**
   * Method under test: {@link PDShadingType7#toPaint(Matrix)}
   */
  @Test
  void testToPaint() {
    // Arrange
    PDShadingType7 pdShadingType7 = new PDShadingType7(new COSDictionary());
    Matrix matrix = new Matrix();

    // Act
    Paint actualToPaintResult = pdShadingType7.toPaint(matrix);

    // Assert
    assertTrue(actualToPaintResult instanceof Type7ShadingPaint);
    assertEquals(0, actualToPaintResult.getTransparency());
    assertSame(pdShadingType7, ((Type7ShadingPaint) actualToPaintResult).getShading());
    assertSame(matrix, ((Type7ShadingPaint) actualToPaintResult).getMatrix());
  }

  /**
   * Method under test: {@link PDShadingType7#getBounds(AffineTransform, Matrix)}
   */
  @Test
  void testGetBounds() throws IOException {
    // Arrange
    PDShadingType7 pdShadingType7 = new PDShadingType7(new COSDictionary());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertNull(pdShadingType7.getBounds(xform, new Matrix()));
  }

  /**
   * Method under test: {@link PDShadingType7#PDShadingType7(COSDictionary)}
   */
  @Test
  void testNewPDShadingType7() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    // Act and Assert
    assertSame(shadingDictionary, (new PDShadingType7(shadingDictionary)).getCOSObject());
  }
}
