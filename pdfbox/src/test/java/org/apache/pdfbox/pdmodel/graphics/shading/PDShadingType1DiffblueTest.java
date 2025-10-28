package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Paint;
import java.awt.geom.AffineTransform;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class PDShadingType1DiffblueTest {
  /**
   * Method under test: {@link PDShadingType1#getMatrix()}
   */
  @Test
  void testGetMatrix() {
    // Arrange and Act
    Matrix actualMatrix = (new PDShadingType1(new COSDictionary())).getMatrix();

    // Assert
    assertEquals(0.0f, actualMatrix.getShearX());
    assertEquals(0.0f, actualMatrix.getShearY());
    assertEquals(0.0f, actualMatrix.getTranslateX());
    assertEquals(0.0f, actualMatrix.getTranslateY());
    assertEquals(1.0f, actualMatrix.getScaleX());
    assertEquals(1.0f, actualMatrix.getScaleY());
    assertEquals(1.0f, actualMatrix.getScalingFactorX());
    assertEquals(1.0f, actualMatrix.getScalingFactorY());
    float[][] values = actualMatrix.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDShadingType1#setMatrix(AffineTransform)}
   */
  @Test
  void testSetMatrix() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);

    // Act
    pdShadingType1.setMatrix(new AffineTransform());

    // Assert
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingType1#getDomain()}
   */
  @Test
  void testGetDomain() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType1(new COSDictionary())).getDomain());
  }

  /**
   * Method under test: {@link PDShadingType1#getDomain()}
   */
  @Test
  void testGetDomain2() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());
    COSArray newDomain = new COSArray();
    pdShadingType1.setDomain(newDomain);

    // Act
    COSArray actualDomain = pdShadingType1.getDomain();

    // Assert
    assertTrue(actualDomain.toList().isEmpty());
    assertSame(newDomain, actualDomain);
  }

  /**
   * Method under test: {@link PDShadingType1#getDomain()}
   */
  @Test
  void testGetDomain3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray newDomain = new COSArray();
    newDomain.add(object);

    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());
    pdShadingType1.setDomain(newDomain);

    // Act
    COSArray actualDomain = pdShadingType1.getDomain();

    // Assert
    verify(object).getCOSObject();
    assertSame(newDomain, actualDomain);
  }

  /**
   * Method under test: {@link PDShadingType1#setDomain(COSArray)}
   */
  @Test
  void testSetDomain() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);
    COSArray newDomain = new COSArray();

    // Act
    pdShadingType1.setDomain(newDomain);

    // Assert
    assertSame(newDomain, pdShadingType1.getDomain());
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingType1#setDomain(COSArray)}
   */
  @Test
  void testSetDomain2() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);

    // Act
    pdShadingType1.setDomain(null);

    // Assert
    assertNull(pdShadingType1.getDomain());
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingType1#setDomain(COSArray)}
   */
  @Test
  void testSetDomain3() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType1 pdShadingType1 = new PDShadingType1(shadingDictionary);
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray newDomain = new COSArray();
    newDomain.add(object);

    // Act
    pdShadingType1.setDomain(newDomain);

    // Assert
    verify(object).getCOSObject();
    assertSame(newDomain, pdShadingType1.getDomain());
    assertSame(shadingDictionary, pdShadingType1.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingType1#toPaint(Matrix)}
   */
  @Test
  void testToPaint() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());
    Matrix matrix = new Matrix();

    // Act
    Paint actualToPaintResult = pdShadingType1.toPaint(matrix);

    // Assert
    assertTrue(actualToPaintResult instanceof Type1ShadingPaint);
    assertEquals(0, actualToPaintResult.getTransparency());
    assertSame(pdShadingType1, ((Type1ShadingPaint) actualToPaintResult).getShading());
    assertSame(matrix, ((Type1ShadingPaint) actualToPaintResult).getMatrix());
  }

  /**
   * Method under test: {@link PDShadingType1#toPaint(Matrix)}
   */
  @Test
  void testToPaint2() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary(new COSDictionary()));
    Matrix matrix = new Matrix();

    // Act
    Paint actualToPaintResult = pdShadingType1.toPaint(matrix);

    // Assert
    assertTrue(actualToPaintResult instanceof Type1ShadingPaint);
    assertEquals(0, actualToPaintResult.getTransparency());
    assertSame(pdShadingType1, ((Type1ShadingPaint) actualToPaintResult).getShading());
    assertSame(matrix, ((Type1ShadingPaint) actualToPaintResult).getMatrix());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDShadingType1#PDShadingType1(COSDictionary)}
   *   <li>{@link PDShadingType1#getShadingType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    // Act
    PDShadingType1 actualPdShadingType1 = new PDShadingType1(shadingDictionary);

    // Assert
    assertEquals(1, actualPdShadingType1.getShadingType());
    assertSame(shadingDictionary, actualPdShadingType1.getCOSObject());
  }
}
