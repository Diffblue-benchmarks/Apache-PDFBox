package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.color.ICC_ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Type4ShadingPaintDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Type4ShadingPaint#Type4ShadingPaint(PDShadingType4, Matrix)}
   *   <li>{@link Type4ShadingPaint#getTransparency()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Type4ShadingPaint.<init>(PDShadingType4, Matrix)",
      "int Type4ShadingPaint.getTransparency()"})
  void testGettersAndSetters() {
    // Arrange
    PDShadingType4 shading = new PDShadingType4(new COSDictionary());
    Matrix matrix = new Matrix();

    // Act
    Type4ShadingPaint actualType4ShadingPaint = new Type4ShadingPaint(shading, matrix);

    // Assert
    assertEquals(0, actualType4ShadingPaint.getTransparency());
    assertSame(shading, actualType4ShadingPaint.getShading());
    assertSame(matrix, actualType4ShadingPaint.getMatrix());
  }

  /**
   * Test {@link Type4ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then ColorModel ColorSpace return {@link ICC_ColorSpace}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type4ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then ColorModel ColorSpace return ICC_ColorSpace")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext Type4ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_thenColorModelColorSpaceReturnICC_ColorSpace() throws IOException {
    // Arrange
    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any())).thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    Type4ShadingPaint type4ShadingPaint = new Type4ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    PaintContext actualCreateContextResult = type4ShadingPaint.createContext(cm, deviceBounds, userBounds,
        new AffineTransform(), null);

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    ColorModel colorModel = actualCreateContextResult.getColorModel();
    assertTrue(colorModel.getColorSpace() instanceof ICC_ColorSpace);
    PDColorSpace shadingColorSpace = ((Type4ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace.getCOSObject() instanceof COSName);
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type4ShadingContext);
    assertEquals("DeviceGray", shadingColorSpace.getName());
    assertNull(((Type4ShadingContext) actualCreateContextResult).getBackground());
    assertEquals(0, colorModel.getTransferType());
    assertEquals(0, ((Type4ShadingContext) actualCreateContextResult).getRgbBackground());
    assertEquals(1, shadingColorSpace.getNumberOfComponents());
    assertEquals(3, colorModel.getNumColorComponents());
    assertEquals(3, colorModel.getTransparency());
    assertEquals(4, colorModel.getNumComponents());
    assertFalse(colorModel.isAlphaPremultiplied());
    assertTrue(colorModel.hasAlpha());
    assertTrue(((Type4ShadingContext) actualCreateContextResult).isDataEmpty());
    assertEquals(Integer.SIZE, colorModel.getPixelSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }
}
