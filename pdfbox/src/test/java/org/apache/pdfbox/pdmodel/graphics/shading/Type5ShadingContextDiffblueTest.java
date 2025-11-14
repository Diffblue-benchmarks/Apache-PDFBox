package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class Type5ShadingContextDiffblueTest {
  @Mock private Matrix matrix;

  @Mock private PDShadingType5 pDShadingType5;

  /**
   * Test {@link Type5ShadingContext#Type5ShadingContext(PDShadingType5, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link Type5ShadingContext#Type5ShadingContext(PDShadingType5,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new Type5ShadingContext(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type5ShadingContext.<init>(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewType5ShadingContext_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    when(pDShadingType5.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(pDShadingType5.getBackground()).thenReturn(null);
    when(pDShadingType5.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(pDShadingType5.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenThrow(new IOException());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> new Type5ShadingContext(pDShadingType5, cm, xform, matrix, new Rectangle()));
    verify(pDShadingType5).getBackground();
    verify(pDShadingType5).getColorSpace();
    verify(pDShadingType5, atLeast(1))
        .collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
  }

  /**
   * Test {@link Type5ShadingContext#Type5ShadingContext(PDShadingType5, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Given {@link PDCalGray#PDCalGray()} Gamma is one.
   * </ul>
   *
   * <p>Method under test: {@link Type5ShadingContext#Type5ShadingContext(PDShadingType5,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new Type5ShadingContext(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle); given PDCalGray() Gamma is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type5ShadingContext.<init>(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewType5ShadingContext_givenPDCalGrayGammaIsOne() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    PDCalGray pdCalGray = new PDCalGray();
    pdCalGray.setGamma(1.0f);
    when(pDShadingType5.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(pDShadingType5.getBackground()).thenReturn(cosArray);
    when(pDShadingType5.getColorSpace()).thenReturn(pdCalGray);
    when(pDShadingType5.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    // Act
    Type5ShadingContext actualType5ShadingContext =
        new Type5ShadingContext(pDShadingType5, cm, xform, matrix, new Rectangle());

    // Assert
    verify(pDShadingType5).getBackground();
    verify(pDShadingType5).getColorSpace();
    verify(pDShadingType5, atLeast(1))
        .collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    ColorModel colorModel = actualType5ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType5ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDCalGray);
    assertArrayEquals(
        new float[] {0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f}, actualType5ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link Type5ShadingContext#Type5ShadingContext(PDShadingType5, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Then return Background is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Type5ShadingContext#Type5ShadingContext(PDShadingType5,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new Type5ShadingContext(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle); then return Background is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type5ShadingContext.<init>(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewType5ShadingContext_thenReturnBackgroundIsNull() throws IOException {
    // Arrange
    when(pDShadingType5.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(pDShadingType5.getBackground()).thenReturn(null);
    when(pDShadingType5.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(pDShadingType5.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    // Act
    Type5ShadingContext actualType5ShadingContext =
        new Type5ShadingContext(pDShadingType5, cm, xform, matrix, new Rectangle());

    // Assert
    verify(pDShadingType5).getBackground();
    verify(pDShadingType5).getColorSpace();
    verify(pDShadingType5, atLeast(1))
        .collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    ColorModel colorModel = actualType5ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType5ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertNull(actualType5ShadingContext.getBackground());
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(
        new float[] {0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link Type5ShadingContext#Type5ShadingContext(PDShadingType5, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Then ShadingColorSpace return {@link PDCalGray}.
   * </ul>
   *
   * <p>Method under test: {@link Type5ShadingContext#Type5ShadingContext(PDShadingType5,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new Type5ShadingContext(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle); then ShadingColorSpace return PDCalGray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type5ShadingContext.<init>(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewType5ShadingContext_thenShadingColorSpaceReturnPDCalGray() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    when(pDShadingType5.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(pDShadingType5.getBackground()).thenReturn(cosArray);
    when(pDShadingType5.getColorSpace()).thenReturn(new PDCalGray());
    when(pDShadingType5.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    // Act
    Type5ShadingContext actualType5ShadingContext =
        new Type5ShadingContext(pDShadingType5, cm, xform, matrix, new Rectangle());

    // Assert
    verify(pDShadingType5).getBackground();
    verify(pDShadingType5).getColorSpace();
    verify(pDShadingType5, atLeast(1))
        .collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    ColorModel colorModel = actualType5ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType5ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDCalGray);
    assertArrayEquals(
        new float[] {0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f}, actualType5ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link Type5ShadingContext#Type5ShadingContext(PDShadingType5, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Then ShadingColorSpace return {@link PDDeviceGray}.
   * </ul>
   *
   * <p>Method under test: {@link Type5ShadingContext#Type5ShadingContext(PDShadingType5,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new Type5ShadingContext(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle); then ShadingColorSpace return PDDeviceGray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type5ShadingContext.<init>(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewType5ShadingContext_thenShadingColorSpaceReturnPDDeviceGray() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    when(pDShadingType5.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(pDShadingType5.getBackground()).thenReturn(cosArray);
    when(pDShadingType5.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(pDShadingType5.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    // Act
    Type5ShadingContext actualType5ShadingContext =
        new Type5ShadingContext(pDShadingType5, cm, xform, matrix, new Rectangle());

    // Assert
    verify(pDShadingType5).getBackground();
    verify(pDShadingType5).getColorSpace();
    verify(pDShadingType5, atLeast(1))
        .collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    ColorModel colorModel = actualType5ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType5ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(
        new float[] {0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f}, actualType5ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }
}
