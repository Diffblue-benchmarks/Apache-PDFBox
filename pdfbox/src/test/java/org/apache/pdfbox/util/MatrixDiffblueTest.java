package org.apache.pdfbox.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSFloat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MatrixDiffblueTest {
  /**
   * Test {@link Matrix#Matrix()}.
   *
   * <p>Method under test: {@link Matrix#Matrix()}
   */
  @Test
  @DisplayName("Test new Matrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.<init>()"})
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
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Matrix#Matrix(float, float, float, float, float, float)}.
   *
   * <p>Method under test: {@link Matrix#Matrix(float, float, float, float, float, float)}
   */
  @Test
  @DisplayName("Test new Matrix(float, float, float, float, float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.<init>(float, float, float, float, float, float)"})
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
    assertArrayEquals(new float[] {10.0f, 10.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {10.0f, 10.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {10.0f, 10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link Matrix#Matrix(AffineTransform)}.
   *
   * <ul>
   *   <li>When {@link AffineTransform#AffineTransform()}.
   *   <li>Then return ShearX is zero.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#Matrix(AffineTransform)}
   */
  @Test
  @DisplayName(
      "Test new Matrix(AffineTransform); when AffineTransform(); then return ShearX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.<init>(AffineTransform)"})
  void testNewMatrix_whenAffineTransform_thenReturnShearXIsZero() {
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
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Matrix#createMatrix(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#createMatrix(COSBase)}
   */
  @Test
  @DisplayName("Test createMatrix(COSBase); when COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix Matrix.createMatrix(COSBase)"})
  void testCreateMatrix_whenCOSArray() {
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
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Matrix#createMatrix(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#createMatrix(COSBase)}
   */
  @Test
  @DisplayName("Test createMatrix(COSBase); when FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix Matrix.createMatrix(COSBase)"})
  void testCreateMatrix_whenFalse() {
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
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Matrix#createAffineTransform()}.
   *
   * <p>Method under test: {@link Matrix#createAffineTransform()}
   */
  @Test
  @DisplayName("Test createAffineTransform()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AffineTransform Matrix.createAffineTransform()"})
  void testCreateAffineTransform() {
    // Arrange and Act
    AffineTransform actualCreateAffineTransformResult = new Matrix().createAffineTransform();

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
   * Test {@link Matrix#getValue(int, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#getValue(int, int)}
   */
  @Test
  @DisplayName("Test getValue(int, int); when minus one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Matrix.getValue(int, int)"})
  void testGetValue_whenMinusOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new Matrix().getValue(-1, 3));
  }

  /**
   * Test {@link Matrix#getValue(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#getValue(int, int)}
   */
  @Test
  @DisplayName("Test getValue(int, int); when one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Matrix.getValue(int, int)"})
  void testGetValue_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new Matrix().getValue(1, 1));
  }

  /**
   * Test {@link Matrix#getValue(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#getValue(int, int)}
   */
  @Test
  @DisplayName("Test getValue(int, int); when one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Matrix.getValue(int, int)"})
  void testGetValue_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new Matrix().getValue(1, 3));
  }

  /**
   * Test {@link Matrix#getValue(int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#getValue(int, int)}
   */
  @Test
  @DisplayName("Test getValue(int, int); when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Matrix.getValue(int, int)"})
  void testGetValue_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new Matrix().getValue(0, 3));
  }

  /**
   * Test {@link Matrix#setValue(int, int, float)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link Matrix#Matrix()} ScaleY is ten.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#setValue(int, int, float)}
   */
  @Test
  @DisplayName("Test setValue(int, int, float); when one; then Matrix() ScaleY is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.setValue(int, int, float)"})
  void testSetValue_whenOne_thenMatrixScaleYIsTen() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act
    matrix.setValue(1, 1, 10.0f);

    // Assert
    assertEquals(10.0f, matrix.getScaleY());
    assertEquals(10.0f, matrix.getScalingFactorY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {0.0f, 10.0f, 0.0f}, values[1], 0.0f);
  }

  /**
   * Test {@link Matrix#getValues()}.
   *
   * <p>Method under test: {@link Matrix#getValues()}
   */
  @Test
  @DisplayName("Test getValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[][] Matrix.getValues()"})
  void testGetValues() {
    // Arrange and Act
    float[][] actualValues = new Matrix().getValues();

    // Assert
    assertEquals(3, actualValues.length);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, actualValues[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, actualValues[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, actualValues[0], 0.0f);
  }

  /**
   * Test {@link Matrix#concatenate(Matrix, Matrix)} with {@code a}, {@code b}.
   *
   * <ul>
   *   <li>When {@link Matrix#Matrix()}.
   *   <li>Then return {@link Matrix#Matrix()}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#concatenate(Matrix, Matrix)}
   */
  @Test
  @DisplayName(
      "Test concatenate(Matrix, Matrix) with 'a', 'b'; when Matrix(); then return Matrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix Matrix.concatenate(Matrix, Matrix)"})
  void testConcatenateWithAB_whenMatrix_thenReturnMatrix() {
    // Arrange
    Matrix a = new Matrix();

    // Act
    Matrix actualConcatenateResult = Matrix.concatenate(a, new Matrix());

    // Assert
    assertEquals(a, actualConcatenateResult);
  }

  /**
   * Test {@link Matrix#concatenate(Matrix, Matrix)} with {@code a}, {@code b}.
   *
   * <ul>
   *   <li>When ScaleInstance {@link Float#NaN} is ten.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#concatenate(Matrix, Matrix)}
   */
  @Test
  @DisplayName("Test concatenate(Matrix, Matrix) with 'a', 'b'; when ScaleInstance NaN is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix Matrix.concatenate(Matrix, Matrix)"})
  void testConcatenateWithAB_whenScaleInstanceNaNIsTen() {
    // Arrange
    Matrix a = Matrix.getScaleInstance(Float.NaN, 10.0f);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Matrix.concatenate(a, new Matrix()));
  }

  /**
   * Test {@link Matrix#concatenate(Matrix, Matrix)} with {@code a}, {@code b}.
   *
   * <ul>
   *   <li>When ScaleInstance ten is {@link Float#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#concatenate(Matrix, Matrix)}
   */
  @Test
  @DisplayName("Test concatenate(Matrix, Matrix) with 'a', 'b'; when ScaleInstance ten is NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix Matrix.concatenate(Matrix, Matrix)"})
  void testConcatenateWithAB_whenScaleInstanceTenIsNaN() {
    // Arrange
    Matrix a = Matrix.getScaleInstance(10.0f, Float.NaN);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Matrix.concatenate(a, new Matrix()));
  }

  /**
   * Test {@link Matrix#concatenate(Matrix, Matrix)} with {@code a}, {@code b}.
   *
   * <ul>
   *   <li>When ScaleInstance ten is {@link Float#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#concatenate(Matrix, Matrix)}
   */
  @Test
  @DisplayName("Test concatenate(Matrix, Matrix) with 'a', 'b'; when ScaleInstance ten is NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix Matrix.concatenate(Matrix, Matrix)"})
  void testConcatenateWithAB_whenScaleInstanceTenIsNaN2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Matrix.concatenate(new Matrix(), Matrix.getScaleInstance(10.0f, Float.NaN)));
  }

  /**
   * Test {@link Matrix#concatenate(Matrix, Matrix)} with {@code a}, {@code b}.
   *
   * <ul>
   *   <li>When TranslateInstance {@link Float#NaN} is ten.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#concatenate(Matrix, Matrix)}
   */
  @Test
  @DisplayName("Test concatenate(Matrix, Matrix) with 'a', 'b'; when TranslateInstance NaN is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix Matrix.concatenate(Matrix, Matrix)"})
  void testConcatenateWithAB_whenTranslateInstanceNaNIsTen() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Matrix.concatenate(new Matrix(), Matrix.getTranslateInstance(Float.NaN, 10.0f)));
  }

  /**
   * Test {@link Matrix#concatenate(Matrix)} with {@code matrix}.
   *
   * <ul>
   *   <li>Given ScaleInstance {@link Float#NaN} is ten.
   *   <li>When {@link Matrix#Matrix()}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#concatenate(Matrix)}
   */
  @Test
  @DisplayName(
      "Test concatenate(Matrix) with 'matrix'; given ScaleInstance NaN is ten; when Matrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.concatenate(Matrix)"})
  void testConcatenateWithMatrix_givenScaleInstanceNaNIsTen_whenMatrix() {
    // Arrange
    Matrix scaleInstance = Matrix.getScaleInstance(Float.NaN, 10.0f);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> scaleInstance.concatenate(new Matrix()));
  }

  /**
   * Test {@link Matrix#concatenate(Matrix)} with {@code matrix}.
   *
   * <ul>
   *   <li>Given ScaleInstance ten is {@link Float#NaN}.
   *   <li>When {@link Matrix#Matrix()}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#concatenate(Matrix)}
   */
  @Test
  @DisplayName(
      "Test concatenate(Matrix) with 'matrix'; given ScaleInstance ten is NaN; when Matrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.concatenate(Matrix)"})
  void testConcatenateWithMatrix_givenScaleInstanceTenIsNaN_whenMatrix() {
    // Arrange
    Matrix scaleInstance = Matrix.getScaleInstance(10.0f, Float.NaN);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> scaleInstance.concatenate(new Matrix()));
  }

  /**
   * Test {@link Matrix#concatenate(Matrix)} with {@code matrix}.
   *
   * <ul>
   *   <li>When ScaleInstance ten is {@link Float#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#concatenate(Matrix)}
   */
  @Test
  @DisplayName("Test concatenate(Matrix) with 'matrix'; when ScaleInstance ten is NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.concatenate(Matrix)"})
  void testConcatenateWithMatrix_whenScaleInstanceTenIsNaN() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Matrix().concatenate(Matrix.getScaleInstance(10.0f, Float.NaN)));
  }

  /**
   * Test {@link Matrix#concatenate(Matrix)} with {@code matrix}.
   *
   * <ul>
   *   <li>When TranslateInstance {@link Float#NaN} is ten.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#concatenate(Matrix)}
   */
  @Test
  @DisplayName("Test concatenate(Matrix) with 'matrix'; when TranslateInstance NaN is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.concatenate(Matrix)"})
  void testConcatenateWithMatrix_whenTranslateInstanceNaNIsTen() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Matrix().concatenate(Matrix.getTranslateInstance(Float.NaN, 10.0f)));
  }

  /**
   * Test {@link Matrix#translate(float, float)} with {@code tx}, {@code ty}.
   *
   * <ul>
   *   <li>Given {@link Matrix#Matrix()}.
   *   <li>When {@link Float#NaN}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#translate(float, float)}
   */
  @Test
  @DisplayName(
      "Test translate(float, float) with 'tx', 'ty'; given Matrix(); when NaN; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.translate(float, float)"})
  void testTranslateWithTxTy_givenMatrix_whenNaN_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Matrix().translate(Float.NaN, 10.0f));
  }

  /**
   * Test {@link Matrix#translate(float, float)} with {@code tx}, {@code ty}.
   *
   * <ul>
   *   <li>Given {@link Matrix#Matrix()}.
   *   <li>When ten.
   *   <li>Then {@link Matrix#Matrix()} TranslateX is ten.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#translate(float, float)}
   */
  @Test
  @DisplayName(
      "Test translate(float, float) with 'tx', 'ty'; given Matrix(); when ten; then Matrix() TranslateX is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.translate(float, float)"})
  void testTranslateWithTxTy_givenMatrix_whenTen_thenMatrixTranslateXIsTen() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act
    matrix.translate(10.0f, 10.0f);

    // Assert
    assertEquals(10.0f, matrix.getTranslateX());
    assertEquals(10.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {10.0f, 10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link Matrix#translate(float, float)} with {@code tx}, {@code ty}.
   *
   * <ul>
   *   <li>Given ScaleInstance {@link Float#NaN} is ten.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#translate(float, float)}
   */
  @Test
  @DisplayName("Test translate(float, float) with 'tx', 'ty'; given ScaleInstance NaN is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.translate(float, float)"})
  void testTranslateWithTxTy_givenScaleInstanceNaNIsTen() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Matrix.getScaleInstance(Float.NaN, 10.0f).translate(10.0f, 10.0f));
  }

  /**
   * Test {@link Matrix#translate(float, float)} with {@code tx}, {@code ty}.
   *
   * <ul>
   *   <li>Given ScaleInstance ten is {@link Float#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#translate(float, float)}
   */
  @Test
  @DisplayName("Test translate(float, float) with 'tx', 'ty'; given ScaleInstance ten is NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.translate(float, float)"})
  void testTranslateWithTxTy_givenScaleInstanceTenIsNaN() {
    // Arrange
    Matrix scaleInstance = Matrix.getScaleInstance(10.0f, Float.NaN);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> scaleInstance.translate(10.0f, 10.0f));
  }

  /**
   * Test {@link Matrix#translate(float, float)} with {@code tx}, {@code ty}.
   *
   * <ul>
   *   <li>Given TranslateInstance ten is {@link Float#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#translate(float, float)}
   */
  @Test
  @DisplayName("Test translate(float, float) with 'tx', 'ty'; given TranslateInstance ten is NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.translate(float, float)"})
  void testTranslateWithTxTy_givenTranslateInstanceTenIsNaN() {
    // Arrange
    Matrix translateInstance = Matrix.getTranslateInstance(10.0f, Float.NaN);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> translateInstance.translate(10.0f, 10.0f));
  }

  /**
   * Test {@link Matrix#translate(Vector)} with {@code vector}.
   *
   * <ul>
   *   <li>Given {@link Matrix#Matrix()}.
   *   <li>Then {@link Matrix#Matrix()} TranslateX is ten.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#translate(Vector)}
   */
  @Test
  @DisplayName(
      "Test translate(Vector) with 'vector'; given Matrix(); then Matrix() TranslateX is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.translate(Vector)"})
  void testTranslateWithVector_givenMatrix_thenMatrixTranslateXIsTen() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act
    matrix.translate(new Vector(10.0f, 10.0f));

    // Assert
    assertEquals(10.0f, matrix.getTranslateX());
    assertEquals(10.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {10.0f, 10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link Matrix#translate(Vector)} with {@code vector}.
   *
   * <ul>
   *   <li>Given {@link Matrix#Matrix()}.
   *   <li>When {@link Vector#Vector(float, float)} with x is {@link Float#NaN} and y is ten.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#translate(Vector)}
   */
  @Test
  @DisplayName(
      "Test translate(Vector) with 'vector'; given Matrix(); when Vector(float, float) with x is NaN and y is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.translate(Vector)"})
  void testTranslateWithVector_givenMatrix_whenVectorWithXIsNaNAndYIsTen() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> matrix.translate(new Vector(Float.NaN, 10.0f)));
  }

  /**
   * Test {@link Matrix#translate(Vector)} with {@code vector}.
   *
   * <ul>
   *   <li>Given ScaleInstance {@link Float#NaN} is ten.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#translate(Vector)}
   */
  @Test
  @DisplayName("Test translate(Vector) with 'vector'; given ScaleInstance NaN is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.translate(Vector)"})
  void testTranslateWithVector_givenScaleInstanceNaNIsTen() {
    // Arrange
    Matrix scaleInstance = Matrix.getScaleInstance(Float.NaN, 10.0f);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> scaleInstance.translate(new Vector(10.0f, 10.0f)));
  }

  /**
   * Test {@link Matrix#translate(Vector)} with {@code vector}.
   *
   * <ul>
   *   <li>Given ScaleInstance ten is {@link Float#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#translate(Vector)}
   */
  @Test
  @DisplayName("Test translate(Vector) with 'vector'; given ScaleInstance ten is NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.translate(Vector)"})
  void testTranslateWithVector_givenScaleInstanceTenIsNaN() {
    // Arrange
    Matrix scaleInstance = Matrix.getScaleInstance(10.0f, Float.NaN);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> scaleInstance.translate(new Vector(10.0f, 10.0f)));
  }

  /**
   * Test {@link Matrix#translate(Vector)} with {@code vector}.
   *
   * <ul>
   *   <li>Given TranslateInstance ten is {@link Float#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#translate(Vector)}
   */
  @Test
  @DisplayName("Test translate(Vector) with 'vector'; given TranslateInstance ten is NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.translate(Vector)"})
  void testTranslateWithVector_givenTranslateInstanceTenIsNaN() {
    // Arrange
    Matrix translateInstance = Matrix.getTranslateInstance(10.0f, Float.NaN);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> translateInstance.translate(new Vector(10.0f, 10.0f)));
  }

  /**
   * Test {@link Matrix#scale(float, float)}.
   *
   * <ul>
   *   <li>Given {@link Matrix#Matrix()}.
   *   <li>When {@link Float#NaN}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#scale(float, float)}
   */
  @Test
  @DisplayName(
      "Test scale(float, float); given Matrix(); when NaN; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.scale(float, float)"})
  void testScale_givenMatrix_whenNaN_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Matrix().scale(Float.NaN, 10.0f));
  }

  /**
   * Test {@link Matrix#scale(float, float)}.
   *
   * <ul>
   *   <li>Given {@link Matrix#Matrix()}.
   *   <li>When {@link Float#NaN}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#scale(float, float)}
   */
  @Test
  @DisplayName(
      "Test scale(float, float); given Matrix(); when NaN; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.scale(float, float)"})
  void testScale_givenMatrix_whenNaN_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Matrix().scale(10.0f, Float.NaN));
  }

  /**
   * Test {@link Matrix#scale(float, float)}.
   *
   * <ul>
   *   <li>Given {@link Matrix#Matrix()}.
   *   <li>When ten.
   *   <li>Then {@link Matrix#Matrix()} ScaleX is ten.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#scale(float, float)}
   */
  @Test
  @DisplayName("Test scale(float, float); given Matrix(); when ten; then Matrix() ScaleX is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.scale(float, float)"})
  void testScale_givenMatrix_whenTen_thenMatrixScaleXIsTen() {
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
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {0.0f, 10.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {10.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Matrix#scale(float, float)}.
   *
   * <ul>
   *   <li>Given ScaleInstance ten is {@link Float#NaN}.
   *   <li>When ten.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#scale(float, float)}
   */
  @Test
  @DisplayName(
      "Test scale(float, float); given ScaleInstance ten is NaN; when ten; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.scale(float, float)"})
  void testScale_givenScaleInstanceTenIsNaN_whenTen_thenThrowIllegalArgumentException() {
    // Arrange
    Matrix scaleInstance = Matrix.getScaleInstance(10.0f, Float.NaN);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> scaleInstance.scale(10.0f, 10.0f));
  }

  /**
   * Test {@link Matrix#scale(float, float)}.
   *
   * <ul>
   *   <li>Given TranslateInstance {@link Float#NaN} is ten.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#scale(float, float)}
   */
  @Test
  @DisplayName(
      "Test scale(float, float); given TranslateInstance NaN is ten; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.scale(float, float)"})
  void testScale_givenTranslateInstanceNaNIsTen_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Matrix.getTranslateInstance(Float.NaN, 10.0f).scale(10.0f, 10.0f));
  }

  /**
   * Test {@link Matrix#scale(float, float)}.
   *
   * <ul>
   *   <li>Given TranslateInstance ten is {@link Float#NaN}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#scale(float, float)}
   */
  @Test
  @DisplayName(
      "Test scale(float, float); given TranslateInstance ten is NaN; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.scale(float, float)"})
  void testScale_givenTranslateInstanceTenIsNaN_thenThrowIllegalArgumentException() {
    // Arrange
    Matrix translateInstance = Matrix.getTranslateInstance(10.0f, Float.NaN);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> translateInstance.scale(10.0f, 10.0f));
  }

  /**
   * Test {@link Matrix#rotate(double)}.
   *
   * <ul>
   *   <li>Given {@link Matrix#Matrix()}.
   *   <li>When {@link Double#NaN}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#rotate(double)}
   */
  @Test
  @DisplayName("Test rotate(double); given Matrix(); when NaN; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.rotate(double)"})
  void testRotate_givenMatrix_whenNaN_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Matrix().rotate(Double.NaN));
  }

  /**
   * Test {@link Matrix#rotate(double)}.
   *
   * <ul>
   *   <li>Given {@link Matrix#Matrix()}.
   *   <li>When ten.
   *   <li>Then {@link Matrix#Matrix()} ShearY is {@code -0.5440211}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#rotate(double)}
   */
  @Test
  @DisplayName(
      "Test rotate(double); given Matrix(); when ten; then Matrix() ShearY is '-0.5440211'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.rotate(double)"})
  void testRotate_givenMatrix_whenTen_thenMatrixShearYIs05440211() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act
    matrix.rotate(10.0d);

    // Assert
    assertEquals(-0.5440211f, matrix.getShearY());
    assertEquals(-0.8390715f, matrix.getScaleX());
    assertEquals(-0.8390715f, matrix.getScaleY());
    assertEquals(0.5440211f, matrix.getShearX());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.8390715f, -0.5440211f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {0.5440211f, -0.8390715f, 0.0f}, values[1], 0.0f);
  }

  /**
   * Test {@link Matrix#rotate(double)}.
   *
   * <ul>
   *   <li>Given ScaleInstance one is {@link Float#NaN}.
   *   <li>When ten.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#rotate(double)}
   */
  @Test
  @DisplayName(
      "Test rotate(double); given ScaleInstance one is NaN; when ten; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Matrix.rotate(double)"})
  void testRotate_givenScaleInstanceOneIsNaN_whenTen_thenThrowIllegalArgumentException() {
    // Arrange
    Matrix scaleInstance = Matrix.getScaleInstance(1.0f, Float.NaN);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> scaleInstance.rotate(10.0d));
  }

  /**
   * Test {@link Matrix#multiply(Matrix)}.
   *
   * <ul>
   *   <li>Given {@link Matrix#Matrix()}.
   *   <li>When {@link Matrix#Matrix()}.
   *   <li>Then return {@link Matrix#Matrix()}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#multiply(Matrix)}
   */
  @Test
  @DisplayName("Test multiply(Matrix); given Matrix(); when Matrix(); then return Matrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix Matrix.multiply(Matrix)"})
  void testMultiply_givenMatrix_whenMatrix_thenReturnMatrix() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act
    Matrix actualMultiplyResult = matrix.multiply(new Matrix());

    // Assert
    assertEquals(matrix, actualMultiplyResult);
  }

  /**
   * Test {@link Matrix#multiply(Matrix)}.
   *
   * <ul>
   *   <li>Given {@link Matrix#Matrix()}.
   *   <li>When ScaleInstance ten is {@link Float#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#multiply(Matrix)}
   */
  @Test
  @DisplayName("Test multiply(Matrix); given Matrix(); when ScaleInstance ten is NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix Matrix.multiply(Matrix)"})
  void testMultiply_givenMatrix_whenScaleInstanceTenIsNaN() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Matrix().multiply(Matrix.getScaleInstance(10.0f, Float.NaN)));
  }

  /**
   * Test {@link Matrix#multiply(Matrix)}.
   *
   * <ul>
   *   <li>Given ScaleInstance {@link Float#NaN} is ten.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#multiply(Matrix)}
   */
  @Test
  @DisplayName(
      "Test multiply(Matrix); given ScaleInstance NaN is ten; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix Matrix.multiply(Matrix)"})
  void testMultiply_givenScaleInstanceNaNIsTen_thenThrowIllegalArgumentException() {
    // Arrange
    Matrix scaleInstance = Matrix.getScaleInstance(Float.NaN, 10.0f);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> scaleInstance.multiply(new Matrix()));
  }

  /**
   * Test {@link Matrix#multiply(Matrix)}.
   *
   * <ul>
   *   <li>Given ScaleInstance ten is {@link Float#NaN}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#multiply(Matrix)}
   */
  @Test
  @DisplayName(
      "Test multiply(Matrix); given ScaleInstance ten is NaN; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix Matrix.multiply(Matrix)"})
  void testMultiply_givenScaleInstanceTenIsNaN_thenThrowIllegalArgumentException() {
    // Arrange
    Matrix scaleInstance = Matrix.getScaleInstance(10.0f, Float.NaN);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> scaleInstance.multiply(new Matrix()));
  }

  /**
   * Test {@link Matrix#multiply(Matrix)}.
   *
   * <ul>
   *   <li>Given TranslateInstance {@link Float#NaN} is ten.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#multiply(Matrix)}
   */
  @Test
  @DisplayName(
      "Test multiply(Matrix); given TranslateInstance NaN is ten; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix Matrix.multiply(Matrix)"})
  void testMultiply_givenTranslateInstanceNaNIsTen_thenThrowIllegalArgumentException() {
    // Arrange
    Matrix translateInstance = Matrix.getTranslateInstance(Float.NaN, 10.0f);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> translateInstance.multiply(new Matrix()));
  }

  /**
   * Test {@link Matrix#transform(Vector)} with {@code vector}.
   *
   * <ul>
   *   <li>When {@link Vector#Vector(float, float)} with x is ten and y is ten.
   *   <li>Then return X is ten.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#transform(Vector)}
   */
  @Test
  @DisplayName(
      "Test transform(Vector) with 'vector'; when Vector(float, float) with x is ten and y is ten; then return X is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Matrix.transform(Vector)"})
  void testTransformWithVector_whenVectorWithXIsTenAndYIsTen_thenReturnXIsTen() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act
    Vector actualTransformResult = matrix.transform(new Vector(10.0f, 10.0f));

    // Assert
    assertEquals(10.0f, actualTransformResult.getX());
    assertEquals(10.0f, actualTransformResult.getY());
  }

  /**
   * Test {@link Matrix#transformPoint(float, float)}.
   *
   * <p>Method under test: {@link Matrix#transformPoint(float, float)}
   */
  @Test
  @DisplayName("Test transformPoint(float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Point2D.Float Matrix.transformPoint(float, float)"})
  void testTransformPoint() {
    // Arrange and Act
    Point2D.Float actualTransformPointResult = new Matrix().transformPoint(10.0f, 10.0f);

    // Assert
    assertEquals(10.0d, actualTransformPointResult.getX());
    assertEquals(10.0d, actualTransformPointResult.getY());
    assertEquals(10.0f, actualTransformPointResult.x);
    assertEquals(10.0f, actualTransformPointResult.y);
  }

  /**
   * Test {@link Matrix#getScaleInstance(float, float)}.
   *
   * <p>Method under test: {@link Matrix#getScaleInstance(float, float)}
   */
  @Test
  @DisplayName("Test getScaleInstance(float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix Matrix.getScaleInstance(float, float)"})
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
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 10.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {10.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Matrix#getTranslateInstance(float, float)}.
   *
   * <p>Method under test: {@link Matrix#getTranslateInstance(float, float)}
   */
  @Test
  @DisplayName("Test getTranslateInstance(float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix Matrix.getTranslateInstance(float, float)"})
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
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {10.0f, 10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link Matrix#getRotateInstance(double, float, float)}.
   *
   * <p>Method under test: {@link Matrix#getRotateInstance(double, float, float)}
   */
  @Test
  @DisplayName("Test getRotateInstance(double, float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix Matrix.getRotateInstance(double, float, float)"})
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
    assertArrayEquals(new float[] {-0.8390715f, -0.5440211f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {0.5440211f, -0.8390715f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {10.0f, 10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link Matrix#clone()}.
   *
   * <p>Method under test: {@link Matrix#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix Matrix.clone()"})
  void testClone() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act
    Matrix actualCloneResult = matrix.clone();

    // Assert
    assertEquals(matrix, actualCloneResult);
  }

  /**
   * Test {@link Matrix#getScalingFactorX()}.
   *
   * <p>Method under test: {@link Matrix#getScalingFactorX()}
   */
  @Test
  @DisplayName("Test getScalingFactorX()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Matrix.getScalingFactorX()"})
  void testGetScalingFactorX() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new Matrix().getScalingFactorX());
  }

  /**
   * Test {@link Matrix#getScalingFactorY()}.
   *
   * <p>Method under test: {@link Matrix#getScalingFactorY()}
   */
  @Test
  @DisplayName("Test getScalingFactorY()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Matrix.getScalingFactorY()"})
  void testGetScalingFactorY() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new Matrix().getScalingFactorY());
  }

  /**
   * Test {@link Matrix#getScaleX()}.
   *
   * <p>Method under test: {@link Matrix#getScaleX()}
   */
  @Test
  @DisplayName("Test getScaleX()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Matrix.getScaleX()"})
  void testGetScaleX() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new Matrix().getScaleX());
  }

  /**
   * Test {@link Matrix#getShearY()}.
   *
   * <p>Method under test: {@link Matrix#getShearY()}
   */
  @Test
  @DisplayName("Test getShearY()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Matrix.getShearY()"})
  void testGetShearY() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new Matrix().getShearY());
  }

  /**
   * Test {@link Matrix#getShearX()}.
   *
   * <p>Method under test: {@link Matrix#getShearX()}
   */
  @Test
  @DisplayName("Test getShearX()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Matrix.getShearX()"})
  void testGetShearX() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new Matrix().getShearX());
  }

  /**
   * Test {@link Matrix#getScaleY()}.
   *
   * <p>Method under test: {@link Matrix#getScaleY()}
   */
  @Test
  @DisplayName("Test getScaleY()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Matrix.getScaleY()"})
  void testGetScaleY() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new Matrix().getScaleY());
  }

  /**
   * Test {@link Matrix#getTranslateX()}.
   *
   * <p>Method under test: {@link Matrix#getTranslateX()}
   */
  @Test
  @DisplayName("Test getTranslateX()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Matrix.getTranslateX()"})
  void testGetTranslateX() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new Matrix().getTranslateX());
  }

  /**
   * Test {@link Matrix#getTranslateY()}.
   *
   * <p>Method under test: {@link Matrix#getTranslateY()}
   */
  @Test
  @DisplayName("Test getTranslateY()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Matrix.getTranslateY()"})
  void testGetTranslateY() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new Matrix().getTranslateY());
  }

  /**
   * Test {@link Matrix#toCOSArray()}.
   *
   * <p>Method under test: {@link Matrix#toCOSArray()}
   */
  @Test
  @DisplayName("Test toCOSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray Matrix.toCOSArray()"})
  void testToCOSArray() {
    // Arrange, Act and Assert
    List<? extends COSBase> toListResult = new Matrix().toCOSArray().toList();
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
   * Test {@link Matrix#toString()}.
   *
   * <p>Method under test: {@link Matrix#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Matrix.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("[1.0,0.0,0.0,1.0,0.0,0.0]", new Matrix().toString());
  }

  /**
   * Test {@link Matrix#equals(Object)}, and {@link Matrix#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Matrix#equals(Object)}
   *   <li>{@link Matrix#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Matrix.equals(Object)", "int Matrix.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Matrix matrix = new Matrix();
    Matrix matrix2 = new Matrix();

    // Act and Assert
    assertEquals(matrix, matrix2);
    assertEquals(matrix.hashCode(), matrix2.hashCode());
  }

  /**
   * Test {@link Matrix#equals(Object)}, and {@link Matrix#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Matrix#equals(Object)}
   *   <li>{@link Matrix#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Matrix.equals(Object)", "int Matrix.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Matrix matrix = new Matrix();

    // Act and Assert
    assertEquals(matrix, matrix);
    int expectedHashCodeResult = matrix.hashCode();
    assertEquals(expectedHashCodeResult, matrix.hashCode());
  }

  /**
   * Test {@link Matrix#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Matrix.equals(Object)", "int Matrix.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Matrix scaleInstance = Matrix.getScaleInstance(10.0f, 10.0f);

    // Act and Assert
    assertNotEquals(scaleInstance, new Matrix());
  }

  /**
   * Test {@link Matrix#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Matrix.equals(Object)", "int Matrix.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Matrix(), null);
  }

  /**
   * Test {@link Matrix#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Matrix#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Matrix.equals(Object)", "int Matrix.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Matrix(), "Different type to Matrix");
  }
}
