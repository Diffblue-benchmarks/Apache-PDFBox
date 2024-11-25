package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
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
   * Test
   * {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <p>
   * Method under test:
   * {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)")
  void testCreateContext() throws IOException {
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
    PDColorSpace shadingColorSpace = ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    COSBase cOSObject = shadingColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    COSBase cOSObject2 = ((PDCalRGB) shadingColorSpace).getBlackPoint().getCOSObject();
    assertTrue(cOSObject2 instanceof COSArray);
    assertTrue(((PDCalRGB) shadingColorSpace).getWhitepoint().getCOSObject() instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    List<? extends COSBase> toListResult2 = ((COSArray) cOSObject2).toList();
    assertEquals(3, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    assertTrue(shadingColorSpace instanceof PDCalRGB);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    assertNull(getResult2.getKey());
    assertEquals(1, ((COSDictionary) getResult).getValues().size());
    assertEquals(1, ((COSDictionary) getResult).size());
    PDGamma gamma = ((PDCalRGB) shadingColorSpace).getGamma();
    assertEquals(1.0f, gamma.getB());
    assertEquals(1.0f, gamma.getG());
    assertEquals(1.0f, gamma.getR());
    assertEquals(64000, ((Type1ShadingContext) actualCreateContextResult).getRgbBackground());
    assertFalse(getResult2.isDirect());
    assertSame(getResult2, toListResult2.get(1));
    assertSame(getResult2, toListResult2.get(2));
  }

  /**
   * Test
   * {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <p>
   * Method under test:
   * {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)")
  void testCreateContext2() throws IOException {
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
    COSBase cOSObject = ((PDCalRGB) shadingColorSpace).getWhitepoint().getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    assertTrue(shadingColorSpace instanceof PDCalRGB);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    assertNull(getResult.getKey());
    PDGamma gamma = ((PDCalRGB) shadingColorSpace).getGamma();
    assertEquals(0.0f, gamma.getB());
    assertEquals(0.0f, gamma.getG());
    assertEquals(0.0f, gamma.getR());
    assertEquals(16776191, ((Type1ShadingContext) actualCreateContextResult).getRgbBackground());
    assertFalse(getResult.isDirect());
    assertSame(getResult, toListResult.get(1));
    assertSame(getResult, toListResult.get(2));
  }

  /**
   * Test
   * {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <p>
   * Method under test:
   * {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)")
  void testCreateContext3() throws IOException {
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
    COSBase cOSObject2 = ((PDCalRGB) shadingColorSpace).getBlackPoint().getCOSObject();
    assertTrue(cOSObject2 instanceof COSArray);
    assertTrue(((PDCalRGB) shadingColorSpace).getWhitepoint().getCOSObject() instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    List<? extends COSBase> toListResult2 = ((COSArray) cOSObject2).toList();
    assertEquals(3, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    assertTrue(shadingColorSpace instanceof PDCalRGB);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    assertNull(getResult2.getKey());
    PDGamma gamma = ((PDCalRGB) shadingColorSpace).getGamma();
    assertEquals(1.0f, gamma.getB());
    assertEquals(1.0f, gamma.getG());
    assertEquals(1.0f, gamma.getR());
    assertEquals(2, ((COSDictionary) getResult).getValues().size());
    assertEquals(2, ((COSDictionary) getResult).size());
    assertEquals(64000, ((Type1ShadingContext) actualCreateContextResult).getRgbBackground());
    assertFalse(getResult2.isDirect());
    assertSame(getResult2, toListResult2.get(1));
    assertSame(getResult2, toListResult2.get(2));
  }

  /**
   * Test
   * {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); given COSArray() add FALSE; then return array length is zero")
  void testCreateContext_givenCOSArrayAddFalse_thenReturnArrayLengthIsZero() throws IOException {
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
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    assertEquals(0, ((Type1ShadingContext) actualCreateContextResult).getRgbBackground());
    assertEquals(0, ((Type1ShadingContext) actualCreateContextResult).getDomain().length);
    assertArrayEquals(new float[]{0.0f}, ((Type1ShadingContext) actualCreateContextResult).getBackground(), 0.0f);
  }

  /**
   * Test
   * {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then return Background is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return Background is 'null'")
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
    PDColorSpace shadingColorSpace = ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    COSBase cOSObject = shadingColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    assertEquals("DeviceGray", ((COSName) cOSObject).getName());
    assertEquals("DeviceGray", shadingColorSpace.getName());
    assertNull(((Type1ShadingContext) actualCreateContextResult).getBackground());
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((Type1ShadingContext) actualCreateContextResult).getRgbBackground());
    assertEquals(1, shadingColorSpace.getNumberOfComponents());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(initialColor.isPattern());
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test
   * {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then return Domain is array of {@code float} with ten and
   * {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return Domain is array of float with ten and '0.5'")
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
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((Type1ShadingContext) actualCreateContextResult).getDomain(), 0.0f);
  }

  /**
   * Test
   * {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then return Domain is array of {@code float} with zero and one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return Domain is array of float with zero and one")
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
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f, 1.0f},
        ((Type1ShadingContext) actualCreateContextResult).getDomain(), 0.0f);
  }

  /**
   * Test
   * {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then return RgbBackground is {@code 167772150}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Type1ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return RgbBackground is '167772150'")
  void testCreateContext_thenReturnRgbBackgroundIs167772150() throws IOException {
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
    PDColorSpace shadingColorSpace = ((Type1ShadingContext) actualCreateContextResult).getShadingColorSpace();
    COSBase cOSObject = shadingColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof Type1ShadingContext);
    assertEquals("DeviceGray", ((COSName) cOSObject).getName());
    assertEquals("DeviceGray", shadingColorSpace.getName());
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(cOSObject.getKey());
    assertEquals(1, shadingColorSpace.getNumberOfComponents());
    assertEquals(167772150, ((Type1ShadingContext) actualCreateContextResult).getRgbBackground());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(initialColor.isPattern());
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }
}
