package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.MemoryCacheImageInputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDMeshBasedShadingTypeDiffblueTest {
  /**
   * Method under test:
   * {@link PDMeshBasedShadingType#collectPatches(AffineTransform, Matrix, int)}
   */
  @Test
  void testCollectPatches() throws IOException {
    // Arrange
    PDShadingType6 pdShadingType6 = new PDShadingType6(new COSDictionary());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertTrue(pdShadingType6.collectPatches(xform, new Matrix(), 1).isEmpty());
  }

  /**
   * Method under test:
   * {@link PDMeshBasedShadingType#collectPatches(AffineTransform, Matrix, int)}
   */
  @Test
  void testCollectPatches2() throws IOException {
    // Arrange
    PDShadingType6 pdShadingType6 = new PDShadingType6(new COSStream());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertTrue(pdShadingType6.collectPatches(xform, new Matrix(), 1).isEmpty());
  }

  /**
   * Method under test:
   * {@link PDMeshBasedShadingType#readPatch(ImageInputStream, boolean, Point2D[], float[][], long, long, PDRange, PDRange, PDRange[], Matrix, AffineTransform, int)}
   */
  @Test
  void testReadPatch() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenReturn(0);
    COSDictionary shadingDictionary = mock(COSDictionary.class);
    when(shadingDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(shadingDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    PDShadingType6 pdShadingType6 = new PDShadingType6(shadingDictionary);
    MemoryCacheImageInputStream input = new MemoryCacheImageInputStream(new ByteArrayInputStream(new byte[]{}));
    PDRange rangeX = new PDRange();
    PDRange rangeY = new PDRange();
    Matrix matrix = new Matrix();

    // Act
    Patch actualReadPatchResult = pdShadingType6.readPatch(input, true, new Point2D[]{new Point(1, 1)},
        new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}}, 1L, 1L, rangeX, rangeY, new PDRange[]{new PDRange()},
        matrix, new AffineTransform(), 1);

    // Assert
    verify(shadingDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    verify(shadingDictionary).getInt(isA(COSName.class), eq(-1));
    assertNull(actualReadPatchResult);
  }

  /**
   * Method under test:
   * {@link PDMeshBasedShadingType#getBounds(AffineTransform, Matrix, int)}
   */
  @Test
  void testGetBounds() throws IOException {
    // Arrange
    PDShadingType6 pdShadingType6 = new PDShadingType6(new COSDictionary());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertNull(pdShadingType6.getBounds(xform, new Matrix(), 1));
  }

  /**
   * Method under test:
   * {@link PDMeshBasedShadingType#getBounds(AffineTransform, Matrix, int)}
   */
  @Test
  void testGetBounds2() throws IOException {
    // Arrange
    PDShadingType6 pdShadingType6 = new PDShadingType6(new COSStream());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertNull(pdShadingType6.getBounds(xform, new Matrix(), 1));
  }
}
