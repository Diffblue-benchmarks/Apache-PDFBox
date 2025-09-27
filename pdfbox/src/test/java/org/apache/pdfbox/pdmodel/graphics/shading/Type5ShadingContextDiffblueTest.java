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

class Type5ShadingContextDiffblueTest {
  /**
   * Test {@link Type5ShadingContext#Type5ShadingContext(PDShadingType5, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Then ColorModel ColorSpace return {@link ICC_ColorSpace}.
   * </ul>
   *
   * <p>Method under test: {@link Type5ShadingContext#Type5ShadingContext(PDShadingType5,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new Type5ShadingContext(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle); then ColorModel ColorSpace return ICC_ColorSpace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type5ShadingContext.<init>(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewType5ShadingContext_thenColorModelColorSpaceReturnICC_ColorSpace()
      throws IOException {
    // Arrange
    PDShadingType5 shading = mock(PDShadingType5.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    Type5ShadingContext actualType5ShadingContext =
        new Type5ShadingContext(shading, cm, xform, matrix, new Rectangle());

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    ColorModel colorModel = actualType5ShadingContext.getColorModel();
    assertTrue(colorModel.getColorSpace() instanceof ICC_ColorSpace);
    PDColorSpace shadingColorSpace = actualType5ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace.getCOSObject() instanceof COSName);
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", shadingColorSpace.getName());
    assertNull(actualType5ShadingContext.getBackground());
    assertEquals(0, colorModel.getTransferType());
    assertEquals(0, actualType5ShadingContext.getRgbBackground());
    assertEquals(1, shadingColorSpace.getNumberOfComponents());
    assertEquals(3, colorModel.getNumColorComponents());
    assertEquals(3, colorModel.getTransparency());
    assertEquals(4, colorModel.getNumComponents());
    assertFalse(colorModel.isAlphaPremultiplied());
    assertTrue(colorModel.hasAlpha());
    assertTrue(actualType5ShadingContext.isDataEmpty());
    assertEquals(Integer.SIZE, colorModel.getPixelSize());
    assertSame(shading, actualType5ShadingContext.getShading());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }
}
