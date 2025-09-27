package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
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

class RadialShadingContextDiffblueTest {
  /**
   * Test {@link RadialShadingContext#RadialShadingContext(PDShadingType3, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link RadialShadingContext#RadialShadingContext(PDShadingType3,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new RadialShadingContext(PDShadingType3, ColorModel, AffineTransform, Matrix, Rectangle); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RadialShadingContext.<init>(PDShadingType3, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewRadialShadingContext_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray())
        .thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.getObject(anyInt())).thenReturn(COSBoolean.FALSE);

    PDShadingType3 shading = mock(PDShadingType3.class);
    when(shading.evalFunction(anyFloat())).thenThrow(new IOException());
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getExtend()).thenReturn(cosArray3);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> new RadialShadingContext(shading, colorModel, xform, matrix, new Rectangle()));
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
  }

  /**
   * Test {@link RadialShadingContext#RadialShadingContext(PDShadingType3, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Given {@link PDCalRGB#PDCalRGB()}.
   *   <li>Then return ShadingColorSpace is {@link PDCalRGB#PDCalRGB()}.
   * </ul>
   *
   * <p>Method under test: {@link RadialShadingContext#RadialShadingContext(PDShadingType3,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new RadialShadingContext(PDShadingType3, ColorModel, AffineTransform, Matrix, Rectangle); given PDCalRGB(); then return ShadingColorSpace is PDCalRGB()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RadialShadingContext.<init>(PDShadingType3, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewRadialShadingContext_givenPDCalRGB_thenReturnShadingColorSpaceIsPDCalRGB()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray())
        .thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.getObject(anyInt())).thenReturn(COSBoolean.FALSE);

    PDShadingType3 shading = mock(PDShadingType3.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getExtend()).thenReturn(cosArray3);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    PDCalRGB pdCalRGB = new PDCalRGB();
    when(shading.getColorSpace()).thenReturn(pdCalRGB);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    RadialShadingContext actualRadialShadingContext =
        new RadialShadingContext(shading, colorModel, xform, matrix, new Rectangle());

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
    assertSame(pdCalRGB, actualRadialShadingContext.getShadingColorSpace());
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualRadialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f},
        actualRadialShadingContext.getCoords(),
        0.0f);
    assertArrayEquals(
        new int[] {8, 8, 8, 8}, actualRadialShadingContext.getColorModel().getComponentSize());
    assertArrayEquals(new boolean[] {false, false}, actualRadialShadingContext.getExtend());
  }

  /**
   * Test {@link RadialShadingContext#RadialShadingContext(PDShadingType3, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Then ColorModel ColorSpace return {@link ICC_ColorSpace}.
   * </ul>
   *
   * <p>Method under test: {@link RadialShadingContext#RadialShadingContext(PDShadingType3,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new RadialShadingContext(PDShadingType3, ColorModel, AffineTransform, Matrix, Rectangle); then ColorModel ColorSpace return ICC_ColorSpace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RadialShadingContext.<init>(PDShadingType3, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewRadialShadingContext_thenColorModelColorSpaceReturnICC_ColorSpace()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray())
        .thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.getObject(anyInt())).thenReturn(COSBoolean.FALSE);

    PDShadingType3 shading = mock(PDShadingType3.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getExtend()).thenReturn(cosArray3);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    RadialShadingContext actualRadialShadingContext =
        new RadialShadingContext(shading, colorModel, xform, matrix, new Rectangle());

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
    ColorModel colorModel2 = actualRadialShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualRadialShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualRadialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f},
        actualRadialShadingContext.getCoords(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
    assertArrayEquals(new boolean[] {false, false}, actualRadialShadingContext.getExtend());
  }

  /**
   * Test {@link RadialShadingContext#RadialShadingContext(PDShadingType3, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Then ColorModel ColorSpace return {@link ICC_ColorSpace}.
   * </ul>
   *
   * <p>Method under test: {@link RadialShadingContext#RadialShadingContext(PDShadingType3,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new RadialShadingContext(PDShadingType3, ColorModel, AffineTransform, Matrix, Rectangle); then ColorModel ColorSpace return ICC_ColorSpace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RadialShadingContext.<init>(PDShadingType3, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewRadialShadingContext_thenColorModelColorSpaceReturnICC_ColorSpace2()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray())
        .thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.getObject(anyInt())).thenReturn(COSBoolean.FALSE);

    PDShadingType3 shading = mock(PDShadingType3.class);
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
    RadialShadingContext actualRadialShadingContext =
        new RadialShadingContext(shading, colorModel, xform, matrix, new Rectangle());

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
    ColorModel colorModel2 = actualRadialShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualRadialShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualRadialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f},
        actualRadialShadingContext.getCoords(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
    assertArrayEquals(new boolean[] {false, false}, actualRadialShadingContext.getExtend());
  }

  /**
   * Test {@link RadialShadingContext#RadialShadingContext(PDShadingType3, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>Then return ShadingColorSpace is {@link PDCalGray#PDCalGray()}.
   * </ul>
   *
   * <p>Method under test: {@link RadialShadingContext#RadialShadingContext(PDShadingType3,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new RadialShadingContext(PDShadingType3, ColorModel, AffineTransform, Matrix, Rectangle); then return ShadingColorSpace is PDCalGray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RadialShadingContext.<init>(PDShadingType3, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewRadialShadingContext_thenReturnShadingColorSpaceIsPDCalGray() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray())
        .thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.getObject(anyInt())).thenReturn(COSBoolean.FALSE);

    PDShadingType3 shading = mock(PDShadingType3.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getExtend()).thenReturn(cosArray3);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    PDCalGray pdCalGray = new PDCalGray();
    when(shading.getColorSpace()).thenReturn(pdCalGray);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    // Act
    RadialShadingContext actualRadialShadingContext =
        new RadialShadingContext(shading, colorModel, xform, matrix, new Rectangle());

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
    assertSame(pdCalGray, actualRadialShadingContext.getShadingColorSpace());
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualRadialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f},
        actualRadialShadingContext.getCoords(),
        0.0f);
    assertArrayEquals(
        new int[] {8, 8, 8, 8}, actualRadialShadingContext.getColorModel().getComponentSize());
    assertArrayEquals(new boolean[] {false, false}, actualRadialShadingContext.getExtend());
  }

  /**
   * Test {@link RadialShadingContext#RadialShadingContext(PDShadingType3, ColorModel,
   * AffineTransform, Matrix, Rectangle)}.
   *
   * <ul>
   *   <li>When {@link Rectangle#Rectangle(int, int)} with one thousand and one thousand.
   * </ul>
   *
   * <p>Method under test: {@link RadialShadingContext#RadialShadingContext(PDShadingType3,
   * ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName(
      "Test new RadialShadingContext(PDShadingType3, ColorModel, AffineTransform, Matrix, Rectangle); when Rectangle(int, int) with one thousand and one thousand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RadialShadingContext.<init>(PDShadingType3, ColorModel, AffineTransform, Matrix, Rectangle)"
  })
  void testNewRadialShadingContext_whenRectangleWithOneThousandAndOneThousand() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray())
        .thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.getObject(anyInt())).thenReturn(COSBoolean.FALSE);

    PDShadingType3 shading = mock(PDShadingType3.class);
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
    RadialShadingContext actualRadialShadingContext =
        new RadialShadingContext(shading, colorModel, xform, matrix, new Rectangle(1000, 1000));

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray3, atLeast(1)).getObject(anyInt());
    verify(cosArray2).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(shading, atLeast(1)).evalFunction(anyFloat());
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getCoords();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getExtend();
    verify(matrix, atLeast(1)).createAffineTransform();
    ColorModel colorModel2 = actualRadialShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualRadialShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualRadialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f},
        actualRadialShadingContext.getCoords(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel2.getComponentSize());
    assertArrayEquals(new boolean[] {false, false}, actualRadialShadingContext.getExtend());
  }
}
