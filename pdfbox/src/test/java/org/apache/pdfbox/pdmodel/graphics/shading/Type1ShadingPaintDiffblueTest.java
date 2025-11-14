package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
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
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Type1ShadingPaintDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Type1ShadingPaint#Type1ShadingPaint(PDShadingType1, Matrix)}
   *   <li>{@link Type1ShadingPaint#getTransparency()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type1ShadingPaint.<init>(PDShadingType1, Matrix)",
    "int Type1ShadingPaint.getTransparency()"
  })
  void testGettersAndSetters() {
    // Arrange
    PDShadingType1 shading = new PDShadingType1(new COSDictionary());
    Matrix matrix = new Matrix();

    // Act
    Type1ShadingPaint actualType1ShadingPaint = new Type1ShadingPaint(shading, matrix);

    // Assert
    assertEquals(0, actualType1ShadingPaint.getTransparency());
    assertSame(shading, actualType1ShadingPaint.getShading());
    assertSame(matrix, actualType1ShadingPaint.getMatrix());
  }

  /**
   * Test {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D,
   * AffineTransform, RenderingHints)}.
   *
   * <p>Method under test: {@link Type1ShadingPaint#createContext(ColorModel, Rectangle,
   * Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName(
      "Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaintContext Type1ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"
  })
  void testCreateContext() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(matrix);

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.createAffineTransform()).thenReturn(new AffineTransform());

    Type1ShadingPaint type1ShadingPaint = new Type1ShadingPaint(shading, matrix2);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    Rectangle deviceBounds = new Rectangle();
    Double userBounds = new Double();

    // Act
    PaintContext actualCreateContextResult =
        type1ShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    verify(matrix).createAffineTransform();
    verify(matrix2).createAffineTransform();
    ColorModel colorModel = actualCreateContextResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace =
        ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getBackground(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getDomain(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D,
   * AffineTransform, RenderingHints)}.
   *
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#toRGB(float[])} throw {@link
   *       IOException#IOException()}.
   *   <li>Then calls {@link PDColorSpace#toRGB(float[])}.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingPaint#createContext(ColorModel, Rectangle,
   * Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName(
      "Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); given PDColorSpace toRGB(float[]) throw IOException(); then calls toRGB(float[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaintContext Type1ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"
  })
  void testCreateContext_givenPDColorSpaceToRGBThrowIOException_thenCallsToRGB()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColorSpace pdColorSpace = mock(PDColorSpace.class);
    when(pdColorSpace.toRGB(Mockito.<float[]>any())).thenThrow(new IOException());

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(pdColorSpace);
    Type1ShadingPaint type1ShadingPaint = new Type1ShadingPaint(shading, mock(Matrix.class));
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    Rectangle deviceBounds = new Rectangle();
    Double userBounds = new Double();

    // Act
    type1ShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(cosArray).toFloatArray();
    verify(pdColorSpace).toRGB(isA(float[].class));
    verify(shading).getBackground();
    verify(shading).getColorSpace();
  }

  /**
   * Test {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D,
   * AffineTransform, RenderingHints)}.
   *
   * <ul>
   *   <li>Then calls {@link Matrix#createAffineTransform()}.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingPaint#createContext(ColorModel, Rectangle,
   * Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName(
      "Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then calls createAffineTransform()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaintContext Type1ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"
  })
  void testCreateContext_thenCallsCreateAffineTransform() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(matrix);
    Type1ShadingPaint type1ShadingPaint = new Type1ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    Rectangle deviceBounds = new Rectangle();
    Double userBounds = new Double();

    // Act
    PaintContext actualCreateContextResult =
        type1ShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    verify(matrix).createAffineTransform();
    ColorModel colorModel = actualCreateContextResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace =
        ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
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
        new float[] {10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getBackground(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getDomain(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D,
   * AffineTransform, RenderingHints)}.
   *
   * <ul>
   *   <li>Then return Background is array of {@code float} with zero and one.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingPaint#createContext(ColorModel, Rectangle,
   * Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName(
      "Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return Background is array of float with zero and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaintContext Type1ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"
  })
  void testCreateContext_thenReturnBackgroundIsArrayOfFloatWithZeroAndOne() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSFloat.ONE);

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(new COSArray());
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(new Matrix());
    Type1ShadingPaint type1ShadingPaint = new Type1ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    Rectangle deviceBounds = new Rectangle();
    Double userBounds = new Double();

    // Act
    PaintContext actualCreateContextResult =
        type1ShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    ColorModel colorModel = actualCreateContextResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace =
        ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(
        new float[] {}, ((Type1ShadingContext) actualCreateContextResult).getDomain(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f, 1.0f},
        ((Type1ShadingContext) actualCreateContextResult).getBackground(),
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
   * Test {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D,
   * AffineTransform, RenderingHints)}.
   *
   * <ul>
   *   <li>Then return Background is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingPaint#createContext(ColorModel, Rectangle,
   * Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName(
      "Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return Background is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaintContext Type1ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"
  })
  void testCreateContext_thenReturnBackgroundIsNull() throws IOException {
    // Arrange
    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getDomain()).thenReturn(new COSArray());
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(new Matrix());
    Type1ShadingPaint type1ShadingPaint = new Type1ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    Rectangle deviceBounds = new Rectangle();
    Double userBounds = new Double();

    // Act
    PaintContext actualCreateContextResult =
        type1ShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    ColorModel colorModel = actualCreateContextResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace =
        ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    assertNull(((Type1ShadingContext) actualCreateContextResult).getBackground());
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(
        new float[] {}, ((Type1ShadingContext) actualCreateContextResult).getDomain(), 0.0f);
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
   * Test {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D,
   * AffineTransform, RenderingHints)}.
   *
   * <ul>
   *   <li>Then return Domain is array of {@code float} with ten and {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingPaint#createContext(ColorModel, Rectangle,
   * Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName(
      "Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return Domain is array of float with ten and '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaintContext Type1ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"
  })
  void testCreateContext_thenReturnDomainIsArrayOfFloatWithTenAnd05() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(new Matrix());
    Type1ShadingPaint type1ShadingPaint = new Type1ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    Rectangle deviceBounds = new Rectangle();
    Double userBounds = new Double();

    // Act
    PaintContext actualCreateContextResult =
        type1ShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    ColorModel colorModel = actualCreateContextResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace =
        ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
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
        new float[] {10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getBackground(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getDomain(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D,
   * AffineTransform, RenderingHints)}.
   *
   * <ul>
   *   <li>Then return Domain is array of {@code float} with zero and one.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingPaint#createContext(ColorModel, Rectangle,
   * Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName(
      "Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return Domain is array of float with zero and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaintContext Type1ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"
  })
  void testCreateContext_thenReturnDomainIsArrayOfFloatWithZeroAndOne() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(new Matrix());
    Type1ShadingPaint type1ShadingPaint = new Type1ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    Rectangle deviceBounds = new Rectangle();
    Double userBounds = new Double();

    // Act
    PaintContext actualCreateContextResult =
        type1ShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getDomain();
    verify(shading).getMatrix();
    ColorModel colorModel = actualCreateContextResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace =
        ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
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
        new float[] {0.0f, 1.0f, 0.0f, 1.0f},
        ((Type1ShadingContext) actualCreateContextResult).getDomain(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getBackground(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D,
   * AffineTransform, RenderingHints)}.
   *
   * <ul>
   *   <li>Then return Domain is empty array of {@code float}.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingPaint#createContext(ColorModel, Rectangle,
   * Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName(
      "Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return Domain is empty array of float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaintContext Type1ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"
  })
  void testCreateContext_thenReturnDomainIsEmptyArrayOfFloat() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(new COSArray());
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(new Matrix());
    Type1ShadingPaint type1ShadingPaint = new Type1ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    Rectangle deviceBounds = new Rectangle();
    Double userBounds = new Double();

    // Act
    PaintContext actualCreateContextResult =
        type1ShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    ColorModel colorModel = actualCreateContextResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace =
        ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(
        new float[] {}, ((Type1ShadingContext) actualCreateContextResult).getDomain(), 0.0f);
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
        new float[] {10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getBackground(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D,
   * AffineTransform, RenderingHints)}.
   *
   * <ul>
   *   <li>Then return RgbBackground is {@code 64000}.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingPaint#createContext(ColorModel, Rectangle,
   * Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName(
      "Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return RgbBackground is '64000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaintContext Type1ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"
  })
  void testCreateContext_thenReturnRgbBackgroundIs64000() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(cosArray2);
    PDCalRGB pdCalRGB = new PDCalRGB();
    when(shading.getColorSpace()).thenReturn(pdCalRGB);
    when(shading.getMatrix()).thenReturn(matrix);

    Matrix matrix2 = mock(Matrix.class);
    when(matrix2.createAffineTransform()).thenReturn(new AffineTransform());

    Type1ShadingPaint type1ShadingPaint = new Type1ShadingPaint(shading, matrix2);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    Rectangle deviceBounds = new Rectangle();
    Double userBounds = new Double();

    // Act
    PaintContext actualCreateContextResult =
        type1ShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    verify(matrix).createAffineTransform();
    verify(matrix2).createAffineTransform();
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    assertEquals(64000, ((Type1ShadingContext) actualCreateContextResult).getRgbBackground());
    assertSame(pdCalRGB, ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace());
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getBackground(),
        0.0f);
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getDomain(),
        0.0f);
    assertArrayEquals(
        new int[] {8, 8, 8, 8}, actualCreateContextResult.getColorModel().getComponentSize());
  }

  /**
   * Test {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D,
   * AffineTransform, RenderingHints)}.
   *
   * <ul>
   *   <li>Then return RgbBackground is {@code 16777215}.
   * </ul>
   *
   * <p>Method under test: {@link Type1ShadingPaint#createContext(ColorModel, Rectangle,
   * Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName(
      "Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return RgbBackground is '16777215'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaintContext Type1ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"
  })
  void testCreateContext_thenReturnRgbBackgroundIs16777215() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSFloat.ONE);

    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(new COSArray());
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(new Matrix());
    Type1ShadingPaint type1ShadingPaint = new Type1ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    Rectangle deviceBounds = new Rectangle();
    Double userBounds = new Double();

    // Act
    PaintContext actualCreateContextResult =
        type1ShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    ColorModel colorModel = actualCreateContextResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace =
        ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    assertEquals(16777215, ((Type1ShadingContext) actualCreateContextResult).getRgbBackground());
    assertArrayEquals(
        new float[] {}, ((Type1ShadingContext) actualCreateContextResult).getDomain(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(
        new float[] {1.0f},
        ((Type1ShadingContext) actualCreateContextResult).getBackground(),
        0.0f);
    assertArrayEquals(
        new float[] {0.95014954f, 1.0f, 1.0882568f},
        ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
  }
}
