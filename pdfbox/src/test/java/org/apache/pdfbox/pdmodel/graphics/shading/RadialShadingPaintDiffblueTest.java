package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.color.ICC_ProfileRGB;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RadialShadingPaintDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RadialShadingPaint#RadialShadingPaint(PDShadingType3, Matrix)}
   *   <li>{@link RadialShadingPaint#getTransparency()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RadialShadingPaint.<init>(PDShadingType3, Matrix)",
    "int RadialShadingPaint.getTransparency()"
  })
  void testGettersAndSetters() {
    // Arrange
    PDShadingType3 shading = new PDShadingType3(new COSDictionary());
    Matrix matrix = new Matrix();

    // Act
    RadialShadingPaint actualRadialShadingPaint = new RadialShadingPaint(shading, matrix);

    // Assert
    assertEquals(0, actualRadialShadingPaint.getTransparency());
    assertSame(shading, actualRadialShadingPaint.getShading());
    assertSame(matrix, actualRadialShadingPaint.getMatrix());
  }

  /**
   * Test {@link RadialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D,
   * AffineTransform, RenderingHints)}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType3} {@link PDShadingType3#evalFunction(float)} throw {@link
   *       IOException#IOException()}.
   *   <li>Then calls {@link COSArray#add(COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link RadialShadingPaint#createContext(ColorModel, Rectangle,
   * Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName(
      "Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); given PDShadingType3 evalFunction(float) throw IOException(); then calls add(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaintContext RadialShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"
  })
  void testCreateContext_givenPDShadingType3EvalFunctionThrowIOException_thenCallsAdd()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray())
        .thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray3).add(Mockito.<COSObjectable>any());
    cosArray3.add(mock(COSObjectable.class));

    PDShadingType3 shading = mock(PDShadingType3.class);
    when(shading.evalFunction(anyFloat())).thenThrow(new IOException());
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getExtend()).thenReturn(cosArray3);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    RadialShadingPaint radialShadingPaint = new RadialShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    Rectangle deviceBounds = new Rectangle();
    Double userBounds = new Double();

    // Act
    radialShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray3).add(isA(COSObjectable.class));
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
   * Test {@link RadialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D,
   * AffineTransform, RenderingHints)}.
   *
   * <ul>
   *   <li>Then ColorModel ColorSpace return {@link ICC_ColorSpace}.
   * </ul>
   *
   * <p>Method under test: {@link RadialShadingPaint#createContext(ColorModel, Rectangle,
   * Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName(
      "Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then ColorModel ColorSpace return ICC_ColorSpace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaintContext RadialShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"
  })
  void testCreateContext_thenColorModelColorSpaceReturnICC_ColorSpace() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray())
        .thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray3).add(Mockito.<COSObjectable>any());
    cosArray3.add(mock(COSObjectable.class));

    PDShadingType3 shading = mock(PDShadingType3.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getExtend()).thenReturn(cosArray3);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    RadialShadingPaint radialShadingPaint = new RadialShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    Rectangle deviceBounds = new Rectangle();
    Double userBounds = new Double();

    // Act
    PaintContext actualCreateContextResult =
        radialShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray3).add(isA(COSObjectable.class));
    verify(cosArray3, atLeast(1)).getObject(anyInt());
    verify(cosArray2).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(shading).evalFunction(10.0f);
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getCoords();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getExtend();
    ColorModel colorModel = actualCreateContextResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace =
        ((RadialShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof RadialShadingContext);
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getDomain(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getCoords(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(
        new boolean[] {false, false},
        ((RadialShadingContext) actualCreateContextResult).getExtend());
  }

  /**
   * Test {@link RadialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D,
   * AffineTransform, RenderingHints)}.
   *
   * <ul>
   *   <li>Then ColorModel ColorSpace return {@link ICC_ColorSpace}.
   * </ul>
   *
   * <p>Method under test: {@link RadialShadingPaint#createContext(ColorModel, Rectangle,
   * Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName(
      "Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then ColorModel ColorSpace return ICC_ColorSpace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaintContext RadialShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"
  })
  void testCreateContext_thenColorModelColorSpaceReturnICC_ColorSpace2() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray())
        .thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray3).add(Mockito.<COSObjectable>any());
    cosArray3.add(mock(COSObjectable.class));

    PDShadingType3 shading = mock(PDShadingType3.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getExtend()).thenReturn(cosArray3);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    RadialShadingPaint radialShadingPaint = new RadialShadingPaint(shading, matrix);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    Rectangle deviceBounds = new Rectangle();
    Double userBounds = new Double();

    // Act
    PaintContext actualCreateContextResult =
        radialShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray3).add(isA(COSObjectable.class));
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
    ColorModel colorModel = actualCreateContextResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace =
        ((RadialShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof RadialShadingContext);
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getDomain(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getCoords(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(
        new boolean[] {false, false},
        ((RadialShadingContext) actualCreateContextResult).getExtend());
  }

  /**
   * Test {@link RadialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D,
   * AffineTransform, RenderingHints)}.
   *
   * <ul>
   *   <li>Then return ShadingColorSpace is {@link PDCalRGB#PDCalRGB()}.
   * </ul>
   *
   * <p>Method under test: {@link RadialShadingPaint#createContext(ColorModel, Rectangle,
   * Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName(
      "Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return ShadingColorSpace is PDCalRGB()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaintContext RadialShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"
  })
  void testCreateContext_thenReturnShadingColorSpaceIsPDCalRGB() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray())
        .thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray3).add(Mockito.<COSObjectable>any());
    cosArray3.add(mock(COSObjectable.class));

    PDShadingType3 shading = mock(PDShadingType3.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getExtend()).thenReturn(cosArray3);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    PDCalRGB pdCalRGB = new PDCalRGB();
    when(shading.getColorSpace()).thenReturn(pdCalRGB);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    RadialShadingPaint radialShadingPaint = new RadialShadingPaint(shading, matrix);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    Rectangle deviceBounds = new Rectangle();
    Double userBounds = new Double();

    // Act
    PaintContext actualCreateContextResult =
        radialShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray3).add(isA(COSObjectable.class));
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
    assertTrue(actualCreateContextResult instanceof RadialShadingContext);
    assertSame(pdCalRGB, ((RadialShadingContext) actualCreateContextResult).getShadingColorSpace());
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getDomain(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getCoords(),
        0.0f);
    assertArrayEquals(
        new int[] {8, 8, 8, 8}, actualCreateContextResult.getColorModel().getComponentSize());
    assertArrayEquals(
        new boolean[] {false, false},
        ((RadialShadingContext) actualCreateContextResult).getExtend());
  }

  /**
   * Test {@link RadialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D,
   * AffineTransform, RenderingHints)}.
   *
   * <ul>
   *   <li>When {@link Rectangle#Rectangle(int, int)} with one thousand and one thousand.
   * </ul>
   *
   * <p>Method under test: {@link RadialShadingPaint#createContext(ColorModel, Rectangle,
   * Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName(
      "Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); when Rectangle(int, int) with one thousand and one thousand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaintContext RadialShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"
  })
  void testCreateContext_whenRectangleWithOneThousandAndOneThousand() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray())
        .thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray3).add(Mockito.<COSObjectable>any());
    cosArray3.add(mock(COSObjectable.class));

    PDShadingType3 shading = mock(PDShadingType3.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getExtend()).thenReturn(cosArray3);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getCoords()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    RadialShadingPaint radialShadingPaint = new RadialShadingPaint(shading, matrix);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    Rectangle deviceBounds = new Rectangle(1000, 1000);
    Double userBounds = new Double();

    // Act
    PaintContext actualCreateContextResult =
        radialShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray3).add(isA(COSObjectable.class));
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
    ColorModel colorModel = actualCreateContextResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace =
        ((RadialShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof RadialShadingContext);
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getDomain(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getCoords(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(
        new boolean[] {false, false},
        ((RadialShadingContext) actualCreateContextResult).getExtend());
  }
}
