package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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
import java.util.ArrayList;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.pdfparser.COSParser;
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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Type4ShadingPaint#Type4ShadingPaint(PDShadingType4, Matrix)}
   *   <li>{@link Type4ShadingPaint#getTransparency()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type4ShadingPaint.<init>(PDShadingType4, Matrix)",
    "int Type4ShadingPaint.getTransparency()"
  })
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
   * Test {@link Type4ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D,
   * AffineTransform, RenderingHints)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link Type4ShadingPaint#createContext(ColorModel, Rectangle,
   * Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName(
      "Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); given COSArray() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaintContext Type4ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"
  })
  void testCreateContext_givenCOSArrayAddFalse() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    Type4ShadingPaint type4ShadingPaint = new Type4ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    Rectangle deviceBounds = new Rectangle();
    Double userBounds = new Double();

    // Act
    PaintContext actualCreateContextResult =
        type4ShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    ColorModel colorModel = actualCreateContextResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace =
        ((Type4ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type4ShadingContext);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(
        new float[] {0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f},
        ((Type4ShadingContext) actualCreateContextResult).getBackground(),
        0.0f);
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
   * Test {@link Type4ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D,
   * AffineTransform, RenderingHints)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one thousand and gen is
   *       one thousand.
   * </ul>
   *
   * <p>Method under test: {@link Type4ShadingPaint#createContext(ColorModel, Rectangle,
   * Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName(
      "Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); given COSObjectKey(long, int) with num is one thousand and gen is one thousand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaintContext Type4ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"
  })
  void testCreateContext_givenCOSObjectKeyWithNumIsOneThousandAndGenIsOneThousand()
      throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObjectKey key = new COSObjectKey(1000L, 1000);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    cosArray.add((COSBase) object);

    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    Type4ShadingPaint type4ShadingPaint = new Type4ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    Rectangle deviceBounds = new Rectangle();
    Double userBounds = new Double();

    // Act
    PaintContext actualCreateContextResult =
        type4ShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    ColorModel colorModel = actualCreateContextResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace =
        ((Type4ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type4ShadingContext);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(
        new float[] {0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f},
        ((Type4ShadingContext) actualCreateContextResult).getBackground(),
        0.0f);
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
   * Test {@link Type4ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D,
   * AffineTransform, RenderingHints)}.
   *
   * <ul>
   *   <li>Then return Background is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Type4ShadingPaint#createContext(ColorModel, Rectangle,
   * Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName(
      "Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return Background is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaintContext Type4ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"
  })
  void testCreateContext_thenReturnBackgroundIsNull() throws IOException {
    // Arrange
    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    Type4ShadingPaint type4ShadingPaint = new Type4ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    Rectangle deviceBounds = new Rectangle();
    Double userBounds = new Double();

    // Act
    PaintContext actualCreateContextResult =
        type4ShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    ColorModel colorModel = actualCreateContextResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace =
        ((Type4ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type4ShadingContext);
    assertNull(((Type4ShadingContext) actualCreateContextResult).getBackground());
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
}
