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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDShadingType7DiffblueTest {
  /**
   * Test {@link PDShadingType7#PDShadingType7(COSDictionary)}.
   * <p>
   * Method under test: {@link PDShadingType7#PDShadingType7(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDShadingType7(COSDictionary)")
  void testNewPDShadingType7() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    // Act and Assert
    assertSame(shadingDictionary, (new PDShadingType7(shadingDictionary)).getCOSObject());
  }

  /**
   * Test {@link PDShadingType7#getShadingType()}.
   * <p>
   * Method under test: {@link PDShadingType7#getShadingType()}
   */
  @Test
  @DisplayName("Test getShadingType()")
  void testGetShadingType() {
    // Arrange, Act and Assert
    assertEquals(7, (new PDShadingType7(new COSDictionary())).getShadingType());
  }

  /**
   * Test {@link PDShadingType7#toPaint(Matrix)}.
   * <p>
   * Method under test: {@link PDShadingType7#toPaint(Matrix)}
   */
  @Test
  @DisplayName("Test toPaint(Matrix)")
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
   * Test {@link PDShadingType7#getBounds(AffineTransform, Matrix)} with
   * {@code xform}, {@code matrix}.
   * <p>
   * Method under test: {@link PDShadingType7#getBounds(AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test getBounds(AffineTransform, Matrix) with 'xform', 'matrix'")
  void testGetBoundsWithXformMatrix() throws IOException {
    // Arrange
    PDShadingType7 pdShadingType7 = new PDShadingType7(new COSDictionary());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertNull(pdShadingType7.getBounds(xform, new Matrix()));
  }
}
