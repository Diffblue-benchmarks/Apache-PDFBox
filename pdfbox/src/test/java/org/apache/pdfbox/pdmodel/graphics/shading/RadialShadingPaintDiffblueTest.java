package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RadialShadingPaint#RadialShadingPaint(PDShadingType3, Matrix)}
   *   <li>{@link RadialShadingPaint#getTransparency()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RadialShadingPaint.<init>(PDShadingType3, Matrix)",
      "int RadialShadingPaint.getTransparency()"})
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
   * Test {@link RadialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <p>
   * Method under test: {@link RadialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext RadialShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray4 = mock(COSArray.class);
    when(cosArray4.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray4).add(Mockito.<COSObjectable>any());
    cosArray4.add(mock(COSObjectable.class));
    PDShadingType3 shading = mock(PDShadingType3.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray3);
    when(shading.getExtend()).thenReturn(cosArray4);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getCoords()).thenReturn(cosArray2);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    RadialShadingPaint radialShadingPaint = new RadialShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle();
    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    PaintContext actualCreateContextResult = radialShadingPaint.createContext(cm, deviceBounds, userBounds,
        new AffineTransform(), null);

    // Assert
    verify(cosArray4).add(isA(COSObjectable.class));
    verify(cosArray4, atLeast(1)).getObject(anyInt());
    verify(cosArray3).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shading).evalFunction(eq(10.0f));
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getCoords();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getExtend();
    PDColorSpace shadingColorSpace = ((RadialShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof RadialShadingContext);
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getDomain(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getBackground(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getCoords(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, actualCreateContextResult.getColorModel().getComponentSize());
    assertArrayEquals(new boolean[]{false, false}, ((RadialShadingContext) actualCreateContextResult).getExtend());
  }

  /**
   * Test {@link RadialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#toFloatArray()} return array of {@code float} with {@code 0.5} and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RadialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); given COSArray toFloatArray() return array of float with '0.5' and '0.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext RadialShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_givenCOSArrayToFloatArrayReturnArrayOfFloatWith05And05() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.toFloatArray()).thenReturn(new float[]{0.5f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray4 = mock(COSArray.class);
    when(cosArray4.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray4).add(Mockito.<COSObjectable>any());
    cosArray4.add(mock(COSObjectable.class));
    PDShadingType3 shading = mock(PDShadingType3.class);
    when(shading.evalFunction(anyFloat())).thenThrow(new IOException("foo"));
    when(shading.getDomain()).thenReturn(cosArray3);
    when(shading.getExtend()).thenReturn(cosArray4);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getCoords()).thenReturn(cosArray2);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    RadialShadingPaint radialShadingPaint = new RadialShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    radialShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(cosArray4).add(isA(COSObjectable.class));
    verify(cosArray4, atLeast(1)).getObject(anyInt());
    verify(cosArray3).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shading).evalFunction(eq(0.5f));
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getCoords();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getExtend();
  }

  /**
   * Test {@link RadialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Given {@link PDShadingType3} {@link PDShading#evalFunction(float)} throw {@link IOException#IOException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RadialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); given PDShadingType3 evalFunction(float) throw IOException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext RadialShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_givenPDShadingType3EvalFunctionThrowIOExceptionWithFoo() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray4 = mock(COSArray.class);
    when(cosArray4.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray4).add(Mockito.<COSObjectable>any());
    cosArray4.add(mock(COSObjectable.class));
    PDShadingType3 shading = mock(PDShadingType3.class);
    when(shading.evalFunction(anyFloat())).thenThrow(new IOException("foo"));
    when(shading.getDomain()).thenReturn(cosArray3);
    when(shading.getExtend()).thenReturn(cosArray4);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getCoords()).thenReturn(cosArray2);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    RadialShadingPaint radialShadingPaint = new RadialShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    radialShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(cosArray4).add(isA(COSObjectable.class));
    verify(cosArray4, atLeast(1)).getObject(anyInt());
    verify(cosArray3).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shading).evalFunction(eq(10.0f));
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getCoords();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getExtend();
  }

  /**
   * Test {@link RadialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then ColorModel ColorSpace return {@link ICC_ColorSpace}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RadialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then ColorModel ColorSpace return ICC_ColorSpace")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext RadialShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_thenColorModelColorSpaceReturnICC_ColorSpace() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray4 = mock(COSArray.class);
    when(cosArray4.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray4).add(Mockito.<COSObjectable>any());
    cosArray4.add(mock(COSObjectable.class));
    PDShadingType3 shading = mock(PDShadingType3.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray3);
    when(shading.getExtend()).thenReturn(cosArray4);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getCoords()).thenReturn(cosArray2);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    RadialShadingPaint radialShadingPaint = new RadialShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    PaintContext actualCreateContextResult = radialShadingPaint.createContext(cm, deviceBounds, userBounds,
        new AffineTransform(), null);

    // Assert
    verify(cosArray4).add(isA(COSObjectable.class));
    verify(cosArray4, atLeast(1)).getObject(anyInt());
    verify(cosArray3).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shading, atLeast(1)).evalFunction(anyFloat());
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
    PDColorSpace shadingColorSpace = ((RadialShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof RadialShadingContext);
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getDomain(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getBackground(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getCoords(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new boolean[]{false, false}, ((RadialShadingContext) actualCreateContextResult).getExtend());
  }

  /**
   * Test {@link RadialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then return Domain is array of {@code float} with {@code 0.5} and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RadialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return Domain is array of float with '0.5' and '0.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext RadialShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_thenReturnDomainIsArrayOfFloatWith05And05() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.toFloatArray()).thenReturn(new float[]{0.5f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray4 = mock(COSArray.class);
    when(cosArray4.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray4).add(Mockito.<COSObjectable>any());
    cosArray4.add(mock(COSObjectable.class));
    PDShadingType3 shading = mock(PDShadingType3.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray3);
    when(shading.getExtend()).thenReturn(cosArray4);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getCoords()).thenReturn(cosArray2);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    RadialShadingPaint radialShadingPaint = new RadialShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    PaintContext actualCreateContextResult = radialShadingPaint.createContext(cm, deviceBounds, userBounds,
        new AffineTransform(), null);

    // Assert
    verify(cosArray4).add(isA(COSObjectable.class));
    verify(cosArray4, atLeast(1)).getObject(anyInt());
    verify(cosArray3).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shading).evalFunction(eq(0.5f));
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
    PDColorSpace shadingColorSpace = ((RadialShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof RadialShadingContext);
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new float[]{0.5f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getDomain(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getBackground(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getCoords(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new boolean[]{false, false}, ((RadialShadingContext) actualCreateContextResult).getExtend());
  }

  /**
   * Test {@link RadialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then return RgbBackground is {@code 64000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RadialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return RgbBackground is '64000'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext RadialShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_thenReturnRgbBackgroundIs64000() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray4 = mock(COSArray.class);
    when(cosArray4.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray4).add(Mockito.<COSObjectable>any());
    cosArray4.add(mock(COSObjectable.class));
    PDShadingType3 shading = mock(PDShadingType3.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray3);
    when(shading.getExtend()).thenReturn(cosArray4);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getCoords()).thenReturn(cosArray2);
    PDCalRGB pdCalRGB = new PDCalRGB();
    when(shading.getColorSpace()).thenReturn(pdCalRGB);
    RadialShadingPaint radialShadingPaint = new RadialShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    PaintContext actualCreateContextResult = radialShadingPaint.createContext(cm, deviceBounds, userBounds,
        new AffineTransform(), null);

    // Assert
    verify(cosArray4).add(isA(COSObjectable.class));
    verify(cosArray4, atLeast(1)).getObject(anyInt());
    verify(cosArray3).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shading, atLeast(1)).evalFunction(anyFloat());
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getCoords();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getExtend();
    assertTrue(actualCreateContextResult instanceof RadialShadingContext);
    assertEquals(64000, ((RadialShadingContext) actualCreateContextResult).getRgbBackground());
    assertSame(pdCalRGB, ((RadialShadingContext) actualCreateContextResult).getShadingColorSpace());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getDomain(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getBackground(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f},
        ((RadialShadingContext) actualCreateContextResult).getCoords(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, actualCreateContextResult.getColorModel().getComponentSize());
    assertArrayEquals(new boolean[]{false, false}, ((RadialShadingContext) actualCreateContextResult).getExtend());
  }
}
