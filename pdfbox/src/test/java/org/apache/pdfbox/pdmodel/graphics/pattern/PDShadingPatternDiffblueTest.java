package org.apache.pdfbox.pdmodel.graphics.pattern;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShading;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType1;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDShadingPatternDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDShadingPattern#PDShadingPattern(COSDictionary)}
   *   <li>{@link PDShadingPattern#getPatternType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act
    PDShadingPattern actualPdShadingPattern = new PDShadingPattern(resourceDictionary);

    // Assert
    assertEquals(2, actualPdShadingPattern.getPatternType());
    assertSame(resourceDictionary, actualPdShadingPattern.getCOSObject());
  }

  /**
   * Test {@link PDShadingPattern#PDShadingPattern()}.
   * <p>
   * Method under test: {@link PDShadingPattern#PDShadingPattern()}
   */
  @Test
  @DisplayName("Test new PDShadingPattern()")
  void testNewPDShadingPattern() throws IOException {
    // Arrange and Act
    PDShadingPattern actualPdShadingPattern = new PDShadingPattern();

    // Assert
    assertEquals("Pattern", actualPdShadingPattern.getType());
    COSDictionary cOSObject = actualPdShadingPattern.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdShadingPattern.getShading());
    assertNull(actualPdShadingPattern.getExtendedGraphicsState());
    Matrix matrix = actualPdShadingPattern.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(2, actualPdShadingPattern.getPatternType());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDShadingPattern#getExtendedGraphicsState()}.
   * <p>
   * Method under test: {@link PDShadingPattern#getExtendedGraphicsState()}
   */
  @Test
  @DisplayName("Test getExtendedGraphicsState()")
  void testGetExtendedGraphicsState() {
    // Arrange, Act and Assert
    assertNull((new PDShadingPattern(new COSDictionary())).getExtendedGraphicsState());
  }

  /**
   * Test {@link PDShadingPattern#getExtendedGraphicsState()}.
   * <ul>
   *   <li>Given {@link PDShadingPattern#PDShadingPattern()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingPattern#getExtendedGraphicsState()}
   */
  @Test
  @DisplayName("Test getExtendedGraphicsState(); given PDShadingPattern(); then return 'null'")
  void testGetExtendedGraphicsState_givenPDShadingPattern_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDShadingPattern()).getExtendedGraphicsState());
  }

  /**
   * Test {@link PDShadingPattern#getExtendedGraphicsState()}.
   * <ul>
   *   <li>Then return
   * {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingPattern#getExtendedGraphicsState()}
   */
  @Test
  @DisplayName("Test getExtendedGraphicsState(); then return PDExtendedGraphicsState()")
  void testGetExtendedGraphicsState_thenReturnPDExtendedGraphicsState() {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();
    PDExtendedGraphicsState extendedGraphicsState = new PDExtendedGraphicsState();
    pdShadingPattern.setExtendedGraphicsState(extendedGraphicsState);

    // Act and Assert
    assertSame(extendedGraphicsState, pdShadingPattern.getExtendedGraphicsState());
  }

  /**
   * Test
   * {@link PDShadingPattern#setExtendedGraphicsState(PDExtendedGraphicsState)}.
   * <ul>
   *   <li>Then {@link PDShadingPattern#PDShadingPattern()} COSObject Values size is
   * three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDShadingPattern#setExtendedGraphicsState(PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName("Test setExtendedGraphicsState(PDExtendedGraphicsState); then PDShadingPattern() COSObject Values size is three")
  void testSetExtendedGraphicsState_thenPDShadingPatternCOSObjectValuesSizeIsThree() {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();
    PDExtendedGraphicsState extendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdShadingPattern.setExtendedGraphicsState(extendedGraphicsState);

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(extendedGraphicsState, pdShadingPattern.getExtendedGraphicsState());
  }

  /**
   * Test
   * {@link PDShadingPattern#setExtendedGraphicsState(PDExtendedGraphicsState)}.
   * <ul>
   *   <li>Then {@link PDShadingPattern#PDShadingPattern()} ExtendedGraphicsState is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDShadingPattern#setExtendedGraphicsState(PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName("Test setExtendedGraphicsState(PDExtendedGraphicsState); then PDShadingPattern() ExtendedGraphicsState is 'null'")
  void testSetExtendedGraphicsState_thenPDShadingPatternExtendedGraphicsStateIsNull() {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();

    // Act
    pdShadingPattern.setExtendedGraphicsState(null);

    // Assert
    assertNull(pdShadingPattern.getExtendedGraphicsState());
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDShadingPattern#getShading()}.
   * <ul>
   *   <li>Given {@link PDShadingPattern#PDShadingPattern(COSDictionary)} with
   * resourceDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingPattern#getShading()}
   */
  @Test
  @DisplayName("Test getShading(); given PDShadingPattern(COSDictionary) with resourceDictionary is COSDictionary()")
  void testGetShading_givenPDShadingPatternWithResourceDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDShadingPattern(new COSDictionary())).getShading());
  }

  /**
   * Test {@link PDShadingPattern#getShading()}.
   * <ul>
   *   <li>Given {@link PDShadingPattern#PDShadingPattern()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingPattern#getShading()}
   */
  @Test
  @DisplayName("Test getShading(); given PDShadingPattern(); then return 'null'")
  void testGetShading_givenPDShadingPattern_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDShadingPattern()).getShading());
  }

  /**
   * Test {@link PDShadingPattern#getShading()}.
   * <ul>
   *   <li>Then return {@link PDShadingType1#PDShadingType1(COSDictionary)} with
   * shadingDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingPattern#getShading()}
   */
  @Test
  @DisplayName("Test getShading(); then return PDShadingType1(COSDictionary) with shadingDictionary is COSDictionary()")
  void testGetShading_thenReturnPDShadingType1WithShadingDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();
    PDShadingType1 shadingResources = new PDShadingType1(new COSDictionary());
    pdShadingPattern.setShading(shadingResources);

    // Act and Assert
    assertSame(shadingResources, pdShadingPattern.getShading());
  }

  /**
   * Test {@link PDShadingPattern#setShading(PDShading)}.
   * <p>
   * Method under test: {@link PDShadingPattern#setShading(PDShading)}
   */
  @Test
  @DisplayName("Test setShading(PDShading)")
  void testSetShading() throws IOException {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();
    PDShadingType1 shadingResources = new PDShadingType1(null);

    // Act
    pdShadingPattern.setShading(shadingResources);

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(shadingResources, pdShadingPattern.getShading());
  }

  /**
   * Test {@link PDShadingPattern#setShading(PDShading)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingPattern#setShading(PDShading)}
   */
  @Test
  @DisplayName("Test setShading(PDShading); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetShading_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();

    COSDictionary shadingDictionary = new COSDictionary();
    shadingDictionary.setKey(new COSObjectKey(1L, 1));
    PDShadingType1 shadingResources = new PDShadingType1(shadingDictionary);

    // Act
    pdShadingPattern.setShading(shadingResources);

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(shadingResources, pdShadingPattern.getShading());
  }

  /**
   * Test {@link PDShadingPattern#setShading(PDShading)}.
   * <ul>
   *   <li>Given {@link PDShadingPattern#PDShadingPattern()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDShadingPattern#PDShadingPattern()} Shading is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingPattern#setShading(PDShading)}
   */
  @Test
  @DisplayName("Test setShading(PDShading); given PDShadingPattern(); when 'null'; then PDShadingPattern() Shading is 'null'")
  void testSetShading_givenPDShadingPattern_whenNull_thenPDShadingPatternShadingIsNull() throws IOException {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();

    // Act
    pdShadingPattern.setShading(null);

    // Assert
    assertNull(pdShadingPattern.getShading());
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDShadingPattern#setShading(PDShading)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingPattern#setShading(PDShading)}
   */
  @Test
  @DisplayName("Test setShading(PDShading); given 'true'; when COSDictionary() Direct is 'true'")
  void testSetShading_givenTrue_whenCOSDictionaryDirectIsTrue() throws IOException {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();

    COSDictionary shadingDictionary = new COSDictionary();
    shadingDictionary.setDirect(true);
    PDShadingType1 shadingResources = new PDShadingType1(shadingDictionary);

    // Act
    pdShadingPattern.setShading(shadingResources);

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(shadingResources, pdShadingPattern.getShading());
  }

  /**
   * Test {@link PDShadingPattern#setShading(PDShading)}.
   * <ul>
   *   <li>Then {@link PDShadingPattern#PDShadingPattern()} COSObject Values size is
   * three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShadingPattern#setShading(PDShading)}
   */
  @Test
  @DisplayName("Test setShading(PDShading); then PDShadingPattern() COSObject Values size is three")
  void testSetShading_thenPDShadingPatternCOSObjectValuesSizeIsThree() throws IOException {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();
    PDShadingType1 shadingResources = new PDShadingType1(new COSDictionary());

    // Act
    pdShadingPattern.setShading(shadingResources);

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(shadingResources, pdShadingPattern.getShading());
  }
}
