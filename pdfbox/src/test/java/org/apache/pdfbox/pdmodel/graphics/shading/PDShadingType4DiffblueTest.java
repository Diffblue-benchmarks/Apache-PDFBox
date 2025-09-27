package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Paint;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDShadingType4DiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDShadingType4#PDShadingType4(COSDictionary)}
   *   <li>{@link PDShadingType4#getShadingType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDShadingType4.<init>(COSDictionary)",
    "int PDShadingType4.getShadingType()"
  })
  void testGettersAndSetters() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    // Act
    PDShadingType4 actualPdShadingType4 = new PDShadingType4(shadingDictionary);

    // Assert
    assertEquals(4, actualPdShadingType4.getShadingType());
    assertSame(shadingDictionary, actualPdShadingType4.getCOSObject());
  }

  /**
   * Test {@link PDShadingType4#getBitsPerFlag()}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDShadingType4#getBitsPerFlag()}
   */
  @Test
  @DisplayName("Test getBitsPerFlag(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDShadingType4.getBitsPerFlag()"})
  void testGetBitsPerFlag_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDShadingType4(new COSDictionary()).getBitsPerFlag());
  }

  /**
   * Test {@link PDShadingType4#setBitsPerFlag(int)}.
   *
   * <p>Method under test: {@link PDShadingType4#setBitsPerFlag(int)}
   */
  @Test
  @DisplayName("Test setBitsPerFlag(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShadingType4.setBitsPerFlag(int)"})
  void testSetBitsPerFlag() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());

    // Act
    pdShadingType4.setBitsPerFlag(1);

    // Assert
    COSDictionary cOSObject = pdShadingType4.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdShadingType4.getBitsPerFlag());
  }

  /**
   * Test {@link PDShadingType4#setBitsPerFlag(int)}.
   *
   * <p>Method under test: {@link PDShadingType4#setBitsPerFlag(int)}
   */
  @Test
  @DisplayName("Test setBitsPerFlag(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShadingType4.setBitsPerFlag(int)"})
  void testSetBitsPerFlag2() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());

    // Act
    pdShadingType4.setBitsPerFlag(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdShadingType4.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdShadingType4.getBitsPerFlag());
  }

  /**
   * Test {@link PDShadingType4#toPaint(Matrix)}.
   *
   * <p>Method under test: {@link PDShadingType4#toPaint(Matrix)}
   */
  @Test
  @DisplayName("Test toPaint(Matrix)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paint PDShadingType4.toPaint(Matrix)"})
  void testToPaint() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());

    // Act
    Paint actualToPaintResult = pdShadingType4.toPaint(new Matrix());

    // Assert
    assertTrue(actualToPaintResult instanceof Type4ShadingPaint);
    assertEquals(0, actualToPaintResult.getTransparency());
    assertSame(pdShadingType4, ((Type4ShadingPaint) actualToPaintResult).getShading());
  }

  /**
   * Test {@link PDShadingType4#toPaint(Matrix)}.
   *
   * <p>Method under test: {@link PDShadingType4#toPaint(Matrix)}
   */
  @Test
  @DisplayName("Test toPaint(Matrix)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paint PDShadingType4.toPaint(Matrix)"})
  void testToPaint2() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary(new COSDictionary()));

    // Act
    Paint actualToPaintResult = pdShadingType4.toPaint(new Matrix());

    // Assert
    assertTrue(actualToPaintResult instanceof Type4ShadingPaint);
    assertEquals(0, actualToPaintResult.getTransparency());
    assertSame(pdShadingType4, ((Type4ShadingPaint) actualToPaintResult).getShading());
  }

  /**
   * Test {@link PDShadingType4#toPaint(Matrix)}.
   *
   * <ul>
   *   <li>Then return {@link Type6ShadingPaint}.
   * </ul>
   *
   * <p>Method under test: {@link PDShadingType4#toPaint(Matrix)}
   */
  @Test
  @DisplayName("Test toPaint(Matrix); then return Type6ShadingPaint")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paint PDShadingType4.toPaint(Matrix)"})
  void testToPaint_thenReturnType6ShadingPaint() {
    // Arrange
    PDShadingType6 pdShadingType6 = new PDShadingType6(new COSDictionary());

    // Act
    Paint actualToPaintResult = pdShadingType6.toPaint(new Matrix());

    // Assert
    assertTrue(actualToPaintResult instanceof Type6ShadingPaint);
    assertEquals(0, actualToPaintResult.getTransparency());
    PDShadingType6 shading = ((Type6ShadingPaint) actualToPaintResult).getShading();
    assertEquals(6, shading.getShadingType());
    assertSame(pdShadingType6, shading);
  }

  /**
   * Test {@link PDShadingType4#collectTriangles(AffineTransform, Matrix)}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType4#PDShadingType4(COSDictionary)} with shadingDictionary is
   *       {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDShadingType4#collectTriangles(AffineTransform, Matrix)}
   */
  @Test
  @DisplayName(
      "Test collectTriangles(AffineTransform, Matrix); given PDShadingType4(COSDictionary) with shadingDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List PDShadingType4.collectTriangles(AffineTransform, Matrix)"})
  void testCollectTriangles_givenPDShadingType4WithShadingDictionaryIsCOSDictionary()
      throws IOException {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertTrue(pdShadingType4.collectTriangles(xform, new Matrix()).isEmpty());
  }

  /**
   * Test {@link PDShadingType4#collectTriangles(AffineTransform, Matrix)}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType4#PDShadingType4(COSDictionary)} with shadingDictionary is
   *       {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDShadingType4#collectTriangles(AffineTransform, Matrix)}
   */
  @Test
  @DisplayName(
      "Test collectTriangles(AffineTransform, Matrix); given PDShadingType4(COSDictionary) with shadingDictionary is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List PDShadingType4.collectTriangles(AffineTransform, Matrix)"})
  void testCollectTriangles_givenPDShadingType4WithShadingDictionaryIsCOSStream()
      throws IOException {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSStream());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertTrue(pdShadingType4.collectTriangles(xform, new Matrix()).isEmpty());
  }
}
