package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Paint;
import java.awt.geom.AffineTransform;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDShadingType1DiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDShadingType1#PDShadingType1(COSDictionary)}
   *   <li>{@link PDShadingType1#getShadingType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDShadingType1.<init>(COSDictionary)", "int PDShadingType1.getShadingType()"})
  void testGettersAndSetters() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    // Act
    PDShadingType1 actualPdShadingType1 = new PDShadingType1(shadingDictionary);

    // Assert
    assertEquals(1, actualPdShadingType1.getShadingType());
    assertSame(shadingDictionary, actualPdShadingType1.getCOSObject());
  }

  /**
   * Test {@link PDShadingType1#getMatrix()}.
   * <ul>
   *   <li>Then return ShearX is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType1#getMatrix()}
   */
  @Test
  @DisplayName("Test getMatrix(); then return ShearX is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Matrix PDShadingType1.getMatrix()"})
  void testGetMatrix_thenReturnShearXIsZero() {
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
   * Test {@link PDShadingType1#setMatrix(AffineTransform)}.
   * <p>
   * Method under test: {@link PDShadingType1#setMatrix(AffineTransform)}
   */
  @Test
  @DisplayName("Test setMatrix(AffineTransform)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDShadingType1.setMatrix(AffineTransform)"})
  void testSetMatrix() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    // Act
    pdShadingType1.setMatrix(new AffineTransform());

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDShadingType1#getDomain()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType1#getDomain()}
   */
  @Test
  @DisplayName("Test getDomain(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDShadingType1.getDomain()"})
  void testGetDomain_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType1(new COSDictionary())).getDomain());
  }

  /**
   * Test {@link PDShadingType1#getDomain()}.
   * <ul>
   *   <li>Then return toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType1#getDomain()}
   */
  @Test
  @DisplayName("Test getDomain(); then return toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDShadingType1.getDomain()"})
  void testGetDomain_thenReturnToListEmpty() {
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
   * Test {@link PDShadingType1#setDomain(COSArray)}.
   * <p>
   * Method under test: {@link PDShadingType1#setDomain(COSArray)}
   */
  @Test
  @DisplayName("Test setDomain(COSArray)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDShadingType1.setDomain(COSArray)"})
  void testSetDomain() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());
    COSArray newDomain = new COSArray();

    // Act
    pdShadingType1.setDomain(newDomain);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(newDomain, pdShadingType1.getDomain());
  }

  /**
   * Test {@link PDShadingType1#setDomain(COSArray)}.
   * <p>
   * Method under test: {@link PDShadingType1#setDomain(COSArray)}
   */
  @Test
  @DisplayName("Test setDomain(COSArray)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDShadingType1.setDomain(COSArray)"})
  void testSetDomain2() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    // Act
    pdShadingType1.setDomain(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDShadingType1#toPaint(Matrix)}.
   * <p>
   * Method under test: {@link PDShadingType1#toPaint(Matrix)}
   */
  @Test
  @DisplayName("Test toPaint(Matrix)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Paint PDShadingType1.toPaint(Matrix)"})
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
   * Test {@link PDShadingType1#toPaint(Matrix)}.
   * <p>
   * Method under test: {@link PDShadingType1#toPaint(Matrix)}
   */
  @Test
  @DisplayName("Test toPaint(Matrix)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Paint PDShadingType1.toPaint(Matrix)"})
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
}
