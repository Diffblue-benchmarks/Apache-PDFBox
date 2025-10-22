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
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.color.ICC_ProfileRGB;
import java.awt.geom.AffineTransform;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDLab;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Type1ShadingContextDiffblueTest {
  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}.
   * <ul>
   *   <li>Given {@link PDCalGray#PDCalGray()}.</li>
   *   <li>Then return ShadingColorSpace is {@link PDCalGray#PDCalGray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); given PDCalGray(); then return ShadingColorSpace is PDCalGray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"})
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
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, actualType1ShadingContext.getColorModel().getComponentSize());
  }

  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}.
   * <ul>
   *   <li>Given {@link PDCalRGB#PDCalRGB()}.</li>
   *   <li>Then return RgbBackground is {@code 64000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); given PDCalRGB(); then return RgbBackground is '64000'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"})
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
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, actualType1ShadingContext.getColorModel().getComponentSize());
  }

  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}.
   * <ul>
   *   <li>Given {@link PDLab#PDLab()}.</li>
   *   <li>Then return RgbBackground is {@code 924193}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); given PDLab(); then return RgbBackground is '924193'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"})
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
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, actualType1ShadingContext.getColorModel().getComponentSize());
  }

  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}.
   * <ul>
   *   <li>Then ColorModel ColorSpace return {@link ICC_ColorSpace}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); then ColorModel ColorSpace return ICC_ColorSpace")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"})
  void testNewType1ShadingContext_thenColorModelColorSpaceReturnICC_ColorSpace() throws IOException {
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
    ColorModel colorModel2 = actualType1ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType1ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel2.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}.
   * <ul>
   *   <li>Then return Background is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); then return Background is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"})
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
    ColorModel colorModel2 = actualType1ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType1ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    assertNull(actualType1ShadingContext.getBackground());
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(new float[]{}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel2.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}.
   * <ul>
   *   <li>Then return Domain is array of {@code float} with zero and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); then return Domain is array of float with zero and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"})
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
    ColorModel colorModel2 = actualType1ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType1ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f, 1.0f}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel2.getComponentSize());
  }

  /**
   * Test {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}.
   * <ul>
   *   <li>Then return Domain is empty array of {@code float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1ShadingContext#Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test new Type1ShadingContext(PDShadingType1, ColorModel, AffineTransform, Matrix); then return Domain is empty array of float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Type1ShadingContext.<init>(PDShadingType1, ColorModel, AffineTransform, Matrix)"})
  void testNewType1ShadingContext_thenReturnDomainIsEmptyArrayOfFloat() throws IOException {
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
    ColorModel colorModel2 = actualType1ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel2.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType1ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertArrayEquals(new float[]{}, actualType1ShadingContext.getDomain(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualType1ShadingContext.getBackground(), 0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel2.getComponentSize());
  }
}
