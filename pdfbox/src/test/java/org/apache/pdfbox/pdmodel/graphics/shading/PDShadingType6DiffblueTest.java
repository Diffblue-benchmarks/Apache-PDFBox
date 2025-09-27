package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Paint;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDShadingType6DiffblueTest {
  /**
   * Test {@link PDShadingType6#PDShadingType6(COSDictionary)}.
   *
   * <p>Method under test: {@link PDShadingType6#PDShadingType6(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDShadingType6(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShadingType6.<init>(COSDictionary)"})
  void testNewPDShadingType6() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    // Act and Assert
    assertSame(shadingDictionary, new PDShadingType6(shadingDictionary).getCOSObject());
  }

  /**
   * Test {@link PDShadingType6#getShadingType()}.
   *
   * <p>Method under test: {@link PDShadingType6#getShadingType()}
   */
  @Test
  @DisplayName("Test getShadingType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDShadingType6.getShadingType()"})
  void testGetShadingType() {
    // Arrange, Act and Assert
    assertEquals(6, new PDShadingType6(new COSDictionary()).getShadingType());
  }

  /**
   * Test {@link PDShadingType6#toPaint(Matrix)}.
   *
   * <p>Method under test: {@link PDShadingType6#toPaint(Matrix)}
   */
  @Test
  @DisplayName("Test toPaint(Matrix)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paint PDShadingType6.toPaint(Matrix)"})
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
   * Test {@link PDShadingType6#getBounds(AffineTransform, Matrix)} with {@code xform}, {@code
   * matrix}.
   *
   * <p>Method under test: {@link PDShadingType6#getBounds(AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test getBounds(AffineTransform, Matrix) with 'xform', 'matrix'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.geom.Rectangle2D PDShadingType6.getBounds(AffineTransform, Matrix)"})
  void testGetBoundsWithXformMatrix() throws IOException {
    // Arrange
    PDShadingType6 pdShadingType6 = new PDShadingType6(new COSDictionary());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertNull(pdShadingType6.getBounds(xform, new Matrix()));
  }
}
