package org.apache.pdfbox.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class MatrixDiffblueTest {
  /**
   * Method under test: {@link Matrix#createMatrix(COSBase)}
   */
  @Test
  void testCreateMatrix() {
    // Arrange and Act
    Matrix actualCreateMatrixResult = Matrix.createMatrix(COSBoolean.FALSE);

    // Assert
    assertEquals(0.0f, actualCreateMatrixResult.getShearX());
    assertEquals(0.0f, actualCreateMatrixResult.getShearY());
    assertEquals(0.0f, actualCreateMatrixResult.getTranslateX());
    assertEquals(0.0f, actualCreateMatrixResult.getTranslateY());
    assertEquals(1.0f, actualCreateMatrixResult.getScaleX());
    assertEquals(1.0f, actualCreateMatrixResult.getScaleY());
    assertEquals(1.0f, actualCreateMatrixResult.getScalingFactorX());
    assertEquals(1.0f, actualCreateMatrixResult.getScalingFactorY());
    float[][] values = actualCreateMatrixResult.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link Matrix#createMatrix(COSBase)}
   */
  @Test
  void testCreateMatrix2() {
    // Arrange and Act
    Matrix actualCreateMatrixResult = Matrix.createMatrix(new COSArray());

    // Assert
    assertEquals(0.0f, actualCreateMatrixResult.getShearX());
    assertEquals(0.0f, actualCreateMatrixResult.getShearY());
    assertEquals(0.0f, actualCreateMatrixResult.getTranslateX());
    assertEquals(0.0f, actualCreateMatrixResult.getTranslateY());
    assertEquals(1.0f, actualCreateMatrixResult.getScaleX());
    assertEquals(1.0f, actualCreateMatrixResult.getScaleY());
    assertEquals(1.0f, actualCreateMatrixResult.getScalingFactorX());
    assertEquals(1.0f, actualCreateMatrixResult.getScalingFactorY());
    float[][] values = actualCreateMatrixResult.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link Matrix#createMatrix(COSBase)}
   */
  @Test
  void testCreateMatrix3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray base = new COSArray();
    base.add(object);

    // Act
    Matrix actualCreateMatrixResult = Matrix.createMatrix(base);

    // Assert
    verify(object).getCOSObject();
    assertEquals(0.0f, actualCreateMatrixResult.getShearX());
    assertEquals(0.0f, actualCreateMatrixResult.getShearY());
    assertEquals(0.0f, actualCreateMatrixResult.getTranslateX());
    assertEquals(0.0f, actualCreateMatrixResult.getTranslateY());
    assertEquals(1.0f, actualCreateMatrixResult.getScaleX());
    assertEquals(1.0f, actualCreateMatrixResult.getScaleY());
    assertEquals(1.0f, actualCreateMatrixResult.getScalingFactorX());
    assertEquals(1.0f, actualCreateMatrixResult.getScalingFactorY());
    float[][] values = actualCreateMatrixResult.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link Matrix#createAffineTransform()}
   */
  @Test
  void testCreateAffineTransform() {
    // Arrange and Act
    AffineTransform actualCreateAffineTransformResult = (new Matrix()).createAffineTransform();

    // Assert
    assertEquals(0, actualCreateAffineTransformResult.getType());
    assertEquals(0.0d, actualCreateAffineTransformResult.getShearX());
    assertEquals(0.0d, actualCreateAffineTransformResult.getShearY());
    assertEquals(0.0d, actualCreateAffineTransformResult.getTranslateX());
    assertEquals(0.0d, actualCreateAffineTransformResult.getTranslateY());
    assertEquals(1.0d, actualCreateAffineTransformResult.getDeterminant());
    assertEquals(1.0d, actualCreateAffineTransformResult.getScaleX());
    assertEquals(1.0d, actualCreateAffineTransformResult.getScaleY());
    assertTrue(actualCreateAffineTransformResult.isIdentity());
  }

  /**
   * Method under test: {@link Matrix#getValue(int, int)}
   */
  @Test
  void testGetValue() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new Matrix()).getValue(1, 3));
    assertEquals(0.0f, (new Matrix()).getValue(0, 3));
    assertEquals(1.0f, (new Matrix()).getValue(-1, 3));
  }

  /**
   * Method under test: {@link Matrix#setValue(int, int, float)}
   */
  @Test
  void testSetValue() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act
    matrix.setValue(1, 1, 10.0f);

    // Assert
    assertEquals(10.0f, matrix.getScaleY());
    assertEquals(10.0f, matrix.getScalingFactorY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[1];
    assertEquals(10.0f, floatArray[1]);
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
  }

  /**
   * Method under test: {@link Matrix#getValues()}
   */
  @Test
  void testGetValues() {
    // Arrange and Act
    float[][] actualValues = (new Matrix()).getValues();

    // Assert
    assertEquals(3, actualValues.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, actualValues[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, actualValues[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, actualValues[0], 0.0f);
  }

  /**
   * Method under test: {@link Matrix#concatenate(Matrix)}
   */
  @Test
  void testConcatenate() {
    // Arrange
    Matrix scaleInstance = Matrix.getScaleInstance(Float.NaN, 10.0f);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> scaleInstance.concatenate(new Matrix()));
  }

  /**
   * Method under test: {@link Matrix#concatenate(Matrix)}
   */
  @Test
  void testConcatenate2() {
    // Arrange
    Matrix scaleInstance = Matrix.getScaleInstance(10.0f, Float.NaN);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> scaleInstance.concatenate(new Matrix()));
  }

  /**
   * Method under test: {@link Matrix#concatenate(Matrix)}
   */
  @Test
  void testConcatenate3() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> matrix.concatenate(Matrix.getScaleInstance(10.0f, Float.NaN)));
  }

  /**
   * Method under test: {@link Matrix#concatenate(Matrix)}
   */
  @Test
  void testConcatenate4() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> matrix.concatenate(Matrix.getTranslateInstance(Float.NaN, 10.0f)));
  }

  /**
   * Method under test: {@link Matrix#concatenate(Matrix, Matrix)}
   */
  @Test
  void testConcatenate5() {
    // Arrange
    Matrix a = new Matrix();

    // Act and Assert
    assertEquals(a, Matrix.concatenate(a, new Matrix()));
  }

  /**
   * Method under test: {@link Matrix#concatenate(Matrix, Matrix)}
   */
  @Test
  void testConcatenate6() {
    // Arrange
    Matrix a = Matrix.getScaleInstance(Float.NaN, 10.0f);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Matrix.concatenate(a, new Matrix()));
  }

  /**
   * Method under test: {@link Matrix#concatenate(Matrix, Matrix)}
   */
  @Test
  void testConcatenate7() {
    // Arrange
    Matrix a = Matrix.getScaleInstance(10.0f, Float.NaN);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Matrix.concatenate(a, new Matrix()));
  }

  /**
   * Method under test: {@link Matrix#concatenate(Matrix, Matrix)}
   */
  @Test
  void testConcatenate8() {
    // Arrange
    Matrix a = new Matrix();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Matrix.concatenate(a, Matrix.getScaleInstance(10.0f, Float.NaN)));
  }

  /**
   * Method under test: {@link Matrix#concatenate(Matrix, Matrix)}
   */
  @Test
  void testConcatenate9() {
    // Arrange
    Matrix a = new Matrix();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Matrix.concatenate(a, Matrix.getTranslateInstance(Float.NaN, 10.0f)));
  }

  /**
   * Method under test: {@link Matrix#translate(float, float)}
   */
  @Test
  void testTranslate() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act
    matrix.translate(10.0f, 10.0f);

    // Assert
    assertEquals(10.0f, matrix.getTranslateX());
    assertEquals(10.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(10.0f, floatArray[0]);
    assertEquals(10.0f, floatArray[1]);
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
  }

  /**
   * Method under test: {@link Matrix#translate(float, float)}
   */
  @Test
  void testTranslate2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Matrix()).translate(Float.NaN, 10.0f));
  }

  /**
   * Method under test: {@link Matrix#translate(float, float)}
   */
  @Test
  void testTranslate3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Matrix.getScaleInstance(Float.NaN, 10.0f).translate(10.0f, 10.0f));
  }

  /**
   * Method under test: {@link Matrix#translate(float, float)}
   */
  @Test
  void testTranslate4() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Matrix.getScaleInstance(10.0f, Float.NaN).translate(10.0f, 10.0f));
  }

  /**
   * Method under test: {@link Matrix#translate(float, float)}
   */
  @Test
  void testTranslate5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Matrix.getTranslateInstance(10.0f, Float.NaN).translate(10.0f, 10.0f));
  }

  /**
   * Method under test: {@link Matrix#translate(Vector)}
   */
  @Test
  void testTranslate6() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act
    matrix.translate(new Vector(10.0f, 10.0f));

    // Assert
    assertEquals(10.0f, matrix.getTranslateX());
    assertEquals(10.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(10.0f, floatArray[0]);
    assertEquals(10.0f, floatArray[1]);
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
  }

  /**
   * Method under test: {@link Matrix#translate(Vector)}
   */
  @Test
  void testTranslate7() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> matrix.translate(new Vector(Float.NaN, 10.0f)));
  }

  /**
   * Method under test: {@link Matrix#translate(Vector)}
   */
  @Test
  void testTranslate8() {
    // Arrange
    Matrix scaleInstance = Matrix.getScaleInstance(Float.NaN, 10.0f);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> scaleInstance.translate(new Vector(10.0f, 10.0f)));
  }

  /**
   * Method under test: {@link Matrix#translate(Vector)}
   */
  @Test
  void testTranslate9() {
    // Arrange
    Matrix scaleInstance = Matrix.getScaleInstance(10.0f, Float.NaN);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> scaleInstance.translate(new Vector(10.0f, 10.0f)));
  }

  /**
   * Method under test: {@link Matrix#translate(Vector)}
   */
  @Test
  void testTranslate10() {
    // Arrange
    Matrix translateInstance = Matrix.getTranslateInstance(10.0f, Float.NaN);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> translateInstance.translate(new Vector(10.0f, 10.0f)));
  }

  /**
   * Method under test: {@link Matrix#scale(float, float)}
   */
  @Test
  void testScale() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act
    matrix.scale(10.0f, 10.0f);

    // Assert
    assertEquals(10.0f, matrix.getScaleX());
    assertEquals(10.0f, matrix.getScaleY());
    assertEquals(10.0f, matrix.getScalingFactorX());
    assertEquals(10.0f, matrix.getScalingFactorY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[0];
    assertEquals(10.0f, floatArray[0]);
    float[] floatArray2 = values[1];
    assertEquals(10.0f, floatArray2[1]);
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(3, floatArray2.length);
  }

  /**
   * Method under test: {@link Matrix#scale(float, float)}
   */
  @Test
  void testScale2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Matrix()).scale(Float.NaN, 10.0f));
  }

  /**
   * Method under test: {@link Matrix#scale(float, float)}
   */
  @Test
  void testScale3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Matrix()).scale(10.0f, Float.NaN));
  }

  /**
   * Method under test: {@link Matrix#scale(float, float)}
   */
  @Test
  void testScale4() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Matrix.getScaleInstance(10.0f, Float.NaN).scale(10.0f, 10.0f));
  }

  /**
   * Method under test: {@link Matrix#scale(float, float)}
   */
  @Test
  void testScale5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Matrix.getTranslateInstance(Float.NaN, 10.0f).scale(10.0f, 10.0f));
  }

  /**
   * Method under test: {@link Matrix#scale(float, float)}
   */
  @Test
  void testScale6() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Matrix.getTranslateInstance(10.0f, Float.NaN).scale(10.0f, 10.0f));
  }

  /**
   * Method under test: {@link Matrix#rotate(double)}
   */
  @Test
  void testRotate() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act
    matrix.rotate(10.0d);

    // Assert
    assertEquals(-0.5440211f, matrix.getShearY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[0];
    assertEquals(-0.5440211f, floatArray[1]);
    assertEquals(-0.8390715f, matrix.getScaleX());
    assertEquals(-0.8390715f, matrix.getScaleY());
    assertEquals(-0.8390715f, floatArray[0]);
    float[] floatArray2 = values[1];
    assertEquals(-0.8390715f, floatArray2[1]);
    assertEquals(0.5440211f, matrix.getShearX());
    assertEquals(0.5440211f, floatArray2[0]);
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(3, floatArray2.length);
  }

  /**
   * Method under test: {@link Matrix#rotate(double)}
   */
  @Test
  void testRotate2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Matrix()).rotate(Double.NaN));
  }

  /**
   * Method under test: {@link Matrix#rotate(double)}
   */
  @Test
  void testRotate3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Matrix.getScaleInstance(1.0f, Float.NaN).rotate(10.0d));
  }

  /**
   * Method under test: {@link Matrix#multiply(Matrix)}
   */
  @Test
  void testMultiply() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act and Assert
    assertEquals(matrix, matrix.multiply(new Matrix()));
  }

  /**
   * Method under test: {@link Matrix#multiply(Matrix)}
   */
  @Test
  void testMultiply2() {
    // Arrange
    Matrix scaleInstance = Matrix.getScaleInstance(Float.NaN, 10.0f);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> scaleInstance.multiply(new Matrix()));
  }

  /**
   * Method under test: {@link Matrix#multiply(Matrix)}
   */
  @Test
  void testMultiply3() {
    // Arrange
    Matrix scaleInstance = Matrix.getScaleInstance(10.0f, Float.NaN);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> scaleInstance.multiply(new Matrix()));
  }

  /**
   * Method under test: {@link Matrix#multiply(Matrix)}
   */
  @Test
  void testMultiply4() {
    // Arrange
    Matrix translateInstance = Matrix.getTranslateInstance(Float.NaN, 10.0f);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> translateInstance.multiply(new Matrix()));
  }

  /**
   * Method under test: {@link Matrix#multiply(Matrix)}
   */
  @Test
  void testMultiply5() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> matrix.multiply(Matrix.getScaleInstance(10.0f, Float.NaN)));
  }

  /**
   * Method under test: {@link Matrix#transform(Vector)}
   */
  @Test
  void testTransform() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act
    Vector actualTransformResult = matrix.transform(new Vector(10.0f, 10.0f));

    // Assert
    assertEquals(10.0f, actualTransformResult.getX());
    assertEquals(10.0f, actualTransformResult.getY());
  }

  /**
   * Method under test: {@link Matrix#transformPoint(float, float)}
   */
  @Test
  void testTransformPoint() {
    // Arrange and Act
    Point2D.Float actualTransformPointResult = (new Matrix()).transformPoint(10.0f, 10.0f);

    // Assert
    assertEquals(10.0d, actualTransformPointResult.getX());
    assertEquals(10.0d, actualTransformPointResult.getY());
    assertEquals(10.0f, actualTransformPointResult.x);
    assertEquals(10.0f, actualTransformPointResult.y);
  }

  /**
   * Method under test: {@link Matrix#getScaleInstance(float, float)}
   */
  @Test
  void testGetScaleInstance() {
    // Arrange and Act
    Matrix actualScaleInstance = Matrix.getScaleInstance(10.0f, 10.0f);

    // Assert
    assertEquals(0.0f, actualScaleInstance.getShearX());
    assertEquals(0.0f, actualScaleInstance.getShearY());
    assertEquals(0.0f, actualScaleInstance.getTranslateX());
    assertEquals(0.0f, actualScaleInstance.getTranslateY());
    assertEquals(10.0f, actualScaleInstance.getScaleX());
    assertEquals(10.0f, actualScaleInstance.getScaleY());
    assertEquals(10.0f, actualScaleInstance.getScalingFactorX());
    assertEquals(10.0f, actualScaleInstance.getScalingFactorY());
    float[][] values = actualScaleInstance.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 10.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link Matrix#getTranslateInstance(float, float)}
   */
  @Test
  void testGetTranslateInstance() {
    // Arrange and Act
    Matrix actualTranslateInstance = Matrix.getTranslateInstance(10.0f, 10.0f);

    // Assert
    assertEquals(0.0f, actualTranslateInstance.getShearX());
    assertEquals(0.0f, actualTranslateInstance.getShearY());
    assertEquals(1.0f, actualTranslateInstance.getScaleX());
    assertEquals(1.0f, actualTranslateInstance.getScaleY());
    assertEquals(1.0f, actualTranslateInstance.getScalingFactorX());
    assertEquals(1.0f, actualTranslateInstance.getScalingFactorY());
    assertEquals(10.0f, actualTranslateInstance.getTranslateX());
    assertEquals(10.0f, actualTranslateInstance.getTranslateY());
    float[][] values = actualTranslateInstance.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{10.0f, 10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Method under test: {@link Matrix#getRotateInstance(double, float, float)}
   */
  @Test
  void testGetRotateInstance() {
    // Arrange and Act
    Matrix actualRotateInstance = Matrix.getRotateInstance(10.0d, 10.0f, 10.0f);

    // Assert
    assertEquals(-0.5440211f, actualRotateInstance.getShearY());
    assertEquals(-0.8390715f, actualRotateInstance.getScaleX());
    assertEquals(-0.8390715f, actualRotateInstance.getScaleY());
    assertEquals(0.5440211f, actualRotateInstance.getShearX());
    assertEquals(1.0f, actualRotateInstance.getScalingFactorX());
    assertEquals(1.0f, actualRotateInstance.getScalingFactorY());
    assertEquals(10.0f, actualRotateInstance.getTranslateX());
    assertEquals(10.0f, actualRotateInstance.getTranslateY());
    float[][] values = actualRotateInstance.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.8390715f, -0.5440211f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{0.5440211f, -0.8390715f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{10.0f, 10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Method under test: {@link Matrix#clone()}
   */
  @Test
  void testClone() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act and Assert
    assertEquals(matrix, matrix.clone());
  }

  /**
   * Method under test: {@link Matrix#getScalingFactorX()}
   */
  @Test
  void testGetScalingFactorX() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new Matrix()).getScalingFactorX());
  }

  /**
   * Method under test: {@link Matrix#getScalingFactorY()}
   */
  @Test
  void testGetScalingFactorY() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new Matrix()).getScalingFactorY());
  }

  /**
   * Method under test: {@link Matrix#getScaleX()}
   */
  @Test
  void testGetScaleX() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new Matrix()).getScaleX());
  }

  /**
   * Method under test: {@link Matrix#getShearY()}
   */
  @Test
  void testGetShearY() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new Matrix()).getShearY());
  }

  /**
   * Method under test: {@link Matrix#getShearX()}
   */
  @Test
  void testGetShearX() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new Matrix()).getShearX());
  }

  /**
   * Method under test: {@link Matrix#getScaleY()}
   */
  @Test
  void testGetScaleY() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new Matrix()).getScaleY());
  }

  /**
   * Method under test: {@link Matrix#getTranslateX()}
   */
  @Test
  void testGetTranslateX() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new Matrix()).getTranslateX());
  }

  /**
   * Method under test: {@link Matrix#getTranslateY()}
   */
  @Test
  void testGetTranslateY() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new Matrix()).getTranslateY());
  }

  /**
   * Method under test: {@link Matrix#toCOSArray()}
   */
  @Test
  void testToCOSArray() {
    // Arrange, Act and Assert
    List<? extends COSBase> toListResult = (new Matrix()).toCOSArray().toList();
    assertEquals(6, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    COSBase getResult5 = toListResult.get(4);
    assertTrue(getResult5 instanceof COSFloat);
    COSBase getResult6 = toListResult.get(5);
    assertTrue(getResult6 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertEquals(getResult, getResult4);
    assertEquals(getResult2, getResult3);
    assertEquals(getResult2, getResult5);
    assertEquals(getResult2, getResult6);
  }

  /**
   * Method under test: {@link Matrix#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Matrix scaleInstance = Matrix.getScaleInstance(10.0f, 10.0f);

    // Act and Assert
    assertNotEquals(scaleInstance, new Matrix());
  }

  /**
   * Method under test: {@link Matrix#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Matrix(), null);
  }

  /**
   * Method under test: {@link Matrix#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Matrix(), "Different type to Matrix");
  }

  /**
   * Method under test: {@link Matrix#Matrix()}
   */
  @Test
  void testNewMatrix() {
    // Arrange and Act
    Matrix actualMatrix = new Matrix();

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
   * Method under test:
   * {@link Matrix#Matrix(float, float, float, float, float, float)}
   */
  @Test
  void testNewMatrix2() {
    // Arrange and Act
    Matrix actualMatrix = new Matrix(10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f);

    // Assert
    assertEquals(10.0f, actualMatrix.getScaleX());
    assertEquals(10.0f, actualMatrix.getScaleY());
    assertEquals(10.0f, actualMatrix.getShearX());
    assertEquals(10.0f, actualMatrix.getShearY());
    assertEquals(10.0f, actualMatrix.getTranslateX());
    assertEquals(10.0f, actualMatrix.getTranslateY());
    assertEquals(14.142136f, actualMatrix.getScalingFactorX());
    assertEquals(14.142136f, actualMatrix.getScalingFactorY());
    float[][] values = actualMatrix.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{10.0f, 10.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{10.0f, 10.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{10.0f, 10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Method under test: {@link Matrix#Matrix(AffineTransform)}
   */
  @Test
  void testNewMatrix3() {
    // Arrange and Act
    Matrix actualMatrix = new Matrix(new AffineTransform());

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
   * Method under test: {@link Matrix#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("[1.0,0.0,0.0,1.0,0.0,0.0]", (new Matrix()).toString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Matrix#equals(Object)}
   *   <li>{@link Matrix#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Matrix matrix = new Matrix();
    Matrix matrix2 = new Matrix();

    // Act and Assert
    assertEquals(matrix, matrix2);
    int expectedHashCodeResult = matrix.hashCode();
    assertEquals(expectedHashCodeResult, matrix2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Matrix#equals(Object)}
   *   <li>{@link Matrix#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act and Assert
    assertEquals(matrix, matrix);
    int expectedHashCodeResult = matrix.hashCode();
    assertEquals(expectedHashCodeResult, matrix.hashCode());
  }
}
