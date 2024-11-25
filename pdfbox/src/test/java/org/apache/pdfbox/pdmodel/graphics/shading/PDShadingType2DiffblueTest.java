package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Paint;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
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
   *   <li>Given {@link PDShadingType2#PDShadingType2(COSDictionary)} with
   * shadingDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType2#getExtend()}
   */
  @Test
  @DisplayName("Test getExtend(); given PDShadingType2(COSDictionary) with shadingDictionary is COSDictionary()")
  void testGetExtend_givenPDShadingType2WithShadingDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType2(new COSDictionary())).getExtend());
  }

  /**
   * Test {@link PDShadingType2#getExtend()}.
   * <ul>
   *   <li>Given {@link PDShadingType2#PDShadingType2(COSDictionary)} with
   * shadingDictionary is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType2#getExtend()}
   */
  @Test
  @DisplayName("Test getExtend(); given PDShadingType2(COSDictionary) with shadingDictionary is COSStream(); then return 'null'")
  void testGetExtend_givenPDShadingType2WithShadingDictionaryIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType2(new COSStream())).getExtend());
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
   * <ul>
   *   <li>Then {@link PDShadingType2#PDShadingType2(COSDictionary)} with
   * shadingDictionary is {@link COSDictionary#COSDictionary()} Extend is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType2#setExtend(COSArray)}
   */
  @Test
  @DisplayName("Test setExtend(COSArray); then PDShadingType2(COSDictionary) with shadingDictionary is COSDictionary() Extend is 'null'")
  void testSetExtend_thenPDShadingType2WithShadingDictionaryIsCOSDictionaryExtendIsNull() {
    // Arrange
    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());

    // Act
    pdShadingType2.setExtend(null);

    // Assert
    assertNull(pdShadingType2.getExtend());
    COSDictionary cOSObject = pdShadingType2.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDShadingType2#getDomain()}.
   * <ul>
   *   <li>Given {@link PDShadingType2#PDShadingType2(COSDictionary)} with
   * shadingDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType2#getDomain()}
   */
  @Test
  @DisplayName("Test getDomain(); given PDShadingType2(COSDictionary) with shadingDictionary is COSDictionary()")
  void testGetDomain_givenPDShadingType2WithShadingDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType2(new COSDictionary())).getDomain());
  }

  /**
   * Test {@link PDShadingType2#getDomain()}.
   * <ul>
   *   <li>Given {@link PDShadingType2#PDShadingType2(COSDictionary)} with
   * shadingDictionary is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType2#getDomain()}
   */
  @Test
  @DisplayName("Test getDomain(); given PDShadingType2(COSDictionary) with shadingDictionary is COSStream(); then return 'null'")
  void testGetDomain_givenPDShadingType2WithShadingDictionaryIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType2(new COSStream())).getDomain());
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
   * <ul>
   *   <li>Then {@link PDShadingType2#PDShadingType2(COSDictionary)} with
   * shadingDictionary is {@link COSDictionary#COSDictionary()} Domain is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType2#setDomain(COSArray)}
   */
  @Test
  @DisplayName("Test setDomain(COSArray); then PDShadingType2(COSDictionary) with shadingDictionary is COSDictionary() Domain is 'null'")
  void testSetDomain_thenPDShadingType2WithShadingDictionaryIsCOSDictionaryDomainIsNull() {
    // Arrange
    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());

    // Act
    pdShadingType2.setDomain(null);

    // Assert
    assertNull(pdShadingType2.getDomain());
    COSDictionary cOSObject = pdShadingType2.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDShadingType2#getCoords()}.
   * <ul>
   *   <li>Given {@link PDShadingType2#PDShadingType2(COSDictionary)} with
   * shadingDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType2#getCoords()}
   */
  @Test
  @DisplayName("Test getCoords(); given PDShadingType2(COSDictionary) with shadingDictionary is COSDictionary()")
  void testGetCoords_givenPDShadingType2WithShadingDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType2(new COSDictionary())).getCoords());
  }

  /**
   * Test {@link PDShadingType2#getCoords()}.
   * <ul>
   *   <li>Given {@link PDShadingType2#PDShadingType2(COSDictionary)} with
   * shadingDictionary is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType2#getCoords()}
   */
  @Test
  @DisplayName("Test getCoords(); given PDShadingType2(COSDictionary) with shadingDictionary is COSStream(); then return 'null'")
  void testGetCoords_givenPDShadingType2WithShadingDictionaryIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType2(new COSStream())).getCoords());
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
   * <ul>
   *   <li>Then {@link PDShadingType2#PDShadingType2(COSDictionary)} with
   * shadingDictionary is {@link COSDictionary#COSDictionary()} Coords is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingType2#setCoords(COSArray)}
   */
  @Test
  @DisplayName("Test setCoords(COSArray); then PDShadingType2(COSDictionary) with shadingDictionary is COSDictionary() Coords is 'null'")
  void testSetCoords_thenPDShadingType2WithShadingDictionaryIsCOSDictionaryCoordsIsNull() {
    // Arrange
    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());

    // Act
    pdShadingType2.setCoords(null);

    // Assert
    assertNull(pdShadingType2.getCoords());
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
