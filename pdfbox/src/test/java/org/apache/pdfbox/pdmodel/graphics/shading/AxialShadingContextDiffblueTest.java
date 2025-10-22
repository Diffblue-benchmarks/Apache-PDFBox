package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.color.ICC_ProfileRGB;
import java.awt.geom.AffineTransform;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AxialShadingContextDiffblueTest {
  /**
   * Test {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}.
   * <p>
   * Method under test: {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName("Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AxialShadingContext.<init>(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)"})
  void testNewAxialShadingContext() throws IOException {
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
    ColorModel colorModel2 = actualAxialShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualAxialShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    PDColor initialColor = shadingColorSpace.getInitialColor();
    assertSame(shadingColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getCoords(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getBackground(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel2.getComponentSize());
    assertArrayEquals(new boolean[]{false, false}, actualAxialShadingContext.getExtend());
  }

  /**
   * Test {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}.
   * <ul>
   *   <li>Given {@link PDCalGray#PDCalGray()}.</li>
   *   <li>Then return RgbBackground is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName("Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle); given PDCalGray(); then return RgbBackground is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AxialShadingContext.<init>(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)"})
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
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getCoords(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getBackground(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, actualAxialShadingContext.getColorModel().getComponentSize());
    assertArrayEquals(new boolean[]{false, false}, actualAxialShadingContext.getExtend());
  }

  /**
   * Test {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}.
   * <ul>
   *   <li>Given {@link PDCalRGB#PDCalRGB()}.</li>
   *   <li>Then return RgbBackground is {@code 64000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName("Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle); given PDCalRGB(); then return RgbBackground is '64000'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AxialShadingContext.<init>(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)"})
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
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getCoords(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getBackground(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, actualAxialShadingContext.getColorModel().getComponentSize());
    assertArrayEquals(new boolean[]{false, false}, actualAxialShadingContext.getExtend());
  }

  /**
   * Test {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}.
   * <ul>
   *   <li>Then ColorModel ColorSpace return {@link ICC_ColorSpace}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName("Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle); then ColorModel ColorSpace return ICC_ColorSpace")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AxialShadingContext.<init>(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)"})
  void testNewAxialShadingContext_thenColorModelColorSpaceReturnICC_ColorSpace() throws IOException {
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
    ColorModel colorModel2 = actualAxialShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualAxialShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getCoords(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getBackground(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel2.getComponentSize());
    assertArrayEquals(new boolean[]{false, false}, actualAxialShadingContext.getExtend());
  }

  /**
   * Test {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}.
   * <ul>
   *   <li>Then return Domain is array of {@code float} with {@code 0.5} and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AxialShadingContext#AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName("Test new AxialShadingContext(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle); then return Domain is array of float with '0.5' and '0.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AxialShadingContext.<init>(PDShadingType2, ColorModel, AffineTransform, Matrix, Rectangle)"})
  void testNewAxialShadingContext_thenReturnDomainIsArrayOfFloatWith05And05() throws IOException {
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
    ColorModel colorModel2 = actualAxialShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualAxialShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new float[]{0.5f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getCoords(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualAxialShadingContext.getBackground(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel2.getComponentSize());
    assertArrayEquals(new boolean[]{false, false}, actualAxialShadingContext.getExtend());
  }
}
