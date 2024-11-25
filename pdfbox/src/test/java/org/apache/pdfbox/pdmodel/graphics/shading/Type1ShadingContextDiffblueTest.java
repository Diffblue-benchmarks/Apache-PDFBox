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
import java.awt.geom.AffineTransform;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDLab;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Type1ShadingContextDiffblueTest {
  /**
   * Test
   * {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}.
   * <ul>
   *   <li>Given {@link PDCalGray#PDCalGray()}.</li>
   *   <li>Then return ShadingColorSpace is {@link PDCalGray#PDCalGray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); given PDCalGray(); then return ShadingColorSpace is PDCalGray()")
  void testNewType1ShadingContext_givenPDCalGray_thenReturnShadingColorSpaceIsPDCalGray() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(cosArray2);
    PDCalGray pdCalGray = new PDCalGray();
    when(shading.getColorSpace()).thenReturn(pdCalGray);
    when(shading.getMatrix()).thenReturn(new Matrix());
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();

    // Act
    Type1ShadingContext actualType1ShadingContext = new Type1ShadingContext(shading, colorModel, xform, new Matrix());

    // Assert
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    assertSame(pdCalGray, actualType1ShadingContext.getShadingColorSpace());
  }

  /**
   * Test
   * {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}.
   * <ul>
   *   <li>Given {@link PDCalRGB#PDCalRGB()}.</li>
   *   <li>Then return RgbBackground is {@code 64000}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); given PDCalRGB(); then return RgbBackground is '64000'")
  void testNewType1ShadingContext_givenPDCalRGB_thenReturnRgbBackgroundIs64000() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(cosArray2);
    PDCalRGB pdCalRGB = new PDCalRGB();
    when(shading.getColorSpace()).thenReturn(pdCalRGB);
    when(shading.getMatrix()).thenReturn(new Matrix());
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();

    // Act
    Type1ShadingContext actualType1ShadingContext = new Type1ShadingContext(shading, colorModel, xform, new Matrix());

    // Assert
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    assertEquals(64000, actualType1ShadingContext.getRgbBackground());
    assertSame(pdCalRGB, actualType1ShadingContext.getShadingColorSpace());
  }

  /**
   * Test
   * {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}.
   * <ul>
   *   <li>Given {@link PDLab#PDLab()}.</li>
   *   <li>Then return RgbBackground is {@code 924193}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); given PDLab(); then return RgbBackground is '924193'")
  void testNewType1ShadingContext_givenPDLab_thenReturnRgbBackgroundIs924193() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(cosArray2);
    PDLab pdLab = new PDLab();
    when(shading.getColorSpace()).thenReturn(pdLab);
    when(shading.getMatrix()).thenReturn(new Matrix());
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();

    // Act
    Type1ShadingContext actualType1ShadingContext = new Type1ShadingContext(shading, colorModel, xform, new Matrix());

    // Assert
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    assertEquals(924193, actualType1ShadingContext.getRgbBackground());
    assertSame(pdLab, actualType1ShadingContext.getShadingColorSpace());
  }

  /**
   * Test
   * {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}.
   * <ul>
   *   <li>Then return Background is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); then return Background is 'null'")
  void testNewType1ShadingContext_thenReturnBackgroundIsNull() throws IOException {
    // Arrange
    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getDomain()).thenReturn(new COSArray());
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(new Matrix());
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();

    // Act
    Type1ShadingContext actualType1ShadingContext = new Type1ShadingContext(shading, colorModel, xform, new Matrix());

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    PDColorSpace shadingColorSpace = actualType1ShadingContext.getShadingColorSpace();
    COSBase cOSObject = shadingColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject).getName());
    assertEquals("DeviceGray", shadingColorSpace.getName());
    assertNull(actualType1ShadingContext.getBackground());
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(cOSObject.getKey());
    assertEquals(0, actualType1ShadingContext.getRgbBackground());
    assertEquals(0, actualType1ShadingContext.getDomain().length);
    assertEquals(1, shadingColorSpace.getNumberOfComponents());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(initialColor.isPattern());
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test
   * {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}.
   * <ul>
   *   <li>Then return Domain is array of {@code float} with ten and
   * {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); then return Domain is array of float with ten and '0.5'")
  void testNewType1ShadingContext_thenReturnDomainIsArrayOfFloatWithTenAnd05() throws IOException {
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
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();

    // Act
    Type1ShadingContext actualType1ShadingContext = new Type1ShadingContext(shading, colorModel, xform, new Matrix());

    // Assert
    verify(cosArray).toFloatArray();
    verify(cosArray2).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getDomain(), 0.0f);
  }

  /**
   * Test
   * {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}.
   * <ul>
   *   <li>Then return Domain is array of {@code float} with zero and one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); then return Domain is array of float with zero and one")
  void testNewType1ShadingContext_thenReturnDomainIsArrayOfFloatWithZeroAndOne() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(new Matrix());
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();

    // Act
    Type1ShadingContext actualType1ShadingContext = new Type1ShadingContext(shading, colorModel, xform, new Matrix());

    // Assert
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).getDomain();
    verify(shading).getMatrix();
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f, 1.0f}, actualType1ShadingContext.getDomain(), 0.0f);
  }

  /**
   * Test
   * {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}.
   * <ul>
   *   <li>Then return RgbBackground is {@code 167772150}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); then return RgbBackground is '167772150'")
  void testNewType1ShadingContext_thenReturnRgbBackgroundIs167772150() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDShadingType1 shading = mock(PDShadingType1.class);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getDomain()).thenReturn(new COSArray());
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(shading.getMatrix()).thenReturn(new Matrix());
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();

    // Act
    Type1ShadingContext actualType1ShadingContext = new Type1ShadingContext(shading, colorModel, xform, new Matrix());

    // Assert
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getDomain();
    verify(shading).getMatrix();
    PDColorSpace shadingColorSpace = actualType1ShadingContext.getShadingColorSpace();
    COSBase cOSObject = shadingColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject).getName());
    assertEquals("DeviceGray", shadingColorSpace.getName());
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(cOSObject.getKey());
    assertEquals(0, actualType1ShadingContext.getDomain().length);
    assertEquals(1, shadingColorSpace.getNumberOfComponents());
    assertEquals(167772150, actualType1ShadingContext.getRgbBackground());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(initialColor.isPattern());
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }
}
