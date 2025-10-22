package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionType0;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Type5ShadingContextDiffblueTest {
  /**
   * Test {@link Type5ShadingContext#Type5ShadingContext(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return DataEmpty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type5ShadingContext#Type5ShadingContext(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName("Test new Type5ShadingContext(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle); given ArrayList(); then return DataEmpty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Type5ShadingContext.<init>(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle)"})
  void testNewType5ShadingContext_givenArrayList_thenReturnDataEmpty() throws IOException {
    // Arrange
    PDShadingType5 shading = mock(PDShadingType5.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any())).thenReturn(new ArrayList<>());
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    Type5ShadingContext actualType5ShadingContext = new Type5ShadingContext(shading, cm, xform, matrix,
        new Rectangle(1, 1));

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    ColorModel colorModel = actualType5ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType5ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    float[][] matrix2 = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix2.length);
    assertTrue(actualType5ShadingContext.isDataEmpty());
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix2[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix2[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix2[0], 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link Type5ShadingContext#Type5ShadingContext(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle)}.
   * <ul>
   *   <li>Then return not DataEmpty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type5ShadingContext#Type5ShadingContext(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle)}
   */
  @Test
  @DisplayName("Test new Type5ShadingContext(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle); then return not DataEmpty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Type5ShadingContext.<init>(PDShadingType5, ColorModel, AffineTransform, Matrix, Rectangle)"})
  void testNewType5ShadingContext_thenReturnNotDataEmpty() throws IOException {
    // Arrange
    ArrayList<ShadedTriangle> shadedTriangleList = new ArrayList<>();
    Point point = new Point(1, 1);

    Point point2 = new Point(1, 1);

    shadedTriangleList.add(new ShadedTriangle(new Point2D[]{point, point2, new Point(1, 1)},
        new float[][]{new float[]{255.0f, 10.0f, 255.0f, 10.0f}, new float[]{255.0f, 10.0f, 255.0f, 10.0f},
            new float[]{255.0f, 10.0f, 255.0f, 10.0f}}));
    PDShadingType5 shading = mock(PDShadingType5.class);
    when(shading.evalFunction(Mockito.<float[]>any())).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(shading.getFunction()).thenReturn(new PDFunctionType0(COSBoolean.FALSE));
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(shadedTriangleList);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    Type5ShadingContext actualType5ShadingContext = new Type5ShadingContext(shading, cm, xform, matrix,
        new Rectangle(1, 1));

    // Assert
    verify(shading, atLeast(1)).evalFunction(Mockito.<float[]>any());
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading, atLeast(1)).getFunction();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    ColorModel colorModel = actualType5ShadingContext.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    PDColorSpace shadingColorSpace = actualType5ShadingContext.getShadingColorSpace();
    assertTrue(shadingColorSpace instanceof PDDeviceGray);
    float[][] matrix2 = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix2.length);
    assertFalse(actualType5ShadingContext.isDataEmpty());
    assertArrayEquals(new float[]{0.0f}, shadingColorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix2[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix2[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix2[0], 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }
}
