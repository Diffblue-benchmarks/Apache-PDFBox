package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.color.ICC_ProfileRGB;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionType0;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Type4ShadingContextDiffblueTest {
  /**
   * Test
   * {@link Type4ShadingContext#Type4ShadingContext(PDShadingType4, ColorModel, AffineTransform, Matrix, Rectangle)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return DataEmpty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Type4ShadingContext#Type4ShadingContext(PDShadingType4, ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName("Test new Type4ShadingContext(PDShadingType4, ColorModel, AffineTransform, Matrix, Rectangle); given ArrayList(); then return DataEmpty")
  void testNewType4ShadingContext_givenArrayList_thenReturnDataEmpty() throws IOException {
    // Arrange
    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any())).thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    Type4ShadingContext actualType4ShadingContext = new Type4ShadingContext(shading, cm, xform, matrix,
        new Rectangle(1, 1));

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    ColorModel colorModel = actualType4ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType4ShadingContext.getShadingColorSpace();
    COSBase cOSObject = shadingColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject).getName());
    assertEquals("DeviceGray", shadingColorSpace.getName());
    assertNull(actualType4ShadingContext.getBackground());
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(cOSObject.getKey());
    byte[] data = profile.getData();
    assertEquals((byte) -102, data[6867]);
    assertEquals((byte) -103, data[6866]);
    assertEquals((byte) -36, data[3]);
    assertEquals((byte) -41, data[6855]);
    assertEquals((byte) -51, data[6863]);
    assertEquals((byte) -93, data[6854]);
    assertEquals(0, profile.getPCSType());
    assertEquals(0, colorModel.getTransferType());
    assertEquals(0, actualType4ShadingContext.getRgbBackground());
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
    assertEquals(1, shadingColorSpace.getNumberOfComponents());
    assertEquals((byte) 15, data[6874]);
    assertEquals(2, profile.getMajorVersion());
    assertEquals((byte) 26, data[2]);
    assertEquals((byte) 2, data[8]);
    assertEquals(3, colorSpace.getNumComponents());
    assertEquals(3, profile.getNumComponents());
    assertEquals(3, colorModel.getNumColorComponents());
    assertEquals(3, colorModel.getTransparency());
    float[][] matrix2 = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix2.length);
    assertEquals(4, colorModel.getNumComponents());
    assertEquals(48, profile.getMinorVersion());
    assertEquals(5, colorSpace.getType());
    assertEquals(5, profile.getColorSpaceType());
    assertEquals(6876, data.length);
    assertEquals((byte) 7, data[24]);
    assertFalse(colorModel.isAlphaPremultiplied());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(initialColor.isPattern());
    assertTrue(colorSpace.isCS_sRGB());
    assertTrue(colorModel.hasAlpha());
    assertTrue(actualType4ShadingContext.isDataEmpty());
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
    assertSame(shading, actualType4ShadingContext.getShading());
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix2[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix2[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix2[0], 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test
   * {@link Type4ShadingContext#Type4ShadingContext(PDShadingType4, ColorModel, AffineTransform, Matrix, Rectangle)}.
   * <ul>
   *   <li>Then return not DataEmpty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Type4ShadingContext#Type4ShadingContext(PDShadingType4, ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName("Test new Type4ShadingContext(PDShadingType4, ColorModel, AffineTransform, Matrix, Rectangle); then return not DataEmpty")
  void testNewType4ShadingContext_thenReturnNotDataEmpty() throws IOException {
    // Arrange
    ArrayList<ShadedTriangle> shadedTriangleList = new ArrayList<>();
    Point point = new Point(1, 1);

    Point point2 = new Point(1, 1);

    shadedTriangleList.add(new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{255.0f, 10.0f, 255.0f, 10.0f}, new float[]{255.0f, 10.0f, 255.0f, 10.0f},
            new float[]{255.0f, 10.0f, 255.0f, 10.0f}}));
    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.evalFunction(Mockito.<float[]>any())).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getFunction()).thenReturn(new PDFunctionType0(COSBoolean.FALSE));
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(shadedTriangleList);
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    Type4ShadingContext actualType4ShadingContext = new Type4ShadingContext(shading, cm, xform, matrix,
        new Rectangle(1, 1));

    // Assert
    verify(shading, atLeast(1)).evalFunction(Mockito.<float[]>any());
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getFunction();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    ColorModel colorModel = actualType4ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType4ShadingContext.getShadingColorSpace();
    COSBase cOSObject = shadingColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject).getName());
    assertEquals("DeviceGray", shadingColorSpace.getName());
    assertNull(actualType4ShadingContext.getBackground());
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(cOSObject.getKey());
    byte[] data = profile.getData();
    assertEquals((byte) -102, data[6867]);
    assertEquals((byte) -103, data[6866]);
    assertEquals((byte) -36, data[3]);
    assertEquals((byte) -41, data[6855]);
    assertEquals((byte) -51, data[6863]);
    assertEquals((byte) -93, data[6854]);
    assertEquals(0, profile.getPCSType());
    assertEquals(0, colorModel.getTransferType());
    assertEquals(0, actualType4ShadingContext.getRgbBackground());
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
    assertEquals(1, shadingColorSpace.getNumberOfComponents());
    assertEquals((byte) 15, data[6874]);
    assertEquals(2, profile.getMajorVersion());
    assertEquals((byte) 26, data[2]);
    assertEquals((byte) 2, data[8]);
    assertEquals(3, colorSpace.getNumComponents());
    assertEquals(3, profile.getNumComponents());
    assertEquals(3, colorModel.getNumColorComponents());
    assertEquals(3, colorModel.getTransparency());
    float[][] matrix2 = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix2.length);
    assertEquals(4, colorModel.getNumComponents());
    assertEquals(48, profile.getMinorVersion());
    assertEquals(5, colorSpace.getType());
    assertEquals(5, profile.getColorSpaceType());
    assertEquals(6876, data.length);
    assertEquals((byte) 7, data[24]);
    assertFalse(colorModel.isAlphaPremultiplied());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(initialColor.isPattern());
    assertFalse(actualType4ShadingContext.isDataEmpty());
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
    assertSame(shading, actualType4ShadingContext.getShading());
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix2[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix2[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix2[0], 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }
}
