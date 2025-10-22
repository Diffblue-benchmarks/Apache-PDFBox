package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Type1ShadingPaintDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Type1ShadingPaint#Type1ShadingPaint(PDShadingType1, Matrix)}
   *   <li>{@link Type1ShadingPaint#getTransparency()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Type1ShadingPaint.<init>(PDShadingType1, Matrix)",
      "int Type1ShadingPaint.getTransparency()"})
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
   * Test {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then return Background is array of {@code float} with zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return Background is array of float with zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext Type1ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_thenReturnBackgroundIsArrayOfFloatWithZero() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(new COSArray());
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(new Matrix());
    Type1ShadingPaint type1ShadingPaint = new Type1ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    PaintContext actualCreateContextResult = type1ShadingPaint.createContext(cm, deviceBounds, userBounds,
        new AffineTransform(), null);

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
    PDColorSpace shadingColorSpace = ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(new float[]{}, ((Type1ShadingContext) actualCreateContextResult).getDomain(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, ((Type1ShadingContext) actualCreateContextResult).getBackground(), 0.0f);
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then return Background is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return Background is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext Type1ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_thenReturnBackgroundIsNull() throws IOException {
    // Arrange
    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getDomain()).thenReturn(new COSArray());
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(new Matrix());
    Type1ShadingPaint type1ShadingPaint = new Type1ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    PaintContext actualCreateContextResult = type1ShadingPaint.createContext(cm, deviceBounds, userBounds,
        new AffineTransform(), null);

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
    PDColorSpace shadingColorSpace = ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    assertNull(((Type1ShadingContext) actualCreateContextResult).getBackground());
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(new float[]{}, ((Type1ShadingContext) actualCreateContextResult).getDomain(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then return Domain is array of {@code float} with ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return Domain is array of float with ten and '0.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext Type1ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_thenReturnDomainIsArrayOfFloatWithTenAnd05() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(new Matrix());
    Type1ShadingPaint type1ShadingPaint = new Type1ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    PaintContext actualCreateContextResult = type1ShadingPaint.createContext(cm, deviceBounds, userBounds,
        new AffineTransform(), null);

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
    PDColorSpace shadingColorSpace = ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getBackground(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getDomain(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then return Domain is array of {@code float} with zero and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return Domain is array of float with zero and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext Type1ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_thenReturnDomainIsArrayOfFloatWithZeroAndOne() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(new Matrix());
    Type1ShadingPaint type1ShadingPaint = new Type1ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    PaintContext actualCreateContextResult = type1ShadingPaint.createContext(cm, deviceBounds, userBounds,
        new AffineTransform(), null);

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
    PDColorSpace shadingColorSpace = ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f, 1.0f},
        ((Type1ShadingContext) actualCreateContextResult).getDomain(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getBackground(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then return Domain is empty array of {@code float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return Domain is empty array of float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext Type1ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_thenReturnDomainIsEmptyArrayOfFloat() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(new COSArray());
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(new Matrix());
    Type1ShadingPaint type1ShadingPaint = new Type1ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    PaintContext actualCreateContextResult = type1ShadingPaint.createContext(cm, deviceBounds, userBounds,
        new AffineTransform(), null);

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
    PDColorSpace shadingColorSpace = ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(new float[]{}, ((Type1ShadingContext) actualCreateContextResult).getDomain(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getBackground(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then ShadingColorSpace BlackPoint COSObject return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then ShadingColorSpace BlackPoint COSObject return COSArray")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext Type1ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_thenShadingColorSpaceBlackPointCOSObjectReturnCOSArray() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    PDCalRGB pdCalRGB = new PDCalRGB();
    pdCalRGB.setGamma(new PDGamma());
    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getColorSpace()).thenReturn(pdCalRGB);
    when(shading.getMatrix()).thenReturn(new Matrix());
    Type1ShadingPaint type1ShadingPaint = new Type1ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    PaintContext actualCreateContextResult = type1ShadingPaint.createContext(cm, deviceBounds, userBounds,
        new AffineTransform(), null);

    // Assert
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    PDColorSpace shadingColorSpace = ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(((PDCalRGB) shadingColorSpace).getBlackPoint().getCOSObject() instanceof COSArray);
    assertTrue(((PDCalRGB) shadingColorSpace).getWhitepoint().getCOSObject() instanceof COSArray);
    assertTrue(shadingColorSpace instanceof PDCalRGB);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    PDGamma gamma = ((PDCalRGB) shadingColorSpace).getGamma();
    assertEquals(0.0f, gamma.getB());
    assertEquals(0.0f, gamma.getG());
    assertEquals(0.0f, gamma.getR());
    assertEquals(16776191, ((Type1ShadingContext) actualCreateContextResult).getRgbBackground());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getBackground(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getDomain(), 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f},
        ((PDCalRGB) shadingColorSpace).getMatrix(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, actualCreateContextResult.getColorModel().getComponentSize());
  }

  /**
   * Test {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then ShadingColorSpace COSObject return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then ShadingColorSpace COSObject return COSArray")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext Type1ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_thenShadingColorSpaceCOSObjectReturnCOSArray() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    PDCalRGB pdCalRGB = new PDCalRGB();
    pdCalRGB.setMatrix(new Matrix());
    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getColorSpace()).thenReturn(pdCalRGB);
    when(shading.getMatrix()).thenReturn(new Matrix());
    Type1ShadingPaint type1ShadingPaint = new Type1ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    PaintContext actualCreateContextResult = type1ShadingPaint.createContext(cm, deviceBounds, userBounds,
        new AffineTransform(), null);

    // Assert
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    PDColorSpace shadingColorSpace = ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    COSBase cOSObject = shadingColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    assertTrue(shadingColorSpace instanceof PDCalRGB);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    assertEquals(2, ((COSArray) cOSObject).toList().size());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getBackground(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getDomain(), 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f},
        ((PDCalRGB) shadingColorSpace).getMatrix(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, actualCreateContextResult.getColorModel().getComponentSize());
  }

  /**
   * Test {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then ShadingColorSpace return {@link PDCalRGB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then ShadingColorSpace return PDCalRGB")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext Type1ShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_thenShadingColorSpaceReturnPDCalRGB() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(cosArray2);
    when(shading.getColorSpace()).thenReturn(new PDCalRGB());
    when(shading.getMatrix()).thenReturn(new Matrix());
    Type1ShadingPaint type1ShadingPaint = new Type1ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    PaintContext actualCreateContextResult = type1ShadingPaint.createContext(cm, deviceBounds, userBounds,
        new AffineTransform(), null);

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
    PDColorSpace shadingColorSpace = ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDCalRGB);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getBackground(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getDomain(), 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f},
        ((PDCalRGB) shadingColorSpace).getMatrix(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }
}
