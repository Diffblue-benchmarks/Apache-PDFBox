package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Paint;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class PDShadingType4DiffblueTest {
  /**
   * Method under test: {@link PDShadingType4#getBitsPerFlag()}
   */
  @Test
  void testGetBitsPerFlag() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDShadingType4(new COSDictionary())).getBitsPerFlag());
  }

  /**
   * Method under test: {@link PDShadingType4#setBitsPerFlag(int)}
   */
  @Test
  void testSetBitsPerFlag() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType4 pdShadingType4 = new PDShadingType4(shadingDictionary);

    // Act
    pdShadingType4.setBitsPerFlag(1);

    // Assert
    assertEquals(1, pdShadingType4.getBitsPerFlag());
    assertSame(shadingDictionary, pdShadingType4.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingType4#setBitsPerFlag(int)}
   */
  @Test
  void testSetBitsPerFlag2() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType4 pdShadingType4 = new PDShadingType4(shadingDictionary);

    // Act
    pdShadingType4.setBitsPerFlag(Integer.MIN_VALUE);

    // Assert
    assertEquals(Integer.MIN_VALUE, pdShadingType4.getBitsPerFlag());
    assertSame(shadingDictionary, pdShadingType4.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingType4#toPaint(Matrix)}
   */
  @Test
  void testToPaint() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());
    Matrix matrix = new Matrix();

    // Act
    Paint actualToPaintResult = pdShadingType4.toPaint(matrix);

    // Assert
    assertTrue(actualToPaintResult instanceof Type4ShadingPaint);
    assertEquals(0, actualToPaintResult.getTransparency());
    assertSame(pdShadingType4, ((Type4ShadingPaint) actualToPaintResult).getShading());
    assertSame(matrix, ((Type4ShadingPaint) actualToPaintResult).getMatrix());
  }

  /**
   * Method under test: {@link PDShadingType4#toPaint(Matrix)}
   */
  @Test
  void testToPaint2() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary(new COSDictionary()));
    Matrix matrix = new Matrix();

    // Act
    Paint actualToPaintResult = pdShadingType4.toPaint(matrix);

    // Assert
    assertTrue(actualToPaintResult instanceof Type4ShadingPaint);
    assertEquals(0, actualToPaintResult.getTransparency());
    assertSame(pdShadingType4, ((Type4ShadingPaint) actualToPaintResult).getShading());
    assertSame(matrix, ((Type4ShadingPaint) actualToPaintResult).getMatrix());
  }

  /**
   * Method under test: {@link PDShadingType4#toPaint(Matrix)}
   */
  @Test
  void testToPaint3() {
    // Arrange
    PDShadingType6 pdShadingType6 = new PDShadingType6(new COSDictionary());
    Matrix matrix = new Matrix();

    // Act
    Paint actualToPaintResult = pdShadingType6.toPaint(matrix);

    // Assert
    assertTrue(actualToPaintResult instanceof Type6ShadingPaint);
    assertEquals(0, actualToPaintResult.getTransparency());
    assertSame(pdShadingType6, ((Type6ShadingPaint) actualToPaintResult).getShading());
    assertSame(matrix, ((Type6ShadingPaint) actualToPaintResult).getMatrix());
  }

  /**
   * Method under test:
   * {@link PDShadingType4#collectTriangles(AffineTransform, Matrix)}
   */
  @Test
  void testCollectTriangles() throws IOException {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertTrue(pdShadingType4.collectTriangles(xform, new Matrix()).isEmpty());
  }

  /**
   * Method under test:
   * {@link PDShadingType4#collectTriangles(AffineTransform, Matrix)}
   */
  @Test
  void testCollectTriangles2() throws IOException {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSStream());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertTrue(pdShadingType4.collectTriangles(xform, new Matrix()).isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDShadingType4#PDShadingType4(COSDictionary)}
   *   <li>{@link PDShadingType4#getShadingType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    // Act
    PDShadingType4 actualPdShadingType4 = new PDShadingType4(shadingDictionary);

    // Assert
    assertEquals(4, actualPdShadingType4.getShadingType());
    assertSame(shadingDictionary, actualPdShadingType4.getCOSObject());
  }
}
