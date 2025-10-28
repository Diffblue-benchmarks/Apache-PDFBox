package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AxialShadingPaintDiffblueTest {
  /**
   * Method under test:
   * {@link AxialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  void testCreateContext() {
    // Arrange
    COSDictionary shadingDictionary = mock(COSDictionary.class);
    when(shadingDictionary.getDictionaryObject(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(COSBoolean.FALSE);
    PDShadingType2 shadingType2 = new PDShadingType2(shadingDictionary);
    AxialShadingPaint axialShadingPaint = new AxialShadingPaint(shadingType2, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    axialShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(shadingDictionary).getDictionaryObject(isA(COSName.class), isA(COSName.class));
  }

  /**
   * Method under test:
   * {@link AxialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  void testCreateContext2() {
    // Arrange
    COSDictionary shadingDictionary = mock(COSDictionary.class);
    when(shadingDictionary.getDictionaryObject(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSArray());
    PDShadingType2 shadingType2 = new PDShadingType2(shadingDictionary);
    AxialShadingPaint axialShadingPaint = new AxialShadingPaint(shadingType2, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    axialShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(shadingDictionary).getDictionaryObject(isA(COSName.class), isA(COSName.class));
  }

  /**
   * Method under test:
   * {@link AxialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  void testCreateContext3() throws IOException {
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
   * Method under test:
   * {@link AxialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  void testCreateContext4() throws IOException {
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
    ColorModel colorModel = actualCreateContextResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    assertTrue(actualCreateContextResult instanceof AxialShadingContext);
    assertNull(((AxialShadingContext) actualCreateContextResult).getFunction());
    byte[] data = profile.getData();
    assertEquals((byte) -102, data[6867]);
    assertEquals((byte) -103, data[6866]);
    assertEquals((byte) -36, data[3]);
    assertEquals((byte) -41, data[6855]);
    assertEquals((byte) -51, data[6863]);
    assertEquals((byte) -93, data[6854]);
    assertEquals(0, profile.getPCSType());
    assertEquals(0, colorModel.getTransferType());
    assertEquals((byte) 0, data[0]);
    assertEquals((byte) 0, data[1]);
    assertEquals((byte) 0, data[10]);
    assertEquals((byte) 0, data[11]);
    assertEquals((byte) 0, data[6851]);
    assertEquals((byte) 0, data[6852]);
    assertEquals((byte) 0, data[6853]);
    assertEquals((byte) 0, data[6856]);
    assertEquals((byte) 0, data[6857]);
    assertEquals((byte) 0, data[6860]);
    assertEquals((byte) 0, data[6861]);
    assertEquals((byte) 0, data[6864]);
    assertEquals((byte) 0, data[6865]);
    assertEquals((byte) 0, data[6868]);
    assertEquals((byte) 0, data[6869]);
    assertEquals((byte) 0, data[6872]);
    assertEquals((byte) 0, data[6873]);
    assertEquals(1, profile.getProfileClass());
    assertEquals((byte) 15, data[6874]);
    assertEquals(2, profile.getMajorVersion());
    assertEquals((byte) 26, data[2]);
    assertEquals((byte) 2, data[8]);
    assertEquals(3, colorSpace.getNumComponents());
    assertEquals(3, profile.getNumComponents());
    assertEquals(3, colorModel.getNumColorComponents());
    assertEquals(3, colorModel.getTransparency());
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertEquals(4, colorModel.getNumComponents());
    assertEquals(48, profile.getMinorVersion());
    assertEquals(5, colorSpace.getType());
    assertEquals(5, profile.getColorSpaceType());
    assertEquals(64000, ((AxialShadingContext) actualCreateContextResult).getRgbBackground());
    assertEquals(6876, data.length);
    assertEquals((byte) 7, data[24]);
    assertFalse(colorModel.isAlphaPremultiplied());
    assertTrue(colorSpace.isCS_sRGB());
    assertTrue(colorModel.hasAlpha());
    assertEquals(Integer.SIZE, colorModel.getPixelSize());
    assertEquals(' ', data[19]);
    assertEquals(' ', data[23]);
    assertEquals('&', data[6870]);
    assertEquals('0', data[9]);
    assertEquals('B', data[18]);
    assertEquals('G', data[17]);
    assertEquals('L', data[6862]);
    assertEquals('R', data[Short.SIZE]);
    assertEquals('T', data[6858]);
    assertEquals('X', data[20]);
    assertEquals('Y', data[21]);
    assertEquals('Z', data[22]);
    assertEquals('\\', data[6875]);
    assertEquals('c', data[5]);
    assertEquals('f', data[6871]);
    assertEquals('l', data[4]);
    assertEquals('m', data[12]);
    assertEquals('m', data[6]);
    assertEquals('n', data[13]);
    assertEquals('r', data[15]);
    assertEquals('s', data[7]);
    assertEquals('t', data[14]);
    assertEquals('{', data[6859]);
    assertSame(pdCalRGB, ((AxialShadingContext) actualCreateContextResult).getShadingColorSpace());
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
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
   * Method under test:
   * {@link AxialShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  void testCreateContext5() throws IOException {
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
   * Methods under test:
   * <ul>
   *   <li>{@link AxialShadingPaint#AxialShadingPaint(PDShadingType2, Matrix)}
   *   <li>{@link AxialShadingPaint#getTransparency()}
   * </ul>
   */
  @Test
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
}
