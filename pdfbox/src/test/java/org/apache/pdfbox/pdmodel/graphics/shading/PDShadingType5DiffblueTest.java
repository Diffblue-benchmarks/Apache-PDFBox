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

class PDShadingType5DiffblueTest {
  /**
   * Method under test: {@link PDShadingType5#getVerticesPerRow()}
   */
  @Test
  void testGetVerticesPerRow() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDShadingType5(new COSDictionary())).getVerticesPerRow());
  }

  /**
   * Method under test: {@link PDShadingType5#setVerticesPerRow(int)}
   */
  @Test
  void testSetVerticesPerRow() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType5 pdShadingType5 = new PDShadingType5(shadingDictionary);

    // Act
    pdShadingType5.setVerticesPerRow(1);

    // Assert
    assertEquals(1, pdShadingType5.getVerticesPerRow());
    assertSame(shadingDictionary, pdShadingType5.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingType5#setVerticesPerRow(int)}
   */
  @Test
  void testSetVerticesPerRow2() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType5 pdShadingType5 = new PDShadingType5(shadingDictionary);

    // Act
    pdShadingType5.setVerticesPerRow(Integer.MIN_VALUE);

    // Assert
    assertEquals(Integer.MIN_VALUE, pdShadingType5.getVerticesPerRow());
    assertSame(shadingDictionary, pdShadingType5.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingType5#toPaint(Matrix)}
   */
  @Test
  void testToPaint() {
    // Arrange
    PDShadingType5 pdShadingType5 = new PDShadingType5(new COSDictionary());
    Matrix matrix = new Matrix();

    // Act
    Paint actualToPaintResult = pdShadingType5.toPaint(matrix);

    // Assert
    assertTrue(actualToPaintResult instanceof Type5ShadingPaint);
    assertEquals(0, actualToPaintResult.getTransparency());
    assertSame(pdShadingType5, ((Type5ShadingPaint) actualToPaintResult).getShading());
    assertSame(matrix, ((Type5ShadingPaint) actualToPaintResult).getMatrix());
  }

  /**
   * Method under test: {@link PDShadingType5#toPaint(Matrix)}
   */
  @Test
  void testToPaint2() {
    // Arrange
    PDShadingType5 pdShadingType5 = new PDShadingType5(new COSDictionary(new COSDictionary()));
    Matrix matrix = new Matrix();

    // Act
    Paint actualToPaintResult = pdShadingType5.toPaint(matrix);

    // Assert
    assertTrue(actualToPaintResult instanceof Type5ShadingPaint);
    assertEquals(0, actualToPaintResult.getTransparency());
    assertSame(pdShadingType5, ((Type5ShadingPaint) actualToPaintResult).getShading());
    assertSame(matrix, ((Type5ShadingPaint) actualToPaintResult).getMatrix());
  }

  /**
   * Method under test:
   * {@link PDShadingType5#collectTriangles(AffineTransform, Matrix)}
   */
  @Test
  void testCollectTriangles() throws IOException {
    // Arrange
    PDShadingType5 pdShadingType5 = new PDShadingType5(new COSDictionary());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertTrue(pdShadingType5.collectTriangles(xform, new Matrix()).isEmpty());
  }

  /**
   * Method under test:
   * {@link PDShadingType5#collectTriangles(AffineTransform, Matrix)}
   */
  @Test
  void testCollectTriangles2() throws IOException {
    // Arrange
    PDShadingType5 pdShadingType5 = new PDShadingType5(new COSStream());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertTrue(pdShadingType5.collectTriangles(xform, new Matrix()).isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDShadingType5#PDShadingType5(COSDictionary)}
   *   <li>{@link PDShadingType5#getShadingType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    // Act
    PDShadingType5 actualPdShadingType5 = new PDShadingType5(shadingDictionary);

    // Assert
    assertEquals(5, actualPdShadingType5.getShadingType());
    assertSame(shadingDictionary, actualPdShadingType5.getCOSObject());
  }
}
