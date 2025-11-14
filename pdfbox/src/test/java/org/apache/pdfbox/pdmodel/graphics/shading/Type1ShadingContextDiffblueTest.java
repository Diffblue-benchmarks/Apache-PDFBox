package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;
import org.apache.pdfbox.pdmodel.graphics.color.PDLab;
import org.apache.pdfbox.pdmodel.graphics.color.PDTristimulus;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Type1ShadingContextDiffblueTest {
  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel,
   * AffineTransform, Matrix)}.
   *
   * <p>Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1,
   * ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"
  })
  void testNewType1ShadingContext() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSFloat.ONE);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(matrix);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    Type1ShadingContext actualType1ShadingContext =
        new Type1ShadingContext(shading, colorModel, xform, matrix2);

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray2).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    verify(matrix).createAffineTransform();
    verify(matrix2).createAffineTransform();
    ColorModel colorModel2 = actualType1ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType1ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    float[][] matrix3 = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix3.length);
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix3[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix3[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix3[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel,
   * AffineTransform, Matrix)}.
   *
   * <p>Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1,
   * ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"
  })
  void testNewType1ShadingContext2() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSFloat.ONE);

    PDCalRGB pdCalRGB = new PDCalRGB();
    pdCalRGB.setGamma(new PDGamma());

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(pdCalRGB);
    when(shading.getMatrix()).thenReturn(matrix);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    Type1ShadingContext actualType1ShadingContext =
        new Type1ShadingContext(shading, colorModel, xform, matrix2);

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray2).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    verify(matrix).createAffineTransform();
    verify(matrix2).createAffineTransform();
    PDColorSpace shadingColorSpace = actualType1ShadingContext.getShadingColorSpace();
    assertTrue(((PDCalRGB) shadingColorSpace).getBlackPoint().getCOSObject() instanceof COSArray);
    assertTrue(shadingColorSpace instanceof PDCalRGB);
    PDGamma gamma = ((PDCalRGB) shadingColorSpace).getGamma();
    assertEquals(0.0f, gamma.getB());
    assertEquals(0.0f, gamma.getG());
    assertEquals(0.0f, gamma.getR());
    assertEquals(16776191, actualType1ShadingContext.getRgbBackground());
    assertArrayEquals(
        new float[] {0.0f, 0.0f, 0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(
        new float[] {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f},
        ((PDCalRGB) shadingColorSpace).getMatrix(),
        0.0f);
    assertArrayEquals(
        new int[] {8, 8, 8, 8}, actualType1ShadingContext.getColorModel().getComponentSize());
  }

  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel,
   * AffineTransform, Matrix)}.
   *
   * <ul>
   *   <li>Given {@link PDDeviceGray#INSTANCE}.
   *   <li>Then ShadingColorSpace return {@link PDDeviceGray}.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1,
   * ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName(
      "Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); given INSTANCE; then ShadingColorSpace return PDDeviceGray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"
  })
  void testNewType1ShadingContext_givenInstance_thenShadingColorSpaceReturnPDDeviceGray()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSFloat.ONE);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(matrix);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    // Act
    Type1ShadingContext actualType1ShadingContext =
        new Type1ShadingContext(shading, colorModel, xform, new Matrix());

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray2).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    verify(matrix).createAffineTransform();
    ColorModel colorModel2 = actualType1ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType1ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    float[][] matrix2 = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix2.length);
    assertArrayEquals(
        new float[] {0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix2[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix2[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix2[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel,
   * AffineTransform, Matrix)}.
   *
   * <ul>
   *   <li>Given {@link Matrix#Matrix()}.
   *   <li>Then ShadingColorSpace return {@link PDDeviceGray}.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1,
   * ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName(
      "Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); given Matrix(); then ShadingColorSpace return PDDeviceGray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"
  })
  void testNewType1ShadingContext_givenMatrix_thenShadingColorSpaceReturnPDDeviceGray()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSFloat.ONE);

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(new Matrix());
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    // Act
    Type1ShadingContext actualType1ShadingContext =
        new Type1ShadingContext(shading, colorModel, xform, new Matrix());

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray2).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    ColorModel colorModel2 = actualType1ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType1ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
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
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel,
   * AffineTransform, Matrix)}.
   *
   * <ul>
   *   <li>Given {@link PDCalGray#PDCalGray()} Gamma is one.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1,
   * ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName(
      "Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); given PDCalGray() Gamma is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"
  })
  void testNewType1ShadingContext_givenPDCalGrayGammaIsOne() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSFloat.ONE);

    PDCalGray pdCalGray = new PDCalGray();
    pdCalGray.setGamma(1.0f);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(pdCalGray);
    when(shading.getMatrix()).thenReturn(matrix);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    Type1ShadingContext actualType1ShadingContext =
        new Type1ShadingContext(shading, colorModel, xform, matrix2);

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray2).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    verify(matrix).createAffineTransform();
    verify(matrix2).createAffineTransform();
    ColorModel colorModel2 = actualType1ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType1ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDCalGray);
    float[][] matrix3 = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix3.length);
    assertArrayEquals(
        new float[] {0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix3[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix3[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix3[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel,
   * AffineTransform, Matrix)}.
   *
   * <ul>
   *   <li>Given {@link PDCalGray#PDCalGray()} WhitePoint is {@link PDTristimulus#PDTristimulus()}.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1,
   * ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName(
      "Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); given PDCalGray() WhitePoint is PDTristimulus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"
  })
  void testNewType1ShadingContext_givenPDCalGrayWhitePointIsPDTristimulus() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSFloat.ONE);

    PDCalGray pdCalGray = new PDCalGray();
    pdCalGray.setWhitePoint(new PDTristimulus());

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(pdCalGray);
    when(shading.getMatrix()).thenReturn(matrix);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    Type1ShadingContext actualType1ShadingContext =
        new Type1ShadingContext(shading, colorModel, xform, matrix2);

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray2).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    verify(matrix).createAffineTransform();
    verify(matrix2).createAffineTransform();
    ColorModel colorModel2 = actualType1ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType1ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDCalGray);
    float[][] matrix3 = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix3.length);
    assertArrayEquals(
        new float[] {0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix3[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix3[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix3[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel,
   * AffineTransform, Matrix)}.
   *
   * <ul>
   *   <li>Given {@link PDCalGray#PDCalGray()}.
   *   <li>Then ShadingColorSpace return {@link PDCalGray}.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1,
   * ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName(
      "Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); given PDCalGray(); then ShadingColorSpace return PDCalGray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"
  })
  void testNewType1ShadingContext_givenPDCalGray_thenShadingColorSpaceReturnPDCalGray()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSFloat.ONE);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(new PDCalGray());
    when(shading.getMatrix()).thenReturn(matrix);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    Type1ShadingContext actualType1ShadingContext =
        new Type1ShadingContext(shading, colorModel, xform, matrix2);

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray2).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    verify(matrix).createAffineTransform();
    verify(matrix2).createAffineTransform();
    ColorModel colorModel2 = actualType1ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType1ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDCalGray);
    float[][] matrix3 = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix3.length);
    assertArrayEquals(
        new float[] {0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix3[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix3[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix3[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel,
   * AffineTransform, Matrix)}.
   *
   * <ul>
   *   <li>Given {@link PDCalRGB#PDCalRGB()} Matrix is {@link Matrix#Matrix()}.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1,
   * ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName(
      "Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); given PDCalRGB() Matrix is Matrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"
  })
  void testNewType1ShadingContext_givenPDCalRGBMatrixIsMatrix() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSFloat.ONE);

    PDCalRGB pdCalRGB = new PDCalRGB();
    pdCalRGB.setMatrix(new Matrix());

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(pdCalRGB);
    when(shading.getMatrix()).thenReturn(matrix);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    Type1ShadingContext actualType1ShadingContext =
        new Type1ShadingContext(shading, colorModel, xform, matrix2);

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray2).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    verify(matrix).createAffineTransform();
    verify(matrix2).createAffineTransform();
    ColorModel colorModel2 = actualType1ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType1ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDCalRGB);
    float[][] matrix3 = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix3.length);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix3[2], 0.0f);
    assertArrayEquals(
        new float[] {0.0f, 0.0f, 0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix3[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix3[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(
        new float[] {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f},
        ((PDCalRGB) shadingColorSpace).getMatrix(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel,
   * AffineTransform, Matrix)}.
   *
   * <ul>
   *   <li>Given {@link PDCalRGB#PDCalRGB()}.
   *   <li>Then ShadingColorSpace return {@link PDCalRGB}.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1,
   * ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName(
      "Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); given PDCalRGB(); then ShadingColorSpace return PDCalRGB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"
  })
  void testNewType1ShadingContext_givenPDCalRGB_thenShadingColorSpaceReturnPDCalRGB()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSFloat.ONE);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(new PDCalRGB());
    when(shading.getMatrix()).thenReturn(matrix);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    Type1ShadingContext actualType1ShadingContext =
        new Type1ShadingContext(shading, colorModel, xform, matrix2);

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray2).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    verify(matrix).createAffineTransform();
    verify(matrix2).createAffineTransform();
    ColorModel colorModel2 = actualType1ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType1ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDCalRGB);
    float[][] matrix3 = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix3.length);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix3[2], 0.0f);
    assertArrayEquals(
        new float[] {0.0f, 0.0f, 0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix3[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix3[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(
        new float[] {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f},
        ((PDCalRGB) shadingColorSpace).getMatrix(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel,
   * AffineTransform, Matrix)}.
   *
   * <ul>
   *   <li>Given {@link PDLab#PDLab()}.
   *   <li>Then return RgbBackground is {@code 924193}.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1,
   * ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName(
      "Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); given PDLab(); then return RgbBackground is '924193'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"
  })
  void testNewType1ShadingContext_givenPDLab_thenReturnRgbBackgroundIs924193() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSFloat.ONE);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getBackground()).thenReturn(cosArray);
    PDLab pdLab = new PDLab();
    when(shading.getColorSpace()).thenReturn(pdLab);
    when(shading.getMatrix()).thenReturn(matrix);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    Type1ShadingContext actualType1ShadingContext =
        new Type1ShadingContext(shading, colorModel, xform, matrix2);

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray2).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    verify(matrix).createAffineTransform();
    verify(matrix2).createAffineTransform();
    assertEquals(924193, actualType1ShadingContext.getRgbBackground());
    assertSame(pdLab, actualType1ShadingContext.getShadingColorSpace());
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(
        new int[] {8, 8, 8, 8}, actualType1ShadingContext.getColorModel().getComponentSize());
  }

  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel,
   * AffineTransform, Matrix)}.
   *
   * <ul>
   *   <li>Then return Background is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1,
   * ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName(
      "Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); then return Background is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"
  })
  void testNewType1ShadingContext_thenReturnBackgroundIsNull() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSFloat.ONE);

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getDomain()).thenReturn(cosArray);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(new Matrix());
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    // Act
    Type1ShadingContext actualType1ShadingContext =
        new Type1ShadingContext(shading, colorModel, xform, new Matrix());

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    ColorModel colorModel2 = actualType1ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType1ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertNull(actualType1ShadingContext.getBackground());
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(
        new float[] {0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {1.0f}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel,
   * AffineTransform, Matrix)}.
   *
   * <ul>
   *   <li>Then return Domain is array of {@code float} with one.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1,
   * ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName(
      "Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); then return Domain is array of float with one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"
  })
  void testNewType1ShadingContext_thenReturnDomainIsArrayOfFloatWithOne() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = new COSArray(new ArrayList<>());
    cosArray2.add(COSFloat.ONE);

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(new Matrix());
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    // Act
    Type1ShadingContext actualType1ShadingContext =
        new Type1ShadingContext(shading, colorModel, xform, new Matrix());

    // Assert
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    ColorModel colorModel2 = actualType1ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType1ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(
        new float[] {0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {1.0f}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel,
   * AffineTransform, Matrix)}.
   *
   * <ul>
   *   <li>Then return RgbBackground is {@code 167149558}.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1,
   * ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName(
      "Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); then return RgbBackground is '167149558'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"
  })
  void testNewType1ShadingContext_thenReturnRgbBackgroundIs167149558() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSFloat.ONE);

    PDCalRGB pdCalRGB = new PDCalRGB();
    pdCalRGB.setWhitePoint(new PDTristimulus());

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(pdCalRGB);
    when(shading.getMatrix()).thenReturn(matrix);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    Type1ShadingContext actualType1ShadingContext =
        new Type1ShadingContext(shading, colorModel, xform, matrix2);

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray2).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    verify(matrix).createAffineTransform();
    verify(matrix2).createAffineTransform();
    ColorModel colorModel2 = actualType1ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType1ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDCalRGB);
    assertEquals(167149558, actualType1ShadingContext.getRgbBackground());
    assertArrayEquals(
        new float[] {0.0f, 0.0f, 0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(
        new float[] {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f},
        ((PDCalRGB) shadingColorSpace).getMatrix(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
  }
}
