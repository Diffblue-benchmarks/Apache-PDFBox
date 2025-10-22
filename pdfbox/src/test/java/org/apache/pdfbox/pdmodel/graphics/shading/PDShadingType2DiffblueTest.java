package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Paint;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDShadingType2DiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDShadingType2#PDShadingType2(COSDictionary)}
   *   <li>{@link PDShadingType2#getShadingType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDShadingType2.<init>(COSDictionary)", "int PDShadingType2.getShadingType()"})
  void testGettersAndSetters() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    // Act
    PDShadingType2 actualPdShadingType2 = new PDShadingType2(shadingDictionary);

    // Assert
    assertEquals(2, actualPdShadingType2.getShadingType());
    assertSame(shadingDictionary, actualPdShadingType2.getCOSObject());
  }

  /**
   * Test {@link PDShadingType2#getExtend()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType2#getExtend()}
   */
  @Test
  @DisplayName("Test getExtend(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDShadingType2.getExtend()"})
  void testGetExtend_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType2(new COSDictionary())).getExtend());
  }

  /**
   * Test {@link PDShadingType2#getExtend()}.
   * <ul>
   *   <li>Then return toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType2#getExtend()}
   */
  @Test
  @DisplayName("Test getExtend(); then return toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDShadingType2.getExtend()"})
  void testGetExtend_thenReturnToListEmpty() {
    // Arrange
    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());
    COSArray newExtend = new COSArray();
    pdShadingType2.setExtend(newExtend);

    // Act
    COSArray actualExtend = pdShadingType2.getExtend();

    // Assert
    assertTrue(actualExtend.toList().isEmpty());
    assertSame(newExtend, actualExtend);
  }

  /**
   * Test {@link PDShadingType2#setExtend(COSArray)}.
   * <p>
   * Method under test: {@link PDShadingType2#setExtend(COSArray)}
   */
  @Test
  @DisplayName("Test setExtend(COSArray)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDShadingType2.setExtend(COSArray)"})
  void testSetExtend() {
    // Arrange
    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());
    COSArray newExtend = new COSArray();

    // Act
    pdShadingType2.setExtend(newExtend);

    // Assert
    COSDictionary cOSObject = pdShadingType2.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(newExtend, pdShadingType2.getExtend());
  }

  /**
   * Test {@link PDShadingType2#setExtend(COSArray)}.
   * <p>
   * Method under test: {@link PDShadingType2#setExtend(COSArray)}
   */
  @Test
  @DisplayName("Test setExtend(COSArray)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDShadingType2.setExtend(COSArray)"})
  void testSetExtend2() {
    // Arrange
    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());

    // Act
    pdShadingType2.setExtend(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdShadingType2.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDShadingType2#getDomain()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType2#getDomain()}
   */
  @Test
  @DisplayName("Test getDomain(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDShadingType2.getDomain()"})
  void testGetDomain_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType2(new COSDictionary())).getDomain());
  }

  /**
   * Test {@link PDShadingType2#getDomain()}.
   * <ul>
   *   <li>Then return toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType2#getDomain()}
   */
  @Test
  @DisplayName("Test getDomain(); then return toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDShadingType2.getDomain()"})
  void testGetDomain_thenReturnToListEmpty() {
    // Arrange
    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());
    COSArray newDomain = new COSArray();
    pdShadingType2.setDomain(newDomain);

    // Act
    COSArray actualDomain = pdShadingType2.getDomain();

    // Assert
    assertTrue(actualDomain.toList().isEmpty());
    assertSame(newDomain, actualDomain);
  }

  /**
   * Test {@link PDShadingType2#setDomain(COSArray)}.
   * <p>
   * Method under test: {@link PDShadingType2#setDomain(COSArray)}
   */
  @Test
  @DisplayName("Test setDomain(COSArray)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDShadingType2.setDomain(COSArray)"})
  void testSetDomain() {
    // Arrange
    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());
    COSArray newDomain = new COSArray();

    // Act
    pdShadingType2.setDomain(newDomain);

    // Assert
    COSDictionary cOSObject = pdShadingType2.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(newDomain, pdShadingType2.getDomain());
  }

  /**
   * Test {@link PDShadingType2#setDomain(COSArray)}.
   * <p>
   * Method under test: {@link PDShadingType2#setDomain(COSArray)}
   */
  @Test
  @DisplayName("Test setDomain(COSArray)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDShadingType2.setDomain(COSArray)"})
  void testSetDomain2() {
    // Arrange
    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());

    // Act
    pdShadingType2.setDomain(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdShadingType2.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDShadingType2#getCoords()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType2#getCoords()}
   */
  @Test
  @DisplayName("Test getCoords(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDShadingType2.getCoords()"})
  void testGetCoords_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType2(new COSDictionary())).getCoords());
  }

  /**
   * Test {@link PDShadingType2#getCoords()}.
   * <ul>
   *   <li>Then return toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType2#getCoords()}
   */
  @Test
  @DisplayName("Test getCoords(); then return toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDShadingType2.getCoords()"})
  void testGetCoords_thenReturnToListEmpty() {
    // Arrange
    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());
    COSArray newCoords = new COSArray();
    pdShadingType2.setCoords(newCoords);

    // Act
    COSArray actualCoords = pdShadingType2.getCoords();

    // Assert
    assertTrue(actualCoords.toList().isEmpty());
    assertSame(newCoords, actualCoords);
  }

  /**
   * Test {@link PDShadingType2#setCoords(COSArray)}.
   * <p>
   * Method under test: {@link PDShadingType2#setCoords(COSArray)}
   */
  @Test
  @DisplayName("Test setCoords(COSArray)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDShadingType2.setCoords(COSArray)"})
  void testSetCoords() {
    // Arrange
    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());
    COSArray newCoords = new COSArray();

    // Act
    pdShadingType2.setCoords(newCoords);

    // Assert
    COSDictionary cOSObject = pdShadingType2.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(newCoords, pdShadingType2.getCoords());
  }

  /**
   * Test {@link PDShadingType2#setCoords(COSArray)}.
   * <p>
   * Method under test: {@link PDShadingType2#setCoords(COSArray)}
   */
  @Test
  @DisplayName("Test setCoords(COSArray)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDShadingType2.setCoords(COSArray)"})
  void testSetCoords2() {
    // Arrange
    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());

    // Act
    pdShadingType2.setCoords(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdShadingType2.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDShadingType2#toPaint(Matrix)}.
   * <ul>
   *   <li>Then return {@link AxialShadingPaint}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType2#toPaint(Matrix)}
   */
  @Test
  @DisplayName("Test toPaint(Matrix); then return AxialShadingPaint")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Paint PDShadingType2.toPaint(Matrix)"})
  void testToPaint_thenReturnAxialShadingPaint() {
    // Arrange
    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());

    // Act
    Paint actualToPaintResult = pdShadingType2.toPaint(new Matrix());

    // Assert
    assertTrue(actualToPaintResult instanceof AxialShadingPaint);
    assertEquals(0, actualToPaintResult.getTransparency());
    PDShadingType2 shading = ((AxialShadingPaint) actualToPaintResult).getShading();
    assertEquals(2, shading.getShadingType());
    assertSame(pdShadingType2, shading);
  }

  /**
   * Test {@link PDShadingType2#toPaint(Matrix)}.
   * <ul>
   *   <li>Then return {@link RadialShadingPaint}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType2#toPaint(Matrix)}
   */
  @Test
  @DisplayName("Test toPaint(Matrix); then return RadialShadingPaint")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Paint PDShadingType2.toPaint(Matrix)"})
  void testToPaint_thenReturnRadialShadingPaint() {
    // Arrange
    PDShadingType3 pdShadingType3 = new PDShadingType3(new COSDictionary());

    // Act
    Paint actualToPaintResult = pdShadingType3.toPaint(new Matrix());

    // Assert
    assertTrue(actualToPaintResult instanceof RadialShadingPaint);
    assertEquals(0, actualToPaintResult.getTransparency());
    PDShadingType3 shading = ((RadialShadingPaint) actualToPaintResult).getShading();
    assertEquals(3, shading.getShadingType());
    assertSame(pdShadingType3, shading);
  }
}
