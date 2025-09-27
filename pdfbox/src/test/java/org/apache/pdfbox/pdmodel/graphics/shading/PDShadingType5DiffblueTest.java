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

class PDShadingType5DiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDShadingType5#PDShadingType5(COSDictionary)}
   *   <li>{@link PDShadingType5#getShadingType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDShadingType5.<init>(COSDictionary)",
    "int PDShadingType5.getShadingType()"
  })
  void testGettersAndSetters() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    // Act
    PDShadingType5 actualPdShadingType5 = new PDShadingType5(shadingDictionary);

    // Assert
    assertEquals(5, actualPdShadingType5.getShadingType());
    assertSame(shadingDictionary, actualPdShadingType5.getCOSObject());
  }

  /**
   * Test {@link PDShadingType5#getVerticesPerRow()}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDShadingType5#getVerticesPerRow()}
   */
  @Test
  @DisplayName("Test getVerticesPerRow(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDShadingType5.getVerticesPerRow()"})
  void testGetVerticesPerRow_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDShadingType5(new COSDictionary()).getVerticesPerRow());
  }

  /**
   * Test {@link PDShadingType5#setVerticesPerRow(int)}.
   *
   * <p>Method under test: {@link PDShadingType5#setVerticesPerRow(int)}
   */
  @Test
  @DisplayName("Test setVerticesPerRow(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShadingType5.setVerticesPerRow(int)"})
  void testSetVerticesPerRow() {
    // Arrange
    PDShadingType5 pdShadingType5 = new PDShadingType5(new COSDictionary());

    // Act
    pdShadingType5.setVerticesPerRow(1);

    // Assert
    COSDictionary cOSObject = pdShadingType5.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdShadingType5.getVerticesPerRow());
  }

  /**
   * Test {@link PDShadingType5#setVerticesPerRow(int)}.
   *
   * <p>Method under test: {@link PDShadingType5#setVerticesPerRow(int)}
   */
  @Test
  @DisplayName("Test setVerticesPerRow(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShadingType5.setVerticesPerRow(int)"})
  void testSetVerticesPerRow2() {
    // Arrange
    PDShadingType5 pdShadingType5 = new PDShadingType5(new COSDictionary());

    // Act
    pdShadingType5.setVerticesPerRow(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdShadingType5.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdShadingType5.getVerticesPerRow());
  }

  /**
   * Test {@link PDShadingType5#toPaint(Matrix)}.
   *
   * <p>Method under test: {@link PDShadingType5#toPaint(Matrix)}
   */
  @Test
  @DisplayName("Test toPaint(Matrix)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paint PDShadingType5.toPaint(Matrix)"})
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
   * Test {@link PDShadingType5#toPaint(Matrix)}.
   *
   * <p>Method under test: {@link PDShadingType5#toPaint(Matrix)}
   */
  @Test
  @DisplayName("Test toPaint(Matrix)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paint PDShadingType5.toPaint(Matrix)"})
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
   * Test {@link PDShadingType5#collectTriangles(AffineTransform, Matrix)}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType5#PDShadingType5(COSDictionary)} with shadingDictionary is
   *       {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDShadingType5#collectTriangles(AffineTransform, Matrix)}
   */
  @Test
  @DisplayName(
      "Test collectTriangles(AffineTransform, Matrix); given PDShadingType5(COSDictionary) with shadingDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List PDShadingType5.collectTriangles(AffineTransform, Matrix)"})
  void testCollectTriangles_givenPDShadingType5WithShadingDictionaryIsCOSDictionary()
      throws IOException {
    // Arrange
    PDShadingType5 pdShadingType5 = new PDShadingType5(new COSDictionary());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertTrue(pdShadingType5.collectTriangles(xform, new Matrix()).isEmpty());
  }

  /**
   * Test {@link PDShadingType5#collectTriangles(AffineTransform, Matrix)}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType5#PDShadingType5(COSDictionary)} with shadingDictionary is
   *       {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDShadingType5#collectTriangles(AffineTransform, Matrix)}
   */
  @Test
  @DisplayName(
      "Test collectTriangles(AffineTransform, Matrix); given PDShadingType5(COSDictionary) with shadingDictionary is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List PDShadingType5.collectTriangles(AffineTransform, Matrix)"})
  void testCollectTriangles_givenPDShadingType5WithShadingDictionaryIsCOSStream()
      throws IOException {
    // Arrange
    PDShadingType5 pdShadingType5 = new PDShadingType5(new COSStream());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertTrue(pdShadingType5.collectTriangles(xform, new Matrix()).isEmpty());
  }
}
