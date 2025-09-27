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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.color.ICC_ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Type4ShadingContextDiffblueTest {
  /**
   * Test {@link Type4ShadingContext#Type4ShadingContext(PDShadingType4, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Then ColorModel ColorSpace return {@link ICC_ColorSpace}.
   * </ul>
   *
   * <p>Method under test: {@link Type4ShadingContext#Type4ShadingContext(PDShadingType4,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new Type4ShadingContext(PDShadingType4, ColorModel, AffineTransform, Matrix, Rectangle); then ColorModel ColorSpace return ICC_ColorSpace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type4ShadingContext.<init>(PDShadingType4, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewType4ShadingContext_thenColorModelColorSpaceReturnICC_ColorSpace()
      throws IOException {
    // Arrange
    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.getBackground()).thenReturn(null);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    Type4ShadingContext actualType4ShadingContext =
        new Type4ShadingContext(shading, cm, xform, matrix, new Rectangle());

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    ColorModel colorModel = actualType4ShadingContext.getColorModel();
    assertTrue(colorModel.getColorSpace() instanceof ICC_ColorSpace);
    PDColorSpace shadingColorSpace = actualType4ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace.getCOSObject() instanceof COSName);
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", shadingColorSpace.getName());
    assertNull(actualType4ShadingContext.getBackground());
    assertEquals(0, colorModel.getTransferType());
    assertEquals(0, actualType4ShadingContext.getRgbBackground());
    assertEquals(1, shadingColorSpace.getNumberOfComponents());
    assertEquals(3, colorModel.getNumColorComponents());
    assertEquals(3, colorModel.getTransparency());
    assertEquals(4, colorModel.getNumComponents());
    assertFalse(colorModel.isAlphaPremultiplied());
    assertTrue(colorModel.hasAlpha());
    assertTrue(actualType4ShadingContext.isDataEmpty());
    assertEquals(Integer.SIZE, colorModel.getPixelSize());
    assertSame(shading, actualType4ShadingContext.getShading());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }
}
