package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.color.ICC_ProfileRGB;
import java.awt.geom.AffineTransform;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Type7ShadingContextDiffblueTest {
  /**
   * Test {@link Type7ShadingContext#Type7ShadingContext(PDShadingType7, ColorModel, AffineTransform, Matrix, Rectangle)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return Background is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type7ShadingContext#Type7ShadingContext(PDShadingType7, ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName("Test new Type7ShadingContext(PDShadingType7, ColorModel, AffineTransform, Matrix, Rectangle); given 'null'; then return Background is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Type7ShadingContext.<init>(PDShadingType7, ColorModel, AffineTransform, Matrix, Rectangle)"})
  void testNewType7ShadingContext_givenNull_thenReturnBackgroundIsNull() throws IOException {
    // Arrange
    PDShadingType7 shading = mock(PDShadingType7.class);
    when(shading.collectPatches(Mockito.<AffineTransform>any(), Mockito.<Matrix>any(), anyInt()))
        .thenReturn(new ArrayList<>());
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    Type7ShadingContext actualType7ShadingContext = new Type7ShadingContext(shading, colorModel, xform, matrix,
        new Rectangle(1, 1));

    // Assert
    verify(shading).collectPatches(isA(AffineTransform.class), isA(Matrix.class), eq(16));
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    ColorModel colorModel2 = actualType7ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType7ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertNull(actualType7ShadingContext.getBackground());
    float[][] matrix2 = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix2.length);
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix2[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix2[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix2[0], 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel2.getComponentSize());
  }

  /**
   * Test {@link Type7ShadingContext#Type7ShadingContext(PDShadingType7, ColorModel, AffineTransform, Matrix, Rectangle)}.
   * <ul>
   *   <li>Then return Background is array of {@code float} with zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type7ShadingContext#Type7ShadingContext(PDShadingType7, ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName("Test new Type7ShadingContext(PDShadingType7, ColorModel, AffineTransform, Matrix, Rectangle); then return Background is array of float with zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Type7ShadingContext.<init>(PDShadingType7, ColorModel, AffineTransform, Matrix, Rectangle)"})
  void testNewType7ShadingContext_thenReturnBackgroundIsArrayOfFloatWithZero() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    PDShadingType7 shading = mock(PDShadingType7.class);
    when(shading.collectPatches(Mockito.<AffineTransform>any(), Mockito.<Matrix>any(), anyInt()))
        .thenReturn(new ArrayList<>());
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    Type7ShadingContext actualType7ShadingContext = new Type7ShadingContext(shading, colorModel, xform, matrix,
        new Rectangle(1, 1));

    // Assert
    verify(shading).collectPatches(isA(AffineTransform.class), isA(Matrix.class), eq(16));
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    ColorModel colorModel2 = actualType7ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType7ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    float[][] matrix2 = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix2.length);
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, actualType7ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix2[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix2[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix2[0], 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel2.getComponentSize());
  }
}
