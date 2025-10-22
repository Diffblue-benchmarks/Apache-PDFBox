package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDMeshBasedShadingTypeDiffblueTest {
  /**
   * Test {@link PDMeshBasedShadingType#collectPatches(AffineTransform, Matrix, int)}.
   * <ul>
   *   <li>Given {@link PDShadingType6#PDShadingType6(COSDictionary)} with shadingDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMeshBasedShadingType#collectPatches(AffineTransform, Matrix, int)}
   */
  @Test
  @DisplayName("Test collectPatches(AffineTransform, Matrix, int); given PDShadingType6(COSDictionary) with shadingDictionary is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List PDMeshBasedShadingType.collectPatches(AffineTransform, Matrix, int)"})
  void testCollectPatches_givenPDShadingType6WithShadingDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    PDShadingType6 pdShadingType6 = new PDShadingType6(new COSDictionary());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertTrue(pdShadingType6.collectPatches(xform, new Matrix(), 1).isEmpty());
  }

  /**
   * Test {@link PDMeshBasedShadingType#collectPatches(AffineTransform, Matrix, int)}.
   * <ul>
   *   <li>Given {@link PDShadingType6#PDShadingType6(COSDictionary)} with shadingDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMeshBasedShadingType#collectPatches(AffineTransform, Matrix, int)}
   */
  @Test
  @DisplayName("Test collectPatches(AffineTransform, Matrix, int); given PDShadingType6(COSDictionary) with shadingDictionary is COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List PDMeshBasedShadingType.collectPatches(AffineTransform, Matrix, int)"})
  void testCollectPatches_givenPDShadingType6WithShadingDictionaryIsCOSStream() throws IOException {
    // Arrange
    PDShadingType6 pdShadingType6 = new PDShadingType6(new COSStream());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertTrue(pdShadingType6.collectPatches(xform, new Matrix(), 1).isEmpty());
  }

  /**
   * Test {@link PDMeshBasedShadingType#getBounds(AffineTransform, Matrix, int)} with {@code AffineTransform}, {@code Matrix}, {@code int}.
   * <p>
   * Method under test: {@link PDMeshBasedShadingType#getBounds(AffineTransform, Matrix, int)}
   */
  @Test
  @DisplayName("Test getBounds(AffineTransform, Matrix, int) with 'AffineTransform', 'Matrix', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.awt.geom.Rectangle2D PDMeshBasedShadingType.getBounds(AffineTransform, Matrix, int)"})
  void testGetBoundsWithAffineTransformMatrixInt() throws IOException {
    // Arrange
    PDShadingType6 pdShadingType6 = new PDShadingType6(new COSDictionary());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertNull(pdShadingType6.getBounds(xform, new Matrix(), 1));
  }

  /**
   * Test {@link PDMeshBasedShadingType#getBounds(AffineTransform, Matrix, int)} with {@code AffineTransform}, {@code Matrix}, {@code int}.
   * <p>
   * Method under test: {@link PDMeshBasedShadingType#getBounds(AffineTransform, Matrix, int)}
   */
  @Test
  @DisplayName("Test getBounds(AffineTransform, Matrix, int) with 'AffineTransform', 'Matrix', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.awt.geom.Rectangle2D PDMeshBasedShadingType.getBounds(AffineTransform, Matrix, int)"})
  void testGetBoundsWithAffineTransformMatrixInt2() throws IOException {
    // Arrange
    PDShadingType6 pdShadingType6 = new PDShadingType6(new COSStream());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertNull(pdShadingType6.getBounds(xform, new Matrix(), 1));
  }
}
