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

class AxialShadingPaintDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AxialShadingPaint#AxialShadingPaint(PDShadingType2, Matrix)}
   *   <li>{@link AxialShadingPaint#getTransparency()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AxialShadingPaint.<init>(PDShadingType2, Matrix)",
      "int AxialShadingPaint.getTransparency()"})
  void testGettersAndSetters() {
    // Arrange
    PDShadingType2 shadingType2 = new PDShadingType2(new COSDictionary());
    Matrix matrix = new Matrix();

    // Act
    AxialShadingPaint actualAxialShadingPaint = new AxialShadingPaint(shadingType2, matrix);

    // Assert
    assertEquals(0, actualAxialShadingPaint.getTransparency());
    assertSame(shadingType2, actualAxialShadingPaint.getShading());
    assertSame(matrix, actualAxialShadingPaint.getMatrix());
  }

  /**
   * Test {@link AxialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <p>
   * Method under test: {@link AxialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext AxialShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray4 = mock(COSArray.class);
    when(cosArray4.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray4).add(Mockito.<COSObjectable>any());
    cosArray4.add(mock(COSObjectable.class));
    PDShadingType2 shadingType2 = mock(PDShadingType2.class);
    when(shadingType2.evalFunction(anyFloat())).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(shadingType2.getDomain()).thenReturn(cosArray3);
    when(shadingType2.getExtend()).thenReturn(cosArray4);
    when(shadingType2.getBackground()).thenReturn(cosArray);
    when(shadingType2.getCoords()).thenReturn(cosArray2);
    when(shadingType2.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    AxialShadingPaint axialShadingPaint = new AxialShadingPaint(shadingType2, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle();
    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    PaintContext actualCreateContextResult = axialShadingPaint.createContext(cm, deviceBounds, userBounds,
        new AffineTransform(), null);

    // Assert
    verify(cosArray4).add(isA(COSObjectable.class));
    verify(cosArray4, atLeast(1)).getObject(anyInt());
    verify(cosArray3).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shadingType2).evalFunction(eq(10.0f));
    verify(shadingType2).getBackground();
    verify(shadingType2).getColorSpace();
    verify(shadingType2).getCoords();
    verify(shadingType2, atLeast(1)).getDomain();
    verify(shadingType2).getExtend();
    PDColorSpace shadingColorSpace = ((AxialShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof AxialShadingContext);
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((AxialShadingContext) actualCreateContextResult).getCoords(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((AxialShadingContext) actualCreateContextResult).getDomain(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((AxialShadingContext) actualCreateContextResult).getBackground(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, actualCreateContextResult.getColorModel().getComponentSize());
    assertArrayEquals(new boolean[]{false, false}, ((AxialShadingContext) actualCreateContextResult).getExtend());
  }

  /**
   * Test {@link AxialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#toFloatArray()} return array of {@code float} with {@code 0.5} and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AxialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); given COSArray toFloatArray() return array of float with '0.5' and '0.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext AxialShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_givenCOSArrayToFloatArrayReturnArrayOfFloatWith05And05() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.toFloatArray()).thenReturn(new float[]{0.5f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray4 = mock(COSArray.class);
    when(cosArray4.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray4).add(Mockito.<COSObjectable>any());
    cosArray4.add(mock(COSObjectable.class));
    PDShadingType2 shadingType2 = mock(PDShadingType2.class);
    when(shadingType2.evalFunction(anyFloat())).thenThrow(new IOException("foo"));
    when(shadingType2.getDomain()).thenReturn(cosArray3);
    when(shadingType2.getExtend()).thenReturn(cosArray4);
    when(shadingType2.getBackground()).thenReturn(cosArray);
    when(shadingType2.getCoords()).thenReturn(cosArray2);
    when(shadingType2.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    AxialShadingPaint axialShadingPaint = new AxialShadingPaint(shadingType2, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    axialShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(cosArray4).add(isA(COSObjectable.class));
    verify(cosArray4, atLeast(1)).getObject(anyInt());
    verify(cosArray3).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shadingType2).evalFunction(eq(0.5f));
    verify(shadingType2).getBackground();
    verify(shadingType2).getColorSpace();
    verify(shadingType2).getCoords();
    verify(shadingType2, atLeast(1)).getDomain();
    verify(shadingType2).getExtend();
  }

  /**
   * Test {@link AxialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Given {@link PDShadingType2} {@link PDShading#evalFunction(float)} throw {@link IOException#IOException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AxialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); given PDShadingType2 evalFunction(float) throw IOException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext AxialShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_givenPDShadingType2EvalFunctionThrowIOExceptionWithFoo() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray4 = mock(COSArray.class);
    when(cosArray4.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray4).add(Mockito.<COSObjectable>any());
    cosArray4.add(mock(COSObjectable.class));
    PDShadingType2 shadingType2 = mock(PDShadingType2.class);
    when(shadingType2.evalFunction(anyFloat())).thenThrow(new IOException("foo"));
    when(shadingType2.getDomain()).thenReturn(cosArray3);
    when(shadingType2.getExtend()).thenReturn(cosArray4);
    when(shadingType2.getBackground()).thenReturn(cosArray);
    when(shadingType2.getCoords()).thenReturn(cosArray2);
    when(shadingType2.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    AxialShadingPaint axialShadingPaint = new AxialShadingPaint(shadingType2, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    axialShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(cosArray4).add(isA(COSObjectable.class));
    verify(cosArray4, atLeast(1)).getObject(anyInt());
    verify(cosArray3).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shadingType2).evalFunction(eq(10.0f));
    verify(shadingType2).getBackground();
    verify(shadingType2).getColorSpace();
    verify(shadingType2).getCoords();
    verify(shadingType2, atLeast(1)).getDomain();
    verify(shadingType2).getExtend();
  }

  /**
   * Test {@link AxialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then ColorModel ColorSpace return {@link ICC_ColorSpace}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AxialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then ColorModel ColorSpace return ICC_ColorSpace")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext AxialShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_thenColorModelColorSpaceReturnICC_ColorSpace() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray4 = mock(COSArray.class);
    when(cosArray4.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray4).add(Mockito.<COSObjectable>any());
    cosArray4.add(mock(COSObjectable.class));
    PDShadingType2 shadingType2 = mock(PDShadingType2.class);
    when(shadingType2.evalFunction(anyFloat())).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(shadingType2.getDomain()).thenReturn(cosArray3);
    when(shadingType2.getExtend()).thenReturn(cosArray4);
    when(shadingType2.getBackground()).thenReturn(cosArray);
    when(shadingType2.getCoords()).thenReturn(cosArray2);
    when(shadingType2.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    AxialShadingPaint axialShadingPaint = new AxialShadingPaint(shadingType2, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    PaintContext actualCreateContextResult = axialShadingPaint.createContext(cm, deviceBounds, userBounds,
        new AffineTransform(), null);

    // Assert
    verify(cosArray4).add(isA(COSObjectable.class));
    verify(cosArray4, atLeast(1)).getObject(anyInt());
    verify(cosArray3).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shadingType2, atLeast(1)).evalFunction(anyFloat());
    verify(shadingType2).getBackground();
    verify(shadingType2).getColorSpace();
    verify(shadingType2).getCoords();
    verify(shadingType2, atLeast(1)).getDomain();
    verify(shadingType2).getExtend();
    ColorModel colorModel = actualCreateContextResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = ((AxialShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof AxialShadingContext);
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((AxialShadingContext) actualCreateContextResult).getCoords(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((AxialShadingContext) actualCreateContextResult).getDomain(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((AxialShadingContext) actualCreateContextResult).getBackground(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new boolean[]{false, false}, ((AxialShadingContext) actualCreateContextResult).getExtend());
  }

  /**
   * Test {@link AxialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then return Domain is array of {@code float} with {@code 0.5} and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AxialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return Domain is array of float with '0.5' and '0.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext AxialShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_thenReturnDomainIsArrayOfFloatWith05And05() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.toFloatArray()).thenReturn(new float[]{0.5f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray4 = mock(COSArray.class);
    when(cosArray4.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray4).add(Mockito.<COSObjectable>any());
    cosArray4.add(mock(COSObjectable.class));
    PDShadingType2 shadingType2 = mock(PDShadingType2.class);
    when(shadingType2.evalFunction(anyFloat())).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(shadingType2.getDomain()).thenReturn(cosArray3);
    when(shadingType2.getExtend()).thenReturn(cosArray4);
    when(shadingType2.getBackground()).thenReturn(cosArray);
    when(shadingType2.getCoords()).thenReturn(cosArray2);
    when(shadingType2.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    AxialShadingPaint axialShadingPaint = new AxialShadingPaint(shadingType2, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    PaintContext actualCreateContextResult = axialShadingPaint.createContext(cm, deviceBounds, userBounds,
        new AffineTransform(), null);

    // Assert
    verify(cosArray4).add(isA(COSObjectable.class));
    verify(cosArray4, atLeast(1)).getObject(anyInt());
    verify(cosArray3).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shadingType2).evalFunction(eq(0.5f));
    verify(shadingType2).getBackground();
    verify(shadingType2).getColorSpace();
    verify(shadingType2).getCoords();
    verify(shadingType2, atLeast(1)).getDomain();
    verify(shadingType2).getExtend();
    ColorModel colorModel = actualCreateContextResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = ((AxialShadingContext) actualCreateContextResult).getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertTrue(actualCreateContextResult instanceof AxialShadingContext);
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new float[]{0.5f, 0.5f, 10.0f, 0.5f},
        ((AxialShadingContext) actualCreateContextResult).getDomain(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((AxialShadingContext) actualCreateContextResult).getCoords(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((AxialShadingContext) actualCreateContextResult).getBackground(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new boolean[]{false, false}, ((AxialShadingContext) actualCreateContextResult).getExtend());
  }

  /**
   * Test {@link AxialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}.
   * <ul>
   *   <li>Then return RgbBackground is {@code 64000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AxialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  @DisplayName("Test createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints); then return RgbBackground is '64000'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaintContext AxialShadingPaint.createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)"})
  void testCreateContext_thenReturnRgbBackgroundIs64000() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray4 = mock(COSArray.class);
    when(cosArray4.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosArray4).add(Mockito.<COSObjectable>any());
    cosArray4.add(mock(COSObjectable.class));
    PDShadingType2 shadingType2 = mock(PDShadingType2.class);
    when(shadingType2.evalFunction(anyFloat())).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(shadingType2.getDomain()).thenReturn(cosArray3);
    when(shadingType2.getExtend()).thenReturn(cosArray4);
    when(shadingType2.getBackground()).thenReturn(cosArray);
    when(shadingType2.getCoords()).thenReturn(cosArray2);
    PDCalRGB pdCalRGB = new PDCalRGB();
    when(shadingType2.getColorSpace()).thenReturn(pdCalRGB);
    AxialShadingPaint axialShadingPaint = new AxialShadingPaint(shadingType2, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    PaintContext actualCreateContextResult = axialShadingPaint.createContext(cm, deviceBounds, userBounds,
        new AffineTransform(), null);

    // Assert
    verify(cosArray4).add(isA(COSObjectable.class));
    verify(cosArray4, atLeast(1)).getObject(anyInt());
    verify(cosArray3).toFloatArray();
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shadingType2, atLeast(1)).evalFunction(anyFloat());
    verify(shadingType2).getBackground();
    verify(shadingType2).getColorSpace();
    verify(shadingType2).getCoords();
    verify(shadingType2, atLeast(1)).getDomain();
    verify(shadingType2).getExtend();
    assertTrue(actualCreateContextResult instanceof AxialShadingContext);
    assertEquals(64000, ((AxialShadingContext) actualCreateContextResult).getRgbBackground());
    assertSame(pdCalRGB, ((AxialShadingContext) actualCreateContextResult).getShadingColorSpace());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((AxialShadingContext) actualCreateContextResult).getCoords(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((AxialShadingContext) actualCreateContextResult).getDomain(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f},
        ((AxialShadingContext) actualCreateContextResult).getBackground(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, actualCreateContextResult.getColorModel().getComponentSize());
    assertArrayEquals(new boolean[]{false, false}, ((AxialShadingContext) actualCreateContextResult).getExtend());
  }
}
