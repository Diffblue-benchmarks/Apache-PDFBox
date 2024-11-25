package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AxialShadingContextDiffblueTest {
  /**
   * Test
   * {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}.
   * <ul>
   *   <li>Given {@link PDCalGray#PDCalGray()}.</li>
   *   <li>Then return RgbBackground is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName("Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle); given PDCalGray(); then return RgbBackground is zero")
  void testNewAxialShadingContext_givenPDCalGray_thenReturnRgbBackgroundIsZero() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray4 = mock(COSArray.class);
    when(cosArray4.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    PDShadingType2 shading = mock(PDShadingType2.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray3);
    when(shading.getExtend()).thenReturn(cosArray4);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getCoords()).thenReturn(cosArray2);
    PDCalGray pdCalGray = new PDCalGray();
    when(shading.getColorSpace()).thenReturn(pdCalGray);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    AxialShadingContext actualAxialShadingContext = new AxialShadingContext(shading, colorModel, xform, matrix,
        new Rectangle(1, 1));

    // Assert
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
    assertEquals(0, actualAxialShadingContext.getRgbBackground());
    assertSame(pdCalGray, actualAxialShadingContext.getShadingColorSpace());
  }

  /**
   * Test
   * {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}.
   * <ul>
   *   <li>Given {@link PDCalRGB#PDCalRGB()}.</li>
   *   <li>Then return RgbBackground is {@code 64000}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName("Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle); given PDCalRGB(); then return RgbBackground is '64000'")
  void testNewAxialShadingContext_givenPDCalRGB_thenReturnRgbBackgroundIs64000() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray4 = mock(COSArray.class);
    when(cosArray4.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    PDShadingType2 shading = mock(PDShadingType2.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray3);
    when(shading.getExtend()).thenReturn(cosArray4);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getCoords()).thenReturn(cosArray2);
    PDCalRGB pdCalRGB = new PDCalRGB();
    when(shading.getColorSpace()).thenReturn(pdCalRGB);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    AxialShadingContext actualAxialShadingContext = new AxialShadingContext(shading, colorModel, xform, matrix,
        new Rectangle(1, 1));

    // Assert
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
    assertEquals(64000, actualAxialShadingContext.getRgbBackground());
    assertSame(pdCalRGB, actualAxialShadingContext.getShadingColorSpace());
  }

  /**
   * Test
   * {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}.
   * <ul>
   *   <li>Then return first element is {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName("Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle); then return first element is '0.5'")
  void testNewAxialShadingContext_thenReturnFirstElementIs05() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.toFloatArray()).thenReturn(new float[]{0.5f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray4 = mock(COSArray.class);
    when(cosArray4.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    PDShadingType2 shading = mock(PDShadingType2.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray3);
    when(shading.getExtend()).thenReturn(cosArray4);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getCoords()).thenReturn(cosArray2);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    AxialShadingContext actualAxialShadingContext = new AxialShadingContext(shading, colorModel, xform, matrix,
        new Rectangle(1, 1));

    // Assert
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
    PDColorSpace shadingColorSpace = actualAxialShadingContext.getShadingColorSpace();
    COSBase cOSObject = shadingColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject).getName());
    assertEquals("DeviceGray", shadingColorSpace.getName());
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(cOSObject.getKey());
    float[] domain = actualAxialShadingContext.getDomain();
    assertEquals(0.5f, domain[0]);
    assertEquals(1, shadingColorSpace.getNumberOfComponents());
    assertEquals(167772150, actualAxialShadingContext.getRgbBackground());
    assertEquals(4, domain.length);
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(initialColor.isPattern());
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test
   * {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}.
   * <ul>
   *   <li>Then ShadingColorSpace COSObject return {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName("Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle); then ShadingColorSpace COSObject return COSName")
  void testNewAxialShadingContext_thenShadingColorSpaceCOSObjectReturnCOSName() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray4 = mock(COSArray.class);
    when(cosArray4.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    PDShadingType2 shading = mock(PDShadingType2.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray3);
    when(shading.getExtend()).thenReturn(cosArray4);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getCoords()).thenReturn(cosArray2);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    AxialShadingContext actualAxialShadingContext = new AxialShadingContext(shading, colorModel, xform, matrix,
        new Rectangle(1, 1));

    // Assert
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
    PDColorSpace shadingColorSpace = actualAxialShadingContext.getShadingColorSpace();
    COSBase cOSObject = shadingColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject).getName());
    assertEquals("DeviceGray", shadingColorSpace.getName());
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(cOSObject.getKey());
    assertEquals(1, shadingColorSpace.getNumberOfComponents());
    assertEquals(167772150, actualAxialShadingContext.getRgbBackground());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(initialColor.isPattern());
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test
   * {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}.
   * <ul>
   *   <li>When {@link Rectangle#Rectangle()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName("Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle); when Rectangle()")
  void testNewAxialShadingContext_whenRectangle() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray4 = mock(COSArray.class);
    when(cosArray4.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    PDShadingType2 shading = mock(PDShadingType2.class);
    when(shading.evalFunction(anyFloat())).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getDomain()).thenReturn(cosArray3);
    when(shading.getExtend()).thenReturn(cosArray4);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getCoords()).thenReturn(cosArray2);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    AxialShadingContext actualAxialShadingContext = new AxialShadingContext(shading, colorModel, xform, matrix,
        new Rectangle());

    // Assert
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
    PDColorSpace shadingColorSpace = actualAxialShadingContext.getShadingColorSpace();
    COSBase cOSObject = shadingColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject).getName());
    assertEquals("DeviceGray", shadingColorSpace.getName());
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(cOSObject.getKey());
    assertEquals(1, shadingColorSpace.getNumberOfComponents());
    assertEquals(167772150, actualAxialShadingContext.getRgbBackground());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(initialColor.isPattern());
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }
}
