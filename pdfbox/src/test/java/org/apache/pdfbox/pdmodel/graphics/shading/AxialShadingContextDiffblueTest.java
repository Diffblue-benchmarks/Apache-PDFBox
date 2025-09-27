package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
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
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AxialShadingContextDiffblueTest {
  /**
   * Test {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <p>Method under test: {@link AxialShadingContext#AxialShadingContext(PDShadingType2,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AxialShadingContext.<init>(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewAxialShadingContext() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSFloat.ONE);

    PDShadingType2 shading = mock(PDShadingType2.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(null);
    when(shading.getExtend()).thenReturn(null);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    AxialShadingContext actualAxialShadingContext =
        new AxialShadingContext(shading, colorModel, xform, matrix, new Rectangle());

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray).toFloatArray();
    verify(shading).evalFunction(0.0f);
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getCoords();
    verify(shading).getDomain();
    verify(shading).getExtend();
    ColorModel colorModel2 = actualAxialShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualAxialShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f}, actualAxialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getCoords(), 0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
    assertArrayEquals(new boolean[] {false, false}, actualAxialShadingContext.getExtend());
  }

  /**
   * Test {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <p>Method under test: {@link AxialShadingContext#AxialShadingContext(PDShadingType2,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AxialShadingContext.<init>(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewAxialShadingContext2() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSFloat.ONE);

    COSArray cosArray2 = new COSArray(new ArrayList<>());
    cosArray2.add(COSBoolean.FALSE);
    cosArray2.add((COSBase) new COSObject(COSBoolean.FALSE));

    PDShadingType2 shading = mock(PDShadingType2.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(null);
    when(shading.getExtend()).thenReturn(cosArray2);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    AxialShadingContext actualAxialShadingContext =
        new AxialShadingContext(shading, colorModel, xform, matrix, new Rectangle());

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray).toFloatArray();
    verify(shading).evalFunction(0.0f);
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getCoords();
    verify(shading).getDomain();
    verify(shading).getExtend();
    verify(matrix, atLeast(1)).createAffineTransform();
    ColorModel colorModel2 = actualAxialShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualAxialShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    float[][] matrix2 = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix2.length);
    assertArrayEquals(
        new float[] {0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f}, actualAxialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix2[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix2[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix2[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getCoords(), 0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
    assertArrayEquals(new boolean[] {false, false}, actualAxialShadingContext.getExtend());
  }

  /**
   * Test {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Given {@link AffineTransform#AffineTransform()}.
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link AxialShadingContext#AxialShadingContext(PDShadingType2,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle); given AffineTransform(); then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AxialShadingContext.<init>(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewAxialShadingContext_givenAffineTransform_thenReturnArrayLengthIsThree()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSFloat.ONE);

    PDShadingType2 shading = mock(PDShadingType2.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(null);
    when(shading.getExtend()).thenReturn(null);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    AxialShadingContext actualAxialShadingContext =
        new AxialShadingContext(shading, colorModel, xform, matrix, new Rectangle());

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray).toFloatArray();
    verify(shading).evalFunction(0.0f);
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getCoords();
    verify(shading).getDomain();
    verify(shading).getExtend();
    verify(matrix, atLeast(1)).createAffineTransform();
    ColorModel colorModel2 = actualAxialShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualAxialShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    float[][] matrix2 = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix2.length);
    assertArrayEquals(
        new float[] {0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f}, actualAxialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix2[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix2[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix2[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getCoords(), 0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
    assertArrayEquals(new boolean[] {false, false}, actualAxialShadingContext.getExtend());
  }

  /**
   * Test {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link AxialShadingContext#AxialShadingContext(PDShadingType2,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AxialShadingContext.<init>(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewAxialShadingContext_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSFloat.ONE);

    PDShadingType2 shading = mock(PDShadingType2.class);
    when(shading.evalFunction(anyFloat())).thenThrow(new IOException());
    when(shading.getDomain()).thenReturn(null);
    when(shading.getExtend()).thenReturn(null);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> new AxialShadingContext(shading, colorModel, xform, matrix, new Rectangle()));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray).toFloatArray();
    verify(shading).evalFunction(0.0f);
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getCoords();
    verify(shading).getDomain();
    verify(shading).getExtend();
  }

  /**
   * Test {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Given {@link PDCalGray#PDCalGray()}.
   *   <li>Then return ShadingColorSpace is {@link PDCalGray#PDCalGray()}.
   * </ul>
   *
   * <p>Method under test: {@link AxialShadingContext#AxialShadingContext(PDShadingType2,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle); given PDCalGray(); then return ShadingColorSpace is PDCalGray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AxialShadingContext.<init>(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewAxialShadingContext_givenPDCalGray_thenReturnShadingColorSpaceIsPDCalGray()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSFloat.ONE);

    PDShadingType2 shading = mock(PDShadingType2.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(null);
    when(shading.getExtend()).thenReturn(null);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    PDCalGray pdCalGray = new PDCalGray();
    when(shading.getColorSpace()).thenReturn(pdCalGray);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    AxialShadingContext actualAxialShadingContext =
        new AxialShadingContext(shading, colorModel, xform, matrix, new Rectangle());

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray).toFloatArray();
    verify(shading).evalFunction(0.0f);
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getCoords();
    verify(shading).getDomain();
    verify(shading).getExtend();
    verify(matrix, atLeast(1)).createAffineTransform();
    assertSame(pdCalGray, actualAxialShadingContext.getShadingColorSpace());
    assertArrayEquals(new float[] {0.0f, 1.0f}, actualAxialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getCoords(), 0.0f);
    assertArrayEquals(
        new int[] {8, 8, 8, 8}, actualAxialShadingContext.getColorModel().getComponentSize());
    assertArrayEquals(new boolean[] {false, false}, actualAxialShadingContext.getExtend());
  }

  /**
   * Test {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Given {@link PDCalRGB#PDCalRGB()}.
   *   <li>Then return ShadingColorSpace is {@link PDCalRGB#PDCalRGB()}.
   * </ul>
   *
   * <p>Method under test: {@link AxialShadingContext#AxialShadingContext(PDShadingType2,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle); given PDCalRGB(); then return ShadingColorSpace is PDCalRGB()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AxialShadingContext.<init>(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewAxialShadingContext_givenPDCalRGB_thenReturnShadingColorSpaceIsPDCalRGB()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSFloat.ONE);

    PDShadingType2 shading = mock(PDShadingType2.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(null);
    when(shading.getExtend()).thenReturn(null);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    PDCalRGB pdCalRGB = new PDCalRGB();
    when(shading.getColorSpace()).thenReturn(pdCalRGB);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    AxialShadingContext actualAxialShadingContext =
        new AxialShadingContext(shading, colorModel, xform, matrix, new Rectangle());

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray).toFloatArray();
    verify(shading).evalFunction(0.0f);
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getCoords();
    verify(shading).getDomain();
    verify(shading).getExtend();
    verify(matrix, atLeast(1)).createAffineTransform();
    assertSame(pdCalRGB, actualAxialShadingContext.getShadingColorSpace());
    assertArrayEquals(new float[] {0.0f, 1.0f}, actualAxialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getCoords(), 0.0f);
    assertArrayEquals(
        new int[] {8, 8, 8, 8}, actualAxialShadingContext.getColorModel().getComponentSize());
    assertArrayEquals(new boolean[] {false, false}, actualAxialShadingContext.getExtend());
  }

  /**
   * Test {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AxialShadingContext#AxialShadingContext(PDShadingType2,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle); then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AxialShadingContext.<init>(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewAxialShadingContext_thenCallsGetObject() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSFloat.ONE);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.getObject(anyInt())).thenReturn(COSBoolean.FALSE);

    PDShadingType2 shading = mock(PDShadingType2.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getExtend()).thenReturn(cosArray3);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    AxialShadingContext actualAxialShadingContext =
        new AxialShadingContext(shading, colorModel, xform, matrix, new Rectangle());

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray3, atLeast(1)).getObject(anyInt());
    verify(cosArray2).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(shading).evalFunction(10.0f);
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getCoords();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getExtend();
    verify(matrix, atLeast(1)).createAffineTransform();
    ColorModel colorModel2 = actualAxialShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualAxialShadingContext.getShadingColorSpace();
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
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getCoords(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
    assertArrayEquals(new boolean[] {false, false}, actualAxialShadingContext.getExtend());
  }

  /**
   * Test {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link AxialShadingContext#AxialShadingContext(PDShadingType2,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle); then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AxialShadingContext.<init>(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewAxialShadingContext_thenReturnArrayLengthIsThree() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSFloat.ONE);

    COSArray cosArray2 = new COSArray(new ArrayList<>());
    cosArray2.add(COSBoolean.FALSE);
    cosArray2.add(COSFloat.ONE);

    PDShadingType2 shading = mock(PDShadingType2.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getExtend()).thenReturn(null);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    AxialShadingContext actualAxialShadingContext =
        new AxialShadingContext(shading, colorModel, xform, matrix, new Rectangle());

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray).toFloatArray();
    verify(shading).evalFunction(0.0f);
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getCoords();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getExtend();
    verify(matrix, atLeast(1)).createAffineTransform();
    ColorModel colorModel2 = actualAxialShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualAxialShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    float[][] matrix2 = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix2.length);
    assertArrayEquals(
        new float[] {0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f}, actualAxialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix2[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix2[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix2[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getCoords(), 0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
    assertArrayEquals(new boolean[] {false, false}, actualAxialShadingContext.getExtend());
  }

  /**
   * Test {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link AxialShadingContext#AxialShadingContext(PDShadingType2,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle); then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AxialShadingContext.<init>(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewAxialShadingContext_thenReturnArrayLengthIsThree2() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSFloat.ONE);

    COSArray cosArray2 = new COSArray(new ArrayList<>());
    cosArray2.add(COSBoolean.FALSE);
    cosArray2.add(COSBoolean.FALSE);

    PDShadingType2 shading = mock(PDShadingType2.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(null);
    when(shading.getExtend()).thenReturn(cosArray2);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    AxialShadingContext actualAxialShadingContext =
        new AxialShadingContext(shading, colorModel, xform, matrix, new Rectangle());

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray).toFloatArray();
    verify(shading).evalFunction(0.0f);
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getCoords();
    verify(shading).getDomain();
    verify(shading).getExtend();
    verify(matrix, atLeast(1)).createAffineTransform();
    ColorModel colorModel2 = actualAxialShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualAxialShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    float[][] matrix2 = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix2.length);
    assertArrayEquals(
        new float[] {0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f}, actualAxialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new float[] {0.013916016f, 0.09713745f, 0.71383667f}, matrix2[2], 0.0f);
    assertArrayEquals(new float[] {0.22238159f, 0.717041f, 0.06059265f}, matrix2[1], 0.0f);
    assertArrayEquals(new float[] {0.43585205f, 0.3853302f, 0.14302063f}, matrix2[0], 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getCoords(), 0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
    assertArrayEquals(new boolean[] {false, false}, actualAxialShadingContext.getExtend());
  }

  /**
   * Test {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Then return Domain is array of {@code float} with ten and {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link AxialShadingContext#AxialShadingContext(PDShadingType2,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle); then return Domain is array of float with ten and '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AxialShadingContext.<init>(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewAxialShadingContext_thenReturnDomainIsArrayOfFloatWithTenAnd05() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSFloat.ONE);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDShadingType2 shading = mock(PDShadingType2.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getExtend()).thenReturn(null);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    AxialShadingContext actualAxialShadingContext =
        new AxialShadingContext(shading, colorModel, xform, matrix, new Rectangle());

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(shading).evalFunction(10.0f);
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getCoords();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getExtend();
    verify(matrix, atLeast(1)).createAffineTransform();
    ColorModel colorModel2 = actualAxialShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualAxialShadingContext.getShadingColorSpace();
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
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getCoords(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
    assertArrayEquals(new boolean[] {false, false}, actualAxialShadingContext.getExtend());
  }

  /**
   * Test {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>When {@link Rectangle#Rectangle(int, int)} with one thousand and one thousand.
   * </ul>
   *
   * <p>Method under test: {@link AxialShadingContext#AxialShadingContext(PDShadingType2,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle); when Rectangle(int, int) with one thousand and one thousand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AxialShadingContext.<init>(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewAxialShadingContext_whenRectangleWithOneThousandAndOneThousand() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSFloat.ONE);

    PDShadingType2 shading = mock(PDShadingType2.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(null);
    when(shading.getExtend()).thenReturn(null);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    AxialShadingContext actualAxialShadingContext =
        new AxialShadingContext(shading, colorModel, xform, matrix, new Rectangle(1000, 1000));

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray).toFloatArray();
    verify(shading, atLeast(1)).evalFunction(anyFloat());
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getCoords();
    verify(shading).getDomain();
    verify(shading).getExtend();
    verify(matrix, atLeast(1)).createAffineTransform();
    ColorModel colorModel2 = actualAxialShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualAxialShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f}, actualAxialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getCoords(), 0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
    assertArrayEquals(new boolean[] {false, false}, actualAxialShadingContext.getExtend());
  }
}
